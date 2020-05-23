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
package org.openapitools.empoa.util.test;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import static org.eclipse.microprofile.openapi.OASFactory.createAPIResponse;
import static org.eclipse.microprofile.openapi.OASFactory.createAPIResponses;
import static org.eclipse.microprofile.openapi.OASFactory.createComponents;
import static org.eclipse.microprofile.openapi.OASFactory.createInfo;
import static org.eclipse.microprofile.openapi.OASFactory.createOpenAPI;
import static org.eclipse.microprofile.openapi.OASFactory.createOperation;
import static org.eclipse.microprofile.openapi.OASFactory.createPathItem;
import static org.eclipse.microprofile.openapi.OASFactory.createPaths;
import static org.eclipse.microprofile.openapi.OASFactory.createSchema;
import static org.eclipse.microprofile.openapi.OASFactory.createServer;
import static org.eclipse.microprofile.openapi.OASFactory.createServerVariable;
import static org.eclipse.microprofile.openapi.OASFactory.createServerVariables;

import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.callbacks.Callback;
import org.eclipse.microprofile.openapi.models.examples.Example;
import org.eclipse.microprofile.openapi.models.headers.Header;
import org.eclipse.microprofile.openapi.models.links.Link;
import org.eclipse.microprofile.openapi.models.media.Schema;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;
import org.eclipse.microprofile.openapi.models.parameters.RequestBody;
import org.eclipse.microprofile.openapi.models.responses.APIResponse;
import org.eclipse.microprofile.openapi.models.security.SecurityScheme;
import org.junit.jupiter.api.Test;
import org.openapitools.empoa.extended.tck.specs.BigSpec;
import org.openapitools.empoa.extended.tck.specs.PingSpec;
import org.openapitools.empoa.gson.OASGsonSerializer;
import org.openapitools.empoa.util.OASUtil;
import org.openapitools.empoa.util.SortMapsConfig;

import com.google.gson.Gson;

public class OASUtilTest {

    @Test
    public void testSortMapsBigSpec() throws Exception {
        Gson gson = OASGsonSerializer.instance();

        OpenAPI openAPI = BigSpec.create();
        OASUtil.sortMaps(openAPI);
        String sortedJson = gson.toJson(openAPI);

        String orignalJson = gson.toJson(BigSpec.create());
        assertThat(sortedJson).isNotEqualTo(orignalJson);
        assertThatJson(sortedJson).isEqualTo(orignalJson);
    }

