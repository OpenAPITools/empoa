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
import org.eclipse.microprofile.openapi.models.media.Schema;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;

public final class HelloSpec {
    public static OpenAPI create() {
        return createOpenAPI()
            .openapi("3.0.1")
            .info(
                createInfo()
                    .title("Hello Specification")
                    .description("This specification says Hello")
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
                    .url("http://api.example.io/")
                    .description("Secondary server")
            )
            .paths(
                createPaths()
                    .addPathItem(
                        "/hello/{name}", createPathItem()
                            .GET(
                                createOperation()
                                    .summary("Retun an hello object")
                                    .operationId("hello")
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
                                    .addParameter(
                                        createParameter()
                                            .name("language")
                                            .in(Parameter.In.QUERY)
                                            .description("Language used to say hello")
                                            .schema(
                                                createSchema()
                                                    .addEnumeration("english")
                                                    .addEnumeration("french")
                                                    .addEnumeration("german")
                                                    .addEnumeration("italian")
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
                                                                            .ref("#/components/schemas/Hello")
                                                                    )
                                                            )
                                                            .addMediaType(
                                                                "application/xml", createMediaType()
                                                                    .schema(
                                                                        createSchema()
                                                                            .ref("#/components/schemas/Hello")
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
                            )
                    )
            )
            .components(
                createComponents()
                    .addSchema(
                        "Hello", createSchema()
                            .type(Schema.SchemaType.OBJECT)
                            .addProperty(
                                "timestamp", createSchema()
                                    .type(Schema.SchemaType.INTEGER)
                                    .description("Unix timestamp (generation time)")
                                    .format("int32")
                            )
                            .addProperty(
                                "message", createSchema()
                                    .type(Schema.SchemaType.STRING)
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
            );
    }
}
