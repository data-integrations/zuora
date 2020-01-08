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
package io.cdap.plugin.zuora.restobjects.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines Entity Object with all related options which defines entity
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ObjectDefinition {
  /**
   *  Object definition type
   */
  enum ObjectDefinitionType {
    /**
     * Describes top-level object
     */
    BASE,

    /**
     * Describes object, designed to be used as part of another objects
     */
    NESTED,

    /**
     * Custom standalone object
     */
    CUSTOM
  }

  /**
   * Entity internal name
   */
  String Name() default "";

  /**
   * Relative API URI for the Entity
   */
  String APIUrl() default "";

  /**
   * List of argument names, required to made request
   */
  String[] RequiredArguments() default "";

  /**
   * List of argument names, required to made post request
   */
  String[] RequiredPostArguments() default "";

  /**
   * Root element of the response
   */
  String responseRootElement() default "";

  ObjectDefinitionType ObjectType() default ObjectDefinitionType.BASE;
}
