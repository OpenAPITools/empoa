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
package org.openapitools.empoa.util.equals;

import static org.assertj.core.api.Assertions.assertThat;

import org.eclipse.microprofile.openapi.OASFactory;
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
import org.eclipse.microprofile.openapi.models.security.Scopes;
import org.eclipse.microprofile.openapi.models.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.models.security.SecurityScheme;
import org.eclipse.microprofile.openapi.models.servers.Server;
import org.eclipse.microprofile.openapi.models.servers.ServerVariable;
import org.eclipse.microprofile.openapi.models.servers.ServerVariables;
import org.eclipse.microprofile.openapi.models.tags.Tag;
import org.junit.jupiter.api.Test;
import org.openapitools.empoa.extended.tck.OASTestFactory;

public class OASEqualsTest {

    @Test
    public void test() throws Exception {

        // tag::usage[]
        Schema firstSchema;
        Schema secondSchema;
        // ... instantiate the 'firstSchema' and 'secondSchema' variables
        // end::usage[]

        firstSchema = OASTestFactory.createTestSchema();
        secondSchema = OASFactory.createSchema()
            .ref("#/components/schemas/Dog");

        // tag::usage[]
        boolean equals = OASEquals.equals(firstSchema, secondSchema);
        // end::usage[]

        assertThat(equals).isFalse();

    }

