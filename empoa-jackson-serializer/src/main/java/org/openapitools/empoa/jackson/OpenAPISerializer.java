/**
 * Copyright 2017 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//Adapted from https://github.com/smallrye/smallrye-open-api/blob/1.1.0/implementation/src/main/java/io/smallrye/openapi/runtime/io/OpenApiSerializer.java
package org.openapitools.empoa.jackson;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;

import org.eclipse.microprofile.openapi.models.Components;
import org.eclipse.microprofile.openapi.models.Extensible;
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
import org.openapitools.empoa.jackson.internal.JsonUtil;
import org.openapitools.empoa.jackson.internal.OpenAPIConstants;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

/**
 * Class used to serialize an OpenAPI
 *
 * @author eric.wittmann@gmail.com
 */
public class OpenAPISerializer {

    public enum Format {
        JSON("application/json"), YAML("application/yaml");

        private final String mimeType;

        Format(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getMimeType() {
            return mimeType;
        }
    }

    /**
     * Serializes the given {@link Components} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Components object
     * @param format
     *            the serialization format
     * @return Components object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Components model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeComponentsToNode, format);
    }

    /**
     * Serializes the given {@link ExternalDocumentation} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the ExternalDocumentation object
     * @param format
     *            the serialization format
     * @return ExternalDocumentation object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(ExternalDocumentation model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeExternalDocumentationToNode, format);
    }

    /**
     * Serializes the given {@link OpenAPI} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the OpenAPI object
     * @param format
     *            the serialization format
     * @return OpenAPI object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(OpenAPI model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeOpenAPIToNode, format);
    }

    /**
     * Serializes the given {@link Operation} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Operation object
     * @param format
     *            the serialization format
     * @return Operation object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Operation model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeOperationToNode, format);
    }

    /**
     * Serializes the given {@link PathItem} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the PathItem object
     * @param format
     *            the serialization format
     * @return PathItem object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(PathItem model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writePathItemToNode, format);
    }

    /**
     * Serializes the given {@link Paths} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Paths object
     * @param format
     *            the serialization format
     * @return Paths object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Paths model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writePathsToNode, format);
    }

    /**
     * Serializes the given {@link Callback} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Callback object
     * @param format
     *            the serialization format
     * @return Callback object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Callback model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeCallbackToNode, format);
    }

    /**
     * Serializes the given {@link Example} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Example object
     * @param format
     *            the serialization format
     * @return Example object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Example model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeExampleToNode, format);
    }

    /**
     * Serializes the given {@link Header} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Header object
     * @param format
     *            the serialization format
     * @return Header object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Header model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeHeaderToNode, format);
    }

    /**
     * Serializes the given {@link Contact} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Contact object
     * @param format
     *            the serialization format
     * @return Contact object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Contact model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeContactToNode, format);
    }

    /**
     * Serializes the given {@link Info} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Info object
     * @param format
     *            the serialization format
     * @return Info object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Info model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeInfoToNode, format);
    }

    /**
     * Serializes the given {@link License} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the License object
     * @param format
     *            the serialization format
     * @return License object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(License model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeLicenseToNode, format);
    }

    /**
     * Serializes the given {@link Link} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Link object
     * @param format
     *            the serialization format
     * @return Link object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Link model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeLinkToNode, format);
    }

    /**
     * Serializes the given {@link Content} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Content object
     * @param format
     *            the serialization format
     * @return Content object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Content model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeContentToNode, format);
    }

    /**
     * Serializes the given {@link Discriminator} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Discriminator object
     * @param format
     *            the serialization format
     * @return Discriminator object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Discriminator model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeDiscriminatorToNode, format);
    }

    /**
     * Serializes the given {@link Encoding} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Encoding object
     * @param format
     *            the serialization format
     * @return Encoding object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Encoding model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeEncodingToNode, format);
    }

    /**
     * Serializes the given {@link MediaType} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the MediaType object
     * @param format
     *            the serialization format
     * @return MediaType object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(MediaType model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeMediaTypeToNode, format);
    }

    /**
     * Serializes the given {@link Schema} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Schema object
     * @param format
     *            the serialization format
     * @return Schema object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Schema model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeSchemaToNode, format);
    }

    /**
     * Serializes the given {@link XML} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the XML object
     * @param format
     *            the serialization format
     * @return XML object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(XML model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeXMLToNode, format);
    }

    /**
     * Serializes the given {@link Parameter} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Parameter object
     * @param format
     *            the serialization format
     * @return Parameter object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Parameter model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeParameterToNode, format);
    }

    /**
     * Serializes the given {@link RequestBody} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the RequestBody object
     * @param format
     *            the serialization format
     * @return RequestBody object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(RequestBody model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeRequestBodyToNode, format);
    }

    /**
     * Serializes the given {@link APIResponse} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the APIResponse object
     * @param format
     *            the serialization format
     * @return APIResponse object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(APIResponse model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeAPIResponseToNode, format);
    }

    /**
     * Serializes the given {@link APIResponses} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the APIResponses object
     * @param format
     *            the serialization format
     * @return APIResponses object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(APIResponses model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeAPIResponsesToNode, format);
    }

    /**
     * Serializes the given {@link OAuthFlow} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the OAuthFlow object
     * @param format
     *            the serialization format
     * @return OAuthFlow object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(OAuthFlow model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeOAuthFlowToNode, format);
    }

    /**
     * Serializes the given {@link OAuthFlows} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the OAuthFlows object
     * @param format
     *            the serialization format
     * @return OAuthFlows object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(OAuthFlows model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeOAuthFlowsToNode, format);
    }

    /**
     * Serializes the given {@link Scopes} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Scopes object
     * @param format
     *            the serialization format
     * @return Scopes object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Scopes model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeScopesToNode, format);
    }

    /**
     * Serializes the given {@link SecurityRequirement} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the SecurityRequirement object
     * @param format
     *            the serialization format
     * @return SecurityRequirement object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(SecurityRequirement model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeSecurityRequirementToNode, format);
    }

    /**
     * Serializes the given {@link SecurityScheme} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the SecurityScheme object
     * @param format
     *            the serialization format
     * @return SecurityScheme object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(SecurityScheme model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeSecuritySchemeToNode, format);
    }

    /**
     * Serializes the given {@link Server} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Server object
     * @param format
     *            the serialization format
     * @return Server object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Server model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeServerToNode, format);
    }

    /**
     * Serializes the given {@link ServerVariable} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the ServerVariable object
     * @param format
     *            the serialization format
     * @return ServerVariable object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(ServerVariable model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeServerVariableToNode, format);
    }

    /**
     * Serializes the given {@link ServerVariables} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the ServerVariables object
     * @param format
     *            the serialization format
     * @return ServerVariables object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(ServerVariables model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeServerVariablesToNode, format);
    }

    /**
     * Serializes the given {@link Tag} object into either JSON or YAML and returns it as a string.
     *
     * @param model
     *            the Tag object
     * @param format
     *            the serialization format
     * @return Tag object as a String
     * @throws IOException
     *             Errors in processing the JSON
     */
    public static final String serialize(Tag model, Format format) throws IOException {
        return serialize(model, OpenAPISerializer::writeTagToNode, format);
    }

