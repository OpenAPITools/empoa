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
package org.openapitools.empoa.simple.internal.models.media;

import org.eclipse.microprofile.openapi.models.media.Encoding;

public class EncodingImpl implements Encoding {

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
    public Encoding addExtension(String key, Object object) {
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

    private String _contentType;

    @Override
    public String getContentType() {
        return _contentType;
    }

    @Override
    public void setContentType(String contentType) {
        _contentType = contentType;
    }

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.headers.Header> _headers;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.headers.Header> getHeaders() {
        if (_headers == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_headers);
    }

    @Override
    public void setHeaders(java.util.Map<String, org.eclipse.microprofile.openapi.models.headers.Header> headers) {
        if (headers == null) {
            _headers = null;
        } else {
            _headers = new java.util.LinkedHashMap<>();
            _headers.putAll(headers);
        }
    }

    @Override
    public Encoding addHeader(String key, org.eclipse.microprofile.openapi.models.headers.Header header) {
        if (header == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_headers == null) {
                _headers = new java.util.LinkedHashMap<>();
            }
            _headers.put(key, header);
        }
        return this;
    }

    @Override
    public void removeHeader(String key) {
        if (_headers != null) {
            _headers.remove(key);
        }
    }

    private org.eclipse.microprofile.openapi.models.media.Encoding.Style _style;

    @Override
    public org.eclipse.microprofile.openapi.models.media.Encoding.Style getStyle() {
        return _style;
    }

    @Override
    public void setStyle(org.eclipse.microprofile.openapi.models.media.Encoding.Style style) {
        _style = style;
    }

    private Boolean _explode;

    @Override
    public Boolean getExplode() {
        return _explode;
    }

    @Override
    public void setExplode(Boolean explode) {
        _explode = explode;
    }

    private Boolean _allowReserved;

    @Override
    public Boolean getAllowReserved() {
        return _allowReserved;
    }

    @Override
    public void setAllowReserved(Boolean allowReserved) {
        _allowReserved = allowReserved;
    }

}
