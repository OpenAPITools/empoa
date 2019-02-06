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
package org.openapitools.empoa.swagger.core.internal.models.parameters;

import org.eclipse.microprofile.openapi.models.parameters.RequestBody;

public class SwRequestBody implements RequestBody {

    private io.swagger.v3.oas.models.parameters.RequestBody _swRequestBody;

    public SwRequestBody() {
        _swRequestBody = new io.swagger.v3.oas.models.parameters.RequestBody();
    }

    public SwRequestBody(io.swagger.v3.oas.models.parameters.RequestBody _swRequestBody) {
        this._swRequestBody = _swRequestBody;
    }

    public io.swagger.v3.oas.models.parameters.RequestBody getSw() {
        return _swRequestBody;
    }

    @Override
    public String getRef() {
        return _swRequestBody.get$ref();
    }

    @Override
    public void setRef(String ref) {
        _swRequestBody.set$ref(ref);
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swRequestBody.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swRequestBody.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swRequestBody.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public RequestBody addExtension(String key, Object object) {
        _swRequestBody.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swRequestBody.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getDescription() {
        return _swRequestBody.getDescription();
    }

    @Override
    public void setDescription(String description) {
        _swRequestBody.setDescription(description);
    }

    private org.openapitools.empoa.swagger.core.internal.models.media.SwContent _content;

    private void initContent() {
        if (_swRequestBody.getContent() == null) {
            _content = null;
        } else if (_content == null) {
            _content = new org.openapitools.empoa.swagger.core.internal.models.media.SwContent(_swRequestBody.getContent());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.media.Content getContent() {
        initContent();
        return _content;
    }

    @Override
    public void setContent(org.eclipse.microprofile.openapi.models.media.Content content) {
        if (content != null) {
            if (!(content instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwContent)) {
                throw new IllegalArgumentException("Unexpected type: " + content);
            }
            _content = (org.openapitools.empoa.swagger.core.internal.models.media.SwContent) content;
            _swRequestBody.setContent(_content.getSw());
        } else {
            _content = null;
            _swRequestBody.setContent(null);
        }
    }

    @Override
    public Boolean getRequired() {
        return _swRequestBody.getRequired();
    }

    @Override
    public void setRequired(Boolean required) {
        _swRequestBody.setRequired(required);
    }

}
