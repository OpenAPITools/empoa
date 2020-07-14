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
package org.openapitools.empoa.extended.tck;

import static org.eclipse.microprofile.openapi.OASFactory.*;

import org.eclipse.microprofile.openapi.models.Components;
import org.eclipse.microprofile.openapi.models.ExternalDocumentation;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.Operation;
import org.eclipse.microprofile.openapi.models.PathItem;
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
import org.openapitools.empoa.extended.tck.specs.BigSpec;
import org.openapitools.empoa.extended.tck.specs.HelloSpec;
import org.openapitools.empoa.extended.tck.specs.PingSpec;

public final class OASTestFactory {

    public static OpenAPI createTestOpenAPI() {
        return HelloSpec.create();
    }

    public static Components createTestComponents() {
        return BigSpec.create()
            .getComponents();
    }

    public static ExternalDocumentation createTestExternalDocumentation() {
        return createExternalDocumentation()
            .description("docs description")
            .addExtension("x-xtensio", "doc");
    }

    public static Operation createTestOperation() {
        return createTestPathItem()
            .getGET();
    }

    public static PathItem createTestPathItem() {
        return createTestPaths()
            .getPathItem("/ping");
    }

    public static Paths createTestPaths() {
        return PingSpec.create()
            .getPaths();
    }

    public static Callback createTestCallback() {
        return createCallback()
            .addPathItem(
                "{$request.body#/callbackUrl}", createPathItem()
                    .POST(
                        createOperation()
                            .requestBody(
                                createRequestBody()
                                    .content(
                                        createContent()
                                            .addMediaType(
                                                "application/json", createMediaType()
                                                    .schema(
                                                        createSchema()
                                                            .addRequired("message")
                                                            .type(Schema.SchemaType.OBJECT)
                                                            .addProperty(
                                                                "message", createSchema()
                                                                    .type(Schema.SchemaType.STRING)
                                                                    .example("Some event happened")
                                                            )
                                                    )
                                            )
                                    )
                                    .required(true)
                            )
                            .responses(
                                createAPIResponses()
                                    .addAPIResponse(
                                        "200", createAPIResponse()
                                            .description("Your server returns this code if it accepts the callback")
                                    )
                            )
                    )
            );
    }

    public static Example createTestExample() {
        return createExample()
            .description("example description")
            .externalValue("externalValue")
            .addExtension("x-xtensio", "example");
    }

    public static Header createTestHeader() {
        return createHeader()
            .description("header description")
            .allowEmptyValue(false)
            .addExtension("x-xtensio", "header");
    }

    public static Contact createTestContact() {
        return createContact()
            .name("Me")
            .email("test@test.com");
    }

    public static Info createTestInfo() {
        return BigSpec.create()
            .getInfo();
    }

    public static License createTestLicense() {
        return BigSpec.create()
            .getInfo()
            .getLicense();
    }

    public static Link createTestLink() {
        return createLink()
            .description("Some description");
    }

    public static Content createTestContent() {
        return createContent()
            .addMediaType(
                "application/json", createMediaType()
                    .schema(
                        createSchema()
                            .ref("#/components/schemas/SomeObject")
                    )
            );
    }

    public static Discriminator createTestDiscriminator() {
        return createDiscriminator()
            .propertyName("type")
            .addMapping("Cat", "#/components/schemas/Cat")
            .addMapping("Dog", "#/components/schemas/Dog");
    }

    public static Encoding createTestEncoding() {
        return createEncoding()
            .explode(true)
            .contentType("application/json")
            .addExtension("x-xtensio", "encoding");
    }

    public static MediaType createTestMediaType() {
        return createMediaType()
            .schema(
                createSchema()
                    .type(Schema.SchemaType.OBJECT)
                    .addProperty(
                        "message", createSchema()
                            .type(Schema.SchemaType.STRING)
                    )
                    .addProperty(
                        "description", createSchema()
                            .type(Schema.SchemaType.STRING)
                    )
            );
    }

    public static Schema createTestSchema() {
        return createSchema()
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
            .addProperty(
                "items", createSchema()
                    .type(Schema.SchemaType.ARRAY)
                    .items(createSchema().type(Schema.SchemaType.STRING))
            )
            .addProperty(
                "language", createSchema()
                    .defaultValue("EN")
                    .addEnumeration("EN")
                    .addEnumeration("FR")
                    .addEnumeration("DE")
                    .addEnumeration("IT")
                    .type(Schema.SchemaType.STRING)
            )
            .addExtension("x-xtensio", "schema");
    }

    public static XML createTestXML() {
        return createXML()
            .name("test")
            .addExtension("x-xtensio", "xml");
    }

    public static Parameter createTestParameter() {
        return createParameter()
            .name("force")
            .in(Parameter.In.QUERY)
            .schema(
                createSchema()
                    .type(Schema.SchemaType.BOOLEAN)
            )
            .addExtension("x-xtensio", "parameter");
    }

    public static RequestBody createTestRequestBody() {
        return createRequestBody()
            .description("Some description")
            .content(
                createContent()
                    .addMediaType(
                        "application/json", createMediaType()
                            .schema(
                                createSchema()
                                    .type(Schema.SchemaType.OBJECT)
                                    .addProperty(
                                        "message", createSchema()
                                            .type(Schema.SchemaType.STRING)
                                    )
                                    .addProperty(
                                        "description", createSchema()
                                            .type(Schema.SchemaType.STRING)
                                    )
                            )
                    )
            )
            .addExtension("x-xtensio", "body");
    }

    public static APIResponse createTestAPIResponse() {
        return createAPIResponse()
            .description("OK")
            .content(
                createContent()
                    .addMediaType(
                        "application/text", createMediaType()
                            .schema(
                                createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                    )
                    .addMediaType(
                        "application/json", createMediaType()
                            .schema(
                                createSchema()
                                    .ref("#/components/schemas/Node")
                            )
                    )
            );
    }

    public static APIResponses createTestAPIResponses() {
        return createAPIResponses()
            .addAPIResponse(
                "200", createAPIResponse()
                    .ref("#/components/responses/OkResponse")
            )
            .addAPIResponse(
                "4xx", createAPIResponse()
                    .ref("#/components/responses/BusinessErrorResponse")
            )
            .addAPIResponse(
                "default", createAPIResponse()
                    .ref("#/components/responses/ErrorResponse")
            );
    }

    public static OAuthFlow createTestOAuthFlow() {
        return createOAuthFlow()
            .tokenUrl("https://test.url.com");
    }

    public static OAuthFlows createTestOAuthFlows() {
        return createOAuthFlows()
            .addExtension("name", "value");
    }

    public static SecurityRequirement createTestSecurityRequirement() {
        return createSecurityRequirement()
            .addScheme("basic-auth");
    }

    public static SecurityScheme createTestSecurityScheme() {
        return createSecurityScheme()
            .type(SecurityScheme.Type.HTTP)
            .scheme("basic")
            .description("A description")
            .addExtension("x-xtensio", "security");
    }

    public static Server createTestServer() {
        return createServer()
            .url("http://api.example.com/")
            .description("Main server")
            .addExtension("x-xtensio", "server");
    }

    public static ServerVariable createTestServerVariable() {
        return createServerVariable()
            .description("the version username")
            .addEnumeration("v1")
            .addEnumeration("v2")
            .addEnumeration("v3")
            .defaultValue("v1")
            .addExtension("x-xtensio", "variable");
    }

    public static Tag createTestTag() {
        return createTag()
            .name("something")
            .description("tag description")
            .addExtension("x-xtensio", "tag");
    }

    private OASTestFactory() {
    }
}