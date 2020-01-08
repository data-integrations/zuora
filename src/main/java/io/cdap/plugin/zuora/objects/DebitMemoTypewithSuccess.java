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
* Object name: DebitMemoTypewithSuccess (DebitMemoTypewithSuccess)
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "DebitMemos",
  responseRootElement = "debitmemos",
  APIUrl = "debitmemos",
  ObjectType = ObjectDefinition.ObjectDefinitionType.BASE
)
public class DebitMemoTypewithSuccess extends BaseObject {
  /**
  * Name: accountId (accountId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: amount (amount), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: autoPay (autoPay), Type: boolean
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("autoPay")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoPay;

  /**
  * Name: balance (balance), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("balance")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String balance;

  /**
  * Name: beAppliedAmount (beAppliedAmount), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("beAppliedAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String beAppliedAmount;

  /**
  * Name: cancelledById (cancelledById), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cancelledById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cancelledById;

  /**
  * Name: cancelledOn (cancelledOn), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cancelledOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cancelledOn;

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
  * Name: debitMemoDate (debitMemoDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("debitMemoDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String debitMemoDate;

  /**
  * Name: dueDate (dueDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("dueDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String dueDate;

  /**
  * Name: id (id), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: latestPDFFileId (latestPDFFileId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("latestPDFFileId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String latestPDFFileId;

  /**
  * Name: number (number), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("number")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String number;

  /**
  * Name: postedById (postedById), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("postedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String postedById;

  /**
  * Name: postedOn (postedOn), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("postedOn")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String postedOn;

  /**
  * Name: reasonCode (reasonCode), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("reasonCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String reasonCode;

  /**
  * Name: referredInvoiceId (referredInvoiceId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("referredInvoiceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referredInvoiceId;

  /**
  * Name: status (status), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

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

  /**
  * Name: taxMessage (taxMessage), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxMessage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxMessage;

  /**
  * Name: taxStatus (taxStatus), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("taxStatus")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String taxStatus;

  /**
  * Name: totalTaxExemptAmount (totalTaxExemptAmount), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("totalTaxExemptAmount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String totalTaxExemptAmount;

  /**
  * Name: transferredToAccounting (transferredToAccounting), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("transferredToAccounting")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transferredToAccounting;

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
    addCustomField("accountId", accountId, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("autoPay", autoPay, Boolean.class);
    addCustomField("balance", balance, String.class);
    addCustomField("beAppliedAmount", beAppliedAmount, String.class);
    addCustomField("cancelledById", cancelledById, String.class);
    addCustomField("cancelledOn", cancelledOn, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("debitMemoDate", debitMemoDate, String.class);
    addCustomField("dueDate", dueDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("latestPDFFileId", latestPDFFileId, String.class);
    addCustomField("number", number, String.class);
    addCustomField("postedById", postedById, String.class);
    addCustomField("postedOn", postedOn, String.class);
    addCustomField("reasonCode", reasonCode, String.class);
    addCustomField("referredInvoiceId", referredInvoiceId, String.class);
    addCustomField("status", status, String.class);
    addCustomField("targetDate", targetDate, String.class);
    addCustomField("taxAmount", taxAmount, String.class);
    addCustomField("taxMessage", taxMessage, String.class);
    addCustomField("taxStatus", taxStatus, String.class);
    addCustomField("totalTaxExemptAmount", totalTaxExemptAmount, String.class);
    addCustomField("transferredToAccounting", transferredToAccounting, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}
