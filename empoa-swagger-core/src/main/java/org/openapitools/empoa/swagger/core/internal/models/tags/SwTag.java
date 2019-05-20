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
package org.openapitools.empoa.swagger.core.internal.models.tags;

import org.eclipse.microprofile.openapi.models.tags.Tag;

public class SwTag implements Tag {

    private io.swagger.v3.oas.models.tags.Tag _swTag;

    public SwTag() {
        _swTag = new io.swagger.v3.oas.models.tags.Tag();
    }

    public SwTag(io.swagger.v3.oas.models.tags.Tag _swTag) {
        this._swTag = _swTag;
    }

    public io.swagger.v3.oas.models.tags.Tag getSw() {
        return _swTag;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swTag.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swTag.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swTag.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Tag addExtension(String key, Object object) {
        _swTag.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swTag.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getName() {
        return _swTag.getName();
    }

    @Override
    public void setName(String name) {
        _swTag.setName(name);
    }

    @Override
    public String getDescription() {
        return _swTag.getDescription();
    }

    @Override
    public void setDescription(String description) {
        _swTag.setDescription(description);
    }

    private org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation _externalDocs;

    private void initExternalDocs() {
        if (_swTag.getExternalDocs() == null) {
            _externalDocs = null;
        } else if (_externalDocs == null) {
            _externalDocs = new org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation(_swTag.getExternalDocs());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.ExternalDocumentation getExternalDocs() {
        initExternalDocs();
        return _externalDocs;
    }

    @Override
    public void setExternalDocs(org.eclipse.microprofile.openapi.models.ExternalDocumentation externalDocs) {
        if (externalDocs != null) {
            if (!(externalDocs instanceof org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation)) {
                throw new IllegalArgumentException("Unexpected type: " + externalDocs);
            }
            _externalDocs = (org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation) externalDocs;
            _swTag.setExternalDocs(_externalDocs.getSw());
        } else {
            _externalDocs = null;
            _swTag.setExternalDocs(null);
        }
    }

}
