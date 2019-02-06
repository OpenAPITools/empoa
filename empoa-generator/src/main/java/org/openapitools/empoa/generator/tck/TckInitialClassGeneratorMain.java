/*******************************************************************************
 * Copyright 2019 Jeremie Bresson
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
package org.openapitools.empoa.generator.tck;

import java.io.IOException;
import java.nio.file.Paths;

import org.openapitools.empoa.specs.OpenAPISpec;
import org.openapitools.empoa.util.FileUtil;
import org.openapitools.empoa.util.StringUtil;

public class TckInitialClassGeneratorMain {
    public static void main(String[] args) throws Exception {
        for (Class<?> cls : OpenAPISpec.interfaces()) {
            createTest(cls.getCanonicalName());
        }
    }

    private static void createTest(String fqName) throws IOException {
        String pkgName = toExtendedTckPackage(fqName);
        String clsName = toExtendedTckClassName(fqName);
        String simpleNmae = StringUtil.computeSimpleName(fqName);
        String varName = StringUtil.decapitalize(simpleNmae);

        StringBuilder sb = new StringBuilder();
        sb.append("package " + pkgName + ";\n");
        sb.append("\n");
        sb.append("import static org.assertj.core.api.Assertions.assertThat;\n");
        sb.append("\n");
        sb.append("import org.eclipse.microprofile.openapi.OASFactory;\n");
        sb.append("import " + fqName + ";\n");
        sb.append("import org.testng.annotations.Test;\n");
        sb.append("\n");
        sb.append("public class " + clsName + " {\n");
        sb.append("\n");
        sb.append("    @Test\n");
        sb.append("    public void testCreate" + simpleNmae + "() {\n");
        sb.append("        " + simpleNmae + " " + varName + " = OASFactory.create" + simpleNmae + "();\n");
        sb.append("        assertThat(" + varName + ").isNotNull();\n");
        sb.append("    }\n");
        sb.append("\n");
        sb.append("}\n");
        FileUtil.writeJavaClass(Paths.get("../empoa-extended-tck/src/main/java"), pkgName, clsName, sb.toString());
    }

    static String toExtendedTckPackage(String fqName) {
        return StringUtil.computePackage(fqName.replace("org.eclipse.microprofile.openapi", "org.openapitools.empoa.extended.tck"));
    }

    static String toExtendedTckClassName(String fqName) {
        return StringUtil.computeSimpleName(fqName) + "Test";
    }
}
