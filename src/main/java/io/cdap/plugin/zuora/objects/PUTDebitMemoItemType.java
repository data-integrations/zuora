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
* Object name: PUTDebitMemoItemType (PUTDebitMemoItemType)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PUTDebitMemoItemType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PUTDebitMemoItemType extends BaseObject {
  /**
  * Name: amount (amount), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: comment (comment), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
  * Name: financeInformation (financeInformation), Type: PUTDebitMemoItemTypeFinanceInformationItem
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
  * Name: skuName (skuName), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("skuName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String skuName;

  /**
  * Name: taxItems (taxItems), Type: array|PutDebitMemoTaxItemType
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "PutDebitMemoTaxItemType")
  private List<PutDebitMemoTaxItemType> taxItems;

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
    addCustomField("amount", amount, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("financeInformation", financeInformation, String.class);
    addCustomField("id", id, String.class);
    addCustomField("serviceEndDate", serviceEndDate, String.class);
    addCustomField("serviceStartDate", serviceStartDate, String.class);
    addCustomField("skuName", skuName, String.class);
    addCustomField("taxItems", taxItems, List.class);
    addCustomField("unitOfMeasure", unitOfMeasure, String.class);
  }
}
