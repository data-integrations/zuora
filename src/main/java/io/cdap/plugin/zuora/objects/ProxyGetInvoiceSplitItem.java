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
* Object name: ProxyGetInvoiceSplitItem (ProxyGetInvoiceSplitItem)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "ProxyGetInvoiceSplitItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class ProxyGetInvoiceSplitItem extends BaseObject {
  /**
  * Name: CreatedById (CreatedById), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdById;

  /**
  * Name: CreatedDate (CreatedDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("createdDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String createdDate;

  /**
  * Name: Id (Id), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

  /**
  * Name: InvoiceDate (InvoiceDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceDate;

  /**
  * Name: InvoiceId (InvoiceId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceId;

  /**
  * Name: InvoiceSplitId (InvoiceSplitId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("invoiceSplitId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String invoiceSplitId;

  /**
  * Name: PaymentTerm (PaymentTerm), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("paymentTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String paymentTerm;

  /**
  * Name: SplitPercentage (SplitPercentage), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("splitPercentage")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String splitPercentage;

  /**
  * Name: UpdatedById (UpdatedById), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedById")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedById;

  /**
  * Name: UpdatedDate (UpdatedDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("updatedDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String updatedDate;


  @Override
  public void addFields() {
    addCustomField("createdById", createdById, String.class);
    addCustomField("createdDate", createdDate, String.class);
    addCustomField("id", id, String.class);
    addCustomField("invoiceDate", invoiceDate, String.class);
    addCustomField("invoiceId", invoiceId, String.class);
    addCustomField("invoiceSplitId", invoiceSplitId, String.class);
    addCustomField("paymentTerm", paymentTerm, String.class);
    addCustomField("splitPercentage", splitPercentage, String.class);
    addCustomField("updatedById", updatedById, String.class);
    addCustomField("updatedDate", updatedDate, String.class);
  }
}
