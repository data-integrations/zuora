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

package io.cdap.plugin.zuora.plugin.batch.source;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.cdap.plugin.zuora.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

/**
 * Source config test
 */
public class ZuoraSourceConfigTest extends BaseTest {
  private static Gson gson = new GsonBuilder().create();
  ZuoraSourceConfig config;

  @Before
  public void setUp() throws Exception {
    config = gson.fromJson(getResource("ZuoraSourceConfigExample.json"), ZuoraSourceConfig.class);
  }

  @Test
  public void isSingleObjectMode() {
    Assert.assertFalse(config.isSingleObjectMode());
  }

  @Test
  public void getSchema() {
    Assert.assertNull(config.getSchema(false));
    Assert.assertNotNull(config.getSchema(true));
  }

  @Test
  public void getObjects() {
    Assert.assertEquals(
      Arrays.asList(
        "Products",
        "Refunds",
        "PaymentRun",
        "Orders",
        "Entities",
        "DebitMemos",
        "CreditMemos",
        "BillingDocuments"
      ),
      config.getObjects()
    );
  }

  @Test
  public void getObjectsWithSchema() {
    Assert.assertEquals(8, config.getObjectsWithSchema().size());
  }

  @Test
  public void getArguments() {
    Assert.assertNull(config.getArguments());
  }
}
