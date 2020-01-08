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
* Object name: WorkflowsResponsePaginationItem (WorkflowsResponsePaginationItem)
* Related objects: 
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "WorkflowsResponsePaginationItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class WorkflowsResponsePaginationItem extends BaseObject {
  /**
  * Name: next_page (next_page), Type: string
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("next_page")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String next_page;

  /**
  * Name: page (page), Type: integer
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("page")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer page;

  /**
  * Name: page_length (page_length), Type: integer
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("page_length")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer page_length;


  @Override
  public void addFields() {
    addCustomField("next_page", next_page, String.class);
    addCustomField("page", page, Integer.class);
    addCustomField("page_length", page_length, Integer.class);
  }
}
