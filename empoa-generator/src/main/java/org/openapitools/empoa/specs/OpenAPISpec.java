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
package org.openapitools.empoa.specs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import org.openapitools.empoa.specs.AdditionalMethod.Type;

public class OpenAPISpec {

    public static Collection<Class<?>> interfaces() {
        return interfacesMap().values();
    }

    public static Map<ElementType, Class<?>> interfacesMap() {
        Map<ElementType, Class<?>> map = new LinkedHashMap<>();
        map.put(ElementType.Components, org.eclipse.microprofile.openapi.models.Components.class);
        map.put(ElementType.ExternalDocumentation, org.eclipse.microprofile.openapi.models.ExternalDocumentation.class);
        map.put(ElementType.OpenAPI, org.eclipse.microprofile.openapi.models.OpenAPI.class);
        map.put(ElementType.Operation, org.eclipse.microprofile.openapi.models.Operation.class);
        map.put(ElementType.PathItem, org.eclipse.microprofile.openapi.models.PathItem.class);
        map.put(ElementType.Paths, org.eclipse.microprofile.openapi.models.Paths.class);
        map.put(ElementType.Callback, org.eclipse.microprofile.openapi.models.callbacks.Callback.class);
        map.put(ElementType.Example, org.eclipse.microprofile.openapi.models.examples.Example.class);
        map.put(ElementType.Header, org.eclipse.microprofile.openapi.models.headers.Header.class);
        map.put(ElementType.Contact, org.eclipse.microprofile.openapi.models.info.Contact.class);
        map.put(ElementType.Info, org.eclipse.microprofile.openapi.models.info.Info.class);
        map.put(ElementType.License, org.eclipse.microprofile.openapi.models.info.License.class);
        map.put(ElementType.Link, org.eclipse.microprofile.openapi.models.links.Link.class);
        map.put(ElementType.Content, org.eclipse.microprofile.openapi.models.media.Content.class);
        map.put(ElementType.Discriminator, org.eclipse.microprofile.openapi.models.media.Discriminator.class);
        map.put(ElementType.Encoding, org.eclipse.microprofile.openapi.models.media.Encoding.class);
        map.put(ElementType.MediaType, org.eclipse.microprofile.openapi.models.media.MediaType.class);
        map.put(ElementType.Schema, org.eclipse.microprofile.openapi.models.media.Schema.class);
        map.put(ElementType.XML, org.eclipse.microprofile.openapi.models.media.XML.class);
        map.put(ElementType.Parameter, org.eclipse.microprofile.openapi.models.parameters.Parameter.class);
        map.put(ElementType.RequestBody, org.eclipse.microprofile.openapi.models.parameters.RequestBody.class);
        map.put(ElementType.APIResponse, org.eclipse.microprofile.openapi.models.responses.APIResponse.class);
        map.put(ElementType.APIResponses, org.eclipse.microprofile.openapi.models.responses.APIResponses.class);
        map.put(ElementType.OAuthFlow, org.eclipse.microprofile.openapi.models.security.OAuthFlow.class);
        map.put(ElementType.OAuthFlows, org.eclipse.microprofile.openapi.models.security.OAuthFlows.class);
        map.put(ElementType.SecurityRequirement, org.eclipse.microprofile.openapi.models.security.SecurityRequirement.class);
        map.put(ElementType.SecurityScheme, org.eclipse.microprofile.openapi.models.security.SecurityScheme.class);
        map.put(ElementType.Server, org.eclipse.microprofile.openapi.models.servers.Server.class);
        map.put(ElementType.ServerVariable, org.eclipse.microprofile.openapi.models.servers.ServerVariable.class);
        map.put(ElementType.Tag, org.eclipse.microprofile.openapi.models.tags.Tag.class);
        return map;
    }

