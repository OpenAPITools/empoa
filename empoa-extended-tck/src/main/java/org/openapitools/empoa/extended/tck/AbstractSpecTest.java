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
import org.openapitools.empoa.extended.tck.specs.HelloSpec;
import org.openapitools.empoa.extended.tck.specs.PingSpec;
import org.openapitools.empoa.extended.tck.specs.TodoappSpec;
import org.testng.annotations.Test;

public abstract class AbstractSpecTest {

    protected static enum Specs {
        PING, HELLO, TODOAPP
    }

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

    protected abstract void runTest(Specs spec) throws Exception;

    protected OpenAPI createOpenAPI(Specs spec) throws IOException {
        switch (spec) {
        case PING:
            return PingSpec.create();
        case HELLO:
            return HelloSpec.create();
        case TODOAPP:
            return TodoappSpec.create();
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
