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

package io.cdap.plugin.zuora.plugin.batch.sink;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.cdap.plugin.zuora.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Sink config test
 */
public class ZuoraSinkConfigTest extends BaseTest {

  private static Gson gson = new GsonBuilder().create();
  ZuoraSinkConfig config;

  @Before
  public void setUp() throws Exception {
    config = gson.fromJson(getResource("ZuoraSinkConfigExample.json"), ZuoraSinkConfig.class);
  }

  @Test
  public void getArgumentsSource() {
    Assert.assertEquals(ZuoraSinkConfig.ToArgumentsSource.INPUT, config.getArgumentsSource());
  }

  @Test
  public void getObjectName() {
    Assert.assertEquals("test", config.getObjectName());
  }

  @Test
  public void getBodyColumnName() {
    Assert.assertEquals("body", config.getBodyColumnName());
  }

  @Test
  public void getRequestArguments() {
    ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<>();
    builder
      .put("arg1", "val1")
      .put("arg2", "val2");

    Assert.assertEquals(builder.build(), config.getRequestArguments());
  }
}
