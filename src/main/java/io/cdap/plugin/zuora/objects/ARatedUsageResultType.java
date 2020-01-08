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
* Object name: ARatedUsageResultType (ARatedUsageResultType)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ARatedUsageResultType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ARatedUsageResultType extends BaseObject {
  /**
  * Name: accountNumber (accountNumber), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountNumber;

  /**
  * Name: amount (amount), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: chargeNumber (chargeNumber), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeNumber;

  /**
  * Name: currency (currency), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("currency")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String currency;

  /**
  * Name: id (id), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: quantity (quantity), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
  * Name: ratedResultId (ratedResultId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("ratedResultId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ratedResultId;

  /**
  * Name: startDate (startDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("startDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String startDate;

  /**
  * Name: subscriptionNumber (subscriptionNumber), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionNumber;

  /**
  * Name: unitOfMeasure (unitOfMeasure), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unitOfMeasure")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unitOfMeasure;

  /**
  * Name: usageId (usageId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("usageId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String usageId;


  @Override
  public void addFields() {
    addCustomField("accountNumber", accountNumber, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("chargeNumber", chargeNumber, String.class);
    addCustomField("currency", currency, String.class);
    addCustomField("id", id, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("ratedResultId", ratedResultId, String.class);
    addCustomField("startDate", startDate, String.class);
    addCustomField("subscriptionNumber", subscriptionNumber, String.class);
    addCustomField("unitOfMeasure", unitOfMeasure, String.class);
    addCustomField("usageId", usageId, String.class);
  }
}
