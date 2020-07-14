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
package org.openapitools.empoa.util.merge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.eclipse.microprofile.openapi.OASFactory.createAPIResponse;
import static org.eclipse.microprofile.openapi.OASFactory.createAPIResponses;
import static org.eclipse.microprofile.openapi.OASFactory.createComponents;
import static org.eclipse.microprofile.openapi.OASFactory.createContent;
import static org.eclipse.microprofile.openapi.OASFactory.createInfo;
import static org.eclipse.microprofile.openapi.OASFactory.createMediaType;
import static org.eclipse.microprofile.openapi.OASFactory.createOpenAPI;
import static org.eclipse.microprofile.openapi.OASFactory.createOperation;
import static org.eclipse.microprofile.openapi.OASFactory.createPathItem;
import static org.eclipse.microprofile.openapi.OASFactory.createPaths;
import static org.eclipse.microprofile.openapi.OASFactory.createRequestBody;
import static org.eclipse.microprofile.openapi.OASFactory.createSchema;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.models.Components;
import org.eclipse.microprofile.openapi.models.ExternalDocumentation;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.Operation;
import org.eclipse.microprofile.openapi.models.PathItem;
import org.eclipse.microprofile.openapi.models.PathItem.HttpMethod;
import org.eclipse.microprofile.openapi.models.Paths;
import org.eclipse.microprofile.openapi.models.callbacks.Callback;
import org.eclipse.microprofile.openapi.models.examples.Example;
import org.eclipse.microprofile.openapi.models.headers.Header;
import org.eclipse.microprofile.openapi.models.info.Contact;
import org.eclipse.microprofile.openapi.models.info.Info;
import org.eclipse.microprofile.openapi.models.info.License;
import org.eclipse.microprofile.openapi.models.links.Link;
import org.eclipse.microprofile.openapi.models.media.Content;
import org.eclipse.microprofile.openapi.models.media.Discriminator;
import org.eclipse.microprofile.openapi.models.media.Encoding;
import org.eclipse.microprofile.openapi.models.media.MediaType;
import org.eclipse.microprofile.openapi.models.media.Schema;
import org.eclipse.microprofile.openapi.models.media.XML;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;
import org.eclipse.microprofile.openapi.models.parameters.RequestBody;
import org.eclipse.microprofile.openapi.models.responses.APIResponse;
import org.eclipse.microprofile.openapi.models.responses.APIResponses;
import org.eclipse.microprofile.openapi.models.security.OAuthFlow;
import org.eclipse.microprofile.openapi.models.security.OAuthFlows;
import org.eclipse.microprofile.openapi.models.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.models.security.SecurityScheme;
import org.eclipse.microprofile.openapi.models.servers.Server;
import org.eclipse.microprofile.openapi.models.servers.ServerVariable;
import org.eclipse.microprofile.openapi.models.tags.Tag;
import org.junit.jupiter.api.Test;
import org.openapitools.empoa.extended.tck.OASTestFactory;
import org.openapitools.empoa.extended.tck.specs.PingSpec;
import org.openapitools.empoa.extended.tck.specs.TodoappSpec;
import org.openapitools.empoa.gson.OASGsonSerializer;
import org.openapitools.empoa.util.equals.OASEquals;

import com.google.gson.Gson;

public class OASMergeTest {

    @Test
    public void test() throws Exception {
        // tag::usage[]
        Operation fromOperation;
        Operation intoOperation;
        // ... instantiate the 'fromOperation' and 'intoOperation' variables
        // end::usage[]

        fromOperation = OASFactory.createOperation()
            .description("some description");
        intoOperation = TodoappSpec.create()
            .getPaths()
            .getPathItem("/task")
            .getGET();
        assertThat(intoOperation).isNotNull();

        // tag::usage[]
        OASMerge.merge(fromOperation, intoOperation);
        // end::usage[]

        Operation expected = TodoappSpec.create()
            .getPaths()
            .getPathItem("/task")
            .getGET()
            .description("some description");
        asJsonIsEqualTo(expected, intoOperation);
        assertThat(OASEquals.equals(expected, intoOperation)).isTrue();
    }

