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

import java.util.TreeMap;

import org.eclipse.microprofile.openapi.models.Components;
import org.eclipse.microprofile.openapi.models.ExternalDocumentation;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.Operation;
import org.eclipse.microprofile.openapi.models.PathItem;
import org.eclipse.microprofile.openapi.models.Paths;
import org.eclipse.microprofile.openapi.models.callbacks.Callback;
import org.eclipse.microprofile.openapi.models.examples.Example;
import org.eclipse.microprofile.openapi.models.headers.Header;
import org.eclipse.microprofile.openapi.models.info.Contact;
import org.eclipse.microprofile.openapi.models.info.Info;
import org.eclipse.microprofile.openapi.models.info.License;
import org.eclipse.microprofile.openapi.models.links.Link;
import org.eclipse.microprofile.openapi.models.media.Content;
import org.eclipse.microprofile.openapi.models.media.Discriminator;
import org.eclipse.microprofile.openapi.models.media.Encoding;
import org.eclipse.microprofile.openapi.models.media.MediaType;
import org.eclipse.microprofile.openapi.models.media.Schema;
import org.eclipse.microprofile.openapi.models.media.XML;
import org.eclipse.microprofile.openapi.models.parameters.Parameter;
import org.eclipse.microprofile.openapi.models.parameters.RequestBody;
import org.eclipse.microprofile.openapi.models.responses.APIResponse;
import org.eclipse.microprofile.openapi.models.responses.APIResponses;
import org.eclipse.microprofile.openapi.models.security.OAuthFlow;
import org.eclipse.microprofile.openapi.models.security.OAuthFlows;
import org.eclipse.microprofile.openapi.models.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.models.security.SecurityScheme;
import org.eclipse.microprofile.openapi.models.servers.Server;
import org.eclipse.microprofile.openapi.models.servers.ServerVariable;
import org.eclipse.microprofile.openapi.models.tags.Tag;
import org.openapitools.empoa.util.visitor.OASVisitResult;
import org.openapitools.empoa.util.visitor.OASVisitorAdapter;

class SortMapsVisitor extends OASVisitorAdapter {

    private SortMapsConfig config;

    SortMapsVisitor(SortMapsConfig config) {
        this.config = config;
    }

