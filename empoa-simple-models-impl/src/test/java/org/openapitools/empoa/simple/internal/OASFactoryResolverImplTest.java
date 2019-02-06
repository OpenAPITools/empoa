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

import static org.testng.Assert.assertEquals;

import org.eclipse.microprofile.openapi.OASFactory;
import org.testng.annotations.Test;

public class OASFactoryResolverImplTest {

    @Test
    public void testCreateObject() {
        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.Components.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.ComponentsImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.ExternalDocumentation.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.ExternalDocumentationImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.OpenAPI.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.OpenAPIImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.Operation.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.OperationImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.PathItem.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.PathItemImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.Paths.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.PathsImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.callbacks.Callback.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.callbacks.CallbackImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.examples.Example.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.examples.ExampleImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.headers.Header.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.headers.HeaderImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.info.Contact.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.info.ContactImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.info.Info.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.info.InfoImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.info.License.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.info.LicenseImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.links.Link.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.links.LinkImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Content.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.media.ContentImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Discriminator.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.media.DiscriminatorImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Encoding.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.media.EncodingImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.MediaType.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.media.MediaTypeImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.Schema.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.media.SchemaImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.media.XML.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.media.XMLImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.parameters.Parameter.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.parameters.ParameterImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.parameters.RequestBody.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.parameters.RequestBodyImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.responses.APIResponse.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.responses.APIResponseImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.responses.APIResponses.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.responses.APIResponsesImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.OAuthFlow.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.security.OAuthFlowImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.OAuthFlows.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.security.OAuthFlowsImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.Scopes.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.security.ScopesImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.SecurityRequirement.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.security.SecurityRequirementImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.security.SecurityScheme.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.security.SecuritySchemeImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.servers.Server.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.servers.ServerImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.servers.ServerVariable.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.servers.ServerVariableImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.servers.ServerVariables.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.servers.ServerVariablesImpl.class
        );

        assertEquals(
            OASFactory.createObject(org.eclipse.microprofile.openapi.models.tags.Tag.class)
                .getClass(), org.openapitools.empoa.simple.internal.models.tags.TagImpl.class
        );
    }

}
