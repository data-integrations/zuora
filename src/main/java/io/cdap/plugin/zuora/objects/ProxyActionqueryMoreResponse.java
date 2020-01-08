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
package io.cdap.plugin.zuora.objects;

import com.google.gson.annotations.SerializedName;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectDefinition;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectFieldDefinition;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;

import java.util.List;

import javax.annotation.Nullable;

/**
* Object name: ProxyActionqueryMoreResponse (ProxyActionqueryMoreResponse)
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyActionqueryMoreResponse",
  RequiredArguments = {
    "queryMoreRequest"
  },
  APIUrl = "action/queryMore",
  ObjectType = ObjectDefinition.ObjectDefinitionType.BASE
)
public class ProxyActionqueryMoreResponse extends BaseObject {
  /**
  * Name: done (done), Type: boolean
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("done")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean done;

  /**
  * Name: queryLocator (queryLocator), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("queryLocator")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String queryLocator;

  /**
  * Name: records (records), Type: array|ZObject
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("records")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "ZObject")
  private List<ZObject> records;

  /**
  * Name: size (size), Type: integer
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("size")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer size;


  @Override
  public void addFields() {
    addCustomField("done", done, Boolean.class);
    addCustomField("queryLocator", queryLocator, String.class);
    addCustomField("records", records, List.class);
    addCustomField("size", size, Integer.class);
  }
}
