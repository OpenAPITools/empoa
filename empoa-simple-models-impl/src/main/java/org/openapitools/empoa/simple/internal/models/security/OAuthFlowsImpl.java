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

import org.eclipse.microprofile.openapi.models.security.OAuthFlows;

public class OAuthFlowsImpl implements OAuthFlows {

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
    public OAuthFlows addExtension(String key, Object object) {
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

    private org.eclipse.microprofile.openapi.models.security.OAuthFlow _implicit;

    @Override
    public org.eclipse.microprofile.openapi.models.security.OAuthFlow getImplicit() {
        return _implicit;
    }

    @Override
    public void setImplicit(org.eclipse.microprofile.openapi.models.security.OAuthFlow implicit) {
        _implicit = implicit;
    }

    private org.eclipse.microprofile.openapi.models.security.OAuthFlow _password;

    @Override
    public org.eclipse.microprofile.openapi.models.security.OAuthFlow getPassword() {
        return _password;
    }

    @Override
    public void setPassword(org.eclipse.microprofile.openapi.models.security.OAuthFlow password) {
        _password = password;
    }

    private org.eclipse.microprofile.openapi.models.security.OAuthFlow _clientCredentials;

    @Override
    public org.eclipse.microprofile.openapi.models.security.OAuthFlow getClientCredentials() {
        return _clientCredentials;
    }

    @Override
    public void setClientCredentials(org.eclipse.microprofile.openapi.models.security.OAuthFlow clientCredentials) {
        _clientCredentials = clientCredentials;
    }

    private org.eclipse.microprofile.openapi.models.security.OAuthFlow _authorizationCode;

    @Override
    public org.eclipse.microprofile.openapi.models.security.OAuthFlow getAuthorizationCode() {
        return _authorizationCode;
    }

    @Override
    public void setAuthorizationCode(org.eclipse.microprofile.openapi.models.security.OAuthFlow authorizationCode) {
        _authorizationCode = authorizationCode;
    }

}
