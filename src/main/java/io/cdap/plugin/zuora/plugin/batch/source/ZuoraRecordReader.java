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

package io.cdap.plugin.zuora.plugin.batch.source;

import com.google.gson.Gson;
import io.cdap.plugin.zuora.client.ZuoraRestClient;
import io.cdap.plugin.zuora.restobjects.ObjectHelper;
import io.cdap.plugin.zuora.restobjects.ObjectInfo;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import io.cdap.plugin.zuora.restobjects.objects.BaseResult;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import java.io.IOException;
import java.util.Iterator;

/**
 * RecordReader implementation, which reads {@link BaseObject} instances from Zuora API
 */
public class ZuoraRecordReader extends RecordReader<ZuoraSplitArgument, BaseObject> {
  private static final Gson gson = new Gson();

  protected ZuoraSplitArgument arguments;
  protected ZuoraRestClient client;

  protected BaseResult<BaseObject> resultPage;
  protected Iterator<BaseObject> recordIterator;
  protected BaseObject currentRecord;

  public ZuoraRecordReader(ZuoraSplitArgument arguments) {
    this.arguments = arguments;
  }

  @Override
  public void initialize(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException {
    Configuration configuration = taskAttemptContext.getConfiguration();
    ZuoraSourceConfig conf = gson.fromJson(
      configuration.get(ZuoraSourceConfig.PROPERTY_CONFIG_JSON),
      ZuoraSourceConfig.class
    );
    client = new ZuoraRestClient(conf);
    ObjectInfo objectInfo = ObjectHelper.getObjectInfo(arguments.getObjectName());
    resultPage = client.getObject(objectInfo, conf.getArguments());

    if (!resultPage.isSuccess()) {
      throw new RuntimeException(String.format("API exception of the query id %s: %s",
        resultPage.getProcessId(), resultPage.getReason(false)));
    }
    recordIterator = resultPage.getResult().iterator();
  }

  @Override
  public boolean nextKeyValue() throws IOException {
    boolean recordHasNext = recordIterator.hasNext();

    if (recordHasNext) {
      currentRecord = recordIterator.next();
    } else {
      resultPage = client.nextPage(resultPage);
      if (resultPage != null) {
        recordIterator = resultPage.getResult().iterator();
        recordHasNext = recordIterator.hasNext();
        if (recordHasNext) {
          currentRecord = recordIterator.next();
        }
      }
    }
    return recordHasNext;
  }

  @Override
  public ZuoraSplitArgument getCurrentKey() {
    return arguments;
  }

  @Override
  public BaseObject getCurrentValue() {
    return currentRecord;
  }

  @Override
  public float getProgress() {
    return 0.0f;
  }

  @Override
  public void close() {
    //no-op
  }
}
