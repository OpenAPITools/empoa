/*******************************************************************************
 * Copyright 2022 Jeremie Bresson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package org.openapitools.empoa.generator.tck;

import org.openapitools.empoa.specs.OpenAPISpec;
import org.openapitools.empoa.util.StringUtil;

public class TckAbstractElementSerializerGeneratorMain {

    public static void main(String[] args) throws Exception {
        OpenAPISpec.elements()
            .stream()
            .map(element -> StringUtil.computeSimpleName(element.fqName))
            .forEach(simpleName -> {
                String v = StringUtil.decapitalize(simpleName);
                System.out.println(
                    ""
                        + "    @Test\n"
                        + "    public void test" + simpleName + "ToJson() throws Exception {\n"
                        + "        " + simpleName + " " + v + " = OASElement.create" + simpleName + "();\n"
                        + "        String json = convertToJson(" + v + ");\n"
                        + "\n"
                        + "        assertThatJson(json).isEqualTo(readExpected(\"" + simpleName + "\"));\n"
                        + "    }\n"
                );
            }
            );
    }

}
