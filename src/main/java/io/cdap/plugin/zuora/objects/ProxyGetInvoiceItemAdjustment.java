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
* Object name: ProxyGetInvoiceItemAdjustment (ProxyGetInvoiceItemAdjustment).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyGetInvoiceItemAdjustment",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProxyGetInvoiceItemAdjustment extends BaseObject {
  /**
  * Name: AccountId (AccountId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: AccountingCode (AccountingCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountingCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountingCode;

  /**
  * Name: AdjustmentDate (AdjustmentDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("adjustmentDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String adjustmentDate;

  /**
  * Name: AdjustmentNumber (AdjustmentNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("adjustmentNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String adjustmentNumber;

  /**
  * Name: Amount (Amount), Type: number.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("amount")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String amount;

  /**
  * Name: CancelledById (CancelledById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cancelledById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cancelledById;

  /**
  * Name: CancelledDate (CancelledDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("cancelledDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String cancelledDate;

  /**
  * Name: Comment (Comment), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("comment")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String comment;

  /**
  * Name: CreatedById (CreatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
  * Name: CreatedDate (CreatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /**
  * Name: CustomerName (CustomerName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("customerName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String customerName;

  /**
  * Name: CustomerNumber (CustomerNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("customerNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String customerNumber;

  /**
  * Name: Id (Id), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: InvoiceId (InvoiceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceId;

  /**
  * Name: InvoiceItemName (InvoiceItemName), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceItemName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceItemName;

  /**
  * Name: InvoiceNumber (InvoiceNumber), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceNumber;

  /**
  * Name: ReasonCode (ReasonCode), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("reasonCode")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String reasonCode;

  /**
  * Name: ReferenceId (ReferenceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("referenceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String referenceId;

  /**
  * Name: ServiceEndDate (ServiceEndDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("serviceEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceEndDate;

  /**
  * Name: ServiceStartDate (ServiceStartDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("serviceStartDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceStartDate;

  /**
  * Name: SourceId (SourceId), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sourceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceId;

  /**
  * Name: SourceType (SourceType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("sourceType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String sourceType;

  /**
  * Name: Status (Status), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("status")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String status;

  /**
  * Name: TransferredToAccounting (TransferredToAccounting), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("transferredToAccounting")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String transferredToAccounting;

  /**
  * Name: UpdatedById (UpdatedById), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
  * Name: UpdatedDate (UpdatedDate), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;


  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("accountingCode", accountingCode, String.class);
    addCustomField("adjustmentDate", adjustmentDate, String.class);
    addCustomField("adjustmentNumber", adjustmentNumber, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("cancelledById", cancelledById, String.class);
    addCustomField("cancelledDate", cancelledDate, String.class);
    addCustomField("comment", comment, String.class);
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("customerName", customerName, String.class);
    addCustomField("customerNumber", customerNumber, String.class);
    addCustomField("id", id, String.class);
    addCustomField("invoiceId", invoiceId, String.class);
    addCustomField("invoiceItemName", invoiceItemName, String.class);
    addCustomField("invoiceNumber", invoiceNumber, String.class);
    addCustomField("reasonCode", reasonCode, String.class);
    addCustomField("referenceId", referenceId, String.class);
    addCustomField("serviceEndDate", serviceEndDate, String.class);
    addCustomField("serviceStartDate", serviceStartDate, String.class);
    addCustomField("sourceId", sourceId, String.class);
    addCustomField("sourceType", sourceType, String.class);
    addCustomField("status", status, String.class);
    addCustomField("transferredToAccounting", transferredToAccounting, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}
