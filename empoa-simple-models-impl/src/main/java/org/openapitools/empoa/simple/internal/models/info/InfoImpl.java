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
package org.openapitools.empoa.simple.internal.models.info;

import org.eclipse.microprofile.openapi.models.info.Info;

public class InfoImpl implements Info {

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
    public Info addExtension(String key, Object object) {
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

    private String _title;

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;
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

    private String _termsOfService;

    @Override
    public String getTermsOfService() {
        return _termsOfService;
    }

    @Override
    public void setTermsOfService(String termsOfService) {
        _termsOfService = termsOfService;
    }

    private org.eclipse.microprofile.openapi.models.info.Contact _contact;

    @Override
    public org.eclipse.microprofile.openapi.models.info.Contact getContact() {
        return _contact;
    }

    @Override
    public void setContact(org.eclipse.microprofile.openapi.models.info.Contact contact) {
        _contact = contact;
    }

    private org.eclipse.microprofile.openapi.models.info.License _license;

    @Override
    public org.eclipse.microprofile.openapi.models.info.License getLicense() {
        return _license;
    }

    @Override
    public void setLicense(org.eclipse.microprofile.openapi.models.info.License license) {
        _license = license;
    }

    private String _version;

    @Override
    public String getVersion() {
        return _version;
    }

    @Override
    public void setVersion(String version) {
        _version = version;
    }

}
