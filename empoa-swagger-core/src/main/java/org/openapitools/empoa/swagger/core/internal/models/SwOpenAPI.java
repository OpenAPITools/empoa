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

import org.eclipse.microprofile.openapi.models.OpenAPI;

public class SwOpenAPI implements OpenAPI {

    private io.swagger.v3.oas.models.OpenAPI _swOpenAPI;

    public SwOpenAPI() {
        _swOpenAPI = new io.swagger.v3.oas.models.OpenAPI();
    }

    public SwOpenAPI(io.swagger.v3.oas.models.OpenAPI _swOpenAPI) {
        this._swOpenAPI = _swOpenAPI;
    }

    public io.swagger.v3.oas.models.OpenAPI getSw() {
        return _swOpenAPI;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swOpenAPI.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swOpenAPI.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swOpenAPI.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public OpenAPI addExtension(String key, Object object) {
        _swOpenAPI.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swOpenAPI.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getOpenapi() {
        return _swOpenAPI.getOpenapi();
    }

    @Override
    public void setOpenapi(String openapi) {
        _swOpenAPI.setOpenapi(openapi);
    }

    private org.openapitools.empoa.swagger.core.internal.models.info.SwInfo _info;

    private void initInfo() {
        if (_swOpenAPI.getInfo() == null) {
            _info = null;
        } else if (_info == null) {
            _info = new org.openapitools.empoa.swagger.core.internal.models.info.SwInfo(_swOpenAPI.getInfo());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.info.Info getInfo() {
        initInfo();
        return _info;
    }

    @Override
    public void setInfo(org.eclipse.microprofile.openapi.models.info.Info info) {
        if (info != null) {
            if (!(info instanceof org.openapitools.empoa.swagger.core.internal.models.info.SwInfo)) {
                throw new IllegalArgumentException("Unexpected type: " + info);
            }
            _info = (org.openapitools.empoa.swagger.core.internal.models.info.SwInfo) info;
            _swOpenAPI.setInfo(_info.getSw());
        } else {
            _info = null;
            _swOpenAPI.setInfo(null);
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation _externalDocs;

    private void initExternalDocs() {
        if (_swOpenAPI.getExternalDocs() == null) {
            _externalDocs = null;
        } else if (_externalDocs == null) {
            _externalDocs = new org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation(_swOpenAPI.getExternalDocs());
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
            _swOpenAPI.setExternalDocs(_externalDocs.getSw());
        } else {
            _externalDocs = null;
            _swOpenAPI.setExternalDocs(null);
        }
    }

    private java.util.List<org.openapitools.empoa.swagger.core.internal.models.servers.SwServer> _servers;

    private void initServers() {
        if (_swOpenAPI.getServers() == null) {
            _servers = null;
        } else if (_servers == null) {
            _servers = _swOpenAPI.getServers()
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
        _swOpenAPI.setServers(null);
        if (servers != null) {
            if (servers.isEmpty()) {
                _swOpenAPI.setServers(new java.util.ArrayList<>());
            } else {
                for (org.eclipse.microprofile.openapi.models.servers.Server e : servers) {
                    this.addServer(e);
                }
            }
        }
    }

    @Override
    public OpenAPI addServer(org.eclipse.microprofile.openapi.models.servers.Server server) {
        if (!(server instanceof org.openapitools.empoa.swagger.core.internal.models.servers.SwServer)) {
            throw new IllegalArgumentException("Unexpected type: " + server);
        }
        org.openapitools.empoa.swagger.core.internal.models.servers.SwServer element = (org.openapitools.empoa.swagger.core.internal.models.servers.SwServer) server;
        initServers();
        if (_servers == null) {
            _servers = new java.util.ArrayList<>();
            _swOpenAPI.setServers(new java.util.ArrayList<>());
        }
        _servers.add(element);
        _swOpenAPI.getServers()
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
            _swOpenAPI.getServers()
                .remove(element.getSw());
        }
    }

    private java.util.List<org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement> _security;

    private void initSecurity() {
        if (_swOpenAPI.getSecurity() == null) {
            _security = null;
        } else if (_security == null) {
            _security = _swOpenAPI.getSecurity()
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
        _swOpenAPI.setSecurity(null);
        if (security != null) {
            if (security.isEmpty()) {
                _swOpenAPI.setSecurity(new java.util.ArrayList<>());
            } else {
                for (org.eclipse.microprofile.openapi.models.security.SecurityRequirement e : security) {
                    this.addSecurityRequirement(e);
                }
            }
        }
    }

    @Override
    public OpenAPI addSecurityRequirement(org.eclipse.microprofile.openapi.models.security.SecurityRequirement securityRequirement) {
        if (!(securityRequirement instanceof org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement)) {
            throw new IllegalArgumentException("Unexpected type: " + securityRequirement);
        }
        org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement element = (org.openapitools.empoa.swagger.core.internal.models.security.SwSecurityRequirement) securityRequirement;
        initSecurity();
        if (_security == null) {
            _security = new java.util.ArrayList<>();
            _swOpenAPI.setSecurity(new java.util.ArrayList<>());
        }
        _security.add(element);
        _swOpenAPI.getSecurity()
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
            _swOpenAPI.getSecurity()
                .remove(element.getSw());
        }
    }

    private java.util.List<org.openapitools.empoa.swagger.core.internal.models.tags.SwTag> _tags;

    private void initTags() {
        if (_swOpenAPI.getTags() == null) {
            _tags = null;
        } else if (_tags == null) {
            _tags = _swOpenAPI.getTags()
                .stream()
                .map(org.openapitools.empoa.swagger.core.internal.models.tags.SwTag::new)
                .collect(java.util.stream.Collectors.toCollection(java.util.ArrayList::new));
        }
    }

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.tags.Tag> getTags() {
        initTags();
        if (_tags == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_tags);
    }

    @Override
    public void setTags(java.util.List<org.eclipse.microprofile.openapi.models.tags.Tag> tags) {
        _swOpenAPI.setTags(null);
        if (tags != null) {
            if (tags.isEmpty()) {
                _swOpenAPI.setTags(new java.util.ArrayList<>());
            } else {
                for (org.eclipse.microprofile.openapi.models.tags.Tag e : tags) {
                    this.addTag(e);
                }
            }
        }
    }

    @Override
    public OpenAPI addTag(org.eclipse.microprofile.openapi.models.tags.Tag tag) {
        if (!(tag instanceof org.openapitools.empoa.swagger.core.internal.models.tags.SwTag)) {
            throw new IllegalArgumentException("Unexpected type: " + tag);
        }
        org.openapitools.empoa.swagger.core.internal.models.tags.SwTag element = (org.openapitools.empoa.swagger.core.internal.models.tags.SwTag) tag;
        initTags();
        if (_tags == null) {
            _tags = new java.util.ArrayList<>();
            _swOpenAPI.setTags(new java.util.ArrayList<>());
        }
        _tags.add(element);
        _swOpenAPI.getTags()
            .add(element.getSw());
        return this;
    }

    @Override
    public void removeTag(org.eclipse.microprofile.openapi.models.tags.Tag tag) {
        if (!(tag instanceof org.openapitools.empoa.swagger.core.internal.models.tags.SwTag)) {
            throw new IllegalArgumentException("Unexpected type: " + tag);
        }
        org.openapitools.empoa.swagger.core.internal.models.tags.SwTag element = (org.openapitools.empoa.swagger.core.internal.models.tags.SwTag) tag;
        initTags();
        if (_tags != null) {
            _tags.remove(tag);
            _swOpenAPI.getTags()
                .remove(element.getSw());
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.SwPaths _paths;

    private void initPaths() {
        if (_swOpenAPI.getPaths() == null) {
            _paths = null;
        } else if (_paths == null) {
            _paths = new org.openapitools.empoa.swagger.core.internal.models.SwPaths(_swOpenAPI.getPaths());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.Paths getPaths() {
        initPaths();
        return _paths;
    }

    @Override
    public void setPaths(org.eclipse.microprofile.openapi.models.Paths paths) {
        if (paths != null) {
            if (!(paths instanceof org.openapitools.empoa.swagger.core.internal.models.SwPaths)) {
                throw new IllegalArgumentException("Unexpected type: " + paths);
            }
            _paths = (org.openapitools.empoa.swagger.core.internal.models.SwPaths) paths;
            _swOpenAPI.setPaths(_paths.getSw());
        } else {
            _paths = null;
            _swOpenAPI.setPaths(null);
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.SwComponents _components;

    private void initComponents() {
        if (_swOpenAPI.getComponents() == null) {
            _components = null;
        } else if (_components == null) {
            _components = new org.openapitools.empoa.swagger.core.internal.models.SwComponents(_swOpenAPI.getComponents());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.Components getComponents() {
        initComponents();
        return _components;
    }

    @Override
    public void setComponents(org.eclipse.microprofile.openapi.models.Components components) {
        if (components != null) {
            if (!(components instanceof org.openapitools.empoa.swagger.core.internal.models.SwComponents)) {
                throw new IllegalArgumentException("Unexpected type: " + components);
            }
            _components = (org.openapitools.empoa.swagger.core.internal.models.SwComponents) components;
            _swOpenAPI.setComponents(_components.getSw());
        } else {
            _components = null;
            _swOpenAPI.setComponents(null);
        }
    }

}
