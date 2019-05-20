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

import org.eclipse.microprofile.openapi.models.info.Info;

public class SwInfo implements Info {

    private io.swagger.v3.oas.models.info.Info _swInfo;

    public SwInfo() {
        _swInfo = new io.swagger.v3.oas.models.info.Info();
    }

    public SwInfo(io.swagger.v3.oas.models.info.Info _swInfo) {
        this._swInfo = _swInfo;
    }

    public io.swagger.v3.oas.models.info.Info getSw() {
        return _swInfo;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swInfo.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swInfo.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swInfo.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Info addExtension(String key, Object object) {
        _swInfo.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swInfo.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getTitle() {
        return _swInfo.getTitle();
    }

    @Override
    public void setTitle(String title) {
        _swInfo.setTitle(title);
    }

    @Override
    public String getDescription() {
        return _swInfo.getDescription();
    }

    @Override
    public void setDescription(String description) {
        _swInfo.setDescription(description);
    }

    @Override
    public String getTermsOfService() {
        return _swInfo.getTermsOfService();
    }

    @Override
    public void setTermsOfService(String termsOfService) {
        _swInfo.setTermsOfService(termsOfService);
    }

    private org.openapitools.empoa.swagger.core.internal.models.info.SwContact _contact;

    private void initContact() {
        if (_swInfo.getContact() == null) {
            _contact = null;
        } else if (_contact == null) {
            _contact = new org.openapitools.empoa.swagger.core.internal.models.info.SwContact(_swInfo.getContact());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.info.Contact getContact() {
        initContact();
        return _contact;
    }

    @Override
    public void setContact(org.eclipse.microprofile.openapi.models.info.Contact contact) {
        if (contact != null) {
            if (!(contact instanceof org.openapitools.empoa.swagger.core.internal.models.info.SwContact)) {
                throw new IllegalArgumentException("Unexpected type: " + contact);
            }
            _contact = (org.openapitools.empoa.swagger.core.internal.models.info.SwContact) contact;
            _swInfo.setContact(_contact.getSw());
        } else {
            _contact = null;
            _swInfo.setContact(null);
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.info.SwLicense _license;

    private void initLicense() {
        if (_swInfo.getLicense() == null) {
            _license = null;
        } else if (_license == null) {
            _license = new org.openapitools.empoa.swagger.core.internal.models.info.SwLicense(_swInfo.getLicense());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.info.License getLicense() {
        initLicense();
        return _license;
    }

    @Override
    public void setLicense(org.eclipse.microprofile.openapi.models.info.License license) {
        if (license != null) {
            if (!(license instanceof org.openapitools.empoa.swagger.core.internal.models.info.SwLicense)) {
                throw new IllegalArgumentException("Unexpected type: " + license);
            }
            _license = (org.openapitools.empoa.swagger.core.internal.models.info.SwLicense) license;
            _swInfo.setLicense(_license.getSw());
        } else {
            _license = null;
            _swInfo.setLicense(null);
        }
    }

    @Override
    public String getVersion() {
        return _swInfo.getVersion();
    }

    @Override
    public void setVersion(String version) {
        _swInfo.setVersion(version);
    }

}
