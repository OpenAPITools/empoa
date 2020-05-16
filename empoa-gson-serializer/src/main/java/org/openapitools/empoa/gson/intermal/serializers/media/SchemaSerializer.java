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
package org.openapitools.empoa.gson.intermal.serializers.media;

import java.lang.reflect.Type;

import org.eclipse.microprofile.openapi.models.media.Schema;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class SchemaSerializer implements JsonSerializer<Schema> {

    @Override
    public JsonElement serialize(Schema src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        if (src.getRef() != null) {
            object.addProperty("$ref", src.getRef());
        } else {

            if (src.getType() != null) {
                object.add(
                    "type", context.serialize(
                        src.getType()
                            .toString()
                    )
                );
            }
            if (src.getFormat() != null) {
                object.add("format", context.serialize(src.getFormat()));
            }
            if (src.getTitle() != null) {
                object.add("title", context.serialize(src.getTitle()));
            }
            if (src.getDescription() != null) {
                object.add("description", context.serialize(src.getDescription()));
            }
            if (src.getDiscriminator() != null) {
                object.add("discriminator", context.serialize(src.getDiscriminator()));
            }
            if (src.getDefaultValue() != null) {
                object.add("default", context.serialize(src.getDefaultValue()));
            }
            if (src.getEnumeration() != null) {
                object.add("enum", context.serialize(src.getEnumeration()));
            }
            if (src.getMultipleOf() != null) {
                object.add("multipleOf", context.serialize(src.getMultipleOf()));
            }
            if (src.getMaximum() != null) {
                object.add("maximum", context.serialize(src.getMaximum()));
            }
            if (src.getExclusiveMaximum() != null) {
                object.add("exclusiveMaximum", context.serialize(src.getExclusiveMaximum()));
            }
            if (src.getMinimum() != null) {
                object.add("minimum", context.serialize(src.getMinimum()));
            }
            if (src.getExclusiveMinimum() != null) {
                object.add("exclusiveMinimum", context.serialize(src.getExclusiveMinimum()));
            }
            if (src.getMaxLength() != null) {
                object.add("maxLength", context.serialize(src.getMaxLength()));
            }
            if (src.getMinLength() != null) {
                object.add("minLength", context.serialize(src.getMinLength()));
            }
            if (src.getPattern() != null) {
                object.add("pattern", context.serialize(src.getPattern()));
            }
            if (src.getMaxItems() != null) {
                object.add("maxItems", context.serialize(src.getMaxItems()));
            }
            if (src.getMinItems() != null) {
                object.add("minItems", context.serialize(src.getMinItems()));
            }
            if (src.getUniqueItems() != null) {
                object.add("uniqueItems", context.serialize(src.getUniqueItems()));
            }
            if (src.getMaxProperties() != null) {
                object.add("maxProperties", context.serialize(src.getMaxProperties()));
            }
            if (src.getMinProperties() != null) {
                object.add("minProperties", context.serialize(src.getMinProperties()));
            }
            if (src.getRequired() != null) {
                object.add("required", context.serialize(src.getRequired()));
            }
            if (src.getNot() != null) {
                object.add("not", context.serialize(src.getNot()));
            }
            if (src.getProperties() != null) {
                object.add("properties", context.serialize(src.getProperties()));
            }
            if (src.getAdditionalPropertiesSchema() != null) {
                object.add("additionalProperties", context.serialize(src.getAdditionalPropertiesSchema()));
            }
            if (src.getAdditionalPropertiesBoolean() != null) {
                object.add("additionalProperties", context.serialize(src.getAdditionalPropertiesBoolean()));
            }
            if (src.getNullable() != null) {
                object.add("nullable", context.serialize(src.getNullable()));
            }
            if (src.getReadOnly() != null) {
                object.add("readOnly", context.serialize(src.getReadOnly()));
            }
            if (src.getWriteOnly() != null) {
                object.add("writeOnly", context.serialize(src.getWriteOnly()));
            }
            if (src.getExample() != null) {
                object.add("example", context.serialize(src.getExample()));
            }
            if (src.getExternalDocs() != null) {
                object.add("externalDocs", context.serialize(src.getExternalDocs()));
            }
            if (src.getDeprecated() != null) {
                object.add("deprecated", context.serialize(src.getDeprecated()));
            }
            if (src.getXml() != null) {
                object.add("xml", context.serialize(src.getXml()));
            }
            if (src.getItems() != null) {
                object.add("items", context.serialize(src.getItems()));
            }
            if (src.getAllOf() != null) {
                object.add("allOf", context.serialize(src.getAllOf()));
            }
            if (src.getAnyOf() != null) {
                object.add("anyOf", context.serialize(src.getAnyOf()));
            }
            if (src.getOneOf() != null) {
                object.add("oneOf", context.serialize(src.getOneOf()));
            }
            if (src.getExtensions() != null) {
                for (java.util.Map.Entry<String, Object> extension : src.getExtensions()
                    .entrySet()) {
                    object.add(extension.getKey(), context.serialize(extension.getValue()));
                }
            }
        }
        return object;
    }

}
