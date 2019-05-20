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
package org.openapitools.empoa.swagger.core.internal.models;

import org.eclipse.microprofile.openapi.models.ExternalDocumentation;

public class SwExternalDocumentation implements ExternalDocumentation {

    private io.swagger.v3.oas.models.ExternalDocumentation _swExternalDocumentation;

    public SwExternalDocumentation() {
        _swExternalDocumentation = new io.swagger.v3.oas.models.ExternalDocumentation();
    }

    public SwExternalDocumentation(io.swagger.v3.oas.models.ExternalDocumentation _swExternalDocumentation) {
        this._swExternalDocumentation = _swExternalDocumentation;
    }

    public io.swagger.v3.oas.models.ExternalDocumentation getSw() {
        return _swExternalDocumentation;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swExternalDocumentation.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swExternalDocumentation.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swExternalDocumentation.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public ExternalDocumentation addExtension(String key, Object object) {
        _swExternalDocumentation.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swExternalDocumentation.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getDescription() {
        return _swExternalDocumentation.getDescription();
    }

    @Override
    public void setDescription(String description) {
        _swExternalDocumentation.setDescription(description);
    }

    @Override
    public String getUrl() {
        return _swExternalDocumentation.getUrl();
    }

    @Override
    public void setUrl(String url) {
        _swExternalDocumentation.setUrl(url);
    }

}
