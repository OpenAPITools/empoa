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
package org.openapitools.empoa.swagger.core.internal.models.servers;

import org.eclipse.microprofile.openapi.models.servers.Server;

public class SwServer implements Server {

    private io.swagger.v3.oas.models.servers.Server _swServer;

    public SwServer() {
        _swServer = new io.swagger.v3.oas.models.servers.Server();
    }

    public SwServer(io.swagger.v3.oas.models.servers.Server _swServer) {
        this._swServer = _swServer;
    }

    public io.swagger.v3.oas.models.servers.Server getSw() {
        return _swServer;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swServer.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swServer.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swServer.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Server addExtension(String key, Object object) {
        _swServer.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swServer.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getUrl() {
        return _swServer.getUrl();
    }

    @Override
    public void setUrl(String url) {
        _swServer.setUrl(url);
    }

    @Override
    public String getDescription() {
        return _swServer.getDescription();
    }

    @Override
    public void setDescription(String description) {
        _swServer.setDescription(description);
    }

    private java.util.Map<String, org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariable> _variables;

    private void initCallbacks() {
        if (_swServer.getVariables() == null) {
            _variables = null;
        } else if (_variables == null) {
            _variables = _swServer.getVariables()
                .entrySet()
                .stream()
                .collect(
                    java.util.stream.Collectors.toMap(
                        java.util.Map.Entry::getKey,
                        e -> new org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariable(e.getValue()),
                        (k1, k2) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", k1));
                        },
                        () -> new java.util.LinkedHashMap<String, org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariable>()
                    )
                );
        }
    }

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.servers.ServerVariable> getVariables() {
        initCallbacks();
        if (_variables == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_variables);
    }

    @Override
    public void setVariables(java.util.Map<String, org.eclipse.microprofile.openapi.models.servers.ServerVariable> callbacks) {
        _swServer.setVariables(null);
        if (callbacks != null) {
            if (callbacks.isEmpty()) {
                _swServer.setVariables(new io.swagger.v3.oas.models.servers.ServerVariables());
            } else {
                for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.servers.ServerVariable> e : callbacks.entrySet()) {
                    this.addVariable(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Server addVariable(String key, org.eclipse.microprofile.openapi.models.servers.ServerVariable callback) {
        if (!(callback instanceof org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariable)) {
            throw new IllegalArgumentException("Unexpected type: " + callback);
        }
        org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariable value = (org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariable) callback;
        initCallbacks();
        if (_variables == null) {
            _variables = new java.util.LinkedHashMap<>();
            _swServer.setVariables(new io.swagger.v3.oas.models.servers.ServerVariables());
        }
        _variables.put(key, value);
        _swServer.getVariables()
            .put(key, value.getSw());
        return this;
    }

    @Override
    public void removeVariable(String key) {
        initCallbacks();
        if (_variables != null) {
            _variables.remove(key);
            _swServer.getVariables()
                .remove(key);
        }
    }

}
