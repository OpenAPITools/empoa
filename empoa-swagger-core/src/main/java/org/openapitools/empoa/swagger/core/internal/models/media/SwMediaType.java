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

import org.eclipse.microprofile.openapi.models.media.MediaType;

public class SwMediaType implements MediaType {

    private io.swagger.v3.oas.models.media.MediaType _swMediaType;

    public SwMediaType() {
        _swMediaType = new io.swagger.v3.oas.models.media.MediaType();
    }

    public SwMediaType(io.swagger.v3.oas.models.media.MediaType _swMediaType) {
        this._swMediaType = _swMediaType;
    }

    public io.swagger.v3.oas.models.media.MediaType getSw() {
        return _swMediaType;
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swMediaType.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swMediaType.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swMediaType.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public MediaType addExtension(String key, Object object) {
        _swMediaType.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swMediaType.getExtensions()
                .remove(key);
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.media.SwSchema _schema;

    private void initSchema() {
        if (_swMediaType.getSchema() == null) {
            _schema = null;
        } else if (_schema == null) {
            _schema = new org.openapitools.empoa.swagger.core.internal.models.media.SwSchema(_swMediaType.getSchema());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.media.Schema getSchema() {
        initSchema();
        return _schema;
    }

    @Override
    public void setSchema(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (schema != null) {
            if (!(schema instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwSchema)) {
                throw new IllegalArgumentException("Unexpected type: " + schema);
            }
            _schema = (org.openapitools.empoa.swagger.core.internal.models.media.SwSchema) schema;
            _swMediaType.setSchema(_schema.getSw());
        } else {
            _schema = null;
            _swMediaType.setSchema(null);
        }
    }

    private java.util.Map<String, org.openapitools.empoa.swagger.core.internal.models.examples.SwExample> _examples;

    private void initExamples() {
        if (_swMediaType.getExamples() == null) {
            _examples = null;
        } else if (_examples == null) {
            _examples = _swMediaType.getExamples()
                .entrySet()
                .stream()
                .collect(
                    java.util.stream.Collectors.toMap(
                        java.util.Map.Entry::getKey,
                        e -> new org.openapitools.empoa.swagger.core.internal.models.examples.SwExample(e.getValue()),
                        (k1, k2) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", k1));
                        },
                        () -> new java.util.LinkedHashMap<String, org.openapitools.empoa.swagger.core.internal.models.examples.SwExample>()
                    )
                );
        }
    }

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.examples.Example> getExamples() {
        initExamples();
        if (_examples == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_examples);
    }

    @Override
    public void setExamples(java.util.Map<String, org.eclipse.microprofile.openapi.models.examples.Example> examples) {
        _swMediaType.setExamples(null);
        if (examples != null) {
            if (examples.isEmpty()) {
                _swMediaType.setExamples(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.examples.Example> e : examples.entrySet()) {
                    this.addExample(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public MediaType addExample(String key, org.eclipse.microprofile.openapi.models.examples.Example example) {
        if (!(example instanceof org.openapitools.empoa.swagger.core.internal.models.examples.SwExample)) {
            throw new IllegalArgumentException("Unexpected type: " + example);
        }
        org.openapitools.empoa.swagger.core.internal.models.examples.SwExample value = (org.openapitools.empoa.swagger.core.internal.models.examples.SwExample) example;
        initExamples();
        if (_examples == null) {
            _examples = new java.util.LinkedHashMap<>();
            _swMediaType.setExamples(new java.util.LinkedHashMap<>());
        }
        _examples.put(key, value);
        _swMediaType.getExamples()
            .put(key, value.getSw());
        return this;
    }

    @Override
    public void removeExample(String key) {
        initExamples();
        if (_examples != null) {
            _examples.remove(key);
            _swMediaType.getExamples()
                .remove(key);
        }
    }

    @Override
    public Object getExample() {
        return _swMediaType.getExample();
    }

    @Override
    public void setExample(Object example) {
        _swMediaType.setExample(example);
    }

    private java.util.Map<String, org.openapitools.empoa.swagger.core.internal.models.media.SwEncoding> _encoding;

    private void initEncoding() {
        if (_swMediaType.getEncoding() == null) {
            _encoding = null;
        } else if (_encoding == null) {
            _encoding = _swMediaType.getEncoding()
                .entrySet()
                .stream()
                .collect(
                    java.util.stream.Collectors.toMap(
                        java.util.Map.Entry::getKey,
                        e -> new org.openapitools.empoa.swagger.core.internal.models.media.SwEncoding(e.getValue()),
                        (k1, k2) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", k1));
                        },
                        () -> new java.util.LinkedHashMap<String, org.openapitools.empoa.swagger.core.internal.models.media.SwEncoding>()
                    )
                );
        }
    }

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.media.Encoding> getEncoding() {
        initEncoding();
        if (_encoding == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_encoding);
    }

    @Override
    public void setEncoding(java.util.Map<String, org.eclipse.microprofile.openapi.models.media.Encoding> encoding) {
        _swMediaType.setEncoding(null);
        if (encoding != null) {
            if (encoding.isEmpty()) {
                _swMediaType.setEncoding(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.media.Encoding> e : encoding.entrySet()) {
                    this.addEncoding(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public MediaType addEncoding(String key, org.eclipse.microprofile.openapi.models.media.Encoding encoding) {
        if (!(encoding instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwEncoding)) {
            throw new IllegalArgumentException("Unexpected type: " + encoding);
        }
        org.openapitools.empoa.swagger.core.internal.models.media.SwEncoding value = (org.openapitools.empoa.swagger.core.internal.models.media.SwEncoding) encoding;
        initEncoding();
        if (_encoding == null) {
            _encoding = new java.util.LinkedHashMap<>();
            _swMediaType.setEncoding(new java.util.LinkedHashMap<>());
        }
        _encoding.put(key, value);
        _swMediaType.getEncoding()
            .put(key, value.getSw());
        return this;
    }

    @Override
    public void removeEncoding(String key) {
        initEncoding();
        if (_encoding != null) {
            _encoding.remove(key);
            _swMediaType.getEncoding()
                .remove(key);
        }
    }

}
