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

import static org.testng.Assert.assertEquals;

import org.eclipse.microprofile.openapi.OASFactory;
import org.testng.annotations.Test;

public class SwOASFactoryResolverTest {

    @Test
    public void testCreateObject() {
        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.Components.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.SwComponents.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.ExternalDocumentation.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.OpenAPI.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.SwOpenAPI.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.Operation.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.SwOperation.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.PathItem.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.SwPathItem.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.Paths.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.SwPaths.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.callbacks.Callback.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.callbacks.SwCallback.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.examples.Example.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.examples.SwExample.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.headers.Header.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.info.Contact.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.info.SwContact.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.info.Info.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.info.SwInfo.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.info.License.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.info.SwLicense.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.links.Link.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.links.SwLink.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Content.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.media.SwContent.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Discriminator.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.media.SwDiscriminator.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Encoding.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.media.SwEncoding.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.MediaType.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.media.SwMediaType.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Schema.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.media.SwSchema.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.XML.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.media.SwXML.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.parameters.Parameter.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.parameters.RequestBody.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.parameters.SwRequestBody.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.responses.APIResponse.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponse.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.responses.APIResponses.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponses.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.OAuthFlow.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.OAuthFlows.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlows.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.Scopes.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.security.SwScopes.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.SecurityRequirement.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.SecurityScheme.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityScheme.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.servers.Server.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.servers.SwServer.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.servers.ServerVariable.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariable.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.servers.ServerVariables.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariables.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.tags.Tag.class)
                .getClass(), org.openapitools.empoa.swagger.core.internal.models.tags.SwTag.class
        );
    }

}
