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
import org.eclipse.microprofile.openapi.models.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.models.security.SecurityScheme;
import org.eclipse.microprofile.openapi.models.servers.Server;
import org.eclipse.microprofile.openapi.models.servers.ServerVariable;
import org.eclipse.microprofile.openapi.models.tags.Tag;
import org.junit.jupiter.api.Test;
import org.openapitools.empoa.extended.tck.specs.OASElement;

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
    public void testEmptyTagToJson() throws Exception {
        Tag tag = OASFactory.createTag();
        String json = convertToJson(tag);
        assertThatJson(json).isEqualTo("{}");
    }

    @Test
    public void testComponentsToJson() throws Exception {
        Components components = OASElement.createComponents();
        String json = convertToJson(components);

        assertThatJson(json).isEqualTo(readExpected("Components"));
    }

    @Test
    public void testExternalDocumentationToJson() throws Exception {
        ExternalDocumentation externalDocumentation = OASElement.createExternalDocumentation();
        String json = convertToJson(externalDocumentation);

        assertThatJson(json).isEqualTo(readExpected("ExternalDocumentation"));
    }

    @Test
    public void testOpenAPIToJson() throws Exception {
        OpenAPI openAPI = OASElement.createOpenAPI();
        String json = convertToJson(openAPI);

        assertThatJson(json).isEqualTo(readExpected("OpenAPI"));
    }

    @Test
    public void testOperationToJson() throws Exception {
        Operation operation = OASElement.createOperation();
        String json = convertToJson(operation);

        assertThatJson(json).isEqualTo(readExpected("Operation"));
    }

    @Test
    public void testPathItemToJson() throws Exception {
        PathItem pathItem = OASElement.createPathItem();
        String json = convertToJson(pathItem);

        assertThatJson(json).isEqualTo(readExpected("PathItem"));
    }

    @Test
    public void testPathsToJson() throws Exception {
        Paths paths = OASElement.createPaths();
        String json = convertToJson(paths);

        assertThatJson(json).isEqualTo(readExpected("Paths"));
    }

    @Test
    public void testCallbackToJson() throws Exception {
        Callback callback = OASElement.createCallback();
        String json = convertToJson(callback);

        String readExpected = readExpected("Callback");
        System.out.println("expected:" + readExpected);
        System.out.println("json:" + json);
        assertThatJson(json).isEqualTo(readExpected);
    }

    @Test
    public void testExampleToJson() throws Exception {
        Example example = OASElement.createExample();
        String json = convertToJson(example);

        assertThatJson(json).isEqualTo(readExpected("Example"));
    }

    @Test
    public void testHeaderToJson() throws Exception {
        Header header = OASElement.createHeader();
        String json = convertToJson(header);

        assertThatJson(json).isEqualTo(readExpected("Header"));
    }

    @Test
    public void testContactToJson() throws Exception {
        Contact contact = OASElement.createContact();
        String json = convertToJson(contact);

        assertThatJson(json).isEqualTo(readExpected("Contact"));
    }

    @Test
    public void testInfoToJson() throws Exception {
        Info info = OASElement.createInfo();
        String json = convertToJson(info);

        assertThatJson(json).isEqualTo(readExpected("Info"));
    }

    @Test
    public void testLicenseToJson() throws Exception {
        License license = OASElement.createLicense();
        String json = convertToJson(license);

        assertThatJson(json).isEqualTo(readExpected("License"));
    }

    @Test
    public void testLinkToJson() throws Exception {
        Link link = OASElement.createLink();
        String json = convertToJson(link);

        assertThatJson(json).isEqualTo(readExpected("Link"));
    }

    @Test
    public void testContentToJson() throws Exception {
        Content content = OASElement.createContent();
        String json = convertToJson(content);

        assertThatJson(json).isEqualTo(readExpected("Content"));
    }

    @Test
    public void testDiscriminatorToJson() throws Exception {
        Discriminator discriminator = OASElement.createDiscriminator();
        String json = convertToJson(discriminator);

        assertThatJson(json).isEqualTo(readExpected("Discriminator"));
    }

    @Test
    public void testEncodingToJson() throws Exception {
        Encoding encoding = OASElement.createEncoding();
        String json = convertToJson(encoding);

        assertThatJson(json).isEqualTo(readExpected("Encoding"));
    }

    @Test
    public void testMediaTypeToJson() throws Exception {
        MediaType mediaType = OASElement.createMediaType();
        String json = convertToJson(mediaType);

        assertThatJson(json).isEqualTo(readExpected("MediaType"));
    }

    @Test
    public void testSchemaToJson() throws Exception {
        Schema schema = OASElement.createSchema();
        String json = convertToJson(schema);

        assertThatJson(json).isEqualTo(readExpected("Schema"));
    }

    @Test
    public void testXMLToJson() throws Exception {
        XML xml = OASElement.createXML();
        String json = convertToJson(xml);

        assertThatJson(json).isEqualTo(readExpected("XML"));
    }

    @Test
    public void testParameterToJson() throws Exception {
        Parameter parameter = OASElement.createParameter();
        String json = convertToJson(parameter);

        assertThatJson(json).isEqualTo(readExpected("Parameter"));
    }

    @Test
    public void testRequestBodyToJson() throws Exception {
        RequestBody requestBody = OASElement.createRequestBody();
        String json = convertToJson(requestBody);

        assertThatJson(json).isEqualTo(readExpected("RequestBody"));
    }

    @Test
    public void testAPIResponseToJson() throws Exception {
        APIResponse apiResponse = OASElement.createAPIResponse();
        String json = convertToJson(apiResponse);

        assertThatJson(json).isEqualTo(readExpected("APIResponse"));
    }

    @Test
    public void testAPIResponsesToJson() throws Exception {
        APIResponses apiResponses = OASElement.createAPIResponses();
        String json = convertToJson(apiResponses);

        assertThatJson(json).isEqualTo(readExpected("APIResponses"));
    }

    @Test
    public void testOAuthFlowToJson() throws Exception {
        OAuthFlow oAuthFlow = OASElement.createOAuthFlow();
        String json = convertToJson(oAuthFlow);

        assertThatJson(json).isEqualTo(readExpected("OAuthFlow"));
    }

    @Test
    public void testOAuthFlowsToJson() throws Exception {
        OAuthFlows oAuthFlows = OASElement.createOAuthFlows();
        String json = convertToJson(oAuthFlows);

        assertThatJson(json).isEqualTo(readExpected("OAuthFlows"));
    }

    @Test
    public void testSecurityRequirementToJson() throws Exception {
        SecurityRequirement securityRequirement = OASElement.createSecurityRequirement();
        String json = convertToJson(securityRequirement);

        assertThatJson(json).isEqualTo(readExpected("SecurityRequirement"));
    }

    @Test
    public void testSecuritySchemeToJson() throws Exception {
        SecurityScheme securityScheme = OASElement.createSecurityScheme();
        String json = convertToJson(securityScheme);

        assertThatJson(json).isEqualTo(readExpected("SecurityScheme"));
    }

    @Test
    public void testServerToJson() throws Exception {
        Server server = OASElement.createServer();
        String json = convertToJson(server);

        assertThatJson(json).isEqualTo(readExpected("Server"));
    }

    @Test
    public void testServerVariableToJson() throws Exception {
        ServerVariable serverVariable = OASElement.createServerVariable();
        String json = convertToJson(serverVariable);

        assertThatJson(json).isEqualTo(readExpected("ServerVariable"));
    }

    @Test
    public void testTagToJson() throws Exception {
        Tag tag = OASElement.createTag();
        String json = convertToJson(tag);

        assertThatJson(json).isEqualTo(readExpected("Tag"));
    }

    @Test
    public void testSchemaWithAdditionalPropertesSchemaToJson() throws Exception {
        Schema schema = OASElement.createSchemaWithAdditionalPropertesSchema();
        String json = convertToJson(schema);

        assertThatJson(json).isEqualTo(readExpected("SchemaWithAdditionalPropertesSchema"));
    }

    @Test
    public void testSchemaWithAdditionalPropertesBooleanToJson() throws Exception {
        Schema schema = OASElement.createSchemaWithAdditionalPropertesBoolean();
        String json = convertToJson(schema);

        assertThatJson(json).isEqualTo(readExpected("SchemaWithAdditionalPropertesBoolean"));
    }

    @Test
    public void testPathItemWithReferenceToJson() throws Exception {
        PathItem pathItem = OASElement.createPathItem()
            .ref("#/components/pathItems/SomePathItem")
            .description("Some description");

        String json = convertToJson(pathItem);

        assertThatJson(json).isEqualTo(readExpected("PathItemWithReference"));
    }

    @Test
    public void testCallbackWithReferenceToJson() throws Exception {
        Callback callback = OASElement.createCallback()
            .ref("#/components/callbacks/SomeCallback");

        String json = convertToJson(callback);

        assertThatJson(json).isEqualTo(readExpected("CallbackWithReference"));
    }

    @Test
    public void testExampleWithReferenceToJson() throws Exception {
        Example example = OASElement.createExample()
            .ref("#/components/examples/SomeExample")
            .description("Some description");

        String json = convertToJson(example);

        assertThatJson(json).isEqualTo(readExpected("ExampleWithReference"));
    }

    @Test
    public void testHeaderWithReferenceToJson() throws Exception {
        Header header = OASElement.createHeader()
            .ref("#/components/headers/SomeHeader")
            .description("Some description");

        String json = convertToJson(header);

        assertThatJson(json).isEqualTo(readExpected("HeaderWithReference"));
    }

    @Test
    public void testLinkWithReferenceToJson() throws Exception {
        Link link = OASElement.createLink()
            .ref("#/components/links/SomeLink")
            .description("Some description");

        String json = convertToJson(link);

        assertThatJson(json).isEqualTo(readExpected("LinkWithReference"));
    }

    @Test
    public void testSchemaWithReferenceToJson() throws Exception {
        Schema schema = OASElement.createSchema()
            .ref("#/components/schemas/SomeSchema")
            .title("Title")
            .description("Some description");

        String json = convertToJson(schema);

        assertThatJson(json).isEqualTo(readExpected("SchemaWithReference"));
    }

    @Test
    public void testParameterWithReferenceToJson() throws Exception {
        Parameter parameter = OASElement.createParameter()
            .ref("#/components/parameters/SomeParameter")
            .name("SomeName")
            .description("Some description");

        String json = convertToJson(parameter);

        assertThatJson(json).isEqualTo(readExpected("ParameterWithReference"));
    }

    @Test
    public void testRequestBodyWithReferenceToJson() throws Exception {
        RequestBody requestBody = OASElement.createRequestBody()
            .ref("#/components/requestBodies/SomeRequestBody")
            .description("Some description");

        String json = convertToJson(requestBody);

        assertThatJson(json).isEqualTo(readExpected("RequestBodyWithReference"));
    }

    @Test
    public void testAPIResponseWithReferenceToJson() throws Exception {
        APIResponse apiResponse = OASElement.createAPIResponse()
            .ref("#/components/responses/SomeAPIResponse")
            .description("Some description");

        String json = convertToJson(apiResponse);

        assertThatJson(json).isEqualTo(readExpected("APIResponseWithReference"));
    }

    @Test
    public void testSecuritySchemeWithReferenceToJson() throws Exception {
        SecurityScheme securityScheme = OASElement.createSecurityScheme()
            .ref("#/components/securitySchemes/SomeSecurityScheme")
            .name("SomeName")
            .description("Some description");

        String json = convertToJson(securityScheme);

        assertThatJson(json).isEqualTo(readExpected("SecuritySchemeWithReference"));
    }

    private String readExpected(String name) throws IOException {
        return AbstractSpecTest.read(getClass().getResourceAsStream("/extended-tck/elements/" + name + ".json"));
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

    protected abstract String convertToJson(SecurityRequirement securityRequirement) throws IOException;

    protected abstract String convertToJson(SecurityScheme securityScheme) throws IOException;

    protected abstract String convertToJson(Server server) throws IOException;

    protected abstract String convertToJson(ServerVariable serverVariable) throws IOException;

    protected abstract String convertToJson(Tag tag) throws IOException;

}