    @Override
    public OASVisitResult visit(OpenAPI openAPI, String jsonPath) {
        if (config.getSortOpenAPIExtensions() && openAPI.getExtensions() != null) {
            openAPI.setExtensions(new TreeMap<>(openAPI.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(APIResponse apiResponse, String jsonPath) {
        if (config.getSortAPIResponseHeaders() && apiResponse.getHeaders() != null) {
            apiResponse.setHeaders(new TreeMap<>(apiResponse.getHeaders()));
        }
        if (config.getSortAPIResponseLinks() && apiResponse.getLinks() != null) {
            apiResponse.setLinks(new TreeMap<>(apiResponse.getLinks()));
        }
        if (config.getSortAPIResponseExtensions() && apiResponse.getExtensions() != null) {
            apiResponse.setExtensions(new TreeMap<>(apiResponse.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(APIResponses apiResponses, String jsonPath) {
        if (config.getSortAPIResponsesAPIResponses() && apiResponses.getAPIResponses() != null) {
            apiResponses.setAPIResponses(new TreeMap<>(apiResponses.getAPIResponses()));
        }
        if (config.getSortAPIResponsesExtensions() && apiResponses.getExtensions() != null) {
            apiResponses.setExtensions(new TreeMap<>(apiResponses.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Callback callback, String jsonPath) {
        if (config.getSortCallbackPathItems() && callback.getPathItems() != null) {
            callback.setPathItems(new TreeMap<>(callback.getPathItems()));
        }
        if (config.getSortCallbackExtensions() && callback.getExtensions() != null) {
            callback.setExtensions(new TreeMap<>(callback.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Components components, String jsonPath) {
        if (config.getSortComponentsSchemas() && components.getSchemas() != null) {
            components.setSchemas(new TreeMap<>(components.getSchemas()));
        }
        if (config.getSortComponentsResponses() && components.getResponses() != null) {
            components.setResponses(new TreeMap<>(components.getResponses()));
        }
        if (config.getSortComponentsParameters() && components.getParameters() != null) {
            components.setParameters(new TreeMap<>(components.getParameters()));
        }
        if (config.getSortComponentsExamples() && components.getExamples() != null) {
            components.setExamples(new TreeMap<>(components.getExamples()));
        }
        if (config.getSortComponentsRequestBodies() && components.getRequestBodies() != null) {
            components.setRequestBodies(new TreeMap<>(components.getRequestBodies()));
        }
        if (config.getSortComponentsHeaders() && components.getHeaders() != null) {
            components.setHeaders(new TreeMap<>(components.getHeaders()));
        }
        if (config.getSortComponentsSecuritySchemes() && components.getSecuritySchemes() != null) {
            components.setSecuritySchemes(new TreeMap<>(components.getSecuritySchemes()));
        }
        if (config.getSortComponentsLinks() && components.getLinks() != null) {
            components.setLinks(new TreeMap<>(components.getLinks()));
        }
        if (config.getSortComponentsCallbacks() && components.getCallbacks() != null) {
            components.setCallbacks(new TreeMap<>(components.getCallbacks()));
        }
        if (config.getSortComponentsExtensions() && components.getExtensions() != null) {
            components.setExtensions(new TreeMap<>(components.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Contact contact, String jsonPath) {
        if (config.getSortContactExtensions() && contact.getExtensions() != null) {
            contact.setExtensions(new TreeMap<>(contact.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Content content, String jsonPath) {
        if (config.getSortContentMediaTypes() && content.getMediaTypes() != null) {
            content.setMediaTypes(new TreeMap<>(content.getMediaTypes()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Discriminator discriminator, String jsonPath) {
        if (config.getSortDiscriminatorMapping() && discriminator.getMapping() != null) {
            discriminator.setMapping(new TreeMap<>(discriminator.getMapping()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Encoding encoding, String jsonPath) {
        if (config.getSortEncodingHeaders() && encoding.getHeaders() != null) {
            encoding.setHeaders(new TreeMap<>(encoding.getHeaders()));
        }
        if (config.getSortEncodingExtensions() && encoding.getExtensions() != null) {
            encoding.setExtensions(new TreeMap<>(encoding.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Example example, String jsonPath) {
        if (config.getSortExampleExtensions() && example.getExtensions() != null) {
            example.setExtensions(new TreeMap<>(example.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(ExternalDocumentation externalDocumentation, String jsonPath) {
        if (config.getSortExternalDocumentationExtensions() && externalDocumentation.getExtensions() != null) {
            externalDocumentation.setExtensions(new TreeMap<>(externalDocumentation.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Header header, String jsonPath) {
        if (config.getSortHeaderExamples() && header.getExamples() != null) {
            header.setExamples(new TreeMap<>(header.getExamples()));
        }
        if (config.getSortHeaderExtensions() && header.getExtensions() != null) {
            header.setExtensions(new TreeMap<>(header.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Info info, String jsonPath) {
        if (config.getSortInfoExtensions() && info.getExtensions() != null) {
            info.setExtensions(new TreeMap<>(info.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(License license, String jsonPath) {
        if (config.getSortLicenseExtensions() && license.getExtensions() != null) {
            license.setExtensions(new TreeMap<>(license.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Link link, String jsonPath) {
        if (config.getSortLinkParameters() && link.getParameters() != null) {
            link.setParameters(new TreeMap<>(link.getParameters()));
        }
        if (config.getSortLinkExtensions() && link.getExtensions() != null) {
            link.setExtensions(new TreeMap<>(link.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(MediaType mediaType, String jsonPath) {
        if (config.getSortMediaTypeExamples() && mediaType.getExamples() != null) {
            mediaType.setExamples(new TreeMap<>(mediaType.getExamples()));
        }
        if (config.getSortMediaTypeEncoding() && mediaType.getEncoding() != null) {
            mediaType.setEncoding(new TreeMap<>(mediaType.getEncoding()));
        }
        if (config.getSortMediaTypeExtensions() && mediaType.getExtensions() != null) {
            mediaType.setExtensions(new TreeMap<>(mediaType.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(OAuthFlow oAuthFlow, String jsonPath) {
        if (config.getSortOAuthFlowExtensions() && oAuthFlow.getExtensions() != null) {
            oAuthFlow.setExtensions(new TreeMap<>(oAuthFlow.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(OAuthFlows oAuthFlows, String jsonPath) {
        if (config.getSortOAuthFlowsExtensions() && oAuthFlows.getExtensions() != null) {
            oAuthFlows.setExtensions(new TreeMap<>(oAuthFlows.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Operation operation, String jsonPath) {
        if (config.getSortOperationCallbacks() && operation.getCallbacks() != null) {
            operation.setCallbacks(new TreeMap<>(operation.getCallbacks()));
        }
        if (config.getSortOperationExtensions() && operation.getExtensions() != null) {
            operation.setExtensions(new TreeMap<>(operation.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Parameter parameter, String jsonPath) {
        if (config.getSortParameterExamples() && parameter.getExamples() != null) {
            parameter.setExamples(new TreeMap<>(parameter.getExamples()));
        }
        if (config.getSortParameterExtensions() && parameter.getExtensions() != null) {
            parameter.setExtensions(new TreeMap<>(parameter.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(PathItem pathItem, String jsonPath) {
        if (config.getSortPathItemExtensions() && pathItem.getExtensions() != null) {
            pathItem.setExtensions(new TreeMap<>(pathItem.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Paths paths, String jsonPath) {
        if (config.getSortPathsPathItems() && paths.getPathItems() != null) {
            paths.setPathItems(new TreeMap<>(paths.getPathItems()));
        }
        if (config.getSortPathsExtensions() && paths.getExtensions() != null) {
            paths.setExtensions(new TreeMap<>(paths.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(RequestBody requestBody, String jsonPath) {
        if (config.getSortRequestBodyExtensions() && requestBody.getExtensions() != null) {
            requestBody.setExtensions(new TreeMap<>(requestBody.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Schema schema, String jsonPath) {
        if (config.getSortSchemaProperties() && schema.getProperties() != null) {
            schema.setProperties(new TreeMap<>(schema.getProperties()));
        }
        if (config.getSortSchemaExtensions() && schema.getExtensions() != null) {
            schema.setExtensions(new TreeMap<>(schema.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(SecurityRequirement securityRequirement, String jsonPath) {
        if (config.getSortSecurityRequirementSchemes() && securityRequirement.getSchemes() != null) {
            securityRequirement.setSchemes(new TreeMap<>(securityRequirement.getSchemes()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(SecurityScheme securityScheme, String jsonPath) {
        if (config.getSortSecuritySchemeExtensions() && securityScheme.getExtensions() != null) {
            securityScheme.setExtensions(new TreeMap<>(securityScheme.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Server server, String jsonPath) {
        if (config.getSortServerExtensions() && server.getExtensions() != null) {
            server.setExtensions(new TreeMap<>(server.getExtensions()));
        }
        if (config.getSortServerVariables() && server.getVariables() != null) {
            server.setVariables(new TreeMap<>(server.getVariables()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(ServerVariable serverVariable, String jsonPath) {
        if (config.getSortServerVariableExtensions() && serverVariable.getExtensions() != null) {
            serverVariable.setExtensions(new TreeMap<>(serverVariable.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Tag tag, String jsonPath) {
        if (config.getSortTagExtensions() && tag.getExtensions() != null) {
            tag.setExtensions(new TreeMap<>(tag.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(XML xml, String jsonPath) {
        if (config.getSortXMLExtensions() && xml.getExtensions() != null) {
            xml.setExtensions(new TreeMap<>(xml.getExtensions()));
        }
        return OASVisitResult.CONTINUE;
    }

}
