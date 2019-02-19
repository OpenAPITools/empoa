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

public final class MultipleResponsesSpec {
    public static OpenAPI create() {
        return createOpenAPI()
            .openapi("3.0.1")
            .info(
                createInfo()
                    .title("A Specification")
                    .version("1.0")
            )
            .addServer(
                createServer()
                    .url("http://localhost:8080/")
            )
            .paths(
                createPaths()
                    .addPathItem(
                        "/ping", createPathItem()
                            .GET(
                                createOperation()
                                    .operationId("pingGet")
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "200", createAPIResponse()
                                                    .description("OK")
                                                    .content(
                                                        createContent()
                                                            .addMediaType(
                                                                "application/json", createMediaType()
                                                                    .schema(
                                                                        createSchema()
                                                                            .ref("#/components/schemas/PingObject")
                                                                    )
                                                            )
                                                    )
                                            )
                                            .addAPIResponse(
                                                "4XX", createAPIResponse()
                                                    .ref("#/components/responses/BusinessErrorResponse")
                                            )
                                            .addAPIResponse(
                                                "default", createAPIResponse()
                                                    .description("Server Error")
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
                            .POST(
                                createOperation()
                                    .operationId("pingPost")
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "405", createAPIResponse()
                                                    .description("POST is not allowed")
                                            )
                                    )
                            )
                    )
            )
            .components(
                createComponents()
                    .addSchema(
                        "PingObject", createSchema()
                            .title("Title")
                            .type(Schema.SchemaType.OBJECT)
                            .addProperty(
                                "id", createSchema()
                                    .type(Schema.SchemaType.INTEGER)
                                    .format("int32")
                            )
                            .addProperty(
                                "name", createSchema()
                                    .type(Schema.SchemaType.STRING)
                            )
                            .description("Some description")
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
                    .addResponse(
                        "BusinessErrorResponse", createAPIResponse()
                            .description("Business Error")
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
            );
    }
}
