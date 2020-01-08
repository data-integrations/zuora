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

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.InputSplit;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Basic split on per-object basis
 */
public class ZuoraSourceSplit extends InputSplit implements Writable {
  private ZuoraSplitArgument arguments;

  @SuppressWarnings("unused")
  public ZuoraSourceSplit() {
    // for serialization
  }

  public ZuoraSourceSplit(ZuoraSplitArgument args) {
    this.arguments = args;
  }

  @Override
  public void write(DataOutput dataOutput) throws IOException {
   dataOutput.writeUTF(arguments.getObjectName());
   dataOutput.writeUTF(arguments.getObjectSchema());
  }

  @Override
  public void readFields(DataInput dataInput) throws IOException {
    String name = dataInput.readUTF();
    String schema = dataInput.readUTF();
    arguments = new ZuoraSplitArgument(name, schema);
  }

  @Override
  public long getLength() {
    return 0;
  }

  @Override
  public String[] getLocations() {
    return new String[0];
  }

  public ZuoraSplitArgument getArguments() {
    return arguments;
  }
}
