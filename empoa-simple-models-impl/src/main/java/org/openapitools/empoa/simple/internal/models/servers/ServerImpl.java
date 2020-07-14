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
package org.openapitools.empoa.simple.internal.models.servers;

import org.eclipse.microprofile.openapi.models.servers.Server;

public class ServerImpl implements Server {

    private java.util.Map<String, Object> _extensions;

    @Override
    public java.util.Map<String, Object> getExtensions() {
        if (_extensions == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_extensions);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        if (extensions == null) {
            _extensions = null;
        } else {
            _extensions = new java.util.LinkedHashMap<>();
            _extensions.putAll(extensions);
        }
    }

    @Override
    public Server addExtension(String key, Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_extensions == null) {
                _extensions = new java.util.LinkedHashMap<>();
            }
            _extensions.put(key, object);
        }
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (_extensions != null) {
            _extensions.remove(key);
        }
    }

    private String _url;

    @Override
    public String getUrl() {
        return _url;
    }

    @Override
    public void setUrl(String url) {
        _url = url;
    }

    private String _description;

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;
    }

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.servers.ServerVariable> _variables;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.servers.ServerVariable> getVariables() {
        if (_variables == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_variables);
    }

    @Override
    public void setVariables(java.util.Map<String, org.eclipse.microprofile.openapi.models.servers.ServerVariable> variables) {
        if (variables == null) {
            _variables = null;
        } else {
            _variables = new java.util.LinkedHashMap<>();
            _variables.putAll(variables);
        }
    }

    @Override
    public Server addVariable(String key, org.eclipse.microprofile.openapi.models.servers.ServerVariable serverVariable) {
        if (serverVariable == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_variables == null) {
                _variables = new java.util.LinkedHashMap<>();
            }
            _variables.put(key, serverVariable);
        }
        return this;
    }

    @Override
    public void removeVariable(String key) {
        if (_variables != null) {
            _variables.remove(key);
        }
    }

}
