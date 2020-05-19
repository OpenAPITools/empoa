/*******************************************************************************
 * Copyright 2020 Jeremie Bresson
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
package org.openapitools.empoa.generator.util.equals;

import java.io.IOException;
import java.util.List;

import org.openapitools.empoa.generator.Input;
import org.openapitools.empoa.generator.util.ElementComparator;
import org.openapitools.empoa.specs.Element;
import org.openapitools.empoa.util.FileUtil;
import org.openapitools.empoa.util.StringUtil;

public class EqualsTestGenerator {

    static final String EQUALS_CLASS_NAME = "OASEqualsTest";
    private List<Element> elements;
    private Input input;

    public EqualsTestGenerator(List<Element> elements, Input input) {
        this.elements = elements;
        this.input = input;
    }

    public String generateContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("package " + input.rootPackage + ";\n");
        sb.append("\n");
        sb.append("import static org.assertj.core.api.Assertions.assertThat;\n");
        sb.append("\n");
        sb.append("import org.eclipse.microprofile.openapi.OASFactory;\n");
        for (Element element : elements) {
            sb.append("import " + element.fqName + ";\n");
        }
        sb.append("import org.junit.jupiter.api.Test;\n");
        sb.append("import org.openapitools.empoa.extended.tck.OASTestFactory;\n");
        sb.append("\n");
        sb.append("public class " + EQUALS_CLASS_NAME);
        sb.append(" {\n");
        sb.append("\n");
        elements.stream()
            .sorted(new ElementComparator())
            .forEach(element -> {
                String simpleName = StringUtil.computeSimpleName(element.fqName);
                sb.append("    @Test\n");
                sb.append("    public void testCopy" + simpleName + "() throws Exception {\n");
                sb.append("        " + simpleName + " a1 = OASFactory.create" + simpleName + "();\n");
                sb.append("        " + simpleName + " b1 = OASFactory.create" + simpleName + "();\n");
                sb.append("        assertThat(a1).isNotSameAs(b1);\n");
                sb.append("        assertThat(OASEquals.equals(a1, b1)).isTrue();\n");
                sb.append("\n");
                sb.append("        " + simpleName + " a2 = OASTestFactory.createTest" + simpleName + "();\n");
                sb.append("        " + simpleName + " b2 = OASTestFactory.createTest" + simpleName + "();\n");
                sb.append("        assertThat(a2).isNotSameAs(b2);\n");
                sb.append("        assertThat(OASEquals.equals(a2, b2)).isTrue();\n");
                sb.append("\n");
                sb.append("        assertThat(OASEquals.equals(a1, a2)).isFalse();\n");
                sb.append("    }\n");
                sb.append("\n");
            });
        sb.append("}\n");

        return sb.toString();
    }

    public void writeFile() throws IOException {
        FileUtil.writeJavaClass(input.srcFolder, input.rootPackage, EQUALS_CLASS_NAME, generateContent());
    }

    private static boolean isMp(String fqType) {
        return fqType.startsWith("org.eclipse.microprofile");
    }

}
