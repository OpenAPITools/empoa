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

//tag::usage[]
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.microprofile.openapi.models.Components;
import org.eclipse.microprofile.openapi.models.Operation;

public class OperationIdVisitor extends OASVisitorAdapter {

    private Map<String, String> operationIds = new HashMap<>();

    public Map<String, String> getOperationIds() {
        return Collections.unmodifiableMap(operationIds);
    }

    @Override
    public OASVisitResult visit(Operation operation, String jsonPath) {
        operationIds.put(jsonPath + ".operationId", operation.getOperationId()); // <1>
        return OASVisitResult.CONTINUE; // <2>
    }

    @Override
    public OASVisitResult visit(Components components, String jsonPath) {
        return OASVisitResult.TERMINATE; // <3>
    }
}
// end::usage[]
