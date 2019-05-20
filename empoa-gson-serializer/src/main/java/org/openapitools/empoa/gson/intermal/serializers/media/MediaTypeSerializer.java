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

import org.eclipse.microprofile.openapi.models.media.MediaType;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class MediaTypeSerializer implements JsonSerializer<MediaType> {

    @Override
    public JsonElement serialize(MediaType src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        if (src.getSchema() != null) {
            object.add("schema", context.serialize(src.getSchema()));
        }
        if (src.getExamples() != null) {
            object.add("examples", context.serialize(src.getExamples()));
        }
        if (src.getExample() != null) {
            object.add("example", context.serialize(src.getExample()));
        }
        if (src.getEncoding() != null) {
            object.add("encoding", context.serialize(src.getEncoding()));
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
