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
package org.openapitools.empoa.util.copy;

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
import org.eclipse.microprofile.openapi.models.media.Schema.SchemaType;
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
import org.junit.jupiter.api.Test;
import org.openapitools.empoa.extended.tck.OASTestFactory;
import org.openapitools.empoa.extended.tck.specs.BigSpec;
import org.openapitools.empoa.extended.tck.specs.TodoappSpec;
import org.openapitools.empoa.gson.OASGsonSerializer;
import org.openapitools.empoa.util.equals.OASEquals;

import com.google.gson.Gson;

public class OASCopyTest {

    @Test
    public void test() throws Exception {
        // tag::usage[]
        PathItem original;
        // ... instantiate the 'original' variable
        // end::usage[]

        original = TodoappSpec.create()
            .getPaths()
            .getPathItem("/task");
        assertThat(original).isNotNull();

        // tag::usage[]
        PathItem copy = OASCopy.copy(original);
        // end::usage[]

        assertThat(copy).isNotSameAs(original);
        asJsonIsEqualTo(original, copy);
        assertThat(OASEquals.equals(original, copy)).isTrue();
    }

    @Test
    public void testCopyOpenAPI() throws Exception {
        OpenAPI original = BigSpec.create();
        OpenAPI copy = OASCopy.copy(original);
        assertThat(copy).isNotSameAs(original);
        assertThat(copy.getInfo()).isNotSameAs(original.getInfo());
        assertThat(copy.getPaths()).isNotSameAs(original.getPaths());
        assertThat(copy.getTags()).isNotSameAs(original.getTags());
        Components originalComponents = original.getComponents();
        Components copyComponents = copy.getComponents();
        assertThat(copyComponents).isNotSameAs(originalComponents);
        assertThat(copyComponents.getSchemas()).isNotSameAs(originalComponents.getSchemas());
        assertThat(copyComponents.getCallbacks()).isNotSameAs(originalComponents.getCallbacks());

        asJsonIsEqualTo(original, copy);
    }

