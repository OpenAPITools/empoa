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

import org.eclipse.microprofile.openapi.models.Operation;

public class SwOperation implements Operation {

    private io.swagger.v3.oas.models.Operation _swOperation;

    public SwOperation() {
        _swOperation = new io.swagger.v3.oas.models.Operation();
    }

    public SwOperation(io.swagger.v3.oas.models.Operation _swOperation) {
        this._swOperation = _swOperation;
    }

    public io.swagger.v3.oas.models.Operation getSw() {
        return _swOperation;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swOperation.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swOperation.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swOperation.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Operation addExtension(String key, Object object) {
        _swOperation.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swOperation.getExtensions()
                .remove(key);
        }
    }

    @Override
    public java.util.List<String> getTags() {
        java.util.List<String> result = _swOperation.getTags();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(result);
    }

    @Override
    public void setTags(java.util.List<String> tags) {
        _swOperation.setTags(null);
        if (tags != null) {
            if (tags.isEmpty()) {
                _swOperation.setTags(new java.util.ArrayList<>());
            } else {
                for (String e : tags) {
                    this.addTag(e);
                }
            }
        }
    }

    @Override
    public Operation addTag(String string) {
        _swOperation.addTagsItem(string);
        return this;
    }

    @Override
    public void removeTag(String string) {
        if (_swOperation.getTags() != null) {
            _swOperation.getTags()
                .remove(string);
        }
    }

    @Override
    public String getSummary() {
        return _swOperation.getSummary();
    }

    @Override
    public void setSummary(String summary) {
        _swOperation.setSummary(summary);
    }

    @Override
    public String getDescription() {
        return _swOperation.getDescription();
    }

    @Override
    public void setDescription(String description) {
        _swOperation.setDescription(description);
    }

    private org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation _externalDocs;

    private void initExternalDocs() {
        if (_swOperation.getExternalDocs() == null) {
            _externalDocs = null;
        } else if (_externalDocs == null) {
            _externalDocs = new org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation(_swOperation.getExternalDocs());
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
            _swOperation.setExternalDocs(_externalDocs.getSw());
        } else {
            _externalDocs = null;
            _swOperation.setExternalDocs(null);
        }
    }

    @Override
    public String getOperationId() {
        return _swOperation.getOperationId();
    }

    @Override
    public void setOperationId(String operationId) {
        _swOperation.setOperationId(operationId);
    }

    private java.util.List<org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter> _parameters;

    private void initParameters() {
        if (_swOperation.getParameters() == null) {
            _parameters = null;
        } else if (_parameters == null) {
            _parameters = _swOperation.getParameters()
                .stream()
                .map(org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter::new)
                .collect(java.util.stream.Collectors.toCollection(java.util.ArrayList::new));
        }
    }

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.parameters.Parameter> getParameters() {
        initParameters();
        if (_parameters == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_parameters);
    }

    @Override
    public void setParameters(java.util.List<org.eclipse.microprofile.openapi.models.parameters.Parameter> parameters) {
        _swOperation.setParameters(null);
        if (parameters != null) {
            if (parameters.isEmpty()) {
                _swOperation.setParameters(new java.util.ArrayList<>());
            } else {
                for (org.eclipse.microprofile.openapi.models.parameters.Parameter e : parameters) {
                    this.addParameter(e);
                }
            }
        }
    }

    @Override
    public Operation addParameter(org.eclipse.microprofile.openapi.models.parameters.Parameter parameter) {
        if (!(parameter instanceof org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter)) {
            throw new IllegalArgumentException("Unexpected type: " + parameter);
        }
        org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter element = (org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter) parameter;
        initParameters();
        if (_parameters == null) {
            _parameters = new java.util.ArrayList<>();
            _swOperation.setParameters(new java.util.ArrayList<>());
        }
        _parameters.add(element);
        _swOperation.getParameters()
            .add(element.getSw());
        return this;
    }

