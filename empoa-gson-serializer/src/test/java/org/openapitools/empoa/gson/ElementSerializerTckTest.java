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
package org.openapitools.empoa.gson;

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
        return OASGsonSerializer.instance()
            .toJson(components);
    }

    @Override
    protected String convertToJson(ExternalDocumentation externalDocumentation) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(externalDocumentation);
    }

    @Override
    protected String convertToJson(OpenAPI openAPI) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(openAPI);
    }

    @Override
    protected String convertToJson(Operation operation) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(operation);
    }

    @Override
    protected String convertToJson(PathItem pathItem) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(pathItem);
    }

    @Override
    protected String convertToJson(Paths paths) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(paths);
    }

    @Override
    protected String convertToJson(Callback callback) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(callback);
    }

    @Override
    protected String convertToJson(Example example) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(example);
    }

    @Override
    protected String convertToJson(Header header) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(header);
    }

    @Override
    protected String convertToJson(Contact contact) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(contact);
    }

    @Override
    protected String convertToJson(Info info) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(info);
    }

    @Override
    protected String convertToJson(License license) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(license);
    }

    @Override
    protected String convertToJson(Link link) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(link);
    }

    @Override
    protected String convertToJson(Content content) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(content);
    }

    @Override
    protected String convertToJson(Discriminator discriminator) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(discriminator);
    }

    @Override
    protected String convertToJson(Encoding encoding) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(encoding);
    }

    @Override
    protected String convertToJson(MediaType mediaType) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(mediaType);
    }

    @Override
    protected String convertToJson(Schema schema) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(schema);
    }

    @Override
    protected String convertToJson(XML xML) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(xML);
    }

    @Override
    protected String convertToJson(Parameter parameter) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(parameter);
    }

    @Override
    protected String convertToJson(RequestBody requestBody) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(requestBody);
    }

    @Override
    protected String convertToJson(APIResponse apiResponse) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(apiResponse);
    }

    @Override
    protected String convertToJson(APIResponses apiResponses) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(apiResponses);
    }

    @Override
    protected String convertToJson(OAuthFlow oAuthFlow) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(oAuthFlow);
    }

    @Override
    protected String convertToJson(OAuthFlows oAuthFlows) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(oAuthFlows);
    }

    @Override
    protected String convertToJson(SecurityRequirement securityRequirement) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(securityRequirement);
    }

    @Override
    protected String convertToJson(SecurityScheme securityScheme) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(securityScheme);
    }

    @Override
    protected String convertToJson(Server server) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(server);
    }

    @Override
    protected String convertToJson(ServerVariable serverVariable) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(serverVariable);
    }

    @Override
    protected String convertToJson(Tag tag) throws IOException {
        return OASGsonSerializer.instance()
            .toJson(tag);
    }

}
