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

import org.eclipse.microprofile.openapi.models.servers.ServerVariables;

public class ServerVariablesImpl implements ServerVariables {

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
    public ServerVariables addExtension(String key, Object object) {
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

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.servers.ServerVariable> _serverVariables;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.servers.ServerVariable> getServerVariables() {
        if (_serverVariables == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_serverVariables);
    }

    @Override
    public void setServerVariables(java.util.Map<String, org.eclipse.microprofile.openapi.models.servers.ServerVariable> serverVariables) {
        if (serverVariables == null) {
            _serverVariables = null;
        } else {
            _serverVariables = new java.util.LinkedHashMap<>();
            _serverVariables.putAll(serverVariables);
        }
    }

    @Override
    public ServerVariables addServerVariable(String key, org.eclipse.microprofile.openapi.models.servers.ServerVariable serverVariable) {
        if (serverVariable == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_serverVariables == null) {
                _serverVariables = new java.util.LinkedHashMap<>();
            }
            _serverVariables.put(key, serverVariable);
        }
        return this;
    }

    @Override
    public void removeServerVariable(String key) {
        if (_serverVariables != null) {
            _serverVariables.remove(key);
        }
    }

}
