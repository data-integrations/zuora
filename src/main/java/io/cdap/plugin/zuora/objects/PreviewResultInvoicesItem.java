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
* Object name: PreviewResultInvoicesItem (PreviewResultInvoicesItem)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PreviewResultInvoicesItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PreviewResultInvoicesItem extends BaseObject {
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
  * Name: invoiceItems (invoiceItems), Type: array|InvoiceItemPreviewResult
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "InvoiceItemPreviewResult")
  private List<InvoiceItemPreviewResult> invoiceItems;

  /**
  * Name: targetDate (targetDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("targetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetDate;

  /**
  * Name: taxAmount (taxAmount), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxAmount;


  @Override
  public void addFields() {
    addCustomField("amount", amount, String.class);
    addCustomField("amountWithoutTax", amountWithoutTax, String.class);
    addCustomField("invoiceItems", invoiceItems, List.class);
    addCustomField("targetDate", targetDate, String.class);
    addCustomField("taxAmount", taxAmount, String.class);
  }
}
