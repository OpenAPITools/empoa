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

import org.eclipse.microprofile.openapi.models.security.OAuthFlow;

public class OAuthFlowImpl implements OAuthFlow {

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
    public OAuthFlow addExtension(String key, Object object) {
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

    private String _authorizationUrl;

    @Override
    public String getAuthorizationUrl() {
        return _authorizationUrl;
    }

    @Override
    public void setAuthorizationUrl(String authorizationUrl) {
        _authorizationUrl = authorizationUrl;
    }

    private String _tokenUrl;

    @Override
    public String getTokenUrl() {
        return _tokenUrl;
    }

    @Override
    public void setTokenUrl(String tokenUrl) {
        _tokenUrl = tokenUrl;
    }

    private String _refreshUrl;

    @Override
    public String getRefreshUrl() {
        return _refreshUrl;
    }

    @Override
    public void setRefreshUrl(String refreshUrl) {
        _refreshUrl = refreshUrl;
    }

    private java.util.Map<String, String> _scopes;

    @Override
    public java.util.Map<String, String> getScopes() {
        if (_scopes == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_scopes);
    }

    @Override
    public void setScopes(java.util.Map<String, String> scopes) {
        if (scopes == null) {
            _scopes = null;
        } else {
            _scopes = new java.util.LinkedHashMap<>();
            _scopes.putAll(scopes);
        }
    }

    @Override
    public OAuthFlow addScope(String key, String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_scopes == null) {
                _scopes = new java.util.LinkedHashMap<>();
            }
            _scopes.put(key, string);
        }
        return this;
    }

    @Override
    public void removeScope(String key) {
        if (_scopes != null) {
            _scopes.remove(key);
        }
    }

}
