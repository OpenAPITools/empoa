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
package org.openapitools.empoa.util.equals;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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

public class OASEquals {

    public static boolean equals(OpenAPI a, OpenAPI b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getOpenapi(), b.getOpenapi())) {
            return false;
        }
        if (!equals(a.getInfo(), b.getInfo())) {
            return false;
        }
        if (!equals(a.getExternalDocs(), b.getExternalDocs())) {
            return false;
        }
        List<Server> aServers = a.getServers();
        List<Server> bServers = b.getServers();
        if (aServers == null && bServers != null) {
            return false;
        } else if (aServers != null && bServers == null) {
            return false;
        } else if (aServers != null && bServers != null) {
            if (aServers.size() != bServers.size()) {
                return false;
            }
            for (int i = 0; i < aServers.size(); i++) {
                if (!equals(aServers.get(i), bServers.get(i))) {
                    return false;
                }
            }
        }
        List<SecurityRequirement> aSecurity = a.getSecurity();
        List<SecurityRequirement> bSecurity = b.getSecurity();
        if (aSecurity == null && bSecurity != null) {
            return false;
        } else if (aSecurity != null && bSecurity == null) {
            return false;
        } else if (aSecurity != null && bSecurity != null) {
            if (aSecurity.size() != bSecurity.size()) {
                return false;
            }
            for (int i = 0; i < aSecurity.size(); i++) {
                if (!equals(aSecurity.get(i), bSecurity.get(i))) {
                    return false;
                }
            }
        }
        List<Tag> aTags = a.getTags();
        List<Tag> bTags = b.getTags();
        if (aTags == null && bTags != null) {
            return false;
        } else if (aTags != null && bTags == null) {
            return false;
        } else if (aTags != null && bTags != null) {
            if (aTags.size() != bTags.size()) {
                return false;
            }
            for (int i = 0; i < aTags.size(); i++) {
                if (!equals(aTags.get(i), bTags.get(i))) {
                    return false;
                }
            }
        }
        if (!equals(a.getPaths(), b.getPaths())) {
            return false;
        }
        if (!equals(a.getComponents(), b.getComponents())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(APIResponse a, APIResponse b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getRef(), b.getRef())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        Map<String, Header> aHeaders = a.getHeaders();
        Map<String, Header> bHeaders = b.getHeaders();
        if (aHeaders == null && bHeaders != null) {
            return false;
        } else if (aHeaders != null && bHeaders == null) {
            return false;
        } else if (aHeaders != null && bHeaders != null) {
            if (aHeaders.size() != bHeaders.size()) {
                return false;
            }
            if (!Objects.equals(aHeaders.keySet(), bHeaders.keySet())) {
                return false;
            }
            for (String key : aHeaders.keySet()) {
                if (!equals(aHeaders.get(key), bHeaders.get(key))) {
                    return false;
                }
            }
        }
        if (!equals(a.getContent(), b.getContent())) {
            return false;
        }
        Map<String, Link> aLinks = a.getLinks();
        Map<String, Link> bLinks = b.getLinks();
        if (aLinks == null && bLinks != null) {
            return false;
        } else if (aLinks != null && bLinks == null) {
            return false;
        } else if (aLinks != null && bLinks != null) {
            if (aLinks.size() != bLinks.size()) {
                return false;
            }
            if (!Objects.equals(aLinks.keySet(), bLinks.keySet())) {
                return false;
            }
            for (String key : aLinks.keySet()) {
                if (!equals(aLinks.get(key), bLinks.get(key))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(APIResponses a, APIResponses b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        Map<String, APIResponse> aAPIResponses = a.getAPIResponses();
        Map<String, APIResponse> bAPIResponses = b.getAPIResponses();
        if (aAPIResponses == null && bAPIResponses != null) {
            return false;
        } else if (aAPIResponses != null && bAPIResponses == null) {
            return false;
        } else if (aAPIResponses != null && bAPIResponses != null) {
            if (aAPIResponses.size() != bAPIResponses.size()) {
                return false;
            }
            if (!Objects.equals(aAPIResponses.keySet(), bAPIResponses.keySet())) {
                return false;
            }
            for (String key : aAPIResponses.keySet()) {
                if (!equals(aAPIResponses.get(key), bAPIResponses.get(key))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Callback a, Callback b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getRef(), b.getRef())) {
            return false;
        }
        Map<String, PathItem> aPathItems = a.getPathItems();
        Map<String, PathItem> bPathItems = b.getPathItems();
        if (aPathItems == null && bPathItems != null) {
            return false;
        } else if (aPathItems != null && bPathItems == null) {
            return false;
        } else if (aPathItems != null && bPathItems != null) {
            if (aPathItems.size() != bPathItems.size()) {
                return false;
            }
            if (!Objects.equals(aPathItems.keySet(), bPathItems.keySet())) {
                return false;
            }
            for (String key : aPathItems.keySet()) {
                if (!equals(aPathItems.get(key), bPathItems.get(key))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Components a, Components b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        Map<String, Schema> aSchemas = a.getSchemas();
        Map<String, Schema> bSchemas = b.getSchemas();
        if (aSchemas == null && bSchemas != null) {
            return false;
        } else if (aSchemas != null && bSchemas == null) {
            return false;
        } else if (aSchemas != null && bSchemas != null) {
            if (aSchemas.size() != bSchemas.size()) {
                return false;
            }
            if (!Objects.equals(aSchemas.keySet(), bSchemas.keySet())) {
                return false;
            }
            for (String key : aSchemas.keySet()) {
                if (!equals(aSchemas.get(key), bSchemas.get(key))) {
                    return false;
                }
            }
        }
        Map<String, APIResponse> aResponses = a.getResponses();
        Map<String, APIResponse> bResponses = b.getResponses();
        if (aResponses == null && bResponses != null) {
            return false;
        } else if (aResponses != null && bResponses == null) {
            return false;
        } else if (aResponses != null && bResponses != null) {
            if (aResponses.size() != bResponses.size()) {
                return false;
            }
            if (!Objects.equals(aResponses.keySet(), bResponses.keySet())) {
                return false;
            }
            for (String key : aResponses.keySet()) {
                if (!equals(aResponses.get(key), bResponses.get(key))) {
                    return false;
                }
            }
        }
        Map<String, Parameter> aParameters = a.getParameters();
        Map<String, Parameter> bParameters = b.getParameters();
        if (aParameters == null && bParameters != null) {
            return false;
        } else if (aParameters != null && bParameters == null) {
            return false;
        } else if (aParameters != null && bParameters != null) {
            if (aParameters.size() != bParameters.size()) {
                return false;
            }
            if (!Objects.equals(aParameters.keySet(), bParameters.keySet())) {
                return false;
            }
            for (String key : aParameters.keySet()) {
                if (!equals(aParameters.get(key), bParameters.get(key))) {
                    return false;
                }
            }
        }
        Map<String, Example> aExamples = a.getExamples();
        Map<String, Example> bExamples = b.getExamples();
        if (aExamples == null && bExamples != null) {
            return false;
        } else if (aExamples != null && bExamples == null) {
            return false;
        } else if (aExamples != null && bExamples != null) {
            if (aExamples.size() != bExamples.size()) {
                return false;
            }
            if (!Objects.equals(aExamples.keySet(), bExamples.keySet())) {
                return false;
            }
            for (String key : aExamples.keySet()) {
                if (!equals(aExamples.get(key), bExamples.get(key))) {
                    return false;
                }
            }
        }
        Map<String, RequestBody> aRequestBodies = a.getRequestBodies();
        Map<String, RequestBody> bRequestBodies = b.getRequestBodies();
        if (aRequestBodies == null && bRequestBodies != null) {
            return false;
        } else if (aRequestBodies != null && bRequestBodies == null) {
            return false;
        } else if (aRequestBodies != null && bRequestBodies != null) {
            if (aRequestBodies.size() != bRequestBodies.size()) {
                return false;
            }
            if (!Objects.equals(aRequestBodies.keySet(), bRequestBodies.keySet())) {
                return false;
            }
            for (String key : aRequestBodies.keySet()) {
                if (!equals(aRequestBodies.get(key), bRequestBodies.get(key))) {
                    return false;
                }
            }
        }
        Map<String, Header> aHeaders = a.getHeaders();
        Map<String, Header> bHeaders = b.getHeaders();
        if (aHeaders == null && bHeaders != null) {
            return false;
        } else if (aHeaders != null && bHeaders == null) {
            return false;
        } else if (aHeaders != null && bHeaders != null) {
            if (aHeaders.size() != bHeaders.size()) {
                return false;
            }
            if (!Objects.equals(aHeaders.keySet(), bHeaders.keySet())) {
                return false;
            }
            for (String key : aHeaders.keySet()) {
                if (!equals(aHeaders.get(key), bHeaders.get(key))) {
                    return false;
                }
            }
        }
        Map<String, SecurityScheme> aSecuritySchemes = a.getSecuritySchemes();
        Map<String, SecurityScheme> bSecuritySchemes = b.getSecuritySchemes();
        if (aSecuritySchemes == null && bSecuritySchemes != null) {
            return false;
        } else if (aSecuritySchemes != null && bSecuritySchemes == null) {
            return false;
        } else if (aSecuritySchemes != null && bSecuritySchemes != null) {
            if (aSecuritySchemes.size() != bSecuritySchemes.size()) {
                return false;
            }
            if (!Objects.equals(aSecuritySchemes.keySet(), bSecuritySchemes.keySet())) {
                return false;
            }
            for (String key : aSecuritySchemes.keySet()) {
                if (!equals(aSecuritySchemes.get(key), bSecuritySchemes.get(key))) {
                    return false;
                }
            }
        }
        Map<String, Link> aLinks = a.getLinks();
        Map<String, Link> bLinks = b.getLinks();
        if (aLinks == null && bLinks != null) {
            return false;
        } else if (aLinks != null && bLinks == null) {
            return false;
        } else if (aLinks != null && bLinks != null) {
            if (aLinks.size() != bLinks.size()) {
                return false;
            }
            if (!Objects.equals(aLinks.keySet(), bLinks.keySet())) {
                return false;
            }
            for (String key : aLinks.keySet()) {
                if (!equals(aLinks.get(key), bLinks.get(key))) {
                    return false;
                }
            }
        }
        Map<String, Callback> aCallbacks = a.getCallbacks();
        Map<String, Callback> bCallbacks = b.getCallbacks();
        if (aCallbacks == null && bCallbacks != null) {
            return false;
        } else if (aCallbacks != null && bCallbacks == null) {
            return false;
        } else if (aCallbacks != null && bCallbacks != null) {
            if (aCallbacks.size() != bCallbacks.size()) {
                return false;
            }
            if (!Objects.equals(aCallbacks.keySet(), bCallbacks.keySet())) {
                return false;
            }
            for (String key : aCallbacks.keySet()) {
                if (!equals(aCallbacks.get(key), bCallbacks.get(key))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Contact a, Contact b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getName(), b.getName())) {
            return false;
        }
        if (!Objects.equals(a.getUrl(), b.getUrl())) {
            return false;
        }
        if (!Objects.equals(a.getEmail(), b.getEmail())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Content a, Content b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        Map<String, MediaType> aMediaTypes = a.getMediaTypes();
        Map<String, MediaType> bMediaTypes = b.getMediaTypes();
        if (aMediaTypes == null && bMediaTypes != null) {
            return false;
        } else if (aMediaTypes != null && bMediaTypes == null) {
            return false;
        } else if (aMediaTypes != null && bMediaTypes != null) {
            if (aMediaTypes.size() != bMediaTypes.size()) {
                return false;
            }
            if (!Objects.equals(aMediaTypes.keySet(), bMediaTypes.keySet())) {
                return false;
            }
            for (String key : aMediaTypes.keySet()) {
                if (!equals(aMediaTypes.get(key), bMediaTypes.get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean equals(Discriminator a, Discriminator b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getPropertyName(), b.getPropertyName())) {
            return false;
        }
        if (!Objects.equals(a.getMapping(), b.getMapping())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Encoding a, Encoding b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getContentType(), b.getContentType())) {
            return false;
        }
        Map<String, Header> aHeaders = a.getHeaders();
        Map<String, Header> bHeaders = b.getHeaders();
        if (aHeaders == null && bHeaders != null) {
            return false;
        } else if (aHeaders != null && bHeaders == null) {
            return false;
        } else if (aHeaders != null && bHeaders != null) {
            if (aHeaders.size() != bHeaders.size()) {
                return false;
            }
            if (!Objects.equals(aHeaders.keySet(), bHeaders.keySet())) {
                return false;
            }
            for (String key : aHeaders.keySet()) {
                if (!equals(aHeaders.get(key), bHeaders.get(key))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getStyle(), b.getStyle())) {
            return false;
        }
        if (!Objects.equals(a.getExplode(), b.getExplode())) {
            return false;
        }
        if (!Objects.equals(a.getAllowReserved(), b.getAllowReserved())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Example a, Example b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getRef(), b.getRef())) {
            return false;
        }
        if (!Objects.equals(a.getSummary(), b.getSummary())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!Objects.equals(a.getValue(), b.getValue())) {
            return false;
        }
        if (!Objects.equals(a.getExternalValue(), b.getExternalValue())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(ExternalDocumentation a, ExternalDocumentation b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!Objects.equals(a.getUrl(), b.getUrl())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Header a, Header b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getRef(), b.getRef())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!Objects.equals(a.getRequired(), b.getRequired())) {
            return false;
        }
        if (!Objects.equals(a.getDeprecated(), b.getDeprecated())) {
            return false;
        }
        if (!Objects.equals(a.getAllowEmptyValue(), b.getAllowEmptyValue())) {
            return false;
        }
        if (!Objects.equals(a.getStyle(), b.getStyle())) {
            return false;
        }
        if (!Objects.equals(a.getExplode(), b.getExplode())) {
            return false;
        }
        if (!equals(a.getSchema(), b.getSchema())) {
            return false;
        }
        Map<String, Example> aExamples = a.getExamples();
        Map<String, Example> bExamples = b.getExamples();
        if (aExamples == null && bExamples != null) {
            return false;
        } else if (aExamples != null && bExamples == null) {
            return false;
        } else if (aExamples != null && bExamples != null) {
            if (aExamples.size() != bExamples.size()) {
                return false;
            }
            if (!Objects.equals(aExamples.keySet(), bExamples.keySet())) {
                return false;
            }
            for (String key : aExamples.keySet()) {
                if (!equals(aExamples.get(key), bExamples.get(key))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getExample(), b.getExample())) {
            return false;
        }
        if (!equals(a.getContent(), b.getContent())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Info a, Info b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getTitle(), b.getTitle())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!Objects.equals(a.getTermsOfService(), b.getTermsOfService())) {
            return false;
        }
        if (!equals(a.getContact(), b.getContact())) {
            return false;
        }
        if (!equals(a.getLicense(), b.getLicense())) {
            return false;
        }
        if (!Objects.equals(a.getVersion(), b.getVersion())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(License a, License b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getName(), b.getName())) {
            return false;
        }
        if (!Objects.equals(a.getUrl(), b.getUrl())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Link a, Link b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getRef(), b.getRef())) {
            return false;
        }
        if (!equals(a.getServer(), b.getServer())) {
            return false;
        }
        if (!Objects.equals(a.getOperationRef(), b.getOperationRef())) {
            return false;
        }
        if (!Objects.equals(a.getRequestBody(), b.getRequestBody())) {
            return false;
        }
        if (!Objects.equals(a.getOperationId(), b.getOperationId())) {
            return false;
        }
        if (!Objects.equals(a.getParameters(), b.getParameters())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(MediaType a, MediaType b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!equals(a.getSchema(), b.getSchema())) {
            return false;
        }
        Map<String, Example> aExamples = a.getExamples();
        Map<String, Example> bExamples = b.getExamples();
        if (aExamples == null && bExamples != null) {
            return false;
        } else if (aExamples != null && bExamples == null) {
            return false;
        } else if (aExamples != null && bExamples != null) {
            if (aExamples.size() != bExamples.size()) {
                return false;
            }
            if (!Objects.equals(aExamples.keySet(), bExamples.keySet())) {
                return false;
            }
            for (String key : aExamples.keySet()) {
                if (!equals(aExamples.get(key), bExamples.get(key))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getExample(), b.getExample())) {
            return false;
        }
        Map<String, Encoding> aEncoding = a.getEncoding();
        Map<String, Encoding> bEncoding = b.getEncoding();
        if (aEncoding == null && bEncoding != null) {
            return false;
        } else if (aEncoding != null && bEncoding == null) {
            return false;
        } else if (aEncoding != null && bEncoding != null) {
            if (aEncoding.size() != bEncoding.size()) {
                return false;
            }
            if (!Objects.equals(aEncoding.keySet(), bEncoding.keySet())) {
                return false;
            }
            for (String key : aEncoding.keySet()) {
                if (!equals(aEncoding.get(key), bEncoding.get(key))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(OAuthFlow a, OAuthFlow b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getAuthorizationUrl(), b.getAuthorizationUrl())) {
            return false;
        }
        if (!Objects.equals(a.getTokenUrl(), b.getTokenUrl())) {
            return false;
        }
        if (!Objects.equals(a.getRefreshUrl(), b.getRefreshUrl())) {
            return false;
        }
        if (!Objects.equals(a.getScopes(), b.getScopes())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(OAuthFlows a, OAuthFlows b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!equals(a.getImplicit(), b.getImplicit())) {
            return false;
        }
        if (!equals(a.getPassword(), b.getPassword())) {
            return false;
        }
        if (!equals(a.getClientCredentials(), b.getClientCredentials())) {
            return false;
        }
        if (!equals(a.getAuthorizationCode(), b.getAuthorizationCode())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Operation a, Operation b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getTags(), b.getTags())) {
            return false;
        }
        if (!Objects.equals(a.getSummary(), b.getSummary())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!equals(a.getExternalDocs(), b.getExternalDocs())) {
            return false;
        }
        if (!Objects.equals(a.getOperationId(), b.getOperationId())) {
            return false;
        }
        List<Parameter> aParameters = a.getParameters();
        List<Parameter> bParameters = b.getParameters();
        if (aParameters == null && bParameters != null) {
            return false;
        } else if (aParameters != null && bParameters == null) {
            return false;
        } else if (aParameters != null && bParameters != null) {
            if (aParameters.size() != bParameters.size()) {
                return false;
            }
            for (int i = 0; i < aParameters.size(); i++) {
                if (!equals(aParameters.get(i), bParameters.get(i))) {
                    return false;
                }
            }
        }
        if (!equals(a.getRequestBody(), b.getRequestBody())) {
            return false;
        }
        if (!equals(a.getResponses(), b.getResponses())) {
            return false;
        }
        Map<String, Callback> aCallbacks = a.getCallbacks();
        Map<String, Callback> bCallbacks = b.getCallbacks();
        if (aCallbacks == null && bCallbacks != null) {
            return false;
        } else if (aCallbacks != null && bCallbacks == null) {
            return false;
        } else if (aCallbacks != null && bCallbacks != null) {
            if (aCallbacks.size() != bCallbacks.size()) {
                return false;
            }
            if (!Objects.equals(aCallbacks.keySet(), bCallbacks.keySet())) {
                return false;
            }
            for (String key : aCallbacks.keySet()) {
                if (!equals(aCallbacks.get(key), bCallbacks.get(key))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getDeprecated(), b.getDeprecated())) {
            return false;
        }
        List<SecurityRequirement> aSecurity = a.getSecurity();
        List<SecurityRequirement> bSecurity = b.getSecurity();
        if (aSecurity == null && bSecurity != null) {
            return false;
        } else if (aSecurity != null && bSecurity == null) {
            return false;
        } else if (aSecurity != null && bSecurity != null) {
            if (aSecurity.size() != bSecurity.size()) {
                return false;
            }
            for (int i = 0; i < aSecurity.size(); i++) {
                if (!equals(aSecurity.get(i), bSecurity.get(i))) {
                    return false;
                }
            }
        }
        List<Server> aServers = a.getServers();
        List<Server> bServers = b.getServers();
        if (aServers == null && bServers != null) {
            return false;
        } else if (aServers != null && bServers == null) {
            return false;
        } else if (aServers != null && bServers != null) {
            if (aServers.size() != bServers.size()) {
                return false;
            }
            for (int i = 0; i < aServers.size(); i++) {
                if (!equals(aServers.get(i), bServers.get(i))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Parameter a, Parameter b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getRef(), b.getRef())) {
            return false;
        }
        if (!Objects.equals(a.getName(), b.getName())) {
            return false;
        }
        if (!Objects.equals(a.getIn(), b.getIn())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!Objects.equals(a.getRequired(), b.getRequired())) {
            return false;
        }
        if (!Objects.equals(a.getDeprecated(), b.getDeprecated())) {
            return false;
        }
        if (!Objects.equals(a.getAllowEmptyValue(), b.getAllowEmptyValue())) {
            return false;
        }
        if (!Objects.equals(a.getStyle(), b.getStyle())) {
            return false;
        }
        if (!Objects.equals(a.getExplode(), b.getExplode())) {
            return false;
        }
        if (!Objects.equals(a.getAllowReserved(), b.getAllowReserved())) {
            return false;
        }
        if (!equals(a.getSchema(), b.getSchema())) {
            return false;
        }
        Map<String, Example> aExamples = a.getExamples();
        Map<String, Example> bExamples = b.getExamples();
        if (aExamples == null && bExamples != null) {
            return false;
        } else if (aExamples != null && bExamples == null) {
            return false;
        } else if (aExamples != null && bExamples != null) {
            if (aExamples.size() != bExamples.size()) {
                return false;
            }
            if (!Objects.equals(aExamples.keySet(), bExamples.keySet())) {
                return false;
            }
            for (String key : aExamples.keySet()) {
                if (!equals(aExamples.get(key), bExamples.get(key))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getExample(), b.getExample())) {
            return false;
        }
        if (!equals(a.getContent(), b.getContent())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(PathItem a, PathItem b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getRef(), b.getRef())) {
            return false;
        }
        if (!Objects.equals(a.getSummary(), b.getSummary())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!equals(a.getGET(), b.getGET())) {
            return false;
        }
        if (!equals(a.getPUT(), b.getPUT())) {
            return false;
        }
        if (!equals(a.getPOST(), b.getPOST())) {
            return false;
        }
        if (!equals(a.getDELETE(), b.getDELETE())) {
            return false;
        }
        if (!equals(a.getOPTIONS(), b.getOPTIONS())) {
            return false;
        }
        if (!equals(a.getHEAD(), b.getHEAD())) {
            return false;
        }
        if (!equals(a.getPATCH(), b.getPATCH())) {
            return false;
        }
        if (!equals(a.getTRACE(), b.getTRACE())) {
            return false;
        }
        List<Server> aServers = a.getServers();
        List<Server> bServers = b.getServers();
        if (aServers == null && bServers != null) {
            return false;
        } else if (aServers != null && bServers == null) {
            return false;
        } else if (aServers != null && bServers != null) {
            if (aServers.size() != bServers.size()) {
                return false;
            }
            for (int i = 0; i < aServers.size(); i++) {
                if (!equals(aServers.get(i), bServers.get(i))) {
                    return false;
                }
            }
        }
        List<Parameter> aParameters = a.getParameters();
        List<Parameter> bParameters = b.getParameters();
        if (aParameters == null && bParameters != null) {
            return false;
        } else if (aParameters != null && bParameters == null) {
            return false;
        } else if (aParameters != null && bParameters != null) {
            if (aParameters.size() != bParameters.size()) {
                return false;
            }
            for (int i = 0; i < aParameters.size(); i++) {
                if (!equals(aParameters.get(i), bParameters.get(i))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Paths a, Paths b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        Map<String, PathItem> aPathItems = a.getPathItems();
        Map<String, PathItem> bPathItems = b.getPathItems();
        if (aPathItems == null && bPathItems != null) {
            return false;
        } else if (aPathItems != null && bPathItems == null) {
            return false;
        } else if (aPathItems != null && bPathItems != null) {
            if (aPathItems.size() != bPathItems.size()) {
                return false;
            }
            if (!Objects.equals(aPathItems.keySet(), bPathItems.keySet())) {
                return false;
            }
            for (String key : aPathItems.keySet()) {
                if (!equals(aPathItems.get(key), bPathItems.get(key))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(RequestBody a, RequestBody b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getRef(), b.getRef())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!equals(a.getContent(), b.getContent())) {
            return false;
        }
        if (!Objects.equals(a.getRequired(), b.getRequired())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Schema a, Schema b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getRef(), b.getRef())) {
            return false;
        }
        if (!equals(a.getDiscriminator(), b.getDiscriminator())) {
            return false;
        }
        if (!Objects.equals(a.getTitle(), b.getTitle())) {
            return false;
        }
        if (!Objects.equals(a.getDefaultValue(), b.getDefaultValue())) {
            return false;
        }
        if (!Objects.equals(a.getEnumeration(), b.getEnumeration())) {
            return false;
        }
        if (!Objects.equals(a.getMultipleOf(), b.getMultipleOf())) {
            return false;
        }
        if (!Objects.equals(a.getMaximum(), b.getMaximum())) {
            return false;
        }
        if (!Objects.equals(a.getExclusiveMaximum(), b.getExclusiveMaximum())) {
            return false;
        }
        if (!Objects.equals(a.getMinimum(), b.getMinimum())) {
            return false;
        }
        if (!Objects.equals(a.getExclusiveMinimum(), b.getExclusiveMinimum())) {
            return false;
        }
        if (!Objects.equals(a.getMaxLength(), b.getMaxLength())) {
            return false;
        }
        if (!Objects.equals(a.getMinLength(), b.getMinLength())) {
            return false;
        }
        if (!Objects.equals(a.getPattern(), b.getPattern())) {
            return false;
        }
        if (!Objects.equals(a.getMaxItems(), b.getMaxItems())) {
            return false;
        }
        if (!Objects.equals(a.getMinItems(), b.getMinItems())) {
            return false;
        }
        if (!Objects.equals(a.getUniqueItems(), b.getUniqueItems())) {
            return false;
        }
        if (!Objects.equals(a.getMaxProperties(), b.getMaxProperties())) {
            return false;
        }
        if (!Objects.equals(a.getMinProperties(), b.getMinProperties())) {
            return false;
        }
        if (!Objects.equals(a.getRequired(), b.getRequired())) {
            return false;
        }
        if (!Objects.equals(a.getType(), b.getType())) {
            return false;
        }
        if (!equals(a.getNot(), b.getNot())) {
            return false;
        }
        Map<String, Schema> aProperties = a.getProperties();
        Map<String, Schema> bProperties = b.getProperties();
        if (aProperties == null && bProperties != null) {
            return false;
        } else if (aProperties != null && bProperties == null) {
            return false;
        } else if (aProperties != null && bProperties != null) {
            if (aProperties.size() != bProperties.size()) {
                return false;
            }
            if (!Objects.equals(aProperties.keySet(), bProperties.keySet())) {
                return false;
            }
            for (String key : aProperties.keySet()) {
                if (!equals(aProperties.get(key), bProperties.get(key))) {
                    return false;
                }
            }
        }
        if (!equals(a.getAdditionalPropertiesSchema(), b.getAdditionalPropertiesSchema())) {
            return false;
        }
        if (!Objects.equals(a.getAdditionalPropertiesBoolean(), b.getAdditionalPropertiesBoolean())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!Objects.equals(a.getFormat(), b.getFormat())) {
            return false;
        }
        if (!Objects.equals(a.getNullable(), b.getNullable())) {
            return false;
        }
        if (!Objects.equals(a.getReadOnly(), b.getReadOnly())) {
            return false;
        }
        if (!Objects.equals(a.getWriteOnly(), b.getWriteOnly())) {
            return false;
        }
        if (!Objects.equals(a.getExample(), b.getExample())) {
            return false;
        }
        if (!equals(a.getExternalDocs(), b.getExternalDocs())) {
            return false;
        }
        if (!Objects.equals(a.getDeprecated(), b.getDeprecated())) {
            return false;
        }
        if (!equals(a.getXml(), b.getXml())) {
            return false;
        }
        if (!equals(a.getItems(), b.getItems())) {
            return false;
        }
        List<Schema> aAllOf = a.getAllOf();
        List<Schema> bAllOf = b.getAllOf();
        if (aAllOf == null && bAllOf != null) {
            return false;
        } else if (aAllOf != null && bAllOf == null) {
            return false;
        } else if (aAllOf != null && bAllOf != null) {
            if (aAllOf.size() != bAllOf.size()) {
                return false;
            }
            for (int i = 0; i < aAllOf.size(); i++) {
                if (!equals(aAllOf.get(i), bAllOf.get(i))) {
                    return false;
                }
            }
        }
        List<Schema> aAnyOf = a.getAnyOf();
        List<Schema> bAnyOf = b.getAnyOf();
        if (aAnyOf == null && bAnyOf != null) {
            return false;
        } else if (aAnyOf != null && bAnyOf == null) {
            return false;
        } else if (aAnyOf != null && bAnyOf != null) {
            if (aAnyOf.size() != bAnyOf.size()) {
                return false;
            }
            for (int i = 0; i < aAnyOf.size(); i++) {
                if (!equals(aAnyOf.get(i), bAnyOf.get(i))) {
                    return false;
                }
            }
        }
        List<Schema> aOneOf = a.getOneOf();
        List<Schema> bOneOf = b.getOneOf();
        if (aOneOf == null && bOneOf != null) {
            return false;
        } else if (aOneOf != null && bOneOf == null) {
            return false;
        } else if (aOneOf != null && bOneOf != null) {
            if (aOneOf.size() != bOneOf.size()) {
                return false;
            }
            for (int i = 0; i < aOneOf.size(); i++) {
                if (!equals(aOneOf.get(i), bOneOf.get(i))) {
                    return false;
                }
            }
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(SecurityRequirement a, SecurityRequirement b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getSchemes(), b.getSchemes())) {
            return false;
        }
        return true;
    }

    public static boolean equals(SecurityScheme a, SecurityScheme b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getRef(), b.getRef())) {
            return false;
        }
        if (!Objects.equals(a.getType(), b.getType())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!Objects.equals(a.getName(), b.getName())) {
            return false;
        }
        if (!Objects.equals(a.getIn(), b.getIn())) {
            return false;
        }
        if (!Objects.equals(a.getScheme(), b.getScheme())) {
            return false;
        }
        if (!Objects.equals(a.getBearerFormat(), b.getBearerFormat())) {
            return false;
        }
        if (!equals(a.getFlows(), b.getFlows())) {
            return false;
        }
        if (!Objects.equals(a.getOpenIdConnectUrl(), b.getOpenIdConnectUrl())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Server a, Server b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getUrl(), b.getUrl())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!Objects.equals(a.getVariables(), b.getVariables())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(ServerVariable a, ServerVariable b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getEnumeration(), b.getEnumeration())) {
            return false;
        }
        if (!Objects.equals(a.getDefaultValue(), b.getDefaultValue())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(Tag a, Tag b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getName(), b.getName())) {
            return false;
        }
        if (!Objects.equals(a.getDescription(), b.getDescription())) {
            return false;
        }
        if (!equals(a.getExternalDocs(), b.getExternalDocs())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    public static boolean equals(XML a, XML b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return false;
        }
        if (!Objects.equals(a.getName(), b.getName())) {
            return false;
        }
        if (!Objects.equals(a.getNamespace(), b.getNamespace())) {
            return false;
        }
        if (!Objects.equals(a.getPrefix(), b.getPrefix())) {
            return false;
        }
        if (!Objects.equals(a.getAttribute(), b.getAttribute())) {
            return false;
        }
        if (!Objects.equals(a.getWrapped(), b.getWrapped())) {
            return false;
        }
        if (!Objects.equals(a.getExtensions(), b.getExtensions())) {
            return false;
        }
        return true;
    }

    private OASEquals() {
    }
}
