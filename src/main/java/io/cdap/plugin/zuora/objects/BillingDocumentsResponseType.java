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
* Object name: BillingDocumentsResponseType (BillingDocumentsResponseType)
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "BillingDocuments",
  responseRootElement = "billingDocuments",
  RequiredArguments = {
    "accountId"
  },
  APIUrl = "billing-documents",
  ObjectType = ObjectDefinition.ObjectDefinitionType.BASE
)
public class BillingDocumentsResponseType extends BaseObject {
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
  * Name: balance (balance), Type: number
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("balance")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String balance;

  /**
  * Name: documentDate (documentDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("documentDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String documentDate;

  /**
  * Name: documentNumber (documentNumber), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("documentNumber")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String documentNumber;

  /**
  * Name: documentType (documentType), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("documentType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String documentType;

  /**
  * Name: id (id), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("id")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String id;

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
    addCustomField("accountId", accountId, String.class);
    addCustomField("amount", amount, String.class);
    addCustomField("balance", balance, String.class);
    addCustomField("documentDate", documentDate, String.class);
    addCustomField("documentNumber", documentNumber, String.class);
    addCustomField("documentType", documentType, String.class);
    addCustomField("id", id, String.class);
    addCustomField("status", status, String.class);
  }
}
