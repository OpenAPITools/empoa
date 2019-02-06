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

import org.eclipse.microprofile.openapi.models.servers.ServerVariable;

public class ServerVariableImpl implements ServerVariable {

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
    public ServerVariable addExtension(String key, Object object) {
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

    private java.util.List<String> _enumeration;

    @Override
    public java.util.List<String> getEnumeration() {
        if (_enumeration == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_enumeration);
    }

    @Override
    public void setEnumeration(java.util.List<String> enumeration) {
        if (enumeration == null) {
            _enumeration = null;
        } else {
            _enumeration = new java.util.ArrayList<>();
            _enumeration.addAll(enumeration);
        }
    }

    @Override
    public ServerVariable addEnumeration(String string) {
        if (_enumeration == null) {
            _enumeration = new java.util.ArrayList<>();
        }
        _enumeration.add(string);
        return this;
    }

    @Override
    public void removeEnumeration(String string) {
        if (_enumeration != null) {
            _enumeration.remove(string);
        }
    }

    private String _defaultValue;

    @Override
    public String getDefaultValue() {
        return _defaultValue;
    }

    @Override
    public void setDefaultValue(String defaultValue) {
        _defaultValue = defaultValue;
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

}