    /**
     * Serializes the given object into either JSON or YAML and returns it as a string.
     *
     * @param model
     * @param writeMethod
     * @param format
     * @return
     * @throws IOException
     */
    static final <T> String serialize(T model, BiConsumer<ObjectNode, T> writeMethod, Format format) throws IOException {
        try {
            ObjectNode tree = JsonUtil.objectNode();
            writeMethod.accept(tree, model);

            ObjectMapper mapper;
            if (format == Format.JSON) {
                mapper = new ObjectMapper();
                return mapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(tree);
            } else {
                YAMLFactory factory = new YAMLFactory();
                factory.enable(YAMLGenerator.Feature.MINIMIZE_QUOTES);
                factory.enable(YAMLGenerator.Feature.ALWAYS_QUOTE_NUMBERS_AS_STRINGS);
                mapper = new ObjectMapper(factory);
                return mapper.writer()
                    .writeValueAsString(tree);
            }
        } catch (JsonProcessingException e) {
            throw new IOException(e);
        }
    }

    /**
     * Writes a {@link OpenAPI} to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeOpenAPIToNode(ObjectNode node, OpenAPI model) {
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_OPENAPI, model.getOpenapi());
        writeInfo(node, model.getInfo());
        writeExternalDocumentation(node, model.getExternalDocs());
        writeServers(node, model.getServers());
        writeSecurity(node, model.getSecurity());
        writeTags(node, model.getTags());
        writePaths(node, model.getPaths());
        writeComponents(node, model.getComponents());
        writeExtensions(node, model);
    }

    /**
     * Writes the {@link Info} model to the JSON tree.
     *
     * @param parent
     * @param model
     */
    private static void writeInfo(ObjectNode parent, Info model) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(OpenAPIConstants.PROP_INFO);
        writeInfoToNode(node, model);
    }

    /**
     * Writes a {@link Info} to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeInfoToNode(ObjectNode node, Info model) {
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_TITLE, model.getTitle());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_TERMS_OF_SERVICE, model.getTermsOfService());
        writeContact(node, model.getContact());
        writeLicense(node, model.getLicense());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_VERSION, model.getVersion());
        writeExtensions(node, model);
    }

    /**
     * Writes the {@link Contact} model to the JSON tree.
     *
     * @param parent
     * @param model
     */
    private static void writeContact(ObjectNode parent, Contact model) {
        if (model == null) {
            return;
        }
        ObjectNode node = JsonUtil.objectNode();
        parent.set(OpenAPIConstants.PROP_CONTACT, node);
        writeContactToNode(node, model);
    }

