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

public final class TodoappSpec {
    public static OpenAPI create() {
        return createOpenAPI()
            .openapi("3.0.1")
            .info(
                createInfo()
                    .title("A TODO-Task list application")
                    .description("A simple application to handle tasks.")
                    .license(
                        createLicense()
                            .name("Eclipse Public License 2.0")
                            .url("https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.html")
                    )
                    .version("1.0.0")
            )
            .addServer(
                createServer()
                    .url("http://localhost:8080/todoapp")
            )
            .addTag(
                createTag()
                    .name("task")
                    .description("Task management")
            )
            .paths(
                createPaths()
                    .addPathItem(
                        "/task", createPathItem()
                            .GET(
                                createOperation()
                                    .addTag("task")
                                    .summary("Get the list of all tasks")
                                    .operationId("tasksGetAll")
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "200", createAPIResponse()
                                                    .description("List of all tasks")
                                                    .content(
                                                        createContent()
                                                            .addMediaType(
                                                                "application/json", createMediaType()
                                                                    .schema(
                                                                        createSchema()
                                                                            .type(Schema.SchemaType.ARRAY)
                                                                            .items(
                                                                                createSchema()
                                                                                    .ref("#/components/schemas/Task")
                                                                            )
                                                                    )
                                                            )
                                                    )
                                            )
                                            .addAPIResponse(
                                                "default", createAPIResponse()
                                                    .description("Generic error response")
                                                    .content(
                                                        createContent()
                                                            .addMediaType(
                                                                "application/json", createMediaType()
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
                                    .addTag("task")
                                    .summary("Create a new task")
                                    .operationId("tasksCreate")
                                    .requestBody(
                                        createRequestBody()
                                            .content(
                                                createContent()
                                                    .addMediaType(
                                                        "application/json", createMediaType()
                                                            .schema(
                                                                createSchema()
                                                                    .ref("#/components/schemas/Task")
                                                            )
                                                    )
                                            )
                                    )
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "200", createAPIResponse()
                                                    .description("The created task")
                                                    .content(
                                                        createContent()
                                                            .addMediaType(
                                                                "application/json", createMediaType()
                                                                    .schema(
                                                                        createSchema()
                                                                            .ref("#/components/schemas/Task")
                                                                    )
                                                            )
                                                    )
                                            )
                                            .addAPIResponse(
                                                "default", createAPIResponse()
                                                    .description("Generic error response")
                                                    .content(
                                                        createContent()
                                                            .addMediaType(
                                                                "application/json", createMediaType()
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
                    .addPathItem(
                        "/task/{taskId}", createPathItem()
                            .GET(
                                createOperation()
                                    .addTag("task")
                                    .summary("Get a single task based on its id")
                                    .operationId("tasksRead")
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "200", createAPIResponse()
                                                    .description("Ok")
                                                    .content(
                                                        createContent()
                                                            .addMediaType(
                                                                "application/json", createMediaType()
                                                                    .schema(
                                                                        createSchema()
                                                                            .ref("#/components/schemas/Task")
                                                                    )
                                                            )
                                                    )
                                            )
                                            .addAPIResponse(
                                                "default", createAPIResponse()
                                                    .description("Generic error response")
                                                    .content(
                                                        createContent()
                                                            .addMediaType(
                                                                "application/json", createMediaType()
                                                                    .schema(
                                                                        createSchema()
                                                                            .ref("#/components/schemas/Error")
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                            )
                            .PUT(
                                createOperation()
                                    .addTag("task")
                                    .summary("Update an existing task")
                                    .operationId("tasksUpdate")
                                    .requestBody(
                                        createRequestBody()
                                            .content(
                                                createContent()
                                                    .addMediaType(
                                                        "application/json", createMediaType()
                                                            .schema(
                                                                createSchema()
                                                                    .ref("#/components/schemas/Task")
                                                            )
                                                    )
                                            )
                                    )
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "200", createAPIResponse()
                                                    .description("The updated task")
                                                    .content(
                                                        createContent()
                                                            .addMediaType(
                                                                "application/json", createMediaType()
                                                                    .schema(
                                                                        createSchema()
                                                                            .ref("#/components/schemas/Task")
                                                                    )
                                                            )
                                                    )
                                            )
                                            .addAPIResponse(
                                                "default", createAPIResponse()
                                                    .description("Generic error response")
                                                    .content(
                                                        createContent()
                                                            .addMediaType(
                                                                "application/json", createMediaType()
                                                                    .schema(
                                                                        createSchema()
                                                                            .ref("#/components/schemas/Error")
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                            )
                            .DELETE(
                                createOperation()
                                    .addTag("task")
                                    .summary("Delete an existing task")
                                    .operationId("tasksDelete")
                                    .responses(
                                        createAPIResponses()
                                            .addAPIResponse(
                                                "204", createAPIResponse()
                                                    .description("Task deleted response")
                                            )
                                            .addAPIResponse(
                                                "default", createAPIResponse()
                                                    .description("Generic error response")
                                                    .content(
                                                        createContent()
                                                            .addMediaType(
                                                                "application/json", createMediaType()
                                                                    .schema(
                                                                        createSchema()
                                                                            .ref("#/components/schemas/Error")
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                            )
                            .addParameter(
                                createParameter()
                                    .name("taskId")
                                    .in(Parameter.In.PATH)
                                    .description("The id of the task")
                                    .required(true)
                                    .style(Parameter.Style.SIMPLE)
                                    .explode(false)
                                    .schema(
                                        createSchema()
                                            .type(Schema.SchemaType.STRING)
                                    )
                                    .example("e1cb23d0-6cbe-4a29-b586-bfa424bc93fd")
                            )
                    )
            )
            .components(
                createComponents()
                    .addSchema(
                        "Task", createSchema()
                            .addRequired("description")
                            .type(Schema.SchemaType.OBJECT)
                            .addProperty(
                                "completed", createSchema()
                                    .type(Schema.SchemaType.BOOLEAN)
                                    .description("indicates if a taks is completed or not")
                            )
                            .addProperty(
                                "description", createSchema()
                                    .type(Schema.SchemaType.STRING)
                                    .description("description of the task")
                                    .example("My important task")
                            )
                            .addProperty(
                                "id", createSchema()
                                    .type(Schema.SchemaType.STRING)
                                    .description("id of the taks")
                                    .readOnly(true)
                                    .example("e1cb23d0-6cbe-4a29-b586-bfa424bc93fd")
                            )
                            .description("Object representing a Task")
                    )
                    .addSchema(
                        "Error", createSchema()
                            .type(Schema.SchemaType.OBJECT)
                            .addProperty(
                                "code", createSchema()
                                    .type(Schema.SchemaType.INTEGER)
                                    .description("Error code that identify of the error")
                                    .format("int32")
                                    .example(1000)
                            )
                            .addProperty(
                                "message", createSchema()
                                    .type(Schema.SchemaType.STRING)
                                    .description("Short description of the error")
                                    .example("Could not perform the task")
                            )
                            .description("Object representing an error")
                    )
            );
    }
}
