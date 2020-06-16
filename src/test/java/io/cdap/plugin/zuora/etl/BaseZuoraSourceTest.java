/*
 *  Copyright © 2020 Cask Data, Inc.
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
import io.cdap.cdap.api.data.format.StructuredRecord;
import io.cdap.cdap.etl.mock.test.HydratorTestBase;
import io.cdap.plugin.zuora.client.ZuoraRestClient;
import io.cdap.plugin.zuora.objects.ProductType;
import io.cdap.plugin.zuora.plugin.batch.source.ZuoraSourceConfig;
import io.cdap.plugin.zuora.restobjects.ObjectHelper;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import io.cdap.plugin.zuora.restobjects.objects.BaseResult;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import java.util.List;
import java.util.Map;

public abstract class BaseZuoraSourceTest extends HydratorTestBase {
  private static final String BASIC_AUTH_TYPE = "basic";

  private static String authType;
  private static String authUser;
  private static String authPass;
  private static String restAPI;
  private static ZuoraRestClient client;

  @Rule
  public TestName testName = new TestName();

  @BeforeClass
  public static void setProperties() {
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
  }

  public Map<String, String> getBaseProperties() {
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
      .put("referenceName", "ref");

    return optionsBuilder.build();
  }

  public abstract List<StructuredRecord> getPipelineResults(Map<String, String> properties,
                                                   int expectedRecordsCount) throws Exception;

  @Test
  public void testSource() throws Exception {
    BaseResult<BaseObject> result = client.getObject(ObjectHelper.getObjectInfo(ProductType.class), null);
    Assert.assertTrue(result.isSuccess());
    int resultCount = result.getResult().size();
    while (result != null) {
      result = client.nextPage(result);
      if (result != null && result.isSuccess()) {
        resultCount += result.getResult().size();
      }
    }

    Map<String, String> properties = new ImmutableMap.Builder<String, String>()
      .putAll(getBaseProperties())
      .put(ZuoraSourceConfig.PROPERTY_BASE_OBJECTS_TO_PULL, "Products")
      .build();

    List<StructuredRecord> outputRecords = getPipelineResults(properties, resultCount);
    Assert.assertEquals(resultCount, outputRecords.size());
  }
}
