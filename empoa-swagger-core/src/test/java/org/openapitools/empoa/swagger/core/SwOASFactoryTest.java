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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.eclipse.microprofile.openapi.models.media.Schema.SchemaType;
import org.junit.jupiter.api.Test;

public class SwOASFactoryTest {

    @Test
    public void testComponents() throws Exception {
        io.swagger.v3.oas.models.Components original = new io.swagger.v3.oas.models.Components();
        org.eclipse.microprofile.openapi.models.Components converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testExternalDocumentation() throws Exception {
        io.swagger.v3.oas.models.ExternalDocumentation original = new io.swagger.v3.oas.models.ExternalDocumentation();
        original.setDescription("Some description");
        org.eclipse.microprofile.openapi.models.ExternalDocumentation converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
    }

    @Test
    public void testOpenAPI() throws Exception {
        io.swagger.v3.oas.models.OpenAPI original = new io.swagger.v3.oas.models.OpenAPI();
        org.eclipse.microprofile.openapi.models.OpenAPI converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testOperation() throws Exception {
        io.swagger.v3.oas.models.Operation original = new io.swagger.v3.oas.models.Operation();
        original.setDescription("Some description");
        org.eclipse.microprofile.openapi.models.Operation converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
    }

    @Test
    public void testPathItem() throws Exception {
        io.swagger.v3.oas.models.PathItem original = new io.swagger.v3.oas.models.PathItem();
        original.setDescription("Some description");
        org.eclipse.microprofile.openapi.models.PathItem converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
    }

    @Test
    public void testPaths() throws Exception {
        io.swagger.v3.oas.models.Paths original = new io.swagger.v3.oas.models.Paths();
        org.eclipse.microprofile.openapi.models.Paths converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testCallback() throws Exception {
        io.swagger.v3.oas.models.callbacks.Callback original = new io.swagger.v3.oas.models.callbacks.Callback();
        org.eclipse.microprofile.openapi.models.callbacks.Callback converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testExample() throws Exception {
        io.swagger.v3.oas.models.examples.Example original = new io.swagger.v3.oas.models.examples.Example();
        original.setDescription("Some description");
        org.eclipse.microprofile.openapi.models.examples.Example converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
    }

    @Test
    public void testHeader() throws Exception {
        io.swagger.v3.oas.models.headers.Header original = new io.swagger.v3.oas.models.headers.Header();
        original.setDescription("Some description");
        org.eclipse.microprofile.openapi.models.headers.Header converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
    }

    @Test
    public void testContact() throws Exception {
        io.swagger.v3.oas.models.info.Contact original = new io.swagger.v3.oas.models.info.Contact();
        org.eclipse.microprofile.openapi.models.info.Contact converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testInfo() throws Exception {
        io.swagger.v3.oas.models.info.Info original = new io.swagger.v3.oas.models.info.Info();
        original.setDescription("Some description");
        org.eclipse.microprofile.openapi.models.info.Info converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
    }

    @Test
    public void testLicense() throws Exception {
        io.swagger.v3.oas.models.info.License original = new io.swagger.v3.oas.models.info.License();
        org.eclipse.microprofile.openapi.models.info.License converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testLink() throws Exception {
        io.swagger.v3.oas.models.links.Link original = new io.swagger.v3.oas.models.links.Link();
        original.setDescription("Some description");
        org.eclipse.microprofile.openapi.models.links.Link converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
    }

    @Test
    public void testContent() throws Exception {
        io.swagger.v3.oas.models.media.Content original = new io.swagger.v3.oas.models.media.Content();
        org.eclipse.microprofile.openapi.models.media.Content converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testDiscriminator() throws Exception {
        io.swagger.v3.oas.models.media.Discriminator original = new io.swagger.v3.oas.models.media.Discriminator();
        org.eclipse.microprofile.openapi.models.media.Discriminator converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testEncoding() throws Exception {
        io.swagger.v3.oas.models.media.Encoding original = new io.swagger.v3.oas.models.media.Encoding();
        org.eclipse.microprofile.openapi.models.media.Encoding converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testMediaType() throws Exception {
        io.swagger.v3.oas.models.media.MediaType original = new io.swagger.v3.oas.models.media.MediaType();
        org.eclipse.microprofile.openapi.models.media.MediaType converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testSchema() throws Exception {
        io.swagger.v3.oas.models.media.Schema original = new io.swagger.v3.oas.models.media.Schema();
        original.setDescription("Some description");
        original.setTitle("Title");
        original.setType("string");
        org.eclipse.microprofile.openapi.models.media.Schema converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
        assertThat(converted.getTitle()).isEqualTo("Title");
        assertThat(converted.getType()).isEqualTo(SchemaType.STRING);
    }

    @Test
    public void testXML() throws Exception {
        io.swagger.v3.oas.models.media.XML original = new io.swagger.v3.oas.models.media.XML();
        org.eclipse.microprofile.openapi.models.media.XML converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testParameter() throws Exception {
        io.swagger.v3.oas.models.parameters.Parameter original = new io.swagger.v3.oas.models.parameters.Parameter();
        original.setDescription("Some description");
        org.eclipse.microprofile.openapi.models.parameters.Parameter converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
    }

    @Test
    public void testRequestBody() throws Exception {
        io.swagger.v3.oas.models.parameters.RequestBody original = new io.swagger.v3.oas.models.parameters.RequestBody();
        original.setDescription("Some description");
        org.eclipse.microprofile.openapi.models.parameters.RequestBody converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
    }

    @Test
    public void testAPIResponse() throws Exception {
        io.swagger.v3.oas.models.responses.ApiResponse original = new io.swagger.v3.oas.models.responses.ApiResponse();
        original.setDescription("Some description");
        org.eclipse.microprofile.openapi.models.responses.APIResponse converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
    }

    @Test
    public void testAPIResponses() throws Exception {
        io.swagger.v3.oas.models.responses.ApiResponses original = new io.swagger.v3.oas.models.responses.ApiResponses();
        org.eclipse.microprofile.openapi.models.responses.APIResponses converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testOAuthFlow() throws Exception {
        io.swagger.v3.oas.models.security.OAuthFlow original = new io.swagger.v3.oas.models.security.OAuthFlow();
        org.eclipse.microprofile.openapi.models.security.OAuthFlow converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testOAuthFlows() throws Exception {
        io.swagger.v3.oas.models.security.OAuthFlows original = new io.swagger.v3.oas.models.security.OAuthFlows();
        org.eclipse.microprofile.openapi.models.security.OAuthFlows converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testScopes() throws Exception {
        io.swagger.v3.oas.models.security.Scopes original = new io.swagger.v3.oas.models.security.Scopes();
        org.eclipse.microprofile.openapi.models.security.Scopes converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testSecurityRequirement() throws Exception {
        io.swagger.v3.oas.models.security.SecurityRequirement original = new io.swagger.v3.oas.models.security.SecurityRequirement();
        org.eclipse.microprofile.openapi.models.security.SecurityRequirement converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testSecurityScheme() throws Exception {
        io.swagger.v3.oas.models.security.SecurityScheme original = new io.swagger.v3.oas.models.security.SecurityScheme();
        original.setDescription("Some description");
        org.eclipse.microprofile.openapi.models.security.SecurityScheme converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
    }

    @Test
    public void testServer() throws Exception {
        io.swagger.v3.oas.models.servers.Server original = new io.swagger.v3.oas.models.servers.Server();
        original.setDescription("Some description");
        org.eclipse.microprofile.openapi.models.servers.Server converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
    }

    @Test
    public void testServerVariable() throws Exception {
        io.swagger.v3.oas.models.servers.ServerVariable original = new io.swagger.v3.oas.models.servers.ServerVariable();
        original.setDescription("Some description");
        original.setDefault("myValue");
        original.setEnum(Arrays.asList("myValue", "someValue"));
        org.eclipse.microprofile.openapi.models.servers.ServerVariable converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
        assertThat(converted.getDefaultValue()).isEqualTo("myValue");
        assertThat(converted.getEnumeration()).containsExactly("myValue", "someValue");
    }

    @Test
    public void testServerVariables() throws Exception {
        io.swagger.v3.oas.models.servers.ServerVariables original = new io.swagger.v3.oas.models.servers.ServerVariables();
        org.eclipse.microprofile.openapi.models.servers.ServerVariables converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
    }

    @Test
    public void testTag() throws Exception {
        io.swagger.v3.oas.models.tags.Tag original = new io.swagger.v3.oas.models.tags.Tag();
        original.setDescription("Some description");
        org.eclipse.microprofile.openapi.models.tags.Tag converted = SwOASFactory.createObject(original);
        assertThat(converted).isNotNull();
        assertThat(converted.getDescription()).isEqualTo("Some description");
    }
}
