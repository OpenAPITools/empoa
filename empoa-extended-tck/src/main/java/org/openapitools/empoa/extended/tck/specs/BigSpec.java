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
package org.openapitools.empoa.extended.tck.specs;

import static org.eclipse.microprofile.openapi.OASFactory.*;

import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.headers.Header;
import org.eclipse.microprofile.openapi.models.media.Schema;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;
import org.eclipse.microprofile.openapi.models.security.SecurityScheme;

public final class BigSpec {
    public static OpenAPI create() {
        return createOpenAPI()
            .openapi("3.0.1")
            .info(
                createInfo()
                    .title("Big Specification")
                    .description("This specification description")
                    .termsOfService("http://example.com/terms/")
                    .contact(
                        createContact()
                            .name("Support")
                            .url("http://www.example.com/support/")
                            .email("support@example.com")
                    )
                    .license(
                        createLicense()
                            .name("Apache 2.0")
                            .url("https://www.apache.org/licenses/LICENSE-2.0.html")
                    )
                    .version("1.0")
            )
            .addServer(
                createServer()
                    .url("http://api.example.com/")
                    .description("Main server")
            )
            .addServer(
                createServer()
                    .url("http://{version}.example-test.com:8080/{username}/")
                    .description("Test server")
                    .addVariable(
                        "version", createServerVariable()
                            .addEnumeration("v1")
                            .addEnumeration("v2")
                            .addEnumeration("v3")
                            .defaultValue("v1")
                    )
                    .addVariable(
                        "username", createServerVariable()
                            .defaultValue("alice")
                            .description("the developer username")
                    )
            )
            .addTag(
                createTag()
                    .name("WIP")
                    .description("work-in-progress")
            )
            .paths(
                createPaths()
                    .addPathItem(
                        "/tree/{name}", createPathItem()
                            .GET(
                                createOperation()
                                    .addTag("WIP")
                                    .summary("Return a tree of nodes")
                                    .operationId("tree")
                                    .addParameter(
                                        createParameter()
                                            .name("name")
                                            .in(Parameter.In.PATH)
                                            .required(true)
                                            .schema(
                                                createSchema()
                                                    .type(Schema.SchemaType.STRING)
                                            )
                                    )
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "200", createAPIResponse()
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
                                                    )
                                            )
                                            .addAPIResponse(
                                                "4XX", createAPIResponse()
                                                    .description("Error")
                                                    .content(
                                                        createContent()
                                                            .addMediaType(
                                                                "*/*", createMediaType()
                                                                    .schema(
                                                                        createSchema()
                                                                            .ref("#/components/schemas/Error")
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                                    .addSecurityRequirement(
                                        createSecurityRequirement()
                                            .addScheme("basic-auth")
                                    )
                                    .addSecurityRequirement(
                                        createSecurityRequirement()
                                            .addScheme("api-key-auth")
                                    )
                            )
                    )
                    .addPathItem(
                        "/messages", createPathItem()
                            .POST(
                                createOperation()
                                    .summary("Create a message")
                                    .operationId("postMessage")
                                    .requestBody(
                                        createRequestBody()
                                            .content(
                                                createContent()
                                                    .addMediaType(
                                                        "application/json", createMediaType()
                                                            .schema(
                                                                createSchema()
                                                                    .type(Schema.SchemaType.OBJECT)
                                                                    .addProperty(
                                                                        "id", createSchema()
                                                                            .type(Schema.SchemaType.INTEGER)
                                                                            .format("int32")
                                                                    )
                                                                    .addProperty(
                                                                        "description", createSchema()
                                                                            .type(Schema.SchemaType.STRING)
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
                                                            )
                                                    )
                                            )
                                    )
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "200", createAPIResponse()
                                                    .ref("#/components/responses/MessageResponse")
                                            )
                                    )
                            )
                    )
                    .addPathItem(
                        "/messages/{id}", createPathItem()
                            .GET(
                                createOperation()
                                    .summary("Return a message")
                                    .operationId("getMessage")
                                    .addParameter(
                                        createParameter()
                                            .ref("#/components/parameters/LanguageParam")
                                    )
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "200", createAPIResponse()
                                                    .ref("#/components/responses/MessageResponse")
                                            )
                                    )
                            )
                            .PUT(
                                createOperation()
                                    .summary("Update a message")
                                    .operationId("putMessage")
                                    .addParameter(
                                        createParameter()
                                            .name("force")
                                            .in(Parameter.In.QUERY)
                                            .schema(
                                                createSchema()
                                                    .type(Schema.SchemaType.BOOLEAN)
                                            )
                                    )
                                    .requestBody(
                                        createRequestBody()
                                            .ref("#/components/requestBodies/UpdateBody")
                                    )
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "200", createAPIResponse()
                                                    .ref("#/components/responses/MessageResponse")
                                            )
                                    )
                            )
                            .addParameter(
                                createParameter()
                                    .name("id")
                                    .in(Parameter.In.PATH)
                                    .required(true)
                                    .schema(
                                        createSchema()
                                            .type(Schema.SchemaType.STRING)
                                    )
                            )
                    )
                    .addPathItem(
                        "/subscribe", createPathItem()
                            .POST(
                                createOperation()
                                    .summary("Subscribe to a webhook")
                                    .operationId("subscribeWebhook")
                                    .requestBody(
                                        createRequestBody()
                                            .content(
                                                createContent()
                                                    .addMediaType(
                                                        "application/json", createMediaType()
                                                            .schema(
                                                                createSchema()
                                                                    .ref("#/components/schemas/Body")
                                                            )
                                                    )
                                            )
                                            .required(true)
                                    )
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "201", createAPIResponse()
                                                    .description("Webhook created")
                                            )
                                    )
                                    .addCallback(
                                        "myEvent", createCallback()
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
                                            )
                                    )
                                    .addCallback(
                                        "pingEvent", createCallback()
                                            .ref("#/components/callbacks/PingCallback")
                                    )
                            )
                    )
            )
            .components(
                createComponents()
                    .addSchema(
                        "Message", createSchema()
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
                        "Node", createSchema()
                            .type(Schema.SchemaType.OBJECT)
                            .addProperty(
                                "name", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                            .addProperty(
                                "children", createSchema()
                                    .type(Schema.SchemaType.ARRAY)
                                    .items(
                                        createSchema()
                                            .ref("#/components/schemas/Node")
                                    )
                            )
                    )
                    .addSchema(
                        "Error", createSchema()
                            .type(Schema.SchemaType.OBJECT)
                            .addProperty(
                                "code", createSchema()
                                    .type(Schema.SchemaType.INTEGER)
                                    .format("int32")
                            )
                            .addProperty(
                                "message", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                    )
                    .addSchema(
                        "Body", createSchema()
                            .addRequired("callbackUrl")
                            .type(Schema.SchemaType.OBJECT)
                            .addProperty(
                                "callbackUrl", createSchema()
                                    .type(Schema.SchemaType.STRING)
                                    .format("uri")
                                    .example("https://myserver.com/send/callback/here")
                            )
                            .addProperty(
                                "items", createSchema()
                                    .type(Schema.SchemaType.ARRAY)
                                    .items(
                                        createSchema()
                                            .ref("#/components/schemas/Info")
                                    )
                            )
                    )
                    .addSchema(
                        "Info", createSchema()
                            .discriminator(
                                createDiscriminator()
                                    .propertyName("infoType")
                                    .addMapping("simple", "#/components/schemas/SimpleInfo")
                                    .addMapping("extended", "#/components/schemas/ExtendedInfo")
                            )
                            .type(Schema.SchemaType.OBJECT)
                            .addOneOf(
                                createSchema()
                                    .ref("#/components/schemas/SimpleInfo")
                            )
                            .addOneOf(
                                createSchema()
                                    .ref("#/components/schemas/ExtendedInfo")
                            )
                    )
                    .addSchema(
                        "SimpleInfo", createSchema()
                            .type(Schema.SchemaType.OBJECT)
                            .addProperty(
                                "infoType", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                            .addProperty(
                                "description", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                    )
                    .addSchema(
                        "ExtendedInfo", createSchema()
                            .type(Schema.SchemaType.OBJECT)
                            .addProperty(
                                "infoType", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                            .addProperty(
                                "code", createSchema()
                                    .type(Schema.SchemaType.INTEGER)
                                    .format("int32")
                            )
                            .addProperty(
                                "data", createSchema()
                                    .type(Schema.SchemaType.OBJECT)
                                    .not(
                                        createSchema()
                                            .type(Schema.SchemaType.INTEGER)
                                    )
                            )
                            .addProperty(
                                "info", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                    )
                    .addSchema(
                        "RootClass", createSchema()
                            .discriminator(
                                createDiscriminator()
                                    .propertyName("type")
                            )
                            .addRequired("type")
                            .type(Schema.SchemaType.OBJECT)
                            .addProperty(
                                "type", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                            .addProperty(
                                "prop0", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                    )
                    .addSchema(
                        "ParentObject", createSchema()
                            .addAllOf(
                                createSchema()
                                    .ref("#/components/schemas/RootClass")
                            )
                            .addAllOf(
                                createSchema()
                                    .type(Schema.SchemaType.OBJECT)
                                    .addProperty(
                                        "prop1", createSchema()
                                            .type(Schema.SchemaType.STRING)
                                    )
                                    .addProperty(
                                        "prop2", createSchema()
                                            .type(Schema.SchemaType.STRING)
                                    )
                            )
                    )
                    .addSchema(
                        "ChildObject", createSchema()
                            .addAllOf(
                                createSchema()
                                    .ref("#/components/schemas/ParentObject")
                            )
                            .addAllOf(
                                createSchema()
                                    .type(Schema.SchemaType.OBJECT)
                                    .addProperty(
                                        "prop3", createSchema()
                                            .type(Schema.SchemaType.STRING)
                                    )
                                    .addProperty(
                                        "prop4", createSchema()
                                            .type(Schema.SchemaType.STRING)
                                    )
                            )
                    )
                    .addResponse(
                        "MessageResponse", createAPIResponse()
                            .description("OK")
                            .content(
                                createContent()
                                    .addMediaType(
                                        "*/*", createMediaType()
                                            .schema(
                                                createSchema()
                                                    .ref("#/components/schemas/Message")
                                            )
                                    )
                            )
                    )
                    .addParameter(
                        "LanguageParam", createParameter()
                            .name("language")
                            .in(Parameter.In.QUERY)
                            .description("Language of the message")
                            .schema(
                                createSchema()
                                    .addEnumeration("english")
                                    .addEnumeration("french")
                                    .addEnumeration("german")
                                    .addEnumeration("italian")
                                    .type(Schema.SchemaType.STRING)
                            )
                    )
                    .addExample(
                        "ExampleEntry", createExample()
                            .description("Some description")
                            .addExtension("x-test", "value")
                    )
                    .addRequestBody(
                        "UpdateBody", createRequestBody()
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
                    )
                    .addHeader(
                        "HeaderEntry", createHeader()
                            .description("Some description")
                            .style(Header.Style.SIMPLE)
                            .addExtension("x-test", "value")
                    )
                    .addSecurityScheme(
                        "basic-auth", createSecurityScheme()
                            .type(SecurityScheme.Type.HTTP)
                            .description("Login and password")
                            .scheme("basic")
                    )
                    .addSecurityScheme(
                        "api-key-auth", createSecurityScheme()
                            .type(SecurityScheme.Type.APIKEY)
                            .name("X-ACCESS-API-KEY")
                            .in(SecurityScheme.In.HEADER)
                            .scheme("basic")
                    )
                    .addLink(
                        "LinkEntry", createLink()
                            .operationId("postMessage")
                            .description("Some description")
                            .addExtension("x-test", "value")
                    )
                    .addCallback(
                        "PingCallback", createCallback()
                            .addPathItem(
                                "{$request.body#/callbackUrl}", createPathItem()
                                    .GET(
                                        createOperation()
                                            .addParameter(
                                                createParameter()
                                                    .name("x-callback-id")
                                                    .in(Parameter.In.HEADER)
                                                    .description("id")
                                                    .required(true)
                                                    .style(Parameter.Style.SIMPLE)
                                                    .explode(false)
                                                    .schema(
                                                        createSchema()
                                                            .type(Schema.SchemaType.STRING)
                                                    )
                                            )
                                            .responses(
                                                createAPIResponses()
                                                    .addAPIResponse(
                                                        "200", createAPIResponse()
                                                            .description("Your server returns this code if it accepts the callback")
                                                    )
                                            )
                                    )
                            )
                    )
            );
    }
}