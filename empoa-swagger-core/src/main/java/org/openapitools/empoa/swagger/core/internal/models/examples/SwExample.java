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
package org.openapitools.empoa.swagger.core.internal.models.examples;

import org.eclipse.microprofile.openapi.models.examples.Example;

public class SwExample implements Example {

    private io.swagger.v3.oas.models.examples.Example _swExample;

    public SwExample() {
        _swExample = new io.swagger.v3.oas.models.examples.Example();
    }

    public SwExample(io.swagger.v3.oas.models.examples.Example _swExample) {
        this._swExample = _swExample;
    }

    public io.swagger.v3.oas.models.examples.Example getSw() {
        return _swExample;
    }

    @Override
    public String getRef() {
        return _swExample.get$ref();
    }

    @Override
    public void setRef(String ref) {
        _swExample.set$ref(ref);
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swExample.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swExample.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swExample.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Example addExtension(String key, Object object) {
        _swExample.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swExample.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getSummary() {
        return _swExample.getSummary();
    }

    @Override
    public void setSummary(String summary) {
        _swExample.setSummary(summary);
    }

    @Override
    public String getDescription() {
        return _swExample.getDescription();
    }

    @Override
    public void setDescription(String description) {
        _swExample.setDescription(description);
    }

    @Override
    public Object getValue() {
        return _swExample.getValue();
    }

    @Override
    public void setValue(Object value) {
        _swExample.setValue(value);
    }

    @Override
    public String getExternalValue() {
        return _swExample.getExternalValue();
    }

    @Override
    public void setExternalValue(String externalValue) {
        _swExample.setExternalValue(externalValue);
    }

}
