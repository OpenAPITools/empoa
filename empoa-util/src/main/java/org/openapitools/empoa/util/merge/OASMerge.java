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
package org.openapitools.empoa.util.merge;

import java.math.BigDecimal;
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
import org.eclipse.microprofile.openapi.models.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.models.security.SecurityScheme;
import org.eclipse.microprofile.openapi.models.servers.Server;
import org.eclipse.microprofile.openapi.models.servers.ServerVariable;
import org.eclipse.microprofile.openapi.models.tags.Tag;
import org.openapitools.empoa.util.copy.OASCopy;
import org.openapitools.empoa.util.equals.OASEquals;

public class OASMerge {

    public static void merge(OpenAPI from, OpenAPI into) {
        if (into == null) {
            throw new IllegalArgumentException("OpenAPI 'into' parameter can not be null");
        }
        if (from != null) {
            String fromOpenapi = from.getOpenapi();
            if (fromOpenapi != null) {
                into.setOpenapi(fromOpenapi);
            }
            Info fromInfo = from.getInfo();
            if (fromInfo != null) {
                Info intoInfo = into.getInfo();
                if (intoInfo != null) {
                    merge(fromInfo, intoInfo);
                } else {
                    into.setInfo(OASCopy.copy(fromInfo));
                }
            }
            ExternalDocumentation fromExternalDocs = from.getExternalDocs();
            if (fromExternalDocs != null) {
                ExternalDocumentation intoExternalDocs = into.getExternalDocs();
                if (intoExternalDocs != null) {
                    merge(fromExternalDocs, intoExternalDocs);
                } else {
                    into.setExternalDocs(OASCopy.copy(fromExternalDocs));
                }
            }
            List<Server> fromServers = from.getServers();
            if (fromServers != null) {
                List<Server> intoServers = into.getServers();
                if (intoServers != null) {
                    for (Server item : fromServers) {
                        if (!intoServers.stream()
                            .anyMatch(i -> OASEquals.equals(i, item))) {
                            into.addServer(OASCopy.copy(item));
                        }
                    }
                } else {
                    for (Server item : fromServers) {
                        into.addServer(OASCopy.copy(item));
                    }
                }
            }
            List<SecurityRequirement> fromSecurity = from.getSecurity();
            if (fromSecurity != null) {
                List<SecurityRequirement> intoSecurity = into.getSecurity();
                if (intoSecurity != null) {
                    for (SecurityRequirement item : fromSecurity) {
                        if (!intoSecurity.stream()
                            .anyMatch(i -> OASEquals.equals(i, item))) {
                            into.addSecurityRequirement(OASCopy.copy(item));
                        }
                    }
                } else {
                    for (SecurityRequirement item : fromSecurity) {
                        into.addSecurityRequirement(OASCopy.copy(item));
                    }
                }
            }
            List<Tag> fromTags = from.getTags();
            if (fromTags != null) {
                List<Tag> intoTags = into.getTags();
                if (intoTags != null) {
                    for (Tag item : fromTags) {
                        if (!intoTags.stream()
                            .anyMatch(i -> OASEquals.equals(i, item))) {
                            into.addTag(OASCopy.copy(item));
                        }
                    }
                } else {
                    for (Tag item : fromTags) {
                        into.addTag(OASCopy.copy(item));
                    }
                }
            }
            Paths fromPaths = from.getPaths();
            if (fromPaths != null) {
                Paths intoPaths = into.getPaths();
                if (intoPaths != null) {
                    merge(fromPaths, intoPaths);
                } else {
                    into.setPaths(OASCopy.copy(fromPaths));
                }
            }
            Components fromComponents = from.getComponents();
            if (fromComponents != null) {
                Components intoComponents = into.getComponents();
                if (intoComponents != null) {
                    merge(fromComponents, intoComponents);
                } else {
                    into.setComponents(OASCopy.copy(fromComponents));
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(APIResponse from, APIResponse into) {
        if (into == null) {
            throw new IllegalArgumentException("APIResponse 'into' parameter can not be null");
        }
        if (from != null) {
            String fromRef = from.getRef();
            if (fromRef != null) {
                into.setRef(fromRef);
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            Map<String, Header> fromHeaders = from.getHeaders();
            if (fromHeaders != null) {
                Map<String, Header> intoHeaders = into.getHeaders();
                if (intoHeaders != null) {
                    for (Entry<String, Header> entry : fromHeaders.entrySet()) {
                        if (intoHeaders.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoHeaders.get(entry.getKey()));
                        } else {
                            into.addHeader(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Header> entry : fromHeaders.entrySet()) {
                        into.addHeader(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Content fromContent = from.getContent();
            if (fromContent != null) {
                Content intoContent = into.getContent();
                if (intoContent != null) {
                    merge(fromContent, intoContent);
                } else {
                    into.setContent(OASCopy.copy(fromContent));
                }
            }
            Map<String, Link> fromLinks = from.getLinks();
            if (fromLinks != null) {
                Map<String, Link> intoLinks = into.getLinks();
                if (intoLinks != null) {
                    for (Entry<String, Link> entry : fromLinks.entrySet()) {
                        if (intoLinks.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoLinks.get(entry.getKey()));
                        } else {
                            into.addLink(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Link> entry : fromLinks.entrySet()) {
                        into.addLink(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(APIResponses from, APIResponses into) {
        if (into == null) {
            throw new IllegalArgumentException("APIResponses 'into' parameter can not be null");
        }
        if (from != null) {
            Map<String, APIResponse> fromAPIResponses = from.getAPIResponses();
            if (fromAPIResponses != null) {
                Map<String, APIResponse> intoAPIResponses = into.getAPIResponses();
                if (intoAPIResponses != null) {
                    for (Entry<String, APIResponse> entry : fromAPIResponses.entrySet()) {
                        if (intoAPIResponses.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoAPIResponses.get(entry.getKey()));
                        } else {
                            into.addAPIResponse(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, APIResponse> entry : fromAPIResponses.entrySet()) {
                        into.addAPIResponse(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Callback from, Callback into) {
        if (into == null) {
            throw new IllegalArgumentException("Callback 'into' parameter can not be null");
        }
        if (from != null) {
            String fromRef = from.getRef();
            if (fromRef != null) {
                into.setRef(fromRef);
            }
            Map<String, PathItem> fromPathItems = from.getPathItems();
            if (fromPathItems != null) {
                Map<String, PathItem> intoPathItems = into.getPathItems();
                if (intoPathItems != null) {
                    for (Entry<String, PathItem> entry : fromPathItems.entrySet()) {
                        if (intoPathItems.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoPathItems.get(entry.getKey()));
                        } else {
                            into.addPathItem(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, PathItem> entry : fromPathItems.entrySet()) {
                        into.addPathItem(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Components from, Components into) {
        if (into == null) {
            throw new IllegalArgumentException("Components 'into' parameter can not be null");
        }
        if (from != null) {
            Map<String, Schema> fromSchemas = from.getSchemas();
            if (fromSchemas != null) {
                Map<String, Schema> intoSchemas = into.getSchemas();
                if (intoSchemas != null) {
                    for (Entry<String, Schema> entry : fromSchemas.entrySet()) {
                        if (intoSchemas.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoSchemas.get(entry.getKey()));
                        } else {
                            into.addSchema(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Schema> entry : fromSchemas.entrySet()) {
                        into.addSchema(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, APIResponse> fromResponses = from.getResponses();
            if (fromResponses != null) {
                Map<String, APIResponse> intoResponses = into.getResponses();
                if (intoResponses != null) {
                    for (Entry<String, APIResponse> entry : fromResponses.entrySet()) {
                        if (intoResponses.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoResponses.get(entry.getKey()));
                        } else {
                            into.addResponse(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, APIResponse> entry : fromResponses.entrySet()) {
                        into.addResponse(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, Parameter> fromParameters = from.getParameters();
            if (fromParameters != null) {
                Map<String, Parameter> intoParameters = into.getParameters();
                if (intoParameters != null) {
                    for (Entry<String, Parameter> entry : fromParameters.entrySet()) {
                        if (intoParameters.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoParameters.get(entry.getKey()));
                        } else {
                            into.addParameter(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Parameter> entry : fromParameters.entrySet()) {
                        into.addParameter(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, Example> fromExamples = from.getExamples();
            if (fromExamples != null) {
                Map<String, Example> intoExamples = into.getExamples();
                if (intoExamples != null) {
                    for (Entry<String, Example> entry : fromExamples.entrySet()) {
                        if (intoExamples.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoExamples.get(entry.getKey()));
                        } else {
                            into.addExample(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Example> entry : fromExamples.entrySet()) {
                        into.addExample(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, RequestBody> fromRequestBodies = from.getRequestBodies();
            if (fromRequestBodies != null) {
                Map<String, RequestBody> intoRequestBodies = into.getRequestBodies();
                if (intoRequestBodies != null) {
                    for (Entry<String, RequestBody> entry : fromRequestBodies.entrySet()) {
                        if (intoRequestBodies.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoRequestBodies.get(entry.getKey()));
                        } else {
                            into.addRequestBody(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, RequestBody> entry : fromRequestBodies.entrySet()) {
                        into.addRequestBody(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, Header> fromHeaders = from.getHeaders();
            if (fromHeaders != null) {
                Map<String, Header> intoHeaders = into.getHeaders();
                if (intoHeaders != null) {
                    for (Entry<String, Header> entry : fromHeaders.entrySet()) {
                        if (intoHeaders.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoHeaders.get(entry.getKey()));
                        } else {
                            into.addHeader(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Header> entry : fromHeaders.entrySet()) {
                        into.addHeader(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, SecurityScheme> fromSecuritySchemes = from.getSecuritySchemes();
            if (fromSecuritySchemes != null) {
                Map<String, SecurityScheme> intoSecuritySchemes = into.getSecuritySchemes();
                if (intoSecuritySchemes != null) {
                    for (Entry<String, SecurityScheme> entry : fromSecuritySchemes.entrySet()) {
                        if (intoSecuritySchemes.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoSecuritySchemes.get(entry.getKey()));
                        } else {
                            into.addSecurityScheme(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, SecurityScheme> entry : fromSecuritySchemes.entrySet()) {
                        into.addSecurityScheme(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, Link> fromLinks = from.getLinks();
            if (fromLinks != null) {
                Map<String, Link> intoLinks = into.getLinks();
                if (intoLinks != null) {
                    for (Entry<String, Link> entry : fromLinks.entrySet()) {
                        if (intoLinks.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoLinks.get(entry.getKey()));
                        } else {
                            into.addLink(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Link> entry : fromLinks.entrySet()) {
                        into.addLink(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, Callback> fromCallbacks = from.getCallbacks();
            if (fromCallbacks != null) {
                Map<String, Callback> intoCallbacks = into.getCallbacks();
                if (intoCallbacks != null) {
                    for (Entry<String, Callback> entry : fromCallbacks.entrySet()) {
                        if (intoCallbacks.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoCallbacks.get(entry.getKey()));
                        } else {
                            into.addCallback(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Callback> entry : fromCallbacks.entrySet()) {
                        into.addCallback(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Contact from, Contact into) {
        if (into == null) {
            throw new IllegalArgumentException("Contact 'into' parameter can not be null");
        }
        if (from != null) {
            String fromName = from.getName();
            if (fromName != null) {
                into.setName(fromName);
            }
            String fromUrl = from.getUrl();
            if (fromUrl != null) {
                into.setUrl(fromUrl);
            }
            String fromEmail = from.getEmail();
            if (fromEmail != null) {
                into.setEmail(fromEmail);
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Content from, Content into) {
        if (into == null) {
            throw new IllegalArgumentException("Content 'into' parameter can not be null");
        }
        if (from != null) {
            Map<String, MediaType> fromMediaTypes = from.getMediaTypes();
            if (fromMediaTypes != null) {
                Map<String, MediaType> intoMediaTypes = into.getMediaTypes();
                if (intoMediaTypes != null) {
                    for (Entry<String, MediaType> entry : fromMediaTypes.entrySet()) {
                        if (intoMediaTypes.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoMediaTypes.get(entry.getKey()));
                        } else {
                            into.addMediaType(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, MediaType> entry : fromMediaTypes.entrySet()) {
                        into.addMediaType(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
        }
    }

    public static void merge(Discriminator from, Discriminator into) {
        if (into == null) {
            throw new IllegalArgumentException("Discriminator 'into' parameter can not be null");
        }
        if (from != null) {
            String fromPropertyName = from.getPropertyName();
            if (fromPropertyName != null) {
                into.setPropertyName(fromPropertyName);
            }
            Map<String, String> fromMapping = from.getMapping();
            if (fromMapping != null) {
                for (Entry<String, String> entry : fromMapping.entrySet()) {
                    into.addMapping(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Encoding from, Encoding into) {
        if (into == null) {
            throw new IllegalArgumentException("Encoding 'into' parameter can not be null");
        }
        if (from != null) {
            String fromContentType = from.getContentType();
            if (fromContentType != null) {
                into.setContentType(fromContentType);
            }
            Map<String, Header> fromHeaders = from.getHeaders();
            if (fromHeaders != null) {
                Map<String, Header> intoHeaders = into.getHeaders();
                if (intoHeaders != null) {
                    for (Entry<String, Header> entry : fromHeaders.entrySet()) {
                        if (intoHeaders.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoHeaders.get(entry.getKey()));
                        } else {
                            into.addHeader(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Header> entry : fromHeaders.entrySet()) {
                        into.addHeader(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Encoding.Style fromStyle = from.getStyle();
            if (fromStyle != null) {
                into.setStyle(fromStyle);
            }
            Boolean fromExplode = from.getExplode();
            if (fromExplode != null) {
                into.setExplode(fromExplode);
            }
            Boolean fromAllowReserved = from.getAllowReserved();
            if (fromAllowReserved != null) {
                into.setAllowReserved(fromAllowReserved);
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Example from, Example into) {
        if (into == null) {
            throw new IllegalArgumentException("Example 'into' parameter can not be null");
        }
        if (from != null) {
            String fromRef = from.getRef();
            if (fromRef != null) {
                into.setRef(fromRef);
            }
            String fromSummary = from.getSummary();
            if (fromSummary != null) {
                into.setSummary(fromSummary);
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            Object fromValue = from.getValue();
            if (fromValue != null) {
                into.setValue(fromValue);
            }
            String fromExternalValue = from.getExternalValue();
            if (fromExternalValue != null) {
                into.setExternalValue(fromExternalValue);
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(ExternalDocumentation from, ExternalDocumentation into) {
        if (into == null) {
            throw new IllegalArgumentException("ExternalDocumentation 'into' parameter can not be null");
        }
        if (from != null) {
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            String fromUrl = from.getUrl();
            if (fromUrl != null) {
                into.setUrl(fromUrl);
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Header from, Header into) {
        if (into == null) {
            throw new IllegalArgumentException("Header 'into' parameter can not be null");
        }
        if (from != null) {
            String fromRef = from.getRef();
            if (fromRef != null) {
                into.setRef(fromRef);
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            Boolean fromRequired = from.getRequired();
            if (fromRequired != null) {
                into.setRequired(fromRequired);
            }
            Boolean fromDeprecated = from.getDeprecated();
            if (fromDeprecated != null) {
                into.setDeprecated(fromDeprecated);
            }
            Boolean fromAllowEmptyValue = from.getAllowEmptyValue();
            if (fromAllowEmptyValue != null) {
                into.setAllowEmptyValue(fromAllowEmptyValue);
            }
            Header.Style fromStyle = from.getStyle();
            if (fromStyle != null) {
                into.setStyle(fromStyle);
            }
            Boolean fromExplode = from.getExplode();
            if (fromExplode != null) {
                into.setExplode(fromExplode);
            }
            Schema fromSchema = from.getSchema();
            if (fromSchema != null) {
                Schema intoSchema = into.getSchema();
                if (intoSchema != null) {
                    merge(fromSchema, intoSchema);
                } else {
                    into.setSchema(OASCopy.copy(fromSchema));
                }
            }
            Map<String, Example> fromExamples = from.getExamples();
            if (fromExamples != null) {
                Map<String, Example> intoExamples = into.getExamples();
                if (intoExamples != null) {
                    for (Entry<String, Example> entry : fromExamples.entrySet()) {
                        if (intoExamples.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoExamples.get(entry.getKey()));
                        } else {
                            into.addExample(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Example> entry : fromExamples.entrySet()) {
                        into.addExample(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Object fromExample = from.getExample();
            if (fromExample != null) {
                into.setExample(fromExample);
            }
            Content fromContent = from.getContent();
            if (fromContent != null) {
                Content intoContent = into.getContent();
                if (intoContent != null) {
                    merge(fromContent, intoContent);
                } else {
                    into.setContent(OASCopy.copy(fromContent));
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Info from, Info into) {
        if (into == null) {
            throw new IllegalArgumentException("Info 'into' parameter can not be null");
        }
        if (from != null) {
            String fromTitle = from.getTitle();
            if (fromTitle != null) {
                into.setTitle(fromTitle);
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            String fromTermsOfService = from.getTermsOfService();
            if (fromTermsOfService != null) {
                into.setTermsOfService(fromTermsOfService);
            }
            Contact fromContact = from.getContact();
            if (fromContact != null) {
                Contact intoContact = into.getContact();
                if (intoContact != null) {
                    merge(fromContact, intoContact);
                } else {
                    into.setContact(OASCopy.copy(fromContact));
                }
            }
            License fromLicense = from.getLicense();
            if (fromLicense != null) {
                License intoLicense = into.getLicense();
                if (intoLicense != null) {
                    merge(fromLicense, intoLicense);
                } else {
                    into.setLicense(OASCopy.copy(fromLicense));
                }
            }
            String fromVersion = from.getVersion();
            if (fromVersion != null) {
                into.setVersion(fromVersion);
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(License from, License into) {
        if (into == null) {
            throw new IllegalArgumentException("License 'into' parameter can not be null");
        }
        if (from != null) {
            String fromName = from.getName();
            if (fromName != null) {
                into.setName(fromName);
            }
            String fromUrl = from.getUrl();
            if (fromUrl != null) {
                into.setUrl(fromUrl);
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Link from, Link into) {
        if (into == null) {
            throw new IllegalArgumentException("Link 'into' parameter can not be null");
        }
        if (from != null) {
            String fromRef = from.getRef();
            if (fromRef != null) {
                into.setRef(fromRef);
            }
            Server fromServer = from.getServer();
            if (fromServer != null) {
                Server intoServer = into.getServer();
                if (intoServer != null) {
                    merge(fromServer, intoServer);
                } else {
                    into.setServer(OASCopy.copy(fromServer));
                }
            }
            String fromOperationRef = from.getOperationRef();
            if (fromOperationRef != null) {
                into.setOperationRef(fromOperationRef);
            }
            Object fromRequestBody = from.getRequestBody();
            if (fromRequestBody != null) {
                into.setRequestBody(fromRequestBody);
            }
            String fromOperationId = from.getOperationId();
            if (fromOperationId != null) {
                into.setOperationId(fromOperationId);
            }
            Map<String, Object> fromParameters = from.getParameters();
            if (fromParameters != null) {
                for (Entry<String, Object> entry : fromParameters.entrySet()) {
                    into.addParameter(entry.getKey(), entry.getValue());
                }
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(MediaType from, MediaType into) {
        if (into == null) {
            throw new IllegalArgumentException("MediaType 'into' parameter can not be null");
        }
        if (from != null) {
            Schema fromSchema = from.getSchema();
            if (fromSchema != null) {
                Schema intoSchema = into.getSchema();
                if (intoSchema != null) {
                    merge(fromSchema, intoSchema);
                } else {
                    into.setSchema(OASCopy.copy(fromSchema));
                }
            }
            Map<String, Example> fromExamples = from.getExamples();
            if (fromExamples != null) {
                Map<String, Example> intoExamples = into.getExamples();
                if (intoExamples != null) {
                    for (Entry<String, Example> entry : fromExamples.entrySet()) {
                        if (intoExamples.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoExamples.get(entry.getKey()));
                        } else {
                            into.addExample(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Example> entry : fromExamples.entrySet()) {
                        into.addExample(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Object fromExample = from.getExample();
            if (fromExample != null) {
                into.setExample(fromExample);
            }
            Map<String, Encoding> fromEncoding = from.getEncoding();
            if (fromEncoding != null) {
                Map<String, Encoding> intoEncoding = into.getEncoding();
                if (intoEncoding != null) {
                    for (Entry<String, Encoding> entry : fromEncoding.entrySet()) {
                        if (intoEncoding.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoEncoding.get(entry.getKey()));
                        } else {
                            into.addEncoding(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Encoding> entry : fromEncoding.entrySet()) {
                        into.addEncoding(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(OAuthFlow from, OAuthFlow into) {
        if (into == null) {
            throw new IllegalArgumentException("OAuthFlow 'into' parameter can not be null");
        }
        if (from != null) {
            String fromAuthorizationUrl = from.getAuthorizationUrl();
            if (fromAuthorizationUrl != null) {
                into.setAuthorizationUrl(fromAuthorizationUrl);
            }
            String fromTokenUrl = from.getTokenUrl();
            if (fromTokenUrl != null) {
                into.setTokenUrl(fromTokenUrl);
            }
            String fromRefreshUrl = from.getRefreshUrl();
            if (fromRefreshUrl != null) {
                into.setRefreshUrl(fromRefreshUrl);
            }
            Map<String, String> fromScopes = from.getScopes();
            if (fromScopes != null) {
                for (Entry<String, String> entry : fromScopes.entrySet()) {
                    into.addScope(entry.getKey(), entry.getValue());
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(OAuthFlows from, OAuthFlows into) {
        if (into == null) {
            throw new IllegalArgumentException("OAuthFlows 'into' parameter can not be null");
        }
        if (from != null) {
            OAuthFlow fromImplicit = from.getImplicit();
            if (fromImplicit != null) {
                OAuthFlow intoImplicit = into.getImplicit();
                if (intoImplicit != null) {
                    merge(fromImplicit, intoImplicit);
                } else {
                    into.setImplicit(OASCopy.copy(fromImplicit));
                }
            }
            OAuthFlow fromPassword = from.getPassword();
            if (fromPassword != null) {
                OAuthFlow intoPassword = into.getPassword();
                if (intoPassword != null) {
                    merge(fromPassword, intoPassword);
                } else {
                    into.setPassword(OASCopy.copy(fromPassword));
                }
            }
            OAuthFlow fromClientCredentials = from.getClientCredentials();
            if (fromClientCredentials != null) {
                OAuthFlow intoClientCredentials = into.getClientCredentials();
                if (intoClientCredentials != null) {
                    merge(fromClientCredentials, intoClientCredentials);
                } else {
                    into.setClientCredentials(OASCopy.copy(fromClientCredentials));
                }
            }
            OAuthFlow fromAuthorizationCode = from.getAuthorizationCode();
            if (fromAuthorizationCode != null) {
                OAuthFlow intoAuthorizationCode = into.getAuthorizationCode();
                if (intoAuthorizationCode != null) {
                    merge(fromAuthorizationCode, intoAuthorizationCode);
                } else {
                    into.setAuthorizationCode(OASCopy.copy(fromAuthorizationCode));
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Operation from, Operation into) {
        if (into == null) {
            throw new IllegalArgumentException("Operation 'into' parameter can not be null");
        }
        if (from != null) {
            List<String> fromTags = from.getTags();
            if (fromTags != null) {
                List<String> intoTags = into.getTags();
                if (intoTags != null) {
                    for (String item : fromTags) {
                        if (!intoTags.contains(item)) {
                            into.addTag(item);
                        }
                    }
                } else {
                    for (String item : fromTags) {
                        into.addTag(item);
                    }
                }
            }
            String fromSummary = from.getSummary();
            if (fromSummary != null) {
                into.setSummary(fromSummary);
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            ExternalDocumentation fromExternalDocs = from.getExternalDocs();
            if (fromExternalDocs != null) {
                ExternalDocumentation intoExternalDocs = into.getExternalDocs();
                if (intoExternalDocs != null) {
                    merge(fromExternalDocs, intoExternalDocs);
                } else {
                    into.setExternalDocs(OASCopy.copy(fromExternalDocs));
                }
            }
            String fromOperationId = from.getOperationId();
            if (fromOperationId != null) {
                into.setOperationId(fromOperationId);
            }
            List<Parameter> fromParameters = from.getParameters();
            if (fromParameters != null) {
                List<Parameter> intoParameters = into.getParameters();
                if (intoParameters != null) {
                    for (Parameter item : fromParameters) {
                        if (!intoParameters.stream()
                            .anyMatch(i -> OASEquals.equals(i, item))) {
                            into.addParameter(OASCopy.copy(item));
                        }
                    }
                } else {
                    for (Parameter item : fromParameters) {
                        into.addParameter(OASCopy.copy(item));
                    }
                }
            }
            RequestBody fromRequestBody = from.getRequestBody();
            if (fromRequestBody != null) {
                RequestBody intoRequestBody = into.getRequestBody();
                if (intoRequestBody != null) {
                    merge(fromRequestBody, intoRequestBody);
                } else {
                    into.setRequestBody(OASCopy.copy(fromRequestBody));
                }
            }
            APIResponses fromResponses = from.getResponses();
            if (fromResponses != null) {
                APIResponses intoResponses = into.getResponses();
                if (intoResponses != null) {
                    merge(fromResponses, intoResponses);
                } else {
                    into.setResponses(OASCopy.copy(fromResponses));
                }
            }
            Map<String, Callback> fromCallbacks = from.getCallbacks();
            if (fromCallbacks != null) {
                Map<String, Callback> intoCallbacks = into.getCallbacks();
                if (intoCallbacks != null) {
                    for (Entry<String, Callback> entry : fromCallbacks.entrySet()) {
                        if (intoCallbacks.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoCallbacks.get(entry.getKey()));
                        } else {
                            into.addCallback(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Callback> entry : fromCallbacks.entrySet()) {
                        into.addCallback(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Boolean fromDeprecated = from.getDeprecated();
            if (fromDeprecated != null) {
                into.setDeprecated(fromDeprecated);
            }
            List<SecurityRequirement> fromSecurity = from.getSecurity();
            if (fromSecurity != null) {
                List<SecurityRequirement> intoSecurity = into.getSecurity();
                if (intoSecurity != null) {
                    for (SecurityRequirement item : fromSecurity) {
                        if (!intoSecurity.stream()
                            .anyMatch(i -> OASEquals.equals(i, item))) {
                            into.addSecurityRequirement(OASCopy.copy(item));
                        }
                    }
                } else {
                    for (SecurityRequirement item : fromSecurity) {
                        into.addSecurityRequirement(OASCopy.copy(item));
                    }
                }
            }
            List<Server> fromServers = from.getServers();
            if (fromServers != null) {
                List<Server> intoServers = into.getServers();
                if (intoServers != null) {
                    for (Server item : fromServers) {
                        if (!intoServers.stream()
                            .anyMatch(i -> OASEquals.equals(i, item))) {
                            into.addServer(OASCopy.copy(item));
                        }
                    }
                } else {
                    for (Server item : fromServers) {
                        into.addServer(OASCopy.copy(item));
                    }
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Parameter from, Parameter into) {
        if (into == null) {
            throw new IllegalArgumentException("Parameter 'into' parameter can not be null");
        }
        if (from != null) {
            String fromRef = from.getRef();
            if (fromRef != null) {
                into.setRef(fromRef);
            }
            String fromName = from.getName();
            if (fromName != null) {
                into.setName(fromName);
            }
            Parameter.In fromIn = from.getIn();
            if (fromIn != null) {
                into.setIn(fromIn);
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            Boolean fromRequired = from.getRequired();
            if (fromRequired != null) {
                into.setRequired(fromRequired);
            }
            Boolean fromDeprecated = from.getDeprecated();
            if (fromDeprecated != null) {
                into.setDeprecated(fromDeprecated);
            }
            Boolean fromAllowEmptyValue = from.getAllowEmptyValue();
            if (fromAllowEmptyValue != null) {
                into.setAllowEmptyValue(fromAllowEmptyValue);
            }
            Parameter.Style fromStyle = from.getStyle();
            if (fromStyle != null) {
                into.setStyle(fromStyle);
            }
            Boolean fromExplode = from.getExplode();
            if (fromExplode != null) {
                into.setExplode(fromExplode);
            }
            Boolean fromAllowReserved = from.getAllowReserved();
            if (fromAllowReserved != null) {
                into.setAllowReserved(fromAllowReserved);
            }
            Schema fromSchema = from.getSchema();
            if (fromSchema != null) {
                Schema intoSchema = into.getSchema();
                if (intoSchema != null) {
                    merge(fromSchema, intoSchema);
                } else {
                    into.setSchema(OASCopy.copy(fromSchema));
                }
            }
            Map<String, Example> fromExamples = from.getExamples();
            if (fromExamples != null) {
                Map<String, Example> intoExamples = into.getExamples();
                if (intoExamples != null) {
                    for (Entry<String, Example> entry : fromExamples.entrySet()) {
                        if (intoExamples.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoExamples.get(entry.getKey()));
                        } else {
                            into.addExample(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Example> entry : fromExamples.entrySet()) {
                        into.addExample(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Object fromExample = from.getExample();
            if (fromExample != null) {
                into.setExample(fromExample);
            }
            Content fromContent = from.getContent();
            if (fromContent != null) {
                Content intoContent = into.getContent();
                if (intoContent != null) {
                    merge(fromContent, intoContent);
                } else {
                    into.setContent(OASCopy.copy(fromContent));
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(PathItem from, PathItem into) {
        if (into == null) {
            throw new IllegalArgumentException("PathItem 'into' parameter can not be null");
        }
        if (from != null) {
            String fromRef = from.getRef();
            if (fromRef != null) {
                into.setRef(fromRef);
            }
            String fromSummary = from.getSummary();
            if (fromSummary != null) {
                into.setSummary(fromSummary);
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            Operation fromGET = from.getGET();
            if (fromGET != null) {
                Operation intoGET = into.getGET();
                if (intoGET != null) {
                    merge(fromGET, intoGET);
                } else {
                    into.setGET(OASCopy.copy(fromGET));
                }
            }
            Operation fromPUT = from.getPUT();
            if (fromPUT != null) {
                Operation intoPUT = into.getPUT();
                if (intoPUT != null) {
                    merge(fromPUT, intoPUT);
                } else {
                    into.setPUT(OASCopy.copy(fromPUT));
                }
            }
            Operation fromPOST = from.getPOST();
            if (fromPOST != null) {
                Operation intoPOST = into.getPOST();
                if (intoPOST != null) {
                    merge(fromPOST, intoPOST);
                } else {
                    into.setPOST(OASCopy.copy(fromPOST));
                }
            }
            Operation fromDELETE = from.getDELETE();
            if (fromDELETE != null) {
                Operation intoDELETE = into.getDELETE();
                if (intoDELETE != null) {
                    merge(fromDELETE, intoDELETE);
                } else {
                    into.setDELETE(OASCopy.copy(fromDELETE));
                }
            }
            Operation fromOPTIONS = from.getOPTIONS();
            if (fromOPTIONS != null) {
                Operation intoOPTIONS = into.getOPTIONS();
                if (intoOPTIONS != null) {
                    merge(fromOPTIONS, intoOPTIONS);
                } else {
                    into.setOPTIONS(OASCopy.copy(fromOPTIONS));
                }
            }
            Operation fromHEAD = from.getHEAD();
            if (fromHEAD != null) {
                Operation intoHEAD = into.getHEAD();
                if (intoHEAD != null) {
                    merge(fromHEAD, intoHEAD);
                } else {
                    into.setHEAD(OASCopy.copy(fromHEAD));
                }
            }
            Operation fromPATCH = from.getPATCH();
            if (fromPATCH != null) {
                Operation intoPATCH = into.getPATCH();
                if (intoPATCH != null) {
                    merge(fromPATCH, intoPATCH);
                } else {
                    into.setPATCH(OASCopy.copy(fromPATCH));
                }
            }
            Operation fromTRACE = from.getTRACE();
            if (fromTRACE != null) {
                Operation intoTRACE = into.getTRACE();
                if (intoTRACE != null) {
                    merge(fromTRACE, intoTRACE);
                } else {
                    into.setTRACE(OASCopy.copy(fromTRACE));
                }
            }
            List<Server> fromServers = from.getServers();
            if (fromServers != null) {
                List<Server> intoServers = into.getServers();
                if (intoServers != null) {
                    for (Server item : fromServers) {
                        if (!intoServers.stream()
                            .anyMatch(i -> OASEquals.equals(i, item))) {
                            into.addServer(OASCopy.copy(item));
                        }
                    }
                } else {
                    for (Server item : fromServers) {
                        into.addServer(OASCopy.copy(item));
                    }
                }
            }
            List<Parameter> fromParameters = from.getParameters();
            if (fromParameters != null) {
                List<Parameter> intoParameters = into.getParameters();
                if (intoParameters != null) {
                    for (Parameter item : fromParameters) {
                        if (!intoParameters.stream()
                            .anyMatch(i -> OASEquals.equals(i, item))) {
                            into.addParameter(OASCopy.copy(item));
                        }
                    }
                } else {
                    for (Parameter item : fromParameters) {
                        into.addParameter(OASCopy.copy(item));
                    }
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Paths from, Paths into) {
        if (into == null) {
            throw new IllegalArgumentException("Paths 'into' parameter can not be null");
        }
        if (from != null) {
            Map<String, PathItem> fromPathItems = from.getPathItems();
            if (fromPathItems != null) {
                Map<String, PathItem> intoPathItems = into.getPathItems();
                if (intoPathItems != null) {
                    for (Entry<String, PathItem> entry : fromPathItems.entrySet()) {
                        if (intoPathItems.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoPathItems.get(entry.getKey()));
                        } else {
                            into.addPathItem(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, PathItem> entry : fromPathItems.entrySet()) {
                        into.addPathItem(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(RequestBody from, RequestBody into) {
        if (into == null) {
            throw new IllegalArgumentException("RequestBody 'into' parameter can not be null");
        }
        if (from != null) {
            String fromRef = from.getRef();
            if (fromRef != null) {
                into.setRef(fromRef);
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            Content fromContent = from.getContent();
            if (fromContent != null) {
                Content intoContent = into.getContent();
                if (intoContent != null) {
                    merge(fromContent, intoContent);
                } else {
                    into.setContent(OASCopy.copy(fromContent));
                }
            }
            Boolean fromRequired = from.getRequired();
            if (fromRequired != null) {
                into.setRequired(fromRequired);
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Schema from, Schema into) {
        if (into == null) {
            throw new IllegalArgumentException("Schema 'into' parameter can not be null");
        }
        if (from != null) {
            String fromRef = from.getRef();
            if (fromRef != null) {
                into.setRef(fromRef);
            }
            Discriminator fromDiscriminator = from.getDiscriminator();
            if (fromDiscriminator != null) {
                Discriminator intoDiscriminator = into.getDiscriminator();
                if (intoDiscriminator != null) {
                    merge(fromDiscriminator, intoDiscriminator);
                } else {
                    into.setDiscriminator(OASCopy.copy(fromDiscriminator));
                }
            }
            String fromTitle = from.getTitle();
            if (fromTitle != null) {
                into.setTitle(fromTitle);
            }
            Object fromDefaultValue = from.getDefaultValue();
            if (fromDefaultValue != null) {
                into.setDefaultValue(fromDefaultValue);
            }
            List<Object> fromEnumeration = from.getEnumeration();
            if (fromEnumeration != null) {
                List<Object> intoEnumeration = into.getEnumeration();
                if (intoEnumeration != null) {
                    for (Object item : fromEnumeration) {
                        if (!intoEnumeration.contains(item)) {
                            into.addEnumeration(item);
                        }
                    }
                } else {
                    for (Object item : fromEnumeration) {
                        into.addEnumeration(item);
                    }
                }
            }
            BigDecimal fromMultipleOf = from.getMultipleOf();
            if (fromMultipleOf != null) {
                into.setMultipleOf(fromMultipleOf);
            }
            BigDecimal fromMaximum = from.getMaximum();
            if (fromMaximum != null) {
                into.setMaximum(fromMaximum);
            }
            Boolean fromExclusiveMaximum = from.getExclusiveMaximum();
            if (fromExclusiveMaximum != null) {
                into.setExclusiveMaximum(fromExclusiveMaximum);
            }
            BigDecimal fromMinimum = from.getMinimum();
            if (fromMinimum != null) {
                into.setMinimum(fromMinimum);
            }
            Boolean fromExclusiveMinimum = from.getExclusiveMinimum();
            if (fromExclusiveMinimum != null) {
                into.setExclusiveMinimum(fromExclusiveMinimum);
            }
            Integer fromMaxLength = from.getMaxLength();
            if (fromMaxLength != null) {
                into.setMaxLength(fromMaxLength);
            }
            Integer fromMinLength = from.getMinLength();
            if (fromMinLength != null) {
                into.setMinLength(fromMinLength);
            }
            String fromPattern = from.getPattern();
            if (fromPattern != null) {
                into.setPattern(fromPattern);
            }
            Integer fromMaxItems = from.getMaxItems();
            if (fromMaxItems != null) {
                into.setMaxItems(fromMaxItems);
            }
            Integer fromMinItems = from.getMinItems();
            if (fromMinItems != null) {
                into.setMinItems(fromMinItems);
            }
            Boolean fromUniqueItems = from.getUniqueItems();
            if (fromUniqueItems != null) {
                into.setUniqueItems(fromUniqueItems);
            }
            Integer fromMaxProperties = from.getMaxProperties();
            if (fromMaxProperties != null) {
                into.setMaxProperties(fromMaxProperties);
            }
            Integer fromMinProperties = from.getMinProperties();
            if (fromMinProperties != null) {
                into.setMinProperties(fromMinProperties);
            }
            List<String> fromRequired = from.getRequired();
            if (fromRequired != null) {
                List<String> intoRequired = into.getRequired();
                if (intoRequired != null) {
                    for (String item : fromRequired) {
                        if (!intoRequired.contains(item)) {
                            into.addRequired(item);
                        }
                    }
                } else {
                    for (String item : fromRequired) {
                        into.addRequired(item);
                    }
                }
            }
            Schema.SchemaType fromType = from.getType();
            if (fromType != null) {
                into.setType(fromType);
            }
            Schema fromNot = from.getNot();
            if (fromNot != null) {
                Schema intoNot = into.getNot();
                if (intoNot != null) {
                    merge(fromNot, intoNot);
                } else {
                    into.setNot(OASCopy.copy(fromNot));
                }
            }
            Map<String, Schema> fromProperties = from.getProperties();
            if (fromProperties != null) {
                Map<String, Schema> intoProperties = into.getProperties();
                if (intoProperties != null) {
                    for (Entry<String, Schema> entry : fromProperties.entrySet()) {
                        if (intoProperties.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoProperties.get(entry.getKey()));
                        } else {
                            into.addProperty(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, Schema> entry : fromProperties.entrySet()) {
                        into.addProperty(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Schema fromAdditionalPropertiesSchema = from.getAdditionalPropertiesSchema();
            if (fromAdditionalPropertiesSchema != null) {
                Schema intoAdditionalPropertiesSchema = into.getAdditionalPropertiesSchema();
                if (intoAdditionalPropertiesSchema != null) {
                    merge(fromAdditionalPropertiesSchema, intoAdditionalPropertiesSchema);
                } else {
                    into.setAdditionalPropertiesSchema(OASCopy.copy(fromAdditionalPropertiesSchema));
                }
            }
            Boolean fromAdditionalPropertiesBoolean = from.getAdditionalPropertiesBoolean();
            if (fromAdditionalPropertiesBoolean != null) {
                into.setAdditionalPropertiesBoolean(fromAdditionalPropertiesBoolean);
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            String fromFormat = from.getFormat();
            if (fromFormat != null) {
                into.setFormat(fromFormat);
            }
            Boolean fromNullable = from.getNullable();
            if (fromNullable != null) {
                into.setNullable(fromNullable);
            }
            Boolean fromReadOnly = from.getReadOnly();
            if (fromReadOnly != null) {
                into.setReadOnly(fromReadOnly);
            }
            Boolean fromWriteOnly = from.getWriteOnly();
            if (fromWriteOnly != null) {
                into.setWriteOnly(fromWriteOnly);
            }
            Object fromExample = from.getExample();
            if (fromExample != null) {
                into.setExample(fromExample);
            }
            ExternalDocumentation fromExternalDocs = from.getExternalDocs();
            if (fromExternalDocs != null) {
                ExternalDocumentation intoExternalDocs = into.getExternalDocs();
                if (intoExternalDocs != null) {
                    merge(fromExternalDocs, intoExternalDocs);
                } else {
                    into.setExternalDocs(OASCopy.copy(fromExternalDocs));
                }
            }
            Boolean fromDeprecated = from.getDeprecated();
            if (fromDeprecated != null) {
                into.setDeprecated(fromDeprecated);
            }
            XML fromXml = from.getXml();
            if (fromXml != null) {
                XML intoXml = into.getXml();
                if (intoXml != null) {
                    merge(fromXml, intoXml);
                } else {
                    into.setXml(OASCopy.copy(fromXml));
                }
            }
            Schema fromItems = from.getItems();
            if (fromItems != null) {
                Schema intoItems = into.getItems();
                if (intoItems != null) {
                    merge(fromItems, intoItems);
                } else {
                    into.setItems(OASCopy.copy(fromItems));
                }
            }
            List<Schema> fromAllOf = from.getAllOf();
            if (fromAllOf != null) {
                List<Schema> intoAllOf = into.getAllOf();
                if (intoAllOf != null) {
                    for (Schema item : fromAllOf) {
                        if (!intoAllOf.stream()
                            .anyMatch(i -> OASEquals.equals(i, item))) {
                            into.addAllOf(OASCopy.copy(item));
                        }
                    }
                } else {
                    for (Schema item : fromAllOf) {
                        into.addAllOf(OASCopy.copy(item));
                    }
                }
            }
            List<Schema> fromAnyOf = from.getAnyOf();
            if (fromAnyOf != null) {
                List<Schema> intoAnyOf = into.getAnyOf();
                if (intoAnyOf != null) {
                    for (Schema item : fromAnyOf) {
                        if (!intoAnyOf.stream()
                            .anyMatch(i -> OASEquals.equals(i, item))) {
                            into.addAnyOf(OASCopy.copy(item));
                        }
                    }
                } else {
                    for (Schema item : fromAnyOf) {
                        into.addAnyOf(OASCopy.copy(item));
                    }
                }
            }
            List<Schema> fromOneOf = from.getOneOf();
            if (fromOneOf != null) {
                List<Schema> intoOneOf = into.getOneOf();
                if (intoOneOf != null) {
                    for (Schema item : fromOneOf) {
                        if (!intoOneOf.stream()
                            .anyMatch(i -> OASEquals.equals(i, item))) {
                            into.addOneOf(OASCopy.copy(item));
                        }
                    }
                } else {
                    for (Schema item : fromOneOf) {
                        into.addOneOf(OASCopy.copy(item));
                    }
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(SecurityRequirement from, SecurityRequirement into) {
        if (into == null) {
            throw new IllegalArgumentException("SecurityRequirement 'into' parameter can not be null");
        }
        if (from != null) {
            Map<String, List<String>> fromSchemes = from.getSchemes();
            if (fromSchemes != null) {
                for (Entry<String, List<String>> entry : fromSchemes.entrySet()) {
                    into.addScheme(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(SecurityScheme from, SecurityScheme into) {
        if (into == null) {
            throw new IllegalArgumentException("SecurityScheme 'into' parameter can not be null");
        }
        if (from != null) {
            String fromRef = from.getRef();
            if (fromRef != null) {
                into.setRef(fromRef);
            }
            SecurityScheme.Type fromType = from.getType();
            if (fromType != null) {
                into.setType(fromType);
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            String fromName = from.getName();
            if (fromName != null) {
                into.setName(fromName);
            }
            SecurityScheme.In fromIn = from.getIn();
            if (fromIn != null) {
                into.setIn(fromIn);
            }
            String fromScheme = from.getScheme();
            if (fromScheme != null) {
                into.setScheme(fromScheme);
            }
            String fromBearerFormat = from.getBearerFormat();
            if (fromBearerFormat != null) {
                into.setBearerFormat(fromBearerFormat);
            }
            OAuthFlows fromFlows = from.getFlows();
            if (fromFlows != null) {
                OAuthFlows intoFlows = into.getFlows();
                if (intoFlows != null) {
                    merge(fromFlows, intoFlows);
                } else {
                    into.setFlows(OASCopy.copy(fromFlows));
                }
            }
            String fromOpenIdConnectUrl = from.getOpenIdConnectUrl();
            if (fromOpenIdConnectUrl != null) {
                into.setOpenIdConnectUrl(fromOpenIdConnectUrl);
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Server from, Server into) {
        if (into == null) {
            throw new IllegalArgumentException("Server 'into' parameter can not be null");
        }
        if (from != null) {
            String fromUrl = from.getUrl();
            if (fromUrl != null) {
                into.setUrl(fromUrl);
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            Map<String, ServerVariable> fromVariables = from.getVariables();
            if (fromVariables != null) {
                Map<String, ServerVariable> intoVariables = into.getVariables();
                if (intoVariables != null) {
                    for (Entry<String, ServerVariable> entry : fromVariables.entrySet()) {
                        if (intoVariables.containsKey(entry.getKey())) {
                            merge(entry.getValue(), intoVariables.get(entry.getKey()));
                        } else {
                            into.addVariable(entry.getKey(), OASCopy.copy(entry.getValue()));
                        }
                    }
                } else {
                    for (Entry<String, ServerVariable> entry : fromVariables.entrySet()) {
                        into.addVariable(entry.getKey(), OASCopy.copy(entry.getValue()));
                    }
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(ServerVariable from, ServerVariable into) {
        if (into == null) {
            throw new IllegalArgumentException("ServerVariable 'into' parameter can not be null");
        }
        if (from != null) {
            List<String> fromEnumeration = from.getEnumeration();
            if (fromEnumeration != null) {
                List<String> intoEnumeration = into.getEnumeration();
                if (intoEnumeration != null) {
                    for (String item : fromEnumeration) {
                        if (!intoEnumeration.contains(item)) {
                            into.addEnumeration(item);
                        }
                    }
                } else {
                    for (String item : fromEnumeration) {
                        into.addEnumeration(item);
                    }
                }
            }
            String fromDefaultValue = from.getDefaultValue();
            if (fromDefaultValue != null) {
                into.setDefaultValue(fromDefaultValue);
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(Tag from, Tag into) {
        if (into == null) {
            throw new IllegalArgumentException("Tag 'into' parameter can not be null");
        }
        if (from != null) {
            String fromName = from.getName();
            if (fromName != null) {
                into.setName(fromName);
            }
            String fromDescription = from.getDescription();
            if (fromDescription != null) {
                into.setDescription(fromDescription);
            }
            ExternalDocumentation fromExternalDocs = from.getExternalDocs();
            if (fromExternalDocs != null) {
                ExternalDocumentation intoExternalDocs = into.getExternalDocs();
                if (intoExternalDocs != null) {
                    merge(fromExternalDocs, intoExternalDocs);
                } else {
                    into.setExternalDocs(OASCopy.copy(fromExternalDocs));
                }
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static void merge(XML from, XML into) {
        if (into == null) {
            throw new IllegalArgumentException("XML 'into' parameter can not be null");
        }
        if (from != null) {
            String fromName = from.getName();
            if (fromName != null) {
                into.setName(fromName);
            }
            String fromNamespace = from.getNamespace();
            if (fromNamespace != null) {
                into.setNamespace(fromNamespace);
            }
            String fromPrefix = from.getPrefix();
            if (fromPrefix != null) {
                into.setPrefix(fromPrefix);
            }
            Boolean fromAttribute = from.getAttribute();
            if (fromAttribute != null) {
                into.setAttribute(fromAttribute);
            }
            Boolean fromWrapped = from.getWrapped();
            if (fromWrapped != null) {
                into.setWrapped(fromWrapped);
            }
            Map<String, Object> extensions = from.getExtensions();
            if (extensions != null) {
                for (Entry<String, Object> entry : extensions.entrySet()) {
                    into.addExtension(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    private OASMerge() {
    }
}
