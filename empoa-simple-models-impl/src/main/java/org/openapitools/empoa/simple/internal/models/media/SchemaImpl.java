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

import org.eclipse.microprofile.openapi.models.media.Schema;

public class SchemaImpl implements Schema {

    private String _ref;

    @Override
    public String getRef() {
        return _ref;
    }

    @Override
    public void setRef(String ref) {
        if (ref != null && !ref.contains("#") && !ref.contains("/")) {
            _ref = "#/components/schemas/" + ref;
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
    public Schema addExtension(String key, Object object) {
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

    private org.eclipse.microprofile.openapi.models.media.Discriminator _discriminator;

    @Override
    public org.eclipse.microprofile.openapi.models.media.Discriminator getDiscriminator() {
        return _discriminator;
    }

    @Override
    public void setDiscriminator(org.eclipse.microprofile.openapi.models.media.Discriminator discriminator) {
        _discriminator = discriminator;
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

    private Object _defaultValue;

    @Override
    public Object getDefaultValue() {
        return _defaultValue;
    }

    @Override
    public void setDefaultValue(Object defaultValue) {
        _defaultValue = defaultValue;
    }

    private java.util.List<Object> _enumeration;

    @Override
    public java.util.List<Object> getEnumeration() {
        if (_enumeration == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_enumeration);
    }

    @Override
    public void setEnumeration(java.util.List<Object> enumeration) {
        if (enumeration == null) {
            _enumeration = null;
        } else {
            _enumeration = new java.util.ArrayList<>();
            _enumeration.addAll(enumeration);
        }
    }

    @Override
    public Schema addEnumeration(Object object) {
        if (_enumeration == null) {
            _enumeration = new java.util.ArrayList<>();
        }
        _enumeration.add(object);
        return this;
    }

    @Override
    public void removeEnumeration(Object object) {
        if (_enumeration != null) {
            _enumeration.remove(object);
        }
    }

    private java.math.BigDecimal _multipleOf;

    @Override
    public java.math.BigDecimal getMultipleOf() {
        return _multipleOf;
    }

    @Override
    public void setMultipleOf(java.math.BigDecimal multipleOf) {
        _multipleOf = multipleOf;
    }

    private java.math.BigDecimal _maximum;

    @Override
    public java.math.BigDecimal getMaximum() {
        return _maximum;
    }

    @Override
    public void setMaximum(java.math.BigDecimal maximum) {
        _maximum = maximum;
    }

    private Boolean _exclusiveMaximum;

    @Override
    public Boolean getExclusiveMaximum() {
        return _exclusiveMaximum;
    }

    @Override
    public void setExclusiveMaximum(Boolean exclusiveMaximum) {
        _exclusiveMaximum = exclusiveMaximum;
    }

    private java.math.BigDecimal _minimum;

    @Override
    public java.math.BigDecimal getMinimum() {
        return _minimum;
    }

    @Override
    public void setMinimum(java.math.BigDecimal minimum) {
        _minimum = minimum;
    }

    private Boolean _exclusiveMinimum;

    @Override
    public Boolean getExclusiveMinimum() {
        return _exclusiveMinimum;
    }

    @Override
    public void setExclusiveMinimum(Boolean exclusiveMinimum) {
        _exclusiveMinimum = exclusiveMinimum;
    }

    private Integer _maxLength;

    @Override
    public Integer getMaxLength() {
        return _maxLength;
    }

    @Override
    public void setMaxLength(Integer maxLength) {
        _maxLength = maxLength;
    }

    private Integer _minLength;

    @Override
    public Integer getMinLength() {
        return _minLength;
    }

    @Override
    public void setMinLength(Integer minLength) {
        _minLength = minLength;
    }

    private String _pattern;

    @Override
    public String getPattern() {
        return _pattern;
    }

    @Override
    public void setPattern(String pattern) {
        _pattern = pattern;
    }

    private Integer _maxItems;

    @Override
    public Integer getMaxItems() {
        return _maxItems;
    }

    @Override
    public void setMaxItems(Integer maxItems) {
        _maxItems = maxItems;
    }

    private Integer _minItems;

    @Override
    public Integer getMinItems() {
        return _minItems;
    }

    @Override
    public void setMinItems(Integer minItems) {
        _minItems = minItems;
    }

    private Boolean _uniqueItems;

    @Override
    public Boolean getUniqueItems() {
        return _uniqueItems;
    }

    @Override
    public void setUniqueItems(Boolean uniqueItems) {
        _uniqueItems = uniqueItems;
    }

    private Integer _maxProperties;

    @Override
    public Integer getMaxProperties() {
        return _maxProperties;
    }

    @Override
    public void setMaxProperties(Integer maxProperties) {
        _maxProperties = maxProperties;
    }

    private Integer _minProperties;

    @Override
    public Integer getMinProperties() {
        return _minProperties;
    }

    @Override
    public void setMinProperties(Integer minProperties) {
        _minProperties = minProperties;
    }

    private java.util.List<String> _required;

    @Override
    public java.util.List<String> getRequired() {
        if (_required == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_required);
    }

    @Override
    public void setRequired(java.util.List<String> required) {
        if (required == null) {
            _required = null;
        } else {
            _required = new java.util.ArrayList<>();
            _required.addAll(required);
        }
    }

    @Override
    public Schema addRequired(String string) {
        if (_required == null) {
            _required = new java.util.ArrayList<>();
        }
        _required.add(string);
        return this;
    }

    @Override
    public void removeRequired(String string) {
        if (_required != null) {
            _required.remove(string);
        }
    }

    private org.eclipse.microprofile.openapi.models.media.Schema.SchemaType _type;

    @Override
    public org.eclipse.microprofile.openapi.models.media.Schema.SchemaType getType() {
        return _type;
    }

    @Override
    public void setType(org.eclipse.microprofile.openapi.models.media.Schema.SchemaType type) {
        _type = type;
    }

    private org.eclipse.microprofile.openapi.models.media.Schema _not;

    @Override
    public org.eclipse.microprofile.openapi.models.media.Schema getNot() {
        return _not;
    }

    @Override
    public void setNot(org.eclipse.microprofile.openapi.models.media.Schema not) {
        _not = not;
    }

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.media.Schema> _properties;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.media.Schema> getProperties() {
        if (_properties == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_properties);
    }

    @Override
    public void setProperties(java.util.Map<String, org.eclipse.microprofile.openapi.models.media.Schema> properties) {
        if (properties == null) {
            _properties = null;
        } else {
            _properties = new java.util.LinkedHashMap<>();
            _properties.putAll(properties);
        }
    }

    @Override
    public Schema addProperty(String key, org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (schema == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_properties == null) {
                _properties = new java.util.LinkedHashMap<>();
            }
            _properties.put(key, schema);
        }
        return this;
    }

    @Override
    public void removeProperty(String key) {
        if (_properties != null) {
            _properties.remove(key);
        }
    }

    private org.eclipse.microprofile.openapi.models.media.Schema _additionalPropertiesSchema;

    @Override
    public org.eclipse.microprofile.openapi.models.media.Schema getAdditionalPropertiesSchema() {
        return _additionalPropertiesSchema;
    }

    @Override
    public void setAdditionalPropertiesBoolean(Boolean additionalProperties) {
        _additionalPropertiesSchema = null;
        _additionalPropertiesBoolean = additionalProperties;
    }

    private Boolean _additionalPropertiesBoolean;

    @Override
    public Boolean getAdditionalPropertiesBoolean() {
        return _additionalPropertiesBoolean;
    }

    @Override
    public void setAdditionalPropertiesSchema(Schema additionalProperties) {
        _additionalPropertiesBoolean = null;
        _additionalPropertiesSchema = additionalProperties;
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

    private String _format;

    @Override
    public String getFormat() {
        return _format;
    }

    @Override
    public void setFormat(String format) {
        _format = format;
    }

    private Boolean _nullable;

    @Override
    public Boolean getNullable() {
        return _nullable;
    }

    @Override
    public void setNullable(Boolean nullable) {
        _nullable = nullable;
    }

    private Boolean _readOnly;

    @Override
    public Boolean getReadOnly() {
        return _readOnly;
    }

    @Override
    public void setReadOnly(Boolean readOnly) {
        _readOnly = readOnly;
    }

    private Boolean _writeOnly;

    @Override
    public Boolean getWriteOnly() {
        return _writeOnly;
    }

    @Override
    public void setWriteOnly(Boolean writeOnly) {
        _writeOnly = writeOnly;
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

    private org.eclipse.microprofile.openapi.models.ExternalDocumentation _externalDocs;

    @Override
    public org.eclipse.microprofile.openapi.models.ExternalDocumentation getExternalDocs() {
        return _externalDocs;
    }

    @Override
    public void setExternalDocs(org.eclipse.microprofile.openapi.models.ExternalDocumentation externalDocs) {
        _externalDocs = externalDocs;
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

    private org.eclipse.microprofile.openapi.models.media.XML _xml;

    @Override
    public org.eclipse.microprofile.openapi.models.media.XML getXml() {
        return _xml;
    }

    @Override
    public void setXml(org.eclipse.microprofile.openapi.models.media.XML xml) {
        _xml = xml;
    }

    private org.eclipse.microprofile.openapi.models.media.Schema _items;

    @Override
    public org.eclipse.microprofile.openapi.models.media.Schema getItems() {
        return _items;
    }

    @Override
    public void setItems(org.eclipse.microprofile.openapi.models.media.Schema items) {
        _items = items;
    }

    private java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> _allOf;

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> getAllOf() {
        if (_allOf == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_allOf);
    }

    @Override
    public void setAllOf(java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> allOf) {
        if (allOf == null) {
            _allOf = null;
        } else {
            _allOf = new java.util.ArrayList<>();
            _allOf.addAll(allOf);
        }
    }

    @Override
    public Schema addAllOf(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (_allOf == null) {
            _allOf = new java.util.ArrayList<>();
        }
        _allOf.add(schema);
        return this;
    }

    @Override
    public void removeAllOf(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (_allOf != null) {
            _allOf.remove(schema);
        }
    }

    private java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> _anyOf;

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> getAnyOf() {
        if (_anyOf == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_anyOf);
    }

    @Override
    public void setAnyOf(java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> anyOf) {
        if (anyOf == null) {
            _anyOf = null;
        } else {
            _anyOf = new java.util.ArrayList<>();
            _anyOf.addAll(anyOf);
        }
    }

    @Override
    public Schema addAnyOf(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (_anyOf == null) {
            _anyOf = new java.util.ArrayList<>();
        }
        _anyOf.add(schema);
        return this;
    }

    @Override
    public void removeAnyOf(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (_anyOf != null) {
            _anyOf.remove(schema);
        }
    }

    private java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> _oneOf;

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> getOneOf() {
        if (_oneOf == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_oneOf);
    }

    @Override
    public void setOneOf(java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> oneOf) {
        if (oneOf == null) {
            _oneOf = null;
        } else {
            _oneOf = new java.util.ArrayList<>();
            _oneOf.addAll(oneOf);
        }
    }

    @Override
    public Schema addOneOf(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (_oneOf == null) {
            _oneOf = new java.util.ArrayList<>();
        }
        _oneOf.add(schema);
        return this;
    }

    @Override
    public void removeOneOf(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (_oneOf != null) {
            _oneOf.remove(schema);
        }
    }

}
