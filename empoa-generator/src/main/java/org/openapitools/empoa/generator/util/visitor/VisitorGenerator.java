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
package org.openapitools.empoa.generator.util.visitor;

import java.io.IOException;
import java.util.List;

import org.openapitools.empoa.generator.Input;
import org.openapitools.empoa.generator.util.ElementComparator;
import org.openapitools.empoa.specs.Element;
import org.openapitools.empoa.util.FileUtil;
import org.openapitools.empoa.util.StringUtil;

public class VisitorGenerator {

    static final String VISITOR_INTERFACE_NAME = "OASVisitor";
    private List<Element> elements;
    private Input input;

    public VisitorGenerator(List<Element> elements, Input input) {
        this.elements = elements;
        this.input = input;
    }

    public String generateContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("package " + input.rootPackage + ";\n");
        sb.append("\n");
        for (Element element : elements) {
            sb.append("import " + element.fqName + ";\n");
        }
        sb.append("\n");
        sb.append("public interface " + VISITOR_INTERFACE_NAME);
        sb.append(" {\n");
        sb.append("\n");
        elements.stream()
            .sorted(new ElementComparator())
            .forEach(element -> {
                String simpleName = StringUtil.computeSimpleName(element.fqName);
                sb.append("    OpenAPIVisitResult visit(" + simpleName + " " + StringUtil.decapitalize(simpleName) + ", String jsonPath);\n");
                sb.append("\n");
            });
        sb.append("}\n");

        return sb.toString();
    }

    public void writeFile() throws IOException {
        FileUtil.writeJavaClass(input.srcFolder, input.rootPackage, VISITOR_INTERFACE_NAME, generateContent());
    }

}
