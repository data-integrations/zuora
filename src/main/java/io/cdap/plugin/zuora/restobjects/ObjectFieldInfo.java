/*
 * Copyright © 2019 Cask Data, Inc.
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

import io.cdap.cdap.api.data.schema.Schema;
import io.cdap.plugin.zuora.restobjects.annotations.ObjectFieldDefinition;

/**
 *  Entity meta-info holder for the {@link ObjectFieldDefinition} annotation
 */
public class ObjectFieldInfo {
  private String name;
  private Schema.Type type;
  private String nestedClass;

  public ObjectFieldInfo(String name, Schema.Type type, String nestedClass) {
    this.name = name;
    this.type = type;
    this.nestedClass = nestedClass;
  }

  public String getName() {
    return name;
  }

  public Schema.Type getType() {
    return type;
  }

  public String getNestedClassName() {
    return nestedClass;
  }
}
