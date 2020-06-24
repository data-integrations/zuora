/*
 * Copyright © 2020 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.cdap.plugin.zuora.restobjects;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.gson.annotations.SerializedName;
import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.RestObjectsConfig;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectDefinition;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectFieldDefinition;
import io.cdap.plugin.zuora.restobjects.objects.BaseObject;
import io.cdap.plugin.zuora.restobjects.objects.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/**
 * Schema processing core. Deals with such work as:
 * - resolves schema from annotated entities
 * - builds custom schemas with accounting base schema structure
 * - support nesting entities, maps
 */
public class ObjectHelper {
  private static List<Class> objects = RestObjectsConfig.getObjectClasses();
  private static Map<String, ObjectInfo> objectsDefinitions;

  static {
    // resolves available entities schema on first access
    buildSchemaDefinition();
  }

  /**
   * Returns the ObjectInfo.
   * @param object the object
   * @return ObjectInfo
   */
  public static ObjectInfo getObjectInfoFromClass(Class object) {
    ObjectDefinition objectDefinition = (ObjectDefinition) object.getAnnotation(ObjectDefinition.class);

    List<ObjectFieldInfo> objectFieldInfos = Arrays.stream(object.getDeclaredFields()).map(x -> {
      try {
        ObjectFieldDefinition objectFieldDefinition = x.getAnnotation(ObjectFieldDefinition.class);
        String name = (objectFieldDefinition.FieldName().isEmpty())
        ? x.getAnnotation(SerializedName.class).value()
        : objectFieldDefinition.FieldName();

        return new ObjectFieldInfo(name, objectFieldDefinition.FieldType(), objectFieldDefinition.NestedClass());
      } catch (NullPointerException e) {
        return null;  // Ignore non-annotated fields
      }
    }).filter(Objects::nonNull).collect(Collectors.toList());
    return new ObjectInfo(
        objectDefinition.Name(),
        objectFieldInfos,
        objectDefinition.APIUrl(),
        object,
        Arrays.asList(objectDefinition.RequiredArguments()),
        Arrays.asList(objectDefinition.RequiredPostArguments()),
        objectDefinition.responseRootElement(),
        objectDefinition.ObjectType()
    );
  }

  /**
   * Create schema definition for annotated objects.
   */
  private static void buildSchemaDefinition() {
    if (objectsDefinitions != null) {
      return;
    }
    ImmutableMap.Builder<String, ObjectInfo> builder = new ImmutableMap.Builder<>();
    objects.forEach(object -> {
      try {
        builder.put(object.getName(), getObjectInfoFromClass(object));
      } catch (NullPointerException e) {
        throw new RuntimeException(String.format("Object with name %s not annotated with %s", object.getName(),
            ObjectDefinition.class.getName()));
      }
    });
    objectsDefinitions = builder.build();
  }

  /**
   * Returns the list of string.
   * @return list of string
   */
  public static List<String> getObjectNames() {
    return objectsDefinitions.values().stream()
        .filter(x -> x.getObjectType() == ObjectDefinition.ObjectDefinitionType.BASE)
        .map(ObjectInfo::getCdapObjectName)
        .collect(Collectors.toList());
  }

  /**
   * Provides entity schema definition.
   *
   * @param objectClass entity class, which derived from {@link BaseObject}
   */
  public static ObjectInfo getObjectInfo(Class objectClass) {
    return objectsDefinitions.get(objectClass.getName());
  }

  /**
   * Provides entity schema definition.
   *
   * @param internalObjectName the name, provided via {@link ObjectDefinition#Name()}
   */
  @Nullable
  public static ObjectInfo getObjectInfo(String internalObjectName) {
    return objectsDefinitions.values().stream()
        .filter(x -> !Strings.isNullOrEmpty(x.getCdapObjectName()) && x.getCdapObjectName().equals(internalObjectName))
        .findFirst()
        .orElse(null);
  }

  /**
   * Provides schema definition for desired entities with only desired fields included.
   *
   * @param internalObjectName the name, provided via {@link ObjectDefinition#Name()}
   * @param requestedFields    the names, provided via {@link SerializedName#value()}
   * @return CDAP Schema
   */
  public static Schema buildSchema(List<String> internalObjectName, @Nullable List<String> requestedFields) {
    return buildSchema(internalObjectName, requestedFields, false);
  }