    @Test
    public void testCopyOpenAPI() throws Exception {
        OpenAPI a1 = OASFactory.createOpenAPI();
        OpenAPI b1 = OASFactory.createOpenAPI();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        OpenAPI a2 = OASTestFactory.createTestOpenAPI();
        OpenAPI b2 = OASTestFactory.createTestOpenAPI();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyAPIResponse() throws Exception {
        APIResponse a1 = OASFactory.createAPIResponse();
        APIResponse b1 = OASFactory.createAPIResponse();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        APIResponse a2 = OASTestFactory.createTestAPIResponse();
        APIResponse b2 = OASTestFactory.createTestAPIResponse();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyAPIResponses() throws Exception {
        APIResponses a1 = OASFactory.createAPIResponses();
        APIResponses b1 = OASFactory.createAPIResponses();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        APIResponses a2 = OASTestFactory.createTestAPIResponses();
        APIResponses b2 = OASTestFactory.createTestAPIResponses();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyCallback() throws Exception {
        Callback a1 = OASFactory.createCallback();
        Callback b1 = OASFactory.createCallback();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Callback a2 = OASTestFactory.createTestCallback();
        Callback b2 = OASTestFactory.createTestCallback();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyComponents() throws Exception {
        Components a1 = OASFactory.createComponents();
        Components b1 = OASFactory.createComponents();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Components a2 = OASTestFactory.createTestComponents();
        Components b2 = OASTestFactory.createTestComponents();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyContact() throws Exception {
        Contact a1 = OASFactory.createContact();
        Contact b1 = OASFactory.createContact();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Contact a2 = OASTestFactory.createTestContact();
        Contact b2 = OASTestFactory.createTestContact();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyContent() throws Exception {
        Content a1 = OASFactory.createContent();
        Content b1 = OASFactory.createContent();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Content a2 = OASTestFactory.createTestContent();
        Content b2 = OASTestFactory.createTestContent();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyDiscriminator() throws Exception {
        Discriminator a1 = OASFactory.createDiscriminator();
        Discriminator b1 = OASFactory.createDiscriminator();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Discriminator a2 = OASTestFactory.createTestDiscriminator();
        Discriminator b2 = OASTestFactory.createTestDiscriminator();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyEncoding() throws Exception {
        Encoding a1 = OASFactory.createEncoding();
        Encoding b1 = OASFactory.createEncoding();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Encoding a2 = OASTestFactory.createTestEncoding();
        Encoding b2 = OASTestFactory.createTestEncoding();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyExample() throws Exception {
        Example a1 = OASFactory.createExample();
        Example b1 = OASFactory.createExample();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Example a2 = OASTestFactory.createTestExample();
        Example b2 = OASTestFactory.createTestExample();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyExternalDocumentation() throws Exception {
        ExternalDocumentation a1 = OASFactory.createExternalDocumentation();
        ExternalDocumentation b1 = OASFactory.createExternalDocumentation();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        ExternalDocumentation a2 = OASTestFactory.createTestExternalDocumentation();
        ExternalDocumentation b2 = OASTestFactory.createTestExternalDocumentation();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyHeader() throws Exception {
        Header a1 = OASFactory.createHeader();
        Header b1 = OASFactory.createHeader();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Header a2 = OASTestFactory.createTestHeader();
        Header b2 = OASTestFactory.createTestHeader();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyInfo() throws Exception {
        Info a1 = OASFactory.createInfo();
        Info b1 = OASFactory.createInfo();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Info a2 = OASTestFactory.createTestInfo();
        Info b2 = OASTestFactory.createTestInfo();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyLicense() throws Exception {
        License a1 = OASFactory.createLicense();
        License b1 = OASFactory.createLicense();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        License a2 = OASTestFactory.createTestLicense();
        License b2 = OASTestFactory.createTestLicense();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyLink() throws Exception {
        Link a1 = OASFactory.createLink();
        Link b1 = OASFactory.createLink();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Link a2 = OASTestFactory.createTestLink();
        Link b2 = OASTestFactory.createTestLink();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyMediaType() throws Exception {
        MediaType a1 = OASFactory.createMediaType();
        MediaType b1 = OASFactory.createMediaType();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        MediaType a2 = OASTestFactory.createTestMediaType();
        MediaType b2 = OASTestFactory.createTestMediaType();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyOAuthFlow() throws Exception {
        OAuthFlow a1 = OASFactory.createOAuthFlow();
        OAuthFlow b1 = OASFactory.createOAuthFlow();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        OAuthFlow a2 = OASTestFactory.createTestOAuthFlow();
        OAuthFlow b2 = OASTestFactory.createTestOAuthFlow();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyOAuthFlows() throws Exception {
        OAuthFlows a1 = OASFactory.createOAuthFlows();
        OAuthFlows b1 = OASFactory.createOAuthFlows();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        OAuthFlows a2 = OASTestFactory.createTestOAuthFlows();
        OAuthFlows b2 = OASTestFactory.createTestOAuthFlows();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyOperation() throws Exception {
        Operation a1 = OASFactory.createOperation();
        Operation b1 = OASFactory.createOperation();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Operation a2 = OASTestFactory.createTestOperation();
        Operation b2 = OASTestFactory.createTestOperation();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyParameter() throws Exception {
        Parameter a1 = OASFactory.createParameter();
        Parameter b1 = OASFactory.createParameter();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Parameter a2 = OASTestFactory.createTestParameter();
        Parameter b2 = OASTestFactory.createTestParameter();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyPathItem() throws Exception {
        PathItem a1 = OASFactory.createPathItem();
        PathItem b1 = OASFactory.createPathItem();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        PathItem a2 = OASTestFactory.createTestPathItem();
        PathItem b2 = OASTestFactory.createTestPathItem();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyPaths() throws Exception {
        Paths a1 = OASFactory.createPaths();
        Paths b1 = OASFactory.createPaths();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Paths a2 = OASTestFactory.createTestPaths();
        Paths b2 = OASTestFactory.createTestPaths();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyRequestBody() throws Exception {
        RequestBody a1 = OASFactory.createRequestBody();
        RequestBody b1 = OASFactory.createRequestBody();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        RequestBody a2 = OASTestFactory.createTestRequestBody();
        RequestBody b2 = OASTestFactory.createTestRequestBody();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopySchema() throws Exception {
        Schema a1 = OASFactory.createSchema();
        Schema b1 = OASFactory.createSchema();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Schema a2 = OASTestFactory.createTestSchema();
        Schema b2 = OASTestFactory.createTestSchema();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyScopes() throws Exception {
        Scopes a1 = OASFactory.createScopes();
        Scopes b1 = OASFactory.createScopes();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Scopes a2 = OASTestFactory.createTestScopes();
        Scopes b2 = OASTestFactory.createTestScopes();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopySecurityRequirement() throws Exception {
        SecurityRequirement a1 = OASFactory.createSecurityRequirement();
        SecurityRequirement b1 = OASFactory.createSecurityRequirement();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        SecurityRequirement a2 = OASTestFactory.createTestSecurityRequirement();
        SecurityRequirement b2 = OASTestFactory.createTestSecurityRequirement();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopySecurityScheme() throws Exception {
        SecurityScheme a1 = OASFactory.createSecurityScheme();
        SecurityScheme b1 = OASFactory.createSecurityScheme();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        SecurityScheme a2 = OASTestFactory.createTestSecurityScheme();
        SecurityScheme b2 = OASTestFactory.createTestSecurityScheme();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyServer() throws Exception {
        Server a1 = OASFactory.createServer();
        Server b1 = OASFactory.createServer();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Server a2 = OASTestFactory.createTestServer();
        Server b2 = OASTestFactory.createTestServer();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyServerVariable() throws Exception {
        ServerVariable a1 = OASFactory.createServerVariable();
        ServerVariable b1 = OASFactory.createServerVariable();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        ServerVariable a2 = OASTestFactory.createTestServerVariable();
        ServerVariable b2 = OASTestFactory.createTestServerVariable();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyServerVariables() throws Exception {
        ServerVariables a1 = OASFactory.createServerVariables();
        ServerVariables b1 = OASFactory.createServerVariables();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        ServerVariables a2 = OASTestFactory.createTestServerVariables();
        ServerVariables b2 = OASTestFactory.createTestServerVariables();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyTag() throws Exception {
        Tag a1 = OASFactory.createTag();
        Tag b1 = OASFactory.createTag();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        Tag a2 = OASTestFactory.createTestTag();
        Tag b2 = OASTestFactory.createTestTag();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

    @Test
    public void testCopyXML() throws Exception {
        XML a1 = OASFactory.createXML();
        XML b1 = OASFactory.createXML();
        assertThat(a1).isNotSameAs(b1);
        assertThat(OASEquals.equals(a1, b1)).isTrue();

        XML a2 = OASTestFactory.createTestXML();
        XML b2 = OASTestFactory.createTestXML();
        assertThat(a2).isNotSameAs(b2);
        assertThat(OASEquals.equals(a2, b2)).isTrue();

        assertThat(OASEquals.equals(a1, a2)).isFalse();
    }

}
