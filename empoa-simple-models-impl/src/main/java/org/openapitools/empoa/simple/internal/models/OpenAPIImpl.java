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

import org.eclipse.microprofile.openapi.models.OpenAPI;

public class OpenAPIImpl implements OpenAPI {

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
    public OpenAPI addExtension(String key, Object object) {
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

    private String _openapi;

    @Override
    public String getOpenapi() {
        return _openapi;
    }

    @Override
    public void setOpenapi(String openapi) {
        _openapi = openapi;
    }

    private org.eclipse.microprofile.openapi.models.info.Info _info;

    @Override
    public org.eclipse.microprofile.openapi.models.info.Info getInfo() {
        return _info;
    }

    @Override
    public void setInfo(org.eclipse.microprofile.openapi.models.info.Info info) {
        _info = info;
    }

    private org.eclipse.microprofile.openapi.models.ExternalDocumentation _externalDocs;

    @Override
    public org.eclipse.microprofile.openapi.models.ExternalDocumentation getExternalDocs() {
        return _externalDocs;
    }

    @Override
    public void setExternalDocs(org.eclipse.microprofile.openapi.models.ExternalDocumentation externalDocs) {
        _externalDocs = externalDocs;
    }

    private java.util.List<org.eclipse.microprofile.openapi.models.servers.Server> _servers;

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.servers.Server> getServers() {
        if (_servers == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_servers);
    }

    @Override
    public void setServers(java.util.List<org.eclipse.microprofile.openapi.models.servers.Server> servers) {
        if (servers == null) {
            _servers = null;
        } else {
            _servers = new java.util.ArrayList<>();
            _servers.addAll(servers);
        }
    }

    @Override
    public OpenAPI addServer(org.eclipse.microprofile.openapi.models.servers.Server server) {
        if (_servers == null) {
            _servers = new java.util.ArrayList<>();
        }
        _servers.add(server);
        return this;
    }

    @Override
    public void removeServer(org.eclipse.microprofile.openapi.models.servers.Server server) {
        if (_servers != null) {
            _servers.remove(server);
        }
    }

    private java.util.List<org.eclipse.microprofile.openapi.models.security.SecurityRequirement> _security;

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.security.SecurityRequirement> getSecurity() {
        if (_security == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_security);
    }

    @Override
    public void setSecurity(java.util.List<org.eclipse.microprofile.openapi.models.security.SecurityRequirement> security) {
        if (security == null) {
            _security = null;
        } else {
            _security = new java.util.ArrayList<>();
            _security.addAll(security);
        }
    }

    @Override
    public OpenAPI addSecurityRequirement(org.eclipse.microprofile.openapi.models.security.SecurityRequirement securityRequirement) {
        if (_security == null) {
            _security = new java.util.ArrayList<>();
        }
        _security.add(securityRequirement);
        return this;
    }

    @Override
    public void removeSecurityRequirement(org.eclipse.microprofile.openapi.models.security.SecurityRequirement securityRequirement) {
        if (_security != null) {
            _security.remove(securityRequirement);
        }
    }

    private java.util.List<org.eclipse.microprofile.openapi.models.tags.Tag> _tags;

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.tags.Tag> getTags() {
        if (_tags == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_tags);
    }

    @Override
    public void setTags(java.util.List<org.eclipse.microprofile.openapi.models.tags.Tag> tags) {
        if (tags == null) {
            _tags = null;
        } else {
            _tags = new java.util.ArrayList<>();
            _tags.addAll(tags);
        }
    }

    @Override
    public OpenAPI addTag(org.eclipse.microprofile.openapi.models.tags.Tag tag) {
        if (_tags == null) {
            _tags = new java.util.ArrayList<>();
        }
        _tags.add(tag);
        return this;
    }

    @Override
    public void removeTag(org.eclipse.microprofile.openapi.models.tags.Tag tag) {
        if (_tags != null) {
            _tags.remove(tag);
        }
    }

    private org.eclipse.microprofile.openapi.models.Paths _paths;

    @Override
    public org.eclipse.microprofile.openapi.models.Paths getPaths() {
        return _paths;
    }

    @Override
    public void setPaths(org.eclipse.microprofile.openapi.models.Paths paths) {
        _paths = paths;
    }

    private org.eclipse.microprofile.openapi.models.Components _components;

    @Override
    public org.eclipse.microprofile.openapi.models.Components getComponents() {
        return _components;
    }

    @Override
    public void setComponents(org.eclipse.microprofile.openapi.models.Components components) {
        _components = components;
    }

}
