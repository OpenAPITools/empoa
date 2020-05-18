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
package org.openapitools.empoa.swagger.core.internal.models.media;

import org.eclipse.microprofile.openapi.models.media.Encoding;

public class SwEncoding implements Encoding {

    private io.swagger.v3.oas.models.media.Encoding _swEncoding;

    public SwEncoding() {
        _swEncoding = new io.swagger.v3.oas.models.media.Encoding();
    }

    public SwEncoding(io.swagger.v3.oas.models.media.Encoding _swEncoding) {
        this._swEncoding = _swEncoding;
    }

    public io.swagger.v3.oas.models.media.Encoding getSw() {
        return _swEncoding;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swEncoding.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swEncoding.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swEncoding.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Encoding addExtension(String key, Object object) {
        _swEncoding.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swEncoding.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getContentType() {
        return _swEncoding.getContentType();
    }

    @Override
    public void setContentType(String contentType) {
        _swEncoding.setContentType(contentType);
    }

    private java.util.Map<String, org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader> _headers;

    private void initHeaders() {
        if (_swEncoding.getHeaders() == null) {
            _headers = null;
        } else if (_headers == null) {
            _headers = _swEncoding.getHeaders()
                .entrySet()
                .stream()
                .collect(
                    java.util.stream.Collectors.toMap(
                        java.util.Map.Entry::getKey,
                        e -> new org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader(e.getValue()),
                        (k1, k2) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", k1));
                        },
                        () -> new java.util.LinkedHashMap<String, org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader>()
                    )
                );
        }
    }

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.headers.Header> getHeaders() {
        initHeaders();
        if (_headers == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_headers);
    }

    @Override
    public void setHeaders(java.util.Map<String, org.eclipse.microprofile.openapi.models.headers.Header> headers) {
        _swEncoding.setHeaders(null);
        if (headers != null) {
            if (headers.isEmpty()) {
                _swEncoding.setHeaders(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.headers.Header> e : headers.entrySet()) {
                    this.addHeader(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Encoding addHeader(String key, org.eclipse.microprofile.openapi.models.headers.Header header) {
        if (!(header instanceof org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader)) {
            throw new IllegalArgumentException("Unexpected type: " + header);
        }
        org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader value = (org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader) header;
        initHeaders();
        if (_headers == null) {
            _headers = new java.util.LinkedHashMap<>();
            _swEncoding.setHeaders(new java.util.LinkedHashMap<>());
        }
        _headers.put(key, value);
        _swEncoding.getHeaders()
            .put(key, value.getSw());
        return this;
    }

    @Override
    public void removeHeader(String key) {
        initHeaders();
        if (_headers != null) {
            _headers.remove(key);
            _swEncoding.getHeaders()
                .remove(key);
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.media.Encoding.Style getStyle() {
        if (_swEncoding.getStyle() == null) {
            return null;
        }
        switch (_swEncoding.getStyle()) {
        case FORM:
            return org.eclipse.microprofile.openapi.models.media.Encoding.Style.FORM;
        case SPACE_DELIMITED:
            return org.eclipse.microprofile.openapi.models.media.Encoding.Style.SPACE_DELIMITED;
        case PIPE_DELIMITED:
            return org.eclipse.microprofile.openapi.models.media.Encoding.Style.PIPE_DELIMITED;
        case DEEP_OBJECT:
            return org.eclipse.microprofile.openapi.models.media.Encoding.Style.DEEP_OBJECT;
        default:
            throw new IllegalStateException("Unexpected enum value: " + _swEncoding.getStyle());
        }
    }

    @Override
    public void setStyle(org.eclipse.microprofile.openapi.models.media.Encoding.Style style) {
        io.swagger.v3.oas.models.media.Encoding.StyleEnum value;
        if (style == null) {
            value = null;
        } else {
            switch (style) {
            case FORM:
                value = io.swagger.v3.oas.models.media.Encoding.StyleEnum.FORM;
                break;
            case SPACE_DELIMITED:
                value = io.swagger.v3.oas.models.media.Encoding.StyleEnum.SPACE_DELIMITED;
                break;
            case PIPE_DELIMITED:
                value = io.swagger.v3.oas.models.media.Encoding.StyleEnum.PIPE_DELIMITED;
                break;
            case DEEP_OBJECT:
                value = io.swagger.v3.oas.models.media.Encoding.StyleEnum.DEEP_OBJECT;
                break;
            default:
                throw new IllegalStateException("Unexpected enum value: " + style);
            }
        }
        _swEncoding.setStyle(value);
    }

    @Override
    public Boolean getExplode() {
        return _swEncoding.getExplode();
    }

    @Override
    public void setExplode(Boolean explode) {
        _swEncoding.setExplode(explode);
    }

    @Override
    public Boolean getAllowReserved() {
        return _swEncoding.getAllowReserved();
    }

    @Override
    public void setAllowReserved(Boolean allowReserved) {
        _swEncoding.setAllowReserved(allowReserved);
    }

}
