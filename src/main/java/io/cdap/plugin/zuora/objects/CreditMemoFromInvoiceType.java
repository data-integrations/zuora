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
* Object name: CreditMemoFromInvoiceType (CreditMemoFromInvoiceType).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "CreditMemoFromInvoiceType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class CreditMemoFromInvoiceType extends BaseObject {
  /**
  * Name: autoApplyToInvoiceUponPosting (autoApplyToInvoiceUponPosting), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("autoApplyToInvoiceUponPosting")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoApplyToInvoiceUponPosting;

  /**
  * Name: comment (comment), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
  * Name: effectiveDate (effectiveDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("effectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveDate;

  /**
  * Name: excludeFromAutoApplyRules (excludeFromAutoApplyRules), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("excludeFromAutoApplyRules")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean excludeFromAutoApplyRules;

  /**
  * Name: invoiceId (invoiceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceId;

  /**
  * Name: items (items), Type: array|CreditMemoItemFromInvoiceItemType.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("items")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "CreditMemoItemFromInvoiceItemType")
  private List<CreditMemoItemFromInvoiceItemType> items;

  /**
  * Name: reasonCode (reasonCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("reasonCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String reasonCode;

  /**
  * Name: taxAutoCalculation (taxAutoCalculation), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxAutoCalculation")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean taxAutoCalculation;


  @Override
  public void addFields() {
    addCustomField("autoApplyToInvoiceUponPosting", autoApplyToInvoiceUponPosting, Boolean.class);
    addCustomField("comment", comment, String.class);
    addCustomField("effectiveDate", effectiveDate, String.class);
    addCustomField("excludeFromAutoApplyRules", excludeFromAutoApplyRules, Boolean.class);
    addCustomField("invoiceId", invoiceId, String.class);
    addCustomField("items", items, List.class);
    addCustomField("reasonCode", reasonCode, String.class);
    addCustomField("taxAutoCalculation", taxAutoCalculation, Boolean.class);
  }
}
