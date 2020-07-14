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

import static org.assertj.core.api.Assertions.assertThat;

import org.eclipse.microprofile.openapi.OASFactory;
import org.junit.jupiter.api.Test;

public class SwOASFactoryResolverTest {

    @Test
    public void testCreateObject() {
        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.Components.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.SwComponents.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.ExternalDocumentation.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.OpenAPI.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.SwOpenAPI.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.Operation.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.SwOperation.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.PathItem.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.SwPathItem.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.Paths.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.SwPaths.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.callbacks.Callback.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.callbacks.SwCallback.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.examples.Example.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.examples.SwExample.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.headers.Header.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.info.Contact.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.info.SwContact.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.info.Info.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.info.SwInfo.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.info.License.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.info.SwLicense.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.links.Link.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.links.SwLink.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Content.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.media.SwContent.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Discriminator.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.media.SwDiscriminator.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Encoding.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.media.SwEncoding.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.MediaType.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.media.SwMediaType.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Schema.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.media.SwSchema.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.XML.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.media.SwXML.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.parameters.Parameter.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.parameters.RequestBody.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.parameters.SwRequestBody.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.responses.APIResponse.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponse.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.responses.APIResponses.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponses.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.OAuthFlow.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.OAuthFlows.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlows.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.SecurityRequirement.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.SecurityScheme.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityScheme.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.servers.Server.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.servers.SwServer.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.servers.ServerVariable.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariable.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.tags.Tag.class))
            .isOfAnyClassIn(org.openapitools.empoa.swagger.core.internal.models.tags.SwTag.class);
    }

}
