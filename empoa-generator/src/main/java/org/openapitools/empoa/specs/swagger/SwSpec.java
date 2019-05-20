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
package org.openapitools.empoa.specs.swagger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.openapi.models.Components;
import org.eclipse.microprofile.openapi.models.ExternalDocumentation;
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
import org.openapitools.empoa.specs.AdditionalMethod;
import org.openapitools.empoa.specs.AdditionalMethod.Type;
import org.openapitools.empoa.specs.IMember;
import org.openapitools.empoa.specs.MemberType;
import org.openapitools.empoa.specs.OpenAPISpec;

/**
 * @author jbr
 *
 */
public class SwSpec {

    public static List<SwElement> elements() {
        List<SwElement> elements = new ArrayList<>();
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
        elements.add(createScopes());
        elements.add(createSecurityRequirement());
        elements.add(createSecurityScheme());

        // org.eclipse.microprofile.openapi.models.servers
        elements.add(createServer());
        elements.add(createServerVariable());
        elements.add(createServerVariables());

        // org.eclipse.microprofile.openapi.models.tag
        elements.add(createTag());

        return elements;
    }

    public static SwElement createComponents() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMapMember(MemberType.Components_Schemas, "Schemas", Schema.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.Components_Responses, "Responses", APIResponse.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.Components_Parameters, "Parameters", Parameter.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.Components_Examples, "Examples", Example.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.Components_RequestBodies, "RequestBodies", RequestBody.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.Components_Headers, "Headers", Header.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.Components_SecuritySchemes, "SecuritySchemes", SecurityScheme.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.Components_Links, "Links", Link.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.Components_Callbacks, "Callbacks", Callback.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createComponents(), io.swagger.v3.oas.models.Components.class.getCanonicalName(), members);
    }

    public static SwElement createExternalDocumentation() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.ExternalDocumentation_Description, "Description", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.ExternalDocumentation_Url, "Url", String.class.getSimpleName()));
        return new SwElement(OpenAPISpec.createExternalDocumentation(), io.swagger.v3.oas.models.ExternalDocumentation.class.getCanonicalName(), members);
    }

    public static SwElement createOpenAPI() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.OpenAPI_Openapi, "Openapi", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.OpenAPI_Info, "Info", Info.class.getCanonicalName()));
        members.add(new SwMember(MemberType.OpenAPI_ExternalDocs, "ExternalDocs", ExternalDocumentation.class.getCanonicalName()));
        members.add(new SwListMember(MemberType.OpenAPI_Servers, "Servers", Server.class.getCanonicalName()));
        members.add(new SwListMember(MemberType.OpenAPI_Security, "Security", SecurityRequirement.class.getCanonicalName(), "addSecurityRequirement"));
        members.add(new SwListMember(MemberType.OpenAPI_Tags, "Tags", Tag.class.getCanonicalName()));
        members.add(new SwMember(MemberType.OpenAPI_Paths, "Paths", Paths.class.getCanonicalName()));
        members.add(new SwMember(MemberType.OpenAPI_Components, "Components", Components.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createOpenAPI(), io.swagger.v3.oas.models.OpenAPI.class.getCanonicalName(), members);
    }

    public static SwElement createOperation() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwListMember(MemberType.Operation_Tags, "Tags", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Operation_Summary, "Summary", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Operation_Description, "Description", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Operation_ExternalDocs, "ExternalDocs", ExternalDocumentation.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Operation_OperationId, "OperationId", String.class.getSimpleName()));
        members.add(new SwListMember(MemberType.Operation_Parameters, "Parameters", Parameter.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Operation_RequestBody, "RequestBody", RequestBody.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Operation_Responses, "Responses", APIResponses.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.Operation_Callbacks, "Callbacks", Callback.class.getCanonicalName(), true, true));
        members.add(new SwMember(MemberType.Operation_Deprecated, "Deprecated", Boolean.class.getSimpleName()));
        members.add(new SwListMember(MemberType.Operation_Security, "Security", SecurityRequirement.class.getName(), "addSecurityRequirement"));
        members.add(new SwListMember(MemberType.Operation_Servers, "Servers", Server.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createOperation(), io.swagger.v3.oas.models.Operation.class.getCanonicalName(), members);
    }

    public static SwElement createPathItem() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.PathItem_Summary, "Summary", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.PathItem_Description, "Description", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.PathItem_GET, "Get", Operation.class.getCanonicalName()));
        members.add(new SwMember(MemberType.PathItem_PUT, "Put", Operation.class.getCanonicalName()));
        members.add(new SwMember(MemberType.PathItem_POST, "Post", Operation.class.getCanonicalName()));
        members.add(new SwMember(MemberType.PathItem_DELETE, "Delete", Operation.class.getCanonicalName()));
        members.add(new SwMember(MemberType.PathItem_OPTIONS, "Options", Operation.class.getCanonicalName()));
        members.add(new SwMember(MemberType.PathItem_HEAD, "Head", Operation.class.getCanonicalName()));
        members.add(new SwMember(MemberType.PathItem_PATCH, "Patch", Operation.class.getCanonicalName()));
        members.add(new SwMember(MemberType.PathItem_TRACE, "Trace", Operation.class.getCanonicalName()));
        members.add(new AdditionalMethod(Type.PathItem_getOperations));
        members.add(new SwListMember(MemberType.PathItem_Servers, "Servers", Server.class.getCanonicalName()));
        members.add(new SwListMember(MemberType.PathItem_Parameters, "Parameters", Parameter.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createPathItem(), io.swagger.v3.oas.models.PathItem.class.getCanonicalName(), members);
    }

    public static SwElement createPaths() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMapMember(MemberType.Paths_PathItems, "PathItems", PathItem.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createPaths(), io.swagger.v3.oas.models.Paths.class.getCanonicalName(), members);
    }

    public static SwElement createCallback() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMapMember(MemberType.Callback_PathItems, "PathItems", PathItem.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createCallback(), io.swagger.v3.oas.models.callbacks.Callback.class.getCanonicalName(), members);
    }

    public static SwElement createExample() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.Example_Summary, "Summary", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Example_Description, "Description", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Example_Value, "Value", Object.class.getSimpleName()));
        members.add(new SwMember(MemberType.Example_ExternalValue, "ExternalValue", String.class.getSimpleName()));
        return new SwElement(OpenAPISpec.createExample(), io.swagger.v3.oas.models.examples.Example.class.getCanonicalName(), members);
    }

    public static SwElement createHeader() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.Header_Description, "Description", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Header_Required, "Required", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Header_Deprecated, "Deprecated", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Header_AllowEmptyValue, "AllowEmptyValue", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Header_Style, "Style", io.swagger.v3.oas.models.headers.Header.StyleEnum.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Header_Explode, "Explode", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Header_Schema, "Schema", Schema.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.Header_Examples, "Examples", Example.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Header_Example, "Example", Object.class.getSimpleName()));
        members.add(new SwMember(MemberType.Header_Content, "Content", Content.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createHeader(), io.swagger.v3.oas.models.headers.Header.class.getCanonicalName(), members);
    }

    public static SwElement createContact() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.Contact_Name, "Name", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Contact_Url, "Url", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Contact_Email, "Email", String.class.getSimpleName()));
        return new SwElement(OpenAPISpec.createContact(), io.swagger.v3.oas.models.info.Contact.class.getCanonicalName(), members);
    }

    public static SwElement createInfo() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.Info_Title, "Title", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Info_Description, "Description", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Info_TermsOfService, "TermsOfService", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Info_Contact, "Contact", Contact.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Info_License, "License", License.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Info_Version, "Version", String.class.getSimpleName()));
        return new SwElement(OpenAPISpec.createInfo(), io.swagger.v3.oas.models.info.Info.class.getCanonicalName(), members);
    }

    public static SwElement createLicense() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.License_Name, "Name", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.License_Url, "Url", String.class.getSimpleName()));
        return new SwElement(OpenAPISpec.createLicense(), io.swagger.v3.oas.models.info.License.class.getCanonicalName(), members);
    }

    public static SwElement createLink() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.Link_Server, "Server", Server.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Link_OperationRef, "OperationRef", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Link_RequestBody, "RequestBody", Object.class.getSimpleName()));
        members.add(new SwMember(MemberType.Link_OperationId, "OperationId", String.class.getSimpleName()));
        members.add(new SwMapMember(MemberType.Link_Parameters, "Parameters", Object.class.getSimpleName()));
        members.add(new SwMember(MemberType.Link_Description, "Description", String.class.getSimpleName()));
        return new SwElement(OpenAPISpec.createLink(), io.swagger.v3.oas.models.links.Link.class.getCanonicalName(), members);
    }

    public static SwElement createContent() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMapMember(MemberType.Content_MediaTypes, "MediaTypes", MediaType.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createContent(), io.swagger.v3.oas.models.media.Content.class.getCanonicalName(), members);
    }

    public static SwElement createDiscriminator() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.Discriminator_PropertyName, "PropertyName", String.class.getSimpleName()));
        members.add(new SwMapMember(MemberType.Discriminator_Mapping, "Mapping", String.class.getSimpleName()));
        return new SwElement(OpenAPISpec.createDiscriminator(), io.swagger.v3.oas.models.media.Discriminator.class.getCanonicalName(), members);
    }

    public static SwElement createEncoding() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.Encoding_ContentType, "ContentType", String.class.getSimpleName()));
        members.add(new SwMapMember(MemberType.Encoding_Headers, "Headers", Header.class.getName(), true, true));
        members.add(new SwMember(MemberType.Encoding_Style, "Style", io.swagger.v3.oas.models.media.Encoding.StyleEnum.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Encoding_Explode, "Explode", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Encoding_AllowReserved, "AllowReserved", Boolean.class.getSimpleName()));
        return new SwElement(OpenAPISpec.createEncoding(), io.swagger.v3.oas.models.media.Encoding.class.getCanonicalName(), members);
    }

    public static SwElement createMediaType() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.MediaType_Schema, "Schema", Schema.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.MediaType_Examples, "Examples", Example.class.getCanonicalName()));
        members.add(new SwMember(MemberType.MediaType_Example, "Example", Object.class.getSimpleName()));
        members.add(new SwMapMember(MemberType.MediaType_Encoding, "Encoding", Encoding.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createMediaType(), io.swagger.v3.oas.models.media.MediaType.class.getCanonicalName(), members);
    }

    public static SwElement createSchema() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.Schema_Discriminator, "Discriminator", Discriminator.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Schema_Title, "Title", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_DefaultValue, "Default", Object.class.getSimpleName()));
        members.add(new SwListMember(MemberType.Schema_Enumeration, "Enum", Object.class.getSimpleName(), "addEnumItemObject"));
        members.add(new SwMember(MemberType.Schema_MultipleOf, "MultipleOf", BigDecimal.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Schema_Maximum, "Maximum", BigDecimal.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Schema_ExclusiveMaximum, "ExclusiveMaximum", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_Minimum, "Minimum", BigDecimal.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Schema_ExclusiveMinimum, "ExclusiveMinimum", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_MaxLength, "MaxLength", Integer.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_MinLength, "MinLength", Integer.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_Pattern, "Pattern", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_MaxItems, "MaxItems", Integer.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_MinItems, "MinItems", Integer.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_UniqueItems, "UniqueItems", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_MaxProperties, "MaxProperties", Integer.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_MinProperties, "MinProperties", Integer.class.getSimpleName()));
        members.add(new SwListMember(MemberType.Schema_Required, "Required", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_Type, "Type", Schema.SchemaType.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_Not, "Not", Schema.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.Schema_Properties, "Properties", Schema.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Schema_AdditionalProperties_Schema, "AdditionalPropertiesSchema", Schema.class.getCanonicalName(), true, true, false, true));
        members.add(new AdditionalMethod(Type.Schema_setAdditionalPropertiesSchema));
        members.add(new SwMember(MemberType.Schema_AdditionalProperties_Boolean, "AdditionalPropertiesBoolean", Boolean.class.getSimpleName(), true, true, false, true));
        members.add(new AdditionalMethod(Type.Schema_setAdditionalPropertiesBoolean));
        members.add(new SwMember(MemberType.Schema_Description, "Description", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_Format, "Format", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_Nullable, "Nullable", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_ReadOnly, "ReadOnly", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_WriteOnly, "WriteOnly", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_Example, "Example", Object.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_ExternalDocs, "ExternalDocs", ExternalDocumentation.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Schema_Deprecated, "Deprecated", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Schema_Xml, "Xml", XML.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Schema_Items, "Items", Schema.class.getCanonicalName()));
        members.add(new SwListMember(MemberType.Schema_AllOf, "AllOf", Schema.class.getCanonicalName()));
        members.add(new SwListMember(MemberType.Schema_AnyOf, "AnyOf", Schema.class.getCanonicalName()));
        members.add(new SwListMember(MemberType.Schema_OneOf, "OneOf", Schema.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createSchema(), io.swagger.v3.oas.models.media.Schema.class.getCanonicalName(), members);
    }

    public static SwElement createXML() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.XML_Name, "Name", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.XML_Namespace, "Namespace", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.XML_Prefix, "Prefix", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.XML_Attribute, "Attribute", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.XML_Wrapped, "Wrapped", Boolean.class.getSimpleName()));
        return new SwElement(OpenAPISpec.createXML(), io.swagger.v3.oas.models.media.XML.class.getCanonicalName(), members);
    }

    public static SwElement createParameter() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.Parameter_Name, "Name", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Parameter_In, "In", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Parameter_Description, "Description", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Parameter_Required, "Required", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Parameter_Deprecated, "Deprecated", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Parameter_AllowEmptyValue, "AllowEmptyValue", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Parameter_Style, "Style", io.swagger.v3.oas.models.parameters.Parameter.StyleEnum.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Parameter_Explode, "Explode", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Parameter_AllowReserved, "AllowReserved", Boolean.class.getSimpleName()));
        members.add(new SwMember(MemberType.Parameter_Schema, "Schema", Schema.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.Parameter_Examples, "Examples", Example.class.getCanonicalName()));
        members.add(new SwMember(MemberType.Parameter_Example, "Example", Object.class.getSimpleName()));
        members.add(new SwMember(MemberType.Parameter_Content, "Content", Content.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createParameter(), io.swagger.v3.oas.models.parameters.Parameter.class.getCanonicalName(), members);
    }

    public static SwElement createRequestBody() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.RequestBody_Description, "Description", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.RequestBody_Content, "Content", Content.class.getCanonicalName()));
        members.add(new SwMember(MemberType.RequestBody_Required, "Required", Boolean.class.getSimpleName()));
        return new SwElement(OpenAPISpec.createRequestBody(), io.swagger.v3.oas.models.parameters.RequestBody.class.getCanonicalName(), members);
    }

    public static SwElement createAPIResponse() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.APIResponse_Description, "Description", String.class.getSimpleName()));
        members.add(new SwMapMember(MemberType.APIResponse_Headers, "Headers", Header.class.getCanonicalName()));
        members.add(new SwMember(MemberType.APIResponse_Content, "Content", Content.class.getCanonicalName()));
        members.add(new SwMapMember(MemberType.APIResponse_Links, "Links", Link.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createAPIResponse(), io.swagger.v3.oas.models.responses.ApiResponse.class.getCanonicalName(), members);
    }

    public static SwElement createAPIResponses() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMapMember(MemberType.APIResponses_APIResponses, "APIResponses", APIResponse.class.getCanonicalName()));
        members.add(new AdditionalMethod(Type.APIResponses_getDefaultValue));
        members.add(new AdditionalMethod(Type.APIResponses_setDefaultValue));
        return new SwElement(OpenAPISpec.createAPIResponses(), io.swagger.v3.oas.models.responses.ApiResponses.class.getCanonicalName(), members);
    }

    public static SwElement createOAuthFlow() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.OAuthFlow_AuthorizationUrl, "AuthorizationUrl", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.OAuthFlow_TokenUrl, "TokenUrl", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.OAuthFlow_RefreshUrl, "RefreshUrl", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.OAuthFlow_Scopes, "Scopes", Scopes.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createOAuthFlow(), io.swagger.v3.oas.models.security.OAuthFlow.class.getCanonicalName(), members);
    }

    public static SwElement createOAuthFlows() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.OAuthFlows_Implicit, "Implicit", OAuthFlow.class.getCanonicalName()));
        members.add(new SwMember(MemberType.OAuthFlows_Password, "Password", OAuthFlow.class.getCanonicalName()));
        members.add(new SwMember(MemberType.OAuthFlows_ClientCredentials, "ClientCredentials", OAuthFlow.class.getCanonicalName()));
        members.add(new SwMember(MemberType.OAuthFlows_AuthorizationCode, "AuthorizationCode", OAuthFlow.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createOAuthFlows(), io.swagger.v3.oas.models.security.OAuthFlows.class.getCanonicalName(), members);
    }

    public static SwElement createScopes() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMapMember(MemberType.Scopes_Scopes, "Scopes", String.class.getSimpleName()));
        return new SwElement(OpenAPISpec.createScopes(), io.swagger.v3.oas.models.security.Scopes.class.getCanonicalName(), members);
    }

    public static SwElement createSecurityRequirement() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMapMember(MemberType.SecurityRequirement_Schemes, "Schemes", "java.util.List<String>"));
        members.add(new AdditionalMethod(Type.SecurityRequirement_addScheme_singleton));
        members.add(new AdditionalMethod(Type.SecurityRequirement_addScheme_empty));
        return new SwElement(OpenAPISpec.createSecurityRequirement(), io.swagger.v3.oas.models.security.SecurityRequirement.class.getCanonicalName(), members);
    }

    public static SwElement createSecurityScheme() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.SecurityScheme_Type, "Type", io.swagger.v3.oas.models.security.SecurityScheme.Type.class.getCanonicalName()));
        members.add(new SwMember(MemberType.SecurityScheme_Description, "Description", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.SecurityScheme_Name, "Name", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.SecurityScheme_In, "In", io.swagger.v3.oas.models.security.SecurityScheme.In.class.getCanonicalName()));
        members.add(new SwMember(MemberType.SecurityScheme_Scheme, "Scheme", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.SecurityScheme_BearerFormat, "BearerFormat", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.SecurityScheme_Flows, "Flows", OAuthFlows.class.getCanonicalName()));
        members.add(new SwMember(MemberType.SecurityScheme_OpenIdConnectUrl, "OpenIdConnectUrl", String.class.getSimpleName()));
        return new SwElement(OpenAPISpec.createSecurityScheme(), io.swagger.v3.oas.models.security.SecurityScheme.class.getCanonicalName(), members);
    }

    public static SwElement createServer() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.Server_Url, "Url", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Server_Description, "Description", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Server_Variables, "Variables", ServerVariables.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createServer(), io.swagger.v3.oas.models.servers.Server.class.getCanonicalName(), members);
    }

    public static SwElement createServerVariable() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwListMember(MemberType.ServerVariable_Enumeration, "Enum", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.ServerVariable_DefaultValue, "Default", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.ServerVariable_Description, "Description", String.class.getSimpleName()));
        return new SwElement(OpenAPISpec.createServerVariable(), io.swagger.v3.oas.models.servers.ServerVariable.class.getCanonicalName(), members);
    }

    public static SwElement createServerVariables() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMapMember(MemberType.ServerVariables_ServerVariables, "ServerVariables", ServerVariable.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createServerVariables(), io.swagger.v3.oas.models.servers.ServerVariables.class.getCanonicalName(), members);
    }

    public static SwElement createTag() {
        List<IMember> members = new ArrayList<>();
        members.add(new SwMember(MemberType.Tag_Name, "Name", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Tag_Description, "Description", String.class.getSimpleName()));
        members.add(new SwMember(MemberType.Tag_ExternalDocs, "ExternalDocs", ExternalDocumentation.class.getCanonicalName()));
        return new SwElement(OpenAPISpec.createTag(), io.swagger.v3.oas.models.tags.Tag.class.getCanonicalName(), members);
    }
}
