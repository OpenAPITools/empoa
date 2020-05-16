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
package org.openapitools.empoa.jackson;

import static org.assertj.core.api.Assertions.assertThat;

import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.openapitools.empoa.extended.tck.AbstractSpecTest;

public class OpenAPISerializerToYamlTest extends AbstractSpecTest {

    @Override
    protected void runTest(Specs spec) throws Exception {
        OpenAPI openAPI = getOpenAPISpec(spec);
        assertThat(openAPI).isNotNull();

        String expected = readFromResource(toResourceName(spec));
        String yaml = OpenAPISerializer.serialize(openAPI, OpenAPISerializer.Format.YAML);

        assertThat(yaml).isEqualToIgnoringNewLines(expected);
    }

    private String toResourceName(Specs spec) {
        switch (spec) {
        case PING:
            return "/jackson-serializer/yaml/ping.yaml";
        case HELLO:
            return "/jackson-serializer/yaml/hello.yaml";
        case TODOAPP:
            return "/jackson-serializer/yaml/todoapp.yaml";
        case MULTIPLE_RESPONSES:
            return "/jackson-serializer/yaml/multiple-responses.yaml";
        case BIG:
            return "/jackson-serializer/yaml/big.yaml";
        default:
            throw new IllegalArgumentException("Unknown spec: " + spec);
        }
    }

}
