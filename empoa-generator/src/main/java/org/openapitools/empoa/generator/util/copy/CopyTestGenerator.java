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
package org.openapitools.empoa.generator.util.copy;

import java.io.IOException;
import java.util.List;

import org.openapitools.empoa.generator.Input;
import org.openapitools.empoa.generator.util.ElementComparator;
import org.openapitools.empoa.specs.Element;
import org.openapitools.empoa.util.FileUtil;
import org.openapitools.empoa.util.StringUtil;

public class CopyTestGenerator {

    static final String COPY_CLASS_NAME = "OASCopyTest";
    private List<Element> elements;
    private Input input;

    public CopyTestGenerator(List<Element> elements, Input input) {
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
        sb.append("import org.openapitools.empoa.extended.tck.specs.BigSpec;\n");
        sb.append("\n");
        sb.append("public class " + COPY_CLASS_NAME);
        sb.append(" {\n");
        sb.append("\n");
        elements.stream()
            .sorted(new ElementComparator())
            .forEach(element -> {
                String simpleName = StringUtil.computeSimpleName(element.fqName);
                sb.append("    @Test\n");
                sb.append("    public void testCopy" + simpleName + "() throws Exception {\n");
                sb.append("        " + simpleName + " original1 = OASFactory.create" + simpleName + "();\n");
                sb.append("        " + simpleName + " copy1 = OASCopy.copy(original1);\n");
                sb.append("        assertThat(copy1).isNotSameAs(original1);\n");
                sb.append("        assertThat(OASEquals.equals(original1, copy1)).isTrue();\n");
                sb.append("\n");
                sb.append("        " + simpleName + " original2 = OASTestFactory.createTest" + simpleName + "();\n");
                sb.append("        " + simpleName + " copy2 = OASCopy.copy(original2);\n");
                sb.append("        assertThat(copy2).isNotSameAs(original2);\n");
                sb.append("        assertThat(OASEquals.equals(original2, copy2)).isTrue();\n");
                sb.append("    }\n");
                sb.append("\n");
            });
        sb.append("}\n");

        return sb.toString();
    }

    public void writeFile() throws IOException {
        FileUtil.writeJavaClass(input.srcFolder, input.rootPackage, COPY_CLASS_NAME, generateContent());
    }

    private static boolean isMp(String fqType) {
        return fqType.startsWith("org.eclipse.microprofile");
    }

}
