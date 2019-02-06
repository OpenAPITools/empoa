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
package org.openapitools.empoa.swagger.core;

import org.openapitools.empoa.swagger.core.internal.SwAdapter;

public class SwOASFactory {

    /**
     * Create a MicroProfile-OpenAPI instance corresponding to the swagger-core element
     *
     * @param sw
     *            swagger-core instance
     * @param <T>
     *            type of MicroProfile-OpenAPI that should be returned
     * @return the corresponding MicroProfile-OpenAPI instance
     */
    @SuppressWarnings("unchecked")
    public static <T extends org.eclipse.microprofile.openapi.models.Constructible> T createObject(Object sw) {
        if (sw == null) {
            throw new IllegalArgumentException("Swagger-core instance can not be null");
        } else if (sw instanceof io.swagger.v3.oas.models.Components) {
            return (T) SwAdapter.toComponents((io.swagger.v3.oas.models.Components) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.ExternalDocumentation) {
            return (T) SwAdapter.toExternalDocumentation((io.swagger.v3.oas.models.ExternalDocumentation) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.OpenAPI) {
            return (T) SwAdapter.toOpenAPI((io.swagger.v3.oas.models.OpenAPI) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.Operation) {
            return (T) SwAdapter.toOperation((io.swagger.v3.oas.models.Operation) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.PathItem) {
            return (T) SwAdapter.toPathItem((io.swagger.v3.oas.models.PathItem) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.Paths) {
            return (T) SwAdapter.toPaths((io.swagger.v3.oas.models.Paths) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.callbacks.Callback) {
            return (T) SwAdapter.toCallback((io.swagger.v3.oas.models.callbacks.Callback) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.examples.Example) {
            return (T) SwAdapter.toExample((io.swagger.v3.oas.models.examples.Example) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.headers.Header) {
            return (T) SwAdapter.toHeader((io.swagger.v3.oas.models.headers.Header) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.info.Contact) {
            return (T) SwAdapter.toContact((io.swagger.v3.oas.models.info.Contact) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.info.Info) {
            return (T) SwAdapter.toInfo((io.swagger.v3.oas.models.info.Info) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.info.License) {
            return (T) SwAdapter.toLicense((io.swagger.v3.oas.models.info.License) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.links.Link) {
            return (T) SwAdapter.toLink((io.swagger.v3.oas.models.links.Link) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.media.Content) {
            return (T) SwAdapter.toContent((io.swagger.v3.oas.models.media.Content) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.media.Discriminator) {
            return (T) SwAdapter.toDiscriminator((io.swagger.v3.oas.models.media.Discriminator) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.media.Encoding) {
            return (T) SwAdapter.toEncoding((io.swagger.v3.oas.models.media.Encoding) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.media.MediaType) {
            return (T) SwAdapter.toMediaType((io.swagger.v3.oas.models.media.MediaType) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.media.Schema) {
            return (T) SwAdapter.toSchema((io.swagger.v3.oas.models.media.Schema) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.media.XML) {
            return (T) SwAdapter.toXML((io.swagger.v3.oas.models.media.XML) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.parameters.Parameter) {
            return (T) SwAdapter.toParameter((io.swagger.v3.oas.models.parameters.Parameter) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.parameters.RequestBody) {
            return (T) SwAdapter.toRequestBody((io.swagger.v3.oas.models.parameters.RequestBody) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.responses.ApiResponse) {
            return (T) SwAdapter.toAPIResponse((io.swagger.v3.oas.models.responses.ApiResponse) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.responses.ApiResponses) {
            return (T) SwAdapter.toAPIResponses((io.swagger.v3.oas.models.responses.ApiResponses) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.security.OAuthFlow) {
            return (T) SwAdapter.toOAuthFlow((io.swagger.v3.oas.models.security.OAuthFlow) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.security.OAuthFlows) {
            return (T) SwAdapter.toOAuthFlows((io.swagger.v3.oas.models.security.OAuthFlows) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.security.Scopes) {
            return (T) SwAdapter.toScopes((io.swagger.v3.oas.models.security.Scopes) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.security.SecurityRequirement) {
            return (T) SwAdapter.toSecurityRequirement((io.swagger.v3.oas.models.security.SecurityRequirement) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.security.SecurityScheme) {
            return (T) SwAdapter.toSecurityScheme((io.swagger.v3.oas.models.security.SecurityScheme) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.servers.Server) {
            return (T) SwAdapter.toServer((io.swagger.v3.oas.models.servers.Server) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.servers.ServerVariable) {
            return (T) SwAdapter.toServerVariable((io.swagger.v3.oas.models.servers.ServerVariable) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.servers.ServerVariables) {
            return (T) SwAdapter.toServerVariables((io.swagger.v3.oas.models.servers.ServerVariables) sw);
        } else if (sw instanceof io.swagger.v3.oas.models.tags.Tag) {
            return (T) SwAdapter.toTag((io.swagger.v3.oas.models.tags.Tag) sw);
        } else {
            throw new IllegalArgumentException("Can not create the object corresponding to: " + sw);
        }
    }

}
