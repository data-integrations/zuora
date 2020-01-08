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
* Object name: AccountSummaryPaymentType (AccountSummaryPaymentType)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AccountSummaryPaymentType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AccountSummaryPaymentType extends BaseObject {
  /**
  * Name: effectiveDate (effectiveDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("effectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String effectiveDate;

  /**
  * Name: id (id), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: paidInvoices (paidInvoices), Type: array|AccountSummaryPaymentInvoiceType
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paidInvoices")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "AccountSummaryPaymentInvoiceType")
  private List<AccountSummaryPaymentInvoiceType> paidInvoices;

  /**
  * Name: paymentNumber (paymentNumber), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentNumber;

  /**
  * Name: paymentType (paymentType), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentType;

  /**
  * Name: status (status), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;


  @Override
  public void addFields() {
    addCustomField("effectiveDate", effectiveDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("paidInvoices", paidInvoices, List.class);
    addCustomField("paymentNumber", paymentNumber, String.class);
    addCustomField("paymentType", paymentType, String.class);
    addCustomField("status", status, String.class);
  }
}
