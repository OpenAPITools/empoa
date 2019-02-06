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

public class SwOASFactoryResolver extends org.eclipse.microprofile.openapi.spi.OASFactoryResolver {

    @Override
    @SuppressWarnings("unchecked")
    public <T extends org.eclipse.microprofile.openapi.models.Constructible> T createObject(Class<T> clazz) {
        T instance;
        if (clazz == null) {
            throw new IllegalArgumentException("Class can not be null");
        } else if (clazz == org.eclipse.microprofile.openapi.models.Components.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.SwComponents();
        } else if (clazz == org.eclipse.microprofile.openapi.models.ExternalDocumentation.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation();
        } else if (clazz == org.eclipse.microprofile.openapi.models.OpenAPI.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.SwOpenAPI();
        } else if (clazz == org.eclipse.microprofile.openapi.models.Operation.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.SwOperation();
        } else if (clazz == org.eclipse.microprofile.openapi.models.PathItem.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.SwPathItem();
        } else if (clazz == org.eclipse.microprofile.openapi.models.Paths.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.SwPaths();
        } else if (clazz == org.eclipse.microprofile.openapi.models.callbacks.Callback.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.callbacks.SwCallback();
        } else if (clazz == org.eclipse.microprofile.openapi.models.examples.Example.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.examples.SwExample();
        } else if (clazz == org.eclipse.microprofile.openapi.models.headers.Header.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader();
        } else if (clazz == org.eclipse.microprofile.openapi.models.info.Contact.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.info.SwContact();
        } else if (clazz == org.eclipse.microprofile.openapi.models.info.Info.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.info.SwInfo();
        } else if (clazz == org.eclipse.microprofile.openapi.models.info.License.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.info.SwLicense();
        } else if (clazz == org.eclipse.microprofile.openapi.models.links.Link.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.links.SwLink();
        } else if (clazz == org.eclipse.microprofile.openapi.models.media.Content.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.media.SwContent();
        } else if (clazz == org.eclipse.microprofile.openapi.models.media.Discriminator.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.media.SwDiscriminator();
        } else if (clazz == org.eclipse.microprofile.openapi.models.media.Encoding.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.media.SwEncoding();
        } else if (clazz == org.eclipse.microprofile.openapi.models.media.MediaType.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.media.SwMediaType();
        } else if (clazz == org.eclipse.microprofile.openapi.models.media.Schema.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.media.SwSchema();
        } else if (clazz == org.eclipse.microprofile.openapi.models.media.XML.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.media.SwXML();
        } else if (clazz == org.eclipse.microprofile.openapi.models.parameters.Parameter.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter();
        } else if (clazz == org.eclipse.microprofile.openapi.models.parameters.RequestBody.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.parameters.SwRequestBody();
        } else if (clazz == org.eclipse.microprofile.openapi.models.responses.APIResponse.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponse();
        } else if (clazz == org.eclipse.microprofile.openapi.models.responses.APIResponses.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponses();
        } else if (clazz == org.eclipse.microprofile.openapi.models.security.OAuthFlow.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow();
        } else if (clazz == org.eclipse.microprofile.openapi.models.security.OAuthFlows.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlows();
        } else if (clazz == org.eclipse.microprofile.openapi.models.security.Scopes.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.security.SwScopes();
        } else if (clazz == org.eclipse.microprofile.openapi.models.security.SecurityRequirement.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement();
        } else if (clazz == org.eclipse.microprofile.openapi.models.security.SecurityScheme.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityScheme();
        } else if (clazz == org.eclipse.microprofile.openapi.models.servers.Server.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.servers.SwServer();
        } else if (clazz == org.eclipse.microprofile.openapi.models.servers.ServerVariable.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariable();
        } else if (clazz == org.eclipse.microprofile.openapi.models.servers.ServerVariables.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariables();
        } else if (clazz == org.eclipse.microprofile.openapi.models.tags.Tag.class) {
            instance = (T) new org.openapitools.empoa.swagger.core.internal.models.tags.SwTag();
        } else {
            throw new IllegalArgumentException("Can not create " + clazz.getCanonicalName());
        }
        return instance;
    }

}
