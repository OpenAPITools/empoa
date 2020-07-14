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
package org.openapitools.empoa.jackson;

import java.io.IOException;

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
import org.openapitools.empoa.extended.tck.AbstractElementSerializerTest;

public class ElementSerializerTckTest extends AbstractElementSerializerTest {

    @Override
    protected String convertToJson(Components components) throws IOException {
        return OpenAPISerializer.serialize(components, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(ExternalDocumentation externalDocumentation) throws IOException {
        return OpenAPISerializer.serialize(externalDocumentation, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(OpenAPI openAPI) throws IOException {
        return OpenAPISerializer.serialize(openAPI, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Operation operation) throws IOException {
        return OpenAPISerializer.serialize(operation, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(PathItem pathItem) throws IOException {
        return OpenAPISerializer.serialize(pathItem, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Paths paths) throws IOException {
        return OpenAPISerializer.serialize(paths, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Callback callback) throws IOException {
        return OpenAPISerializer.serialize(callback, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Example example) throws IOException {
        return OpenAPISerializer.serialize(example, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Header header) throws IOException {
        return OpenAPISerializer.serialize(header, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Contact contact) throws IOException {
        return OpenAPISerializer.serialize(contact, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Info info) throws IOException {
        return OpenAPISerializer.serialize(info, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(License license) throws IOException {
        return OpenAPISerializer.serialize(license, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Link link) throws IOException {
        return OpenAPISerializer.serialize(link, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Content content) throws IOException {
        return OpenAPISerializer.serialize(content, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Discriminator discriminator) throws IOException {
        return OpenAPISerializer.serialize(discriminator, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Encoding encoding) throws IOException {
        return OpenAPISerializer.serialize(encoding, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(MediaType mediaType) throws IOException {
        return OpenAPISerializer.serialize(mediaType, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Schema schema) throws IOException {
        return OpenAPISerializer.serialize(schema, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(XML xML) throws IOException {
        return OpenAPISerializer.serialize(xML, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Parameter parameter) throws IOException {
        return OpenAPISerializer.serialize(parameter, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(RequestBody requestBody) throws IOException {
        return OpenAPISerializer.serialize(requestBody, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(APIResponse apiResponse) throws IOException {
        return OpenAPISerializer.serialize(apiResponse, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(APIResponses apiResponses) throws IOException {
        return OpenAPISerializer.serialize(apiResponses, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(OAuthFlow oAuthFlow) throws IOException {
        return OpenAPISerializer.serialize(oAuthFlow, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(OAuthFlows oAuthFlows) throws IOException {
        return OpenAPISerializer.serialize(oAuthFlows, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(SecurityRequirement securityRequirement) throws IOException {
        return OpenAPISerializer.serialize(securityRequirement, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(SecurityScheme securityScheme) throws IOException {
        return OpenAPISerializer.serialize(securityScheme, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Server server) throws IOException {
        return OpenAPISerializer.serialize(server, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(ServerVariable serverVariable) throws IOException {
        return OpenAPISerializer.serialize(serverVariable, OpenAPISerializer.Format.JSON);
    }

    @Override
    protected String convertToJson(Tag tag) throws IOException {
        return OpenAPISerializer.serialize(tag, OpenAPISerializer.Format.JSON);
    }

}
