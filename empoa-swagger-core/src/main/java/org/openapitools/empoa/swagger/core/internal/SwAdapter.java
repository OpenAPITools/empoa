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
package org.openapitools.empoa.swagger.core.internal;

public class SwAdapter {

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.Components} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.Components} instance
     *
     * @param swComponents
     *            swagger-core instance
     * @return components
     */
    public static org.eclipse.microprofile.openapi.models.Components toComponents(io.swagger.v3.oas.models.Components swComponents) {
        if (swComponents == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.SwComponents();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.SwComponents(swComponents);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.ExternalDocumentation} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.ExternalDocumentation} instance
     *
     * @param swExternalDocumentation
     *            swagger-core instance
     * @return externalDocumentation
     */
    public static org.eclipse.microprofile.openapi.models.ExternalDocumentation toExternalDocumentation(io.swagger.v3.oas.models.ExternalDocumentation swExternalDocumentation) {
        if (swExternalDocumentation == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation(swExternalDocumentation);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.OpenAPI} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.OpenAPI} instance
     *
     * @param swOpenAPI
     *            swagger-core instance
     * @return openAPI
     */
    public static org.eclipse.microprofile.openapi.models.OpenAPI toOpenAPI(io.swagger.v3.oas.models.OpenAPI swOpenAPI) {
        if (swOpenAPI == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.SwOpenAPI();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.SwOpenAPI(swOpenAPI);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.Operation} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.Operation} instance
     *
     * @param swOperation
     *            swagger-core instance
     * @return operation
     */
    public static org.eclipse.microprofile.openapi.models.Operation toOperation(io.swagger.v3.oas.models.Operation swOperation) {
        if (swOperation == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.SwOperation();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.SwOperation(swOperation);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.PathItem} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.PathItem} instance
     *
     * @param swPathItem
     *            swagger-core instance
     * @return pathItem
     */
    public static org.eclipse.microprofile.openapi.models.PathItem toPathItem(io.swagger.v3.oas.models.PathItem swPathItem) {
        if (swPathItem == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.SwPathItem();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.SwPathItem(swPathItem);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.Paths} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.Paths} instance
     *
     * @param swPaths
     *            swagger-core instance
     * @return paths
     */
    public static org.eclipse.microprofile.openapi.models.Paths toPaths(io.swagger.v3.oas.models.Paths swPaths) {
        if (swPaths == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.SwPaths();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.SwPaths(swPaths);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.callbacks.Callback} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.callbacks.Callback} instance
     *
     * @param swCallback
     *            swagger-core instance
     * @return callback
     */
    public static org.eclipse.microprofile.openapi.models.callbacks.Callback toCallback(io.swagger.v3.oas.models.callbacks.Callback swCallback) {
        if (swCallback == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.callbacks.SwCallback();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.callbacks.SwCallback(swCallback);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.examples.Example} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.examples.Example} instance
     *
     * @param swExample
     *            swagger-core instance
     * @return example
     */
    public static org.eclipse.microprofile.openapi.models.examples.Example toExample(io.swagger.v3.oas.models.examples.Example swExample) {
        if (swExample == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.examples.SwExample();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.examples.SwExample(swExample);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.headers.Header} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.headers.Header} instance
     *
     * @param swHeader
     *            swagger-core instance
     * @return header
     */
    public static org.eclipse.microprofile.openapi.models.headers.Header toHeader(io.swagger.v3.oas.models.headers.Header swHeader) {
        if (swHeader == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader(swHeader);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.info.Contact} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.info.Contact} instance
     *
     * @param swContact
     *            swagger-core instance
     * @return contact
     */
    public static org.eclipse.microprofile.openapi.models.info.Contact toContact(io.swagger.v3.oas.models.info.Contact swContact) {
        if (swContact == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.info.SwContact();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.info.SwContact(swContact);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.info.Info} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.info.Info} instance
     *
     * @param swInfo
     *            swagger-core instance
     * @return info
     */
    public static org.eclipse.microprofile.openapi.models.info.Info toInfo(io.swagger.v3.oas.models.info.Info swInfo) {
        if (swInfo == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.info.SwInfo();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.info.SwInfo(swInfo);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.info.License} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.info.License} instance
     *
     * @param swLicense
     *            swagger-core instance
     * @return license
     */
    public static org.eclipse.microprofile.openapi.models.info.License toLicense(io.swagger.v3.oas.models.info.License swLicense) {
        if (swLicense == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.info.SwLicense();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.info.SwLicense(swLicense);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.links.Link} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.links.Link} instance
     *
     * @param swLink
     *            swagger-core instance
     * @return link
     */
    public static org.eclipse.microprofile.openapi.models.links.Link toLink(io.swagger.v3.oas.models.links.Link swLink) {
        if (swLink == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.links.SwLink();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.links.SwLink(swLink);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.media.Content} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.media.Content} instance
     *
     * @param swContent
     *            swagger-core instance
     * @return content
     */
    public static org.eclipse.microprofile.openapi.models.media.Content toContent(io.swagger.v3.oas.models.media.Content swContent) {
        if (swContent == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.media.SwContent();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.media.SwContent(swContent);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.media.Discriminator} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.media.Discriminator} instance
     *
     * @param swDiscriminator
     *            swagger-core instance
     * @return discriminator
     */
    public static org.eclipse.microprofile.openapi.models.media.Discriminator toDiscriminator(io.swagger.v3.oas.models.media.Discriminator swDiscriminator) {
        if (swDiscriminator == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.media.SwDiscriminator();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.media.SwDiscriminator(swDiscriminator);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.media.Encoding} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.media.Encoding} instance
     *
     * @param swEncoding
     *            swagger-core instance
     * @return encoding
     */
    public static org.eclipse.microprofile.openapi.models.media.Encoding toEncoding(io.swagger.v3.oas.models.media.Encoding swEncoding) {
        if (swEncoding == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.media.SwEncoding();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.media.SwEncoding(swEncoding);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.media.MediaType} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.media.MediaType} instance
     *
     * @param swMediaType
     *            swagger-core instance
     * @return mediaType
     */
    public static org.eclipse.microprofile.openapi.models.media.MediaType toMediaType(io.swagger.v3.oas.models.media.MediaType swMediaType) {
        if (swMediaType == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.media.SwMediaType();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.media.SwMediaType(swMediaType);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.media.Schema} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.media.Schema} instance
     *
     * @param swSchema
     *            swagger-core instance
     * @return schema
     */
    public static org.eclipse.microprofile.openapi.models.media.Schema toSchema(io.swagger.v3.oas.models.media.Schema swSchema) {
        if (swSchema == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.media.SwSchema();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.media.SwSchema(swSchema);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.media.XML} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.media.XML} instance
     *
     * @param swXML
     *            swagger-core instance
     * @return xML
     */
    public static org.eclipse.microprofile.openapi.models.media.XML toXML(io.swagger.v3.oas.models.media.XML swXML) {
        if (swXML == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.media.SwXML();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.media.SwXML(swXML);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.parameters.Parameter} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.parameters.Parameter} instance
     *
     * @param swParameter
     *            swagger-core instance
     * @return parameter
     */
    public static org.eclipse.microprofile.openapi.models.parameters.Parameter toParameter(io.swagger.v3.oas.models.parameters.Parameter swParameter) {
        if (swParameter == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter(swParameter);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.parameters.RequestBody} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.parameters.RequestBody} instance
     *
     * @param swRequestBody
     *            swagger-core instance
     * @return requestBody
     */
    public static org.eclipse.microprofile.openapi.models.parameters.RequestBody toRequestBody(io.swagger.v3.oas.models.parameters.RequestBody swRequestBody) {
        if (swRequestBody == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.parameters.SwRequestBody();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.parameters.SwRequestBody(swRequestBody);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.responses.APIResponse} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.responses.ApiResponse} instance
     *
     * @param swApiResponse
     *            swagger-core instance
     * @return apiResponse
     */
    public static org.eclipse.microprofile.openapi.models.responses.APIResponse toAPIResponse(io.swagger.v3.oas.models.responses.ApiResponse swApiResponse) {
        if (swApiResponse == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponse();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponse(swApiResponse);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.responses.APIResponses} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.responses.ApiResponses} instance
     *
     * @param swApiResponses
     *            swagger-core instance
     * @return apiResponses
     */
    public static org.eclipse.microprofile.openapi.models.responses.APIResponses toAPIResponses(io.swagger.v3.oas.models.responses.ApiResponses swApiResponses) {
        if (swApiResponses == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponses();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponses(swApiResponses);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.security.OAuthFlow} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.security.OAuthFlow} instance
     *
     * @param swOAuthFlow
     *            swagger-core instance
     * @return oAuthFlow
     */
    public static org.eclipse.microprofile.openapi.models.security.OAuthFlow toOAuthFlow(io.swagger.v3.oas.models.security.OAuthFlow swOAuthFlow) {
        if (swOAuthFlow == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow(swOAuthFlow);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.security.OAuthFlows} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.security.OAuthFlows} instance
     *
     * @param swOAuthFlows
     *            swagger-core instance
     * @return oAuthFlows
     */
    public static org.eclipse.microprofile.openapi.models.security.OAuthFlows toOAuthFlows(io.swagger.v3.oas.models.security.OAuthFlows swOAuthFlows) {
        if (swOAuthFlows == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlows();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlows(swOAuthFlows);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.security.Scopes} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.security.Scopes} instance
     *
     * @param swScopes
     *            swagger-core instance
     * @return scopes
     */
    public static org.eclipse.microprofile.openapi.models.security.Scopes toScopes(io.swagger.v3.oas.models.security.Scopes swScopes) {
        if (swScopes == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.security.SwScopes();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.security.SwScopes(swScopes);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.security.SecurityRequirement} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.security.SecurityRequirement} instance
     *
     * @param swSecurityRequirement
     *            swagger-core instance
     * @return securityRequirement
     */
    public static org.eclipse.microprofile.openapi.models.security.SecurityRequirement toSecurityRequirement(io.swagger.v3.oas.models.security.SecurityRequirement swSecurityRequirement) {
        if (swSecurityRequirement == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement(swSecurityRequirement);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.security.SecurityScheme} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.security.SecurityScheme} instance
     *
     * @param swSecurityScheme
     *            swagger-core instance
     * @return securityScheme
     */
    public static org.eclipse.microprofile.openapi.models.security.SecurityScheme toSecurityScheme(io.swagger.v3.oas.models.security.SecurityScheme swSecurityScheme) {
        if (swSecurityScheme == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityScheme();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityScheme(swSecurityScheme);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.servers.Server} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.servers.Server} instance
     *
     * @param swServer
     *            swagger-core instance
     * @return server
     */
    public static org.eclipse.microprofile.openapi.models.servers.Server toServer(io.swagger.v3.oas.models.servers.Server swServer) {
        if (swServer == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.servers.SwServer();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.servers.SwServer(swServer);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.servers.ServerVariable} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.servers.ServerVariable} instance
     *
     * @param swServerVariable
     *            swagger-core instance
     * @return serverVariable
     */
    public static org.eclipse.microprofile.openapi.models.servers.ServerVariable toServerVariable(io.swagger.v3.oas.models.servers.ServerVariable swServerVariable) {
        if (swServerVariable == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariable();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariable(swServerVariable);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.servers.ServerVariables} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.servers.ServerVariables} instance
     *
     * @param swServerVariables
     *            swagger-core instance
     * @return serverVariables
     */
    public static org.eclipse.microprofile.openapi.models.servers.ServerVariables toServerVariables(io.swagger.v3.oas.models.servers.ServerVariables swServerVariables) {
        if (swServerVariables == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariables();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariables(swServerVariables);
    }

    /**
     * Create a MicroProfile {@link org.eclipse.microprofile.openapi.models.tags.Tag} instance wrapping the swagger-core {@link io.swagger.v3.oas.models.tags.Tag} instance
     *
     * @param swTag
     *            swagger-core instance
     * @return tag
     */
    public static org.eclipse.microprofile.openapi.models.tags.Tag toTag(io.swagger.v3.oas.models.tags.Tag swTag) {
        if (swTag == null) {
            return new org.openapitools.empoa.swagger.core.internal.models.tags.SwTag();
        }
        return new org.openapitools.empoa.swagger.core.internal.models.tags.SwTag(swTag);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.Components} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.Components} instance
     *
     * @param mpComponents
     *            MicroProfile instance
     * @return Components
     */
    public static io.swagger.v3.oas.models.Components toSwComponents(org.eclipse.microprofile.openapi.models.Components mpComponents) {
        if (mpComponents instanceof org.openapitools.empoa.swagger.core.internal.models.SwComponents) {
            return ((org.openapitools.empoa.swagger.core.internal.models.SwComponents) mpComponents).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Components: " + mpComponents);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.ExternalDocumentation} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.ExternalDocumentation} instance
     *
     * @param mpExternalDocumentation
     *            MicroProfile instance
     * @return ExternalDocumentation
     */
    public static io.swagger.v3.oas.models.ExternalDocumentation toSwExternalDocumentation(org.eclipse.microprofile.openapi.models.ExternalDocumentation mpExternalDocumentation) {
        if (mpExternalDocumentation instanceof org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation) {
            return ((org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation) mpExternalDocumentation).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for ExternalDocumentation: " + mpExternalDocumentation);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.OpenAPI} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.OpenAPI} instance
     *
     * @param mpOpenAPI
     *            MicroProfile instance
     * @return OpenAPI
     */
    public static io.swagger.v3.oas.models.OpenAPI toSwOpenAPI(org.eclipse.microprofile.openapi.models.OpenAPI mpOpenAPI) {
        if (mpOpenAPI instanceof org.openapitools.empoa.swagger.core.internal.models.SwOpenAPI) {
            return ((org.openapitools.empoa.swagger.core.internal.models.SwOpenAPI) mpOpenAPI).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for OpenAPI: " + mpOpenAPI);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.Operation} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.Operation} instance
     *
     * @param mpOperation
     *            MicroProfile instance
     * @return Operation
     */
    public static io.swagger.v3.oas.models.Operation toSwOperation(org.eclipse.microprofile.openapi.models.Operation mpOperation) {
        if (mpOperation instanceof org.openapitools.empoa.swagger.core.internal.models.SwOperation) {
            return ((org.openapitools.empoa.swagger.core.internal.models.SwOperation) mpOperation).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Operation: " + mpOperation);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.PathItem} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.PathItem} instance
     *
     * @param mpPathItem
     *            MicroProfile instance
     * @return PathItem
     */
    public static io.swagger.v3.oas.models.PathItem toSwPathItem(org.eclipse.microprofile.openapi.models.PathItem mpPathItem) {
        if (mpPathItem instanceof org.openapitools.empoa.swagger.core.internal.models.SwPathItem) {
            return ((org.openapitools.empoa.swagger.core.internal.models.SwPathItem) mpPathItem).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for PathItem: " + mpPathItem);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.Paths} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.Paths} instance
     *
     * @param mpPaths
     *            MicroProfile instance
     * @return Paths
     */
    public static io.swagger.v3.oas.models.Paths toSwPaths(org.eclipse.microprofile.openapi.models.Paths mpPaths) {
        if (mpPaths instanceof org.openapitools.empoa.swagger.core.internal.models.SwPaths) {
            return ((org.openapitools.empoa.swagger.core.internal.models.SwPaths) mpPaths).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Paths: " + mpPaths);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.callbacks.Callback} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.callbacks.Callback} instance
     *
     * @param mpCallback
     *            MicroProfile instance
     * @return Callback
     */
    public static io.swagger.v3.oas.models.callbacks.Callback toSwCallback(org.eclipse.microprofile.openapi.models.callbacks.Callback mpCallback) {
        if (mpCallback instanceof org.openapitools.empoa.swagger.core.internal.models.callbacks.SwCallback) {
            return ((org.openapitools.empoa.swagger.core.internal.models.callbacks.SwCallback) mpCallback).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Callback: " + mpCallback);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.examples.Example} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.examples.Example} instance
     *
     * @param mpExample
     *            MicroProfile instance
     * @return Example
     */
    public static io.swagger.v3.oas.models.examples.Example toSwExample(org.eclipse.microprofile.openapi.models.examples.Example mpExample) {
        if (mpExample instanceof org.openapitools.empoa.swagger.core.internal.models.examples.SwExample) {
            return ((org.openapitools.empoa.swagger.core.internal.models.examples.SwExample) mpExample).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Example: " + mpExample);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.headers.Header} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.headers.Header} instance
     *
     * @param mpHeader
     *            MicroProfile instance
     * @return Header
     */
    public static io.swagger.v3.oas.models.headers.Header toSwHeader(org.eclipse.microprofile.openapi.models.headers.Header mpHeader) {
        if (mpHeader instanceof org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader) {
            return ((org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader) mpHeader).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Header: " + mpHeader);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.info.Contact} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.info.Contact} instance
     *
     * @param mpContact
     *            MicroProfile instance
     * @return Contact
     */
    public static io.swagger.v3.oas.models.info.Contact toSwContact(org.eclipse.microprofile.openapi.models.info.Contact mpContact) {
        if (mpContact instanceof org.openapitools.empoa.swagger.core.internal.models.info.SwContact) {
            return ((org.openapitools.empoa.swagger.core.internal.models.info.SwContact) mpContact).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Contact: " + mpContact);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.info.Info} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.info.Info} instance
     *
     * @param mpInfo
     *            MicroProfile instance
     * @return Info
     */
    public static io.swagger.v3.oas.models.info.Info toSwInfo(org.eclipse.microprofile.openapi.models.info.Info mpInfo) {
        if (mpInfo instanceof org.openapitools.empoa.swagger.core.internal.models.info.SwInfo) {
            return ((org.openapitools.empoa.swagger.core.internal.models.info.SwInfo) mpInfo).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Info: " + mpInfo);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.info.License} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.info.License} instance
     *
     * @param mpLicense
     *            MicroProfile instance
     * @return License
     */
    public static io.swagger.v3.oas.models.info.License toSwLicense(org.eclipse.microprofile.openapi.models.info.License mpLicense) {
        if (mpLicense instanceof org.openapitools.empoa.swagger.core.internal.models.info.SwLicense) {
            return ((org.openapitools.empoa.swagger.core.internal.models.info.SwLicense) mpLicense).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for License: " + mpLicense);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.links.Link} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.links.Link} instance
     *
     * @param mpLink
     *            MicroProfile instance
     * @return Link
     */
    public static io.swagger.v3.oas.models.links.Link toSwLink(org.eclipse.microprofile.openapi.models.links.Link mpLink) {
        if (mpLink instanceof org.openapitools.empoa.swagger.core.internal.models.links.SwLink) {
            return ((org.openapitools.empoa.swagger.core.internal.models.links.SwLink) mpLink).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Link: " + mpLink);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.media.Content} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.media.Content} instance
     *
     * @param mpContent
     *            MicroProfile instance
     * @return Content
     */
    public static io.swagger.v3.oas.models.media.Content toSwContent(org.eclipse.microprofile.openapi.models.media.Content mpContent) {
        if (mpContent instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwContent) {
            return ((org.openapitools.empoa.swagger.core.internal.models.media.SwContent) mpContent).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Content: " + mpContent);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.media.Discriminator} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.media.Discriminator} instance
     *
     * @param mpDiscriminator
     *            MicroProfile instance
     * @return Discriminator
     */
    public static io.swagger.v3.oas.models.media.Discriminator toSwDiscriminator(org.eclipse.microprofile.openapi.models.media.Discriminator mpDiscriminator) {
        if (mpDiscriminator instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwDiscriminator) {
            return ((org.openapitools.empoa.swagger.core.internal.models.media.SwDiscriminator) mpDiscriminator).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Discriminator: " + mpDiscriminator);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.media.Encoding} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.media.Encoding} instance
     *
     * @param mpEncoding
     *            MicroProfile instance
     * @return Encoding
     */
    public static io.swagger.v3.oas.models.media.Encoding toSwEncoding(org.eclipse.microprofile.openapi.models.media.Encoding mpEncoding) {
        if (mpEncoding instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwEncoding) {
            return ((org.openapitools.empoa.swagger.core.internal.models.media.SwEncoding) mpEncoding).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Encoding: " + mpEncoding);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.media.MediaType} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.media.MediaType} instance
     *
     * @param mpMediaType
     *            MicroProfile instance
     * @return MediaType
     */
    public static io.swagger.v3.oas.models.media.MediaType toSwMediaType(org.eclipse.microprofile.openapi.models.media.MediaType mpMediaType) {
        if (mpMediaType instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwMediaType) {
            return ((org.openapitools.empoa.swagger.core.internal.models.media.SwMediaType) mpMediaType).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for MediaType: " + mpMediaType);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.media.Schema} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.media.Schema} instance
     *
     * @param mpSchema
     *            MicroProfile instance
     * @return Schema
     */
    public static io.swagger.v3.oas.models.media.Schema toSwSchema(org.eclipse.microprofile.openapi.models.media.Schema mpSchema) {
        if (mpSchema instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwSchema) {
            return ((org.openapitools.empoa.swagger.core.internal.models.media.SwSchema) mpSchema).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Schema: " + mpSchema);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.media.XML} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.media.XML} instance
     *
     * @param mpXML
     *            MicroProfile instance
     * @return XML
     */
    public static io.swagger.v3.oas.models.media.XML toSwXML(org.eclipse.microprofile.openapi.models.media.XML mpXML) {
        if (mpXML instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwXML) {
            return ((org.openapitools.empoa.swagger.core.internal.models.media.SwXML) mpXML).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for XML: " + mpXML);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.parameters.Parameter} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.parameters.Parameter} instance
     *
     * @param mpParameter
     *            MicroProfile instance
     * @return Parameter
     */
    public static io.swagger.v3.oas.models.parameters.Parameter toSwParameter(org.eclipse.microprofile.openapi.models.parameters.Parameter mpParameter) {
        if (mpParameter instanceof org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter) {
            return ((org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter) mpParameter).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Parameter: " + mpParameter);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.parameters.RequestBody} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.parameters.RequestBody} instance
     *
     * @param mpRequestBody
     *            MicroProfile instance
     * @return RequestBody
     */
    public static io.swagger.v3.oas.models.parameters.RequestBody toSwRequestBody(org.eclipse.microprofile.openapi.models.parameters.RequestBody mpRequestBody) {
        if (mpRequestBody instanceof org.openapitools.empoa.swagger.core.internal.models.parameters.SwRequestBody) {
            return ((org.openapitools.empoa.swagger.core.internal.models.parameters.SwRequestBody) mpRequestBody).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for RequestBody: " + mpRequestBody);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.responses.ApiResponse} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.responses.APIResponse} instance
     *
     * @param mpAPIResponse
     *            MicroProfile instance
     * @return ApiResponse
     */
    public static io.swagger.v3.oas.models.responses.ApiResponse toSwApiResponse(org.eclipse.microprofile.openapi.models.responses.APIResponse mpAPIResponse) {
        if (mpAPIResponse instanceof org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponse) {
            return ((org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponse) mpAPIResponse).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for APIResponse: " + mpAPIResponse);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.responses.ApiResponses} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.responses.APIResponses} instance
     *
     * @param mpAPIResponses
     *            MicroProfile instance
     * @return ApiResponses
     */
    public static io.swagger.v3.oas.models.responses.ApiResponses toSwApiResponses(org.eclipse.microprofile.openapi.models.responses.APIResponses mpAPIResponses) {
        if (mpAPIResponses instanceof org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponses) {
            return ((org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponses) mpAPIResponses).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for APIResponses: " + mpAPIResponses);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.security.OAuthFlow} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.security.OAuthFlow} instance
     *
     * @param mpOAuthFlow
     *            MicroProfile instance
     * @return OAuthFlow
     */
    public static io.swagger.v3.oas.models.security.OAuthFlow toSwOAuthFlow(org.eclipse.microprofile.openapi.models.security.OAuthFlow mpOAuthFlow) {
        if (mpOAuthFlow instanceof org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow) {
            return ((org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow) mpOAuthFlow).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for OAuthFlow: " + mpOAuthFlow);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.security.OAuthFlows} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.security.OAuthFlows} instance
     *
     * @param mpOAuthFlows
     *            MicroProfile instance
     * @return OAuthFlows
     */
    public static io.swagger.v3.oas.models.security.OAuthFlows toSwOAuthFlows(org.eclipse.microprofile.openapi.models.security.OAuthFlows mpOAuthFlows) {
        if (mpOAuthFlows instanceof org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlows) {
            return ((org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlows) mpOAuthFlows).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for OAuthFlows: " + mpOAuthFlows);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.security.Scopes} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.security.Scopes} instance
     *
     * @param mpScopes
     *            MicroProfile instance
     * @return Scopes
     */
    public static io.swagger.v3.oas.models.security.Scopes toSwScopes(org.eclipse.microprofile.openapi.models.security.Scopes mpScopes) {
        if (mpScopes instanceof org.openapitools.empoa.swagger.core.internal.models.security.SwScopes) {
            return ((org.openapitools.empoa.swagger.core.internal.models.security.SwScopes) mpScopes).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Scopes: " + mpScopes);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.security.SecurityRequirement} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.security.SecurityRequirement} instance
     *
     * @param mpSecurityRequirement
     *            MicroProfile instance
     * @return SecurityRequirement
     */
    public static io.swagger.v3.oas.models.security.SecurityRequirement toSwSecurityRequirement(org.eclipse.microprofile.openapi.models.security.SecurityRequirement mpSecurityRequirement) {
        if (mpSecurityRequirement instanceof org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement) {
            return ((org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement) mpSecurityRequirement).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for SecurityRequirement: " + mpSecurityRequirement);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.security.SecurityScheme} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.security.SecurityScheme} instance
     *
     * @param mpSecurityScheme
     *            MicroProfile instance
     * @return SecurityScheme
     */
    public static io.swagger.v3.oas.models.security.SecurityScheme toSwSecurityScheme(org.eclipse.microprofile.openapi.models.security.SecurityScheme mpSecurityScheme) {
        if (mpSecurityScheme instanceof org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityScheme) {
            return ((org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityScheme) mpSecurityScheme).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for SecurityScheme: " + mpSecurityScheme);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.servers.Server} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.servers.Server} instance
     *
     * @param mpServer
     *            MicroProfile instance
     * @return Server
     */
    public static io.swagger.v3.oas.models.servers.Server toSwServer(org.eclipse.microprofile.openapi.models.servers.Server mpServer) {
        if (mpServer instanceof org.openapitools.empoa.swagger.core.internal.models.servers.SwServer) {
            return ((org.openapitools.empoa.swagger.core.internal.models.servers.SwServer) mpServer).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Server: " + mpServer);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.servers.ServerVariable} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.servers.ServerVariable} instance
     *
     * @param mpServerVariable
     *            MicroProfile instance
     * @return ServerVariable
     */
    public static io.swagger.v3.oas.models.servers.ServerVariable toSwServerVariable(org.eclipse.microprofile.openapi.models.servers.ServerVariable mpServerVariable) {
        if (mpServerVariable instanceof org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariable) {
            return ((org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariable) mpServerVariable).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for ServerVariable: " + mpServerVariable);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.servers.ServerVariables} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.servers.ServerVariables} instance
     *
     * @param mpServerVariables
     *            MicroProfile instance
     * @return ServerVariables
     */
    public static io.swagger.v3.oas.models.servers.ServerVariables toSwServerVariables(org.eclipse.microprofile.openapi.models.servers.ServerVariables mpServerVariables) {
        if (mpServerVariables instanceof org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariables) {
            return ((org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariables) mpServerVariables).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for ServerVariables: " + mpServerVariables);
    }

    /**
     * Unwrap the swagger-core {@link io.swagger.v3.oas.models.tags.Tag} element contained in the MicroProfile {@link org.eclipse.microprofile.openapi.models.tags.Tag} instance
     *
     * @param mpTag
     *            MicroProfile instance
     * @return Tag
     */
    public static io.swagger.v3.oas.models.tags.Tag toSwTag(org.eclipse.microprofile.openapi.models.tags.Tag mpTag) {
        if (mpTag instanceof org.openapitools.empoa.swagger.core.internal.models.tags.SwTag) {
            return ((org.openapitools.empoa.swagger.core.internal.models.tags.SwTag) mpTag).getSw();
        }
        throw new IllegalArgumentException("Unxpected type for Tag: " + mpTag);
    }
}
