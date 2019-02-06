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

public class TckExtendsClassGeneratorMain {

    public static void main(String[] args) throws Exception {
        createTests("org.openapitools.empoa.simple.tck", "../empoa-simple-models-impl/src/test/java");
        createTests("org.openapitools.empoa.smallrye.tck", "../empoa-smallrye/src/test/java");
        createTests("org.openapitools.empoa.swagger.core.tck", "../empoa-swagger-core/src/test/java");
    }

    private static void createTests(String packageName, String path) throws IOException {
        for (Class<?> cls : OpenAPISpec.interfaces()) {
            createTest(cls.getCanonicalName(), packageName, path);
        }
    }

    private static void createTest(String fqName, String rootPackage, String path) throws IOException {
        String pkgName = StringUtil.computePackage(fqName.replace("org.eclipse.microprofile.openapi", rootPackage));
        String clsName = StringUtil.computeSimpleName(fqName) + "TckTest";
        String tckPckName = TckInitialClassGeneratorMain.toExtendedTckPackage(fqName);
        String tckClsName = TckInitialClassGeneratorMain.toExtendedTckClassName(fqName);

        StringBuilder sb = new StringBuilder();
        sb.append("package " + pkgName + ";\n");
        sb.append("\n");
        sb.append("import org.testng.annotations.Test;\n");
        sb.append("\n");
        sb.append("import " + tckPckName + "." + tckClsName + ";\n");
        sb.append("\n");
        sb.append("public class " + clsName + " extends " + tckClsName + " {\n");
        sb.append("\n");
        sb.append("    @Test\n");
        sb.append("    public void detect() throws Exception {\n");
        sb.append("        // This is requested by the gradle build to detect this test class, see https://docs.gradle.org/current/userguide/java_testing.html#sec:test_detection\n");
        sb.append("    }\n");
        sb.append("}\n");
        FileUtil.writeJavaClass(Paths.get(path), pkgName, clsName, sb.toString());
    }
}
