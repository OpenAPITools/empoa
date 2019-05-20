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

import org.eclipse.microprofile.openapi.models.security.OAuthFlows;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class OAuthFlowsSerializer implements JsonSerializer<OAuthFlows> {

    @Override
    public JsonElement serialize(OAuthFlows src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        if (src.getImplicit() != null) {
            object.add("implicit", context.serialize(src.getImplicit()));
        }
        if (src.getPassword() != null) {
            object.add("password", context.serialize(src.getPassword()));
        }
        if (src.getClientCredentials() != null) {
            object.add("clientCredentials", context.serialize(src.getClientCredentials()));
        }
        if (src.getAuthorizationCode() != null) {
            object.add("authorizationCode", context.serialize(src.getAuthorizationCode()));
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
