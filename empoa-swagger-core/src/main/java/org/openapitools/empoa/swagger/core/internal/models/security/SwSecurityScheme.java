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

import org.eclipse.microprofile.openapi.models.security.SecurityScheme;

public class SwSecurityScheme implements SecurityScheme {

    private io.swagger.v3.oas.models.security.SecurityScheme _swSecurityScheme;

    public SwSecurityScheme() {
        _swSecurityScheme = new io.swagger.v3.oas.models.security.SecurityScheme();
    }

    public SwSecurityScheme(io.swagger.v3.oas.models.security.SecurityScheme _swSecurityScheme) {
        this._swSecurityScheme = _swSecurityScheme;
    }

    public io.swagger.v3.oas.models.security.SecurityScheme getSw() {
        return _swSecurityScheme;
    }

    @Override
    public String getRef() {
        return _swSecurityScheme.get$ref();
    }

    @Override
    public void setRef(String ref) {
        _swSecurityScheme.set$ref(ref);
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swSecurityScheme.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swSecurityScheme.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swSecurityScheme.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public SecurityScheme addExtension(String key, Object object) {
        _swSecurityScheme.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swSecurityScheme.getExtensions()
                .remove(key);
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.security.SecurityScheme.Type getType() {
        if (_swSecurityScheme.getType() == null) {
            return null;
        }
        switch (_swSecurityScheme.getType()) {
        case APIKEY:
            return org.eclipse.microprofile.openapi.models.security.SecurityScheme.Type.APIKEY;
        case HTTP:
            return org.eclipse.microprofile.openapi.models.security.SecurityScheme.Type.HTTP;
        case OAUTH2:
            return org.eclipse.microprofile.openapi.models.security.SecurityScheme.Type.OAUTH2;
        case OPENIDCONNECT:
            return org.eclipse.microprofile.openapi.models.security.SecurityScheme.Type.OPENIDCONNECT;
        default:
            throw new IllegalStateException("Unexpected enum value");
        }
    }

    @Override
    public void setType(org.eclipse.microprofile.openapi.models.security.SecurityScheme.Type type) {
        io.swagger.v3.oas.models.security.SecurityScheme.Type value;
        if (type == null) {
            value = null;
        } else {
            switch (type) {
            case APIKEY:
                value = io.swagger.v3.oas.models.security.SecurityScheme.Type.APIKEY;
                break;
            case HTTP:
                value = io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP;
                break;
            case OAUTH2:
                value = io.swagger.v3.oas.models.security.SecurityScheme.Type.OAUTH2;
                break;
            case OPENIDCONNECT:
                value = io.swagger.v3.oas.models.security.SecurityScheme.Type.OPENIDCONNECT;
                break;
            default:
                throw new IllegalStateException("Unexpected enum value");
            }
        }
        _swSecurityScheme.setType(value);
    }

    @Override
    public String getDescription() {
        return _swSecurityScheme.getDescription();
    }

    @Override
    public void setDescription(String description) {
        _swSecurityScheme.setDescription(description);
    }

    @Override
    public String getName() {
        return _swSecurityScheme.getName();
    }

    @Override
    public void setName(String name) {
        _swSecurityScheme.setName(name);
    }

    @Override
    public org.eclipse.microprofile.openapi.models.security.SecurityScheme.In getIn() {
        if (_swSecurityScheme.getIn() == null) {
            return null;
        }
        switch (_swSecurityScheme.getIn()) {
        case COOKIE:
            return org.eclipse.microprofile.openapi.models.security.SecurityScheme.In.COOKIE;
        case HEADER:
            return org.eclipse.microprofile.openapi.models.security.SecurityScheme.In.HEADER;
        case QUERY:
            return org.eclipse.microprofile.openapi.models.security.SecurityScheme.In.QUERY;
        default:
            throw new IllegalStateException("Unexpected enum value");
        }
    }

    @Override
    public void setIn(org.eclipse.microprofile.openapi.models.security.SecurityScheme.In in) {
        io.swagger.v3.oas.models.security.SecurityScheme.In value;
        if (in == null) {
            value = null;
        } else {
            switch (in) {
            case COOKIE:
                value = io.swagger.v3.oas.models.security.SecurityScheme.In.COOKIE;
                break;
            case HEADER:
                value = io.swagger.v3.oas.models.security.SecurityScheme.In.HEADER;
                break;
            case QUERY:
                value = io.swagger.v3.oas.models.security.SecurityScheme.In.QUERY;
                break;
            default:
                throw new IllegalStateException("Unexpected enum value");
            }
        }
        _swSecurityScheme.setIn(value);
    }

    @Override
    public String getScheme() {
        return _swSecurityScheme.getScheme();
    }

    @Override
    public void setScheme(String scheme) {
        _swSecurityScheme.setScheme(scheme);
    }

    @Override
    public String getBearerFormat() {
        return _swSecurityScheme.getBearerFormat();
    }

    @Override
    public void setBearerFormat(String bearerFormat) {
        _swSecurityScheme.setBearerFormat(bearerFormat);
    }

    private org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlows _flows;

    private void initFlows() {
        if (_swSecurityScheme.getFlows() == null) {
            _flows = null;
        } else if (_flows == null) {
            _flows = new org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlows(_swSecurityScheme.getFlows());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.security.OAuthFlows getFlows() {
        initFlows();
        return _flows;
    }

    @Override
    public void setFlows(org.eclipse.microprofile.openapi.models.security.OAuthFlows flows) {
        if (flows != null) {
            if (!(flows instanceof org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlows)) {
                throw new IllegalArgumentException("Unexpected type: " + flows);
            }
            _flows = (org.openapitools.empoa.swagger.core.internal.models.security.SwOAuthFlows) flows;
            _swSecurityScheme.setFlows(_flows.getSw());
        } else {
            _flows = null;
            _swSecurityScheme.setFlows(null);
        }
    }

    @Override
    public String getOpenIdConnectUrl() {
        return _swSecurityScheme.getOpenIdConnectUrl();
    }

    @Override
    public void setOpenIdConnectUrl(String openIdConnectUrl) {
        _swSecurityScheme.setOpenIdConnectUrl(openIdConnectUrl);
    }

}