    public static List<Element> elements() {
        List<Element> elements = new ArrayList<>();
        // org.eclipse.microprofile.openapi.models
        elements.add(createComponents());
        elements.add(createExternalDocumentation());
        elements.add(createOpenAPI());
        elements.add(createOperation());
        elements.add(createPathItem());
        elements.add(createPaths());

        // org.eclipse.microprofile.openapi.models.callbacks
        elements.add(createCallback());

        // org.eclipse.microprofile.openapi.models.examples
        elements.add(createExample());

        // org.eclipse.microprofile.openapi.models.headers
        elements.add(createHeader());

        // org.eclipse.microprofile.openapi.models.info
        elements.add(createContact());
        elements.add(createInfo());
        elements.add(createLicense());

        // org.eclipse.microprofile.openapi.models.links
        elements.add(createLink());

        // org.eclipse.microprofile.openapi.models.media
        elements.add(createContent());
        elements.add(createDiscriminator());
        elements.add(createEncoding());
        elements.add(createMediaType());
        elements.add(createSchema());
        elements.add(createXML());

        // org.eclipse.microprofile.openapi.models.parameters
        elements.add(createParameter());
        elements.add(createRequestBody());

        // org.eclipse.microprofile.openapi.models.responses
        elements.add(createAPIResponse());
        elements.add(createAPIResponses());

        // org.eclipse.microprofile.openapi.models.security
        elements.add(createOAuthFlow());
        elements.add(createOAuthFlows());
        elements.add(createSecurityRequirement());
        elements.add(createSecurityScheme());

        // org.eclipse.microprofile.openapi.models.servers
        elements.add(createServer());
        elements.add(createServerVariable());

        // org.eclipse.microprofile.openapi.models.tag
        elements.add(createTag());

        return elements;
    }

    public static Element createComponents() {
        List<IMember> members = new ArrayList<>();
        members.add(new MapMember(MemberType.Components_Schemas, "Schemas", Schema.class.getCanonicalName()));
        members.add(new MapMember(MemberType.Components_Responses, "Responses", APIResponse.class.getCanonicalName()));
        members.add(new MapMember(MemberType.Components_Parameters, "Parameters", Parameter.class.getCanonicalName()));
        members.add(new MapMember(MemberType.Components_Examples, "Examples", Example.class.getCanonicalName()));
        members.add(new MapMember(MemberType.Components_RequestBodies, "RequestBodies", RequestBody.class.getCanonicalName()));
        members.add(new MapMember(MemberType.Components_Headers, "Headers", Header.class.getCanonicalName()));
        members.add(new MapMember(MemberType.Components_SecuritySchemes, "SecuritySchemes", SecurityScheme.class.getCanonicalName()));
        members.add(new MapMember(MemberType.Components_Links, "Links", Link.class.getCanonicalName()));
        members.add(new MapMember(MemberType.Components_Callbacks, "Callbacks", Callback.class.getCanonicalName()));
        return new Element(ElementType.Components, Components.class.getName(), true, false, members);
    }

