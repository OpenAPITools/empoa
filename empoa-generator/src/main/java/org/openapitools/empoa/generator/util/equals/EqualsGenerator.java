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

import org.eclipse.microprofile.openapi.models.media.MediaType;
import org.openapitools.empoa.generator.Input;
import org.openapitools.empoa.generator.util.ElementComparator;
import org.openapitools.empoa.specs.Element;
import org.openapitools.empoa.specs.IMember;
import org.openapitools.empoa.specs.ListMember;
import org.openapitools.empoa.specs.MapMember;
import org.openapitools.empoa.specs.Member;
import org.openapitools.empoa.util.FileUtil;
import org.openapitools.empoa.util.StringUtil;

public class EqualsGenerator {

    static final String EQUALS_CLASS_NAME = "OASEquals";
    private List<Element> elements;
    private Input input;

    public EqualsGenerator(List<Element> elements, Input input) {
        this.elements = elements;
        this.input = input;
    }

    public String generateContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("package " + input.rootPackage + ";\n");
        sb.append("\n");
        sb.append("import java.math.BigDecimal;\n");
        sb.append("import java.util.List;\n");
        sb.append("import java.util.Map;\n");
        sb.append("import java.util.Map.Entry;\n");
        sb.append("import java.util.Objects;\n");
        sb.append("\n");
        sb.append("import org.eclipse.microprofile.openapi.OASFactory;\n");
        for (Element element : elements) {
            sb.append("import " + element.fqName + ";\n");
        }
        sb.append("\n");
        sb.append("public class " + EQUALS_CLASS_NAME);
        sb.append(" {\n");
        sb.append("\n");
        elements.stream()
            .sorted(new ElementComparator())
            .forEach(element -> {
                String simpleName = simpleName(element.fqName);
                sb.append("    public static boolean equals(" + simpleName + " a, " + simpleName + " b) {\n");
                sb.append("        if (a == null) {\n");
                sb.append("            return b == null;\n");
                sb.append("        }\n");
                sb.append("        if (b == null) {\n");
                sb.append("            return false;\n");
                sb.append("        }\n");
                if (element.referenceable) {
                    sb.append("        if (!Objects.equals(a.getRef(), b.getRef())) {\n");
                    sb.append("            return false;\n");
                    sb.append("        }\n");
                }
                for (IMember m : element.members) {
                    if (m instanceof MapMember) {
                        MapMember member = (MapMember) m;
                        String valueType = simpleName(member.valueFqType);
                        if (isMp(member.valueFqType)) {
                            String aName = "a" + member.name;
                            String bName = "b" + member.name;
                            sb.append("        Map<String, " + valueType + "> " + aName + " = a." + member.getterName + "();\n");
                            sb.append("        Map<String, " + valueType + "> " + bName + " = b." + member.getterName + "();\n");
                            sb.append("        if (" + aName + " == null && " + bName + " != null) {\n");
                            sb.append("            return false;\n");
                            sb.append("        } else if(" + aName + " != null && " + bName + " == null) {\n");
                            sb.append("            return false;\n");
                            sb.append("        } else if(" + aName + " != null && " + bName + " != null) {\n");
                            sb.append("            if(" + aName + ".size() != " + bName + ".size()) {\n");
                            sb.append("                return false;\n");
                            sb.append("            }\n");
                            sb.append("            if(!Objects.equals(" + aName + ".keySet(), " + bName + ".keySet())) {\n");
                            sb.append("                return false;\n");
                            sb.append("            }\n");
                            sb.append("            for (String key : " + aName + ".keySet()) {\n");
                            sb.append("                if (!equals(" + aName + ".get(key), " + bName + ".get(key))) {\n");
                            sb.append("                    return false;\n");
                            sb.append("                }\n");
                            sb.append("            }\n");
                            sb.append("        }\n");
                        } else {
                            sb.append("        if (!Objects.equals(a." + member.getterName + "(), b." + member.getterName + "())) {\n");
                            sb.append("            return false;");
                            sb.append("        }\n");
                        }
                    } else if (m instanceof ListMember) {
                        ListMember member = (ListMember) m;
                        String valueType = simpleName(member.itemFqType);
                        if (isMp(member.itemFqType)) {
                            String aName = "a" + member.name;
                            String bName = "b" + member.name;
                            sb.append("        List<" + valueType + "> " + aName + " = a." + member.getterName + "();\n");
                            sb.append("        List<" + valueType + "> " + bName + " = b." + member.getterName + "();\n");
                            sb.append("        if (" + aName + " == null && " + bName + " != null) {\n");
                            sb.append("            return false;\n");
                            sb.append("        } else if(" + aName + " != null && " + bName + " == null) {\n");
                            sb.append("            return false;\n");
                            sb.append("        } else if(" + aName + " != null && " + bName + " != null) {\n");
                            sb.append("            if(" + aName + ".size() != " + bName + ".size()) {\n");
                            sb.append("                return false;\n");
                            sb.append("            }\n");
                            sb.append("            for (int i = 0; i < " + aName + ".size(); i++) {\n");
                            sb.append("                if (!equals(" + aName + ".get(i), " + bName + ".get(i))) {\n");
                            sb.append("                    return false;\n");
                            sb.append("                }\n");
                            sb.append("            }\n");
                            sb.append("        }\n");
                        } else {
                            sb.append("        if (!Objects.equals(a." + member.getterName + "(), b." + member.getterName + "())) {\n");
                            sb.append("            return false;");
                            sb.append("        }\n");
                        }
                    } else if (m instanceof Member) {
                        Member member = (Member) m;
                        if (isMp(member.fqType) && !isMpEnum(member.fqType)) {
                            sb.append("        if (!equals(a." + member.getterName + "(), b." + member.getterName + "())) {\n");
                            sb.append("            return false;\n");
                            sb.append("        }\n");
                        } else {
                            sb.append("        if (!Objects.equals(a." + member.getterName + "(), b." + member.getterName + "())) {\n");
                            sb.append("            return false;\n");
                            sb.append("        }\n");
                        }
                    }
                }
                if (element.extensible) {
                    sb.append("        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {\n");
                    sb.append("            return false;\n");
                    sb.append("        }\n");
                }
                sb.append("        return true;\n");
                sb.append("    }\n");
                sb.append("\n");
            });
        sb.append("    private " + EQUALS_CLASS_NAME + "() {\n");
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

    private static boolean isMpEnum(String fqType) {
        if (MediaType.class.getCanonicalName()
            .equals(fqType)) {
            return false;
        }
        return isMp(fqType) && (fqType.endsWith("In") || fqType.endsWith("Style") || fqType.endsWith("Type"));
    }

    private String simpleName(String fqType) {
        String simpleName = StringUtil.computeSimpleName(fqType);
        if (simpleName.equals("In") || simpleName.equals("Style") || simpleName.equals("SchemaType") || simpleName.equals("Type")) {
            String outerSimpleName = StringUtil.computeSimpleName(fqType.substring(0, fqType.length() - simpleName.length() - 1));
            return outerSimpleName + "." + simpleName;
        }
        return simpleName;
    }

}
