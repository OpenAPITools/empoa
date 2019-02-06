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

import org.eclipse.microprofile.openapi.models.media.XML;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class XMLSerializer implements JsonSerializer<XML> {

    @Override
    public JsonElement serialize(XML src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        if (src.getName() != null) {
            object.add("name", context.serialize(src.getName()));
        }
        if (src.getNamespace() != null) {
            object.add("namespace", context.serialize(src.getNamespace()));
        }
        if (src.getPrefix() != null) {
            object.add("prefix", context.serialize(src.getPrefix()));
        }
        if (src.getAttribute() != null) {
            object.add("attribute", context.serialize(src.getAttribute()));
        }
        if (src.getWrapped() != null) {
            object.add("wrapped", context.serialize(src.getWrapped()));
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
