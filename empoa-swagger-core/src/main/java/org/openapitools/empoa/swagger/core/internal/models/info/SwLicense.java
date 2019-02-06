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
package org.openapitools.empoa.swagger.core.internal.models.info;

import org.eclipse.microprofile.openapi.models.info.License;

public class SwLicense implements License {

    private io.swagger.v3.oas.models.info.License _swLicense;

    public SwLicense() {
        _swLicense = new io.swagger.v3.oas.models.info.License();
    }

    public SwLicense(io.swagger.v3.oas.models.info.License _swLicense) {
        this._swLicense = _swLicense;
    }

    public io.swagger.v3.oas.models.info.License getSw() {
        return _swLicense;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swLicense.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swLicense.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swLicense.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public License addExtension(String key, Object object) {
        _swLicense.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swLicense.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getName() {
        return _swLicense.getName();
    }

    @Override
    public void setName(String name) {
        _swLicense.setName(name);
    }

    @Override
    public String getUrl() {
        return _swLicense.getUrl();
    }

    @Override
    public void setUrl(String url) {
        _swLicense.setUrl(url);
    }

}