    @Override
    public void removeParameter(org.eclipse.microprofile.openapi.models.parameters.Parameter parameter) {
        if (!(parameter instanceof org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter)) {
            throw new IllegalArgumentException("Unexpected type: " + parameter);
        }
        org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter element = (org.openapitools.empoa.swagger.core.internal.models.parameters.SwParameter) parameter;
        initParameters();
        if (_parameters != null) {
            _parameters.remove(parameter);
            _swOperation.getParameters()
                .remove(element.getSw());
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.parameters.SwRequestBody _requestBody;

    private void initRequestBody() {
        if (_swOperation.getRequestBody() == null) {
            _requestBody = null;
        } else if (_requestBody == null) {
            _requestBody = new org.openapitools.empoa.swagger.core.internal.models.parameters.SwRequestBody(_swOperation.getRequestBody());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.parameters.RequestBody getRequestBody() {
        initRequestBody();
        return _requestBody;
    }

    @Override
    public void setRequestBody(org.eclipse.microprofile.openapi.models.parameters.RequestBody requestBody) {
        if (requestBody != null) {
            if (!(requestBody instanceof org.openapitools.empoa.swagger.core.internal.models.parameters.SwRequestBody)) {
                throw new IllegalArgumentException("Unexpected type: " + requestBody);
            }
            _requestBody = (org.openapitools.empoa.swagger.core.internal.models.parameters.SwRequestBody) requestBody;
            _swOperation.setRequestBody(_requestBody.getSw());
        } else {
            _requestBody = null;
            _swOperation.setRequestBody(null);
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponses _responses;

    private void initResponses() {
        if (_swOperation.getResponses() == null) {
            _responses = null;
        } else if (_responses == null) {
            _responses = new org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponses(_swOperation.getResponses());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.responses.APIResponses getResponses() {
        initResponses();
        return _responses;
    }

    @Override
    public void setResponses(org.eclipse.microprofile.openapi.models.responses.APIResponses responses) {
        if (responses != null) {
            if (!(responses instanceof org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponses)) {
                throw new IllegalArgumentException("Unexpected type: " + responses);
            }
            _responses = (org.openapitools.empoa.swagger.core.internal.models.responses.SwAPIResponses) responses;
            _swOperation.setResponses(_responses.getSw());
        } else {
            _responses = null;
            _swOperation.setResponses(null);
        }
    }

    private java.util.Map<String, org.openapitools.empoa.swagger.core.internal.models.callbacks.SwCallback> _callbacks;

    private void initCallbacks() {
        if (_swOperation.getCallbacks() == null) {
            _callbacks = null;
        } else if (_callbacks == null) {
            _callbacks = _swOperation.getCallbacks()
                .entrySet()
                .stream()
                .collect(
                    java.util.stream.Collectors.toMap(
                        java.util.Map.Entry::getKey,
                        e -> new org.openapitools.empoa.swagger.core.internal.models.callbacks.SwCallback(e.getValue()),
                        (k1, k2) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", k1));
                        },
                        () -> new java.util.LinkedHashMap<String, org.openapitools.empoa.swagger.core.internal.models.callbacks.SwCallback>()
                    )
                );
        }
    }

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.callbacks.Callback> getCallbacks() {
        initCallbacks();
        if (_callbacks == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_callbacks);
    }

    @Override
    public void setCallbacks(java.util.Map<String, org.eclipse.microprofile.openapi.models.callbacks.Callback> callbacks) {
        _swOperation.setCallbacks(null);
        if (callbacks != null) {
            if (callbacks.isEmpty()) {
                _swOperation.setCallbacks(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.callbacks.Callback> e : callbacks.entrySet()) {
                    this.addCallback(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Operation addCallback(String key, org.eclipse.microprofile.openapi.models.callbacks.Callback callback) {
        if (!(callback instanceof org.openapitools.empoa.swagger.core.internal.models.callbacks.SwCallback)) {
            throw new IllegalArgumentException("Unexpected type: " + callback);
        }
        org.openapitools.empoa.swagger.core.internal.models.callbacks.SwCallback value = (org.openapitools.empoa.swagger.core.internal.models.callbacks.SwCallback) callback;
        initCallbacks();
        if (_callbacks == null) {
            _callbacks = new java.util.LinkedHashMap<>();
            _swOperation.setCallbacks(new java.util.LinkedHashMap<>());
        }
        _callbacks.put(key, value);
        _swOperation.getCallbacks()
            .put(key, value.getSw());
        return this;
    }

    @Override
    public void removeCallback(String key) {
        initCallbacks();
        if (_callbacks != null) {
            _callbacks.remove(key);
            _swOperation.getCallbacks()
                .remove(key);
        }
    }

    @Override
    public Boolean getDeprecated() {
        return _swOperation.getDeprecated();
    }

    @Override
    public void setDeprecated(Boolean deprecated) {
        _swOperation.setDeprecated(deprecated);
    }

    private java.util.List<org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement> _security;

    private void initSecurity() {
        if (_swOperation.getSecurity() == null) {
            _security = null;
        } else if (_security == null) {
            _security = _swOperation.getSecurity()
                .stream()
                .map(org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement::new)
                .collect(java.util.stream.Collectors.toCollection(java.util.ArrayList::new));
        }
    }

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.security.SecurityRequirement> getSecurity() {
        initSecurity();
        if (_security == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_security);
    }

    @Override
    public void setSecurity(java.util.List<org.eclipse.microprofile.openapi.models.security.SecurityRequirement> security) {
        _swOperation.setSecurity(null);
        if (security != null) {
            if (security.isEmpty()) {
                _swOperation.setSecurity(new java.util.ArrayList<>());
            } else {
                for (org.eclipse.microprofile.openapi.models.security.SecurityRequirement e : security) {
                    this.addSecurityRequirement(e);
                }
            }
        }
    }

    @Override
    public Operation addSecurityRequirement(org.eclipse.microprofile.openapi.models.security.SecurityRequirement securityRequirement) {
        if (!(securityRequirement instanceof org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement)) {
            throw new IllegalArgumentException("Unexpected type: " + securityRequirement);
        }
        org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement element = (org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement) securityRequirement;
        initSecurity();
        if (_security == null) {
            _security = new java.util.ArrayList<>();
            _swOperation.setSecurity(new java.util.ArrayList<>());
        }
        _security.add(element);
        _swOperation.getSecurity()
            .add(element.getSw());
        return this;
    }

    @Override
    public void removeSecurityRequirement(org.eclipse.microprofile.openapi.models.security.SecurityRequirement securityRequirement) {
        if (!(securityRequirement instanceof org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement)) {
            throw new IllegalArgumentException("Unexpected type: " + securityRequirement);
        }
        org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement element = (org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement) securityRequirement;
        initSecurity();
        if (_security != null) {
            _security.remove(securityRequirement);
            _swOperation.getSecurity()
                .remove(element.getSw());
        }
    }

    private java.util.List<org.openapitools.empoa.swagger.core.internal.models.servers.SwServer> _servers;

    private void initServers() {
        if (_swOperation.getServers() == null) {
            _servers = null;
        } else if (_servers == null) {
            _servers = _swOperation.getServers()
                .stream()
                .map(org.openapitools.empoa.swagger.core.internal.models.servers.SwServer::new)
                .collect(java.util.stream.Collectors.toCollection(java.util.ArrayList::new));
        }
    }

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.servers.Server> getServers() {
        initServers();
        if (_servers == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_servers);
    }

    @Override
    public void setServers(java.util.List<org.eclipse.microprofile.openapi.models.servers.Server> servers) {
        _swOperation.setServers(null);
        if (servers != null) {
            if (servers.isEmpty()) {
                _swOperation.setServers(new java.util.ArrayList<>());
            } else {
                for (org.eclipse.microprofile.openapi.models.servers.Server e : servers) {
                    this.addServer(e);
                }
            }
        }
    }

    @Override
    public Operation addServer(org.eclipse.microprofile.openapi.models.servers.Server server) {
        if (!(server instanceof org.openapitools.empoa.swagger.core.internal.models.servers.SwServer)) {
            throw new IllegalArgumentException("Unexpected type: " + server);
        }
        org.openapitools.empoa.swagger.core.internal.models.servers.SwServer element = (org.openapitools.empoa.swagger.core.internal.models.servers.SwServer) server;
        initServers();
        if (_servers == null) {
            _servers = new java.util.ArrayList<>();
            _swOperation.setServers(new java.util.ArrayList<>());
        }
        _servers.add(element);
        _swOperation.getServers()
            .add(element.getSw());
        return this;
    }

    @Override
    public void removeServer(org.eclipse.microprofile.openapi.models.servers.Server server) {
        if (!(server instanceof org.openapitools.empoa.swagger.core.internal.models.servers.SwServer)) {
            throw new IllegalArgumentException("Unexpected type: " + server);
        }
        org.openapitools.empoa.swagger.core.internal.models.servers.SwServer element = (org.openapitools.empoa.swagger.core.internal.models.servers.SwServer) server;
        initServers();
        if (_servers != null) {
            _servers.remove(server);
            _swOperation.getServers()
                .remove(element.getSw());
        }
    }

}
