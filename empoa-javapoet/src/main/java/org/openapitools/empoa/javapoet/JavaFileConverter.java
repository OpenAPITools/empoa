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
package org.openapitools.empoa.javapoet;

import javax.lang.model.element.Modifier;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.models.OpenAPI;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class JavaFileConverter {

    public static JavaFile createOpenAPI(OpenAPI openAPI, String packageName, String className) {
        ClassName oasFactory = ClassName.get(OASFactory.class);

        MethodSpec main = MethodSpec.methodBuilder("create")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .returns(OpenAPI.class)
            .addStatement("return $L", CodeBlockConverter.createOpenAPI(openAPI))
            .build();

        TypeSpec type = TypeSpec.classBuilder(className)
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addMethod(main)
            .build();

        JavaFile javaFile = JavaFile.builder(packageName, type)
            .skipJavaLangImports(true)
            .addStaticImport(oasFactory, "*")
            .build();

        return javaFile;
    }
}
