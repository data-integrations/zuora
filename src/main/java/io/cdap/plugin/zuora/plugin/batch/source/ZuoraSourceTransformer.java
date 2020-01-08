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

package io.cdap.plugin.zuora.plugin.batch.source;

import io.cdap.cdap.api.data.format.StructuredRecord;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import io.cdap.plugin.zuora.restobjects.objects.EmptyObject;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * {@link BaseObject} to {@link StructuredRecord} transformer
 */
public class ZuoraSourceTransformer {

  @SuppressWarnings("unchecked")
  private static void transformValue(String k, Object v, Schema schema, StructuredRecord.Builder builder) {

    if (v instanceof Map) {
      Schema mapSchema = Objects.requireNonNull(schema.getField(k)).getSchema();
      builder.set(k, transform((Map<String, Object>) v, mapSchema));
    } else if (v instanceof EmptyObject) {
      // no-op
    } else if (v instanceof BaseObject) {
      Schema mapSchema = Objects.requireNonNull(schema.getField(k)).getSchema();
      builder.set(k, transform((BaseObject) v, mapSchema));
    } else if (v instanceof List) {
      Schema componentSchema = Objects.requireNonNull(schema.getField(k)).getSchema().getComponentSchema();
      if (componentSchema == null) {
        throw new IllegalArgumentException(String.format("Unable to extract schema for the field '%s'", k));
      }
      Object values = ((List) v).stream()
        .map(arrItem -> transform((Map<String, Object>) arrItem, componentSchema)).collect(Collectors.toList());
      builder.set(k, values);
    } else {
      builder.set(k, v);
    }
  }

  public static StructuredRecord transform(Map<String, Object> object, Schema schema) {
    StructuredRecord.Builder builder = StructuredRecord.builder(schema);

    object.entrySet().stream()
      .filter(k -> schema.getField(k.getKey()) != null)  // filter absent fields in the schema
      .forEach(k -> transformValue(k.getKey(), k.getValue(), schema, builder));

    return builder.build();
  }

  public static StructuredRecord transform(BaseObject object, Schema schema) {
    StructuredRecord.Builder builder = StructuredRecord.builder(schema);

    object.asFilteredMap(schema)
      .forEach((k, v) -> transformValue(k, v, schema, builder));

    return builder.build();
  }
}
