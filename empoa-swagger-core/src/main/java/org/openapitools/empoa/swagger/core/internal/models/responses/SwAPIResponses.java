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
package org.openapitools.empoa.swagger.core.internal.models.responses;

import org.eclipse.microprofile.openapi.models.responses.APIResponses;

public class SwAPIResponses implements APIResponses {

    private io.swagger.v3.oas.models.responses.ApiResponses _swAPIResponses;

    public SwAPIResponses() {
        _swAPIResponses = new io.swagger.v3.oas.models.responses.ApiResponses();
    }

    public SwAPIResponses(io.swagger.v3.oas.models.responses.ApiResponses _swAPIResponses) {
        this._swAPIResponses = _swAPIResponses;
    }

    public io.swagger.v3.oas.models.responses.ApiResponses getSw() {
        return _swAPIResponses;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swAPIResponses.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swAPIResponses.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swAPIResponses.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public APIResponses addExtension(String key, Object object) {
        _swAPIResponses.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swAPIResponses.getExtensions()
                .remove(key);
        }
    }

    private java.util.Map<String, org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponse> _aPIResponses;

    private void initAPIResponses() {
        if (_swAPIResponses == null) {
            _aPIResponses = null;
        } else if (_aPIResponses == null) {
            _aPIResponses = _swAPIResponses
                .entrySet()
                .stream()
                .collect(
                    java.util.stream.Collectors.toMap(
                        java.util.Map.Entry::getKey,
                        e -> new org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponse(e.getValue()),
                        (k1, k2) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", k1));
                        },
                        () -> new java.util.LinkedHashMap<String, org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponse>()
                    )
                );
        }
    }

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.responses.APIResponse> getAPIResponses() {
        initAPIResponses();
        if (_aPIResponses == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_aPIResponses);
    }

    @Override
    public void setAPIResponses(java.util.Map<String, org.eclipse.microprofile.openapi.models.responses.APIResponse> aPIResponses) {
        _swAPIResponses.clear();
        if (aPIResponses != null) {
            if (aPIResponses.isEmpty()) {
                _aPIResponses = new java.util.LinkedHashMap<>();
            } else {
                for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.responses.APIResponse> e : aPIResponses.entrySet()) {
                    this.addAPIResponse(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public APIResponses addAPIResponse(String key, org.eclipse.microprofile.openapi.models.responses.APIResponse aPIResponse) {
        if (!(aPIResponse instanceof org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponse)) {
            throw new IllegalArgumentException("Unexpected type: " + aPIResponse);
        }
        org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponse value = (org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponse) aPIResponse;
        initAPIResponses();
        if (_aPIResponses == null) {
            _aPIResponses = new java.util.LinkedHashMap<>();
        }
        _aPIResponses.put(key, value);
        _swAPIResponses.put(key, value.getSw());
        return this;
    }

    @Override
    public void removeAPIResponse(String key) {
        initAPIResponses();
        if (_aPIResponses != null) {
            _aPIResponses.remove(key);
            _swAPIResponses.remove(key);
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.responses.APIResponse getDefaultValue() {
        return getAPIResponse(DEFAULT);
    }

    @Override
    public void setDefaultValue(org.eclipse.microprofile.openapi.models.responses.APIResponse defaultValue) {
        if (defaultValue == null) {
            removeAPIResponse(DEFAULT);
        } else {
            addAPIResponse(DEFAULT, defaultValue);
        }
    }

}
