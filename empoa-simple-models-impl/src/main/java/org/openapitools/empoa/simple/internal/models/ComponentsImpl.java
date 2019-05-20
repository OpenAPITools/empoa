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
package org.openapitools.empoa.simple.internal.models;

import org.eclipse.microprofile.openapi.models.Components;

public class ComponentsImpl implements Components {

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
    public Components addExtension(String key, Object object) {
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

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.media.Schema> _schemas;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.media.Schema> getSchemas() {
        if (_schemas == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_schemas);
    }

    @Override
    public void setSchemas(java.util.Map<String, org.eclipse.microprofile.openapi.models.media.Schema> schemas) {
        if (schemas == null) {
            _schemas = null;
        } else {
            _schemas = new java.util.LinkedHashMap<>();
            _schemas.putAll(schemas);
        }
    }

    @Override
    public Components addSchema(String key, org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (schema == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_schemas == null) {
                _schemas = new java.util.LinkedHashMap<>();
            }
            _schemas.put(key, schema);
        }
        return this;
    }

    @Override
    public void removeSchema(String key) {
        if (_schemas != null) {
            _schemas.remove(key);
        }
    }

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.responses.APIResponse> _responses;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.responses.APIResponse> getResponses() {
        if (_responses == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_responses);
    }

    @Override
    public void setResponses(java.util.Map<String, org.eclipse.microprofile.openapi.models.responses.APIResponse> responses) {
        if (responses == null) {
            _responses = null;
        } else {
            _responses = new java.util.LinkedHashMap<>();
            _responses.putAll(responses);
        }
    }

    @Override
    public Components addResponse(String key, org.eclipse.microprofile.openapi.models.responses.APIResponse aPIResponse) {
        if (aPIResponse == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_responses == null) {
                _responses = new java.util.LinkedHashMap<>();
            }
            _responses.put(key, aPIResponse);
        }
        return this;
    }

    @Override
    public void removeResponse(String key) {
        if (_responses != null) {
            _responses.remove(key);
        }
    }

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.parameters.Parameter> _parameters;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.parameters.Parameter> getParameters() {
        if (_parameters == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_parameters);
    }

    @Override
    public void setParameters(java.util.Map<String, org.eclipse.microprofile.openapi.models.parameters.Parameter> parameters) {
        if (parameters == null) {
            _parameters = null;
        } else {
            _parameters = new java.util.LinkedHashMap<>();
            _parameters.putAll(parameters);
        }
    }

    @Override
    public Components addParameter(String key, org.eclipse.microprofile.openapi.models.parameters.Parameter parameter) {
        if (parameter == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_parameters == null) {
                _parameters = new java.util.LinkedHashMap<>();
            }
            _parameters.put(key, parameter);
        }
        return this;
    }

    @Override
    public void removeParameter(String key) {
        if (_parameters != null) {
            _parameters.remove(key);
        }
    }

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.examples.Example> _examples;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.examples.Example> getExamples() {
        if (_examples == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_examples);
    }

    @Override
    public void setExamples(java.util.Map<String, org.eclipse.microprofile.openapi.models.examples.Example> examples) {
        if (examples == null) {
            _examples = null;
        } else {
            _examples = new java.util.LinkedHashMap<>();
            _examples.putAll(examples);
        }
    }

    @Override
    public Components addExample(String key, org.eclipse.microprofile.openapi.models.examples.Example example) {
        if (example == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_examples == null) {
                _examples = new java.util.LinkedHashMap<>();
            }
            _examples.put(key, example);
        }
        return this;
    }

    @Override
    public void removeExample(String key) {
        if (_examples != null) {
            _examples.remove(key);
        }
    }

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.parameters.RequestBody> _requestBodies;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.parameters.RequestBody> getRequestBodies() {
        if (_requestBodies == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_requestBodies);
    }

    @Override
    public void setRequestBodies(java.util.Map<String, org.eclipse.microprofile.openapi.models.parameters.RequestBody> requestBodies) {
        if (requestBodies == null) {
            _requestBodies = null;
        } else {
            _requestBodies = new java.util.LinkedHashMap<>();
            _requestBodies.putAll(requestBodies);
        }
    }

    @Override
    public Components addRequestBody(String key, org.eclipse.microprofile.openapi.models.parameters.RequestBody requestBody) {
        if (requestBody == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_requestBodies == null) {
                _requestBodies = new java.util.LinkedHashMap<>();
            }
            _requestBodies.put(key, requestBody);
        }
        return this;
    }

    @Override
    public void removeRequestBody(String key) {
        if (_requestBodies != null) {
            _requestBodies.remove(key);
        }
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
    public Components addHeader(String key, org.eclipse.microprofile.openapi.models.headers.Header header) {
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

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.security.SecurityScheme> _securitySchemes;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.security.SecurityScheme> getSecuritySchemes() {
        if (_securitySchemes == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_securitySchemes);
    }

    @Override
    public void setSecuritySchemes(java.util.Map<String, org.eclipse.microprofile.openapi.models.security.SecurityScheme> securitySchemes) {
        if (securitySchemes == null) {
            _securitySchemes = null;
        } else {
            _securitySchemes = new java.util.LinkedHashMap<>();
            _securitySchemes.putAll(securitySchemes);
        }
    }

    @Override
    public Components addSecurityScheme(String key, org.eclipse.microprofile.openapi.models.security.SecurityScheme securityScheme) {
        if (securityScheme == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_securitySchemes == null) {
                _securitySchemes = new java.util.LinkedHashMap<>();
            }
            _securitySchemes.put(key, securityScheme);
        }
        return this;
    }

    @Override
    public void removeSecurityScheme(String key) {
        if (_securitySchemes != null) {
            _securitySchemes.remove(key);
        }
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
    public Components addLink(String key, org.eclipse.microprofile.openapi.models.links.Link link) {
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

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.callbacks.Callback> _callbacks;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.callbacks.Callback> getCallbacks() {
        if (_callbacks == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_callbacks);
    }

    @Override
    public void setCallbacks(java.util.Map<String, org.eclipse.microprofile.openapi.models.callbacks.Callback> callbacks) {
        if (callbacks == null) {
            _callbacks = null;
        } else {
            _callbacks = new java.util.LinkedHashMap<>();
            _callbacks.putAll(callbacks);
        }
    }

    @Override
    public Components addCallback(String key, org.eclipse.microprofile.openapi.models.callbacks.Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_callbacks == null) {
                _callbacks = new java.util.LinkedHashMap<>();
            }
            _callbacks.put(key, callback);
        }
        return this;
    }

    @Override
    public void removeCallback(String key) {
        if (_callbacks != null) {
            _callbacks.remove(key);
        }
    }

}
