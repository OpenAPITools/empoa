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

import org.eclipse.microprofile.openapi.models.media.Content;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ContentSerializer implements JsonSerializer<Content> {

    @Override
    public JsonElement serialize(Content src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        if (src.getMediaTypes() != null) {
            for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.media.MediaType> entry : src.getMediaTypes()
                .entrySet()) {
                object.add(entry.getKey(), context.serialize(entry.getValue()));
            }
        }
        return object;
    }

}
