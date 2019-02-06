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
package org.openapitools.empoa.gson.intermal.serializers;

import java.lang.reflect.Type;

import org.eclipse.microprofile.openapi.models.OpenAPI;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class OpenAPISerializer implements JsonSerializer<OpenAPI> {

    @Override
    public JsonElement serialize(OpenAPI src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        if (src.getOpenapi() != null) {
            object.add("openapi", context.serialize(src.getOpenapi()));
        }
        if (src.getInfo() != null) {
            object.add("info", context.serialize(src.getInfo()));
        }
        if (src.getExternalDocs() != null) {
            object.add("externalDocs", context.serialize(src.getExternalDocs()));
        }
        if (src.getServers() != null) {
            object.add("servers", context.serialize(src.getServers()));
        }
        if (src.getSecurity() != null) {
            object.add("security", context.serialize(src.getSecurity()));
        }
        if (src.getTags() != null) {
            object.add("tags", context.serialize(src.getTags()));
        }
        if (src.getPaths() != null) {
            object.add("paths", context.serialize(src.getPaths()));
        }
        if (src.getComponents() != null) {
            object.add("components", context.serialize(src.getComponents()));
        }
        if (src.getExtensions() != null) {
            for (java.util.Map.Entry<String, Object> extension : src.getExtensions()
                .entrySet()) {
                object.add(extension.getKey(), context.serialize(extension.getValue()));
            }
        }
        return object;
    }

}