    @Test
    public void testCopyAPIResponse() throws Exception {
        APIResponse original1 = OASFactory.createAPIResponse();
        APIResponse copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        APIResponse original2 = OASTestFactory.createTestAPIResponse();
        APIResponse copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyAPIResponses() throws Exception {
        APIResponses original1 = OASFactory.createAPIResponses();
        APIResponses copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        APIResponses original2 = OASTestFactory.createTestAPIResponses();
        APIResponses copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyCallback() throws Exception {
        Callback original1 = OASFactory.createCallback();
        Callback copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Callback original2 = OASTestFactory.createTestCallback();
        Callback copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyComponents() throws Exception {
        Components original1 = OASFactory.createComponents();
        Components copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Components original2 = OASTestFactory.createTestComponents();
        Components copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyContact() throws Exception {
        Contact original1 = OASFactory.createContact();
        Contact copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Contact original2 = OASTestFactory.createTestContact();
        Contact copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyContent() throws Exception {
        Content original1 = OASFactory.createContent();
        Content copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Content original2 = OASTestFactory.createTestContent();
        Content copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyDiscriminator() throws Exception {
        Discriminator original1 = OASFactory.createDiscriminator();
        Discriminator copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Discriminator original2 = OASTestFactory.createTestDiscriminator();
        Discriminator copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyEncoding() throws Exception {
        Encoding original1 = OASFactory.createEncoding();
        Encoding copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Encoding original2 = OASTestFactory.createTestEncoding();
        Encoding copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyExample() throws Exception {
        Example original1 = OASFactory.createExample();
        Example copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Example original2 = OASTestFactory.createTestExample();
        Example copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyExternalDocumentation() throws Exception {
        ExternalDocumentation original1 = OASFactory.createExternalDocumentation();
        ExternalDocumentation copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        ExternalDocumentation original2 = OASTestFactory.createTestExternalDocumentation();
        ExternalDocumentation copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyHeader() throws Exception {
        Header original1 = OASFactory.createHeader();
        Header copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Header original2 = OASTestFactory.createTestHeader();
        Header copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyInfo() throws Exception {
        Info original1 = OASFactory.createInfo();
        Info copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Info original2 = OASTestFactory.createTestInfo();
        Info copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyLicense() throws Exception {
        License original1 = OASFactory.createLicense();
        License copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        License original2 = OASTestFactory.createTestLicense();
        License copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyLink() throws Exception {
        Link original1 = OASFactory.createLink();
        Link copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Link original2 = OASTestFactory.createTestLink();
        Link copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyMediaType() throws Exception {
        MediaType original1 = OASFactory.createMediaType();
        MediaType copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        MediaType original2 = OASTestFactory.createTestMediaType();
        MediaType copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyOAuthFlow() throws Exception {
        OAuthFlow original1 = OASFactory.createOAuthFlow();
        OAuthFlow copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        OAuthFlow original2 = OASTestFactory.createTestOAuthFlow();
        OAuthFlow copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyOAuthFlows() throws Exception {
        OAuthFlows original1 = OASFactory.createOAuthFlows();
        OAuthFlows copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        OAuthFlows original2 = OASTestFactory.createTestOAuthFlows();
        OAuthFlows copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyOperation() throws Exception {
        Operation original1 = OASFactory.createOperation();
        Operation copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Operation original2 = OASTestFactory.createTestOperation();
        Operation copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyParameter() throws Exception {
        Parameter original1 = OASFactory.createParameter();
        Parameter copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Parameter original2 = OASTestFactory.createTestParameter();
        Parameter copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyPathItem() throws Exception {
        PathItem original1 = OASFactory.createPathItem();
        PathItem copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        PathItem original2 = OASTestFactory.createTestPathItem();
        PathItem copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyPaths() throws Exception {
        Paths original1 = OASFactory.createPaths();
        Paths copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Paths original2 = OASTestFactory.createTestPaths();
        Paths copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyRequestBody() throws Exception {
        RequestBody original1 = OASFactory.createRequestBody();
        RequestBody copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        RequestBody original2 = OASTestFactory.createTestRequestBody();
        RequestBody copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopySchema() throws Exception {
        Schema original1 = OASFactory.createSchema();
        Schema copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Schema original2 = OASTestFactory.createTestSchema();
        Schema copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();

        Schema original3 = OASFactory.createSchema();
        original3.setRef("#/components/schemas/SomeObject");
        Schema copy3 = OASCopy.copy(original3);
        assertThat(copy3).isNotSameAs(original3);
        assertThat(copy3.getRef()).isEqualTo(original3.getRef());

        Schema original4 = OASFactory.createSchema();
        original4.setAdditionalPropertiesBoolean(true);
        Schema copy4 = OASCopy.copy(original4);
        assertThat(copy4).isNotSameAs(original4);
        assertThat(copy4.getAdditionalPropertiesBoolean()).isEqualTo(original4.getAdditionalPropertiesBoolean());

        Schema original5 = OASFactory.createSchema();
        original5.setAdditionalPropertiesSchema(
            OASFactory.createSchema()
                .type(SchemaType.STRING)
        );
        Schema copy5 = OASCopy.copy(original5);
        assertThat(copy5).isNotSameAs(original5);
        assertThat(copy5.getAdditionalPropertiesSchema()).isEqualToComparingFieldByField(original5.getAdditionalPropertiesSchema());
    }

    @Test
    public void testCopySecurityRequirement() throws Exception {
        SecurityRequirement original1 = OASFactory.createSecurityRequirement();
        SecurityRequirement copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        SecurityRequirement original2 = OASTestFactory.createTestSecurityRequirement();
        SecurityRequirement copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopySecurityScheme() throws Exception {
        SecurityScheme original1 = OASFactory.createSecurityScheme();
        SecurityScheme copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        SecurityScheme original2 = OASTestFactory.createTestSecurityScheme();
        SecurityScheme copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyServer() throws Exception {
        Server original1 = OASFactory.createServer();
        Server copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Server original2 = OASTestFactory.createTestServer();
        Server copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyServerVariable() throws Exception {
        ServerVariable original1 = OASFactory.createServerVariable();
        ServerVariable copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        ServerVariable original2 = OASTestFactory.createTestServerVariable();
        ServerVariable copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyTag() throws Exception {
        Tag original1 = OASFactory.createTag();
        Tag copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        Tag original2 = OASTestFactory.createTestTag();
        Tag copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    @Test
    public void testCopyXML() throws Exception {
        XML original1 = OASFactory.createXML();
        XML copy1 = OASCopy.copy(original1);
        assertThat(copy1).isNotSameAs(original1);
        assertThat(OASEquals.equals(original1, copy1)).isTrue();

        XML original2 = OASTestFactory.createTestXML();
        XML copy2 = OASCopy.copy(original2);
        assertThat(copy2).isNotSameAs(original2);
        assertThat(OASEquals.equals(original2, copy2)).isTrue();
    }

    private static void asJsonIsEqualTo(Object a, Object b) {
        Gson gson = OASGsonSerializer.instance();
        String aJson = gson.toJson(a);
        String bJson = gson.toJson(b);
        assertThat(bJson).isEqualTo(aJson);
    }
}
