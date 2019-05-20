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

import org.eclipse.microprofile.openapi.models.security.SecurityScheme;

public class SecuritySchemeImpl implements SecurityScheme {

    private String _ref;

    @Override
    public String getRef() {
        return _ref;
    }

    @Override
    public void setRef(String ref) {
        if (ref != null && !ref.contains("#") && !ref.contains("/")) {
            _ref = "#/components/securitySchemes/" + ref;
        } else {
            _ref = ref;
        }
    }

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
    public SecurityScheme addExtension(String key, Object object) {
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

    private org.eclipse.microprofile.openapi.models.security.SecurityScheme.Type _type;

    @Override
    public org.eclipse.microprofile.openapi.models.security.SecurityScheme.Type getType() {
        return _type;
    }

    @Override
    public void setType(org.eclipse.microprofile.openapi.models.security.SecurityScheme.Type type) {
        _type = type;
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

    private String _name;

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    private org.eclipse.microprofile.openapi.models.security.SecurityScheme.In _in;

    @Override
    public org.eclipse.microprofile.openapi.models.security.SecurityScheme.In getIn() {
        return _in;
    }

    @Override
    public void setIn(org.eclipse.microprofile.openapi.models.security.SecurityScheme.In in) {
        _in = in;
    }

    private String _scheme;

    @Override
    public String getScheme() {
        return _scheme;
    }

    @Override
    public void setScheme(String scheme) {
        _scheme = scheme;
    }

    private String _bearerFormat;

    @Override
    public String getBearerFormat() {
        return _bearerFormat;
    }

    @Override
    public void setBearerFormat(String bearerFormat) {
        _bearerFormat = bearerFormat;
    }

    private org.eclipse.microprofile.openapi.models.security.OAuthFlows _flows;

    @Override
    public org.eclipse.microprofile.openapi.models.security.OAuthFlows getFlows() {
        return _flows;
    }

    @Override
    public void setFlows(org.eclipse.microprofile.openapi.models.security.OAuthFlows flows) {
        _flows = flows;
    }

    private String _openIdConnectUrl;

    @Override
    public String getOpenIdConnectUrl() {
        return _openIdConnectUrl;
    }

    @Override
    public void setOpenIdConnectUrl(String openIdConnectUrl) {
        _openIdConnectUrl = openIdConnectUrl;
    }

}
