/*
 * Copyright © 2019 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.cdap.plugin.zuora.plugin.streaming.source;

import io.cdap.cdap.api.data.format.StructuredRecord;
import io.cdap.cdap.etl.api.streaming.StreamingContext;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import java.io.IOException;

/**
 * Zuora streaming source util. Which encapsulated spark classes from {@link ZuoraStreamingSource}, so
 * that validation does not fail loading spark classes.
 */
public class ZuoraStreamingUtil {
  public static JavaDStream<StructuredRecord> getStream(ZuoraStreamingSourceConfig config,
                                                        StreamingContext streamingContext)
    throws IOException {
    JavaStreamingContext jssc = streamingContext.getSparkStreamingContext();

    return jssc.receiverStream(new ZuoraReceiver(config));
  }
}
