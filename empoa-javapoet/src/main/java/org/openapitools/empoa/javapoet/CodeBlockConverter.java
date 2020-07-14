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
package org.openapitools.empoa.javapoet;

import java.util.ArrayList;
import java.util.List;

import com.squareup.javapoet.CodeBlock;

public class CodeBlockConverter {

    public static CodeBlock createComponents(org.eclipse.microprofile.openapi.models.Components components) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createComponents()"));
        if (components.getSchemas() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.media.Schema> entry : components.getSchemas()
                .entrySet()) {
                list.add(CodeBlock.of("addSchema(\n$S, $L\n)", entry.getKey(), createSchema(entry.getValue())));
            }
        }
        if (components.getResponses() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.responses.APIResponse> entry : components.getResponses()
                .entrySet()) {
                list.add(CodeBlock.of("addResponse(\n$S, $L\n)", entry.getKey(), createAPIResponse(entry.getValue())));
            }
        }
        if (components.getParameters() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.parameters.Parameter> entry : components.getParameters()
                .entrySet()) {
                list.add(CodeBlock.of("addParameter(\n$S, $L\n)", entry.getKey(), createParameter(entry.getValue())));
            }
        }
        if (components.getExamples() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.examples.Example> entry : components.getExamples()
                .entrySet()) {
                list.add(CodeBlock.of("addExample(\n$S, $L\n)", entry.getKey(), createExample(entry.getValue())));
            }
        }
        if (components.getRequestBodies() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.parameters.RequestBody> entry : components.getRequestBodies()
                .entrySet()) {
                list.add(CodeBlock.of("addRequestBody(\n$S, $L\n)", entry.getKey(), createRequestBody(entry.getValue())));
            }
        }
        if (components.getHeaders() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.headers.Header> entry : components.getHeaders()
                .entrySet()) {
                list.add(CodeBlock.of("addHeader(\n$S, $L\n)", entry.getKey(), createHeader(entry.getValue())));
            }
        }
        if (components.getSecuritySchemes() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.security.SecurityScheme> entry : components.getSecuritySchemes()
                .entrySet()) {
                list.add(CodeBlock.of("addSecurityScheme(\n$S, $L\n)", entry.getKey(), createSecurityScheme(entry.getValue())));
            }
        }
        if (components.getLinks() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.links.Link> entry : components.getLinks()
                .entrySet()) {
                list.add(CodeBlock.of("addLink(\n$S, $L\n)", entry.getKey(), createLink(entry.getValue())));
            }
        }
        if (components.getCallbacks() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.callbacks.Callback> entry : components.getCallbacks()
                .entrySet()) {
                list.add(CodeBlock.of("addCallback(\n$S, $L\n)", entry.getKey(), createCallback(entry.getValue())));
            }
        }
        if (components.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : components.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createExternalDocumentation(org.eclipse.microprofile.openapi.models.ExternalDocumentation externalDocumentation) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createExternalDocumentation()"));
        if (externalDocumentation.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", externalDocumentation.getDescription()));
        }
        if (externalDocumentation.getUrl() != null) {
            list.add(CodeBlock.of("url($S)", externalDocumentation.getUrl()));
        }
        if (externalDocumentation.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : externalDocumentation.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createOpenAPI(org.eclipse.microprofile.openapi.models.OpenAPI openAPI) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createOpenAPI()"));
        if (openAPI.getOpenapi() != null) {
            list.add(CodeBlock.of("openapi($S)", openAPI.getOpenapi()));
        }
        if (openAPI.getInfo() != null) {
            list.add(CodeBlock.of("info(\n$L\n)", createInfo(openAPI.getInfo())));
        }
        if (openAPI.getExternalDocs() != null) {
            list.add(CodeBlock.of("externalDocs(\n$L\n)", createExternalDocumentation(openAPI.getExternalDocs())));
        }
        if (openAPI.getServers() != null) {
            for (org.eclipse.microprofile.openapi.models.servers.Server item : openAPI.getServers()) {
                list.add(CodeBlock.of("addServer(\n$L\n)", createServer(item)));
            }
        }
        if (openAPI.getSecurity() != null) {
            for (org.eclipse.microprofile.openapi.models.security.SecurityRequirement item : openAPI.getSecurity()) {
                list.add(CodeBlock.of("addSecurityRequirement(\n$L\n)", createSecurityRequirement(item)));
            }
        }
        if (openAPI.getTags() != null) {
            for (org.eclipse.microprofile.openapi.models.tags.Tag item : openAPI.getTags()) {
                list.add(CodeBlock.of("addTag(\n$L\n)", createTag(item)));
            }
        }
        if (openAPI.getPaths() != null) {
            list.add(CodeBlock.of("paths(\n$L\n)", createPaths(openAPI.getPaths())));
        }
        if (openAPI.getComponents() != null) {
            list.add(CodeBlock.of("components(\n$L\n)", createComponents(openAPI.getComponents())));
        }
        if (openAPI.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : openAPI.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createOperation(org.eclipse.microprofile.openapi.models.Operation operation) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createOperation()"));
        if (operation.getTags() != null) {
            for (String item : operation.getTags()) {
                list.add(CodeBlock.of("addTag($S)", item));
            }
        }
        if (operation.getSummary() != null) {
            list.add(CodeBlock.of("summary($S)", operation.getSummary()));
        }
        if (operation.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", operation.getDescription()));
        }
        if (operation.getExternalDocs() != null) {
            list.add(CodeBlock.of("externalDocs(\n$L\n)", createExternalDocumentation(operation.getExternalDocs())));
        }
        if (operation.getOperationId() != null) {
            list.add(CodeBlock.of("operationId($S)", operation.getOperationId()));
        }
        if (operation.getParameters() != null) {
            for (org.eclipse.microprofile.openapi.models.parameters.Parameter item : operation.getParameters()) {
                list.add(CodeBlock.of("addParameter(\n$L\n)", createParameter(item)));
            }
        }
        if (operation.getRequestBody() != null) {
            list.add(CodeBlock.of("requestBody(\n$L\n)", createRequestBody(operation.getRequestBody())));
        }
        if (operation.getResponses() != null) {
            list.add(CodeBlock.of("responses(\n$L\n)", createAPIResponses(operation.getResponses())));
        }
        if (operation.getCallbacks() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.callbacks.Callback> entry : operation.getCallbacks()
                .entrySet()) {
                list.add(CodeBlock.of("addCallback(\n$S, $L\n)", entry.getKey(), createCallback(entry.getValue())));
            }
        }
        if (operation.getDeprecated() != null) {
            list.add(CodeBlock.of("deprecated($L)", operation.getDeprecated()));
        }
        if (operation.getSecurity() != null) {
            for (org.eclipse.microprofile.openapi.models.security.SecurityRequirement item : operation.getSecurity()) {
                list.add(CodeBlock.of("addSecurityRequirement(\n$L\n)", createSecurityRequirement(item)));
            }
        }
        if (operation.getServers() != null) {
            for (org.eclipse.microprofile.openapi.models.servers.Server item : operation.getServers()) {
                list.add(CodeBlock.of("addServer(\n$L\n)", createServer(item)));
            }
        }
        if (operation.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : operation.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createPathItem(org.eclipse.microprofile.openapi.models.PathItem pathItem) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createPathItem()"));
        if (pathItem.getRef() != null) {
            list.add(CodeBlock.of("ref($S)", pathItem.getRef()));
        }
        if (pathItem.getSummary() != null) {
            list.add(CodeBlock.of("summary($S)", pathItem.getSummary()));
        }
        if (pathItem.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", pathItem.getDescription()));
        }
        if (pathItem.getGET() != null) {
            list.add(CodeBlock.of("GET(\n$L\n)", createOperation(pathItem.getGET())));
        }
        if (pathItem.getPUT() != null) {
            list.add(CodeBlock.of("PUT(\n$L\n)", createOperation(pathItem.getPUT())));
        }
        if (pathItem.getPOST() != null) {
            list.add(CodeBlock.of("POST(\n$L\n)", createOperation(pathItem.getPOST())));
        }
        if (pathItem.getDELETE() != null) {
            list.add(CodeBlock.of("DELETE(\n$L\n)", createOperation(pathItem.getDELETE())));
        }
        if (pathItem.getOPTIONS() != null) {
            list.add(CodeBlock.of("OPTIONS(\n$L\n)", createOperation(pathItem.getOPTIONS())));
        }
        if (pathItem.getHEAD() != null) {
            list.add(CodeBlock.of("HEAD(\n$L\n)", createOperation(pathItem.getHEAD())));
        }
        if (pathItem.getPATCH() != null) {
            list.add(CodeBlock.of("PATCH(\n$L\n)", createOperation(pathItem.getPATCH())));
        }
        if (pathItem.getTRACE() != null) {
            list.add(CodeBlock.of("TRACE(\n$L\n)", createOperation(pathItem.getTRACE())));
        }
        if (pathItem.getServers() != null) {
            for (org.eclipse.microprofile.openapi.models.servers.Server item : pathItem.getServers()) {
                list.add(CodeBlock.of("addServer(\n$L\n)", createServer(item)));
            }
        }
        if (pathItem.getParameters() != null) {
            for (org.eclipse.microprofile.openapi.models.parameters.Parameter item : pathItem.getParameters()) {
                list.add(CodeBlock.of("addParameter(\n$L\n)", createParameter(item)));
            }
        }
        if (pathItem.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : pathItem.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createPaths(org.eclipse.microprofile.openapi.models.Paths paths) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createPaths()"));
        if (paths.getPathItems() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.PathItem> entry : paths.getPathItems()
                .entrySet()) {
                list.add(CodeBlock.of("addPathItem(\n$S, $L\n)", entry.getKey(), createPathItem(entry.getValue())));
            }
        }
        if (paths.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : paths.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createCallback(org.eclipse.microprofile.openapi.models.callbacks.Callback callback) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createCallback()"));
        if (callback.getRef() != null) {
            list.add(CodeBlock.of("ref($S)", callback.getRef()));
        }
        if (callback.getPathItems() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.PathItem> entry : callback.getPathItems()
                .entrySet()) {
                list.add(CodeBlock.of("addPathItem(\n$S, $L\n)", entry.getKey(), createPathItem(entry.getValue())));
            }
        }
        if (callback.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : callback.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createExample(org.eclipse.microprofile.openapi.models.examples.Example example) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createExample()"));
        if (example.getRef() != null) {
            list.add(CodeBlock.of("ref($S)", example.getRef()));
        }
        if (example.getSummary() != null) {
            list.add(CodeBlock.of("summary($S)", example.getSummary()));
        }
        if (example.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", example.getDescription()));
        }
        if (example.getValue() != null) {
            if (example.getValue() instanceof String) {
                list.add(CodeBlock.of("value($S)", example.getValue()));
            } else {
                list.add(CodeBlock.of("value($L)", example.getValue()));
            }
        }
        if (example.getExternalValue() != null) {
            list.add(CodeBlock.of("externalValue($S)", example.getExternalValue()));
        }
        if (example.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : example.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createHeader(org.eclipse.microprofile.openapi.models.headers.Header header) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createHeader()"));
        if (header.getRef() != null) {
            list.add(CodeBlock.of("ref($S)", header.getRef()));
        }
        if (header.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", header.getDescription()));
        }
        if (header.getRequired() != null) {
            list.add(CodeBlock.of("required($L)", header.getRequired()));
        }
        if (header.getDeprecated() != null) {
            list.add(CodeBlock.of("deprecated($L)", header.getDeprecated()));
        }
        if (header.getAllowEmptyValue() != null) {
            list.add(CodeBlock.of("allowEmptyValue($L)", header.getAllowEmptyValue()));
        }
        if (header.getStyle() != null) {
            list.add(
                CodeBlock.of(
                    "style($T.$L)", org.eclipse.microprofile.openapi.models.headers.Header.Style.class, header.getStyle()
                        .name()
                )
            );
        }
        if (header.getExplode() != null) {
            list.add(CodeBlock.of("explode($L)", header.getExplode()));
        }
        if (header.getSchema() != null) {
            list.add(CodeBlock.of("schema(\n$L\n)", createSchema(header.getSchema())));
        }
        if (header.getExamples() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.examples.Example> entry : header.getExamples()
                .entrySet()) {
                list.add(CodeBlock.of("addExample(\n$S, $L\n)", entry.getKey(), createExample(entry.getValue())));
            }
        }
        if (header.getExample() != null) {
            if (header.getExample() instanceof String) {
                list.add(CodeBlock.of("example($S)", header.getExample()));
            } else {
                list.add(CodeBlock.of("example($L)", header.getExample()));
            }
        }
        if (header.getContent() != null) {
            list.add(CodeBlock.of("content(\n$L\n)", createContent(header.getContent())));
        }
        if (header.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : header.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createContact(org.eclipse.microprofile.openapi.models.info.Contact contact) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createContact()"));
        if (contact.getName() != null) {
            list.add(CodeBlock.of("name($S)", contact.getName()));
        }
        if (contact.getUrl() != null) {
            list.add(CodeBlock.of("url($S)", contact.getUrl()));
        }
        if (contact.getEmail() != null) {
            list.add(CodeBlock.of("email($S)", contact.getEmail()));
        }
        if (contact.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : contact.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createInfo(org.eclipse.microprofile.openapi.models.info.Info info) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createInfo()"));
        if (info.getTitle() != null) {
            list.add(CodeBlock.of("title($S)", info.getTitle()));
        }
        if (info.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", info.getDescription()));
        }
        if (info.getTermsOfService() != null) {
            list.add(CodeBlock.of("termsOfService($S)", info.getTermsOfService()));
        }
        if (info.getContact() != null) {
            list.add(CodeBlock.of("contact(\n$L\n)", createContact(info.getContact())));
        }
        if (info.getLicense() != null) {
            list.add(CodeBlock.of("license(\n$L\n)", createLicense(info.getLicense())));
        }
        if (info.getVersion() != null) {
            list.add(CodeBlock.of("version($S)", info.getVersion()));
        }
        if (info.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : info.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createLicense(org.eclipse.microprofile.openapi.models.info.License license) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createLicense()"));
        if (license.getName() != null) {
            list.add(CodeBlock.of("name($S)", license.getName()));
        }
        if (license.getUrl() != null) {
            list.add(CodeBlock.of("url($S)", license.getUrl()));
        }
        if (license.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : license.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createLink(org.eclipse.microprofile.openapi.models.links.Link link) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createLink()"));
        if (link.getRef() != null) {
            list.add(CodeBlock.of("ref($S)", link.getRef()));
        }
        if (link.getServer() != null) {
            list.add(CodeBlock.of("server(\n$L\n)", createServer(link.getServer())));
        }
        if (link.getOperationRef() != null) {
            list.add(CodeBlock.of("operationRef($S)", link.getOperationRef()));
        }
        if (link.getRequestBody() != null) {
            if (link.getRequestBody() instanceof String) {
                list.add(CodeBlock.of("requestBody($S)", link.getRequestBody()));
            } else {
                list.add(CodeBlock.of("requestBody($L)", link.getRequestBody()));
            }
        }
        if (link.getOperationId() != null) {
            list.add(CodeBlock.of("operationId($S)", link.getOperationId()));
        }
        if (link.getParameters() != null) {
            for (java.util.Map.Entry<String, Object> entry : link.getParameters()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addParameter($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addParameter($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        if (link.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", link.getDescription()));
        }
        if (link.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : link.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createContent(org.eclipse.microprofile.openapi.models.media.Content content) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createContent()"));
        if (content.getMediaTypes() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.media.MediaType> entry : content.getMediaTypes()
                .entrySet()) {
                list.add(CodeBlock.of("addMediaType(\n$S, $L\n)", entry.getKey(), createMediaType(entry.getValue())));
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createDiscriminator(org.eclipse.microprofile.openapi.models.media.Discriminator discriminator) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createDiscriminator()"));
        if (discriminator.getPropertyName() != null) {
            list.add(CodeBlock.of("propertyName($S)", discriminator.getPropertyName()));
        }
        if (discriminator.getMapping() != null) {
            for (java.util.Map.Entry<String, String> entry : discriminator.getMapping()
                .entrySet()) {
                list.add(CodeBlock.of("addMapping($S, $S)", entry.getKey(), entry.getValue()));
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createEncoding(org.eclipse.microprofile.openapi.models.media.Encoding encoding) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createEncoding()"));
        if (encoding.getContentType() != null) {
            list.add(CodeBlock.of("contentType($S)", encoding.getContentType()));
        }
        if (encoding.getHeaders() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.headers.Header> entry : encoding.getHeaders()
                .entrySet()) {
                list.add(CodeBlock.of("addHeader(\n$S, $L\n)", entry.getKey(), createHeader(entry.getValue())));
            }
        }
        if (encoding.getStyle() != null) {
            list.add(
                CodeBlock.of(
                    "style($T.$L)", org.eclipse.microprofile.openapi.models.media.Encoding.Style.class, encoding.getStyle()
                        .name()
                )
            );
        }
        if (encoding.getExplode() != null) {
            list.add(CodeBlock.of("explode($L)", encoding.getExplode()));
        }
        if (encoding.getAllowReserved() != null) {
            list.add(CodeBlock.of("allowReserved($L)", encoding.getAllowReserved()));
        }
        if (encoding.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : encoding.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createMediaType(org.eclipse.microprofile.openapi.models.media.MediaType mediaType) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createMediaType()"));
        if (mediaType.getSchema() != null) {
            list.add(CodeBlock.of("schema(\n$L\n)", createSchema(mediaType.getSchema())));
        }
        if (mediaType.getExamples() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.examples.Example> entry : mediaType.getExamples()
                .entrySet()) {
                list.add(CodeBlock.of("addExample(\n$S, $L\n)", entry.getKey(), createExample(entry.getValue())));
            }
        }
        if (mediaType.getExample() != null) {
            if (mediaType.getExample() instanceof String) {
                list.add(CodeBlock.of("example($S)", mediaType.getExample()));
            } else {
                list.add(CodeBlock.of("example($L)", mediaType.getExample()));
            }
        }
        if (mediaType.getEncoding() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.media.Encoding> entry : mediaType.getEncoding()
                .entrySet()) {
                list.add(CodeBlock.of("addEncoding(\n$S, $L\n)", entry.getKey(), createEncoding(entry.getValue())));
            }
        }
        if (mediaType.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : mediaType.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createSchema(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createSchema()"));
        if (schema.getRef() != null) {
            list.add(CodeBlock.of("ref($S)", schema.getRef()));
        }
        if (schema.getDiscriminator() != null) {
            list.add(CodeBlock.of("discriminator(\n$L\n)", createDiscriminator(schema.getDiscriminator())));
        }
        if (schema.getTitle() != null) {
            list.add(CodeBlock.of("title($S)", schema.getTitle()));
        }
        if (schema.getDefaultValue() != null) {
            if (schema.getDefaultValue() instanceof String) {
                list.add(CodeBlock.of("defaultValue($S)", schema.getDefaultValue()));
            } else {
                list.add(CodeBlock.of("defaultValue($L)", schema.getDefaultValue()));
            }
        }
        if (schema.getEnumeration() != null) {
            for (Object item : schema.getEnumeration()) {
                if (item instanceof String) {
                    list.add(CodeBlock.of("addEnumeration($S)", item));
                } else {
                    list.add(CodeBlock.of("addEnumeration($L)", item));
                }
            }
        }
        if (schema.getMultipleOf() != null) {
            list.add(CodeBlock.of("multipleOf($L)", schema.getMultipleOf()));
        }
        if (schema.getMaximum() != null) {
            list.add(CodeBlock.of("maximum($L)", schema.getMaximum()));
        }
        if (schema.getExclusiveMaximum() != null) {
            list.add(CodeBlock.of("exclusiveMaximum($L)", schema.getExclusiveMaximum()));
        }
        if (schema.getMinimum() != null) {
            list.add(CodeBlock.of("minimum($L)", schema.getMinimum()));
        }
        if (schema.getExclusiveMinimum() != null) {
            list.add(CodeBlock.of("exclusiveMinimum($L)", schema.getExclusiveMinimum()));
        }
        if (schema.getMaxLength() != null) {
            list.add(CodeBlock.of("maxLength($L)", schema.getMaxLength()));
        }
        if (schema.getMinLength() != null) {
            list.add(CodeBlock.of("minLength($L)", schema.getMinLength()));
        }
        if (schema.getPattern() != null) {
            list.add(CodeBlock.of("pattern($S)", schema.getPattern()));
        }
        if (schema.getMaxItems() != null) {
            list.add(CodeBlock.of("maxItems($L)", schema.getMaxItems()));
        }
        if (schema.getMinItems() != null) {
            list.add(CodeBlock.of("minItems($L)", schema.getMinItems()));
        }
        if (schema.getUniqueItems() != null) {
            list.add(CodeBlock.of("uniqueItems($L)", schema.getUniqueItems()));
        }
        if (schema.getMaxProperties() != null) {
            list.add(CodeBlock.of("maxProperties($L)", schema.getMaxProperties()));
        }
        if (schema.getMinProperties() != null) {
            list.add(CodeBlock.of("minProperties($L)", schema.getMinProperties()));
        }
        if (schema.getRequired() != null) {
            for (String item : schema.getRequired()) {
                list.add(CodeBlock.of("addRequired($S)", item));
            }
        }
        if (schema.getType() != null) {
            list.add(
                CodeBlock.of(
                    "type($T.$L)", org.eclipse.microprofile.openapi.models.media.Schema.SchemaType.class, schema.getType()
                        .name()
                )
            );
        }
        if (schema.getNot() != null) {
            list.add(CodeBlock.of("not(\n$L\n)", createSchema(schema.getNot())));
        }
        if (schema.getProperties() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.media.Schema> entry : schema.getProperties()
                .entrySet()) {
                list.add(CodeBlock.of("addProperty(\n$S, $L\n)", entry.getKey(), createSchema(entry.getValue())));
            }
        }
        if (schema.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", schema.getDescription()));
        }
        if (schema.getFormat() != null) {
            list.add(CodeBlock.of("format($S)", schema.getFormat()));
        }
        if (schema.getNullable() != null) {
            list.add(CodeBlock.of("nullable($L)", schema.getNullable()));
        }
        if (schema.getReadOnly() != null) {
            list.add(CodeBlock.of("readOnly($L)", schema.getReadOnly()));
        }
        if (schema.getWriteOnly() != null) {
            list.add(CodeBlock.of("writeOnly($L)", schema.getWriteOnly()));
        }
        if (schema.getExample() != null) {
            if (schema.getExample() instanceof String) {
                list.add(CodeBlock.of("example($S)", schema.getExample()));
            } else {
                list.add(CodeBlock.of("example($L)", schema.getExample()));
            }
        }
        if (schema.getExternalDocs() != null) {
            list.add(CodeBlock.of("externalDocs(\n$L\n)", createExternalDocumentation(schema.getExternalDocs())));
        }
        if (schema.getDeprecated() != null) {
            list.add(CodeBlock.of("deprecated($L)", schema.getDeprecated()));
        }
        if (schema.getXml() != null) {
            list.add(CodeBlock.of("xml(\n$L\n)", createXML(schema.getXml())));
        }
        if (schema.getItems() != null) {
            list.add(CodeBlock.of("items(\n$L\n)", createSchema(schema.getItems())));
        }
        if (schema.getAllOf() != null) {
            for (org.eclipse.microprofile.openapi.models.media.Schema item : schema.getAllOf()) {
                list.add(CodeBlock.of("addAllOf(\n$L\n)", createSchema(item)));
            }
        }
        if (schema.getAnyOf() != null) {
            for (org.eclipse.microprofile.openapi.models.media.Schema item : schema.getAnyOf()) {
                list.add(CodeBlock.of("addAnyOf(\n$L\n)", createSchema(item)));
            }
        }
        if (schema.getOneOf() != null) {
            for (org.eclipse.microprofile.openapi.models.media.Schema item : schema.getOneOf()) {
                list.add(CodeBlock.of("addOneOf(\n$L\n)", createSchema(item)));
            }
        }
        if (schema.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : schema.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createXML(org.eclipse.microprofile.openapi.models.media.XML xML) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createXML()"));
        if (xML.getName() != null) {
            list.add(CodeBlock.of("name($S)", xML.getName()));
        }
        if (xML.getNamespace() != null) {
            list.add(CodeBlock.of("namespace($S)", xML.getNamespace()));
        }
        if (xML.getPrefix() != null) {
            list.add(CodeBlock.of("prefix($S)", xML.getPrefix()));
        }
        if (xML.getAttribute() != null) {
            list.add(CodeBlock.of("attribute($L)", xML.getAttribute()));
        }
        if (xML.getWrapped() != null) {
            list.add(CodeBlock.of("wrapped($L)", xML.getWrapped()));
        }
        if (xML.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : xML.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createParameter(org.eclipse.microprofile.openapi.models.parameters.Parameter parameter) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createParameter()"));
        if (parameter.getRef() != null) {
            list.add(CodeBlock.of("ref($S)", parameter.getRef()));
        }
        if (parameter.getName() != null) {
            list.add(CodeBlock.of("name($S)", parameter.getName()));
        }
        if (parameter.getIn() != null) {
            list.add(
                CodeBlock.of(
                    "in($T.$L)", org.eclipse.microprofile.openapi.models.parameters.Parameter.In.class, parameter.getIn()
                        .name()
                )
            );
        }
        if (parameter.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", parameter.getDescription()));
        }
        if (parameter.getRequired() != null) {
            list.add(CodeBlock.of("required($L)", parameter.getRequired()));
        }
        if (parameter.getDeprecated() != null) {
            list.add(CodeBlock.of("deprecated($L)", parameter.getDeprecated()));
        }
        if (parameter.getAllowEmptyValue() != null) {
            list.add(CodeBlock.of("allowEmptyValue($L)", parameter.getAllowEmptyValue()));
        }
        if (parameter.getStyle() != null) {
            list.add(
                CodeBlock.of(
                    "style($T.$L)", org.eclipse.microprofile.openapi.models.parameters.Parameter.Style.class, parameter.getStyle()
                        .name()
                )
            );
        }
        if (parameter.getExplode() != null) {
            list.add(CodeBlock.of("explode($L)", parameter.getExplode()));
        }
        if (parameter.getAllowReserved() != null) {
            list.add(CodeBlock.of("allowReserved($L)", parameter.getAllowReserved()));
        }
        if (parameter.getSchema() != null) {
            list.add(CodeBlock.of("schema(\n$L\n)", createSchema(parameter.getSchema())));
        }
        if (parameter.getExamples() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.examples.Example> entry : parameter.getExamples()
                .entrySet()) {
                list.add(CodeBlock.of("addExample(\n$S, $L\n)", entry.getKey(), createExample(entry.getValue())));
            }
        }
        if (parameter.getExample() != null) {
            if (parameter.getExample() instanceof String) {
                list.add(CodeBlock.of("example($S)", parameter.getExample()));
            } else {
                list.add(CodeBlock.of("example($L)", parameter.getExample()));
            }
        }
        if (parameter.getContent() != null) {
            list.add(CodeBlock.of("content(\n$L\n)", createContent(parameter.getContent())));
        }
        if (parameter.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : parameter.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createRequestBody(org.eclipse.microprofile.openapi.models.parameters.RequestBody requestBody) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createRequestBody()"));
        if (requestBody.getRef() != null) {
            list.add(CodeBlock.of("ref($S)", requestBody.getRef()));
        }
        if (requestBody.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", requestBody.getDescription()));
        }
        if (requestBody.getContent() != null) {
            list.add(CodeBlock.of("content(\n$L\n)", createContent(requestBody.getContent())));
        }
        if (requestBody.getRequired() != null) {
            list.add(CodeBlock.of("required($L)", requestBody.getRequired()));
        }
        if (requestBody.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : requestBody.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createAPIResponse(org.eclipse.microprofile.openapi.models.responses.APIResponse aPIResponse) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createAPIResponse()"));
        if (aPIResponse.getRef() != null) {
            list.add(CodeBlock.of("ref($S)", aPIResponse.getRef()));
        }
        if (aPIResponse.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", aPIResponse.getDescription()));
        }
        if (aPIResponse.getHeaders() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.headers.Header> entry : aPIResponse.getHeaders()
                .entrySet()) {
                list.add(CodeBlock.of("addHeader(\n$S, $L\n)", entry.getKey(), createHeader(entry.getValue())));
            }
        }
        if (aPIResponse.getContent() != null) {
            list.add(CodeBlock.of("content(\n$L\n)", createContent(aPIResponse.getContent())));
        }
        if (aPIResponse.getLinks() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.links.Link> entry : aPIResponse.getLinks()
                .entrySet()) {
                list.add(CodeBlock.of("addLink(\n$S, $L\n)", entry.getKey(), createLink(entry.getValue())));
            }
        }
        if (aPIResponse.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : aPIResponse.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createAPIResponses(org.eclipse.microprofile.openapi.models.responses.APIResponses aPIResponses) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createAPIResponses()"));
        if (aPIResponses.getAPIResponses() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.responses.APIResponse> entry : aPIResponses.getAPIResponses()
                .entrySet()) {
                list.add(CodeBlock.of("addAPIResponse(\n$S, $L\n)", entry.getKey(), createAPIResponse(entry.getValue())));
            }
        }
        if (aPIResponses.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : aPIResponses.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createOAuthFlow(org.eclipse.microprofile.openapi.models.security.OAuthFlow oAuthFlow) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createOAuthFlow()"));
        if (oAuthFlow.getAuthorizationUrl() != null) {
            list.add(CodeBlock.of("authorizationUrl($S)", oAuthFlow.getAuthorizationUrl()));
        }
        if (oAuthFlow.getTokenUrl() != null) {
            list.add(CodeBlock.of("tokenUrl($S)", oAuthFlow.getTokenUrl()));
        }
        if (oAuthFlow.getRefreshUrl() != null) {
            list.add(CodeBlock.of("refreshUrl($S)", oAuthFlow.getRefreshUrl()));
        }
        if (oAuthFlow.getScopes() != null) {
            for (java.util.Map.Entry<String, String> entry : oAuthFlow.getScopes()
                .entrySet()) {
                list.add(CodeBlock.of("addScope($S, $S)", entry.getKey(), entry.getValue()));
            }
        }
        if (oAuthFlow.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : oAuthFlow.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createOAuthFlows(org.eclipse.microprofile.openapi.models.security.OAuthFlows oAuthFlows) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createOAuthFlows()"));
        if (oAuthFlows.getImplicit() != null) {
            list.add(CodeBlock.of("implicit(\n$L\n)", createOAuthFlow(oAuthFlows.getImplicit())));
        }
        if (oAuthFlows.getPassword() != null) {
            list.add(CodeBlock.of("password(\n$L\n)", createOAuthFlow(oAuthFlows.getPassword())));
        }
        if (oAuthFlows.getClientCredentials() != null) {
            list.add(CodeBlock.of("clientCredentials(\n$L\n)", createOAuthFlow(oAuthFlows.getClientCredentials())));
        }
        if (oAuthFlows.getAuthorizationCode() != null) {
            list.add(CodeBlock.of("authorizationCode(\n$L\n)", createOAuthFlow(oAuthFlows.getAuthorizationCode())));
        }
        if (oAuthFlows.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : oAuthFlows.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createSecurityRequirement(org.eclipse.microprofile.openapi.models.security.SecurityRequirement securityRequirement) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createSecurityRequirement()"));
        if (securityRequirement.getSchemes() != null) {
            for (java.util.Map.Entry<String, java.util.List<String>> entry : securityRequirement.getSchemes()
                .entrySet()) {
                if (entry.getValue()
                    .isEmpty()) {
                    list.add(CodeBlock.of("addScheme($S)", entry.getKey()));
                } else if (entry.getValue()
                    .size() == 1) {
                    list.add(
                        CodeBlock.of(
                            "addScheme($S, $S)", entry.getKey(), entry.getValue()
                                .get(0)
                        )
                    );
                } else {
                    list.add(
                        CodeBlock.of(
                            "addScheme(\n$S, $T.asList(\n$L\n)\n)", entry.getKey(), java.util.Arrays.class, CodeBlock.join(
                                entry.getValue()
                                    .stream()
                                    .map(s -> CodeBlock.of("$S", s))
                                    .collect(java.util.stream.Collectors.toList()), ",\n"
                            )
                        )
                    );
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createSecurityScheme(org.eclipse.microprofile.openapi.models.security.SecurityScheme securityScheme) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createSecurityScheme()"));
        if (securityScheme.getRef() != null) {
            list.add(CodeBlock.of("ref($S)", securityScheme.getRef()));
        }
        if (securityScheme.getType() != null) {
            list.add(
                CodeBlock.of(
                    "type($T.$L)", org.eclipse.microprofile.openapi.models.security.SecurityScheme.Type.class, securityScheme.getType()
                        .name()
                )
            );
        }
        if (securityScheme.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", securityScheme.getDescription()));
        }
        if (securityScheme.getName() != null) {
            list.add(CodeBlock.of("name($S)", securityScheme.getName()));
        }
        if (securityScheme.getIn() != null) {
            list.add(
                CodeBlock.of(
                    "in($T.$L)", org.eclipse.microprofile.openapi.models.security.SecurityScheme.In.class, securityScheme.getIn()
                        .name()
                )
            );
        }
        if (securityScheme.getScheme() != null) {
            list.add(CodeBlock.of("scheme($S)", securityScheme.getScheme()));
        }
        if (securityScheme.getBearerFormat() != null) {
            list.add(CodeBlock.of("bearerFormat($S)", securityScheme.getBearerFormat()));
        }
        if (securityScheme.getFlows() != null) {
            list.add(CodeBlock.of("flows(\n$L\n)", createOAuthFlows(securityScheme.getFlows())));
        }
        if (securityScheme.getOpenIdConnectUrl() != null) {
            list.add(CodeBlock.of("openIdConnectUrl($S)", securityScheme.getOpenIdConnectUrl()));
        }
        if (securityScheme.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : securityScheme.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createServer(org.eclipse.microprofile.openapi.models.servers.Server server) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createServer()"));
        if (server.getUrl() != null) {
            list.add(CodeBlock.of("url($S)", server.getUrl()));
        }
        if (server.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", server.getDescription()));
        }
        if (server.getVariables() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.servers.ServerVariable> entry : server.getVariables()
                .entrySet()) {
                list.add(CodeBlock.of("addVariable(\n$S, $L\n)", entry.getKey(), createServerVariable(entry.getValue())));
            }
        }
        if (server.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : server.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createServerVariable(org.eclipse.microprofile.openapi.models.servers.ServerVariable serverVariable) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createServerVariable()"));
        if (serverVariable.getEnumeration() != null) {
            for (String item : serverVariable.getEnumeration()) {
                list.add(CodeBlock.of("addEnumeration($S)", item));
            }
        }
        if (serverVariable.getDefaultValue() != null) {
            list.add(CodeBlock.of("defaultValue($S)", serverVariable.getDefaultValue()));
        }
        if (serverVariable.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", serverVariable.getDescription()));
        }
        if (serverVariable.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : serverVariable.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }

    public static CodeBlock createTag(org.eclipse.microprofile.openapi.models.tags.Tag tag) {
        List<CodeBlock> list = new ArrayList<>();
        list.add(CodeBlock.of("createTag()"));
        if (tag.getName() != null) {
            list.add(CodeBlock.of("name($S)", tag.getName()));
        }
        if (tag.getDescription() != null) {
            list.add(CodeBlock.of("description($S)", tag.getDescription()));
        }
        if (tag.getExternalDocs() != null) {
            list.add(CodeBlock.of("externalDocs(\n$L\n)", createExternalDocumentation(tag.getExternalDocs())));
        }
        if (tag.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> entry : tag.getExtensions()
                .entrySet()) {
                if (entry.getValue() instanceof String) {
                    list.add(CodeBlock.of("addExtension($S, $S)", entry.getKey(), entry.getValue()));
                } else {
                    list.add(CodeBlock.of("addExtension($S, $L)", entry.getKey(), entry.getValue()));
                }
            }
        }
        return CodeBlock.join(list, "\n.");
    }
}