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
package org.openapitools.empoa.util.visitor;

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

public class OASVisitorAdapter implements OASVisitor {

    @Override
    public OASVisitResult visit(OpenAPI openAPI, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(APIResponse apiResponse, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(APIResponses apiResponses, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Callback callback, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Components components, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Contact contact, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Content content, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Discriminator discriminator, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Encoding encoding, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Example example, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(ExternalDocumentation externalDocumentation, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Header header, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Info info, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(License license, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Link link, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(MediaType mediaType, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(OAuthFlow oAuthFlow, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(OAuthFlows oAuthFlows, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Operation operation, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Parameter parameter, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(PathItem pathItem, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Paths paths, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(RequestBody requestBody, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Schema schema, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Scopes scopes, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(SecurityRequirement securityRequirement, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(SecurityScheme securityScheme, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Server server, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(ServerVariable serverVariable, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(ServerVariables serverVariables, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(Tag tag, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

    @Override
    public OASVisitResult visit(XML xml, String jsonPath) {
        return OASVisitResult.CONTINUE;
    }

}
