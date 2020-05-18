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
package org.openapitools.empoa.swagger.core.internal.models.parameters;

import org.eclipse.microprofile.openapi.models.parameters.Parameter;

public class SwParameter implements Parameter {

    private io.swagger.v3.oas.models.parameters.Parameter _swParameter;

    public SwParameter() {
        _swParameter = new io.swagger.v3.oas.models.parameters.Parameter();
    }

    public SwParameter(io.swagger.v3.oas.models.parameters.Parameter _swParameter) {
        this._swParameter = _swParameter;
    }

    public io.swagger.v3.oas.models.parameters.Parameter getSw() {
        return _swParameter;
    }

    @Override
    public String getRef() {
        return _swParameter.get$ref();
    }

    @Override
    public void setRef(String ref) {
        _swParameter.set$ref(ref);
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swParameter.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swParameter.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swParameter.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Parameter addExtension(String key, Object object) {
        _swParameter.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swParameter.getExtensions()
                .remove(key);
        }
    }

    @Override
    public String getName() {
        return _swParameter.getName();
    }

    @Override
    public void setName(String name) {
        _swParameter.setName(name);
    }

    @Override
    public org.eclipse.microprofile.openapi.models.parameters.Parameter.In getIn() {
        if (_swParameter.getIn() == null) {
            return null;
        }
        switch (_swParameter.getIn()
            .toLowerCase()) {
        case "cookie":
            return org.eclipse.microprofile.openapi.models.parameters.Parameter.In.COOKIE;
        case "header":
            return org.eclipse.microprofile.openapi.models.parameters.Parameter.In.HEADER;
        case "path":
            return org.eclipse.microprofile.openapi.models.parameters.Parameter.In.PATH;
        case "query":
            return org.eclipse.microprofile.openapi.models.parameters.Parameter.In.QUERY;
        default:
            throw new IllegalStateException("Unexpected enum value: " + _swParameter.getIn());
        }
    }

    @Override
    public void setIn(org.eclipse.microprofile.openapi.models.parameters.Parameter.In in) {
        if (in == null) {
            _swParameter.setIn(null);
        } else {
            _swParameter.setIn(in.toString());
        }
    }

    @Override
    public String getDescription() {
        return _swParameter.getDescription();
    }

    @Override
    public void setDescription(String description) {
        _swParameter.setDescription(description);
    }

    @Override
    public Boolean getRequired() {
        return _swParameter.getRequired();
    }

    @Override
    public void setRequired(Boolean required) {
        _swParameter.setRequired(required);
    }

    @Override
    public Boolean getDeprecated() {
        return _swParameter.getDeprecated();
    }

    @Override
    public void setDeprecated(Boolean deprecated) {
        _swParameter.setDeprecated(deprecated);
    }

    @Override
    public Boolean getAllowEmptyValue() {
        return _swParameter.getAllowEmptyValue();
    }

    @Override
    public void setAllowEmptyValue(Boolean allowEmptyValue) {
        _swParameter.setAllowEmptyValue(allowEmptyValue);
    }

    @Override
    public org.eclipse.microprofile.openapi.models.parameters.Parameter.Style getStyle() {
        if (_swParameter.getStyle() == null) {
            return null;
        }
        switch (_swParameter.getStyle()) {
        case MATRIX:
            return org.eclipse.microprofile.openapi.models.parameters.Parameter.Style.MATRIX;
        case LABEL:
            return org.eclipse.microprofile.openapi.models.parameters.Parameter.Style.LABEL;
        case FORM:
            return org.eclipse.microprofile.openapi.models.parameters.Parameter.Style.FORM;
        case SIMPLE:
            return org.eclipse.microprofile.openapi.models.parameters.Parameter.Style.SIMPLE;
        case SPACEDELIMITED:
            return org.eclipse.microprofile.openapi.models.parameters.Parameter.Style.SPACEDELIMITED;
        case PIPEDELIMITED:
            return org.eclipse.microprofile.openapi.models.parameters.Parameter.Style.PIPEDELIMITED;
        case DEEPOBJECT:
            return org.eclipse.microprofile.openapi.models.parameters.Parameter.Style.DEEPOBJECT;
        default:
            throw new IllegalStateException("Unexpected enum value: " + _swParameter.getStyle());
        }
    }

