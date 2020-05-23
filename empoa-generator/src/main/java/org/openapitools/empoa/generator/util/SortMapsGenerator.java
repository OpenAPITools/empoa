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
package org.openapitools.empoa.generator.util;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.openapitools.empoa.generator.Input;
import org.openapitools.empoa.specs.Element;
import org.openapitools.empoa.specs.MapMember;
import org.openapitools.empoa.util.FileUtil;
import org.openapitools.empoa.util.StringUtil;

public class SortMapsGenerator {

    static final String CLASS_NAME = "SortMapsVisitor";
    private Map<Element, List<MapMember>> map;
    private Input input;

    public SortMapsGenerator(Map<Element, List<MapMember>> map, Input input) {
        this.map = map;
        this.input = input;
    }

    public String generateContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("package " + input.rootPackage + ";\n");
        sb.append("\n");
        sb.append("import java.util.TreeMap;\n");
        sb.append("\n");
        map.keySet()
            .stream()
            .sorted(Comparator.comparing(e -> e.fqName))
            .forEach(element -> {
                sb.append("import " + element.fqName + ";\n");
            });
        sb.append("import org.openapitools.empoa.util.visitor.OASVisitResult;\n");
        sb.append("import org.openapitools.empoa.util.visitor.OASVisitorAdapter;\n");
        sb.append("\n");
        sb.append("class " + CLASS_NAME);
        sb.append(" extends OASVisitorAdapter {\n");
        sb.append("\n");
        sb.append("    private " + SortMapsConfigGenerator.CLASS_NAME + " config;\n");
        sb.append("\n");
        sb.append("    " + CLASS_NAME + "(" + SortMapsConfigGenerator.CLASS_NAME + " config) {\n");
        sb.append("        this.config = config;\n");
        sb.append("    }\n");
        sb.append("\n");
        map.entrySet()
            .stream()
            .sorted(Comparator.comparing(Map.Entry::getKey, new ElementComparator()))
            .forEach(entry -> {
                Element element = entry.getKey();
                String simpleName = StringUtil.computeSimpleName(element.fqName);
                String varName = StringUtil.decapitalize(simpleName);
                sb.append("    @Override\n");
                sb.append("    public OASVisitResult visit(" + simpleName + " " + varName + ", String jsonPath) {\n");
                for (MapMember member : entry.getValue()) {
                    sb.append("        if (config.get" + booleanName(element, member) + "() && " + varName + "." + member.getterName + "() != null) {\n");
                    sb.append("            " + varName + "." + member.setterName + "(new TreeMap<>(" + varName + "." + member.getterName + "()));\n");
                    sb.append("        }\n");
                }
                sb.append("        return OASVisitResult.CONTINUE;\n");
                sb.append("    }\n");
                sb.append("\n");
            });
        sb.append("}\n");

        return sb.toString();
    }

    private String booleanName(Element e, MapMember member) {
        return "Sort" + e.type.name() + member.name;
    }

    public void writeFile() throws IOException {
        FileUtil.writeJavaClass(input.srcFolder, input.rootPackage, CLASS_NAME, generateContent());
    }
}
