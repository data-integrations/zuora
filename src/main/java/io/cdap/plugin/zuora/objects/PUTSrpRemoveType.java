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
* Object name: PUTSrpRemoveType (PUTSrpRemoveType)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "PUTSrpRemoveType",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class PUTSrpRemoveType extends BaseObject {
  /**
  * Name: contractEffectiveDate (contractEffectiveDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("contractEffectiveDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String contractEffectiveDate;

  /**
  * Name: customerAcceptanceDate (customerAcceptanceDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("customerAcceptanceDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String customerAcceptanceDate;

  /**
  * Name: ratePlanId (ratePlanId), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("ratePlanId")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String ratePlanId;

  /**
  * Name: serviceActivationDate (serviceActivationDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("serviceActivationDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String serviceActivationDate;


  @Override
  public void addFields() {
    addCustomField("contractEffectiveDate", contractEffectiveDate, String.class);
    addCustomField("customerAcceptanceDate", customerAcceptanceDate, String.class);
    addCustomField("ratePlanId", ratePlanId, String.class);
    addCustomField("serviceActivationDate", serviceActivationDate, String.class);
  }
}
