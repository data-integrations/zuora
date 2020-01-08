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
* Object name: PostBillingPreviewParam (PostBillingPreviewParam)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PostBillingPreviewParam",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PostBillingPreviewParam extends BaseObject {
  /**
  * Name: accountId (accountId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("accountId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String accountId;

  /**
  * Name: assumeRenewal (assumeRenewal), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("assumeRenewal")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String assumeRenewal;

  /**
  * Name: chargeTypeToExclude (chargeTypeToExclude), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("chargeTypeToExclude")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String chargeTypeToExclude;

  /**
  * Name: includingEvergreenSubscription (includingEvergreenSubscription), Type: boolean
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("includingEvergreenSubscription")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean includingEvergreenSubscription;

  /**
  * Name: targetDate (targetDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("targetDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String targetDate;


  @Override
  public void addFields() {
    addCustomField("accountId", accountId, String.class);
    addCustomField("assumeRenewal", assumeRenewal, String.class);
    addCustomField("chargeTypeToExclude", chargeTypeToExclude, String.class);
    addCustomField("includingEvergreenSubscription", includingEvergreenSubscription, Boolean.class);
    addCustomField("targetDate", targetDate, String.class);
  }
}
