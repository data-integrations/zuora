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
* Object name: OrderResume (OrderResume)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "OrderResume",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class OrderResume extends BaseObject {
  /**
  * Name: extendsTerm (extendsTerm), Type: boolean
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("extendsTerm")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean extendsTerm;

  /**
  * Name: resumeDate (resumeDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("resumeDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resumeDate;

  /**
  * Name: resumePeriods (resumePeriods), Type: integer
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("resumePeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer resumePeriods;

  /**
  * Name: resumePeriodsType (resumePeriodsType), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("resumePeriodsType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resumePeriodsType;

  /**
  * Name: resumePolicy (resumePolicy), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("resumePolicy")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resumePolicy;

  /**
  * Name: resumeSpecificDate (resumeSpecificDate), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("resumeSpecificDate")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String resumeSpecificDate;


  @Override
  public void addFields() {
    addCustomField("extendsTerm", extendsTerm, Boolean.class);
    addCustomField("resumeDate", resumeDate, String.class);
    addCustomField("resumePeriods", resumePeriods, Integer.class);
    addCustomField("resumePeriodsType", resumePeriodsType, String.class);
    addCustomField("resumePolicy", resumePolicy, String.class);
    addCustomField("resumeSpecificDate", resumeSpecificDate, String.class);
  }
}
