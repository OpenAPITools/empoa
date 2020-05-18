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
package org.openapitools.empoa.swagger.core.internal.models.headers;

import org.eclipse.microprofile.openapi.models.headers.Header;

public class SwHeader implements Header {

    private io.swagger.v3.oas.models.headers.Header _swHeader;

    public SwHeader() {
        _swHeader = new io.swagger.v3.oas.models.headers.Header();
    }

    public SwHeader(io.swagger.v3.oas.models.headers.Header _swHeader) {
        this._swHeader = _swHeader;
    }

    public io.swagger.v3.oas.models.headers.Header getSw() {
        return _swHeader;
    }

    @Override
    public String getRef() {
        return _swHeader.get$ref();
    }

    @Override
    public void setRef(String ref) {
        _swHeader.set$ref(ref);
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swHeader.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swHeader.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swHeader.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Header addExtension(String key, Object object) {
        _swHeader.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swHeader.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getDescription() {
        return _swHeader.getDescription();
    }

    @Override
    public void setDescription(String description) {
        _swHeader.setDescription(description);
    }

    @Override
    public Boolean getRequired() {
        return _swHeader.getRequired();
    }

    @Override
    public void setRequired(Boolean required) {
        _swHeader.setRequired(required);
    }

    @Override
    public Boolean getDeprecated() {
        return _swHeader.getDeprecated();
    }

    @Override
    public void setDeprecated(Boolean deprecated) {
        _swHeader.setDeprecated(deprecated);
    }

    private Boolean _allowEmptyValue;

    @Override
    public Boolean getAllowEmptyValue() {
        return _allowEmptyValue;
    }

    @Override
    public void setAllowEmptyValue(Boolean allowEmptyValue) {
        _allowEmptyValue = allowEmptyValue;
    }

    @Override
    public org.eclipse.microprofile.openapi.models.headers.Header.Style getStyle() {
        if (_swHeader.getStyle() == null) {
            return null;
        }
        switch (_swHeader.getStyle()) {
        case SIMPLE:
            return org.eclipse.microprofile.openapi.models.headers.Header.Style.SIMPLE;
        default:
            throw new IllegalStateException("Unexpected enum value: " + _swHeader.getStyle());
        }
    }

    @Override
    public void setStyle(org.eclipse.microprofile.openapi.models.headers.Header.Style style) {
        io.swagger.v3.oas.models.headers.Header.StyleEnum value;
        if (style == null) {
            value = null;
        } else {
            switch (style) {
            case SIMPLE:
                value = io.swagger.v3.oas.models.headers.Header.StyleEnum.SIMPLE;
                break;
            default:
                throw new IllegalStateException("Unexpected enum value: " + style);
            }
        }
        _swHeader.setStyle(value);
    }

    @Override
    public Boolean getExplode() {
        return _swHeader.getExplode();
    }

    @Override
    public void setExplode(Boolean explode) {
        _swHeader.setExplode(explode);
    }

    private org.openapitools.empoa.swagger.core.internal.models.media.SwSchema _schema;

    private void initSchema() {
        if (_swHeader.getSchema() == null) {
            _schema = null;
        } else if (_schema == null) {
            _schema = new org.openapitools.empoa.swagger.core.internal.models.media.SwSchema(_swHeader.getSchema());
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
            _swHeader.setSchema(_schema.getSw());
        } else {
            _schema = null;
            _swHeader.setSchema(null);
        }
    }

    private java.util.Map<String, org.openapitools.empoa.swagger.core.internal.models.examples.SwExample> _examples;

    private void initExamples() {
        if (_swHeader.getExamples() == null) {
            _examples = null;
        } else if (_examples == null) {
            _examples = _swHeader.getExamples()
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
        _swHeader.setExamples(null);
        if (examples != null) {
            if (examples.isEmpty()) {
                _swHeader.setExamples(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.examples.Example> e : examples.entrySet()) {
                    this.addExample(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Header addExample(String key, org.eclipse.microprofile.openapi.models.examples.Example example) {
        if (!(example instanceof org.openapitools.empoa.swagger.core.internal.models.examples.SwExample)) {
            throw new IllegalArgumentException("Unexpected type: " + example);
        }
        org.openapitools.empoa.swagger.core.internal.models.examples.SwExample value = (org.openapitools.empoa.swagger.core.internal.models.examples.SwExample) example;
        initExamples();
        if (_examples == null) {
            _examples = new java.util.LinkedHashMap<>();
            _swHeader.setExamples(new java.util.LinkedHashMap<>());
        }
        _examples.put(key, value);
        _swHeader.getExamples()
            .put(key, value.getSw());
        return this;
    }

    @Override
    public void removeExample(String key) {
        initExamples();
        if (_examples != null) {
            _examples.remove(key);
            _swHeader.getExamples()
                .remove(key);
        }
    }

    @Override
    public Object getExample() {
        return _swHeader.getExample();
    }

    @Override
    public void setExample(Object example) {
        _swHeader.setExample(example);
    }

    private org.openapitools.empoa.swagger.core.internal.models.media.SwContent _content;

    private void initContent() {
        if (_swHeader.getContent() == null) {
            _content = null;
        } else if (_content == null) {
            _content = new org.openapitools.empoa.swagger.core.internal.models.media.SwContent(_swHeader.getContent());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.media.Content getContent() {
        initContent();
        return _content;
    }

    @Override
    public void setContent(org.eclipse.microprofile.openapi.models.media.Content content) {
        if (content != null) {
            if (!(content instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwContent)) {
                throw new IllegalArgumentException("Unexpected type: " + content);
            }
            _content = (org.openapitools.empoa.swagger.core.internal.models.media.SwContent) content;
            _swHeader.setContent(_content.getSw());
        } else {
            _content = null;
            _swHeader.setContent(null);
        }
    }

}
