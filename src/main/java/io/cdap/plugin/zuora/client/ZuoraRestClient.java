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

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.cdap.plugin.zuora.client.schema.ZuoraDefinitions;
import io.cdap.plugin.zuora.client.schema.ZuoraObjectSchema;
import io.cdap.plugin.zuora.plugin.common.AuthType;
import io.cdap.plugin.zuora.plugin.common.BaseConfig;
import io.cdap.plugin.zuora.restobjects.ObjectHelper;
import io.cdap.plugin.zuora.restobjects.ObjectInfo;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import io.cdap.plugin.zuora.restobjects.objects.BaseResult;
import org.apache.commons.lang.text.StrSubstitutor;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Zuora Rest Client based on {@link HttpClients} with added support for OAuth2 authorization and
 * possibility go through pagination logic of the API
 */
public class ZuoraRestClient {
  public static final String DESCRIBE_API = "describe";
  public static final String REST_API_VERSION = "v1";
  public static final String REST_API_PROTOCOL = "https";
  public static final String REST_ZUORA_VERSION = "230.0";

  private static final String REST_API = REST_API_PROTOCOL + "://rest.apisandbox.zuora.com";
  private static final String OAUTH_URL = "oauth/token";
  private static final String OAUTH_GRANT_TYPE = "client_credentials";
  private static final String OAUTH_TOKEN_TYPE = "bearer";
  private static final String CLIENT_NAME = "cdap-zuora plugin/1.0";
  private static final String HTTP_AUTH_HEADER = "Authorization";
  private static final String CONNECTION_CHECK_ENDPOINT = "settings/listing";
  private static final String VAR_OPEN_CHAR = "{";
  private static final String VAR_CLOSE_CHAR = "}";
  private static final int HTTP_OK_STATUS = 200;
  private static final int HTTP_AUTH_REQUIRED = 401;
  private static final int HTTP_AUTH_FORBIDDEN = 403;
  private static final int HTTP_NOT_FOUND = 404;
  private static final int HTTP_RATE_LIMIT = 429;
  private static final int HTTP_RATE_RETRY_TIME = 120;
  private static final Gson GSON = new GsonBuilder().create();

  private static String authToken = null;

  private String apiEnpoint;
  private String clientId;
  private String clientSecret;
  private boolean basicAuth;
  private Unmarshaller jaxbUnmarshaller;
  private CloseableHttpClient client;

