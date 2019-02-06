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

    private org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariables _variables;

    private void initVariables() {
        if (_swServer.getVariables() == null) {
            _variables = null;
        } else if (_variables == null) {
            _variables = new org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariables(_swServer.getVariables());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.servers.ServerVariables getVariables() {
        initVariables();
        return _variables;
    }

    @Override
    public void setVariables(org.eclipse.microprofile.openapi.models.servers.ServerVariables variables) {
        if (variables != null) {
            if (!(variables instanceof org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariables)) {
                throw new IllegalArgumentException("Unexpected type: " + variables);
            }
            _variables = (org.openapitools.empoa.swagger.core.internal.models.servers.SwServerVariables) variables;
            _swServer.setVariables(_variables.getSw());
        } else {
            _variables = null;
            _swServer.setVariables(null);
        }
    }

}
