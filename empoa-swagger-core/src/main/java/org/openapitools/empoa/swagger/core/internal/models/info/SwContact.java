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
package org.openapitools.empoa.swagger.core.internal.models.info;

import org.eclipse.microprofile.openapi.models.info.Contact;

public class SwContact implements Contact {

    private io.swagger.v3.oas.models.info.Contact _swContact;

    public SwContact() {
        _swContact = new io.swagger.v3.oas.models.info.Contact();
    }

    public SwContact(io.swagger.v3.oas.models.info.Contact _swContact) {
        this._swContact = _swContact;
    }

    public io.swagger.v3.oas.models.info.Contact getSw() {
        return _swContact;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swContact.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swContact.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swContact.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Contact addExtension(String key, Object object) {
        _swContact.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swContact.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getName() {
        return _swContact.getName();
    }

    @Override
    public void setName(String name) {
        _swContact.setName(name);
    }

    @Override
    public String getUrl() {
        return _swContact.getUrl();
    }

    @Override
    public void setUrl(String url) {
        _swContact.setUrl(url);
    }

    @Override
    public String getEmail() {
        return _swContact.getEmail();
    }

    @Override
    public void setEmail(String email) {
        _swContact.setEmail(email);
    }

}