    @Test
    public void testMergePing() throws Exception {
        OpenAPI from1 = PingSpec.create();
        OpenAPI into1 = createOpenAPI()
            .openapi("3.0.1")
            .info(
                createInfo()
                    .title("Ping Specification")
                    .version("1.0")
            )
            .paths(
                createPaths()
                    .addPathItem(
                        "/ping", createPathItem()
                            .POST(
                                createOperation()
                                    .operationId("pingUpdate")
                                    .requestBody(
                                        createRequestBody()
                                            .content(
                                                createContent()
                                                    .addMediaType(
                                                        "application/json", createMediaType()
                                                            .schema(
                                                                createSchema()
                                                                    .ref("#/components/schemas/SomeObject")
                                                            )
                                                    )
                                            )
                                    )
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "200", createAPIResponse()
                                                    .description("OK")
                                            )
                                    )
                            )
                    )
            )
            .components(
                createComponents()
                    .addSchema(
                        "SomeObject", createSchema()
                            .type(Schema.SchemaType.OBJECT)
                            .addProperty(
                                "id", createSchema()
                                    .type(Schema.SchemaType.INTEGER)
                                    .format("int32")
                            )
                            .addProperty(
                                "message", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                    )
            );
        assertThat(into1.getServers()).isNull();
        assertThat(
            into1.getPaths()
                .getPathItem("/ping")
                .getOperations()
        ).containsOnlyKeys(HttpMethod.POST);

        OASMerge.merge(from1, into1);
        assertThat(into1.getServers()).hasSize(1);
        assertThat(
            into1.getPaths()
                .getPathItem("/ping")
                .getOperations()
        ).containsOnlyKeys(HttpMethod.GET, HttpMethod.POST);

    }

    @Test
    public void testMergeOpenAPI() throws Exception {
        OpenAPI from1 = OASTestFactory.createTestOpenAPI();
        OpenAPI into1 = OASFactory.createOpenAPI();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        OpenAPI from2 = OASFactory.createOpenAPI();
        OpenAPI into2 = OASTestFactory.createTestOpenAPI();
        OASMerge.merge(from2, into2);

        OpenAPI from3 = OASTestFactory.createTestOpenAPI();
        OpenAPI into3 = OASTestFactory.createTestOpenAPI();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeAPIResponse() throws Exception {
        APIResponse from1 = OASTestFactory.createTestAPIResponse();
        APIResponse into1 = OASFactory.createAPIResponse();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        APIResponse from2 = OASFactory.createAPIResponse();
        APIResponse into2 = OASTestFactory.createTestAPIResponse();
        OASMerge.merge(from2, into2);

        APIResponse from3 = OASTestFactory.createTestAPIResponse();
        APIResponse into3 = OASTestFactory.createTestAPIResponse();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeAPIResponses() throws Exception {
        APIResponses from1 = OASTestFactory.createTestAPIResponses();
        APIResponses into1 = OASFactory.createAPIResponses();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        APIResponses from2 = OASFactory.createAPIResponses();
        APIResponses into2 = OASTestFactory.createTestAPIResponses();
        OASMerge.merge(from2, into2);

        APIResponses from3 = OASTestFactory.createTestAPIResponses();
        APIResponses into3 = OASTestFactory.createTestAPIResponses();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeCallback() throws Exception {
        Callback from1 = OASTestFactory.createTestCallback();
        Callback into1 = OASFactory.createCallback();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Callback from2 = OASFactory.createCallback();
        Callback into2 = OASTestFactory.createTestCallback();
        OASMerge.merge(from2, into2);

        Callback from3 = OASTestFactory.createTestCallback();
        Callback into3 = OASTestFactory.createTestCallback();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeComponents() throws Exception {
        Components from1 = OASTestFactory.createTestComponents();
        Components into1 = OASFactory.createComponents();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Components from2 = OASFactory.createComponents();
        Components into2 = OASTestFactory.createTestComponents();
        OASMerge.merge(from2, into2);

        Components from3 = OASTestFactory.createTestComponents();
        Components into3 = OASTestFactory.createTestComponents();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeContact() throws Exception {
        Contact from1 = OASTestFactory.createTestContact();
        Contact into1 = OASFactory.createContact();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Contact from2 = OASFactory.createContact();
        Contact into2 = OASTestFactory.createTestContact();
        OASMerge.merge(from2, into2);

        Contact from3 = OASTestFactory.createTestContact();
        Contact into3 = OASTestFactory.createTestContact();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeContent() throws Exception {
        Content from1 = OASTestFactory.createTestContent();
        Content into1 = OASFactory.createContent();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Content from2 = OASFactory.createContent();
        Content into2 = OASTestFactory.createTestContent();
        OASMerge.merge(from2, into2);

        Content from3 = OASTestFactory.createTestContent();
        Content into3 = OASTestFactory.createTestContent();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeDiscriminator() throws Exception {
        Discriminator from1 = OASTestFactory.createTestDiscriminator();
        Discriminator into1 = OASFactory.createDiscriminator();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Discriminator from2 = OASFactory.createDiscriminator();
        Discriminator into2 = OASTestFactory.createTestDiscriminator();
        OASMerge.merge(from2, into2);

        Discriminator from3 = OASTestFactory.createTestDiscriminator();
        Discriminator into3 = OASTestFactory.createTestDiscriminator();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeEncoding() throws Exception {
        Encoding from1 = OASTestFactory.createTestEncoding();
        Encoding into1 = OASFactory.createEncoding();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Encoding from2 = OASFactory.createEncoding();
        Encoding into2 = OASTestFactory.createTestEncoding();
        OASMerge.merge(from2, into2);

        Encoding from3 = OASTestFactory.createTestEncoding();
        Encoding into3 = OASTestFactory.createTestEncoding();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeExample() throws Exception {
        Example from1 = OASTestFactory.createTestExample();
        Example into1 = OASFactory.createExample();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Example from2 = OASFactory.createExample();
        Example into2 = OASTestFactory.createTestExample();
        OASMerge.merge(from2, into2);

        Example from3 = OASTestFactory.createTestExample();
        Example into3 = OASTestFactory.createTestExample();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeExternalDocumentation() throws Exception {
        ExternalDocumentation from1 = OASTestFactory.createTestExternalDocumentation();
        ExternalDocumentation into1 = OASFactory.createExternalDocumentation();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        ExternalDocumentation from2 = OASFactory.createExternalDocumentation();
        ExternalDocumentation into2 = OASTestFactory.createTestExternalDocumentation();
        OASMerge.merge(from2, into2);

        ExternalDocumentation from3 = OASTestFactory.createTestExternalDocumentation();
        ExternalDocumentation into3 = OASTestFactory.createTestExternalDocumentation();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeHeader() throws Exception {
        Header from1 = OASTestFactory.createTestHeader();
        Header into1 = OASFactory.createHeader();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Header from2 = OASFactory.createHeader();
        Header into2 = OASTestFactory.createTestHeader();
        OASMerge.merge(from2, into2);

        Header from3 = OASTestFactory.createTestHeader();
        Header into3 = OASTestFactory.createTestHeader();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeInfo() throws Exception {
        Info from1 = OASTestFactory.createTestInfo();
        Info into1 = OASFactory.createInfo();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Info from2 = OASFactory.createInfo();
        Info into2 = OASTestFactory.createTestInfo();
        OASMerge.merge(from2, into2);

        Info from3 = OASTestFactory.createTestInfo();
        Info into3 = OASTestFactory.createTestInfo();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeLicense() throws Exception {
        License from1 = OASTestFactory.createTestLicense();
        License into1 = OASFactory.createLicense();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        License from2 = OASFactory.createLicense();
        License into2 = OASTestFactory.createTestLicense();
        OASMerge.merge(from2, into2);

        License from3 = OASTestFactory.createTestLicense();
        License into3 = OASTestFactory.createTestLicense();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeLink() throws Exception {
        Link from1 = OASTestFactory.createTestLink();
        Link into1 = OASFactory.createLink();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Link from2 = OASFactory.createLink();
        Link into2 = OASTestFactory.createTestLink();
        OASMerge.merge(from2, into2);

        Link from3 = OASTestFactory.createTestLink();
        Link into3 = OASTestFactory.createTestLink();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeMediaType() throws Exception {
        MediaType from1 = OASTestFactory.createTestMediaType();
        MediaType into1 = OASFactory.createMediaType();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        MediaType from2 = OASFactory.createMediaType();
        MediaType into2 = OASTestFactory.createTestMediaType();
        OASMerge.merge(from2, into2);

        MediaType from3 = OASTestFactory.createTestMediaType();
        MediaType into3 = OASTestFactory.createTestMediaType();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeOAuthFlow() throws Exception {
        OAuthFlow from1 = OASTestFactory.createTestOAuthFlow();
        OAuthFlow into1 = OASFactory.createOAuthFlow();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        OAuthFlow from2 = OASFactory.createOAuthFlow();
        OAuthFlow into2 = OASTestFactory.createTestOAuthFlow();
        OASMerge.merge(from2, into2);

        OAuthFlow from3 = OASTestFactory.createTestOAuthFlow();
        OAuthFlow into3 = OASTestFactory.createTestOAuthFlow();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeOAuthFlows() throws Exception {
        OAuthFlows from1 = OASTestFactory.createTestOAuthFlows();
        OAuthFlows into1 = OASFactory.createOAuthFlows();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        OAuthFlows from2 = OASFactory.createOAuthFlows();
        OAuthFlows into2 = OASTestFactory.createTestOAuthFlows();
        OASMerge.merge(from2, into2);

        OAuthFlows from3 = OASTestFactory.createTestOAuthFlows();
        OAuthFlows into3 = OASTestFactory.createTestOAuthFlows();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeOperation() throws Exception {
        Operation from1 = OASTestFactory.createTestOperation();
        Operation into1 = OASFactory.createOperation();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Operation from2 = OASFactory.createOperation();
        Operation into2 = OASTestFactory.createTestOperation();
        OASMerge.merge(from2, into2);

        Operation from3 = OASTestFactory.createTestOperation();
        Operation into3 = OASTestFactory.createTestOperation();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeParameter() throws Exception {
        Parameter from1 = OASTestFactory.createTestParameter();
        Parameter into1 = OASFactory.createParameter();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Parameter from2 = OASFactory.createParameter();
        Parameter into2 = OASTestFactory.createTestParameter();
        OASMerge.merge(from2, into2);

        Parameter from3 = OASTestFactory.createTestParameter();
        Parameter into3 = OASTestFactory.createTestParameter();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergePathItem() throws Exception {
        PathItem from1 = OASTestFactory.createTestPathItem();
        PathItem into1 = OASFactory.createPathItem();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        PathItem from2 = OASFactory.createPathItem();
        PathItem into2 = OASTestFactory.createTestPathItem();
        OASMerge.merge(from2, into2);

        PathItem from3 = OASTestFactory.createTestPathItem();
        PathItem into3 = OASTestFactory.createTestPathItem();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergePaths() throws Exception {
        Paths from1 = OASTestFactory.createTestPaths();
        Paths into1 = OASFactory.createPaths();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Paths from2 = OASFactory.createPaths();
        Paths into2 = OASTestFactory.createTestPaths();
        OASMerge.merge(from2, into2);

        Paths from3 = OASTestFactory.createTestPaths();
        Paths into3 = OASTestFactory.createTestPaths();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeRequestBody() throws Exception {
        RequestBody from1 = OASTestFactory.createTestRequestBody();
        RequestBody into1 = OASFactory.createRequestBody();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        RequestBody from2 = OASFactory.createRequestBody();
        RequestBody into2 = OASTestFactory.createTestRequestBody();
        OASMerge.merge(from2, into2);

        RequestBody from3 = OASTestFactory.createTestRequestBody();
        RequestBody into3 = OASTestFactory.createTestRequestBody();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeSchema() throws Exception {
        Schema from1 = OASTestFactory.createTestSchema();
        Schema into1 = OASFactory.createSchema();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Schema from2 = OASFactory.createSchema();
        Schema into2 = OASTestFactory.createTestSchema();
        OASMerge.merge(from2, into2);

        Schema from3 = OASTestFactory.createTestSchema();
        Schema into3 = OASTestFactory.createTestSchema();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeSecurityRequirement() throws Exception {
        SecurityRequirement from1 = OASTestFactory.createTestSecurityRequirement();
        SecurityRequirement into1 = OASFactory.createSecurityRequirement();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        SecurityRequirement from2 = OASFactory.createSecurityRequirement();
        SecurityRequirement into2 = OASTestFactory.createTestSecurityRequirement();
        OASMerge.merge(from2, into2);

        SecurityRequirement from3 = OASTestFactory.createTestSecurityRequirement();
        SecurityRequirement into3 = OASTestFactory.createTestSecurityRequirement();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeSecurityScheme() throws Exception {
        SecurityScheme from1 = OASTestFactory.createTestSecurityScheme();
        SecurityScheme into1 = OASFactory.createSecurityScheme();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        SecurityScheme from2 = OASFactory.createSecurityScheme();
        SecurityScheme into2 = OASTestFactory.createTestSecurityScheme();
        OASMerge.merge(from2, into2);

        SecurityScheme from3 = OASTestFactory.createTestSecurityScheme();
        SecurityScheme into3 = OASTestFactory.createTestSecurityScheme();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeServer() throws Exception {
        Server from1 = OASTestFactory.createTestServer();
        Server into1 = OASFactory.createServer();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Server from2 = OASFactory.createServer();
        Server into2 = OASTestFactory.createTestServer();
        OASMerge.merge(from2, into2);

        Server from3 = OASTestFactory.createTestServer();
        Server into3 = OASTestFactory.createTestServer();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeServerVariable() throws Exception {
        ServerVariable from1 = OASTestFactory.createTestServerVariable();
        ServerVariable into1 = OASFactory.createServerVariable();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        ServerVariable from2 = OASFactory.createServerVariable();
        ServerVariable into2 = OASTestFactory.createTestServerVariable();
        OASMerge.merge(from2, into2);

        ServerVariable from3 = OASTestFactory.createTestServerVariable();
        ServerVariable into3 = OASTestFactory.createTestServerVariable();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeTag() throws Exception {
        Tag from1 = OASTestFactory.createTestTag();
        Tag into1 = OASFactory.createTag();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        Tag from2 = OASFactory.createTag();
        Tag into2 = OASTestFactory.createTestTag();
        OASMerge.merge(from2, into2);

        Tag from3 = OASTestFactory.createTestTag();
        Tag into3 = OASTestFactory.createTestTag();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    @Test
    public void testMergeXML() throws Exception {
        XML from1 = OASTestFactory.createTestXML();
        XML into1 = OASFactory.createXML();
        OASMerge.merge(from1, into1);
        asJsonIsEqualTo(from1, into1);

        XML from2 = OASFactory.createXML();
        XML into2 = OASTestFactory.createTestXML();
        OASMerge.merge(from2, into2);

        XML from3 = OASTestFactory.createTestXML();
        XML into3 = OASTestFactory.createTestXML();
        OASMerge.merge(from3, into3);
        asJsonIsEqualTo(from3, into3);
    }

    private static void asJsonIsEqualTo(Object a, Object b) {
        Gson gson = OASGsonSerializer.instance();
        String aJson = gson.toJson(a);
        String bJson = gson.toJson(b);
        assertThat(bJson).isEqualTo(aJson);
    }
}
