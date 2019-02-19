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
package org.openapitools.empoa.extended.tck.specs;

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

public final class OASElement {

    public static Components createComponents() {
        return OASFactory.createComponents()
            .addSchema("SomeObject", createSchema());
    }

    public static ExternalDocumentation createExternalDocumentation() {
        return OASFactory.createExternalDocumentation()
            .description("Some description");
    }

    public static OpenAPI createOpenAPI() {
        return OASFactory.createOpenAPI()
            .openapi("3.0.1");
    }

    public static Operation createOperation() {
        return OASFactory.createOperation()
            .description("Some description")
            .addParameter(createParameter())
            .addTag("Tag");
    }

    public static PathItem createPathItem() {
        return OASFactory.createPathItem()
            .description("Some description")
            .GET(createOperation());
    }

    public static Paths createPaths() {
        return OASFactory.createPaths()
            .addPathItem("ping", createPathItem());
    }

    public static Callback createCallback() {
        return OASFactory.createCallback()
            .addPathItem("call-me-back", createPathItem());
    }

    public static Example createExample() {
        return OASFactory.createExample()
            .description("Some description");
    }

    public static Header createHeader() {
        return OASFactory.createHeader()
            .schema(createStringSchema())
            .description("Some description");
    }

    public static Contact createContact() {
        return OASFactory.createContact()
            .name("SomeName")
            .email("example@company.com");
    }

    public static Info createInfo() {
        return OASFactory.createInfo()
            .title("Title")
            .description("Some description");
    }

    public static License createLicense() {
        return OASFactory.createLicense()
            .name("SomeName");
    }

    public static Link createLink() {
        return OASFactory.createLink()
            .description("Some description");
    }

    public static Content createContent() {
        return OASFactory.createContent()
            .addMediaType("application/json", createMediaType());
    }

    public static Discriminator createDiscriminator() {
        return OASFactory.createDiscriminator()
            .propertyName("type")
            .addMapping("a", "value_a")
            .addMapping("b", "value_b");
    }

    public static Encoding createEncoding() {
        return OASFactory.createEncoding()
            .contentType("application/json");

    }

    public static MediaType createMediaType() {
        return OASFactory.createMediaType()
            .schema(
                createSchema()
            );
    }

    public static Schema createSchema() {
        return OASFactory.createSchema()
            .type(Schema.SchemaType.OBJECT)
            .title("Title")
            .description("Some description")
            .addProperty("id", createIntSchema())
            .addProperty("name", createStringSchema());
    }

    public static Schema createStringSchema() {
        return OASFactory.createSchema()
            .type(Schema.SchemaType.STRING)
            .title("Title")
            .description("Some description");
    }

    public static Schema createIntSchema() {
        return OASFactory.createSchema()
            .type(Schema.SchemaType.INTEGER)
            .format("int32")
            .title("Title")
            .description("Some description");
    }

    public static XML createXML() {
        return OASFactory.createXML()
            .name("SomeName");
    }

    public static Parameter createParameter() {
        return OASFactory.createParameter()
            .name("SomeName")
            .in(Parameter.In.QUERY)
            .description("Some description")
            .schema(createStringSchema());
    }

    public static RequestBody createRequestBody() {
        return OASFactory.createRequestBody()
            .description("Some description");
    }

    public static APIResponse createAPIResponse() {
        return OASFactory.createAPIResponse()
            .description("Some description");
    }

    public static APIResponses createAPIResponses() {
        return OASFactory.createAPIResponses()
            .addAPIResponse("200", createAPIResponse());
    }

    public static OAuthFlow createOAuthFlow() {
        return OASFactory.createOAuthFlow();
    }

    public static OAuthFlows createOAuthFlows() {
        return OASFactory.createOAuthFlows();
    }

    public static Scopes createScopes() {
        return OASFactory.createScopes()
            .addScope("myScope", "Some description");
    }

    public static SecurityRequirement createSecurityRequirement() {
        return OASFactory.createSecurityRequirement()
            .addScheme("BasicAuth");
    }

    public static SecurityScheme createSecurityScheme() {
        return OASFactory.createSecurityScheme()
            .name("SomeName")
            .description("Some description");
    }

    public static Server createServer() {
        return OASFactory.createServer()
            .description("Some description");
    }

    public static ServerVariable createServerVariable() {
        return OASFactory.createServerVariable()
            .description("Some description");
    }

    public static ServerVariables createServerVariables() {
        return OASFactory.createServerVariables()
            .addServerVariable("somevar", createServerVariable());
    }

    public static Tag createTag() {
        return OASFactory.createTag()
            .name("SomeName")
            .description("Some description");
    }

}
