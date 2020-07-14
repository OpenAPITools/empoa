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
package org.openapitools.empoa.swagger.core.internal.models.security;

import org.eclipse.microprofile.openapi.models.security.OAuthFlow;

public class SwOAuthFlow implements OAuthFlow {

    private io.swagger.v3.oas.models.security.OAuthFlow _swOAuthFlow;

    public SwOAuthFlow() {
        _swOAuthFlow = new io.swagger.v3.oas.models.security.OAuthFlow();
    }

    public SwOAuthFlow(io.swagger.v3.oas.models.security.OAuthFlow _swOAuthFlow) {
        this._swOAuthFlow = _swOAuthFlow;
    }

    public io.swagger.v3.oas.models.security.OAuthFlow getSw() {
        return _swOAuthFlow;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swOAuthFlow.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swOAuthFlow.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swOAuthFlow.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public OAuthFlow addExtension(String key, Object object) {
        _swOAuthFlow.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swOAuthFlow.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getAuthorizationUrl() {
        return _swOAuthFlow.getAuthorizationUrl();
    }

    @Override
    public void setAuthorizationUrl(String authorizationUrl) {
        _swOAuthFlow.setAuthorizationUrl(authorizationUrl);
    }

    @Override
    public String getTokenUrl() {
        return _swOAuthFlow.getTokenUrl();
    }

    @Override
    public void setTokenUrl(String tokenUrl) {
        _swOAuthFlow.setTokenUrl(tokenUrl);
    }

    @Override
    public String getRefreshUrl() {
        return _swOAuthFlow.getRefreshUrl();
    }

    @Override
    public void setRefreshUrl(String refreshUrl) {
        _swOAuthFlow.setRefreshUrl(refreshUrl);
    }

    @Override
    public java.util.Map<String, String> getScopes() {
        if (_swOAuthFlow.getScopes() == null) {
            return null;
        }
        java.util.LinkedHashMap<String, String> map = new java.util.LinkedHashMap<String, String>();
        map.putAll(_swOAuthFlow.getScopes());
        return java.util.Collections.unmodifiableMap(map);
    }

    @Override
    public void setScopes(java.util.Map<String, String> scopes) {
        if (scopes == null) {
            _swOAuthFlow.setScopes(null);
        } else {
            io.swagger.v3.oas.models.security.Scopes swScopes = new io.swagger.v3.oas.models.security.Scopes();
            swScopes.putAll(scopes);
            _swOAuthFlow.setScopes(swScopes);
        }
    }

    @Override
    public OAuthFlow addScope(String key, String object) {
        if (object == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_swOAuthFlow.getScopes() == null) {
                io.swagger.v3.oas.models.security.Scopes swScopes = new io.swagger.v3.oas.models.security.Scopes();
                _swOAuthFlow.setScopes(swScopes);
            }
            _swOAuthFlow.getScopes()
                .put(key, object);
        }
        return this;
    }

    @Override
    public void removeScope(String key) {
        if (_swOAuthFlow.getScopes() != null) {
            _swOAuthFlow.getScopes()
                .remove(key);
        }
    }

}
