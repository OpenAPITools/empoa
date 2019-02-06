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

import org.eclipse.microprofile.openapi.models.media.XML;

public class SwXML implements XML {

    private io.swagger.v3.oas.models.media.XML _swXML;

    public SwXML() {
        _swXML = new io.swagger.v3.oas.models.media.XML();
    }

    public SwXML(io.swagger.v3.oas.models.media.XML _swXML) {
        this._swXML = _swXML;
    }

    public io.swagger.v3.oas.models.media.XML getSw() {
        return _swXML;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swXML.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swXML.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swXML.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public XML addExtension(String key, Object object) {
        _swXML.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swXML.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getName() {
        return _swXML.getName();
    }

    @Override
    public void setName(String name) {
        _swXML.setName(name);
    }

    @Override
    public String getNamespace() {
        return _swXML.getNamespace();
    }

    @Override
    public void setNamespace(String namespace) {
        _swXML.setNamespace(namespace);
    }

    @Override
    public String getPrefix() {
        return _swXML.getPrefix();
    }

    @Override
    public void setPrefix(String prefix) {
        _swXML.setPrefix(prefix);
    }

    @Override
    public Boolean getAttribute() {
        return _swXML.getAttribute();
    }

    @Override
    public void setAttribute(Boolean attribute) {
        _swXML.setAttribute(attribute);
    }

    @Override
    public Boolean getWrapped() {
        return _swXML.getWrapped();
    }

    @Override
    public void setWrapped(Boolean wrapped) {
        _swXML.setWrapped(wrapped);
    }

}