    /**
     * Writes a {@link Contact} to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeContactToNode(ObjectNode node, Contact model) {
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_NAME, model.getName());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_URL, model.getUrl());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_EMAIL, model.getEmail());
        writeExtensions(node, model);
    }

    /**
     * Writes the {@link License} model to the JSON tree.
     *
     * @param parent
     * @param model
     */
    private static void writeLicense(ObjectNode parent, License model) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(OpenAPIConstants.PROP_LICENSE);
        writeLicenseToNode(node, model);
    }

    /**
     * Writes a {@link License} to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeLicenseToNode(ObjectNode node, License model) {
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_NAME, model.getName());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_URL, model.getUrl());
        writeExtensions(node, model);
    }

    /**
     * Writes the {@link ExternalDocumentation} model to the JSON tree.
     *
     * @param parent
     * @param model
     */
    private static void writeExternalDocumentation(ObjectNode parent, ExternalDocumentation model) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(OpenAPIConstants.PROP_EXTERNAL_DOCS);
        writeExternalDocumentationToNode(node, model);
    }

    /**
     * Writes a {@link ExternalDocumentation} to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeExternalDocumentationToNode(ObjectNode node, ExternalDocumentation model) {
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_URL, model.getUrl());
        writeExtensions(node, model);
    }

    /**
     * Writes the {@link Tag} model array to the JSON tree.
     *
     * @param node
     * @param tags
     */
    private static void writeTags(ObjectNode node, List<Tag> tags) {
        if (tags == null) {
            return;
        }
        ArrayNode array = node.putArray(OpenAPIConstants.PROP_TAGS);
        for (Tag tag : tags) {
            ObjectNode tagNode = array.addObject();
            writeTagToNode(tagNode, tag);
        }
    }

    /**
     * Writes a {@link Tag} to the given JSON node.
     *
     * @param node
     * @param tag
     */
    private static void writeTagToNode(ObjectNode node, Tag tag) {
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_NAME, tag.getName());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, tag.getDescription());
        writeExternalDocumentation(node, tag.getExternalDocs());
        writeExtensions(node, tag);
    }

    /**
     * Writes the {@link Server} model array to the JSON tree.
     *
     * @param node
     * @param servers
     */
    private static void writeServers(ObjectNode node, List<Server> servers) {
        if (servers == null) {
            return;
        }
        ArrayNode array = node.putArray(OpenAPIConstants.PROP_SERVERS);
        for (Server server : servers) {
            ObjectNode serverNode = array.addObject();
            writeServerToNode(serverNode, server);
        }
    }

    /**
     * Writes a {@link Server} model to the given JSON node.
     *
     * @param node
     *            ObjectNode
     * @param model
     *            Server
     */
    private static void writeServerToNode(ObjectNode node, Server model) {
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_URL, model.getUrl());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
        writeServerVariables(node, model.getVariables());
        writeExtensions(node, model);
    }

    /**
     * Writes the {@link ServerVariables} model to the JSON tree.
     *
     * @param serverNode
     * @param variables
     */
    private static void writeServerVariables(ObjectNode serverNode, ServerVariables variables) {
        if (variables == null) {
            return;
        }
        ObjectNode variablesNode = serverNode.putObject(OpenAPIConstants.PROP_VARIABLES);
        writeServerVariablesToNode(variablesNode, variables);
    }

    /**
     * Writes the {@link ServerVariables} model to the given JSON node.
     *
     * @param node
     * @param variables
     */
    private static void writeServerVariablesToNode(ObjectNode node, ServerVariables variables) {
        if (variables.getServerVariables() != null) {
            for (String varName : variables.getServerVariables()
                .keySet()) {
                writeServerVariable(node, varName, variables.getServerVariable(varName));
            }
            writeExtensions(node, variables);
        }
    }

    /**
     * Writes a {@link ServerVariable} to the JSON tree.
     *
     * @param parent
     * @param variableName
     * @param model
     */
    private static void writeServerVariable(ObjectNode parent, String variableName, ServerVariable model) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(variableName);
        writeServerVariableToNode(node, model);
    }

    /**
     * Writes the {@link ServerVariable} model to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeServerVariableToNode(ObjectNode node, ServerVariable model) {
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DEFAULT, model.getDefaultValue());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
        List<String> enumeration = model.getEnumeration();
        if (enumeration != null) {
            ArrayNode enumArray = node.putArray(OpenAPIConstants.PROP_ENUM);
            for (String enumValue : enumeration) {
                enumArray.add(enumValue);
            }
        }
        writeExtensions(node, model);
    }

    /**
     * Writes the {@link SecurityRequirement} model array to the JSON tree.
     *
     * @param parent
     * @param security
     */
    private static void writeSecurity(ObjectNode parent, List<SecurityRequirement> security) {
        if (security == null) {
            return;
        }
        ArrayNode array = parent.putArray(OpenAPIConstants.PROP_SECURITY);
        for (SecurityRequirement securityRequirement : security) {
            ObjectNode srNode = array.addObject();
            for (String fieldName : securityRequirement.getSchemes()
                .keySet()) {
                List<String> values = securityRequirement.getScheme(fieldName);
                ArrayNode valuesNode = srNode.putArray(fieldName);
                if (values != null) {
                    for (String value : values) {
                        valuesNode.add(value);
                    }
                }
            }
        }
    }

    /**
     * Writes a {@link Paths} to the JSON tree.
     *
     * @param parent
     * @param paths
     */
    private static void writePaths(ObjectNode parent, Paths paths) {
        if (paths == null) {
            return;
        }
        ObjectNode pathsNode = parent.putObject(OpenAPIConstants.PROP_PATHS);
        writePathsToNode(pathsNode, paths);
    }

    /**
     * Writes the {@link Paths} model to the given JSON node.
     *
     * @param node
     * @param paths
     */
    private static void writePathsToNode(ObjectNode node, Paths paths) {
        if (paths.getPathItems() != null) {
            for (String pathName : paths.getPathItems()
                .keySet()) {
                writePathItem(node, paths.getPathItem(pathName), pathName);
            }
            writeExtensions(node, paths);
        }
    }

    /**
     * Writes a {@link PathItem} to the JSON tree.
     *
     * @param parent
     * @param model
     * @param pathName
     */
    private static void writePathItem(ObjectNode parent, PathItem model, String pathName) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(pathName);
        writePathItemToNode(node, model);
    }

    /**
     * Writes the {@link PathItem} model to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writePathItemToNode(ObjectNode node, PathItem model) {
        if (model.getRef() != null) {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_$REF, model.getRef());
        } else {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_SUMMARY, model.getSummary());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
            writeOperation(node, model.getGET(), OpenAPIConstants.PROP_GET);
            writeOperation(node, model.getPUT(), OpenAPIConstants.PROP_PUT);
            writeOperation(node, model.getPOST(), OpenAPIConstants.PROP_POST);
            writeOperation(node, model.getDELETE(), OpenAPIConstants.PROP_DELETE);
            writeOperation(node, model.getOPTIONS(), OpenAPIConstants.PROP_OPTIONS);
            writeOperation(node, model.getHEAD(), OpenAPIConstants.PROP_HEAD);
            writeOperation(node, model.getPATCH(), OpenAPIConstants.PROP_PATCH);
            writeOperation(node, model.getTRACE(), OpenAPIConstants.PROP_TRACE);
            writeParameterList(node, model.getParameters());
            writeServers(node, model.getServers());
            writeExtensions(node, model);
        }
    }

    /**
     * Writes a {@link Operation} to the JSON tree.
     *
     * @param parent
     * @param model
     * @param method
     */
    private static void writeOperation(ObjectNode parent, Operation model, String method) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(method);
        writeOperationToNode(node, model);
    }

    /**
     * Writes the {@link Operation} model to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeOperationToNode(ObjectNode node, Operation model) {
        writeStringArray(node, model.getTags(), OpenAPIConstants.PROP_TAGS);
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_SUMMARY, model.getSummary());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
        writeExternalDocumentation(node, model.getExternalDocs());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_OPERATION_ID, model.getOperationId());
        writeParameterList(node, model.getParameters());
        writeRequestBody(node, model.getRequestBody());
        writeAPIResponses(node, model.getResponses());
        writeCallbacks(node, model.getCallbacks());
        JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_DEPRECATED, model.getDeprecated());
        writeSecurityRequirements(node, model.getSecurity());
        writeServers(node, model.getServers());
        writeExtensions(node, model);
    }

    /**
     * Writes a {@link RequestBody} to the JSON tree.
     *
     * @param parent
     * @param model
     */
    private static void writeRequestBody(ObjectNode parent, RequestBody model) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(OpenAPIConstants.PROP_REQUEST_BODY);
        writeRequestBodyToNode(node, model);
    }

    /**
     * Writes the {@link RequestBody} model to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeRequestBodyToNode(ObjectNode node, RequestBody model) {
        if (model.getRef() != null) {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_$REF, model.getRef());
        } else {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
            writeContent(node, model.getContent());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_REQUIRED, model.getRequired());
            writeExtensions(node, model);
        }
    }

    /**
     * Writes a {@link Content} to the JSON tree.
     *
     * @param parent
     * @param model
     */
    private static void writeContent(ObjectNode parent, Content model) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(OpenAPIConstants.PROP_CONTENT);
        writeContentToNode(node, model);
    }

    /**
     * Writes the {@link Content} model to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeContentToNode(ObjectNode node, Content model) {
        if (model.getMediaTypes() != null) {
            for (String name : model.getMediaTypes()
                .keySet()) {
                writeMediaType(node, model.getMediaType(name), name);
            }
        }
    }

    /**
     * Writes a {@link MediaType} to the JSON tree.
     *
     * @param parent
     * @param model
     * @param name
     */
    private static void writeMediaType(ObjectNode parent, MediaType model, String name) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(name);
        writeMediaTypeToNode(node, model);
    }

    /**
     * Writes the {@link MediaType} model to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeMediaTypeToNode(ObjectNode node, MediaType model) {
        writeSchema(node, model.getSchema(), OpenAPIConstants.PROP_SCHEMA);
        writeObject(node, OpenAPIConstants.PROP_EXAMPLE, model.getExample());
        writeExamples(node, model.getExamples());
        writeEncodings(node, model.getEncoding());
        writeExtensions(node, model);
    }

    /**
     * Writes a {@link Schema} to the JSON tree.
     *
     * @param parent
     * @param model
     * @param name
     */
    private static void writeSchema(ObjectNode parent, Schema model, String name) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(name);
        writeSchemaToNode(node, model);
    }

    /**
     * Writes the {@link Schema} model to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeSchemaToNode(ObjectNode node, Schema model) {
        if (model.getRef() != null) {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_$REF, model.getRef());
        } else {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_FORMAT, model.getFormat());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_TITLE, model.getTitle());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
            writeObject(node, OpenAPIConstants.PROP_DEFAULT, model.getDefaultValue());
            JsonUtil.bigDecimalProperty(node, OpenAPIConstants.PROP_MULTIPLE_OF, model.getMultipleOf());
            JsonUtil.bigDecimalProperty(node, OpenAPIConstants.PROP_MAXIMUM, model.getMaximum());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_EXCLUSIVE_MAXIMUM, model.getExclusiveMaximum());
            JsonUtil.bigDecimalProperty(node, OpenAPIConstants.PROP_MINIMUM, model.getMinimum());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_EXCLUSIVE_MINIMUM, model.getExclusiveMinimum());
            JsonUtil.intProperty(node, OpenAPIConstants.PROP_MAX_LENGTH, model.getMaxLength());
            JsonUtil.intProperty(node, OpenAPIConstants.PROP_MIN_LENGTH, model.getMinLength());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_PATTERN, model.getPattern());
            JsonUtil.intProperty(node, OpenAPIConstants.PROP_MAX_ITEMS, model.getMaxItems());
            JsonUtil.intProperty(node, OpenAPIConstants.PROP_MIN_ITEMS, model.getMinItems());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_UNIQUE_ITEMS, model.getUniqueItems());
            JsonUtil.intProperty(node, OpenAPIConstants.PROP_MAX_PROPERTIES, model.getMaxProperties());
            JsonUtil.intProperty(node, OpenAPIConstants.PROP_MIN_PROPERTIES, model.getMinProperties());
            writeStringArray(node, model.getRequired(), OpenAPIConstants.PROP_REQUIRED);
            writeObjectArray(node, model.getEnumeration(), OpenAPIConstants.PROP_ENUM);
            JsonUtil.enumProperty(node, OpenAPIConstants.PROP_TYPE, model.getType());
            writeSchema(node, model.getItems(), OpenAPIConstants.PROP_ITEMS);
            writeSchemaList(node, model.getAllOf(), OpenAPIConstants.PROP_ALL_OF);
            writeSchemas(node, model.getProperties(), OpenAPIConstants.PROP_PROPERTIES);
            if (model.getAdditionalPropertiesBoolean() != null) {
                JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_ADDITIONAL_PROPERTIES, (Boolean) model.getAdditionalPropertiesBoolean());
            } else {
                writeSchema(node, model.getAdditionalPropertiesSchema(), OpenAPIConstants.PROP_ADDITIONAL_PROPERTIES);
            }
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_READ_ONLY, model.getReadOnly());
            writeXML(node, model.getXml());
            writeExternalDocumentation(node, model.getExternalDocs());
            writeObject(node, OpenAPIConstants.PROP_EXAMPLE, model.getExample());
            writeSchemaList(node, model.getOneOf(), OpenAPIConstants.PROP_ONE_OF);
            writeSchemaList(node, model.getAnyOf(), OpenAPIConstants.PROP_ANY_OF);
            writeSchema(node, model.getNot(), OpenAPIConstants.PROP_NOT);
            writeDiscriminator(node, model.getDiscriminator());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_NULLABLE, model.getNullable());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_WRITE_ONLY, model.getWriteOnly());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_DEPRECATED, model.getDeprecated());
            writeExtensions(node, model);
        }

    }

    /**
     * Writes a {@link XML} object to the JSON tree.
     *
     * @param parent
     * @param model
     */
    private static void writeXML(ObjectNode parent, XML model) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(OpenAPIConstants.PROP_XML);
        writeXMLToNode(node, model);
    }

    /**
     * Writes a {@link XML} object to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeXMLToNode(ObjectNode node, XML model) {
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_NAME, model.getName());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_NAMESPACE, model.getNamespace());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_PREFIX, model.getPrefix());
        JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_ATTRIBUTE, model.getAttribute());
        JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_WRAPPED, model.getWrapped());
        writeExtensions(node, model);
    }

    /**
     * Writes a {@link Discriminator} object to the JSON tree.
     *
     * @param parent
     * @param model
     */
    private static void writeDiscriminator(ObjectNode parent, Discriminator model) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(OpenAPIConstants.PROP_DISCRIMINATOR);
        writeDiscriminatorToNode(node, model);
    }

    /**
     * Writes a {@link Discriminator} object to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeDiscriminatorToNode(ObjectNode node, Discriminator model) {
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_PROPERTY_NAME, model.getPropertyName());
        writeStringMap(node, model.getMapping(), OpenAPIConstants.PROP_MAPPING);
    }

    /**
     * Writes a map of {@link Encoding} objects to the JSON tree.
     *
     * @param parent
     * @param models
     */
    private static void writeEncodings(ObjectNode parent, Map<String, Encoding> models) {
        if (models == null) {
            return;
        }
        ObjectNode node = parent.putObject(OpenAPIConstants.PROP_ENCODING);
        for (String name : models.keySet()) {
            Encoding encoding = models.get(name);
            writeEncoding(node, encoding, name);
        }
    }

    /**
     * Writes a {@link Encoding} object to the JSON tree.
     *
     * @param parent
     * @param model
     * @param name
     */
    private static void writeEncoding(ObjectNode parent, Encoding model, String name) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(name);
        writeEncodingToNode(node, model);
    }

    /**
     * Writes a {@link Encoding} object to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeEncodingToNode(ObjectNode node, Encoding model) {
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_CONTENT_TYPE, model.getContentType());
        writeHeaders(node, model.getHeaders());
        JsonUtil.enumProperty(node, OpenAPIConstants.PROP_STYLE, model.getStyle());
        JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_EXPLODE, model.getExplode());
        JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_ALLOW_RESERVED, model.getAllowReserved());
        writeExtensions(node, model);
    }

    /**
     * Writes a {@link APIResponses} map to the JSON tree.
     *
     * @param parent
     * @param model
     */
    private static void writeAPIResponses(ObjectNode parent, APIResponses model) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(OpenAPIConstants.PROP_RESPONSES);
        writeAPIResponsesToNode(node, model);
    }

    /**
     * Writes a {@link APIResponses} object to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeAPIResponsesToNode(ObjectNode node, APIResponses model) {
        if (model.getAPIResponses() != null) {
            for (String name : model.getAPIResponses()
                .keySet()) {
                writeAPIResponse(node, model.getAPIResponse(name), name);
            }
        }
    }

    /**
     * Writes a {@link APIResponse} object to the JSON tree.
     *
     * @param parent
     * @param model
     * @param name
     */
    private static void writeAPIResponse(ObjectNode parent, APIResponse model, String name) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(name);
        writeAPIResponseToNode(node, model);
    }

    /**
     * Writes a {@link APIResponse} object to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeAPIResponseToNode(ObjectNode node, APIResponse model) {
        if (model.getRef() != null) {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_$REF, model.getRef());
        } else {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
            writeHeaders(node, model.getHeaders());
            writeContent(node, model.getContent());
            writeLinks(node, model.getLinks());
            writeExtensions(node, model);
        }
    }

    /**
     * Writes a list of {@link SecurityRequirement} to the JSON tree.
     *
     * @param parent
     * @param models
     */
    private static void writeSecurityRequirements(ObjectNode parent, List<SecurityRequirement> models) {
        if (models == null) {
            return;
        }
        ArrayNode node = parent.putArray(OpenAPIConstants.PROP_SECURITY);
        for (SecurityRequirement securityRequirement : models) {
            ObjectNode secNode = node.addObject();
            writeSecurityRequirementToNode(secNode, securityRequirement);
        }
    }

    /**
     * Writes a {@link SecurityRequirement} to the given JS node.
     *
     * @param node
     * @param model
     */
    private static void writeSecurityRequirementToNode(ObjectNode node, SecurityRequirement model) {
        if (model == null) {
            return;
        }
        if (model.getSchemes() != null) {
            for (String name : model.getSchemes()
                .keySet()) {
                List<String> scopes = model.getScheme(name);
                writeStringArray(node, scopes, name);
            }
        }
    }

    /**
     * Writes a list of {@link Parameter} to the JSON tree.
     *
     * @param parent
     * @param models
     */
    private static void writeParameterList(ObjectNode parent, List<Parameter> models) {
        if (models == null) {
            return;
        }
        ArrayNode node = parent.putArray(OpenAPIConstants.PROP_PARAMETERS);
        for (Parameter model : models) {
            ObjectNode paramNode = node.addObject();
            writeParameterToNode(paramNode, model);
        }
    }

    /**
     * Writes a {@link Parameter} to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeParameterToNode(ObjectNode node, Parameter model) {
        if (model.getRef() != null) {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_$REF, model.getRef());
        } else {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_NAME, model.getName());
            JsonUtil.enumProperty(node, OpenAPIConstants.PROP_IN, model.getIn());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_REQUIRED, model.getRequired());
            writeSchema(node, model.getSchema(), OpenAPIConstants.PROP_SCHEMA);
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_ALLOW_EMPTY_VALUE, model.getAllowEmptyValue());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_DEPRECATED, model.getDeprecated());
            JsonUtil.enumProperty(node, OpenAPIConstants.PROP_STYLE, model.getStyle());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_EXPLODE, model.getExplode());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_ALLOW_RESERVED, model.getAllowReserved());
            writeObject(node, OpenAPIConstants.PROP_EXAMPLE, model.getExample());
            writeExamples(node, model.getExamples());
            writeContent(node, model.getContent());
            writeExtensions(node, model);
        }
    }

    /**
     * Writes a {@link ServerVariable} to the JSON tree.
     *
     * @param parent
     * @param components
     */
    private static void writeComponents(ObjectNode parent, Components components) {
        if (components == null) {
            return;
        }
        ObjectNode node = parent.putObject(OpenAPIConstants.PROP_COMPONENTS);
        writeComponentsToNode(node, components);
    }

    /**
     * Writes a {@link Components} object to the given JSON node.
     *
     * @param node
     * @param components
     */
    private static void writeComponentsToNode(ObjectNode node, Components components) {
        writeSchemas(node, components.getSchemas());
        writeResponses(node, components.getResponses());
        writeParameters(node, components.getParameters());
        writeExamples(node, components.getExamples());
        writeRequestBodies(node, components.getRequestBodies());
        writeHeaders(node, components.getHeaders());
        writeSecuritySchemes(node, components.getSecuritySchemes());
        writeLinks(node, components.getLinks());
        writeCallbacks(node, components.getCallbacks());
        writeExtensions(node, components);
    }

    /**
     * Writes a map of {@link Schema} to the JSON tree.
     *
     * @param parent
     * @param schemas
     */
    private static void writeSchemas(ObjectNode parent, Map<String, Schema> schemas) {
        writeSchemas(parent, schemas, OpenAPIConstants.PROP_SCHEMAS);
    }

    /**
     * Writes a map of {@link Schema} to the JSON tree.
     *
     * @param parent
     * @param schemas
     */
    private static void writeSchemas(ObjectNode parent, Map<String, Schema> schemas, String propertyName) {
        if (schemas == null) {
            return;
        }
        ObjectNode schemasNode = parent.putObject(propertyName);
        for (String schemaName : schemas.keySet()) {
            writeSchema(schemasNode, schemas.get(schemaName), schemaName);
        }
    }

    /**
     * Writes a list of {@link Schema} to the JSON tree.
     *
     * @param parent
     * @param models
     * @param propertyName
     */
    private static void writeSchemaList(ObjectNode parent, List<Schema> models, String propertyName) {
        if (models == null) {
            return;
        }
        ArrayNode schemasNode = parent.putArray(propertyName);
        for (Schema schema : models) {
            writeSchemaToNode(schemasNode.addObject(), schema);
        }
    }

    /**
     * Writes a map of {@link APIResponse} to the JSON tree.
     *
     * @param parent
     * @param responses
     */
    private static void writeResponses(ObjectNode parent, Map<String, APIResponse> responses) {
        if (responses == null) {
            return;
        }
        ObjectNode responsesNode = parent.putObject(OpenAPIConstants.PROP_RESPONSES);
        for (String responseName : responses.keySet()) {
            writeAPIResponse(responsesNode, responses.get(responseName), responseName);
        }
    }

    /**
     * Writes a map of {@link Parameter} to the JSON tree.
     *
     * @param parent
     * @param parameters
     */
    private static void writeParameters(ObjectNode parent, Map<String, Parameter> parameters) {
        if (parameters == null) {
            return;
        }
        ObjectNode parametersNode = parent.putObject(OpenAPIConstants.PROP_PARAMETERS);
        for (String parameterName : parameters.keySet()) {
            writeParameter(parametersNode, parameters.get(parameterName), parameterName);
        }
    }

    /**
     * Writes a {@link Parameter} object to the JSON tree.
     *
     * @param parent
     * @param model
     * @param name
     */
    private static void writeParameter(ObjectNode parent, Parameter model, String name) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(name);
        writeParameterToNode(node, model);
    }

    /**
     * Writes a map of {@link Example} to the JSON tree.
     *
     * @param parent
     * @param examples
     */
    private static void writeExamples(ObjectNode parent, Map<String, Example> examples) {
        if (examples == null) {
            return;
        }
        ObjectNode examplesNode = parent.putObject(OpenAPIConstants.PROP_EXAMPLES);
        for (String exampleName : examples.keySet()) {
            writeExample(examplesNode, examples.get(exampleName), exampleName);
        }
    }

    /**
     * Writes a {@link Example} object to the JSON tree.
     *
     * @param parent
     * @param model
     * @param name
     */
    private static void writeExample(ObjectNode parent, Example model, String name) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(name);
        writeExampleToNode(node, model);
    }

    /**
     * Writes a {@link Example} object to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeExampleToNode(ObjectNode node, Example model) {
        if (model.getRef() != null) {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_$REF, model.getRef());
        } else {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_SUMMARY, model.getSummary());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
            writeObject(node, OpenAPIConstants.PROP_VALUE, model.getValue());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_EXTERNAL_VALUE, model.getExternalValue());
            writeExtensions(node, model);
        }
    }

    /**
     * Writes a map of {@link RequestBody} to the JSON tree.
     *
     * @param parent
     * @param requestBodies
     */
    private static void writeRequestBodies(ObjectNode parent, Map<String, RequestBody> requestBodies) {
        if (requestBodies == null) {
            return;
        }
        ObjectNode requestBodiesNode = parent.putObject(OpenAPIConstants.PROP_REQUEST_BODIES);
        for (String requestBodyName : requestBodies.keySet()) {
            writeRequestBody(requestBodiesNode, requestBodies.get(requestBodyName), requestBodyName);
        }
    }

    /**
     * Writes a {@link RequestBody} object to the JSON tree.
     *
     * @param parent
     * @param model
     * @param name
     */
    private static void writeRequestBody(ObjectNode parent, RequestBody model, String name) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(name);
        writeRequestBodyToNode(node, model);
    }

    /**
     * Writes a map of {@link Header} to the JSON tree.
     *
     * @param parent
     * @param headers
     */
    private static void writeHeaders(ObjectNode parent, Map<String, Header> headers) {
        if (headers == null) {
            return;
        }
        ObjectNode headersNode = parent.putObject(OpenAPIConstants.PROP_HEADERS);
        for (String headerName : headers.keySet()) {
            writeHeader(headersNode, headers.get(headerName), headerName);
        }
    }

    /**
     * Writes a {@link Header} object to the JSON tree.
     *
     * @param parent
     * @param model
     * @param name
     */
    private static void writeHeader(ObjectNode parent, Header model, String name) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(name);
        writeHeaderToNode(node, model);
    }

    /**
     * Writes a {@link Header} object to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeHeaderToNode(ObjectNode node, Header model) {
        if (model.getRef() != null) {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_$REF, model.getRef());
        } else {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_REQUIRED, model.getRequired());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_DEPRECATED, model.getDeprecated());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_ALLOW_EMPTY_VALUE, model.getAllowEmptyValue());
            JsonUtil.enumProperty(node, OpenAPIConstants.PROP_STYLE, model.getStyle());
            JsonUtil.booleanProperty(node, OpenAPIConstants.PROP_EXPLODE, model.getExplode());
            writeSchema(node, model.getSchema(), OpenAPIConstants.PROP_SCHEMA);
            writeObject(node, OpenAPIConstants.PROP_EXAMPLE, model.getExample());
            writeExamples(node, model.getExamples());
            writeContent(node, model.getContent());
            writeExtensions(node, model);
        }
    }

    /**
     * Writes a map of {@link SecurityScheme} to the JSON tree.
     *
     * @param parent
     * @param securitySchemes
     */
    private static void writeSecuritySchemes(ObjectNode parent, Map<String, SecurityScheme> securitySchemes) {
        if (securitySchemes == null) {
            return;
        }
        ObjectNode securitySchemesNode = parent.putObject(OpenAPIConstants.PROP_SECURITY_SCHEMES);
        for (String securitySchemeName : securitySchemes.keySet()) {
            writeSecurityScheme(securitySchemesNode, securitySchemes.get(securitySchemeName), securitySchemeName);
        }
    }

    /**
     * Writes a {@link SecurityScheme} object to the JSON tree.
     *
     * @param parent
     * @param model
     * @param name
     */
    private static void writeSecurityScheme(ObjectNode parent, SecurityScheme model, String name) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(name);
        writeSecuritySchemeToNode(node, model);
    }

    /**
     * Writes a {@link SecurityScheme} object to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeSecuritySchemeToNode(ObjectNode node, SecurityScheme model) {
        if (model.getRef() != null) {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_$REF, model.getRef());
        } else {
            JsonUtil.enumProperty(node, OpenAPIConstants.PROP_TYPE, model.getType());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_NAME, model.getName());
            JsonUtil.enumProperty(node, OpenAPIConstants.PROP_IN, model.getIn());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_SCHEME, model.getScheme());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_BEARER_FORMAT, model.getBearerFormat());
            writeOAuthFlows(node, model.getFlows());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_OPEN_ID_CONNECT_URL, model.getOpenIdConnectUrl());
            writeExtensions(node, model);
        }
    }

    /**
     * Writes a {@link OAuthFlows} object to the JSON tree.
     *
     * @param parent
     * @param model
     */
    private static void writeOAuthFlows(ObjectNode parent, OAuthFlows model) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(OpenAPIConstants.PROP_FLOWS);
        writeOAuthFlowsToNode(node, model);
    }

    /**
     * Writes a {@link OAuthFlows} object to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeOAuthFlowsToNode(ObjectNode node, OAuthFlows model) {
        writeOAuthFlow(node, model.getImplicit(), OpenAPIConstants.PROP_IMPLICIT);
        writeOAuthFlow(node, model.getPassword(), OpenAPIConstants.PROP_PASSWORD);
        writeOAuthFlow(node, model.getClientCredentials(), OpenAPIConstants.PROP_CLIENT_CREDENTIALS);
        writeOAuthFlow(node, model.getAuthorizationCode(), OpenAPIConstants.PROP_AUTHORIZATION_CODE);
        writeExtensions(node, model);
    }

    /**
     * Writes a {@link OAuthFlow} object to the JSON tree.
     *
     * @param parent
     * @param model
     * @param name
     */
    private static void writeOAuthFlow(ObjectNode parent, OAuthFlow model, String name) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(name);
        writeOAuthFlowToNode(node, model);
    }

    /**
     * Writes a {@link OAuthFlow} object to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeOAuthFlowToNode(ObjectNode node, OAuthFlow model) {
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_AUTHORIZATION_URL, model.getAuthorizationUrl());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_TOKEN_URL, model.getTokenUrl());
        JsonUtil.stringProperty(node, OpenAPIConstants.PROP_REFRESH_URL, model.getRefreshUrl());
        if (model.getScopes() != null) {
            writeStringMap(
                node, model.getScopes()
                    .getScopes(), OpenAPIConstants.PROP_SCOPES
            );
            writeExtensions(node, model);
        }
    }

    /**
     * Writes a {@link Scopes} object to the given JSON node.
     *
     * @param node
     * @param scopes
     */
    private static void writeScopesToNode(ObjectNode node, Scopes scopes) {
        if (scopes.getScopes() != null) {
            for (Entry<String, String> entry : scopes.getScopes()
                .entrySet()) {
                node.put(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Writes a map of {@link Link} to the JSON tree.
     *
     * @param parent
     * @param links
     */
    private static void writeLinks(ObjectNode parent, Map<String, Link> links) {
        if (links == null) {
            return;
        }
        ObjectNode linksNode = parent.putObject(OpenAPIConstants.PROP_LINKS);
        for (String linkName : links.keySet()) {
            writeLink(linksNode, links.get(linkName), linkName);
        }
    }

    /**
     * Writes a {@link Link} object to the JSON tree.
     *
     * @param parent
     * @param model
     * @param name
     */
    private static void writeLink(ObjectNode parent, Link model, String name) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(name);
        writeLinkToNode(node, model);
    }

    /**
     * Writes a {@link Link} object to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeLinkToNode(ObjectNode node, Link model) {
        if (model.getRef() != null) {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_$REF, model.getRef());
        } else {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_OPERATION_REF, model.getOperationRef());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_OPERATION_ID, model.getOperationId());
            writeLinkParameters(node, model.getParameters());
            writeObject(node, OpenAPIConstants.PROP_REQUEST_BODY, model.getRequestBody());
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_DESCRIPTION, model.getDescription());
            writeServer(node, model.getServer());
            writeExtensions(node, model);
        }
    }

    /**
     * Writes the link parameters to the given node.
     *
     * @param parent
     * @param parameters
     */
    private static void writeLinkParameters(ObjectNode parent, Map<String, Object> parameters) {
        if (parameters == null) {
            return;
        }
        ObjectNode node = parent.putObject(OpenAPIConstants.PROP_PARAMETERS);
        for (String name : parameters.keySet()) {
            writeObject(node, name, parameters.get(name));
        }
    }

    /**
     * Writes a {@link Server} object to the JSON tree.
     *
     * @param parent
     * @param model
     */
    private static void writeServer(ObjectNode parent, Server model) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(OpenAPIConstants.PROP_SERVER);
        writeServerToNode(node, model);
    }

    /**
     * Writes a map of {@link Callback} to the JSON tree.
     *
     * @param parent
     * @param callbacks
     */
    private static void writeCallbacks(ObjectNode parent, Map<String, Callback> callbacks) {
        if (callbacks == null) {
            return;
        }
        ObjectNode callbacksNode = parent.putObject(OpenAPIConstants.PROP_CALLBACKS);
        for (String callbackName : callbacks.keySet()) {
            writeCallback(callbacksNode, callbacks.get(callbackName), callbackName);
        }
    }

    /**
     * Writes a {@link Callback} object to the JSON tree.
     *
     * @param parent
     * @param model
     * @param name
     */
    private static void writeCallback(ObjectNode parent, Callback model, String name) {
        if (model == null) {
            return;
        }
        ObjectNode node = parent.putObject(name);
        writeCallbackToNode(node, model);
    }

    /**
     * Writes a {@link Callback} object to the given JSON node.
     *
     * @param node
     * @param model
     */
    private static void writeCallbackToNode(ObjectNode node, Callback model) {
        if (model.getRef() != null) {
            JsonUtil.stringProperty(node, OpenAPIConstants.PROP_$REF, model.getRef());
        } else {
            if (model.getPathItems() != null) {
                for (String pathItemName : model.getPathItems()
                    .keySet()) {
                    writePathItem(node, model.getPathItem(pathItemName), pathItemName);
                }
            }
            writeExtensions(node, model);
        }
    }

    /**
     * Writes extensions to the JSON tree.
     *
     * @param node
     * @param model
     */
    private static void writeExtensions(ObjectNode node, Extensible<?> model) {
        Map<String, Object> extensions = model.getExtensions();
        if (extensions == null || extensions.isEmpty()) {
            return;
        }
        for (Entry<String, Object> entry : extensions.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            writeObject(node, key, value);
        }
    }

    /**
     * Writes an array of strings to the parent node.
     *
     * @param parent
     * @param models
     * @param propertyName
     */
    private static void writeStringArray(ObjectNode parent, List<String> models, String propertyName) {
        if (models == null) {
            return;
        }
        ArrayNode node = parent.putArray(propertyName);
        for (String model : models) {
            node.add(model);
        }
    }

    /**
     * Writes an array of objects to the parent node.
     *
     * @param parent
     * @param models
     * @param propertyName
     */
    private static void writeObjectArray(ObjectNode parent, List<Object> models, String propertyName) {
        if (models == null) {
            return;
        }
        ArrayNode node = parent.putArray(propertyName);
        for (Object model : models) {
            addObject(node, model);
        }
    }

    /**
     * Writes a map of strings to the parent node.
     *
     * @param parent
     * @param models
     * @param propertyName
     */
    private static void writeStringMap(ObjectNode parent, Map<String, String> models, String propertyName) {
        if (models == null) {
            return;
        }
        ObjectNode node = parent.putObject(propertyName);
        for (String name : models.keySet()) {
            String value = models.get(name);
            node.put(name, value);
        }
    }

    /**
     * @param node
     *            ObjectNode
     * @param key
     *            String
     * @param value
     *            Object
     */
    @SuppressWarnings("unchecked")
    private static void writeObject(ObjectNode node, String key, Object value) {
        if (value == null) {
            return;
        }
        if (value instanceof String) {
            node.put(key, (String) value);
        } else if (value instanceof JsonNode) {
            node.set(key, (JsonNode) value);
        } else if (value instanceof BigDecimal) {
            node.put(key, (BigDecimal) value);
        } else if (value instanceof BigInteger) {
            node.put(key, new BigDecimal((BigInteger) value));
        } else if (value instanceof Boolean) {
            node.put(key, (Boolean) value);
        } else if (value instanceof Double) {
            node.put(key, (Double) value);
        } else if (value instanceof Float) {
            node.put(key, (Float) value);
        } else if (value instanceof Integer) {
            node.put(key, (Integer) value);
        } else if (value instanceof Long) {
            node.put(key, (Long) value);
        } else if (value instanceof List) {
            ArrayNode array = node.putArray(key);
            List<Object> values = (List<Object>) value;
            for (Object valueItem : values) {
                addObject(array, valueItem);
            }
        } else if (value instanceof Map) {
            ObjectNode objNode = node.putObject(key);
            Map<String, Object> values = (Map<String, Object>) value;
            for (Entry<String, Object> entry : values.entrySet()) {
                String propertyName = entry.getKey();
                writeObject(objNode, propertyName, entry.getValue());
            }
        } else {
            node.put(key, (String) null);
        }
    }

    /**
     * Adds an object to an array.
     *
     * @param node
     * @param value
     */
    @SuppressWarnings("unchecked")
    private static void addObject(ArrayNode node, Object value) {
        if (value instanceof String) {
            node.add((String) value);
        } else if (value instanceof JsonNode) {
            node.add((JsonNode) value);
        } else if (value instanceof BigDecimal) {
            node.add((BigDecimal) value);
        } else if (value instanceof BigInteger) {
            node.add(new BigDecimal((BigInteger) value));
        } else if (value instanceof Boolean) {
            node.add((Boolean) value);
        } else if (value instanceof Double) {
            node.add((Double) value);
        } else if (value instanceof Float) {
            node.add((Float) value);
        } else if (value instanceof Integer) {
            node.add((Integer) value);
        } else if (value instanceof Long) {
            node.add((Long) value);
        } else if (value instanceof List) {
            ArrayNode array = node.addArray();
            List<Object> values = (List<Object>) value;
            for (Object valueItem : values) {
                addObject(array, valueItem);
            }
        } else if (value instanceof Map) {
            ObjectNode objNode = node.addObject();
            Map<String, Object> values = (Map<String, Object>) value;
            for (Entry<String, Object> entry : values.entrySet()) {
                String propertyName = entry.getKey();
                writeObject(objNode, propertyName, entry.getValue());
            }
        } else {
            node.add((String) null);
        }
    }

}
