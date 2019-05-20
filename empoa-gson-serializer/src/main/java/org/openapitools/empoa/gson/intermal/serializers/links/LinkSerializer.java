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
package org.openapitools.empoa.gson.intermal.serializers.links;

import java.lang.reflect.Type;

import org.eclipse.microprofile.openapi.models.links.Link;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LinkSerializer implements JsonSerializer<Link> {

    @Override
    public JsonElement serialize(Link src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        if (src.getRef() != null) {
            object.addProperty("$ref", src.getRef());
        } else {

            if (src.getServer() != null) {
                object.add("server", context.serialize(src.getServer()));
            }
            if (src.getOperationRef() != null) {
                object.add("operationRef", context.serialize(src.getOperationRef()));
            }
            if (src.getRequestBody() != null) {
                object.add("requestBody", context.serialize(src.getRequestBody()));
            }
            if (src.getOperationId() != null) {
                object.add("operationId", context.serialize(src.getOperationId()));
            }
            if (src.getParameters() != null) {
                object.add("parameters", context.serialize(src.getParameters()));
            }
            if (src.getDescription() != null) {
                object.add("description", context.serialize(src.getDescription()));
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
