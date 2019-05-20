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
package org.openapitools.empoa.gson.intermal.serializers.security;

import java.lang.reflect.Type;

import org.eclipse.microprofile.openapi.models.security.SecurityScheme;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class SecuritySchemeSerializer implements JsonSerializer<SecurityScheme> {

    @Override
    public JsonElement serialize(SecurityScheme src, Type typeOfSrc, JsonSerializationContext context) {
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
            if (src.getDescription() != null) {
                object.add("description", context.serialize(src.getDescription()));
            }
            if (src.getName() != null) {
                object.add("name", context.serialize(src.getName()));
            }
            if (src.getIn() != null) {
                object.add(
                    "in", context.serialize(
                        src.getIn()
                            .toString()
                    )
                );
            }
            if (src.getScheme() != null) {
                object.add("scheme", context.serialize(src.getScheme()));
            }
            if (src.getBearerFormat() != null) {
                object.add("bearerFormat", context.serialize(src.getBearerFormat()));
            }
            if (src.getFlows() != null) {
                object.add("flows", context.serialize(src.getFlows()));
            }
            if (src.getOpenIdConnectUrl() != null) {
                object.add("openIdConnectUrl", context.serialize(src.getOpenIdConnectUrl()));
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
