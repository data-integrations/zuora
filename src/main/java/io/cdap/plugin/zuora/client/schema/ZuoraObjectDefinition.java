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

package io.cdap.plugin.zuora.client.schema;

import io.cdap.plugin.zuora.client.ZuoraRestClient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Object item
 */
public class ZuoraObjectDefinition {

  @XmlAttribute(name = "href")
  private String href;

  @XmlElement(name = "name")
  private String name;

  @XmlElement(name = "label")
  private String label;


  public String getName() {
    return name;
  }

  public String getLabel() {
    return label;
  }

  public String getHref() {
    return href;
  }

  public String getObjectEndpoint() {
    return String.format("%s/%s", ZuoraRestClient.DESCRIBE_API, name);
  }
}
