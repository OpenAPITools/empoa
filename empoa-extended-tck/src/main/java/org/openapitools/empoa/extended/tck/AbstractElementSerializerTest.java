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
package org.openapitools.empoa.extended.tck;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.*;

import java.io.IOException;

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
import org.testng.annotations.Test;

public abstract class AbstractElementSerializerTest {

    @Test
    public void testEmptyComponentsToJson() throws Exception {
        Components components = OASFactory.createComponents();
        String json = convertToJson(components);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyExternalDocumentationToJson() throws Exception {
        ExternalDocumentation externalDocumentation = OASFactory.createExternalDocumentation();
        String json = convertToJson(externalDocumentation);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyOpenAPIToJson() throws Exception {
        OpenAPI openAPI = OASFactory.createOpenAPI();
        String json = convertToJson(openAPI);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyOperationToJson() throws Exception {
        Operation operation = OASFactory.createOperation();
        String json = convertToJson(operation);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyPathItemToJson() throws Exception {
        PathItem pathItem = OASFactory.createPathItem();
        String json = convertToJson(pathItem);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyPathsToJson() throws Exception {
        Paths paths = OASFactory.createPaths();
        String json = convertToJson(paths);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyCallbackToJson() throws Exception {
        Callback callback = OASFactory.createCallback();
        String json = convertToJson(callback);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyExampleToJson() throws Exception {
        Example example = OASFactory.createExample();
        String json = convertToJson(example);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyHeaderToJson() throws Exception {
        Header header = OASFactory.createHeader();
        String json = convertToJson(header);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyContactToJson() throws Exception {
        Contact contact = OASFactory.createContact();
        String json = convertToJson(contact);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyInfoToJson() throws Exception {
        Info info = OASFactory.createInfo();
        String json = convertToJson(info);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyLicenseToJson() throws Exception {
        License license = OASFactory.createLicense();
        String json = convertToJson(license);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyLinkToJson() throws Exception {
        Link link = OASFactory.createLink();
        String json = convertToJson(link);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyContentToJson() throws Exception {
        Content content = OASFactory.createContent();
        String json = convertToJson(content);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyDiscriminatorToJson() throws Exception {
        Discriminator discriminator = OASFactory.createDiscriminator();
        String json = convertToJson(discriminator);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyEncodingToJson() throws Exception {
        Encoding encoding = OASFactory.createEncoding();
        String json = convertToJson(encoding);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyMediaTypeToJson() throws Exception {
        MediaType mediaType = OASFactory.createMediaType();
        String json = convertToJson(mediaType);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptySchemaToJson() throws Exception {
        Schema schema = OASFactory.createSchema();
        String json = convertToJson(schema);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyXMLToJson() throws Exception {
        XML xML = OASFactory.createXML();
        String json = convertToJson(xML);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyParameterToJson() throws Exception {
        Parameter parameter = OASFactory.createParameter();
        String json = convertToJson(parameter);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyRequestBodyToJson() throws Exception {
        RequestBody requestBody = OASFactory.createRequestBody();
        String json = convertToJson(requestBody);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyAPIResponseToJson() throws Exception {
        APIResponse apiResponse = OASFactory.createAPIResponse();
        String json = convertToJson(apiResponse);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyAPIResponsesToJson() throws Exception {
        APIResponses apiResponses = OASFactory.createAPIResponses();
        String json = convertToJson(apiResponses);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyOAuthFlowToJson() throws Exception {
        OAuthFlow oAuthFlow = OASFactory.createOAuthFlow();
        String json = convertToJson(oAuthFlow);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyOAuthFlowsToJson() throws Exception {
        OAuthFlows oAuthFlows = OASFactory.createOAuthFlows();
        String json = convertToJson(oAuthFlows);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyScopesToJson() throws Exception {
        Scopes scopes = OASFactory.createScopes();
        String json = convertToJson(scopes);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptySecurityRequirementToJson() throws Exception {
        SecurityRequirement securityRequirement = OASFactory.createSecurityRequirement();
        String json = convertToJson(securityRequirement);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptySecuritySchemeToJson() throws Exception {
        SecurityScheme securityScheme = OASFactory.createSecurityScheme();
        String json = convertToJson(securityScheme);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyServerToJson() throws Exception {
        Server server = OASFactory.createServer();
        String json = convertToJson(server);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyServerVariableToJson() throws Exception {
        ServerVariable serverVariable = OASFactory.createServerVariable();
        String json = convertToJson(serverVariable);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyServerVariablesToJson() throws Exception {
        ServerVariables serverVariables = OASFactory.createServerVariables();
        String json = convertToJson(serverVariables);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testEmptyTagToJson() throws Exception {
        Tag tag = OASFactory.createTag();
        String json = convertToJson(tag);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testAPIResponsesToJson() throws Exception {
        APIResponses apiResponses = OASFactory.createAPIResponses();

        String json = convertToJson(apiResponses);

        assertThatJson(json).isEqualTo(
            "" +
                "{\n" +
                "}"
        );
    }

    @Test
    public void testOAuthFlowToJson() throws Exception {
        OAuthFlow oAuthFlow = OASFactory.createOAuthFlow();

        String json = convertToJson(oAuthFlow);

        assertThatJson(json).isEqualTo(
            "" +
                "{\n" +
                "}"
        );
    }

    @Test
    public void testOAuthFlowsToJson() throws Exception {
        OAuthFlows oAuthFlows = OASFactory.createOAuthFlows();

        String json = convertToJson(oAuthFlows);

        assertThatJson(json).isEqualTo(
            "" +
                "{\n" +
                "}"
        );
    }

    @Test
    public void testScopesToJson() throws Exception {
        Scopes scopes = OASFactory.createScopes();

        String json = convertToJson(scopes);

        assertThatJson(json).isEqualTo(
            "" +
                "{\n" +
                "}"
        );
    }

    @Test
    public void testSecurityRequirementToJson() throws Exception {
        SecurityRequirement securityRequirement = OASFactory.createSecurityRequirement();

        String json = convertToJson(securityRequirement);

        assertThatJson(json).isEqualTo(
            "" +
                "{\n" +
                "}"
        );
    }

    @Test
    public void testSecuritySchemeToJson() throws Exception {
        SecurityScheme securityScheme = OASFactory.createSecurityScheme()
            .description("Some description");

        String json = convertToJson(securityScheme);

        assertThatJson(json).isEqualTo(
            "" +
                "{\n" +
                "  \"description\": \"Some description\"\n" +
                "}"
        );
    }

    @Test
    public void testServerToJson() throws Exception {
        Server server = OASFactory.createServer()
            .description("Some description");

        String json = convertToJson(server);

        assertThatJson(json).isEqualTo(
            "" +
                "{\n" +
                "  \"description\": \"Some description\"\n" +
                "}"
        );
    }

    @Test
    public void testServerVariableToJson() throws Exception {
        ServerVariable serverVariable = OASFactory.createServerVariable()
            .description("Some description");

        String json = convertToJson(serverVariable);

        assertThatJson(json).isEqualTo(
            "" +
                "{\n" +
                "  \"description\": \"Some description\"\n" +
                "}"
        );
    }

    @Test
    public void testServerVariablesToJson() throws Exception {
        ServerVariables serverVariables = OASFactory.createServerVariables();

        String json = convertToJson(serverVariables);

        assertThatJson(json).isEqualTo(
            "" +
                "{\n" +
                "}"
        );
    }

    @Test
    public void testTagToJson() throws Exception {
        Tag tag = OASFactory.createTag()
            .description("Some description");

        String json = convertToJson(tag);

        assertThatJson(json).isEqualTo(
            "" +
                "{\n" +
                "  \"description\": \"Some description\"\n" +
                "}"
        );
    }

    protected abstract String convertToJson(Components components) throws IOException;

    protected abstract String convertToJson(ExternalDocumentation externalDocumentation) throws IOException;

    protected abstract String convertToJson(OpenAPI openAPI) throws IOException;

    protected abstract String convertToJson(Operation operation) throws IOException;

    protected abstract String convertToJson(PathItem pathItem) throws IOException;

    protected abstract String convertToJson(Paths paths) throws IOException;

    protected abstract String convertToJson(Callback callback) throws IOException;

    protected abstract String convertToJson(Example example) throws IOException;

    protected abstract String convertToJson(Header header) throws IOException;

    protected abstract String convertToJson(Contact contact) throws IOException;

    protected abstract String convertToJson(Info info) throws IOException;

    protected abstract String convertToJson(License license) throws IOException;

    protected abstract String convertToJson(Link link) throws IOException;

    protected abstract String convertToJson(Content content) throws IOException;

    protected abstract String convertToJson(Discriminator discriminator) throws IOException;

    protected abstract String convertToJson(Encoding encoding) throws IOException;

    protected abstract String convertToJson(MediaType mediaType) throws IOException;

    protected abstract String convertToJson(Schema schema) throws IOException;

    protected abstract String convertToJson(XML xML) throws IOException;

    protected abstract String convertToJson(Parameter parameter) throws IOException;

    protected abstract String convertToJson(RequestBody requestBody) throws IOException;

    protected abstract String convertToJson(APIResponse apiResponse) throws IOException;

    protected abstract String convertToJson(APIResponses apiResponses) throws IOException;

    protected abstract String convertToJson(OAuthFlow oAuthFlow) throws IOException;

    protected abstract String convertToJson(OAuthFlows oAuthFlows) throws IOException;

    protected abstract String convertToJson(Scopes scopes) throws IOException;

    protected abstract String convertToJson(SecurityRequirement securityRequirement) throws IOException;

    protected abstract String convertToJson(SecurityScheme securityScheme) throws IOException;

    protected abstract String convertToJson(Server server) throws IOException;

    protected abstract String convertToJson(ServerVariable serverVariable) throws IOException;

    protected abstract String convertToJson(ServerVariables serverVariables) throws IOException;

    protected abstract String convertToJson(Tag tag) throws IOException;

}
