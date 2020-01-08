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
* Object name: CreateSubscriptionForEvergreenTermsItem (CreateSubscriptionForEvergreenTermsItem)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "CreateSubscriptionForEvergreenTermsItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class CreateSubscriptionForEvergreenTermsItem extends BaseObject {
  /**
  * Name: autoRenew (autoRenew), Type: boolean
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("autoRenew")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean autoRenew;

  /**
  * Name: initialTerm (initialTerm), Type: CreateSubscriptionForEvergreenTermsItemInitialTermItem
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("initialTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String initialTerm;

  /**
  * Name: renewalSetting (renewalSetting), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("renewalSetting")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String renewalSetting;

  /**
  * Name: renewalTerms (renewalTerms), Type: array|RenewalTerm
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("renewalTerms")
  @ObjectFieldDefinition(FieldType = Schema.Type.ARRAY, NestedClass = "RenewalTerm")
  private List<RenewalTerm> renewalTerms;


  @Override
  public void addFields() {
    addCustomField("autoRenew", autoRenew, Boolean.class);
    addCustomField("initialTerm", initialTerm, String.class);
    addCustomField("renewalSetting", renewalSetting, String.class);
    addCustomField("renewalTerms", renewalTerms, List.class);
  }
}
