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

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

public class OASAccept {

    public static void accept(OASVisitor visitor, OpenAPI openAPI) {
        accept(visitor, openAPI, "$");
    }

    public static void accept(OASVisitor visitor, OpenAPI openAPI, String jsonPath) {
        if (openAPI != null) {
            OASVisitResult result = visitor.visit(openAPI, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                List<Server> servers = openAPI.getServers();
                if (servers != null) {
                    for (int i = 0; i < servers.size(); i++) {
                        Server item = servers.get(i);
                        accept(visitor, item, jsonPath + ".servers[" + i + "]");
                    }
                }
                List<SecurityRequirement> security = openAPI.getSecurity();
                if (security != null) {
                    for (int i = 0; i < security.size(); i++) {
                        SecurityRequirement item = security.get(i);
                        accept(visitor, item, jsonPath + ".security[" + i + "]");
                    }
                }
                List<Tag> tags = openAPI.getTags();
                if (tags != null) {
                    for (int i = 0; i < tags.size(); i++) {
                        Tag item = tags.get(i);
                        accept(visitor, item, jsonPath + ".tags[" + i + "]");
                    }
                }
                accept(visitor, openAPI.getInfo(), jsonPath + ".info");
                accept(visitor, openAPI.getExternalDocs(), jsonPath + ".externalDocs");
                accept(visitor, openAPI.getPaths(), jsonPath + ".paths");
                accept(visitor, openAPI.getComponents(), jsonPath + ".components");
            }
        }
    }

    public static void accept(OASVisitor visitor, APIResponse apiResponse) {
        accept(visitor, apiResponse, "$");
    }