  public ZuoraRestClient(String apiEndpoint, String clientId, String clientSecret, boolean basicAuth) {
    this.apiEnpoint = (apiEndpoint == null) ? REST_API : apiEndpoint;
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.basicAuth = basicAuth;
    this.client = HttpClients.custom()
      .setUserAgent(CLIENT_NAME)
      .setDefaultHeaders(Lists.newArrayList(
        new BasicHeader("zuora-version", REST_ZUORA_VERSION)
      ))
      .build();

    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(ZuoraDefinitions.class, ZuoraObjectSchema.class);
      this.jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    } catch (JAXBException e) {
      throw new RuntimeException("Invalid XML format", e);
    }
  }

  public ZuoraRestClient(BaseConfig config) {
    this(config.getApiEndpoint(), config.getAuthUsername(), config.getAuthPassword(),
      config.getAuthType() == AuthType.BASIC);
  }


  private String readFromStream(InputStream stream) throws IOException {
    try (InputStreamReader reader = new InputStreamReader(stream)) {
      return new BufferedReader(reader).lines().collect(Collectors.joining());
    }
  }

  private String getOAuth2Token() throws IOException {
    if (basicAuth) {
      authToken = Base64.getEncoder().encodeToString((String.format("%s:%s", clientId, clientSecret).getBytes()));
      return authToken;
    }

    HttpPost post = new HttpPost(String.format("%s/%s", apiEnpoint, OAUTH_URL));
    List<NameValuePair> params = new ArrayList<>();
    params.add(new BasicNameValuePair("client_id", this.clientId));
    params.add(new BasicNameValuePair("client_secret", this.clientSecret));
    params.add(new BasicNameValuePair("grant_type", OAUTH_GRANT_TYPE));

    try {
      post.setEntity(new UrlEncodedFormEntity(params));
    } catch (UnsupportedEncodingException e) {
      throw new IllegalArgumentException("client_id or client_secret were not provided");
    }

    try (CloseableHttpResponse response = client.execute(post)) {
      int statusCode = response.getStatusLine().getStatusCode();
      if (statusCode != HTTP_OK_STATUS) {
        throw new IOException(String.format("Wrong request status returned: %s", statusCode));
      }

      HttpEntity httpEntity = response.getEntity();
      if (httpEntity == null) {
        throw new IOException("No response from the OAuth API");
      }

      OAuthHttpResponse oAuthResponse;
      try (InputStream stream = httpEntity.getContent();
           InputStreamReader reader = new InputStreamReader(stream)) {

        oAuthResponse = GSON.fromJson(reader, OAuthHttpResponse.class);
      }

      if (oAuthResponse == null || !oAuthResponse.getTokenType().equals(OAUTH_TOKEN_TYPE)) {
        throw new IOException("Blank response from OAuth API or wrong token type");
      }
      return oAuthResponse.getAccessToken();
    }
  }

  private String getOAuth2Token(HttpUriRequest request, boolean update) throws IOException {
    if (authToken == null || update) {
      authToken = getOAuth2Token();
    }
    request.removeHeaders(HTTP_AUTH_HEADER);
    if (basicAuth) {
      request.addHeader(HTTP_AUTH_HEADER, "Basic " + authToken);
    } else {
      request.addHeader(HTTP_AUTH_HEADER, "Bearer " + authToken);
    }
    return authToken;
  }

  /**
   * Checks connection to the service by testing API endpoint, in case
   * of exception would be generated {@link IOException}
   */
  public void checkConnection() throws IOException {
    makeApiRequest(Method.GET, CONNECTION_CHECK_ENDPOINT, null, null);
  }

  private CloseableHttpResponse requestWithRetry(HttpUriRequest request) throws IOException {
    while (true) {
      try (CloseableHttpResponse response = client.execute(request)) {
        int responseCode = response.getStatusLine().getStatusCode();
        if (responseCode == HTTP_RATE_LIMIT) {
          int retryAfter;
          Header header = response.getLastHeader("Retry-After");
          try {
            retryAfter = Integer.parseInt(header.getValue()) + 5;
          } catch (NumberFormatException e) {
            retryAfter = HTTP_RATE_RETRY_TIME + 5;
          }
          Thread.sleep(retryAfter * 1000);
        } else {
          return response;
        }
      } catch (InterruptedException e) {
        // no-op
      }
    }
  }

  private String requestWithTokenRefresh(HttpUriRequest request) throws IOException {
    getOAuth2Token(request, false);

    try (CloseableHttpResponse response = requestWithRetry(request)) {
      int responseCode = response.getStatusLine().getStatusCode();
      if (responseCode == HTTP_AUTH_REQUIRED || responseCode == HTTP_AUTH_FORBIDDEN) {
        getOAuth2Token(request, true);
      } else if (responseCode == HTTP_NOT_FOUND) {
        throw new IllegalArgumentException(String.format("Requested resource '%s' not found",
          request.getURI().toString()));
      } else {
        return readFromStream(response.getEntity().getContent());
      }
    }

    // situation, when access token was expired and need to be refreshed
    try (CloseableHttpResponse response = requestWithRetry(request)) {
      int responseCode = response.getStatusLine().getStatusCode();
      if (responseCode == HTTP_AUTH_REQUIRED || responseCode == HTTP_AUTH_FORBIDDEN) {
        throw new IOException("Failed to obtain OAuth2 token, check used credentials");
      } else {
        return readFromStream(response.getEntity().getContent());
      }
    }
  }

  private String makeApiRequest(Method method, String endpoint, @Nullable Map<String, String> arguments,
                                @Nullable String data) throws IOException {
    RequestBuilder builder = RequestBuilder.create(method.name());

    if (method == Method.POST || method == Method.PUT) {
      HttpEntity entity = EntityBuilder
        .create()
        .setText(data)
        .build();
      builder.setEntity(entity);
    }
    String uri = endpoint;
    if (arguments != null && !arguments.isEmpty() && endpoint.contains(VAR_OPEN_CHAR)) {
      uri = StrSubstitutor.replace(endpoint, arguments, VAR_OPEN_CHAR, VAR_CLOSE_CHAR);
    }

    builder.setUri(String.format("%s/%s", apiEnpoint, uri));
    return requestWithTokenRefresh(builder.build());
  }
  /**
   * Verify all incoming arguments for the query object
   *
   * @param objectInfo objects definition
   * @param arguments query arguments
   * @throws IllegalArgumentException if any validation issue
   */
  private void checkIncomingArguments(ObjectInfo objectInfo, Map<String, String> arguments)
    throws IllegalArgumentException {

    if (objectInfo.getRequiredArguments() != null && !objectInfo.getRequiredArguments().isEmpty()) {
      if (arguments == null || arguments.isEmpty()) {
        throw new IllegalArgumentException(String.format(
          "Object '%s' requires input arguments to be passed, nothing found",
          objectInfo.getCdapObjectName()
        ));
      }
      List<String> exceptions = new ArrayList<>();

      objectInfo.getRequiredArguments().forEach(x -> {
        try {
          if (Strings.isNullOrEmpty(x)) {
            return;
          }

          arguments.keySet().stream()
            .filter(x::equals)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(String.format(
              "Object '%s' requires '%s' argument, but nothing provided",
              objectInfo.getCdapObjectName(),
              x
            )));
        } catch (IllegalArgumentException e) {
          exceptions.add(e.getMessage());
        }
      });
      if (!exceptions.isEmpty()) {
        throw new IllegalArgumentException(exceptions.stream().collect(Collectors.joining(System.lineSeparator())));
      }
    }
  }

  public ZuoraDefinitions getObjectList() throws IOException {
    String data = makeApiRequest(Method.GET, REST_API_VERSION + "/" + DESCRIBE_API, null, null);
    try (StringReader reader = new StringReader(data)) {
      return (ZuoraDefinitions) jaxbUnmarshaller.unmarshal(reader);
    } catch (JAXBException e) {
      throw new IOException("Invalid XML Format", e);
    }
  }

  public ZuoraObjectSchema getObjectSchema(String name) throws IOException, JAXBException {
    String data = makeApiRequest(Method.GET, String.format("%s/%s/%s", REST_API_VERSION, DESCRIBE_API, name),
      null, null);
    try (StringReader reader = new StringReader(data)) {
      return (ZuoraObjectSchema) jaxbUnmarshaller.unmarshal(reader);
    }
  }

  /**
   * Converts per-object response structure to generic
   *
   *
   * Example:
   *   {
   *     "myobjectname": [
   *      {
   *        "object field: "object value",
   *        ....
   *      },
   *      ......
   *     ],
   *     "responseField: "value",
   *     ....
   *   }
   *
   * @param objectInfo object information
   * @param data raw Json
   * @return modified json
   */
  private static String adaptJson(ObjectInfo objectInfo, String data) {
    JsonParser parser = new JsonParser();
    JsonObject object = parser.parse(data).getAsJsonObject();
    JsonElement mainJson = object.get(objectInfo.getResponseRootElement());
    object.remove(objectInfo.getResponseRootElement());
    object.add("result", mainJson);
    return object.toString();
  }

  /**
   * Convert prepared json to the result object
   * @param objectInfo Object Definition
   * @param json prepared JSON
   */
  private BaseResult<BaseObject> fetchObject(ObjectInfo objectInfo, String json) {
    Class clazz = objectInfo.getObjectClass();
    json = adaptJson(objectInfo, json);

    Type typeToken = new ParameterizedType() {
      @Override
      public Type[] getActualTypeArguments() {
        return new Type[] { clazz };
      }

      @Override
      public Type getRawType() {
        return BaseResult.class;
      }

      @Override
      public Type getOwnerType() {
        return null;
      }
    };

    BaseResult<BaseObject> result = GSON.fromJson(json, typeToken);
    result.setCdapObjectName(objectInfo.getCdapObjectName());

    return result;
  }

  /**
   * Query API using plugin meta objects
   *
   * @param objectInfo objects definition
   * @param arguments query arguments
   * @return object representation of the query
   * @throws IOException if any issue with query the API happen
   */
  public BaseResult<BaseObject> getObject(ObjectInfo objectInfo, Map<String, String> arguments) throws IOException {
    checkIncomingArguments(objectInfo, arguments);

    String endpoint = objectInfo.getRestAPIUrl();
    String response = makeApiRequest(Method.GET, REST_API_VERSION + "/" + endpoint, arguments, null);

    return fetchObject(objectInfo, response);
  }

  /**
   * Query nextPage of the previous request
   *
   * @param previousResult the result of the previous query
   * @return object representation of the query
   * @throws IOException if any issue with query the API happen
   */
  @Nullable
  public BaseResult<BaseObject> nextPage(BaseResult<BaseObject> previousResult) throws IOException {
    if (previousResult.getNextPage() == null || previousResult.getCdapObjectName() == null) {
      return null;
    }

    String response = makeApiRequest(Method.GET, previousResult.getNextPage(),
      previousResult.getNextPageArguments(), null);

    ObjectInfo objectInfo = ObjectHelper.getObjectInfo(previousResult.getCdapObjectName());
    if (objectInfo == null) {
      return null;
    }
    return fetchObject(objectInfo, response);
  }
}
