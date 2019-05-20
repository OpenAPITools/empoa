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
package org.openapitools.empoa.simple.internal.models.responses;

import org.eclipse.microprofile.openapi.models.responses.APIResponse;

public class APIResponseImpl implements APIResponse {

    private String _ref;

    @Override
    public String getRef() {
        return _ref;
    }

    @Override
    public void setRef(String ref) {
        if (ref != null && !ref.contains("#") && !ref.contains("/")) {
            _ref = "#/components/responses/" + ref;
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
    public APIResponse addExtension(String key, Object object) {
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

    private String _description;

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;
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
    public APIResponse addHeader(String key, org.eclipse.microprofile.openapi.models.headers.Header header) {
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

    private org.eclipse.microprofile.openapi.models.media.Content _content;

    @Override
    public org.eclipse.microprofile.openapi.models.media.Content getContent() {
        return _content;
    }

    @Override
    public void setContent(org.eclipse.microprofile.openapi.models.media.Content content) {
        _content = content;
    }

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.links.Link> _links;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.links.Link> getLinks() {
        if (_links == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_links);
    }

    @Override
    public void setLinks(java.util.Map<String, org.eclipse.microprofile.openapi.models.links.Link> links) {
        if (links == null) {
            _links = null;
        } else {
            _links = new java.util.LinkedHashMap<>();
            _links.putAll(links);
        }
    }

    @Override
    public APIResponse addLink(String key, org.eclipse.microprofile.openapi.models.links.Link link) {
        if (link == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_links == null) {
                _links = new java.util.LinkedHashMap<>();
            }
            _links.put(key, link);
        }
        return this;
    }

    @Override
    public void removeLink(String key) {
        if (_links != null) {
            _links.remove(key);
        }
    }

}