  /**
   * Provides schema definition for desired entities with only desired fields included.
   * <p>
   * For single requested object:
   * Schema generator creates plain schema, where each field represents as column
   * and whole schema describes only one entity
   * <p>
   * For multi-object request:
   * Schema generator creates additional top-level holder, where each column represents
   * separate requested entity
   *
   * @param internalObjectName the name, provided via {@link ObjectDefinition#Name()}
   * @param requestedFields    the names, provided via {@link SerializedName#value()}
   * @param alwaysMultiObject  regulates how to generate schema if only one entity is requested
   * @return CDAP Schema
   */
  public static Schema buildSchema(List<String> internalObjectName, @Nullable List<String> requestedFields,
                                   boolean alwaysMultiObject) {
    // generate simple schema for the single object
    if (!alwaysMultiObject && internalObjectName.size() == 1) {
      return buildSchema(internalObjectName.get(0), requestedFields);
    }

    List<Schema.Field> fields = new ArrayList<>();

    internalObjectName.forEach(object -> {
      List<Schema.Field> objectFields = buildSchema(object, requestedFields).getFields();
      Schema.Field field = Schema.Field.of(object, Schema.recordOf(object, Objects.requireNonNull(objectFields)));

      fields.add(field);
    });

    return Schema.recordOf("output", fields);
  }

  /**
   * Provides schema definition for entity with only desired fields included.
   *
   * @param internalObjectName the name, provided via {@link ObjectDefinition#Name()}
   * @param requestedFields    the names, provided via {@link SerializedName#value()}
   * @return CDAP Schema
   */
  public static Schema buildSchema(String internalObjectName, @Nullable List<String> requestedFields) {
    ObjectInfo objectInfo = getObjectInfo(internalObjectName);

    if (objectInfo == null) {
      return Schema.recordOf(internalObjectName);
    }

    List<ObjectFieldInfo> fieldInfos;

    if (requestedFields == null || requestedFields.isEmpty()) {
      fieldInfos = objectInfo.getFieldDefinitions();
    } else {
      fieldInfos = objectInfo.getFieldsDefinitions(requestedFields);
      if (fieldInfos.isEmpty()) {  // if user selected no fields belonging to current object, show all fields
        fieldInfos = objectInfo.getFieldDefinitions();
      }
    }

    List<Schema.Field> cdapFields = fieldInfos.stream()
        .map(x -> {
          if (x.getType() == Schema.Type.MAP) {
            if (Strings.isNullOrEmpty(x.getNestedClassName())) {
              throw new IllegalArgumentException(String.format("Nested class is not declared for the field %s",
                  x.getName()));
            }
            List<Schema.Field> nestedFields = buildSchema(x.getNestedClassName(), requestedFields).getFields();

            return Schema.Field.of(x.getName(),
                Schema.recordOf(x.getName(), Objects.requireNonNull(nestedFields))
            );
          }
          if (x.getType() == Schema.Type.ARRAY) {
            if (Strings.isNullOrEmpty(x.getNestedClassName())) {
              throw new IllegalArgumentException(String.format("Nested class is not declared for the field %s",
                  x.getName()));
            }
            List<Schema.Field> nestedFields = buildSchema(x.getNestedClassName(), requestedFields).getFields();
            return Schema.Field.of(x.getName(),
                Schema.arrayOf(
                    Schema.recordOf(x.getName(), Objects.requireNonNull(nestedFields))
                )
            );
          }
          return Schema.Field.of(x.getName(), Schema.nullableOf(Schema.of(x.getType())));
        })
        .collect(Collectors.toList());

    return (cdapFields.isEmpty())
        ? Schema.recordOf(objectInfo.getCdapObjectName())
        : Schema.recordOf(objectInfo.getCdapObjectName(), cdapFields);
  }

  /**
   * Alter existing schema with new fields.
   *
   * @param internalObjectName cdap object name
   * @param oldSchema schema to alter
   * @param newFields fields to be added to the schema
   * @return new schema
   */
  public static Schema alterSchema(String internalObjectName, Schema oldSchema,
                                   List<Pair<String, Schema.Type>> newFields) {

    List<Schema.Field> fields = new ArrayList<>(Objects.requireNonNull(oldSchema.getFields()));
    newFields.forEach(x -> {
      fields.add(0, Schema.Field.of(x.getKey(), Schema.nullableOf(Schema.of(x.getValue()))));
    });
    return Schema.recordOf(internalObjectName, fields);
  }
}
