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
package org.openapitools.empoa.simple.internal.models.parameters;

import org.eclipse.microprofile.openapi.models.parameters.Parameter;

public class ParameterImpl implements Parameter {

    private String _ref;

    @Override
    public String getRef() {
        return _ref;
    }

    @Override
    public void setRef(String ref) {
        if (ref != null && !ref.contains("#") && !ref.contains("/")) {
            _ref = "#/components/parameters/" + ref;
        } else {
            _ref = ref;
        }
    }

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
    public Parameter addExtension(String key, Object object) {
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

    private String _name;

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    private org.eclipse.microprofile.openapi.models.parameters.Parameter.In _in;

    @Override
    public org.eclipse.microprofile.openapi.models.parameters.Parameter.In getIn() {
        return _in;
    }

    @Override
    public void setIn(org.eclipse.microprofile.openapi.models.parameters.Parameter.In in) {
        _in = in;
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

    private Boolean _required;

    @Override
    public Boolean getRequired() {
        return _required;
    }

    @Override
    public void setRequired(Boolean required) {
        _required = required;
    }

    private Boolean _deprecated;

    @Override
    public Boolean getDeprecated() {
        return _deprecated;
    }

    @Override
    public void setDeprecated(Boolean deprecated) {
        _deprecated = deprecated;
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

    private org.eclipse.microprofile.openapi.models.parameters.Parameter.Style _style;

    @Override
    public org.eclipse.microprofile.openapi.models.parameters.Parameter.Style getStyle() {
        return _style;
    }

    @Override
    public void setStyle(org.eclipse.microprofile.openapi.models.parameters.Parameter.Style style) {
        _style = style;
    }

    private Boolean _explode;

    @Override
    public Boolean getExplode() {
        return _explode;
    }

    @Override
    public void setExplode(Boolean explode) {
        _explode = explode;
    }

    private Boolean _allowReserved;

    @Override
    public Boolean getAllowReserved() {
        return _allowReserved;
    }

    @Override
    public void setAllowReserved(Boolean allowReserved) {
        _allowReserved = allowReserved;
    }

    private org.eclipse.microprofile.openapi.models.media.Schema _schema;

    @Override
    public org.eclipse.microprofile.openapi.models.media.Schema getSchema() {
        return _schema;
    }

    @Override
    public void setSchema(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        _schema = schema;
    }

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.examples.Example> _examples;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.examples.Example> getExamples() {
        if (_examples == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_examples);
    }

    @Override
    public void setExamples(java.util.Map<String, org.eclipse.microprofile.openapi.models.examples.Example> examples) {
        if (examples == null) {
            _examples = null;
        } else {
            _examples = new java.util.LinkedHashMap<>();
            _examples.putAll(examples);
        }
    }

    @Override
    public Parameter addExample(String key, org.eclipse.microprofile.openapi.models.examples.Example example) {
        if (example == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_examples == null) {
                _examples = new java.util.LinkedHashMap<>();
            }
            _examples.put(key, example);
        }
        return this;
    }

    @Override
    public void removeExample(String key) {
        if (_examples != null) {
            _examples.remove(key);
        }
    }

    private Object _example;

    @Override
    public Object getExample() {
        return _example;
    }

    @Override
    public void setExample(Object example) {
        _example = example;
    }

    private org.eclipse.microprofile.openapi.models.media.Content _content;

    @Override
    public org.eclipse.microprofile.openapi.models.media.Content getContent() {
        return _content;
    }

    @Override
    public void setContent(org.eclipse.microprofile.openapi.models.media.Content content) {
        _content = content;
    }

}