    @Override
    public void setStyle(org.eclipse.microprofile.openapi.models.parameters.Parameter.Style style) {
        io.swagger.v3.oas.models.parameters.Parameter.StyleEnum value;
        if (style == null) {
            value = null;
        } else {
            switch (style) {
            case MATRIX:
                value = io.swagger.v3.oas.models.parameters.Parameter.StyleEnum.MATRIX;
                break;
            case LABEL:
                value = io.swagger.v3.oas.models.parameters.Parameter.StyleEnum.LABEL;
                break;
            case FORM:
                value = io.swagger.v3.oas.models.parameters.Parameter.StyleEnum.FORM;
                break;
            case SIMPLE:
                value = io.swagger.v3.oas.models.parameters.Parameter.StyleEnum.SIMPLE;
                break;
            case SPACEDELIMITED:
                value = io.swagger.v3.oas.models.parameters.Parameter.StyleEnum.SPACEDELIMITED;
                break;
            case PIPEDELIMITED:
                value = io.swagger.v3.oas.models.parameters.Parameter.StyleEnum.PIPEDELIMITED;
                break;
            case DEEPOBJECT:
                value = io.swagger.v3.oas.models.parameters.Parameter.StyleEnum.DEEPOBJECT;
                break;
            default:
                throw new IllegalStateException("Unexpected enum value: " + style);
            }
        }
        _swParameter.setStyle(value);
    }

    @Override
    public Boolean getExplode() {
        return _swParameter.getExplode();
    }

    @Override
    public void setExplode(Boolean explode) {
        _swParameter.setExplode(explode);
    }

    @Override
    public Boolean getAllowReserved() {
        return _swParameter.getAllowReserved();
    }

    @Override
    public void setAllowReserved(Boolean allowReserved) {
        _swParameter.setAllowReserved(allowReserved);
    }

    private org.openapitools.empoa.swagger.core.internal.models.media.SwSchema _schema;

    private void initSchema() {
        if (_swParameter.getSchema() == null) {
            _schema = null;
        } else if (_schema == null) {
            _schema = new org.openapitools.empoa.swagger.core.internal.models.media.SwSchema(_swParameter.getSchema());
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
            _swParameter.setSchema(_schema.getSw());
        } else {
            _schema = null;
            _swParameter.setSchema(null);
        }
    }

    private java.util.Map<String, org.openapitools.empoa.swagger.core.internal.models.examples.SwExample> _examples;

    private void initExamples() {
        if (_swParameter.getExamples() == null) {
            _examples = null;
        } else if (_examples == null) {
            _examples = _swParameter.getExamples()
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
        _swParameter.setExamples(null);
        if (examples != null) {
            if (examples.isEmpty()) {
                _swParameter.setExamples(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.examples.Example> e : examples.entrySet()) {
                    this.addExample(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Parameter addExample(String key, org.eclipse.microprofile.openapi.models.examples.Example example) {
        if (!(example instanceof org.openapitools.empoa.swagger.core.internal.models.examples.SwExample)) {
            throw new IllegalArgumentException("Unexpected type: " + example);
        }
        org.openapitools.empoa.swagger.core.internal.models.examples.SwExample value = (org.openapitools.empoa.swagger.core.internal.models.examples.SwExample) example;
        initExamples();
        if (_examples == null) {
            _examples = new java.util.LinkedHashMap<>();
            _swParameter.setExamples(new java.util.LinkedHashMap<>());
        }
        _examples.put(key, value);
        _swParameter.getExamples()
            .put(key, value.getSw());
        return this;
    }

    @Override
    public void removeExample(String key) {
        initExamples();
        if (_examples != null) {
            _examples.remove(key);
            _swParameter.getExamples()
                .remove(key);
        }
    }

    @Override
    public Object getExample() {
        return _swParameter.getExample();
    }

    @Override
    public void setExample(Object example) {
        _swParameter.setExample(example);
    }

    private org.openapitools.empoa.swagger.core.internal.models.media.SwContent _content;

    private void initContent() {
        if (_swParameter.getContent() == null) {
            _content = null;
        } else if (_content == null) {
            _content = new org.openapitools.empoa.swagger.core.internal.models.media.SwContent(_swParameter.getContent());
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
            _swParameter.setContent(_content.getSw());
        } else {
            _content = null;
            _swParameter.setContent(null);
        }
    }

}
