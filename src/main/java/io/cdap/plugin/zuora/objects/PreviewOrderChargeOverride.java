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
* Object name: PreviewOrderChargeOverride (PreviewOrderChargeOverride).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PreviewOrderChargeOverride",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PreviewOrderChargeOverride extends BaseObject {
  /**
  * Name: billing (billing), Type: PreviewOrderChargeOverrideBillingItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("billing")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String billing;

  /**
  * Name: chargeNumber (chargeNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeNumber;

  /**
  * Name: description (description), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
  * Name: pricing (pricing), Type: PreviewOrderChargeOverridePricingItem.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("pricing")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String pricing;

  /**
  * Name: productRatePlanChargeId (productRatePlanChargeId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productRatePlanChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanChargeId;

  /**
  * Name: revRecCode (revRecCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revRecCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revRecCode;

  /**
  * Name: revRecTriggerCondition (revRecTriggerCondition), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revRecTriggerCondition")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revRecTriggerCondition;

  /**
  * Name: revenueRecognitionRuleName (revenueRecognitionRuleName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("revenueRecognitionRuleName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String revenueRecognitionRuleName;

  /**
  * Name: uniqueToken (uniqueToken), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("uniqueToken")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String uniqueToken;


  @Override
  public void addFields() {
    addCustomField("billing", billing, String.class);
    addCustomField("chargeNumber", chargeNumber, String.class);
    addCustomField("description", description, String.class);
    addCustomField("pricing", pricing, String.class);
    addCustomField("productRatePlanChargeId", productRatePlanChargeId, String.class);
    addCustomField("revRecCode", revRecCode, String.class);
    addCustomField("revRecTriggerCondition", revRecTriggerCondition, String.class);
    addCustomField("revenueRecognitionRuleName", revenueRecognitionRuleName, String.class);
    addCustomField("uniqueToken", uniqueToken, String.class);
  }
}
