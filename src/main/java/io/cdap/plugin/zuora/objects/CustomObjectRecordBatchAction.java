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
* Object name: CustomObjectRecordBatchAction (CustomObjectRecordBatchAction).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "CustomObjectRecordBatchAction",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class CustomObjectRecordBatchAction extends BaseObject {
  /**
  * Name: ids (ids), Type: array|CustomObjectRecordBatchActionIdsItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("ids")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "CustomObjectRecordBatchActionIdsItem")
  private List<CustomObjectRecordBatchActionIdsItem> ids;

  /**
  * Name: records (records), Type: CustomObjectRecordBatchActionRecordsItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("records")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String records;

  /**
  * Name: type (type), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("type")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String type;


  @Override
  public void addFields() {
    addCustomField("ids", ids, List.class);
    addCustomField("records", records, String.class);
    addCustomField("type", type, String.class);
  }
}
