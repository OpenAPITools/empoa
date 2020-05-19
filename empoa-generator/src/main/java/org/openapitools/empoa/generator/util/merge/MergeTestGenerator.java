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
package org.openapitools.empoa.generator.util.merge;

import java.io.IOException;
import java.util.List;

import org.openapitools.empoa.generator.Input;
import org.openapitools.empoa.generator.util.ElementComparator;
import org.openapitools.empoa.specs.Element;
import org.openapitools.empoa.util.FileUtil;
import org.openapitools.empoa.util.StringUtil;

public class MergeTestGenerator {

    static final String EQUALS_CLASS_NAME = "OASMergeTest";
    private List<Element> elements;
    private Input input;

    public MergeTestGenerator(List<Element> elements, Input input) {
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
        sb.append("import org.openapitools.empoa.gson.OASGsonSerializer;\n");
        sb.append("\n");
        sb.append("import com.google.gson.Gson;\n");
        sb.append("\n");
        sb.append("public class " + EQUALS_CLASS_NAME);
        sb.append(" {\n");
        sb.append("\n");
        elements.stream()
            .sorted(new ElementComparator())
            .forEach(element -> {
                String simpleName = StringUtil.computeSimpleName(element.fqName);
                sb.append("    @Test\n");
                sb.append("    public void testMerge" + simpleName + "() throws Exception {\n");
                sb.append("        " + simpleName + " from1 = OASTestFactory.createTest" + simpleName + "();\n");
                sb.append("        " + simpleName + " into1 = OASFactory.create" + simpleName + "();\n");
                sb.append("        OASMerge.merge(from1, into1);\n");
                sb.append("        asJsonIsEqualTo(from1, into1);\n");
                sb.append("\n");
                sb.append("        " + simpleName + " from2 = OASFactory.create" + simpleName + "();\n");
                sb.append("        " + simpleName + " into2 = OASTestFactory.createTest" + simpleName + "();\n");
                sb.append("        OASMerge.merge(from2, into2);\n");
                sb.append("\n");
                sb.append("        " + simpleName + " from3 = OASTestFactory.createTest" + simpleName + "();\n");
                sb.append("        " + simpleName + " into3 = OASTestFactory.createTest" + simpleName + "();\n");
                sb.append("        OASMerge.merge(from3, into3);\n");
                sb.append("        asJsonIsEqualTo(from3, into3);\n");
                sb.append("    }\n");
                sb.append("\n");
            });
        sb.append("    private void asJsonIsEqualTo(Object a, Object b) {\n");
        sb.append("        Gson gson = OASGsonSerializer.instance();\n");
        sb.append("        String aJson = gson.toJson(a);\n");
        sb.append("        String bJson = gson.toJson(b);\n");
        sb.append("        assertThat(bJson).isEqualTo(aJson);\n");
        sb.append("    }\n");
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
