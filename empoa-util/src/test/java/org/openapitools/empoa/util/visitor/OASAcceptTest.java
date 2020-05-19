/*******************************************************************************
 * Copyright 2020 Jeremie Bresson
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
package org.openapitools.empoa.util.visitor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.junit.jupiter.api.Test;
import org.openapitools.empoa.extended.tck.specs.BigSpec;
import org.openapitools.empoa.extended.tck.specs.MultipleResponsesSpec;
import org.openapitools.empoa.extended.tck.specs.PingSpec;

public class OASAcceptTest {

    @Test
    public void testOperationIdWithPingSpec() throws Exception {
        OpenAPI openAPI = PingSpec.create();

        // tag::usage[]
        OperationIdVisitor visitor = new OperationIdVisitor();
        OASAccept.accept(visitor, openAPI); // <1>

        Map<String, String> operationIds = visitor.getOperationIds();
        // end::usage[]

        assertThat(operationIds).hasSize(1);
        assertThat(operationIds).containsEntry("$.paths.['/ping'].get.operationId", "pingGet");
    }

    @Test
    public void testReferenceVisitorWithMultipleResponsesSpec() throws Exception {
        OpenAPI openAPI = MultipleResponsesSpec.create();
        ReferenceVisitor visitor = new ReferenceVisitor(openAPI);
        OASAccept.accept(visitor, openAPI);

        assertThat(visitor.getReferences()).containsExactlyInAnyOrder(
            "#/components/schemas/Error",
            "#/components/schemas/PingObject",
            "#/components/responses/BusinessErrorResponse"
        );
    }

    @Test
    public void testReferenceVisitorWithBigSpec() throws Exception {
        OpenAPI openAPI = BigSpec.create();
        ReferenceVisitor visitor = new ReferenceVisitor(openAPI);
        OASAccept.accept(visitor, openAPI);

        assertThat(visitor.getReferences()).containsExactlyInAnyOrder(
            "#/components/callbacks/PingCallback",
            "#/components/parameters/LanguageParam",
            "#/components/requestBodies/UpdateBody",
            "#/components/responses/MessageResponse",
            "#/components/schemas/Body",
            "#/components/schemas/Error",
            "#/components/schemas/ExtendedInfo",
            "#/components/schemas/Info",
            "#/components/schemas/Message",
            "#/components/schemas/Node",
            "#/components/schemas/ParentObject",
            "#/components/schemas/RootClass",
            "#/components/schemas/SimpleInfo"
        );
    }
}
