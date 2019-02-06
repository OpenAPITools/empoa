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
package org.openapitools.empoa.swagger.core.internal.models.responses;

import org.eclipse.microprofile.openapi.models.responses.APIResponse;

public class SwAPIResponse implements APIResponse {

    private io.swagger.v3.oas.models.responses.ApiResponse _swAPIResponse;

    public SwAPIResponse() {
        _swAPIResponse = new io.swagger.v3.oas.models.responses.ApiResponse();
    }

    public SwAPIResponse(io.swagger.v3.oas.models.responses.ApiResponse _swAPIResponse) {
        this._swAPIResponse = _swAPIResponse;
    }

    public io.swagger.v3.oas.models.responses.ApiResponse getSw() {
        return _swAPIResponse;
    }

    @Override
    public String getRef() {
        return _swAPIResponse.get$ref();
    }

    @Override
    public void setRef(String ref) {
        _swAPIResponse.set$ref(ref);
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swAPIResponse.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swAPIResponse.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swAPIResponse.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public APIResponse addExtension(String key, Object object) {
        _swAPIResponse.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swAPIResponse.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getDescription() {
        return _swAPIResponse.getDescription();
    }

    @Override
    public void setDescription(String description) {
        _swAPIResponse.setDescription(description);
    }

    private java.util.Map<String, org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader> _headers;

    private void initHeaders() {
        if (_swAPIResponse.getHeaders() == null) {
            _headers = null;
        } else if (_headers == null) {
            _headers = _swAPIResponse.getHeaders()
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
        _swAPIResponse.setHeaders(null);
        if (headers != null) {
            if (headers.isEmpty()) {
                _swAPIResponse.setHeaders(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.headers.Header> e : headers.entrySet()) {
                    this.addHeader(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public APIResponse addHeader(String key, org.eclipse.microprofile.openapi.models.headers.Header header) {
        if (!(header instanceof org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader)) {
            throw new IllegalArgumentException("Unexpected type: " + header);
        }
        org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader value = (org.openapitools.empoa.swagger.core.internal.models.headers.SwHeader) header;
        initHeaders();
        if (_headers == null) {
            _headers = new java.util.LinkedHashMap<>();
            _swAPIResponse.setHeaders(new java.util.LinkedHashMap<>());
        }
        _headers.put(key, value);
        _swAPIResponse.getHeaders()
            .put(key, value.getSw());
        return this;
    }

    @Override
    public void removeHeader(String key) {
        initHeaders();
        if (_headers != null) {
            _headers.remove(key);
            _swAPIResponse.getHeaders()
                .remove(key);
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.media.SwContent _content;

    private void initContent() {
        if (_swAPIResponse.getContent() == null) {
            _content = null;
        } else if (_content == null) {
            _content = new org.openapitools.empoa.swagger.core.internal.models.media.SwContent(_swAPIResponse.getContent());
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
            _swAPIResponse.setContent(_content.getSw());
        } else {
            _content = null;
            _swAPIResponse.setContent(null);
        }
    }

    private java.util.Map<String, org.openapitools.empoa.swagger.core.internal.models.links.SwLink> _links;

    private void initLinks() {
        if (_swAPIResponse.getLinks() == null) {
            _links = null;
        } else if (_links == null) {
            _links = _swAPIResponse.getLinks()
                .entrySet()
                .stream()
                .collect(
                    java.util.stream.Collectors.toMap(
                        java.util.Map.Entry::getKey,
                        e -> new org.openapitools.empoa.swagger.core.internal.models.links.SwLink(e.getValue()),
                        (k1, k2) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", k1));
                        },
                        () -> new java.util.LinkedHashMap<String, org.openapitools.empoa.swagger.core.internal.models.links.SwLink>()
                    )
                );
        }
    }

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.links.Link> getLinks() {
        initLinks();
        if (_links == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_links);
    }

    @Override
    public void setLinks(java.util.Map<String, org.eclipse.microprofile.openapi.models.links.Link> links) {
        _swAPIResponse.setLinks(null);
        if (links != null) {
            if (links.isEmpty()) {
                _swAPIResponse.setLinks(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.links.Link> e : links.entrySet()) {
                    this.addLink(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public APIResponse addLink(String key, org.eclipse.microprofile.openapi.models.links.Link link) {
        if (!(link instanceof org.openapitools.empoa.swagger.core.internal.models.links.SwLink)) {
            throw new IllegalArgumentException("Unexpected type: " + link);
        }
        org.openapitools.empoa.swagger.core.internal.models.links.SwLink value = (org.openapitools.empoa.swagger.core.internal.models.links.SwLink) link;
        initLinks();
        if (_links == null) {
            _links = new java.util.LinkedHashMap<>();
            _swAPIResponse.setLinks(new java.util.LinkedHashMap<>());
        }
        _links.put(key, value);
        _swAPIResponse.getLinks()
            .put(key, value.getSw());
        return this;
    }

    @Override
    public void removeLink(String key) {
        initLinks();
        if (_links != null) {
            _links.remove(key);
            _swAPIResponse.getLinks()
                .remove(key);
        }
    }

}
