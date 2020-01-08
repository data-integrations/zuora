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
* Object name: AccountType (AccountType)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AccountType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AccountType extends BaseObject {
  /**
  * Name: billingAndPayment (billingAndPayment), Type: AccountTypeBillingAndPaymentItem
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billingAndPayment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billingAndPayment;

  /**
  * Name: metrics (metrics), Type: AccountTypeMetricsItem
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("metrics")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String metrics;

  /**
  * Name: success (success), Type: boolean
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("success")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean success;

  /**
  * Name: taxInfo (taxInfo), Type: AccountTypeTaxInfoItem
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxInfo")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxInfo;


  @Override
  public void addFields() {
    addCustomField("billingAndPayment", billingAndPayment, String.class);
    addCustomField("metrics", metrics, String.class);
    addCustomField("success", success, Boolean.class);
    addCustomField("taxInfo", taxInfo, String.class);
  }
}
