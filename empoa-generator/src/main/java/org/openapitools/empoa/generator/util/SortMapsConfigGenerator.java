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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openapitools.empoa.generator.Input;
import org.openapitools.empoa.specs.Element;
import org.openapitools.empoa.specs.MapMember;
import org.openapitools.empoa.util.FileUtil;
import org.openapitools.empoa.util.StringUtil;

public class SortMapsConfigGenerator {

    static final String CLASS_NAME = "SortMapsConfig";
    private Map<Element, List<MapMember>> map;
    private Input input;

    public SortMapsConfigGenerator(Map<Element, List<MapMember>> map, Input input) {
        this.map = map;
        this.input = input;
    }

    public String generateContent() {
        List<String> booleans = new ArrayList<String>();
        for (Map.Entry<Element, List<MapMember>> entry : map.entrySet()) {
            Element e = entry.getKey();
            for (MapMember member : entry.getValue()) {
                booleans.add(booleanName(e, member));
            }
        }
        Collections.sort(booleans);

        StringBuilder sb = new StringBuilder();
        sb.append("package " + input.rootPackage + ";\n");
        sb.append("\n");
        sb.append("public class " + CLASS_NAME);
        sb.append(" {\n");
        sb.append("\n");
        for (String b : booleans) {
            sb.append("    private boolean " + b + " = true;\n");
        }
        sb.append("\n");
        for (String b : booleans) {
            sb.append("    public boolean get" + StringUtil.capitalize(b) + "() {\n");
            sb.append("        return " + b + ";\n");
            sb.append("    }\n");
            sb.append("\n");
            sb.append("    public void set" + StringUtil.capitalize(b) + "(boolean value) {\n");
            sb.append("        " + b + " = value;\n");
            sb.append("    }\n");
            sb.append("\n");
            sb.append("    public " + CLASS_NAME + " " + b + "(boolean value) {\n");
            sb.append("        " + b + " = value;\n");
            sb.append("        return this;\n");
            sb.append("    }\n");
            sb.append("\n");
        }
        sb.append("}\n");

        return sb.toString();
    }

    private String booleanName(Element e, MapMember member) {
        return "sort" + e.type.name() + member.name;
    }

    public void writeFile() throws IOException {
        FileUtil.writeJavaClass(input.srcFolder, input.rootPackage, CLASS_NAME, generateContent());
    }
}
