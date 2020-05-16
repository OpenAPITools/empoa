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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.junit.jupiter.api.Test;
import org.openapitools.empoa.extended.tck.specs.BigSpec;
import org.openapitools.empoa.extended.tck.specs.HelloSpec;
import org.openapitools.empoa.extended.tck.specs.MultipleResponsesSpec;
import org.openapitools.empoa.extended.tck.specs.PingSpec;
import org.openapitools.empoa.extended.tck.specs.RefWithSiblingValuesSpec;
import org.openapitools.empoa.extended.tck.specs.TodoappSpec;

public abstract class AbstractSpecTest {

    protected static enum Specs {
        PING,
        HELLO,
        TODOAPP,
        MULTIPLE_RESPONSES,
        BIG,
        REF_WITH_SIBLING_VALUES
    }

    protected static final String PING_JSON = "/extended-tck/specs/ping.json";
    protected static final String HELLO_JSON = "/extended-tck/specs/hello.json";
    protected static final String TODOAPP_JSON = "/extended-tck/specs/todoapp.json";
    protected static final String MULTIPLE_RESPONSES_JSON = "/extended-tck/specs/multiple-responses.json";
    protected static final String BIG_JSON = "/extended-tck/specs/big.json";
    protected static final String REF_WITH_SIBLING_VALUES_EXPECTED_JSON = "/extended-tck/specs/ref-with-sibling-values-expected.json";

    @Test
    public void testPingSpec() throws Exception {
        runTest(Specs.PING);
    }

    @Test
    public void testHelloSpec() throws Exception {
        runTest(Specs.HELLO);
    }

    @Test
    public void testTodoappSpec() throws Exception {
        runTest(Specs.TODOAPP);
    }

    @Test
    public void testMultipleResponsesSpec() throws Exception {
        runTest(Specs.MULTIPLE_RESPONSES);
    }

    @Test
    public void testBigSpec() throws Exception {
        runTest(Specs.BIG);
    }

    protected abstract void runTest(Specs spec) throws Exception;

    protected OpenAPI getOpenAPISpec(Specs spec) throws IOException {
        switch (spec) {
        case PING:
            return PingSpec.create();
        case HELLO:
            return HelloSpec.create();
        case TODOAPP:
            return TodoappSpec.create();
        case MULTIPLE_RESPONSES:
            return MultipleResponsesSpec.create();
        case BIG:
            return BigSpec.create();
        case REF_WITH_SIBLING_VALUES:
            return RefWithSiblingValuesSpec.create();
        default:
            throw new IllegalArgumentException("Unknown spec: " + spec);
        }
    }

    protected String readJsonSpec(Specs spec) throws IOException {
        String name = toJsonSpecName(spec);
        return read(getClass().getResourceAsStream(name));
    }

    private String toJsonSpecName(Specs spec) {
        switch (spec) {
        case PING:
            return PING_JSON;
        case HELLO:
            return HELLO_JSON;
        case TODOAPP:
            return TODOAPP_JSON;
        case MULTIPLE_RESPONSES:
            return MULTIPLE_RESPONSES_JSON;
        case BIG:
            return BIG_JSON;
        case REF_WITH_SIBLING_VALUES:
            return REF_WITH_SIBLING_VALUES_EXPECTED_JSON;
        default:
            throw new IllegalArgumentException("Unknown spec: " + spec);
        }
    }

    protected String readFromResource(String name) throws IOException {
        return read(getClass().getResourceAsStream(name));
    }

    public static String read(InputStream inputStream) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            return bufferedReader.lines()
                .collect(Collectors.joining("\n"));
        }
    }
}
