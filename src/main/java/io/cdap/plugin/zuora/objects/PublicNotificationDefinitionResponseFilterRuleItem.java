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
* Object name: PublicNotificationDefinitionResponseFilterRuleItem (PublicNotificationDefinitionResponseFilterRuleItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PublicNotificationDefinitionResponseFilterRuleItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PublicNotificationDefinitionResponseFilterRuleItem extends BaseObject {
  /**
  * Name: condition (condition), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("condition")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String condition;

  /**
  * Name: description (description), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
  * Name: eventTypeName (eventTypeName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("eventTypeName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String eventTypeName;

  /**
  * Name: id (id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;


  @Override
  public void addFields() {
    addCustomField("condition", condition, String.class);
    addCustomField("description", description, String.class);
    addCustomField("eventTypeName", eventTypeName, String.class);
    addCustomField("id", id, String.class);
  }
}
