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

import org.eclipse.microprofile.openapi.models.media.Discriminator;

public class SwDiscriminator implements Discriminator {

    private io.swagger.v3.oas.models.media.Discriminator _swDiscriminator;

    public SwDiscriminator() {
        _swDiscriminator = new io.swagger.v3.oas.models.media.Discriminator();
    }

    public SwDiscriminator(io.swagger.v3.oas.models.media.Discriminator _swDiscriminator) {
        this._swDiscriminator = _swDiscriminator;
    }

    public io.swagger.v3.oas.models.media.Discriminator getSw() {
        return _swDiscriminator;
    }

    @Override
    public String getPropertyName() {
        return _swDiscriminator.getPropertyName();
    }

    @Override
    public void setPropertyName(String propertyName) {
        _swDiscriminator.setPropertyName(propertyName);
    }

    @Override
    public java.util.Map<String, String> getMapping() {
        java.util.Map<String, String> result = _swDiscriminator.getMapping();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setMapping(java.util.Map<String, String> mapping) {
        _swDiscriminator.setMapping(null);
        if (mapping != null) {
            if (mapping.isEmpty()) {
                _swDiscriminator.setMapping(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, String> e : mapping.entrySet()) {
                    this.addMapping(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Discriminator addMapping(String key, String string) {
        _swDiscriminator.mapping(key, string);
        return this;
    }

    @Override
    public void removeMapping(String key) {
        if (getMapping() != null) {
            _swDiscriminator.getMapping()
                .remove(key);
        }
    }

}
