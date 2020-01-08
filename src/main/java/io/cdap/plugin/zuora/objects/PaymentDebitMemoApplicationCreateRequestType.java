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
* Object name: PaymentDebitMemoApplicationCreateRequestType (PaymentDebitMemoApplicationCreateRequestType)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PaymentDebitMemoApplicationCreateRequestType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PaymentDebitMemoApplicationCreateRequestType extends BaseObject {
  /**
  * Name: amount (amount), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: debitMemoId (debitMemoId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("debitMemoId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String debitMemoId;

  /**
  * Name: items (items), Type: array|PaymentDebitMemoApplicationItemCreateRequestType
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("items")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "PaymentDebitMemoApplicationItemCreateRequestType")
  private List<PaymentDebitMemoApplicationItemCreateRequestType> items;


  @Override
  public void addFields() {
    addCustomField("amount", amount, String.class);
    addCustomField("debitMemoId", debitMemoId, String.class);
    addCustomField("items", items, List.class);
  }
}
