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
* Object name: AccountSummarySubscriptionRatePlanType (AccountSummarySubscriptionRatePlanType)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AccountSummarySubscriptionRatePlanType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AccountSummarySubscriptionRatePlanType extends BaseObject {
  /**
  * Name: productId (productId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productId;

  /**
  * Name: productName (productName), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productName;

  /**
  * Name: productRatePlanId (productRatePlanId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productRatePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productRatePlanId;

  /**
  * Name: productSku (productSku), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("productSku")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String productSku;

  /**
  * Name: ratePlanName (ratePlanName), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("ratePlanName")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ratePlanName;


  @Override
  public void addFields() {
    addCustomField("productId", productId, String.class);
    addCustomField("productName", productName, String.class);
    addCustomField("productRatePlanId", productRatePlanId, String.class);
    addCustomField("productSku", productSku, String.class);
    addCustomField("ratePlanName", ratePlanName, String.class);
  }
}
