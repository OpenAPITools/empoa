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

public class MergeGenerator {

    static final String MERGE_CLASS_NAME = "OASMerge";
    private List<Element> elements;
    private Input input;

    public MergeGenerator(List<Element> elements, Input input) {
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
        sb.append("\n");
        sb.append("import org.eclipse.microprofile.openapi.OASFactory;\n");
        for (Element element : elements) {
            sb.append("import " + element.fqName + ";\n");
        }
        sb.append("import org.openapitools.empoa.util.copy.OASCopy;\n");
        sb.append("import org.openapitools.empoa.util.equals.OASEquals;\n");
        sb.append("\n");
        sb.append("public class " + MERGE_CLASS_NAME);
        sb.append(" {\n");
        sb.append("\n");
        elements.stream()
            .sorted(new ElementComparator())
            .forEach(element -> {
                String simpleName = simpleName(element.fqName);
                sb.append("    public static void merge(" + simpleName + " from, " + simpleName + " into) {\n");
                sb.append("        if (into == null) {\n");
                sb.append("            throw new IllegalArgumentException(\"" + simpleName + " 'into' parameter can not be null\");\n");
                sb.append("        }\n");
                sb.append("        if (from != null) {\n");
                if (element.referenceable) {
                    sb.append("            String fromRef = from.getRef();\n");
                    sb.append("            if (fromRef != null) {\n");
                    sb.append("                into.setRef(fromRef);\n");
                    sb.append("            }\n");
                }
                for (IMember m : element.members) {
                    if (m instanceof MapMember) {
                        MapMember member = (MapMember) m;
                        String valueType = simpleName(member.valueFqType);
                        String fromName = "from" + member.name;
                        sb.append("        Map<String, " + valueType + "> " + fromName + " = from." + member.getterName + "();\n");
                        sb.append("        if (" + fromName + " != null) {\n");
                        if (isMp(member.valueFqType)) {
                            String intoName = "into" + member.name;
                            sb.append("                Map<String, " + valueType + "> " + intoName + " = into." + member.getterName + "();\n");
                            sb.append("                if (" + intoName + " != null) {\n");
                            sb.append("                    for (Entry<String, " + valueType + "> entry : " + fromName + ".entrySet()) {\n");
                            sb.append("                        if (" + intoName + ".containsKey(entry.getKey())) {\n");
                            sb.append("                            merge(entry.getValue(), " + intoName + ".get(entry.getKey()));\n");
                            sb.append("                        } else {\n");
                            sb.append("                            into." + member.addName + "(entry.getKey(), OASCopy.copy(entry.getValue()));\n");
                            sb.append("                        }\n");
                            sb.append("                    }\n");
                            sb.append("                } else {\n");
                            sb.append("                    for (Entry<String, " + valueType + "> entry : " + fromName + ".entrySet()) {\n");
                            sb.append("                        into." + member.addName + "(entry.getKey(), OASCopy.copy(entry.getValue()));\n");
                            sb.append("                    }\n");
                            sb.append("                }\n");
                        } else {
                            sb.append("                for (Entry<String, " + valueType + "> entry : " + fromName + ".entrySet()) {\n");
                            sb.append("                    into." + member.addName + "(entry.getKey(), entry.getValue());\n");
                            sb.append("                }\n");
                        }
                        sb.append("        }\n");
                    } else if (m instanceof ListMember) {
                        ListMember member = (ListMember) m;
                        String valueType = simpleName(member.itemFqType);
                        String fromName = "from" + member.name;
                        String intoName = "into" + member.name;
                        sb.append("        List<" + valueType + "> " + fromName + " = from." + member.getterName + "();\n");
                        sb.append("        if (" + fromName + " != null) {\n");
                        sb.append("            List<" + valueType + "> " + intoName + " = into." + member.getterName + "();\n");
                        sb.append("            if (" + intoName + " != null) {\n");
                        sb.append("                for (" + valueType + " item : " + fromName + ") {\n");
                        if (isMp(member.itemFqType)) {
                            sb.append("                    if (!" + intoName + ".stream()\n");
                            sb.append("                        .anyMatch(i -> OASEquals.equals(i, item))) {\n");
                            sb.append("                            into." + member.addName + "(OASCopy.copy(item));\n");
                            sb.append("                    }\n");
                        } else {
                            sb.append("                    if (!" + intoName + ".contains(item)) {\n");
                            sb.append("                            into." + member.addName + "(item);\n");
                            sb.append("                    }\n");
                        }
                        sb.append("                }\n");
                        sb.append("            } else {\n");
                        sb.append("                for (" + valueType + " item : " + fromName + ") {\n");
                        if (isMp(member.itemFqType)) {
                            sb.append("                into." + member.addName + "(OASCopy.copy(item));\n");
                        } else {
                            sb.append("                into." + member.addName + "(item);\n");
                        }
                        sb.append("                }\n");
                        sb.append("            }\n");
                        sb.append("        }\n");
                    } else if (m instanceof Member) {
                        Member member = (Member) m;
                        String fromName = "from" + member.name;
                        String type = simpleName(member.fqType);
                        sb.append("            " + type + " " + fromName + " = from." + member.getterName + "();\n");
                        sb.append("            if (" + fromName + " != null) {\n");
                        if (isMp(member.fqType) && !isMpEnum(member.fqType)) {
                            String intoName = "into" + member.name;
                            sb.append("                " + type + " " + intoName + " = into." + member.getterName + "();\n");
                            sb.append("                if (" + intoName + " != null) {\n");
                            sb.append("                    merge(" + fromName + ", " + intoName + ");\n");
                            sb.append("                } else {\n");
                            sb.append("                   into." + member.setterName + "(OASCopy.copy(" + fromName + "));\n");
                            sb.append("                }\n");
                        } else {
                            sb.append("                into." + member.setterName + "(" + fromName + ");\n");
                        }
                        sb.append("            }\n");
                    }
                }
                if (element.extensible) {
                    sb.append("        Map<String, Object> extensions = from.getExtensions();\n");
                    sb.append("        if (extensions != null) {\n");
                    sb.append("            for (Entry<String, Object> entry : extensions.entrySet()) {\n");
                    sb.append("                into.addExtension(entry.getKey(), entry.getValue());\n");
                    sb.append("            }\n");
                    sb.append("        }\n");
                }
                sb.append("        }\n");
                sb.append("    }\n");
                sb.append("\n");
            });
        sb.append("    private " + MERGE_CLASS_NAME + "() {\n");
        sb.append("    }\n");
        sb.append("}\n");

        return sb.toString();
    }

    public void writeFile() throws IOException {
        FileUtil.writeJavaClass(input.srcFolder, input.rootPackage, MERGE_CLASS_NAME, generateContent());
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
