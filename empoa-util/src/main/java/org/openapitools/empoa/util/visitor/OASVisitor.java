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

public interface OASVisitor {

    OASVisitResult visit(OpenAPI openAPI, String jsonPath);

    OASVisitResult visit(APIResponse apiResponse, String jsonPath);

    OASVisitResult visit(APIResponses apiResponses, String jsonPath);

    OASVisitResult visit(Callback callback, String jsonPath);

    OASVisitResult visit(Components components, String jsonPath);

    OASVisitResult visit(Contact contact, String jsonPath);

    OASVisitResult visit(Content content, String jsonPath);

    OASVisitResult visit(Discriminator discriminator, String jsonPath);

    OASVisitResult visit(Encoding encoding, String jsonPath);

    OASVisitResult visit(Example example, String jsonPath);

    OASVisitResult visit(ExternalDocumentation externalDocumentation, String jsonPath);

    OASVisitResult visit(Header header, String jsonPath);

    OASVisitResult visit(Info info, String jsonPath);

    OASVisitResult visit(License license, String jsonPath);

    OASVisitResult visit(Link link, String jsonPath);

    OASVisitResult visit(MediaType mediaType, String jsonPath);

    OASVisitResult visit(OAuthFlow oAuthFlow, String jsonPath);

    OASVisitResult visit(OAuthFlows oAuthFlows, String jsonPath);

    OASVisitResult visit(Operation operation, String jsonPath);

    OASVisitResult visit(Parameter parameter, String jsonPath);

    OASVisitResult visit(PathItem pathItem, String jsonPath);

    OASVisitResult visit(Paths paths, String jsonPath);

    OASVisitResult visit(RequestBody requestBody, String jsonPath);

    OASVisitResult visit(Schema schema, String jsonPath);

    OASVisitResult visit(Scopes scopes, String jsonPath);

    OASVisitResult visit(SecurityRequirement securityRequirement, String jsonPath);

    OASVisitResult visit(SecurityScheme securityScheme, String jsonPath);

    OASVisitResult visit(Server server, String jsonPath);

    OASVisitResult visit(ServerVariable serverVariable, String jsonPath);

    OASVisitResult visit(ServerVariables serverVariables, String jsonPath);

    OASVisitResult visit(Tag tag, String jsonPath);

    OASVisitResult visit(XML xml, String jsonPath);

}
