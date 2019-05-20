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
package org.openapitools.empoa.simple.internal.models.security;

import org.eclipse.microprofile.openapi.models.security.SecurityRequirement;

public class SecurityRequirementImpl implements SecurityRequirement {

    private java.util.Map<String, java.util.List<String>> _schemes;

    @Override
    public java.util.Map<String, java.util.List<String>> getSchemes() {
        if (_schemes == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_schemes);
    }

    @Override
    public void setSchemes(java.util.Map<String, java.util.List<String>> schemes) {
        if (schemes == null) {
            _schemes = null;
        } else {
            _schemes = new java.util.LinkedHashMap<>();
            _schemes.putAll(schemes);
        }
    }

    @Override
    public SecurityRequirement addScheme(String key, java.util.List<String> list) {
        if (list == null) {
            list = java.util.Collections.emptyList();
        }
        if (_schemes == null) {
            _schemes = new java.util.LinkedHashMap<>();
        }
        _schemes.put(key, list);
        return this;
    }

    @Override
    public void removeScheme(String key) {
        if (_schemes != null) {
            _schemes.remove(key);
        }
    }

    @Override
    public SecurityRequirement addScheme(String key, String scope) {
        java.util.List<String> list = new java.util.ArrayList<>();
        if (scope != null) {
            list.add(scope);
        }
        return addScheme(key, list);
    }

    @Override
    public SecurityRequirement addScheme(String key) {
        return addScheme(key, new java.util.ArrayList<>());
    }

}
