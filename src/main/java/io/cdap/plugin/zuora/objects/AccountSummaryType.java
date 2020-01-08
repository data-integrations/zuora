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
* Object name: AccountSummaryType (AccountSummaryType)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AccountSummaryType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AccountSummaryType extends BaseObject {
  /**
  * Name: invoices (invoices), Type: array|AccountSummaryInvoiceType
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoices")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "AccountSummaryInvoiceType")
  private List<AccountSummaryInvoiceType> invoices;

  /**
  * Name: payments (payments), Type: array|AccountSummaryPaymentType
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("payments")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "AccountSummaryPaymentType")
  private List<AccountSummaryPaymentType> payments;

  /**
  * Name: subscriptions (subscriptions), Type: array|AccountSummarySubscriptionType
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptions")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "AccountSummarySubscriptionType")
  private List<AccountSummarySubscriptionType> subscriptions;

  /**
  * Name: success (success), Type: boolean
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
  * Name: taxInfo (taxInfo), Type: AccountSummaryTypeTaxInfoItem
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxInfo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxInfo;

  /**
  * Name: usage (usage), Type: array|AccountSummaryUsageType
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("usage")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "AccountSummaryUsageType")
  private List<AccountSummaryUsageType> usage;


  @Override
  public void addFields() {
    addCustomField("invoices", invoices, List.class);
    addCustomField("payments", payments, List.class);
    addCustomField("subscriptions", subscriptions, List.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("taxInfo", taxInfo, String.class);
    addCustomField("usage", usage, List.class);
  }
}
