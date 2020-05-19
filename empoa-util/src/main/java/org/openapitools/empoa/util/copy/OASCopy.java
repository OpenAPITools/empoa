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
package org.openapitools.empoa.util.copy;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

public class OASCopy {

    public static OpenAPI copy(OpenAPI from) {
        if (from == null) {
            return null;
        }
        OpenAPI to = OASFactory.createOpenAPI();
        to.setOpenapi(from.getOpenapi());
        to.setInfo(copy(from.getInfo()));
        to.setExternalDocs(copy(from.getExternalDocs()));
        List<Server> servers = from.getServers();
        if (servers != null) {
            for (Server item : servers) {
                to.addServer(copy(item));
            }
        }
        List<SecurityRequirement> security = from.getSecurity();
        if (security != null) {
            for (SecurityRequirement item : security) {
                to.addSecurityRequirement(copy(item));
            }
        }
        List<Tag> tags = from.getTags();
        if (tags != null) {
            for (Tag item : tags) {
                to.addTag(copy(item));
            }
        }
        to.setPaths(copy(from.getPaths()));
        to.setComponents(copy(from.getComponents()));
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static APIResponse copy(APIResponse from) {
        if (from == null) {
            return null;
        }
        APIResponse to = OASFactory.createAPIResponse();
        to.setRef(from.getRef());
        to.setDescription(from.getDescription());
        Map<String, Header> headers = from.getHeaders();
        if (headers != null) {
            for (Entry<String, Header> entry : headers.entrySet()) {
                to.addHeader(entry.getKey(), copy(entry.getValue()));
            }
        }
        to.setContent(copy(from.getContent()));
        Map<String, Link> links = from.getLinks();
        if (links != null) {
            for (Entry<String, Link> entry : links.entrySet()) {
                to.addLink(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static APIResponses copy(APIResponses from) {
        if (from == null) {
            return null;
        }
        APIResponses to = OASFactory.createAPIResponses();
        Map<String, APIResponse> apiResponses = from.getAPIResponses();
        if (apiResponses != null) {
            for (Entry<String, APIResponse> entry : apiResponses.entrySet()) {
                to.addAPIResponse(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Callback copy(Callback from) {
        if (from == null) {
            return null;
        }
        Callback to = OASFactory.createCallback();
        to.setRef(from.getRef());
        Map<String, PathItem> pathItems = from.getPathItems();
        if (pathItems != null) {
            for (Entry<String, PathItem> entry : pathItems.entrySet()) {
                to.addPathItem(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Components copy(Components from) {
        if (from == null) {
            return null;
        }
        Components to = OASFactory.createComponents();
        Map<String, Schema> schemas = from.getSchemas();
        if (schemas != null) {
            for (Entry<String, Schema> entry : schemas.entrySet()) {
                to.addSchema(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, APIResponse> responses = from.getResponses();
        if (responses != null) {
            for (Entry<String, APIResponse> entry : responses.entrySet()) {
                to.addResponse(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, Parameter> parameters = from.getParameters();
        if (parameters != null) {
            for (Entry<String, Parameter> entry : parameters.entrySet()) {
                to.addParameter(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, Example> examples = from.getExamples();
        if (examples != null) {
            for (Entry<String, Example> entry : examples.entrySet()) {
                to.addExample(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, RequestBody> requestBodies = from.getRequestBodies();
        if (requestBodies != null) {
            for (Entry<String, RequestBody> entry : requestBodies.entrySet()) {
                to.addRequestBody(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, Header> headers = from.getHeaders();
        if (headers != null) {
            for (Entry<String, Header> entry : headers.entrySet()) {
                to.addHeader(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, SecurityScheme> securitySchemes = from.getSecuritySchemes();
        if (securitySchemes != null) {
            for (Entry<String, SecurityScheme> entry : securitySchemes.entrySet()) {
                to.addSecurityScheme(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, Link> links = from.getLinks();
        if (links != null) {
            for (Entry<String, Link> entry : links.entrySet()) {
                to.addLink(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, Callback> callbacks = from.getCallbacks();
        if (callbacks != null) {
            for (Entry<String, Callback> entry : callbacks.entrySet()) {
                to.addCallback(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Contact copy(Contact from) {
        if (from == null) {
            return null;
        }
        Contact to = OASFactory.createContact();
        to.setName(from.getName());
        to.setUrl(from.getUrl());
        to.setEmail(from.getEmail());
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Content copy(Content from) {
        if (from == null) {
            return null;
        }
        Content to = OASFactory.createContent();
        Map<String, MediaType> mediaTypes = from.getMediaTypes();
        if (mediaTypes != null) {
            for (Entry<String, MediaType> entry : mediaTypes.entrySet()) {
                to.addMediaType(entry.getKey(), copy(entry.getValue()));
            }
        }
        return to;
    }

    public static Discriminator copy(Discriminator from) {
        if (from == null) {
            return null;
        }
        Discriminator to = OASFactory.createDiscriminator();
        to.setPropertyName(from.getPropertyName());
        Map<String, String> mapping = from.getMapping();
        if (mapping != null) {
            for (Entry<String, String> entry : mapping.entrySet()) {
                to.addMapping(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Encoding copy(Encoding from) {
        if (from == null) {
            return null;
        }
        Encoding to = OASFactory.createEncoding();
        to.setContentType(from.getContentType());
        Map<String, Header> headers = from.getHeaders();
        if (headers != null) {
            for (Entry<String, Header> entry : headers.entrySet()) {
                to.addHeader(entry.getKey(), copy(entry.getValue()));
            }
        }
        to.setStyle(from.getStyle());
        to.setExplode(from.getExplode());
        to.setAllowReserved(from.getAllowReserved());
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Example copy(Example from) {
        if (from == null) {
            return null;
        }
        Example to = OASFactory.createExample();
        to.setRef(from.getRef());
        to.setSummary(from.getSummary());
        to.setDescription(from.getDescription());
        to.setValue(from.getValue());
        to.setExternalValue(from.getExternalValue());
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static ExternalDocumentation copy(ExternalDocumentation from) {
        if (from == null) {
            return null;
        }
        ExternalDocumentation to = OASFactory.createExternalDocumentation();
        to.setDescription(from.getDescription());
        to.setUrl(from.getUrl());
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Header copy(Header from) {
        if (from == null) {
            return null;
        }
        Header to = OASFactory.createHeader();
        to.setRef(from.getRef());
        to.setDescription(from.getDescription());
        to.setRequired(from.getRequired());
        to.setDeprecated(from.getDeprecated());
        to.setAllowEmptyValue(from.getAllowEmptyValue());
        to.setStyle(from.getStyle());
        to.setExplode(from.getExplode());
        to.setSchema(copy(from.getSchema()));
        Map<String, Example> examples = from.getExamples();
        if (examples != null) {
            for (Entry<String, Example> entry : examples.entrySet()) {
                to.addExample(entry.getKey(), copy(entry.getValue()));
            }
        }
        to.setExample(from.getExample());
        to.setContent(copy(from.getContent()));
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Info copy(Info from) {
        if (from == null) {
            return null;
        }
        Info to = OASFactory.createInfo();
        to.setTitle(from.getTitle());
        to.setDescription(from.getDescription());
        to.setTermsOfService(from.getTermsOfService());
        to.setContact(copy(from.getContact()));
        to.setLicense(copy(from.getLicense()));
        to.setVersion(from.getVersion());
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static License copy(License from) {
        if (from == null) {
            return null;
        }
        License to = OASFactory.createLicense();
        to.setName(from.getName());
        to.setUrl(from.getUrl());
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Link copy(Link from) {
        if (from == null) {
            return null;
        }
        Link to = OASFactory.createLink();
        to.setRef(from.getRef());
        to.setServer(copy(from.getServer()));
        to.setOperationRef(from.getOperationRef());
        to.setRequestBody(from.getRequestBody());
        to.setOperationId(from.getOperationId());
        Map<String, Object> parameters = from.getParameters();
        if (parameters != null) {
            for (Entry<String, Object> entry : parameters.entrySet()) {
                to.addParameter(entry.getKey(), entry.getValue());
            }
        }
        to.setDescription(from.getDescription());
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static MediaType copy(MediaType from) {
        if (from == null) {
            return null;
        }
        MediaType to = OASFactory.createMediaType();
        to.setSchema(copy(from.getSchema()));
        Map<String, Example> examples = from.getExamples();
        if (examples != null) {
            for (Entry<String, Example> entry : examples.entrySet()) {
                to.addExample(entry.getKey(), copy(entry.getValue()));
            }
        }
        to.setExample(from.getExample());
        Map<String, Encoding> encoding = from.getEncoding();
        if (encoding != null) {
            for (Entry<String, Encoding> entry : encoding.entrySet()) {
                to.addEncoding(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static OAuthFlow copy(OAuthFlow from) {
        if (from == null) {
            return null;
        }
        OAuthFlow to = OASFactory.createOAuthFlow();
        to.setAuthorizationUrl(from.getAuthorizationUrl());
        to.setTokenUrl(from.getTokenUrl());
        to.setRefreshUrl(from.getRefreshUrl());
        to.setScopes(copy(from.getScopes()));
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static OAuthFlows copy(OAuthFlows from) {
        if (from == null) {
            return null;
        }
        OAuthFlows to = OASFactory.createOAuthFlows();
        to.setImplicit(copy(from.getImplicit()));
        to.setPassword(copy(from.getPassword()));
        to.setClientCredentials(copy(from.getClientCredentials()));
        to.setAuthorizationCode(copy(from.getAuthorizationCode()));
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Operation copy(Operation from) {
        if (from == null) {
            return null;
        }
        Operation to = OASFactory.createOperation();
        List<String> tags = from.getTags();
        if (tags != null) {
            for (String item : tags) {
                to.addTag(item);
            }
        }
        to.setSummary(from.getSummary());
        to.setDescription(from.getDescription());
        to.setExternalDocs(copy(from.getExternalDocs()));
        to.setOperationId(from.getOperationId());
        List<Parameter> parameters = from.getParameters();
        if (parameters != null) {
            for (Parameter item : parameters) {
                to.addParameter(copy(item));
            }
        }
        to.setRequestBody(copy(from.getRequestBody()));
        to.setResponses(copy(from.getResponses()));
        Map<String, Callback> callbacks = from.getCallbacks();
        if (callbacks != null) {
            for (Entry<String, Callback> entry : callbacks.entrySet()) {
                to.addCallback(entry.getKey(), copy(entry.getValue()));
            }
        }
        to.setDeprecated(from.getDeprecated());
        List<SecurityRequirement> security = from.getSecurity();
        if (security != null) {
            for (SecurityRequirement item : security) {
                to.addSecurityRequirement(copy(item));
            }
        }
        List<Server> servers = from.getServers();
        if (servers != null) {
            for (Server item : servers) {
                to.addServer(copy(item));
            }
        }
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Parameter copy(Parameter from) {
        if (from == null) {
            return null;
        }
        Parameter to = OASFactory.createParameter();
        to.setRef(from.getRef());
        to.setName(from.getName());
        to.setIn(from.getIn());
        to.setDescription(from.getDescription());
        to.setRequired(from.getRequired());
        to.setDeprecated(from.getDeprecated());
        to.setAllowEmptyValue(from.getAllowEmptyValue());
        to.setStyle(from.getStyle());
        to.setExplode(from.getExplode());
        to.setAllowReserved(from.getAllowReserved());
        to.setSchema(copy(from.getSchema()));
        Map<String, Example> examples = from.getExamples();
        if (examples != null) {
            for (Entry<String, Example> entry : examples.entrySet()) {
                to.addExample(entry.getKey(), copy(entry.getValue()));
            }
        }
        to.setExample(from.getExample());
        to.setContent(copy(from.getContent()));
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static PathItem copy(PathItem from) {
        if (from == null) {
            return null;
        }
        PathItem to = OASFactory.createPathItem();
        to.setRef(from.getRef());
        to.setSummary(from.getSummary());
        to.setDescription(from.getDescription());
        to.setGET(copy(from.getGET()));
        to.setPUT(copy(from.getPUT()));
        to.setPOST(copy(from.getPOST()));
        to.setDELETE(copy(from.getDELETE()));
        to.setOPTIONS(copy(from.getOPTIONS()));
        to.setHEAD(copy(from.getHEAD()));
        to.setPATCH(copy(from.getPATCH()));
        to.setTRACE(copy(from.getTRACE()));
        List<Server> servers = from.getServers();
        if (servers != null) {
            for (Server item : servers) {
                to.addServer(copy(item));
            }
        }
        List<Parameter> parameters = from.getParameters();
        if (parameters != null) {
            for (Parameter item : parameters) {
                to.addParameter(copy(item));
            }
        }
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Paths copy(Paths from) {
        if (from == null) {
            return null;
        }
        Paths to = OASFactory.createPaths();
        Map<String, PathItem> pathItems = from.getPathItems();
        if (pathItems != null) {
            for (Entry<String, PathItem> entry : pathItems.entrySet()) {
                to.addPathItem(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static RequestBody copy(RequestBody from) {
        if (from == null) {
            return null;
        }
        RequestBody to = OASFactory.createRequestBody();
        to.setRef(from.getRef());
        to.setDescription(from.getDescription());
        to.setContent(copy(from.getContent()));
        to.setRequired(from.getRequired());
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Schema copy(Schema from) {
        if (from == null) {
            return null;
        }
        Schema to = OASFactory.createSchema();
        to.setRef(from.getRef());
        to.setDiscriminator(copy(from.getDiscriminator()));
        to.setTitle(from.getTitle());
        to.setDefaultValue(from.getDefaultValue());
        List<Object> enumeration = from.getEnumeration();
        if (enumeration != null) {
            for (Object item : enumeration) {
                to.addEnumeration(item);
            }
        }
        to.setMultipleOf(from.getMultipleOf());
        to.setMaximum(from.getMaximum());
        to.setExclusiveMaximum(from.getExclusiveMaximum());
        to.setMinimum(from.getMinimum());
        to.setExclusiveMinimum(from.getExclusiveMinimum());
        to.setMaxLength(from.getMaxLength());
        to.setMinLength(from.getMinLength());
        to.setPattern(from.getPattern());
        to.setMaxItems(from.getMaxItems());
        to.setMinItems(from.getMinItems());
        to.setUniqueItems(from.getUniqueItems());
        to.setMaxProperties(from.getMaxProperties());
        to.setMinProperties(from.getMinProperties());
        List<String> required = from.getRequired();
        if (required != null) {
            for (String item : required) {
                to.addRequired(item);
            }
        }
        to.setType(from.getType());
        to.setNot(copy(from.getNot()));
        Map<String, Schema> properties = from.getProperties();
        if (properties != null) {
            for (Entry<String, Schema> entry : properties.entrySet()) {
                to.addProperty(entry.getKey(), copy(entry.getValue()));
            }
        }
        to.setAdditionalPropertiesSchema(copy(from.getAdditionalPropertiesSchema()));
        to.setAdditionalPropertiesBoolean(from.getAdditionalPropertiesBoolean());
        to.setDescription(from.getDescription());
        to.setFormat(from.getFormat());
        to.setNullable(from.getNullable());
        to.setReadOnly(from.getReadOnly());
        to.setWriteOnly(from.getWriteOnly());
        to.setExample(from.getExample());
        to.setExternalDocs(copy(from.getExternalDocs()));
        to.setDeprecated(from.getDeprecated());
        to.setXml(copy(from.getXml()));
        to.setItems(copy(from.getItems()));
        List<Schema> allOf = from.getAllOf();
        if (allOf != null) {
            for (Schema item : allOf) {
                to.addAllOf(copy(item));
            }
        }
        List<Schema> anyOf = from.getAnyOf();
        if (anyOf != null) {
            for (Schema item : anyOf) {
                to.addAnyOf(copy(item));
            }
        }
        List<Schema> oneOf = from.getOneOf();
        if (oneOf != null) {
            for (Schema item : oneOf) {
                to.addOneOf(copy(item));
            }
        }
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Scopes copy(Scopes from) {
        if (from == null) {
            return null;
        }
        Scopes to = OASFactory.createScopes();
        Map<String, String> scopes = from.getScopes();
        if (scopes != null) {
            for (Entry<String, String> entry : scopes.entrySet()) {
                to.addScope(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static SecurityRequirement copy(SecurityRequirement from) {
        if (from == null) {
            return null;
        }
        SecurityRequirement to = OASFactory.createSecurityRequirement();
        Map<String, List<String>> schemes = from.getSchemes();
        if (schemes != null) {
            for (Entry<String, List<String>> entry : schemes.entrySet()) {
                to.addScheme(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static SecurityScheme copy(SecurityScheme from) {
        if (from == null) {
            return null;
        }
        SecurityScheme to = OASFactory.createSecurityScheme();
        to.setRef(from.getRef());
        to.setType(from.getType());
        to.setDescription(from.getDescription());
        to.setName(from.getName());
        to.setIn(from.getIn());
        to.setScheme(from.getScheme());
        to.setBearerFormat(from.getBearerFormat());
        to.setFlows(copy(from.getFlows()));
        to.setOpenIdConnectUrl(from.getOpenIdConnectUrl());
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Server copy(Server from) {
        if (from == null) {
            return null;
        }
        Server to = OASFactory.createServer();
        to.setUrl(from.getUrl());
        to.setDescription(from.getDescription());
        to.setVariables(copy(from.getVariables()));
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static ServerVariable copy(ServerVariable from) {
        if (from == null) {
            return null;
        }
        ServerVariable to = OASFactory.createServerVariable();
        List<String> enumeration = from.getEnumeration();
        if (enumeration != null) {
            for (String item : enumeration) {
                to.addEnumeration(item);
            }
        }
        to.setDefaultValue(from.getDefaultValue());
        to.setDescription(from.getDescription());
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static ServerVariables copy(ServerVariables from) {
        if (from == null) {
            return null;
        }
        ServerVariables to = OASFactory.createServerVariables();
        Map<String, ServerVariable> serverVariables = from.getServerVariables();
        if (serverVariables != null) {
            for (Entry<String, ServerVariable> entry : serverVariables.entrySet()) {
                to.addServerVariable(entry.getKey(), copy(entry.getValue()));
            }
        }
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static Tag copy(Tag from) {
        if (from == null) {
            return null;
        }
        Tag to = OASFactory.createTag();
        to.setName(from.getName());
        to.setDescription(from.getDescription());
        to.setExternalDocs(copy(from.getExternalDocs()));
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    public static XML copy(XML from) {
        if (from == null) {
            return null;
        }
        XML to = OASFactory.createXML();
        to.setName(from.getName());
        to.setNamespace(from.getNamespace());
        to.setPrefix(from.getPrefix());
        to.setAttribute(from.getAttribute());
        to.setWrapped(from.getWrapped());
        Map<String, Object> extensions = from.getExtensions();
        if (extensions != null) {
            for (Entry<String, Object> entry : extensions.entrySet()) {
                to.addExtension(entry.getKey(), entry.getValue());
            }
        }
        return to;
    }

    private OASCopy() {
    }
}
