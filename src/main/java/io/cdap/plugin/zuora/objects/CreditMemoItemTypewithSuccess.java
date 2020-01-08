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
* Object name: CreditMemoItemTypewithSuccess (CreditMemoItemTypewithSuccess)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "CreditMemoItemTypewithSuccess",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class CreditMemoItemTypewithSuccess extends BaseObject {
  /**
  * Name: amount (amount), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: amountWithoutTax (amountWithoutTax), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amountWithoutTax")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amountWithoutTax;

  /**
  * Name: appliedAmount (appliedAmount), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("appliedAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String appliedAmount;

  /**
  * Name: comment (comment), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
  * Name: createdById (createdById), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
  * Name: createdDate (createdDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /**
  * Name: creditTaxItems (creditTaxItems), Type: array|CMTaxItemType
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("creditTaxItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "CMTaxItemType")
  private List<CMTaxItemType> creditTaxItems;

  /**
  * Name: description (description), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("description")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String description;

  /**
  * Name: financeInformation (financeInformation), Type: CreditMemoItemTypewithSuccessFinanceInformationItem
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("financeInformation")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String financeInformation;

  /**
  * Name: id (id), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: refundAmount (refundAmount), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("refundAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String refundAmount;

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
  * Name: sku (sku), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sku")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sku;

  /**
  * Name: skuName (skuName), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("skuName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String skuName;

  /**
  * Name: sourceItemId (sourceItemId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sourceItemId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceItemId;

  /**
  * Name: sourceItemType (sourceItemType), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sourceItemType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceItemType;

  /**
  * Name: subscriptionId (subscriptionId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("subscriptionId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String subscriptionId;

  /**
  * Name: taxationItems (taxationItems), Type: CreditMemoItemTypewithSuccessTaxationItemsItem
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxationItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxationItems;

  /**
  * Name: unappliedAmount (unappliedAmount), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("unappliedAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String unappliedAmount;

  /**
  * Name: updatedById (updatedById), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
  * Name: updatedDate (updatedDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;


  @Override
  public void addFields() {
    addCustomField("amount", amount, String.class);
    addCustomField("amountWithoutTax", amountWithoutTax, String.class);
    addCustomField("appliedAmount", appliedAmount, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("creditTaxItems", creditTaxItems, List.class);
    addCustomField("description", description, String.class);
    addCustomField("financeInformation", financeInformation, String.class);
    addCustomField("id", id, String.class);
    addCustomField("refundAmount", refundAmount, String.class);
    addCustomField("serviceEndDate", serviceEndDate, String.class);
    addCustomField("serviceStartDate", serviceStartDate, String.class);
    addCustomField("sku", sku, String.class);
    addCustomField("skuName", skuName, String.class);
    addCustomField("sourceItemId", sourceItemId, String.class);
    addCustomField("sourceItemType", sourceItemType, String.class);
    addCustomField("subscriptionId", subscriptionId, String.class);
    addCustomField("taxationItems", taxationItems, String.class);
    addCustomField("unappliedAmount", unappliedAmount, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}
