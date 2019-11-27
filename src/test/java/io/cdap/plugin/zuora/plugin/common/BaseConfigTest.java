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

package io.cdap.plugin.zuora.plugin.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import io.cdap.cdap.etl.api.FailureCollector;
import io.cdap.plugin.zuora.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.lang.reflect.Type;

public class BaseConfigTest extends BaseTest {
  /**
   * Custom class creator for abstract {@link BaseConfig}
   */
  private static class BaseConfigInstanceCreator implements InstanceCreator<BaseConfig> {
    private String ref;

    BaseConfigInstanceCreator(String ref) {
      this.ref = ref;
    }

    @Override
    public BaseConfig createInstance(Type type) {
      return new BaseConfig(ref) {
        @Override
        protected void validate(FailureCollector failureCollector) {
          // no-op
          throw new IllegalArgumentException("no op method");
        }
      };
    }
  }

  private BaseConfig basicAuthConfig;
  private BaseConfig oAuth2AuthConfig;
  private static Gson gson;
  private static String refName = "ref" + getRandomUUID();

  @BeforeClass
  public static void classSetUp() {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(BaseConfig.class, new BaseConfigInstanceCreator(refName));
    gson = builder.create();
  }

  @Before
  public void setUp() throws Exception {
    basicAuthConfig = gson.fromJson(getResource("BaseConfigExample.json"), BaseConfig.class);
    oAuth2AuthConfig = gson.fromJson(getResource("OAuth2ConfigExample.json"), BaseConfig.class);
  }

  @Test
  public void testReferenceValue() {
    Assert.assertEquals(refName, basicAuthConfig.referenceName);
    Assert.assertEquals(refName, oAuth2AuthConfig.referenceName);
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateBasic() {
    basicAuthConfig.validate(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void validateOAuth2() {
    oAuth2AuthConfig.validate(null);
  }

  @Test
  public void getAuthUsername() {
   Assert.assertEquals("username", basicAuthConfig.getAuthUsername());
   Assert.assertEquals("clientid", oAuth2AuthConfig.getAuthUsername());
  }

  @Test
  public void getAuthPassword() {
    Assert.assertEquals("password", basicAuthConfig.getAuthPassword());
    Assert.assertEquals("clientsecret", oAuth2AuthConfig.getAuthPassword());
  }

  @Test
  public void getAuthType() {
    Assert.assertEquals(AuthType.BASIC, basicAuthConfig.getAuthType());
    Assert.assertEquals(AuthType.OAUTH2, oAuth2AuthConfig.getAuthType());
  }

  @Test
  public void getApiEndpoint() {
    Assert.assertEquals("https://endpoint", basicAuthConfig.getApiEndpoint());
    Assert.assertEquals("https://endpoint", oAuth2AuthConfig.getApiEndpoint());
  }
}
