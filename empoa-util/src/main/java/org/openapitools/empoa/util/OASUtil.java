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
package org.openapitools.empoa.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.Operation;
import org.eclipse.microprofile.openapi.models.PathItem;
import org.eclipse.microprofile.openapi.models.PathItem.HttpMethod;
import org.eclipse.microprofile.openapi.models.callbacks.Callback;
import org.eclipse.microprofile.openapi.models.examples.Example;
import org.eclipse.microprofile.openapi.models.headers.Header;
import org.eclipse.microprofile.openapi.models.links.Link;
import org.eclipse.microprofile.openapi.models.media.Schema;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;
import org.eclipse.microprofile.openapi.models.parameters.RequestBody;
import org.eclipse.microprofile.openapi.models.responses.APIResponse;
import org.eclipse.microprofile.openapi.models.security.SecurityScheme;
import org.openapitools.empoa.util.visitor.OASAccept;

public class OASUtil {

    public static final String REF_PREFIX_API_RESPONSE = "#/components/responses/";
    public static final String REF_PREFIX_CALLBACK = "#/components/callbacks/";
    public static final String REF_PREFIX_EXAMPLE = "#/components/examples/";
    public static final String REF_PREFIX_HEADER = "#/components/headers/";
    public static final String REF_PREFIX_LINK = "#/components/links/";
    public static final String REF_PREFIX_PARAMETER = "#/components/parameters/";
    public static final String REF_PREFIX_REQUEST_BODY = "#/components/requestBodies/";
    public static final String REF_PREFIX_SCHEMA = "#/components/schemas/";
    public static final String REF_PREFIX_SECURITY_SCHEME = "#/components/securitySchemes/";

    public static void sortMaps(OpenAPI openAPI) {
        sortMaps(openAPI, new SortMapsConfig());
    }

    public static void sortMaps(OpenAPI openAPI, SortMapsConfig config) {
        SortMapsVisitor visitor = new SortMapsVisitor(config);
        OASAccept.accept(visitor, openAPI);
    }

