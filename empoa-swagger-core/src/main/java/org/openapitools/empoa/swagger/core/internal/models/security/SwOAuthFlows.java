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

import org.eclipse.microprofile.openapi.models.security.OAuthFlows;

public class SwOAuthFlows implements OAuthFlows {

    private io.swagger.v3.oas.models.security.OAuthFlows _swOAuthFlows;

    public SwOAuthFlows() {
        _swOAuthFlows = new io.swagger.v3.oas.models.security.OAuthFlows();
    }

    public SwOAuthFlows(io.swagger.v3.oas.models.security.OAuthFlows _swOAuthFlows) {
        this._swOAuthFlows = _swOAuthFlows;
    }

    public io.swagger.v3.oas.models.security.OAuthFlows getSw() {
        return _swOAuthFlows;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swOAuthFlows.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swOAuthFlows.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swOAuthFlows.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public OAuthFlows addExtension(String key, Object object) {
        _swOAuthFlows.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swOAuthFlows.getExtensions()
                .remove(key);
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow _implicit;

    private void initImplicit() {
        if (_swOAuthFlows.getImplicit() == null) {
            _implicit = null;
        } else if (_implicit == null) {
            _implicit = new org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow(_swOAuthFlows.getImplicit());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.security.OAuthFlow getImplicit() {
        initImplicit();
        return _implicit;
    }

    @Override
    public void setImplicit(org.eclipse.microprofile.openapi.models.security.OAuthFlow implicit) {
        if (implicit != null) {
            if (!(implicit instanceof org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow)) {
                throw new IllegalArgumentException("Unexpected type: " + implicit);
            }
            _implicit = (org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow) implicit;
            _swOAuthFlows.setImplicit(_implicit.getSw());
        } else {
            _implicit = null;
            _swOAuthFlows.setImplicit(null);
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow _password;

    private void initPassword() {
        if (_swOAuthFlows.getPassword() == null) {
            _password = null;
        } else if (_password == null) {
            _password = new org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow(_swOAuthFlows.getPassword());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.security.OAuthFlow getPassword() {
        initPassword();
        return _password;
    }

    @Override
    public void setPassword(org.eclipse.microprofile.openapi.models.security.OAuthFlow password) {
        if (password != null) {
            if (!(password instanceof org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow)) {
                throw new IllegalArgumentException("Unexpected type: " + password);
            }
            _password = (org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow) password;
            _swOAuthFlows.setPassword(_password.getSw());
        } else {
            _password = null;
            _swOAuthFlows.setPassword(null);
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow _clientCredentials;

    private void initClientCredentials() {
        if (_swOAuthFlows.getClientCredentials() == null) {
            _clientCredentials = null;
        } else if (_clientCredentials == null) {
            _clientCredentials = new org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow(_swOAuthFlows.getClientCredentials());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.security.OAuthFlow getClientCredentials() {
        initClientCredentials();
        return _clientCredentials;
    }

    @Override
    public void setClientCredentials(org.eclipse.microprofile.openapi.models.security.OAuthFlow clientCredentials) {
        if (clientCredentials != null) {
            if (!(clientCredentials instanceof org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow)) {
                throw new IllegalArgumentException("Unexpected type: " + clientCredentials);
            }
            _clientCredentials = (org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow) clientCredentials;
            _swOAuthFlows.setClientCredentials(_clientCredentials.getSw());
        } else {
            _clientCredentials = null;
            _swOAuthFlows.setClientCredentials(null);
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow _authorizationCode;

    private void initAuthorizationCode() {
        if (_swOAuthFlows.getAuthorizationCode() == null) {
            _authorizationCode = null;
        } else if (_authorizationCode == null) {
            _authorizationCode = new org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow(_swOAuthFlows.getAuthorizationCode());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.security.OAuthFlow getAuthorizationCode() {
        initAuthorizationCode();
        return _authorizationCode;
    }

    @Override
    public void setAuthorizationCode(org.eclipse.microprofile.openapi.models.security.OAuthFlow authorizationCode) {
        if (authorizationCode != null) {
            if (!(authorizationCode instanceof org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow)) {
                throw new IllegalArgumentException("Unexpected type: " + authorizationCode);
            }
            _authorizationCode = (org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlow) authorizationCode;
            _swOAuthFlows.setAuthorizationCode(_authorizationCode.getSw());
        } else {
            _authorizationCode = null;
            _swOAuthFlows.setAuthorizationCode(null);
        }
    }

}
