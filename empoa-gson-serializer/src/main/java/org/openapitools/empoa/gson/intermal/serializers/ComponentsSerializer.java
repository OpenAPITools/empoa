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

import org.eclipse.microprofile.openapi.models.Components;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ComponentsSerializer implements JsonSerializer<Components> {

    @Override
    public JsonElement serialize(Components src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        if (src.getSchemas() != null) {
            object.add("schemas", context.serialize(src.getSchemas()));
        }
        if (src.getResponses() != null) {
            object.add("responses", context.serialize(src.getResponses()));
        }
        if (src.getParameters() != null) {
            object.add("parameters", context.serialize(src.getParameters()));
        }
        if (src.getExamples() != null) {
            object.add("examples", context.serialize(src.getExamples()));
        }
        if (src.getRequestBodies() != null) {
            object.add("requestBodies", context.serialize(src.getRequestBodies()));
        }
        if (src.getHeaders() != null) {
            object.add("headers", context.serialize(src.getHeaders()));
        }
        if (src.getSecuritySchemes() != null) {
            object.add("securitySchemes", context.serialize(src.getSecuritySchemes()));
        }
        if (src.getLinks() != null) {
            object.add("links", context.serialize(src.getLinks()));
        }
        if (src.getCallbacks() != null) {
            object.add("callbacks", context.serialize(src.getCallbacks()));
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
