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

package io.cdap.plugin.zuora.client;

import com.google.gson.annotations.SerializedName;

/**
 * OAuth request response
 */
public class OAuthHttpResponse {
  @SerializedName("access_token")
  private String accessToken;

  @SerializedName("token_type")
  private String tokenType;

  @SerializedName("expires_in")
  private Integer expiresIn;

  @SerializedName("scope")
  private String scope;

  @SerializedName("jti")
  private String jti;

  public String getAccessToken() {
    return accessToken;
  }

  public String getTokenType() {
    return tokenType;
  }

  public Integer getExpiresIn() {
    return expiresIn;
  }

  public String getScope() {
    return scope;
  }

  public String getJti() {
    return jti;
  }
}
