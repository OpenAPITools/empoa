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
import java.util.ArrayList;
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

public class AcceptGenerator {

    private static final String ACCEPT_CLASS_NAME = "OASAccept";
    private List<Element> elements;
    private Input input;

    public AcceptGenerator(List<Element> elements, Input input) {
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
        for (Element element : elements) {
            sb.append("import " + element.fqName + ";\n");
        }
        sb.append("\n");
        sb.append("public class " + ACCEPT_CLASS_NAME);
        sb.append(" {\n");
        sb.append("\n");
        elements.stream()
            .sorted(new ElementComparator())
            .forEach(element -> {
                String simpleName = StringUtil.computeSimpleName(element.fqName);
                String varName = StringUtil.decapitalize(simpleName);
                sb.append("    public static void accept(" + VisitorGenerator.VISITOR_INTERFACE_NAME + " visitor, " + simpleName + " " + varName + ") {\n");
                sb.append("        accept(visitor, " + varName + ", \"$\");\n");
                sb.append("    }\n");
                sb.append("\n");
                sb.append("    public static void accept(" + VisitorGenerator.VISITOR_INTERFACE_NAME + " visitor, " + simpleName + " " + varName + ", String jsonPath) {\n");
                List<Member> acceptMembers = new ArrayList<>();
                List<ListMember> listMembers = new ArrayList<>();
                List<MapMember> mapMembers = new ArrayList<>();
                for (IMember m : element.members) {
                    if (m instanceof MapMember) {
                        MapMember member = (MapMember) m;
                        if (isMp(member.valueFqType) && !isMpEnum(member.valueFqType)) {
                            mapMembers.add(member);
                        }
                    } else if (m instanceof ListMember) {
                        ListMember member = (ListMember) m;
                        if (isMp(member.itemFqType) && !isMpEnum(member.itemFqType)) {
                            listMembers.add(member);
                        }
                    } else if (m instanceof Member) {
                        Member member = (Member) m;
                        if (isMp(member.fqType) && !isMpEnum(member.fqType)) {
                            acceptMembers.add(member);
                        }
                    }
                }
                sb.append("        if (" + varName + " != null) {\n");
                if (listMembers.isEmpty() && mapMembers.isEmpty() && acceptMembers.isEmpty()) {
                    sb.append("            visitor.visit(" + varName + ", jsonPath);\n");
                } else {
                    sb.append("            OpenAPIVisitResult result = visitor.visit(" + varName + ", jsonPath);\n");
                    sb.append("            if (result == OpenAPIVisitResult.CONTINUE) {\n");
                    for (MapMember member : mapMembers) {
                        String valueType = StringUtil.computeSimpleName(member.valueFqType);
                        String mapName = StringUtil.decapitalize(member.name);
                        if (mapName.equals(varName)) {
                            mapName = "map";
                        }
                        sb.append("                Map<String, " + valueType + "> " + mapName + " = " + varName + "." + member.getterName + "();\n");
                        sb.append("                if (" + mapName + " != null) {\n");
                        sb.append("                    for (Entry<String, " + valueType + "> item : " + mapName + ".entrySet()) {\n");
                        sb.append("                        accept(visitor, item.getValue(), jsonPath + \"" + computeOASJsonPath(member) + ".['\" + item.getKey() + \"']\");\n");
                        sb.append("                    }\n");
                        sb.append("                }\n");

                    }
                    for (ListMember member : listMembers) {
                        String valueType = StringUtil.computeSimpleName(member.itemFqType);
                        String listName = StringUtil.decapitalize(member.name);
                        sb.append("                List<" + valueType + "> " + listName + " = " + varName + "." + member.getterName + "();\n");
                        sb.append("                if (" + listName + " != null) {\n");
                        sb.append("                    for (int i = 0; i < " + listName + ".size(); i++) {\n");
                        sb.append("                        " + valueType + " item = " + listName + ".get(i);\n");
                        sb.append("                        accept(visitor, item, jsonPath + \"" + computeOASJsonPath(member) + "[\" + i + \"]\");\n");
                        sb.append("                    }\n");
                        sb.append("                }\n");
                    }
                    for (Member member : acceptMembers) {
                        sb.append("                accept(visitor, " + varName + "." + member.getterName + "(), jsonPath + \"" + computeOASJsonPath(member) + "\");\n");
                    }
                    sb.append("            }\n");
                }
                sb.append("        }\n");
                sb.append("    }\n");
                sb.append("\n");
            });
        sb.append("}\n");

        return sb.toString();
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

    public void writeFile() throws IOException {
        FileUtil.writeJavaClass(input.srcFolder, input.rootPackage, ACCEPT_CLASS_NAME, generateContent());
    }

    private String computeOASJsonPath(Member member) {
        switch (member.type) {
        case Paths_PathItems:
        case Callback_PathItems:
        case Content_MediaTypes:
        case APIResponses_APIResponses:
        case Scopes_Scopes:
        case SecurityRequirement_Schemes:
        case ServerVariables_ServerVariables:
            return "";
        default:
            String name = member.getterName.replace("get", "");
            if ("Enumeration".equals(name)) {
                return ".enum";
            } else if (name.toUpperCase()
                .equals(name)) {
                return "." + name.toLowerCase();
            }
            return "." + StringUtil.decapitalize(name);
        }

    }

}
