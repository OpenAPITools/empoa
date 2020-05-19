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

public class CopyGenerator {

    static final String COPY_CLASS_NAME = "OASCopy";
    private List<Element> elements;
    private Input input;

    public CopyGenerator(List<Element> elements, Input input) {
        this.elements = elements;
        this.input = input;
    }

    public String generateContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("package " + input.rootPackage + ";\n");
        sb.append("\n");
        sb.append("import java.util.List;\n");
        sb.append("import java.util.Map;\n");
        sb.append("import java.util.Map.Entry;\n");
        sb.append("\n");
        sb.append("import org.eclipse.microprofile.openapi.OASFactory;\n");
        for (Element element : elements) {
            sb.append("import " + element.fqName + ";\n");
        }
        sb.append("\n");
        sb.append("public class " + COPY_CLASS_NAME);
        sb.append(" {\n");
        sb.append("\n");
        elements.stream()
            .sorted(new ElementComparator())
            .forEach(element -> {
                String simpleName = StringUtil.computeSimpleName(element.fqName);
                sb.append("    public static " + simpleName + " copy(" + simpleName + " from) {\n");
                sb.append("        if (from == null) {\n");
                sb.append("            return null;\n");
                sb.append("        }\n");
                sb.append("        " + simpleName + " to = OASFactory.create" + simpleName + "();\n");
                if (element.referenceable) {
                    sb.append("        to.setRef(from.getRef());\n");
                }
                for (IMember m : element.members) {
                    if (m instanceof MapMember) {
                        MapMember member = (MapMember) m;
                        String valueType = StringUtil.computeSimpleName(member.valueFqType);
                        String mapName = StringUtil.decapitalize(member.name);
                        sb.append("        Map<String, " + valueType + "> " + mapName + " = from." + member.getterName + "();\n");
                        sb.append("        if (" + mapName + " != null) {\n");
                        sb.append("            for (Entry<String, " + valueType + "> entry : " + mapName + ".entrySet()) {\n");
                        if (isMp(member.valueFqType)) {
                            sb.append("                to." + member.addName + "(entry.getKey(), copy(entry.getValue()));\n");
                        } else {
                            sb.append("                to." + member.addName + "(entry.getKey(), entry.getValue());\n");
                        }
                        sb.append("            }\n");
                        sb.append("        }\n");
                    } else if (m instanceof ListMember) {
                        ListMember member = (ListMember) m;
                        String valueType = StringUtil.computeSimpleName(member.itemFqType);
                        String listName = StringUtil.decapitalize(member.name);
                        sb.append("        List<" + valueType + "> " + listName + " = from." + member.getterName + "();\n");
                        sb.append("        if (" + listName + " != null) {\n");
                        sb.append("            for (" + valueType + " item : " + listName + ") {\n");
                        if (isMp(member.itemFqType)) {
                            sb.append("                to." + member.addName + "(copy(item));\n");
                        } else {
                            sb.append("                to." + member.addName + "(item);\n");
                        }
                        sb.append("            }\n");
                        sb.append("        }\n");
                    } else if (m instanceof Member) {
                        Member member = (Member) m;
                        if (isMp(member.fqType) && !isMpEnum(member.fqType)) {
                            sb.append("        to." + member.setterName + "(copy(from." + member.getterName + "()));\n");
                        } else {
                            sb.append("        to." + member.setterName + "(from." + member.getterName + "());\n");
                        }
                    }
                }
                if (element.extensible) {
                    sb.append("        Map<String, Object> extensions = from.getExtensions();\n");
                    sb.append("        if (extensions != null) {\n");
                    sb.append("            for (Entry<String, Object> entry : extensions.entrySet()) {\n");
                    sb.append("                to.addExtension(entry.getKey(), entry.getValue());\n");
                    sb.append("            }\n");
                    sb.append("        }\n");
                }
                sb.append("        return to;\n");
                sb.append("    }");
                sb.append("\n");
            });
        sb.append("    private " + COPY_CLASS_NAME + "() {\n");
        sb.append("    }\n");
        sb.append("}\n");

        return sb.toString();
    }

    public void writeFile() throws IOException {
        FileUtil.writeJavaClass(input.srcFolder, input.rootPackage, COPY_CLASS_NAME, generateContent());
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

}
