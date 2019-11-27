/*
 *  Copyright © 2019 Cask Data, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package io.cdap.plugin.zuora.etl;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import io.cdap.cdap.api.artifact.ArtifactSummary;
import io.cdap.cdap.api.data.format.StructuredRecord;
import io.cdap.cdap.api.dataset.table.Table;
import io.cdap.cdap.datapipeline.DataPipelineApp;
import io.cdap.cdap.datapipeline.SmartWorkflow;
import io.cdap.cdap.etl.api.batch.BatchSource;
import io.cdap.cdap.etl.mock.batch.MockSink;
import io.cdap.cdap.etl.mock.test.HydratorTestBase;
import io.cdap.cdap.etl.proto.v2.ETLBatchConfig;
import io.cdap.cdap.etl.proto.v2.ETLPlugin;
import io.cdap.cdap.etl.proto.v2.ETLStage;
import io.cdap.cdap.proto.ProgramRunStatus;
import io.cdap.cdap.proto.artifact.AppRequest;
import io.cdap.cdap.proto.id.ApplicationId;
import io.cdap.cdap.proto.id.ArtifactId;
import io.cdap.cdap.proto.id.NamespaceId;
import io.cdap.cdap.test.ApplicationManager;
import io.cdap.cdap.test.DataSetManager;
import io.cdap.cdap.test.WorkflowManager;
import io.cdap.plugin.zuora.client.ZuoraRestClient;
import io.cdap.plugin.zuora.objects.ProductType;
import io.cdap.plugin.zuora.plugin.batch.source.ZuoraSource;
import io.cdap.plugin.zuora.plugin.batch.source.ZuoraSourceConfig;
import io.cdap.plugin.zuora.plugin.common.BaseConfig;
import io.cdap.plugin.zuora.restobjects.ObjectHelper;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import io.cdap.plugin.zuora.restobjects.objects.BaseResult;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZuoraSourceTest extends HydratorTestBase {
  private static final ArtifactSummary APP_ARTIFACT = new ArtifactSummary("data-pipeline", "3.2.0");
  private static final String BASIC_AUTH_TYPE = "basic";

  private static String authType;
  private static String authUser;
  private static String authPass;
  private static String restAPI;
  private static ZuoraRestClient client;

  @BeforeClass
  public static void setupTestClass() throws Exception {
    authType = System.getProperty("zuora.auth.type");
    restAPI = System.getProperty("zuora.restapi");

    if (Strings.isNullOrEmpty(restAPI)) {
      throw new IllegalArgumentException("'zuora.restapi' system property must not be empty");
    }

    if (authType != null) {
      authUser = System.getProperty("zuora.auth.user");
      authPass = System.getProperty("zuora.auth.pass");

      if (authUser == null || authPass == null) {
        throw new IllegalArgumentException("'zuora.auth.user' and 'zuora.auth.pass' system property must not be empty");
      }
      client = new ZuoraRestClient(restAPI, authUser, authPass, authType.equalsIgnoreCase(BASIC_AUTH_TYPE));
    } else {
      throw new IllegalArgumentException("'zuora.auth.type' system property must not be empty");
    }


    ArtifactId parentArtifact = NamespaceId.DEFAULT.artifact(APP_ARTIFACT.getName(), APP_ARTIFACT.getVersion());
    setupBatchArtifacts(parentArtifact, DataPipelineApp.class);
    addPluginArtifact(
      NamespaceId.DEFAULT.artifact("example-plugins", "1.0.0"),
      parentArtifact,
      ZuoraSource.class
    );
  }

  @Test
  public void testBatchSource() throws Exception {
    ImmutableMap.Builder<String, String> optionsBuilder = new ImmutableMap.Builder<>();

    if (authType.equals(BASIC_AUTH_TYPE)) {
      optionsBuilder
        .put(ZuoraSourceConfig.PROPERTY_AUTH_TYPE, BASIC_AUTH_TYPE)
        .put(ZuoraSourceConfig.PROPERTY_USERNAMENAME, authUser)
        .put(ZuoraSourceConfig.PROPERTY_PASSWORD, authPass);
    } else {
      optionsBuilder
        .put(ZuoraSourceConfig.PROPERTY_AUTH_TYPE, "oauth2")
        .put(ZuoraSourceConfig.PROPERTY_CLIENT_ID, authUser)
        .put(ZuoraSourceConfig.PROPERTY_CLIENT_SECRET, authPass);
    }

    optionsBuilder
      .put("apiEndpoint", restAPI)
      .put("referenceName", "ref")
      .put(ZuoraSourceConfig.PROPERTY_BASE_OBJECTS_TO_PULL, "Products");

    ETLStage source = new ETLStage("name", new ETLPlugin(BaseConfig.PLUGIN_NAME, BatchSource.PLUGIN_TYPE,
      optionsBuilder.build(), null));
    ETLStage sink = new ETLStage("sink", MockSink.getPlugin("outputSink"));

    ETLBatchConfig etlConfig = ETLBatchConfig.builder()
      .addStage(source)
      .addStage(sink)
      .addConnection(source.getName(), sink.getName())
      .build();

    ApplicationId pipelineId = NamespaceId.DEFAULT.app("HttpBatch_");
    ApplicationManager appManager = deployApplication(pipelineId, new AppRequest<>(APP_ARTIFACT, etlConfig));

    WorkflowManager workflowManager = appManager.getWorkflowManager(SmartWorkflow.NAME);
    workflowManager.startAndWaitForRun(ProgramRunStatus.COMPLETED, 5, TimeUnit.MINUTES);

    DataSetManager<Table> outputManager = getDataset("outputSink");
    List<StructuredRecord> outputRecords = MockSink.readOutput(outputManager);

    BaseResult<BaseObject> result = client.getObject(ObjectHelper.getObjectInfo(ProductType.class), null);
    Assert.assertTrue(result.isSuccess());
    int resultCount = result.getResult().size();
    while (result != null) {
      result = client.nextPage(result);
      if (result != null && result.isSuccess()) {
        resultCount += result.getResult().size();
      }
    }
    Assert.assertEquals(resultCount, outputRecords.size());
  }
}
