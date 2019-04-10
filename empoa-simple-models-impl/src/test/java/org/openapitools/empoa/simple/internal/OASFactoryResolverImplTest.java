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
package org.openapitools.empoa.simple.internal;

import static org.assertj.core.api.Assertions.assertThat;

import org.eclipse.microprofile.openapi.OASFactory;
import org.junit.jupiter.api.Test;

public class OASFactoryResolverImplTest {

    @Test
    public void testCreateObject() {
        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.Components.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.ComponentsImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.ExternalDocumentation.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.ExternalDocumentationImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.OpenAPI.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.OpenAPIImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.Operation.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.OperationImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.PathItem.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.PathItemImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.Paths.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.PathsImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.callbacks.Callback.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.callbacks.CallbackImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.examples.Example.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.examples.ExampleImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.headers.Header.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.headers.HeaderImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.info.Contact.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.info.ContactImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.info.Info.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.info.InfoImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.info.License.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.info.LicenseImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.links.Link.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.links.LinkImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Content.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.media.ContentImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Discriminator.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.media.DiscriminatorImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Encoding.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.media.EncodingImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.MediaType.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.media.MediaTypeImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Schema.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.media.SchemaImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.XML.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.media.XMLImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.parameters.Parameter.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.parameters.ParameterImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.parameters.RequestBody.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.parameters.RequestBodyImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.responses.APIResponse.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.responses.APIResponseImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.responses.APIResponses.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.responses.APIResponsesImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.OAuthFlow.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.security.OAuthFlowImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.OAuthFlows.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.security.OAuthFlowsImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.Scopes.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.security.ScopesImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.SecurityRequirement.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.security.SecurityRequirementImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.SecurityScheme.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.security.SecuritySchemeImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.servers.Server.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.servers.ServerImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.servers.ServerVariable.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.servers.ServerVariableImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.servers.ServerVariables.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.servers.ServerVariablesImpl.class);

        assertThat(OASFactory.createObject(org.eclipse.microprofile.openapi.models.tags.Tag.class))
            .isOfAnyClassIn(org.openapitools.empoa.simple.internal.models.tags.TagImpl.class);
    }

}
