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
package org.openapitools.empoa.swagger.core.tck.models.parameters;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.openapitools.empoa.extended.tck.models.parameters.ParameterTest;
import org.openapitools.empoa.swagger.core.internal.SwAdapter;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.media.BooleanSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

public class ParameterTckTest extends ParameterTest {

    @Test
    void testGetIn() throws Exception {
        OpenAPI swOpenAPI = new OpenAPI()
            .paths(
                new Paths()
                    .addPathItem(
                        "/test", new PathItem()
                            .get(
                                new Operation()
                                    .operationId("testGet")
                                    .addParametersItem(
                                        new Parameter().in("Query")
                                            .name("extended")
                                            .schema(new BooleanSchema())
                                    )
                                    .responses(
                                        new ApiResponses()
                                            .addApiResponse(
                                                "200", new ApiResponse()
                                                    .description("OK")
                                            )
                                    )
                            )
                    )
            );
        org.eclipse.microprofile.openapi.models.OpenAPI openAPI = SwAdapter.toOpenAPI(swOpenAPI);
        org.eclipse.microprofile.openapi.models.parameters.Parameter parameter = openAPI.getPaths()
            .getPathItem("/test")
            .getGET()
            .getParameters()
            .get(0);
        assertThat(parameter.getIn()).isEqualTo(org.eclipse.microprofile.openapi.models.parameters.Parameter.In.QUERY);
    }

}
