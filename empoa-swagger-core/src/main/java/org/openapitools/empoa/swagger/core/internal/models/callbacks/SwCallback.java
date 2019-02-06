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
package org.openapitools.empoa.swagger.core.internal.models.callbacks;

import org.eclipse.microprofile.openapi.models.callbacks.Callback;

public class SwCallback implements Callback {

    private io.swagger.v3.oas.models.callbacks.Callback _swCallback;

    public SwCallback() {
        _swCallback = new io.swagger.v3.oas.models.callbacks.Callback();
    }

    public SwCallback(io.swagger.v3.oas.models.callbacks.Callback _swCallback) {
        this._swCallback = _swCallback;
    }

    public io.swagger.v3.oas.models.callbacks.Callback getSw() {
        return _swCallback;
    }

    @Override
    public String getRef() {
        return _swCallback.get$ref();
    }

    @Override
    public void setRef(String ref) {
        _swCallback.set$ref(ref);
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swCallback.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swCallback.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swCallback.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Callback addExtension(String key, Object object) {
        _swCallback.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swCallback.getExtensions()
                .remove(key);
        }
    }

    private java.util.Map<String, org.openapitools.empoa.swagger.core.internal.models.SwPathItem> _pathItems;

    private void initPathItems() {
        if (_swCallback == null) {
            _pathItems = null;
        } else if (_pathItems == null) {
            _pathItems = _swCallback
                .entrySet()
                .stream()
                .collect(
                    java.util.stream.Collectors.toMap(
                        java.util.Map.Entry::getKey,
                        e -> new org.openapitools.empoa.swagger.core.internal.models.SwPathItem(e.getValue()),
                        (k1, k2) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", k1));
                        },
                        () -> new java.util.LinkedHashMap<String, org.openapitools.empoa.swagger.core.internal.models.SwPathItem>()
                    )
                );
        }
    }

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.PathItem> getPathItems() {
        initPathItems();
        if (_pathItems == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_pathItems);
    }

    @Override
    public void setPathItems(java.util.Map<String, org.eclipse.microprofile.openapi.models.PathItem> pathItems) {
        _swCallback.clear();
        if (pathItems != null) {
            if (pathItems.isEmpty()) {
                _pathItems = new java.util.LinkedHashMap<>();
            } else {
                for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.PathItem> e : pathItems.entrySet()) {
                    this.addPathItem(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Callback addPathItem(String key, org.eclipse.microprofile.openapi.models.PathItem pathItem) {
        if (!(pathItem instanceof org.openapitools.empoa.swagger.core.internal.models.SwPathItem)) {
            throw new IllegalArgumentException("Unexpected type: " + pathItem);
        }
        org.openapitools.empoa.swagger.core.internal.models.SwPathItem value = (org.openapitools.empoa.swagger.core.internal.models.SwPathItem) pathItem;
        initPathItems();
        if (_pathItems == null) {
            _pathItems = new java.util.LinkedHashMap<>();
        }
        _pathItems.put(key, value);
        _swCallback.put(key, value.getSw());
        return this;
    }

    @Override
    public void removePathItem(String key) {
        initPathItems();
        if (_pathItems != null) {
            _pathItems.remove(key);
            _swCallback.remove(key);
        }
    }

}
