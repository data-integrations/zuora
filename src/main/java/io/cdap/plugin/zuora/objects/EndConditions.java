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
* Object name: EndConditions (EndConditions)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "EndConditions",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class EndConditions extends BaseObject {
  /**
  * Name: endDateCondition (endDateCondition), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("endDateCondition")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String endDateCondition;

  /**
  * Name: specificEndDate (specificEndDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("specificEndDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String specificEndDate;

  /**
  * Name: upToPeriods (upToPeriods), Type: integer
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("upToPeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer upToPeriods;

  /**
  * Name: upToPeriodsType (upToPeriodsType), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("upToPeriodsType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String upToPeriodsType;


  @Override
  public void addFields() {
    addCustomField("endDateCondition", endDateCondition, String.class);
    addCustomField("specificEndDate", specificEndDate, String.class);
    addCustomField("upToPeriods", upToPeriods, Integer.class);
    addCustomField("upToPeriodsType", upToPeriodsType, String.class);
  }
}
