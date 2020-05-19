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

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.callbacks.Callback;
import org.eclipse.microprofile.openapi.models.examples.Example;
import org.eclipse.microprofile.openapi.models.headers.Header;
import org.eclipse.microprofile.openapi.models.links.Link;
import org.eclipse.microprofile.openapi.models.media.Schema;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;
import org.eclipse.microprofile.openapi.models.parameters.RequestBody;
import org.eclipse.microprofile.openapi.models.responses.APIResponse;
import org.eclipse.microprofile.openapi.models.security.SecurityScheme;
import org.openapitools.empoa.util.OASUtil;

public class ReferenceVisitor extends OASVisitorAdapter {

    private Set<String> references;
    private OpenAPI spec;

    public ReferenceVisitor(OpenAPI spec) {
        this.spec = spec;
        references = new HashSet<>();
    }

    public Set<String> getReferences() {
        return Collections.unmodifiableSet(references);
    }

    @Override
    public OASVisitResult visit(APIResponse referenceable, String jsonPath) {
        String ref = referenceable.getRef();
        if (ref != null) {
            Optional<APIResponse> find = OASUtil.findReferencedAPIResponse(spec, ref);
            if (find.isPresent() && !references.contains(ref)) {
                references.add(ref);
            }
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Callback referenceable, String jsonPath) {
        String ref = referenceable.getRef();
        if (ref != null) {
            Optional<Callback> find = OASUtil.findReferencedCallback(spec, ref);
            if (find.isPresent() && !references.contains(ref)) {
                references.add(ref);
            }
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Example referenceable, String jsonPath) {
        String ref = referenceable.getRef();
        if (ref != null) {
            Optional<Example> find = OASUtil.findReferencedExample(spec, ref);
            if (find.isPresent() && !references.contains(ref)) {
                references.add(ref);
            }
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Header referenceable, String jsonPath) {
        String ref = referenceable.getRef();
        if (ref != null) {
            Optional<Header> find = OASUtil.findReferencedHeader(spec, ref);
            if (find.isPresent() && !references.contains(ref)) {
                references.add(ref);
            }
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Link referenceable, String jsonPath) {
        String ref = referenceable.getRef();
        if (ref != null) {
            Optional<Link> find = OASUtil.findReferencedLink(spec, ref);
            if (find.isPresent() && !references.contains(ref)) {
                references.add(ref);
            }
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Parameter referenceable, String jsonPath) {
        String ref = referenceable.getRef();
        if (ref != null) {
            Optional<Parameter> find = OASUtil.findReferencedParameter(spec, ref);
            if (find.isPresent() && !references.contains(ref)) {
                references.add(ref);
            }
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(RequestBody referenceable, String jsonPath) {
        String ref = referenceable.getRef();
        if (ref != null) {
            Optional<RequestBody> find = OASUtil.findReferencedRequestBody(spec, ref);
            if (find.isPresent() && !references.contains(ref)) {
                references.add(ref);
            }
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(SecurityScheme referenceable, String jsonPath) {
        String ref = referenceable.getRef();
        if (ref != null) {
            Optional<SecurityScheme> find = OASUtil.findReferencedSecurityScheme(spec, ref);
            if (find.isPresent() && !references.contains(ref)) {
                references.add(ref);
            }
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Schema referenceable, String jsonPath) {
        String ref = referenceable.getRef();
        if (ref != null) {
            Optional<Schema> find = OASUtil.findReferencedSchema(spec, ref);
            if (find.isPresent() && !references.contains(ref)) {
                references.add(ref);
            }
        }
        return OASVisitResult.CONTINUE;
    }
}
