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

import org.eclipse.microprofile.openapi.models.PathItem;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class PathItemSerializer implements JsonSerializer<PathItem> {

    @Override
    public JsonElement serialize(PathItem src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        if (src.getRef() != null) {
            object.addProperty("$ref", src.getRef());
        } else {

            if (src.getSummary() != null) {
                object.add("summary", context.serialize(src.getSummary()));
            }
            if (src.getDescription() != null) {
                object.add("description", context.serialize(src.getDescription()));
            }
            if (src.getGET() != null) {
                object.add("get", context.serialize(src.getGET()));
            }
            if (src.getPUT() != null) {
                object.add("put", context.serialize(src.getPUT()));
            }
            if (src.getPOST() != null) {
                object.add("post", context.serialize(src.getPOST()));
            }
            if (src.getDELETE() != null) {
                object.add("delete", context.serialize(src.getDELETE()));
            }
            if (src.getOPTIONS() != null) {
                object.add("options", context.serialize(src.getOPTIONS()));
            }
            if (src.getHEAD() != null) {
                object.add("head", context.serialize(src.getHEAD()));
            }
            if (src.getPATCH() != null) {
                object.add("patch", context.serialize(src.getPATCH()));
            }
            if (src.getTRACE() != null) {
                object.add("trace", context.serialize(src.getTRACE()));
            }
            if (src.getServers() != null) {
                object.add("servers", context.serialize(src.getServers()));
            }
            if (src.getParameters() != null) {
                object.add("parameters", context.serialize(src.getParameters()));
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
