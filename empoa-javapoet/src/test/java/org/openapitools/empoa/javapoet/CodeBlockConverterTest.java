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

import static org.assertj.core.api.Assertions.assertThat;
import static org.eclipse.microprofile.openapi.OASFactory.createAPIResponse;
import static org.eclipse.microprofile.openapi.OASFactory.createAPIResponses;
import static org.eclipse.microprofile.openapi.OASFactory.createObject;

import java.nio.file.Path;
import java.util.Arrays;

import org.eclipse.microprofile.openapi.models.media.Schema;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;
import org.eclipse.microprofile.openapi.models.responses.APIResponses;
import org.eclipse.microprofile.openapi.models.security.SecurityRequirement;
import org.testng.annotations.Test;

import com.squareup.javapoet.CodeBlock;

public class CodeBlockConverterTest {

    @Test
    public void testAddSecurityRequirements() throws Exception {
        SecurityRequirement securityRequirement = createObject(SecurityRequirement.class);
        securityRequirement.addScheme("api_key");
        securityRequirement.addScheme("some_auth", "read");
        securityRequirement.addScheme("oauth2", Arrays.asList("read", "write"));

        CodeBlock block = CodeBlockConverter.createSecurityRequirement(securityRequirement);
        assertThat(block.toString()).isEqualToNormalizingWhitespace(
            "createSecurityRequirement()\n" +
                "        .addScheme(\"api_key\")\n" +
                "        .addScheme(\"some_auth\", \"read\")\n" +
                "        .addScheme(\n" +
                "                \"oauth2\", java.util.Arrays.asList(\n" +
                "                        \"read\",\n" +
                "                        \"write\"\n" +
                "                )\n" +
                "        )"
        );
    }

    @Test
    public void testParameter() throws Exception {
        Parameter parameter = createObject(Parameter.class)
            .name("param")
            .in(Parameter.In.PATH)
            .required(true)
            .style(Parameter.Style.SIMPLE)
            .explode(false);

        CodeBlock block = CodeBlockConverter.createParameter(parameter);
        assertThat(block.toString()).isEqualToNormalizingWhitespace(
            "createParameter()\n" +
                "                .name(\"param\")\n" +
                "                .in(org.eclipse.microprofile.openapi.models.parameters.Parameter.In.PATH)\n" +
                "                .required(true)\n" +
                "                .style(org.eclipse.microprofile.openapi.models.parameters.Parameter.Style.SIMPLE)\n" +
                "                .explode(false)"
        );
    }

    @Test
    public void testSchemaWithReference() throws Exception {
        Schema schmea = createObject(Schema.class)
            .ref("#/components/schemas/Task");

        CodeBlock block = CodeBlockConverter.createSchema(schmea);
        assertThat(block.toString()).isEqualToNormalizingWhitespace(
            "createSchema()\n" +
                "                .ref(\"#/components/schemas/Task\")"
        );
    }

    @Test
    public void testSchemaWithExtension() throws Exception {
        Schema schmea = createObject(Schema.class)
            .type(Schema.SchemaType.STRING)
            .addExtension("x-custom", "value");

        CodeBlock block = CodeBlockConverter.createSchema(schmea);
        assertThat(block.toString()).isEqualToNormalizingWhitespace(
            "createSchema()\n" +
                "                .type(org.eclipse.microprofile.openapi.models.media.Schema.SchemaType.STRING)\n" +
                "                .addExtension(\"x-custom\", \"value\")"
        );
    }

    @Test
    public void testAPIResponses() throws Exception {
        APIResponses apiResponses = createAPIResponses()
            .defaultValue(
                createAPIResponse()
                    .description("Default response")
            )
            .addAPIResponse(
                "200", createAPIResponse()
                    .description("OK response")
            );

        CodeBlock block = CodeBlockConverter.createAPIResponses(apiResponses);
        assertThat(block.toString()).isEqualToNormalizingWhitespace(
            "createAPIResponses()\n" +
                "                .addAPIResponse(\n" +
                "                        \"default\", createAPIResponse()\n" +
                "                                .description(\"Default response\")\n" +
                "                        \n)" +
                "                .addAPIResponse(\n" +
                "                        \"200\", createAPIResponse()\n" +
                "                                .description(\"OK response\")" +
                "                        \n)"
        );
    }

    public static Path toFile(Path srcFolder, String packageName, String className) {
        Path file = srcFolder.resolve(packageName.replace(".", "/") + "/" + className + ".java");
        return file;
    }
}