    public static Element createExternalDocumentation() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.ExternalDocumentation_Description, "Description", String.class.getSimpleName()));
        members.add(new Member(MemberType.ExternalDocumentation_Url, "Url", String.class.getSimpleName()));
        return new Element(ElementType.ExternalDocumentation, ExternalDocumentation.class.getName(), true, false, members);
    }

    public static Element createOpenAPI() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.OpenAPI_Openapi, "Openapi", String.class.getSimpleName()));
        members.add(new Member(MemberType.OpenAPI_Info, "Info", Info.class.getCanonicalName()));
        members.add(new Member(MemberType.OpenAPI_ExternalDocs, "ExternalDocs", ExternalDocumentation.class.getCanonicalName()));
        members.add(new ListMember(MemberType.OpenAPI_Servers, "Servers", Server.class.getCanonicalName()));
        members.add(new ListMember(MemberType.OpenAPI_Security, "Security", SecurityRequirement.class.getCanonicalName(), "addSecurityRequirement", "removeSecurityRequirement"));
        members.add(new ListMember(MemberType.OpenAPI_Tags, "Tags", Tag.class.getCanonicalName()));
        members.add(new Member(MemberType.OpenAPI_Paths, "Paths", Paths.class.getCanonicalName()));
        members.add(new Member(MemberType.OpenAPI_Components, "Components", Components.class.getCanonicalName()));
        return new Element(ElementType.OpenAPI, OpenAPI.class.getName(), true, false, members);
    }

    public static Element createOperation() {
        List<IMember> members = new ArrayList<>();
        members.add(new ListMember(MemberType.Operation_Tags, "Tags", String.class.getSimpleName()));
        members.add(new Member(MemberType.Operation_Summary, "Summary", String.class.getSimpleName()));
        members.add(new Member(MemberType.Operation_Description, "Description", String.class.getSimpleName()));
        members.add(new Member(MemberType.Operation_ExternalDocs, "ExternalDocs", ExternalDocumentation.class.getCanonicalName()));
        members.add(new Member(MemberType.Operation_OperationId, "OperationId", String.class.getSimpleName()));
        members.add(new ListMember(MemberType.Operation_Parameters, "Parameters", Parameter.class.getCanonicalName()));
        members.add(new Member(MemberType.Operation_RequestBody, "RequestBody", RequestBody.class.getCanonicalName()));
        members.add(new Member(MemberType.Operation_Responses, "Responses", APIResponses.class.getCanonicalName()));
        members.add(new MapMember(MemberType.Operation_Callbacks, "Callbacks", Callback.class.getCanonicalName()));
        members.add(new Member(MemberType.Operation_Deprecated, "Deprecated", Boolean.class.getSimpleName()));
        members.add(new ListMember(MemberType.Operation_Security, "Security", SecurityRequirement.class.getName(), "addSecurityRequirement", "removeSecurityRequirement"));
        members.add(new ListMember(MemberType.Operation_Servers, "Servers", Server.class.getCanonicalName()));
        return new Element(ElementType.Operation, Operation.class.getName(), true, false, members);
    }

    public static Element createPathItem() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.PathItem_Summary, "Summary", String.class.getSimpleName()));
        members.add(new Member(MemberType.PathItem_Description, "Description", String.class.getSimpleName()));
        members.add(new Member(MemberType.PathItem_GET, "GET", Operation.class.getCanonicalName()));
        members.add(new Member(MemberType.PathItem_PUT, "PUT", Operation.class.getCanonicalName()));
        members.add(new Member(MemberType.PathItem_POST, "POST", Operation.class.getCanonicalName()));
        members.add(new Member(MemberType.PathItem_DELETE, "DELETE", Operation.class.getCanonicalName()));
        members.add(new Member(MemberType.PathItem_OPTIONS, "OPTIONS", Operation.class.getCanonicalName()));
        members.add(new Member(MemberType.PathItem_HEAD, "HEAD", Operation.class.getCanonicalName()));
        members.add(new Member(MemberType.PathItem_PATCH, "PATCH", Operation.class.getCanonicalName()));
        members.add(new Member(MemberType.PathItem_TRACE, "TRACE", Operation.class.getCanonicalName()));
        members.add(new AdditionalMethod(Type.PathItem_getOperations));
        members.add(new ListMember(MemberType.PathItem_Servers, "Servers", Server.class.getCanonicalName()));
        members.add(new ListMember(MemberType.PathItem_Parameters, "Parameters", Parameter.class.getCanonicalName()));
        return new Element(ElementType.PathItem, PathItem.class.getName(), true, true, members);
    }

    public static Element createPaths() {
        List<IMember> members = new ArrayList<>();
        members.add(new MapMember(MemberType.Paths_PathItems, "PathItems", PathItem.class.getCanonicalName()));
        return new Element(ElementType.Paths, Paths.class.getName(), true, false, members);
    }

    public static Element createCallback() {
        List<IMember> members = new ArrayList<>();
        members.add(new MapMember(MemberType.Callback_PathItems, "PathItems", PathItem.class.getCanonicalName()));
        return new Element(ElementType.Callback, Callback.class.getName(), true, true, members);
    }

    public static Element createExample() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.Example_Summary, "Summary", String.class.getSimpleName()));
        members.add(new Member(MemberType.Example_Description, "Description", String.class.getSimpleName()));
        members.add(new Member(MemberType.Example_Value, "Value", Object.class.getSimpleName()));
        members.add(new Member(MemberType.Example_ExternalValue, "ExternalValue", String.class.getSimpleName()));
        return new Element(ElementType.Example, Example.class.getName(), true, true, members);
    }

    public static Element createHeader() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.Header_Description, "Description", String.class.getSimpleName()));
        members.add(new Member(MemberType.Header_Required, "Required", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Header_Deprecated, "Deprecated", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Header_AllowEmptyValue, "AllowEmptyValue", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Header_Style, "Style", Header.Style.class.getCanonicalName()));
        members.add(new Member(MemberType.Header_Explode, "Explode", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Header_Schema, "Schema", Schema.class.getCanonicalName()));
        members.add(new MapMember(MemberType.Header_Examples, "Examples", Example.class.getCanonicalName()));
        members.add(new Member(MemberType.Header_Example, "Example", Object.class.getSimpleName()));
        members.add(new Member(MemberType.Header_Content, "Content", Content.class.getCanonicalName()));
        return new Element(ElementType.Header, Header.class.getName(), true, true, members);
    }

    public static Element createContact() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.Contact_Name, "Name", String.class.getSimpleName()));
        members.add(new Member(MemberType.Contact_Url, "Url", String.class.getSimpleName()));
        members.add(new Member(MemberType.Contact_Email, "Email", String.class.getSimpleName()));
        return new Element(ElementType.Contact, Contact.class.getName(), true, false, members);
    }

    public static Element createInfo() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.Info_Title, "Title", String.class.getSimpleName()));
        members.add(new Member(MemberType.Info_Description, "Description", String.class.getSimpleName()));
        members.add(new Member(MemberType.Info_TermsOfService, "TermsOfService", String.class.getSimpleName()));
        members.add(new Member(MemberType.Info_Contact, "Contact", Contact.class.getCanonicalName()));
        members.add(new Member(MemberType.Info_License, "License", License.class.getCanonicalName()));
        members.add(new Member(MemberType.Info_Version, "Version", String.class.getSimpleName()));
        return new Element(ElementType.Info, Info.class.getName(), true, false, members);
    }

    public static Element createLicense() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.License_Name, "Name", String.class.getSimpleName()));
        members.add(new Member(MemberType.License_Url, "Url", String.class.getSimpleName()));
        return new Element(ElementType.License, License.class.getName(), true, false, members);
    }

    public static Element createLink() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.Link_Server, "Server", Server.class.getCanonicalName()));
        members.add(new Member(MemberType.Link_OperationRef, "OperationRef", String.class.getSimpleName()));
        members.add(new Member(MemberType.Link_RequestBody, "RequestBody", Object.class.getSimpleName()));
        members.add(new Member(MemberType.Link_OperationId, "OperationId", String.class.getSimpleName()));
        members.add(new MapMember(MemberType.Link_Parameters, "Parameters", Object.class.getSimpleName()));
        members.add(new Member(MemberType.Link_Description, "Description", String.class.getSimpleName()));
        return new Element(ElementType.Link, Link.class.getName(), true, true, members);
    }

    public static Element createContent() {
        List<IMember> members = new ArrayList<>();
        members.add(new MapMember(MemberType.Content_MediaTypes, "MediaTypes", MediaType.class.getCanonicalName()));
        return new Element(ElementType.Content, Content.class.getName(), false, false, members);
    }

    public static Element createDiscriminator() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.Discriminator_PropertyName, "PropertyName", String.class.getSimpleName()));
        members.add(new MapMember(MemberType.Discriminator_Mapping, "Mapping", String.class.getSimpleName()));
        return new Element(ElementType.Discriminator, Discriminator.class.getName(), false, false, members);
    }

    public static Element createEncoding() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.Encoding_ContentType, "ContentType", String.class.getSimpleName()));
        members.add(new MapMember(MemberType.Encoding_Headers, "Headers", Header.class.getName()));
        members.add(new Member(MemberType.Encoding_Style, "Style", Encoding.Style.class.getCanonicalName()));
        members.add(new Member(MemberType.Encoding_Explode, "Explode", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Encoding_AllowReserved, "AllowReserved", Boolean.class.getSimpleName()));
        return new Element(ElementType.Encoding, Encoding.class.getName(), true, false, members);
    }

    public static Element createMediaType() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.MediaType_Schema, "Schema", Schema.class.getCanonicalName()));
        members.add(new MapMember(MemberType.MediaType_Examples, "Examples", Example.class.getCanonicalName()));
        members.add(new Member(MemberType.MediaType_Example, "Example", Object.class.getSimpleName()));
        members.add(new MapMember(MemberType.MediaType_Encoding, "Encoding", Encoding.class.getCanonicalName()));
        return new Element(ElementType.MediaType, MediaType.class.getName(), true, false, members);
    }

    public static Element createSchema() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.Schema_Discriminator, "Discriminator", Discriminator.class.getCanonicalName()));
        members.add(new Member(MemberType.Schema_Title, "Title", String.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_DefaultValue, "DefaultValue", Object.class.getSimpleName()));
        members.add(new ListMember(MemberType.Schema_Enumeration, "Enumeration", Object.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_MultipleOf, "MultipleOf", BigDecimal.class.getCanonicalName()));
        members.add(new Member(MemberType.Schema_Maximum, "Maximum", BigDecimal.class.getCanonicalName()));
        members.add(new Member(MemberType.Schema_ExclusiveMaximum, "ExclusiveMaximum", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_Minimum, "Minimum", BigDecimal.class.getCanonicalName()));
        members.add(new Member(MemberType.Schema_ExclusiveMinimum, "ExclusiveMinimum", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_MaxLength, "MaxLength", Integer.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_MinLength, "MinLength", Integer.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_Pattern, "Pattern", String.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_MaxItems, "MaxItems", Integer.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_MinItems, "MinItems", Integer.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_UniqueItems, "UniqueItems", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_MaxProperties, "MaxProperties", Integer.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_MinProperties, "MinProperties", Integer.class.getSimpleName()));
        members.add(new ListMember(MemberType.Schema_Required, "Required", String.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_Type, "Type", Schema.SchemaType.class.getCanonicalName()));
        members.add(new Member(MemberType.Schema_Not, "Not", Schema.class.getCanonicalName()));
        members.add(new MapMember(MemberType.Schema_Properties, "Properties", Schema.class.getCanonicalName()));
        members.add(new Member(MemberType.Schema_AdditionalProperties_Schema, "AdditionalPropertiesSchema", Schema.class.getCanonicalName(), true, true, false, true));
        members.add(new AdditionalMethod(Type.Schema_setAdditionalPropertiesSchema));
        members.add(new Member(MemberType.Schema_AdditionalProperties_Boolean, "AdditionalPropertiesBoolean", Boolean.class.getSimpleName(), true, true, false, true));
        members.add(new AdditionalMethod(Type.Schema_setAdditionalPropertiesBoolean));
        members.add(new Member(MemberType.Schema_Description, "Description", String.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_Format, "Format", String.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_Nullable, "Nullable", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_ReadOnly, "ReadOnly", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_WriteOnly, "WriteOnly", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_Example, "Example", Object.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_ExternalDocs, "ExternalDocs", ExternalDocumentation.class.getCanonicalName()));
        members.add(new Member(MemberType.Schema_Deprecated, "Deprecated", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Schema_Xml, "Xml", XML.class.getCanonicalName()));
        members.add(new Member(MemberType.Schema_Items, "Items", Schema.class.getCanonicalName()));
        members.add(new ListMember(MemberType.Schema_AllOf, "AllOf", Schema.class.getCanonicalName()));
        members.add(new ListMember(MemberType.Schema_AnyOf, "AnyOf", Schema.class.getCanonicalName()));
        members.add(new ListMember(MemberType.Schema_OneOf, "OneOf", Schema.class.getCanonicalName()));
        return new Element(ElementType.Schema, Schema.class.getName(), true, true, members);
    }

    public static Element createXML() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.XML_Name, "Name", String.class.getSimpleName()));
        members.add(new Member(MemberType.XML_Namespace, "Namespace", String.class.getSimpleName()));
        members.add(new Member(MemberType.XML_Prefix, "Prefix", String.class.getSimpleName()));
        members.add(new Member(MemberType.XML_Attribute, "Attribute", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.XML_Wrapped, "Wrapped", Boolean.class.getSimpleName()));
        return new Element(ElementType.XML, XML.class.getName(), true, false, members);
    }

    public static Element createParameter() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.Parameter_Name, "Name", String.class.getSimpleName()));
        members.add(new Member(MemberType.Parameter_In, "In", Parameter.In.class.getCanonicalName()));
        members.add(new Member(MemberType.Parameter_Description, "Description", String.class.getSimpleName()));
        members.add(new Member(MemberType.Parameter_Required, "Required", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Parameter_Deprecated, "Deprecated", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Parameter_AllowEmptyValue, "AllowEmptyValue", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Parameter_Style, "Style", Parameter.Style.class.getCanonicalName()));
        members.add(new Member(MemberType.Parameter_Explode, "Explode", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Parameter_AllowReserved, "AllowReserved", Boolean.class.getSimpleName()));
        members.add(new Member(MemberType.Parameter_Schema, "Schema", Schema.class.getCanonicalName()));
        members.add(new MapMember(MemberType.Parameter_Examples, "Examples", Example.class.getCanonicalName()));
        members.add(new Member(MemberType.Parameter_Example, "Example", Object.class.getSimpleName()));
        members.add(new Member(MemberType.Parameter_Content, "Content", Content.class.getCanonicalName()));
        return new Element(ElementType.Parameter, Parameter.class.getName(), true, true, members);
    }

    public static Element createRequestBody() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.RequestBody_Description, "Description", String.class.getSimpleName()));
        members.add(new Member(MemberType.RequestBody_Content, "Content", Content.class.getCanonicalName()));
        members.add(new Member(MemberType.RequestBody_Required, "Required", Boolean.class.getSimpleName()));
        return new Element(ElementType.RequestBody, RequestBody.class.getName(), true, true, members);
    }

    public static Element createAPIResponse() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.APIResponse_Description, "Description", String.class.getSimpleName()));
        members.add(new MapMember(MemberType.APIResponse_Headers, "Headers", Header.class.getCanonicalName()));
        members.add(new Member(MemberType.APIResponse_Content, "Content", Content.class.getCanonicalName()));
        members.add(new MapMember(MemberType.APIResponse_Links, "Links", Link.class.getCanonicalName()));
        return new Element(ElementType.APIResponse, APIResponse.class.getName(), true, true, members);
    }

    public static Element createAPIResponses() {
        List<IMember> members = new ArrayList<>();
        members.add(new MapMember(MemberType.APIResponses_APIResponses, "APIResponses", APIResponse.class.getCanonicalName()));
        members.add(new AdditionalMethod(Type.APIResponses_getDefaultValue));
        members.add(new AdditionalMethod(Type.APIResponses_setDefaultValue));
        return new Element(ElementType.APIResponses, APIResponses.class.getName(), true, false, members);
    }

    public static Element createOAuthFlow() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.OAuthFlow_AuthorizationUrl, "AuthorizationUrl", String.class.getSimpleName()));
        members.add(new Member(MemberType.OAuthFlow_TokenUrl, "TokenUrl", String.class.getSimpleName()));
        members.add(new Member(MemberType.OAuthFlow_RefreshUrl, "RefreshUrl", String.class.getSimpleName()));
        members.add(new MapMember(MemberType.OAuthFlow_Scopes, "Scopes", String.class.getSimpleName()));
        return new Element(ElementType.OAuthFlow, OAuthFlow.class.getName(), true, false, members);
    }

    public static Element createOAuthFlows() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.OAuthFlows_Implicit, "Implicit", OAuthFlow.class.getCanonicalName()));
        members.add(new Member(MemberType.OAuthFlows_Password, "Password", OAuthFlow.class.getCanonicalName()));
        members.add(new Member(MemberType.OAuthFlows_ClientCredentials, "ClientCredentials", OAuthFlow.class.getCanonicalName()));
        members.add(new Member(MemberType.OAuthFlows_AuthorizationCode, "AuthorizationCode", OAuthFlow.class.getCanonicalName()));
        return new Element(ElementType.OAuthFlows, OAuthFlows.class.getName(), true, false, members);
    }

    public static Element createSecurityRequirement() {
        List<IMember> members = new ArrayList<>();
        members.add(new MapMember(MemberType.SecurityRequirement_Schemes, "Schemes", "java.util.List<String>", MapNullValueStrategy.CONVERT_NULL_TO_EMPTY_LIST));
        members.add(new AdditionalMethod(Type.SecurityRequirement_addScheme_singleton));
        members.add(new AdditionalMethod(Type.SecurityRequirement_addScheme_empty));
        return new Element(ElementType.SecurityRequirement, SecurityRequirement.class.getName(), false, false, members);
    }

    public static Element createSecurityScheme() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.SecurityScheme_Type, "Type", SecurityScheme.Type.class.getCanonicalName()));
        members.add(new Member(MemberType.SecurityScheme_Description, "Description", String.class.getSimpleName()));
        members.add(new Member(MemberType.SecurityScheme_Name, "Name", String.class.getSimpleName()));
        members.add(new Member(MemberType.SecurityScheme_In, "In", SecurityScheme.In.class.getCanonicalName()));
        members.add(new Member(MemberType.SecurityScheme_Scheme, "Scheme", String.class.getSimpleName()));
        members.add(new Member(MemberType.SecurityScheme_BearerFormat, "BearerFormat", String.class.getSimpleName()));
        members.add(new Member(MemberType.SecurityScheme_Flows, "Flows", OAuthFlows.class.getCanonicalName()));
        members.add(new Member(MemberType.SecurityScheme_OpenIdConnectUrl, "OpenIdConnectUrl", String.class.getSimpleName()));
        return new Element(ElementType.SecurityScheme, SecurityScheme.class.getName(), true, true, members);
    }

    public static Element createServer() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.Server_Url, "Url", String.class.getSimpleName()));
        members.add(new Member(MemberType.Server_Description, "Description", String.class.getSimpleName()));
        members.add(new MapMember(MemberType.Server_Variables, "Variables", ServerVariable.class.getCanonicalName()));
        return new Element(ElementType.Server, Server.class.getName(), true, false, members);
    }

    public static Element createServerVariable() {
        List<IMember> members = new ArrayList<>();
        members.add(new ListMember(MemberType.ServerVariable_Enumeration, "Enumeration", String.class.getSimpleName()));
        members.add(new Member(MemberType.ServerVariable_DefaultValue, "DefaultValue", String.class.getSimpleName()));
        members.add(new Member(MemberType.ServerVariable_Description, "Description", String.class.getSimpleName()));
        return new Element(ElementType.ServerVariable, ServerVariable.class.getName(), true, false, members);
    }

    public static Element createTag() {
        List<IMember> members = new ArrayList<>();
        members.add(new Member(MemberType.Tag_Name, "Name", String.class.getSimpleName()));
        members.add(new Member(MemberType.Tag_Description, "Description", String.class.getSimpleName()));
        members.add(new Member(MemberType.Tag_ExternalDocs, "ExternalDocs", ExternalDocumentation.class.getCanonicalName()));
        return new Element(ElementType.Tag, Tag.class.getName(), true, false, members);
    }
}
