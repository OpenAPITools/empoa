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

import org.eclipse.microprofile.openapi.models.PathItem;

public class PathItemImpl implements PathItem {

    private String _ref;

    @Override
    public String getRef() {
        return _ref;
    }

    @Override
    public void setRef(String ref) {
        if (ref != null && !ref.contains("#") && !ref.contains("/")) {
            _ref = "#/components/pathItems/" + ref;
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
    public PathItem addExtension(String key, Object object) {
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

    private String _summary;

    @Override
    public String getSummary() {
        return _summary;
    }

    @Override
    public void setSummary(String summary) {
        _summary = summary;
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

    private org.eclipse.microprofile.openapi.models.Operation _gET;

    @Override
    public org.eclipse.microprofile.openapi.models.Operation getGET() {
        return _gET;
    }

    @Override
    public void setGET(org.eclipse.microprofile.openapi.models.Operation gET) {
        _gET = gET;
    }

    private org.eclipse.microprofile.openapi.models.Operation _pUT;

    @Override
    public org.eclipse.microprofile.openapi.models.Operation getPUT() {
        return _pUT;
    }

    @Override
    public void setPUT(org.eclipse.microprofile.openapi.models.Operation pUT) {
        _pUT = pUT;
    }

    private org.eclipse.microprofile.openapi.models.Operation _pOST;

    @Override
    public org.eclipse.microprofile.openapi.models.Operation getPOST() {
        return _pOST;
    }

    @Override
    public void setPOST(org.eclipse.microprofile.openapi.models.Operation pOST) {
        _pOST = pOST;
    }

    private org.eclipse.microprofile.openapi.models.Operation _dELETE;

    @Override
    public org.eclipse.microprofile.openapi.models.Operation getDELETE() {
        return _dELETE;
    }

    @Override
    public void setDELETE(org.eclipse.microprofile.openapi.models.Operation dELETE) {
        _dELETE = dELETE;
    }

    private org.eclipse.microprofile.openapi.models.Operation _oPTIONS;

    @Override
    public org.eclipse.microprofile.openapi.models.Operation getOPTIONS() {
        return _oPTIONS;
    }

    @Override
    public void setOPTIONS(org.eclipse.microprofile.openapi.models.Operation oPTIONS) {
        _oPTIONS = oPTIONS;
    }

    private org.eclipse.microprofile.openapi.models.Operation _hEAD;

    @Override
    public org.eclipse.microprofile.openapi.models.Operation getHEAD() {
        return _hEAD;
    }

    @Override
    public void setHEAD(org.eclipse.microprofile.openapi.models.Operation hEAD) {
        _hEAD = hEAD;
    }

    private org.eclipse.microprofile.openapi.models.Operation _pATCH;

    @Override
    public org.eclipse.microprofile.openapi.models.Operation getPATCH() {
        return _pATCH;
    }

    @Override
    public void setPATCH(org.eclipse.microprofile.openapi.models.Operation pATCH) {
        _pATCH = pATCH;
    }

    private org.eclipse.microprofile.openapi.models.Operation _tRACE;

    @Override
    public org.eclipse.microprofile.openapi.models.Operation getTRACE() {
        return _tRACE;
    }

    @Override
    public void setTRACE(org.eclipse.microprofile.openapi.models.Operation tRACE) {
        _tRACE = tRACE;
    }

    @Override
    public java.util.Map<HttpMethod, org.eclipse.microprofile.openapi.models.Operation> getOperations() {
        java.util.Map<HttpMethod, org.eclipse.microprofile.openapi.models.Operation> map = new java.util.LinkedHashMap<>();
        if (getGET() != null) {
            map.put(HttpMethod.GET, getGET());
        }
        if (getPUT() != null) {
            map.put(HttpMethod.PUT, getPUT());
        }
        if (getPOST() != null) {
            map.put(HttpMethod.POST, getPOST());
        }
        if (getDELETE() != null) {
            map.put(HttpMethod.DELETE, getDELETE());
        }
        if (getOPTIONS() != null) {
            map.put(HttpMethod.OPTIONS, getOPTIONS());
        }
        if (getHEAD() != null) {
            map.put(HttpMethod.HEAD, getHEAD());
        }
        if (getPATCH() != null) {
            map.put(HttpMethod.PATCH, getPATCH());
        }
        if (getTRACE() != null) {
            map.put(HttpMethod.TRACE, getTRACE());
        }
        return java.util.Collections.unmodifiableMap(map);
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
    public PathItem addServer(org.eclipse.microprofile.openapi.models.servers.Server server) {
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

    private java.util.List<org.eclipse.microprofile.openapi.models.parameters.Parameter> _parameters;

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.parameters.Parameter> getParameters() {
        if (_parameters == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_parameters);
    }

    @Override
    public void setParameters(java.util.List<org.eclipse.microprofile.openapi.models.parameters.Parameter> parameters) {
        if (parameters == null) {
            _parameters = null;
        } else {
            _parameters = new java.util.ArrayList<>();
            _parameters.addAll(parameters);
        }
    }

    @Override
    public PathItem addParameter(org.eclipse.microprofile.openapi.models.parameters.Parameter parameter) {
        if (_parameters == null) {
            _parameters = new java.util.ArrayList<>();
        }
        _parameters.add(parameter);
        return this;
    }

    @Override
    public void removeParameter(org.eclipse.microprofile.openapi.models.parameters.Parameter parameter) {
        if (_parameters != null) {
            _parameters.remove(parameter);
        }
    }

}
