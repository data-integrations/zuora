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


import javax.annotation.Nullable;

/**
* Object name: ProxyCreateExport (ProxyCreateExport)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyCreateExport",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProxyCreateExport extends BaseObject {
  /**
  * Name: ConvertToCurrencies (ConvertToCurrencies), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("convertToCurrencies")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String convertToCurrencies;

  /**
  * Name: Encrypted (Encrypted), Type: boolean
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("encrypted")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean encrypted;

  /**
  * Name: FileId (FileId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("fileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String fileId;

  /**
  * Name: Format (Format), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("format")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String format;

  /**
  * Name: Name (Name), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("name")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String name;

  /**
  * Name: Query (Query), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("query")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String query;

  /**
  * Name: Size (Size), Type: integer
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("size")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer size;

  /**
  * Name: Status (Status), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: StatusReason (StatusReason), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("statusReason")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String statusReason;

  /**
  * Name: Zip (Zip), Type: boolean
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("zip")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean zip;


  @Override
  public void addFields() {
    addCustomField("convertToCurrencies", convertToCurrencies, String.class);
    addCustomField("encrypted", encrypted, Boolean.class);
    addCustomField("fileId", fileId, String.class);
    addCustomField("format", format, String.class);
    addCustomField("name", name, String.class);
    addCustomField("query", query, String.class);
    addCustomField("size", size, Integer.class);
    addCustomField("status", status, String.class);
    addCustomField("statusReason", statusReason, String.class);
    addCustomField("zip", zip, Boolean.class);
  }
}
