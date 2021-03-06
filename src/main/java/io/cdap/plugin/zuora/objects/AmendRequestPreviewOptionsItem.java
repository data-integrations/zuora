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
* Object name: AmendRequestPreviewOptionsItem (AmendRequestPreviewOptionsItem).
* Related objects:
**/
@SuppressWarnings("unused")
@ObjectDefinition(
  Name = "AmendRequestPreviewOptionsItem",
  ObjectType = ObjectDefinition.ObjectDefinitionType.NESTED
)
public class AmendRequestPreviewOptionsItem extends BaseObject {
  /**
  * Name: EnablePreviewMode (EnablePreviewMode), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("enablePreviewMode")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean enablePreviewMode;

  /**
  * Name: IncludeExistingDraftInvoiceItems (IncludeExistingDraftInvoiceItems), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("includeExistingDraftInvoiceItems")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean includeExistingDraftInvoiceItems;

  /**
  * Name: NumberOfPeriods (NumberOfPeriods), Type: integer.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("numberOfPeriods")
  @ObjectFieldDefinition(FieldType = Schema.Type.INT)
  private Integer numberOfPeriods;

  /**
  * Name: PreviewThroughTermEnd (PreviewThroughTermEnd), Type: boolean.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("previewThroughTermEnd")
  @ObjectFieldDefinition(FieldType = Schema.Type.BOOLEAN)
  private Boolean previewThroughTermEnd;

  /**
  * Name: PreviewType (PreviewType), Type: string.
  * Options (custom, update, select): false, false, false
  **/
  @Nullable
  @SerializedName("previewType")
  @ObjectFieldDefinition(FieldType = Schema.Type.STRING)
  private String previewType;


  @Override
  public void addFields() {
    addCustomField("enablePreviewMode", enablePreviewMode, Boolean.class);
    addCustomField("includeExistingDraftInvoiceItems", includeExistingDraftInvoiceItems, Boolean.class);
    addCustomField("numberOfPeriods", numberOfPeriods, Integer.class);
    addCustomField("previewThroughTermEnd", previewThroughTermEnd, Boolean.class);
    addCustomField("previewType", previewType, String.class);
  }
}