    public static boolean containsAPIResponse(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_API_RESPONSE, refValue);
        return openAPI.getComponents() != null &&
            openAPI.getComponents()
                .getResponses() != null &&
            openAPI.getComponents()
                .getResponses()
                .containsKey(simpleName);
    }

    public static Optional<APIResponse> findReferencedAPIResponse(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_API_RESPONSE, refValue);
        if (openAPI.getComponents() == null) {
            return Optional.empty();
        }
        if (openAPI.getComponents()
            .getResponses() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(
            openAPI.getComponents()
                .getResponses()
                .get(simpleName)
        );
    }

    public static boolean containsCallback(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_CALLBACK, refValue);
        return openAPI.getComponents() != null &&
            openAPI.getComponents()
                .getCallbacks() != null &&
            openAPI.getComponents()
                .getCallbacks()
                .containsKey(simpleName);
    }

    public static Optional<Callback> findReferencedCallback(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_CALLBACK, refValue);
        if (openAPI.getComponents() == null) {
            return Optional.empty();
        }
        if (openAPI.getComponents()
            .getCallbacks() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(
            openAPI.getComponents()
                .getCallbacks()
                .get(simpleName)
        );
    }

    public static boolean containsExample(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_EXAMPLE, refValue);
        return openAPI.getComponents() != null &&
            openAPI.getComponents()
                .getExamples() != null &&
            openAPI.getComponents()
                .getExamples()
                .containsKey(simpleName);
    }

    public static Optional<Example> findReferencedExample(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_EXAMPLE, refValue);
        if (openAPI.getComponents() == null) {
            return Optional.empty();
        }
        if (openAPI.getComponents()
            .getExamples() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(
            openAPI.getComponents()
                .getExamples()
                .get(simpleName)
        );
    }

    public static boolean containsHeader(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_HEADER, refValue);
        return openAPI.getComponents() != null &&
            openAPI.getComponents()
                .getHeaders() != null &&
            openAPI.getComponents()
                .getHeaders()
                .containsKey(simpleName);
    }

    public static Optional<Header> findReferencedHeader(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_HEADER, refValue);
        if (openAPI.getComponents() == null) {
            return Optional.empty();
        }
        if (openAPI.getComponents()
            .getHeaders() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(
            openAPI.getComponents()
                .getHeaders()
                .get(simpleName)
        );
    }

    public static boolean containsLink(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_LINK, refValue);
        return openAPI.getComponents() != null &&
            openAPI.getComponents()
                .getLinks() != null &&
            openAPI.getComponents()
                .getLinks()
                .containsKey(simpleName);
    }

    public static Optional<Link> findReferencedLink(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_LINK, refValue);
        if (openAPI.getComponents() == null) {
            return Optional.empty();
        }
        if (openAPI.getComponents()
            .getLinks() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(
            openAPI.getComponents()
                .getLinks()
                .get(simpleName)
        );
    }

    public static boolean containsParameter(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_PARAMETER, refValue);
        return openAPI.getComponents() != null &&
            openAPI.getComponents()
                .getParameters() != null &&
            openAPI.getComponents()
                .getParameters()
                .containsKey(simpleName);
    }

    public static Optional<Parameter> findReferencedParameter(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_PARAMETER, refValue);
        if (openAPI.getComponents() == null) {
            return Optional.empty();
        }
        if (openAPI.getComponents()
            .getParameters() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(
            openAPI.getComponents()
                .getParameters()
                .get(simpleName)
        );
    }

    public static boolean containsRequestBody(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_REQUEST_BODY, refValue);
        return openAPI.getComponents() != null &&
            openAPI.getComponents()
                .getRequestBodies() != null &&
            openAPI.getComponents()
                .getRequestBodies()
                .containsKey(simpleName);
    }

    public static Optional<RequestBody> findReferencedRequestBody(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_REQUEST_BODY, refValue);
        if (openAPI.getComponents() == null) {
            return Optional.empty();
        }
        if (openAPI.getComponents()
            .getRequestBodies() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(
            openAPI.getComponents()
                .getRequestBodies()
                .get(simpleName)
        );
    }

    public static boolean containsSecurityScheme(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_SECURITY_SCHEME, refValue);
        return openAPI.getComponents() != null &&
            openAPI.getComponents()
                .getSecuritySchemes() != null &&
            openAPI.getComponents()
                .getSecuritySchemes()
                .containsKey(simpleName);
    }

    public static Optional<SecurityScheme> findReferencedSecurityScheme(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_SECURITY_SCHEME, refValue);
        if (openAPI.getComponents() == null) {
            return Optional.empty();
        }
        if (openAPI.getComponents()
            .getSecuritySchemes() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(
            openAPI.getComponents()
                .getSecuritySchemes()
                .get(simpleName)
        );
    }

    public static boolean containsSchema(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_SCHEMA, refValue);
        return openAPI.getComponents() != null &&
            openAPI.getComponents()
                .getSchemas() != null &&
            openAPI.getComponents()
                .getSchemas()
                .containsKey(simpleName);
    }

    public static Optional<Schema> findReferencedSchema(OpenAPI openAPI, String refValue) {
        String simpleName = toSimpleName(REF_PREFIX_SCHEMA, refValue);
        if (openAPI.getComponents() == null) {
            return Optional.empty();
        }
        if (openAPI.getComponents()
            .getSchemas() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(
            openAPI.getComponents()
                .getSchemas()
                .get(simpleName)
        );
    }

    public static void createComponents(OpenAPI openAPI) {
        if (openAPI.getComponents() == null) {
            openAPI.setComponents(OASFactory.createComponents());
        }
    }

    private static String toSimpleName(String refPrefix, String refValue) {
        return refValue.startsWith(refPrefix) ? refValue.substring(refPrefix.length()) : refValue;
    }

    public static List<Parameter> getAllParameters(PathItem pathItem, HttpMethod httpMethod) {
        if (pathItem == null) {
            throw new IllegalArgumentException("parameter pathItem can not be null");
        }
        if (httpMethod == null) {
            throw new IllegalArgumentException("parameter httpMethod can not be null");
        }
        List<Parameter> allParameters = new ArrayList<>();
        if (pathItem.getParameters() != null) {
            allParameters.addAll(pathItem.getParameters());
        }
        Operation operation = pathItem.getOperations()
            .get(httpMethod);
        if (operation != null && operation.getParameters() != null) {
            allParameters.addAll(operation.getParameters());
        }
        return allParameters;
    }

    /**
     * @deprecated Use {@link PathItem#setOperation(HttpMethod, Operation)} instead
     * @param pathItem
     * @param httpMethod
     * @param operation
     */
    @Deprecated
    public static void setOperation(PathItem pathItem, HttpMethod httpMethod, Operation operation) {
        if (pathItem == null) {
            throw new IllegalArgumentException("parameter pathItem can not be null");
        }
        pathItem.setOperation(httpMethod, operation);
    }

}
