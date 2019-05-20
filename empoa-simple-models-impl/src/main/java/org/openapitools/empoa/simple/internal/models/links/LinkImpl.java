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
package org.openapitools.empoa.simple.internal.models.links;

import org.eclipse.microprofile.openapi.models.links.Link;

public class LinkImpl implements Link {

    private String _ref;

    @Override
    public String getRef() {
        return _ref;
    }

    @Override
    public void setRef(String ref) {
        if (ref != null && !ref.contains("#") && !ref.contains("/")) {
            _ref = "#/components/links/" + ref;
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
    public Link addExtension(String key, Object object) {
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

    private org.eclipse.microprofile.openapi.models.servers.Server _server;

    @Override
    public org.eclipse.microprofile.openapi.models.servers.Server getServer() {
        return _server;
    }

    @Override
    public void setServer(org.eclipse.microprofile.openapi.models.servers.Server server) {
        _server = server;
    }

    private String _operationRef;

    @Override
    public String getOperationRef() {
        return _operationRef;
    }

    @Override
    public void setOperationRef(String operationRef) {
        _operationRef = operationRef;
    }

    private Object _requestBody;

    @Override
    public Object getRequestBody() {
        return _requestBody;
    }

    @Override
    public void setRequestBody(Object requestBody) {
        _requestBody = requestBody;
    }

    private String _operationId;

    @Override
    public String getOperationId() {
        return _operationId;
    }

    @Override
    public void setOperationId(String operationId) {
        _operationId = operationId;
    }

    private java.util.Map<String, Object> _parameters;

    @Override
    public java.util.Map<String, Object> getParameters() {
        if (_parameters == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_parameters);
    }

    @Override
    public void setParameters(java.util.Map<String, Object> parameters) {
        if (parameters == null) {
            _parameters = null;
        } else {
            _parameters = new java.util.LinkedHashMap<>();
            _parameters.putAll(parameters);
        }
    }

    @Override
    public Link addParameter(String key, Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_parameters == null) {
                _parameters = new java.util.LinkedHashMap<>();
            }
            _parameters.put(key, object);
        }
        return this;
    }

    @Override
    public void removeParameter(String key) {
        if (_parameters != null) {
            _parameters.remove(key);
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

}
