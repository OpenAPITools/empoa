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
package org.openapitools.empoa.simple.internal.models.media;

import org.eclipse.microprofile.openapi.models.media.Discriminator;

public class DiscriminatorImpl implements Discriminator {

    private String _propertyName;

    @Override
    public String getPropertyName() {
        return _propertyName;
    }

    @Override
    public void setPropertyName(String propertyName) {
        _propertyName = propertyName;
    }

    private java.util.Map<String, String> _mapping;

    @Override
    public java.util.Map<String, String> getMapping() {
        if (_mapping == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_mapping);
    }

    @Override
    public void setMapping(java.util.Map<String, String> mapping) {
        if (mapping == null) {
            _mapping = null;
        } else {
            _mapping = new java.util.LinkedHashMap<>();
            _mapping.putAll(mapping);
        }
    }

    @Override
    public Discriminator addMapping(String key, String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_mapping == null) {
                _mapping = new java.util.LinkedHashMap<>();
            }
            _mapping.put(key, string);
        }
        return this;
    }

    @Override
    public void removeMapping(String key) {
        if (_mapping != null) {
            _mapping.remove(key);
        }
    }

}
