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
package org.openapitools.empoa.swagger.core.tck;

import java.io.IOException;
import java.util.List;

import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;
import org.openapitools.empoa.extended.tck.AbstractSerializerTest;
import org.openapitools.empoa.gson.OASGsonSerializer;
import org.openapitools.empoa.swagger.core.internal.SwAdapter;

import com.google.gson.Gson;

import io.swagger.parser.OpenAPIParser;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

public class ParserAndSerializerWithGsonTckTest extends AbstractSerializerTest {

    @Override
    protected OpenAPI getOpenAPISpec(Specs spec) throws IOException {
        String json = readInputFromResource(spec);

        OpenAPIParser openApiParser = new OpenAPIParser();
        ParseOptions options = new ParseOptions();

        SwaggerParseResult parserResult = openApiParser.readContents(json, null, options);

        // tag::usage[]
        io.swagger.v3.oas.models.OpenAPI swaggerOpenAPI = parserResult.getOpenAPI();
        OpenAPI openAPI = SwAdapter.toOpenAPI(swaggerOpenAPI);
        // end::usage[]

        // Swagger-Parser is adding some values (probably some default that make sense) that are not desirable for this test:
        if (Specs.HELLO == spec) {
            List<Parameter> parameters = openAPI.getPaths()
                .getPathItem("/hello/{name}")
                .getGET()
                .getParameters();
            set2ValuesToNull(parameters.get(0));
            set3ValuesToNull(parameters.get(1));
        } else if (Specs.BIG == spec) {
            set2ValuesToNull(
                openAPI.getPaths()
                    .getPathItem("/tree/{name}")
                    .getGET()
                    .getParameters()
                    .get(0)
            );
            set2ValuesToNull(
                openAPI.getPaths()
                    .getPathItem("/messages/{id}")
                    .getParameters()
                    .get(0)
            );
            set3ValuesToNull(
                openAPI.getPaths()
                    .getPathItem("/messages/{id}")
                    .getPUT()
                    .getParameters()
                    .get(0)
            );
            set3ValuesToNull(
                openAPI.getComponents()
                    .getParameters()
                    .get("LanguageParam")
            );
            openAPI.getComponents()
                .getHeaders()
                .get("HeaderEntry")
                .setExplode(null);
        }
        return openAPI;
    }

    private void set2ValuesToNull(Parameter languageParameter) {
        languageParameter.setExplode(null);
        languageParameter.setStyle(null);
    }

    private void set3ValuesToNull(Parameter languageParameter) {
        languageParameter.setExplode(null);
        languageParameter.setRequired(null);
        languageParameter.setStyle(null);
    }

    @Override
    protected String convertToJson(OpenAPI openAPI) {
        Gson gson = OASGsonSerializer.instance();
        return gson.toJson(openAPI);
    }
}
