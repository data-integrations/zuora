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

import io.cdap.cdap.api.annotation.Description;
import io.cdap.cdap.api.annotation.Macro;
import io.cdap.cdap.api.annotation.Name;
import io.cdap.plugin.zuora.plugin.batch.source.ZuoraSourceConfig;

/**
 * Config for {@link ZuoraStreamingSource}
 */
public class ZuoraStreamingSourceConfig extends ZuoraSourceConfig {
  public static final String PULL_FREQUENCY = "pullFrequency";

  @Name(PULL_FREQUENCY)
  @Description("Delay between polling of Zuora API for updates.")
  @Macro
  private String pullFrequency;

  public ZuoraStreamingSourceConfig(String referenceName) {
    super(referenceName);
  }

  public PullFrequency getPullFrequency() {
    return PullFrequency.fromValue(pullFrequency);
  }
}