    @Test
    public void testSortMapsWithConfig() throws Exception {
        OpenAPI spec = createOpenAPI()
            .openapi("3.0.1")
            .info(
                createInfo()
                    .title("Example Specification")
                    .version("1.0")
            )
            .addServer(
                createServer()
                    .url("http://api.com/{a}/{b}/{c}")
                    .description("Main server")
                    .variables(
                        createServerVariables()
                            .addServerVariable("b", createServerVariable().description("b var"))
                            .addServerVariable("c", createServerVariable().description("c var"))
                            .addServerVariable("a", createServerVariable().description("a var"))
                    )
            )
            .paths(
                createPaths()
                    .addPathItem(
                        "/c", createPathItem()
                            .GET(
                                createOperation()
                                    .operationId("opC")
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "200", createAPIResponse()
                                                    .description("OK")
                                            )
                                    )
                            )
                    )
                    .addPathItem(
                        "/a", createPathItem()
                            .GET(
                                createOperation()
                                    .operationId("opA")
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "400", createAPIResponse()
                                                    .description("Error")
                                            )
                                            .addAPIResponse(
                                                "default", createAPIResponse()
                                                    .description("Default")
                                            )
                                            .addAPIResponse(
                                                "200", createAPIResponse()
                                                    .description("OK")
                                            )
                                    )
                            )
                    )
                    .addPathItem(
                        "/b", createPathItem()
                            .GET(
                                createOperation()
                                    .operationId("opB")
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "200", createAPIResponse()
                                                    .description("OK")
                                            )
                                    )
                                    .addExtension("x-a-extension", "value1")
                                    .addExtension("x-c-extension", "value2")
                                    .addExtension("x-b-extension", "value3")
                            )
                    )
            )
            .components(
                createComponents()
                    .addSchema(
                        "Foo", createSchema()
                            .type(Schema.SchemaType.OBJECT)
                            .addProperty(
                                "value", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                            .addProperty(
                                "description", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                    )
                    .addSchema(
                        "Bar", createSchema()
                            .type(Schema.SchemaType.OBJECT)
                            .addProperty(
                                "abc", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                            .addProperty(
                                "zyx", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                    )
            );
        SortMapsConfig config = new SortMapsConfig().sortSchemaProperties(false);
        OASUtil.sortMaps(spec, config);

        Gson gson = OASGsonSerializer.instance();
        String sortedJson = gson.toJson(spec);
        String expected = "{\n" +
            "  \"openapi\": \"3.0.1\",\n" +
            "  \"info\": {\n" +
            "    \"title\": \"Example Specification\",\n" +
            "    \"version\": \"1.0\"\n" +
            "  },\n" +
            "  \"servers\": [\n" +
            "    {\n" +
            "      \"url\": \"http://api.com/{a}/{b}/{c}\",\n" +
            "      \"description\": \"Main server\",\n" +
            "      \"variables\": {\n" +
            "        \"a\": {\n" +
            "          \"description\": \"a var\"\n" +
            "        },\n" +
            "        \"b\": {\n" +
            "          \"description\": \"b var\"\n" +
            "        },\n" +
            "        \"c\": {\n" +
            "          \"description\": \"c var\"\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  ],\n" +
            "  \"paths\": {\n" +
            "    \"/a\": {\n" +
            "      \"get\": {\n" +
            "        \"operationId\": \"opA\",\n" +
            "        \"responses\": {\n" +
            "          \"200\": {\n" +
            "            \"description\": \"OK\"\n" +
            "          },\n" +
            "          \"400\": {\n" +
            "            \"description\": \"Error\"\n" +
            "          },\n" +
            "          \"default\": {\n" +
            "            \"description\": \"Default\"\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"/b\": {\n" +
            "      \"get\": {\n" +
            "        \"operationId\": \"opB\",\n" +
            "        \"responses\": {\n" +
            "          \"200\": {\n" +
            "            \"description\": \"OK\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"x-a-extension\": \"value1\",\n" +
            "        \"x-b-extension\": \"value3\",\n" +
            "        \"x-c-extension\": \"value2\"\n" +
            "      }\n" +
            "    },\n" +
            "    \"/c\": {\n" +
            "      \"get\": {\n" +
            "        \"operationId\": \"opC\",\n" +
            "        \"responses\": {\n" +
            "          \"200\": {\n" +
            "            \"description\": \"OK\"\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  },\n" +
            "  \"components\": {\n" +
            "    \"schemas\": {\n" +
            "      \"Bar\": {\n" +
            "        \"type\": \"object\",\n" +
            "        \"properties\": {\n" +
            "          \"abc\": {\n" +
            "            \"type\": \"string\"\n" +
            "          },\n" +
            "          \"zyx\": {\n" +
            "            \"type\": \"string\"\n" +
            "          }\n" +
            "        }\n" +
            "      },\n" +
            "      \"Foo\": {\n" +
            "        \"type\": \"object\",\n" +
            "        \"properties\": {\n" +
            "          \"value\": {\n" +
            "            \"type\": \"string\"\n" +
            "          },\n" +
            "          \"description\": {\n" +
            "            \"type\": \"string\"\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
        assertThat(sortedJson).isEqualTo(expected);

    }

    @Test
    public void testContainsAPIResponse() throws Exception {
        assertThat(OASUtil.containsAPIResponse(PingSpec.create(), "Empty")).isFalse();
        OpenAPI openAPI = BigSpec.create();
        assertThat(OASUtil.containsAPIResponse(openAPI, "xxx")).isFalse();
        assertThat(OASUtil.containsAPIResponse(openAPI, "MessageResponse")).isTrue();
        assertThat(OASUtil.containsAPIResponse(openAPI, "#/components/responses/MessageResponse")).isTrue();
    }

    @Test
    public void testContainsCallback() throws Exception {
        assertThat(OASUtil.containsCallback(PingSpec.create(), "Empty")).isFalse();
        OpenAPI openAPI = BigSpec.create();
        assertThat(OASUtil.containsCallback(openAPI, "Test")).isFalse();
        assertThat(OASUtil.containsCallback(openAPI, "PingCallback")).isTrue();
        assertThat(OASUtil.containsCallback(openAPI, "#/components/callbacks/PingCallback")).isTrue();
    }

    @Test
    public void testContainsExample() throws Exception {
        assertThat(OASUtil.containsExample(PingSpec.create(), "Empty")).isFalse();
        OpenAPI openAPI = BigSpec.create();
        assertThat(OASUtil.containsExample(openAPI, "Test")).isFalse();
        assertThat(OASUtil.containsExample(openAPI, "ExampleEntry")).isTrue();
        assertThat(OASUtil.containsExample(openAPI, "#/components/examples/ExampleEntry")).isTrue();
    }

    @Test
    public void testContainsHeader() throws Exception {
        assertThat(OASUtil.containsHeader(PingSpec.create(), "Empty")).isFalse();
        OpenAPI openAPI = BigSpec.create();
        assertThat(OASUtil.containsHeader(openAPI, "xxx")).isFalse();
        assertThat(OASUtil.containsHeader(openAPI, "HeaderEntry")).isTrue();
        assertThat(OASUtil.containsHeader(openAPI, "#/components/headers/HeaderEntry")).isTrue();
    }

    @Test
    public void testContainsLink() throws Exception {
        assertThat(OASUtil.containsLink(PingSpec.create(), "Empty")).isFalse();
        OpenAPI openAPI = BigSpec.create();
        assertThat(OASUtil.containsLink(openAPI, "xxx")).isFalse();
        assertThat(OASUtil.containsLink(openAPI, "LinkEntry")).isTrue();
        assertThat(OASUtil.containsLink(openAPI, "#/components/links/LinkEntry")).isTrue();
    }

    @Test
    public void testContainsParameter() throws Exception {
        assertThat(OASUtil.containsParameter(PingSpec.create(), "Empty")).isFalse();
        OpenAPI openAPI = BigSpec.create();
        assertThat(OASUtil.containsParameter(openAPI, "xxx")).isFalse();
        assertThat(OASUtil.containsParameter(openAPI, "LanguageParam")).isTrue();
        assertThat(OASUtil.containsParameter(openAPI, "#/components/parameters/LanguageParam")).isTrue();
    }

    @Test
    public void testContainsRequestBody() throws Exception {
        assertThat(OASUtil.containsRequestBody(PingSpec.create(), "Empty")).isFalse();
        OpenAPI openAPI = BigSpec.create();
        assertThat(OASUtil.containsRequestBody(openAPI, "xxx")).isFalse();
        assertThat(OASUtil.containsRequestBody(openAPI, "UpdateBody")).isTrue();
        assertThat(OASUtil.containsRequestBody(openAPI, "#/components/requestBodies/UpdateBody")).isTrue();
    }

    @Test
    public void testContainsSchema() throws Exception {
        assertThat(OASUtil.containsSchema(PingSpec.create(), "Empty")).isFalse();
        OpenAPI openAPI = BigSpec.create();
        assertThat(OASUtil.containsSchema(openAPI, "xxx")).isFalse();
        assertThat(OASUtil.containsSchema(openAPI, "SimpleInfo")).isTrue();
        assertThat(OASUtil.containsSchema(openAPI, "#/components/schemas/SimpleInfo")).isTrue();
    }

    @Test
    public void testContainsSecurityScheme() throws Exception {
        assertThat(OASUtil.containsSecurityScheme(PingSpec.create(), "Empty")).isFalse();
        OpenAPI openAPI = BigSpec.create();
        assertThat(OASUtil.containsSecurityScheme(openAPI, "xxx")).isFalse();
        assertThat(OASUtil.containsSecurityScheme(openAPI, "basic-auth")).isTrue();
        assertThat(OASUtil.containsSecurityScheme(openAPI, "#/components/securitySchemes/basic-auth")).isTrue();
    }

    @Test
    public void testFindReferencedAPIResponse() throws Exception {
        assertThat(OASUtil.findReferencedAPIResponse(PingSpec.create(), "Empty")).isEmpty();
        OpenAPI openAPI = BigSpec.create();
        APIResponse item = openAPI.getComponents()
            .getResponses()
            .get("MessageResponse");
        assertThat(OASUtil.findReferencedAPIResponse(openAPI, "xxx")).isEmpty();
        assertThat(OASUtil.findReferencedAPIResponse(openAPI, "MessageResponse")).contains(item);
        assertThat(OASUtil.findReferencedAPIResponse(openAPI, "#/components/responses/MessageResponse")).contains(item);
    }

    @Test
    public void testFindReferencedCallback() throws Exception {
        assertThat(OASUtil.findReferencedCallback(PingSpec.create(), "Empty")).isEmpty();
        OpenAPI openAPI = BigSpec.create();
        Callback item = openAPI.getComponents()
            .getCallbacks()
            .get("PingCallback");
        assertThat(OASUtil.findReferencedCallback(openAPI, "Test")).isEmpty();
        assertThat(OASUtil.findReferencedCallback(openAPI, "PingCallback")).contains(item);
        assertThat(OASUtil.findReferencedCallback(openAPI, "#/components/callbacks/PingCallback")).contains(item);
    }

    @Test
    public void testFindReferencedExample() throws Exception {
        assertThat(OASUtil.findReferencedExample(PingSpec.create(), "Empty")).isEmpty();
        OpenAPI openAPI = BigSpec.create();
        Example item = openAPI.getComponents()
            .getExamples()
            .get("ExampleEntry");
        assertThat(OASUtil.findReferencedExample(openAPI, "Test")).isEmpty();
        assertThat(OASUtil.findReferencedExample(openAPI, "ExampleEntry")).contains(item);
        assertThat(OASUtil.findReferencedExample(openAPI, "#/components/examples/ExampleEntry")).contains(item);
    }

    @Test
    public void testFindReferencedHeader() throws Exception {
        assertThat(OASUtil.findReferencedHeader(PingSpec.create(), "Empty")).isEmpty();
        OpenAPI openAPI = BigSpec.create();
        Header item = openAPI.getComponents()
            .getHeaders()
            .get("HeaderEntry");
        assertThat(OASUtil.findReferencedHeader(openAPI, "xxx")).isEmpty();
        assertThat(OASUtil.findReferencedHeader(openAPI, "HeaderEntry")).contains(item);
        assertThat(OASUtil.findReferencedHeader(openAPI, "#/components/headers/HeaderEntry")).contains(item);
    }

    @Test
    public void testFindReferencedLink() throws Exception {
        assertThat(OASUtil.findReferencedLink(PingSpec.create(), "Empty")).isEmpty();
        OpenAPI openAPI = BigSpec.create();
        Link item = openAPI.getComponents()
            .getLinks()
            .get("LinkEntry");
        assertThat(OASUtil.findReferencedLink(openAPI, "xxx")).isEmpty();
        assertThat(OASUtil.findReferencedLink(openAPI, "LinkEntry")).contains(item);
        assertThat(OASUtil.findReferencedLink(openAPI, "#/components/links/LinkEntry")).contains(item);
    }

    @Test
    public void testFindReferencedParameter() throws Exception {
        assertThat(OASUtil.findReferencedParameter(PingSpec.create(), "Empty")).isEmpty();
        OpenAPI openAPI = BigSpec.create();
        Parameter item = openAPI.getComponents()
            .getParameters()
            .get("LanguageParam");
        assertThat(OASUtil.findReferencedParameter(openAPI, "xxx")).isEmpty();
        assertThat(OASUtil.findReferencedParameter(openAPI, "LanguageParam")).contains(item);
        assertThat(OASUtil.findReferencedParameter(openAPI, "#/components/parameters/LanguageParam")).contains(item);
    }

    @Test
    public void testFindReferencedRequestBody() throws Exception {
        assertThat(OASUtil.findReferencedRequestBody(PingSpec.create(), "Empty")).isEmpty();
        OpenAPI openAPI = BigSpec.create();
        RequestBody item = openAPI.getComponents()
            .getRequestBodies()
            .get("UpdateBody");
        assertThat(OASUtil.findReferencedRequestBody(openAPI, "xxx")).isEmpty();
        assertThat(OASUtil.findReferencedRequestBody(openAPI, "UpdateBody")).contains(item);
        assertThat(OASUtil.findReferencedRequestBody(openAPI, "#/components/requestBodies/UpdateBody")).contains(item);
    }

    @Test
    public void testFindReferencedSchema() throws Exception {
        assertThat(OASUtil.findReferencedSchema(PingSpec.create(), "Empty")).isEmpty();
        OpenAPI openAPI = BigSpec.create();
        Schema item = openAPI.getComponents()
            .getSchemas()
            .get("SimpleInfo");
        assertThat(OASUtil.findReferencedSchema(openAPI, "xxx")).isEmpty();
        assertThat(OASUtil.findReferencedSchema(openAPI, "SimpleInfo")).contains(item);
        assertThat(OASUtil.findReferencedSchema(openAPI, "#/components/schemas/SimpleInfo")).contains(item);
    }

    @Test
    public void testFindReferencedSecurityScheme() throws Exception {
        assertThat(OASUtil.findReferencedSecurityScheme(PingSpec.create(), "Empty")).isEmpty();
        OpenAPI openAPI = BigSpec.create();
        SecurityScheme item = openAPI.getComponents()
            .getSecuritySchemes()
            .get("basic-auth");
        assertThat(OASUtil.findReferencedSecurityScheme(openAPI, "xxx")).isEmpty();
        assertThat(OASUtil.findReferencedSecurityScheme(openAPI, "basic-auth")).contains(item);
        assertThat(OASUtil.findReferencedSecurityScheme(openAPI, "#/components/securitySchemes/basic-auth")).contains(item);
    }
}
