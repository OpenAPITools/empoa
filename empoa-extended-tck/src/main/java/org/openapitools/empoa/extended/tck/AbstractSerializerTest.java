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
package org.openapitools.empoa.extended.tck;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.*;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;

import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.testng.annotations.Test;

public abstract class AbstractSerializerTest extends AbstractSpecTest {

    protected static final String PING_JSON = "/extended-tck/specs/ping.json";
    protected static final String HELLO_JSON = "/extended-tck/specs/hello.json";
    protected static final String TODOAPP_JSON = "/extended-tck/specs/todoapp.json";
    protected static final String MULTIPLE_RESPONSES_JSON = "/extended-tck/specs/multiple-responses.json";
    protected static final String REF_WITH_SIBLING_VALUES_EXPECTED_JSON = "/extended-tck/specs/ref-with-sibling-values-expected.json";
    protected static final String REF_WITH_SIBLING_VALUES_INPUT_JSON = "/extended-tck/specs/ref-with-sibling-values.json";

    @Test
    public void testRefWithSiblingValuesSpec() throws Exception {
        runTest(Specs.REF_WITH_SIBLING_VALUES);
    }

    @Override
    protected void runTest(Specs spec) throws Exception {
        OpenAPI openAPI = createOpenAPI(spec);
        assertThat(openAPI).isNotNull();

        String expected = readExpectedFromResource(spec);
        String json = convertToJson(openAPI);

        assertThatJson(json).isEqualTo(expected);
    }

    protected abstract String convertToJson(OpenAPI openAPI) throws IOException;

    private String readExpectedFromResource(Specs spec) throws IOException {
        String name = toExpectedResourceName(spec);
        return read(getClass().getResourceAsStream(name));
    }

    private String toExpectedResourceName(Specs spec) {
        switch (spec) {
        case PING:
            return PING_JSON;
        case HELLO:
            return HELLO_JSON;
        case TODOAPP:
            return TODOAPP_JSON;
        case MULTIPLE_RESPONSES:
            return MULTIPLE_RESPONSES_JSON;
        case REF_WITH_SIBLING_VALUES:
            return REF_WITH_SIBLING_VALUES_EXPECTED_JSON;
        default:
            throw new IllegalArgumentException("Unknown spec: " + spec);
        }
    }

    protected String readInputFromResource(Specs spec) throws IOException {
        String name = toInputResourceName(spec);
        return read(getClass().getResourceAsStream(name));
    }

    private String toInputResourceName(Specs spec) {
        switch (spec) {
        case PING:
            return PING_JSON;
        case HELLO:
            return HELLO_JSON;
        case TODOAPP:
            return TODOAPP_JSON;
        case MULTIPLE_RESPONSES:
            return MULTIPLE_RESPONSES_JSON;
        case REF_WITH_SIBLING_VALUES:
            return REF_WITH_SIBLING_VALUES_INPUT_JSON;
        default:
            throw new IllegalArgumentException("Unknown spec: " + spec);
        }
    }
}
