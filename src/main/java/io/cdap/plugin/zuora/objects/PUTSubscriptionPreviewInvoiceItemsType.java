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
* Object name: PUTSubscriptionPreviewInvoiceItemsType (PUTSubscriptionPreviewInvoiceItemsType)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PUTSubscriptionPreviewInvoiceItemsType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PUTSubscriptionPreviewInvoiceItemsType extends BaseObject {
  /**
  * Name: chargeAmount (chargeAmount), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeAmount;

  /**
  * Name: chargeDescription (chargeDescription), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeDescription")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeDescription;

  /**
  * Name: chargeName (chargeName), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeName;

  /**
  * Name: productName (productName), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productName;

  /**
  * Name: productRatePlanChargeId (productRatePlanChargeId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productRatePlanChargeId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanChargeId;

  /**
  * Name: quantity (quantity), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("quantity")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String quantity;

  /**
  * Name: serviceEndDate (serviceEndDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("serviceEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceEndDate;

  /**
  * Name: serviceStartDate (serviceStartDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("serviceStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceStartDate;

  /**
  * Name: unitOfMeasure (unitOfMeasure), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unitOfMeasure")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unitOfMeasure;


  @Override
  public void addFields() {
    addCustomField("chargeAmount", chargeAmount, String.class);
    addCustomField("chargeDescription", chargeDescription, String.class);
    addCustomField("chargeName", chargeName, String.class);
    addCustomField("productName", productName, String.class);
    addCustomField("productRatePlanChargeId", productRatePlanChargeId, String.class);
    addCustomField("quantity", quantity, String.class);
    addCustomField("serviceEndDate", serviceEndDate, String.class);
    addCustomField("serviceStartDate", serviceStartDate, String.class);
    addCustomField("unitOfMeasure", unitOfMeasure, String.class);
  }
}
