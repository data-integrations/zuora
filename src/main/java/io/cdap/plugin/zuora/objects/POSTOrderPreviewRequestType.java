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
* Object name: POSTOrderPreviewRequestType (POSTOrderPreviewRequestType)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "POSTOrderPreviewRequestType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class POSTOrderPreviewRequestType extends BaseObject {
  /**
  * Name: existingAccountNumber (existingAccountNumber), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("existingAccountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String existingAccountNumber;

  /**
  * Name: orderDate (orderDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("orderDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String orderDate;

  /**
  * Name: orderNumber (orderNumber), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("orderNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String orderNumber;

  /**
  * Name: subscriptions (subscriptions), Type: array|POSTOrderPreviewRequestTypeSubscriptionsItem
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptions")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "POSTOrderPreviewRequestTypeSubscriptionsItem")
  private List<POSTOrderPreviewRequestTypeSubscriptionsItem> subscriptions;


  @Override
  public void addFields() {
    addCustomField("existingAccountNumber", existingAccountNumber, String.class);
    addCustomField("orderDate", orderDate, String.class);
    addCustomField("orderNumber", orderNumber, String.class);
    addCustomField("subscriptions", subscriptions, List.class);
  }
}
