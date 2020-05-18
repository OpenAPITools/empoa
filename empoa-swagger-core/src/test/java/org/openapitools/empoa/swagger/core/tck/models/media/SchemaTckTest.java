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
package org.openapitools.empoa.swagger.core.tck.models.media;

import static org.assertj.core.api.Assertions.assertThat;

import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.media.Schema;
import org.junit.jupiter.api.Test;
import org.openapitools.empoa.extended.tck.models.media.SchemaTest;
import org.openapitools.empoa.swagger.core.internal.SwAdapter;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

public class SchemaTckTest extends SchemaTest {

    @Test
    void testGetType() throws Exception {
        String content = "{\n" +
            "    \"openapi\": \"3.0.1\",\n" +
            "    \"info\": {\n" +
            "        \"title\": \"Test Specification\",\n" +
            "        \"version\": \"1.0\"\n" +
            "    },\n" +
            "    \"servers\": [\n" +
            "        {\n" +
            "            \"url\": \"http://localhost:8000/\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"paths\": {\n" +
            "        \"/test\": {\n" +
            "            \"get\": {\n" +
            "                \"responses\": {\n" +
            "                    \"200\": {\n" +
            "                        \"content\": {\n" +
            "                            \"application/json\": {\n" +
            "                                \"schema\": {\n" +
            "                                    \"type\": \"object\",\n" +
            "                                    \"properties\": {\n" +
            "                                        \"code\": {\n" +
            "                                            \"format\": \"int32\",\n" +
            "                                            \"type\": \"Integer\"\n" +
            "                                        },\n" +
            "                                        \"message\": {\n" +
            "                                            \"type\": \"String\"\n" +
            "                                        }\n" +
            "                                    }\n" +
            "                                }\n" +
            "                            }\n" +
            "                        },\n" +
            "                        \"description\": \"OK\"\n" +
            "                    }\n" +
            "                },\n" +
            "                \"operationId\": \"testGet\"\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";
        final OpenAPIParser openApiParser = new OpenAPIParser();
        final ParseOptions options = new ParseOptions();
        final SwaggerParseResult parserResult = openApiParser.readContents(content, null, options);

        OpenAPI openAPI = SwAdapter.toOpenAPI(parserResult.getOpenAPI());
        Schema schema = openAPI.getPaths()
            .getPathItem("/test")
            .getGET()
            .getResponses()
            .getAPIResponse("200")
            .getContent()
            .getMediaType("application/json")
            .getSchema();
        assertThat(
            schema.getProperties()
                .get("code")
                .getType()
        ).isEqualTo(Schema.SchemaType.INTEGER);
        assertThat(
            schema.getProperties()
                .get("message")
                .getType()
        ).isEqualTo(Schema.SchemaType.STRING);
    }
}
