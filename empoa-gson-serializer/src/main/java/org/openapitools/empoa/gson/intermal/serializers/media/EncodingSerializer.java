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

import org.eclipse.microprofile.openapi.models.media.Encoding;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class EncodingSerializer implements JsonSerializer<Encoding> {

    @Override
    public JsonElement serialize(Encoding src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        if (src.getContentType() != null) {
            object.add("contentType", context.serialize(src.getContentType()));
        }
        if (src.getHeaders() != null) {
            object.add("headers", context.serialize(src.getHeaders()));
        }
        if (src.getStyle() != null) {
            object.add(
                "style", context.serialize(
                    src.getStyle()
                        .toString()
                )
            );
        }
        if (src.getExplode() != null) {
            object.add("explode", context.serialize(src.getExplode()));
        }
        if (src.getAllowReserved() != null) {
            object.add("allowReserved", context.serialize(src.getAllowReserved()));
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