    public static void accept(OASVisitor visitor, APIResponse apiResponse, String jsonPath) {
        if (apiResponse != null) {
            OASVisitResult result = visitor.visit(apiResponse, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                Map<String, Header> headers = apiResponse.getHeaders();
                if (headers != null) {
                    for (Entry<String, Header> item : headers.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".headers.['" + item.getKey() + "']");
                    }
                }
                Map<String, Link> links = apiResponse.getLinks();
                if (links != null) {
                    for (Entry<String, Link> item : links.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".links.['" + item.getKey() + "']");
                    }
                }
                accept(visitor, apiResponse.getContent(), jsonPath + ".content");
            }
        }
    }

    public static void accept(OASVisitor visitor, APIResponses apiResponses) {
        accept(visitor, apiResponses, "$");
    }

    public static void accept(OASVisitor visitor, APIResponses apiResponses, String jsonPath) {
        if (apiResponses != null) {
            OASVisitResult result = visitor.visit(apiResponses, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                Map<String, APIResponse> map = apiResponses.getAPIResponses();
                if (map != null) {
                    for (Entry<String, APIResponse> item : map.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".['" + item.getKey() + "']");
                    }
                }
            }
        }
    }

    public static void accept(OASVisitor visitor, Callback callback) {
        accept(visitor, callback, "$");
    }

    public static void accept(OASVisitor visitor, Callback callback, String jsonPath) {
        if (callback != null) {
            OASVisitResult result = visitor.visit(callback, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                Map<String, PathItem> pathItems = callback.getPathItems();
                if (pathItems != null) {
                    for (Entry<String, PathItem> item : pathItems.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".['" + item.getKey() + "']");
                    }
                }
            }
        }
    }

    public static void accept(OASVisitor visitor, Components components) {
        accept(visitor, components, "$");
    }

    public static void accept(OASVisitor visitor, Components components, String jsonPath) {
        if (components != null) {
            OASVisitResult result = visitor.visit(components, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                Map<String, Schema> schemas = components.getSchemas();
                if (schemas != null) {
                    for (Entry<String, Schema> item : schemas.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".schemas.['" + item.getKey() + "']");
                    }
                }
                Map<String, APIResponse> responses = components.getResponses();
                if (responses != null) {
                    for (Entry<String, APIResponse> item : responses.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".responses.['" + item.getKey() + "']");
                    }
                }
                Map<String, Parameter> parameters = components.getParameters();
                if (parameters != null) {
                    for (Entry<String, Parameter> item : parameters.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".parameters.['" + item.getKey() + "']");
                    }
                }
                Map<String, Example> examples = components.getExamples();
                if (examples != null) {
                    for (Entry<String, Example> item : examples.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".examples.['" + item.getKey() + "']");
                    }
                }
                Map<String, RequestBody> requestBodies = components.getRequestBodies();
                if (requestBodies != null) {
                    for (Entry<String, RequestBody> item : requestBodies.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".requestBodies.['" + item.getKey() + "']");
                    }
                }
                Map<String, Header> headers = components.getHeaders();
                if (headers != null) {
                    for (Entry<String, Header> item : headers.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".headers.['" + item.getKey() + "']");
                    }
                }
                Map<String, SecurityScheme> securitySchemes = components.getSecuritySchemes();
                if (securitySchemes != null) {
                    for (Entry<String, SecurityScheme> item : securitySchemes.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".securitySchemes.['" + item.getKey() + "']");
                    }
                }
                Map<String, Link> links = components.getLinks();
                if (links != null) {
                    for (Entry<String, Link> item : links.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".links.['" + item.getKey() + "']");
                    }
                }
                Map<String, Callback> callbacks = components.getCallbacks();
                if (callbacks != null) {
                    for (Entry<String, Callback> item : callbacks.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".callbacks.['" + item.getKey() + "']");
                    }
                }
            }
        }
    }

    public static void accept(OASVisitor visitor, Contact contact) {
        accept(visitor, contact, "$");
    }

    public static void accept(OASVisitor visitor, Contact contact, String jsonPath) {
        if (contact != null) {
            visitor.visit(contact, jsonPath);
        }
    }

    public static void accept(OASVisitor visitor, Content content) {
        accept(visitor, content, "$");
    }

    public static void accept(OASVisitor visitor, Content content, String jsonPath) {
        if (content != null) {
            OASVisitResult result = visitor.visit(content, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                Map<String, MediaType> mediaTypes = content.getMediaTypes();
                if (mediaTypes != null) {
                    for (Entry<String, MediaType> item : mediaTypes.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".['" + item.getKey() + "']");
                    }
                }
            }
        }
    }

    public static void accept(OASVisitor visitor, Discriminator discriminator) {
        accept(visitor, discriminator, "$");
    }

    public static void accept(OASVisitor visitor, Discriminator discriminator, String jsonPath) {
        if (discriminator != null) {
            visitor.visit(discriminator, jsonPath);
        }
    }

    public static void accept(OASVisitor visitor, Encoding encoding) {
        accept(visitor, encoding, "$");
    }

    public static void accept(OASVisitor visitor, Encoding encoding, String jsonPath) {
        if (encoding != null) {
            OASVisitResult result = visitor.visit(encoding, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                Map<String, Header> headers = encoding.getHeaders();
                if (headers != null) {
                    for (Entry<String, Header> item : headers.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".headers.['" + item.getKey() + "']");
                    }
                }
            }
        }
    }

    public static void accept(OASVisitor visitor, Example example) {
        accept(visitor, example, "$");
    }

    public static void accept(OASVisitor visitor, Example example, String jsonPath) {
        if (example != null) {
            visitor.visit(example, jsonPath);
        }
    }

    public static void accept(OASVisitor visitor, ExternalDocumentation externalDocumentation) {
        accept(visitor, externalDocumentation, "$");
    }

    public static void accept(OASVisitor visitor, ExternalDocumentation externalDocumentation, String jsonPath) {
        if (externalDocumentation != null) {
            visitor.visit(externalDocumentation, jsonPath);
        }
    }

    public static void accept(OASVisitor visitor, Header header) {
        accept(visitor, header, "$");
    }

    public static void accept(OASVisitor visitor, Header header, String jsonPath) {
        if (header != null) {
            OASVisitResult result = visitor.visit(header, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                Map<String, Example> examples = header.getExamples();
                if (examples != null) {
                    for (Entry<String, Example> item : examples.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".examples.['" + item.getKey() + "']");
                    }
                }
                accept(visitor, header.getSchema(), jsonPath + ".schema");
                accept(visitor, header.getContent(), jsonPath + ".content");
            }
        }
    }

    public static void accept(OASVisitor visitor, Info info) {
        accept(visitor, info, "$");
    }

    public static void accept(OASVisitor visitor, Info info, String jsonPath) {
        if (info != null) {
            OASVisitResult result = visitor.visit(info, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                accept(visitor, info.getContact(), jsonPath + ".contact");
                accept(visitor, info.getLicense(), jsonPath + ".license");
            }
        }
    }

    public static void accept(OASVisitor visitor, License license) {
        accept(visitor, license, "$");
    }

    public static void accept(OASVisitor visitor, License license, String jsonPath) {
        if (license != null) {
            visitor.visit(license, jsonPath);
        }
    }

    public static void accept(OASVisitor visitor, Link link) {
        accept(visitor, link, "$");
    }

    public static void accept(OASVisitor visitor, Link link, String jsonPath) {
        if (link != null) {
            OASVisitResult result = visitor.visit(link, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                accept(visitor, link.getServer(), jsonPath + ".server");
            }
        }
    }

    public static void accept(OASVisitor visitor, MediaType mediaType) {
        accept(visitor, mediaType, "$");
    }

    public static void accept(OASVisitor visitor, MediaType mediaType, String jsonPath) {
        if (mediaType != null) {
            OASVisitResult result = visitor.visit(mediaType, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                Map<String, Example> examples = mediaType.getExamples();
                if (examples != null) {
                    for (Entry<String, Example> item : examples.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".examples.['" + item.getKey() + "']");
                    }
                }
                Map<String, Encoding> encoding = mediaType.getEncoding();
                if (encoding != null) {
                    for (Entry<String, Encoding> item : encoding.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".encoding.['" + item.getKey() + "']");
                    }
                }
                accept(visitor, mediaType.getSchema(), jsonPath + ".schema");
            }
        }
    }

    public static void accept(OASVisitor visitor, OAuthFlow oAuthFlow) {
        accept(visitor, oAuthFlow, "$");
    }

    public static void accept(OASVisitor visitor, OAuthFlow oAuthFlow, String jsonPath) {
        if (oAuthFlow != null) {
            OASVisitResult result = visitor.visit(oAuthFlow, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                accept(visitor, oAuthFlow.getScopes(), jsonPath + ".scopes");
            }
        }
    }

    public static void accept(OASVisitor visitor, OAuthFlows oAuthFlows) {
        accept(visitor, oAuthFlows, "$");
    }

    public static void accept(OASVisitor visitor, OAuthFlows oAuthFlows, String jsonPath) {
        if (oAuthFlows != null) {
            OASVisitResult result = visitor.visit(oAuthFlows, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                accept(visitor, oAuthFlows.getImplicit(), jsonPath + ".implicit");
                accept(visitor, oAuthFlows.getPassword(), jsonPath + ".password");
                accept(visitor, oAuthFlows.getClientCredentials(), jsonPath + ".clientCredentials");
                accept(visitor, oAuthFlows.getAuthorizationCode(), jsonPath + ".authorizationCode");
            }
        }
    }

    public static void accept(OASVisitor visitor, Operation operation) {
        accept(visitor, operation, "$");
    }

    public static void accept(OASVisitor visitor, Operation operation, String jsonPath) {
        if (operation != null) {
            OASVisitResult result = visitor.visit(operation, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                Map<String, Callback> callbacks = operation.getCallbacks();
                if (callbacks != null) {
                    for (Entry<String, Callback> item : callbacks.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".callbacks.['" + item.getKey() + "']");
                    }
                }
                List<Parameter> parameters = operation.getParameters();
                if (parameters != null) {
                    for (int i = 0; i < parameters.size(); i++) {
                        Parameter item = parameters.get(i);
                        accept(visitor, item, jsonPath + ".parameters[" + i + "]");
                    }
                }
                List<SecurityRequirement> security = operation.getSecurity();
                if (security != null) {
                    for (int i = 0; i < security.size(); i++) {
                        SecurityRequirement item = security.get(i);
                        accept(visitor, item, jsonPath + ".security[" + i + "]");
                    }
                }
                List<Server> servers = operation.getServers();
                if (servers != null) {
                    for (int i = 0; i < servers.size(); i++) {
                        Server item = servers.get(i);
                        accept(visitor, item, jsonPath + ".servers[" + i + "]");
                    }
                }
                accept(visitor, operation.getExternalDocs(), jsonPath + ".externalDocs");
                accept(visitor, operation.getRequestBody(), jsonPath + ".requestBody");
                accept(visitor, operation.getResponses(), jsonPath + ".responses");
            }
        }
    }

    public static void accept(OASVisitor visitor, Parameter parameter) {
        accept(visitor, parameter, "$");
    }

    public static void accept(OASVisitor visitor, Parameter parameter, String jsonPath) {
        if (parameter != null) {
            OASVisitResult result = visitor.visit(parameter, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                Map<String, Example> examples = parameter.getExamples();
                if (examples != null) {
                    for (Entry<String, Example> item : examples.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".examples.['" + item.getKey() + "']");
                    }
                }
                accept(visitor, parameter.getSchema(), jsonPath + ".schema");
                accept(visitor, parameter.getContent(), jsonPath + ".content");
            }
        }
    }

    public static void accept(OASVisitor visitor, PathItem pathItem) {
        accept(visitor, pathItem, "$");
    }

    public static void accept(OASVisitor visitor, PathItem pathItem, String jsonPath) {
        if (pathItem != null) {
            OASVisitResult result = visitor.visit(pathItem, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                List<Server> servers = pathItem.getServers();
                if (servers != null) {
                    for (int i = 0; i < servers.size(); i++) {
                        Server item = servers.get(i);
                        accept(visitor, item, jsonPath + ".servers[" + i + "]");
                    }
                }
                List<Parameter> parameters = pathItem.getParameters();
                if (parameters != null) {
                    for (int i = 0; i < parameters.size(); i++) {
                        Parameter item = parameters.get(i);
                        accept(visitor, item, jsonPath + ".parameters[" + i + "]");
                    }
                }
                accept(visitor, pathItem.getGET(), jsonPath + ".get");
                accept(visitor, pathItem.getPUT(), jsonPath + ".put");
                accept(visitor, pathItem.getPOST(), jsonPath + ".post");
                accept(visitor, pathItem.getDELETE(), jsonPath + ".delete");
                accept(visitor, pathItem.getOPTIONS(), jsonPath + ".options");
                accept(visitor, pathItem.getHEAD(), jsonPath + ".head");
                accept(visitor, pathItem.getPATCH(), jsonPath + ".patch");
                accept(visitor, pathItem.getTRACE(), jsonPath + ".trace");
            }
        }
    }

    public static void accept(OASVisitor visitor, Paths paths) {
        accept(visitor, paths, "$");
    }

    public static void accept(OASVisitor visitor, Paths paths, String jsonPath) {
        if (paths != null) {
            OASVisitResult result = visitor.visit(paths, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                Map<String, PathItem> pathItems = paths.getPathItems();
                if (pathItems != null) {
                    for (Entry<String, PathItem> item : pathItems.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".['" + item.getKey() + "']");
                    }
                }
            }
        }
    }

    public static void accept(OASVisitor visitor, RequestBody requestBody) {
        accept(visitor, requestBody, "$");
    }

    public static void accept(OASVisitor visitor, RequestBody requestBody, String jsonPath) {
        if (requestBody != null) {
            OASVisitResult result = visitor.visit(requestBody, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                accept(visitor, requestBody.getContent(), jsonPath + ".content");
            }
        }
    }

    public static void accept(OASVisitor visitor, Schema schema) {
        accept(visitor, schema, "$");
    }

    public static void accept(OASVisitor visitor, Schema schema, String jsonPath) {
        if (schema != null) {
            OASVisitResult result = visitor.visit(schema, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                Map<String, Schema> properties = schema.getProperties();
                if (properties != null) {
                    for (Entry<String, Schema> item : properties.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".properties.['" + item.getKey() + "']");
                    }
                }
                List<Schema> allOf = schema.getAllOf();
                if (allOf != null) {
                    for (int i = 0; i < allOf.size(); i++) {
                        Schema item = allOf.get(i);
                        accept(visitor, item, jsonPath + ".allOf[" + i + "]");
                    }
                }
                List<Schema> anyOf = schema.getAnyOf();
                if (anyOf != null) {
                    for (int i = 0; i < anyOf.size(); i++) {
                        Schema item = anyOf.get(i);
                        accept(visitor, item, jsonPath + ".anyOf[" + i + "]");
                    }
                }
                List<Schema> oneOf = schema.getOneOf();
                if (oneOf != null) {
                    for (int i = 0; i < oneOf.size(); i++) {
                        Schema item = oneOf.get(i);
                        accept(visitor, item, jsonPath + ".oneOf[" + i + "]");
                    }
                }
                accept(visitor, schema.getDiscriminator(), jsonPath + ".discriminator");
                accept(visitor, schema.getNot(), jsonPath + ".not");
                accept(visitor, schema.getAdditionalPropertiesSchema(), jsonPath + ".additionalPropertiesSchema");
                accept(visitor, schema.getExternalDocs(), jsonPath + ".externalDocs");
                accept(visitor, schema.getXml(), jsonPath + ".xml");
                accept(visitor, schema.getItems(), jsonPath + ".items");
            }
        }
    }

    public static void accept(OASVisitor visitor, Scopes scopes) {
        accept(visitor, scopes, "$");
    }

    public static void accept(OASVisitor visitor, Scopes scopes, String jsonPath) {
        if (scopes != null) {
            visitor.visit(scopes, jsonPath);
        }
    }

    public static void accept(OASVisitor visitor, SecurityRequirement securityRequirement) {
        accept(visitor, securityRequirement, "$");
    }

    public static void accept(OASVisitor visitor, SecurityRequirement securityRequirement, String jsonPath) {
        if (securityRequirement != null) {
            visitor.visit(securityRequirement, jsonPath);
        }
    }

    public static void accept(OASVisitor visitor, SecurityScheme securityScheme) {
        accept(visitor, securityScheme, "$");
    }

    public static void accept(OASVisitor visitor, SecurityScheme securityScheme, String jsonPath) {
        if (securityScheme != null) {
            OASVisitResult result = visitor.visit(securityScheme, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                accept(visitor, securityScheme.getFlows(), jsonPath + ".flows");
            }
        }
    }

    public static void accept(OASVisitor visitor, Server server) {
        accept(visitor, server, "$");
    }

    public static void accept(OASVisitor visitor, Server server, String jsonPath) {
        if (server != null) {
            OASVisitResult result = visitor.visit(server, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                accept(visitor, server.getVariables(), jsonPath + ".variables");
            }
        }
    }

    public static void accept(OASVisitor visitor, ServerVariable serverVariable) {
        accept(visitor, serverVariable, "$");
    }

    public static void accept(OASVisitor visitor, ServerVariable serverVariable, String jsonPath) {
        if (serverVariable != null) {
            visitor.visit(serverVariable, jsonPath);
        }
    }

    public static void accept(OASVisitor visitor, ServerVariables serverVariables) {
        accept(visitor, serverVariables, "$");
    }

    public static void accept(OASVisitor visitor, ServerVariables serverVariables, String jsonPath) {
        if (serverVariables != null) {
            OASVisitResult result = visitor.visit(serverVariables, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                Map<String, ServerVariable> map = serverVariables.getServerVariables();
                if (map != null) {
                    for (Entry<String, ServerVariable> item : map.entrySet()) {
                        accept(visitor, item.getValue(), jsonPath + ".['" + item.getKey() + "']");
                    }
                }
            }
        }
    }

    public static void accept(OASVisitor visitor, Tag tag) {
        accept(visitor, tag, "$");
    }

    public static void accept(OASVisitor visitor, Tag tag, String jsonPath) {
        if (tag != null) {
            OASVisitResult result = visitor.visit(tag, jsonPath);
            if (result == OASVisitResult.CONTINUE) {
                accept(visitor, tag.getExternalDocs(), jsonPath + ".externalDocs");
            }
        }
    }

    public static void accept(OASVisitor visitor, XML xml) {
        accept(visitor, xml, "$");
    }

    public static void accept(OASVisitor visitor, XML xml, String jsonPath) {
        if (xml != null) {
            visitor.visit(xml, jsonPath);
        }
    }

}
