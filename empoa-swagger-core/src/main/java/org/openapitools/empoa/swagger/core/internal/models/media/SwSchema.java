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

import org.eclipse.microprofile.openapi.models.media.Schema;

public class SwSchema implements Schema {

    private io.swagger.v3.oas.models.media.Schema _swSchema;

    public SwSchema() {
        _swSchema = new io.swagger.v3.oas.models.media.Schema();
    }

    public SwSchema(io.swagger.v3.oas.models.media.Schema _swSchema) {
        this._swSchema = _swSchema;
    }

    private static io.swagger.v3.oas.models.media.ComposedSchema transformToComposedSchema(io.swagger.v3.oas.models.media.Schema schema) {
        io.swagger.v3.oas.models.media.ComposedSchema result = new io.swagger.v3.oas.models.media.ComposedSchema();
        result.set$ref(schema.get$ref());
        result.setAdditionalProperties(schema.getAdditionalProperties());
        result.setDefault(schema.getDefault());
        result.setDeprecated(schema.getDeprecated());
        result.setDescription(schema.getDescription());
        result.setDiscriminator(schema.getDiscriminator());
        result.setEnum(schema.getEnum());
        result.setExample(schema.getExample());
        result.setExclusiveMaximum(schema.getExclusiveMaximum());
        result.setExclusiveMinimum(schema.getExclusiveMinimum());
        result.setExtensions(schema.getExtensions());
        result.setExternalDocs(schema.getExternalDocs());
        result.setFormat(schema.getFormat());
        result.setMaximum(schema.getMaximum());
        result.setMaxItems(schema.getMaxItems());
        result.setMaxLength(schema.getMaxLength());
        result.setMaxProperties(schema.getMaxProperties());
        result.setMinimum(schema.getMinimum());
        result.setMinItems(schema.getMinItems());
        result.setMinLength(schema.getMinLength());
        result.setMinProperties(schema.getMinProperties());
        result.setMultipleOf(schema.getMultipleOf());
        result.setName(schema.getName());
        result.setNot(schema.getNot());
        result.setNullable(schema.getNullable());
        result.setPattern(schema.getPattern());
        result.setProperties(schema.getProperties());
        result.setReadOnly(schema.getReadOnly());
        result.setRequired(schema.getRequired());
        result.setTitle(schema.getTitle());
        result.setType(schema.getType());
        result.setUniqueItems(schema.getUniqueItems());
        result.setWriteOnly(schema.getWriteOnly());
        result.setXml(schema.getXml());
        return result;
    }

    private static io.swagger.v3.oas.models.media.ArraySchema transformToArraySchema(io.swagger.v3.oas.models.media.Schema schema) {
        io.swagger.v3.oas.models.media.ArraySchema result = new io.swagger.v3.oas.models.media.ArraySchema();
        result.set$ref(schema.get$ref());
        result.setAdditionalProperties(schema.getAdditionalProperties());
        result.setDefault(schema.getDefault());
        result.setDeprecated(schema.getDeprecated());
        result.setDescription(schema.getDescription());
        result.setDiscriminator(schema.getDiscriminator());
        result.setEnum(schema.getEnum());
        result.setExample(schema.getExample());
        result.setExclusiveMaximum(schema.getExclusiveMaximum());
        result.setExclusiveMinimum(schema.getExclusiveMinimum());
        result.setExtensions(schema.getExtensions());
        result.setExternalDocs(schema.getExternalDocs());
        result.setFormat(schema.getFormat());
        result.setMaximum(schema.getMaximum());
        result.setMaxItems(schema.getMaxItems());
        result.setMaxLength(schema.getMaxLength());
        result.setMaxProperties(schema.getMaxProperties());
        result.setMinimum(schema.getMinimum());
        result.setMinItems(schema.getMinItems());
        result.setMinLength(schema.getMinLength());
        result.setMinProperties(schema.getMinProperties());
        result.setMultipleOf(schema.getMultipleOf());
        result.setName(schema.getName());
        result.setNot(schema.getNot());
        result.setNullable(schema.getNullable());
        result.setPattern(schema.getPattern());
        result.setProperties(schema.getProperties());
        result.setReadOnly(schema.getReadOnly());
        result.setRequired(schema.getRequired());
        result.setTitle(schema.getTitle());
        result.setType(schema.getType());
        result.setUniqueItems(schema.getUniqueItems());
        result.setWriteOnly(schema.getWriteOnly());
        result.setXml(schema.getXml());
        return result;
    }

    public io.swagger.v3.oas.models.media.Schema getSw() {
        return _swSchema;
    }

    @Override
    public String getRef() {
        return _swSchema.get$ref();
    }

    @Override
    public void setRef(String ref) {
        _swSchema.set$ref(ref);
    }

    @Override
    public java.util.Map<String, Object> getExtensions() {
        java.util.Map<String, Object> result = _swSchema.getExtensions();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(result);
    }

    @Override
    public void setExtensions(java.util.Map<String, Object> extensions) {
        _swSchema.setExtensions(null);
        if (extensions != null) {
            if (extensions.isEmpty()) {
                _swSchema.setExtensions(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, Object> e : extensions.entrySet()) {
                    this.addExtension(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Schema addExtension(String key, Object object) {
        _swSchema.addExtension(key, object);
        return this;
    }

    @Override
    public void removeExtension(String key) {
        if (getExtensions() != null) {
            _swSchema.getExtensions()
                .remove(key);
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.media.SwDiscriminator _discriminator;

    private void initDiscriminator() {
        if (_swSchema.getDiscriminator() == null) {
            _discriminator = null;
        } else if (_discriminator == null) {
            _discriminator = new org.openapitools.empoa.swagger.core.internal.models.media.SwDiscriminator(_swSchema.getDiscriminator());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.media.Discriminator getDiscriminator() {
        initDiscriminator();
        return _discriminator;
    }

    @Override
    public void setDiscriminator(org.eclipse.microprofile.openapi.models.media.Discriminator discriminator) {
        if (discriminator != null) {
            if (!(discriminator instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwDiscriminator)) {
                throw new IllegalArgumentException("Unexpected type: " + discriminator);
            }
            _discriminator = (org.openapitools.empoa.swagger.core.internal.models.media.SwDiscriminator) discriminator;
            _swSchema.setDiscriminator(_discriminator.getSw());
        } else {
            _discriminator = null;
            _swSchema.setDiscriminator(null);
        }
    }

    @Override
    public String getTitle() {
        return _swSchema.getTitle();
    }

    @Override
    public void setTitle(String title) {
        _swSchema.setTitle(title);
    }

    @Override
    public Object getDefaultValue() {
        return _swSchema.getDefault();
    }

    @Override
    public void setDefaultValue(Object defaultValue) {
        _swSchema.setDefault(defaultValue);
    }

    @Override
    public java.util.List<Object> getEnumeration() {
        java.util.List<Object> result = _swSchema.getEnum();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(result);
    }

    @Override
    public void setEnumeration(java.util.List<Object> enumeration) {
        _swSchema.setEnum(null);
        if (enumeration != null) {
            if (enumeration.isEmpty()) {
                _swSchema.setEnum(new java.util.ArrayList<>());
            } else {
                for (Object e : enumeration) {
                    this.addEnumeration(e);
                }
            }
        }
    }

    @Override
    public Schema addEnumeration(Object object) {
        _swSchema.addEnumItemObject(object);
        return this;
    }

    @Override
    public void removeEnumeration(Object object) {
        if (_swSchema.getEnum() != null) {
            _swSchema.getEnum()
                .remove(object);
        }
    }

    @Override
    public java.math.BigDecimal getMultipleOf() {
        return _swSchema.getMultipleOf();
    }

    @Override
    public void setMultipleOf(java.math.BigDecimal multipleOf) {
        _swSchema.setMultipleOf(multipleOf);
    }

    @Override
    public java.math.BigDecimal getMaximum() {
        return _swSchema.getMaximum();
    }

    @Override
    public void setMaximum(java.math.BigDecimal maximum) {
        _swSchema.setMaximum(maximum);
    }

    @Override
    public Boolean getExclusiveMaximum() {
        return _swSchema.getExclusiveMaximum();
    }

    @Override
    public void setExclusiveMaximum(Boolean exclusiveMaximum) {
        _swSchema.setExclusiveMaximum(exclusiveMaximum);
    }

    @Override
    public java.math.BigDecimal getMinimum() {
        return _swSchema.getMinimum();
    }

    @Override
    public void setMinimum(java.math.BigDecimal minimum) {
        _swSchema.setMinimum(minimum);
    }

    @Override
    public Boolean getExclusiveMinimum() {
        return _swSchema.getExclusiveMinimum();
    }

    @Override
    public void setExclusiveMinimum(Boolean exclusiveMinimum) {
        _swSchema.setExclusiveMinimum(exclusiveMinimum);
    }

    @Override
    public Integer getMaxLength() {
        return _swSchema.getMaxLength();
    }

    @Override
    public void setMaxLength(Integer maxLength) {
        _swSchema.setMaxLength(maxLength);
    }

    @Override
    public Integer getMinLength() {
        return _swSchema.getMinLength();
    }

    @Override
    public void setMinLength(Integer minLength) {
        _swSchema.setMinLength(minLength);
    }

    @Override
    public String getPattern() {
        return _swSchema.getPattern();
    }

    @Override
    public void setPattern(String pattern) {
        _swSchema.setPattern(pattern);
    }

    @Override
    public Integer getMaxItems() {
        return _swSchema.getMaxItems();
    }

    @Override
    public void setMaxItems(Integer maxItems) {
        _swSchema.setMaxItems(maxItems);
    }

    @Override
    public Integer getMinItems() {
        return _swSchema.getMinItems();
    }

    @Override
    public void setMinItems(Integer minItems) {
        _swSchema.setMinItems(minItems);
    }

    @Override
    public Boolean getUniqueItems() {
        return _swSchema.getUniqueItems();
    }

    @Override
    public void setUniqueItems(Boolean uniqueItems) {
        _swSchema.setUniqueItems(uniqueItems);
    }

    @Override
    public Integer getMaxProperties() {
        return _swSchema.getMaxProperties();
    }

    @Override
    public void setMaxProperties(Integer maxProperties) {
        _swSchema.setMaxProperties(maxProperties);
    }

    @Override
    public Integer getMinProperties() {
        return _swSchema.getMinProperties();
    }

    @Override
    public void setMinProperties(Integer minProperties) {
        _swSchema.setMinProperties(minProperties);
    }

    @Override
    public java.util.List<String> getRequired() {
        java.util.List<String> result = _swSchema.getRequired();
        if (result == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(result);
    }

    @Override
    public void setRequired(java.util.List<String> required) {
        _swSchema.required(null);
        if (required != null) {
            if (required.isEmpty()) {
                _swSchema.required(new java.util.ArrayList<>());
            } else {
                for (String e : required) {
                    this.addRequired(e);
                }
            }
        }
    }

    @Override
    public Schema addRequired(String string) {
        _swSchema.addRequiredItem(string);
        return this;
    }

    @Override
    public void removeRequired(String string) {
        if (_swSchema.getRequired() != null) {
            _swSchema.getRequired()
                .remove(string);
        }
    }

    @Override
    public SchemaType getType() {
        if (_swSchema.getType() == null) {
            return null;
        }
        switch (_swSchema.getType()
            .toLowerCase()) {
        case "array":
            return org.eclipse.microprofile.openapi.models.media.Schema.SchemaType.ARRAY;
        case "boolean":
            return org.eclipse.microprofile.openapi.models.media.Schema.SchemaType.BOOLEAN;
        case "integer":
            return org.eclipse.microprofile.openapi.models.media.Schema.SchemaType.INTEGER;
        case "number":
            return org.eclipse.microprofile.openapi.models.media.Schema.SchemaType.NUMBER;
        case "object":
            return org.eclipse.microprofile.openapi.models.media.Schema.SchemaType.OBJECT;
        case "string":
            return org.eclipse.microprofile.openapi.models.media.Schema.SchemaType.STRING;
        default:
            throw new IllegalStateException("Unexpected enum value: " + _swSchema.getType());
        }
    }

    @Override
    public void setType(SchemaType type) {
        if (type == null) {
            _swSchema.setType(null);
        } else {
            _swSchema.setType(type.toString());
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.media.SwSchema _not;

    private void initNot() {
        if (_swSchema.getNot() == null) {
            _not = null;
        } else if (_not == null) {
            _not = new org.openapitools.empoa.swagger.core.internal.models.media.SwSchema(_swSchema.getNot());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.media.Schema getNot() {
        initNot();
        return _not;
    }

    @Override
    public void setNot(org.eclipse.microprofile.openapi.models.media.Schema not) {
        if (not != null) {
            if (!(not instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwSchema)) {
                throw new IllegalArgumentException("Unexpected type: " + not);
            }
            _not = (org.openapitools.empoa.swagger.core.internal.models.media.SwSchema) not;
            _swSchema.setNot(_not.getSw());
        } else {
            _not = null;
            _swSchema.setNot(null);
        }
    }

    private java.util.Map<String, org.openapitools.empoa.swagger.core.internal.models.media.SwSchema> _properties;

    private void initProperties() {
        if (_swSchema.getProperties() == null) {
            _properties = null;
        } else if (_properties == null) {
            _properties = ((java.util.Map<String, io.swagger.v3.oas.models.media.Schema>) _swSchema.getProperties())
                .entrySet()
                .stream()
                .collect(
                    java.util.stream.Collectors.toMap(
                        java.util.Map.Entry::getKey,
                        e -> new org.openapitools.empoa.swagger.core.internal.models.media.SwSchema(e.getValue()),
                        (k1, k2) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", k1));
                        },
                        () -> new java.util.LinkedHashMap<String, org.openapitools.empoa.swagger.core.internal.models.media.SwSchema>()
                    )
                );
        }
    }

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.media.Schema> getProperties() {
        initProperties();
        if (_properties == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_properties);
    }

    @Override
    public void setProperties(java.util.Map<String, org.eclipse.microprofile.openapi.models.media.Schema> properties) {
        _swSchema.setProperties(null);
        if (properties != null) {
            if (properties.isEmpty()) {
                _swSchema.setProperties(new java.util.LinkedHashMap<>());
            } else {
                for (java.util.Map.Entry<String, org.eclipse.microprofile.openapi.models.media.Schema> e : properties.entrySet()) {
                    this.addProperty(e.getKey(), e.getValue());
                }
            }
        }
    }

    @Override
    public Schema addProperty(String key, org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (!(schema instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwSchema)) {
            throw new IllegalArgumentException("Unexpected type: " + schema);
        }
        org.openapitools.empoa.swagger.core.internal.models.media.SwSchema value = (org.openapitools.empoa.swagger.core.internal.models.media.SwSchema) schema;
        initProperties();
        if (_properties == null) {
            _properties = new java.util.LinkedHashMap<>();
            _swSchema.setProperties(new java.util.LinkedHashMap<>());
        }
        _properties.put(key, value);
        _swSchema.getProperties()
            .put(key, value.getSw());
        return this;
    }

    @Override
    public void removeProperty(String key) {
        initProperties();
        if (_properties != null) {
            _properties.remove(key);
            _swSchema.getProperties()
                .remove(key);
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.media.SwSchema _additionalPropertiesSchema;

    private void initAdditionalPropertiesSchema() {
        if (_additionalPropertiesSchema == null) {
            if (_swSchema.getAdditionalProperties() instanceof io.swagger.v3.oas.models.media.Schema) {
                _additionalPropertiesSchema = new org.openapitools.empoa.swagger.core.internal.models.media.SwSchema((io.swagger.v3.oas.models.media.Schema) _swSchema.getAdditionalProperties());
            } else {
                _additionalPropertiesSchema = null;
            }
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.media.Schema getAdditionalPropertiesSchema() {
        initAdditionalPropertiesSchema();
        return _additionalPropertiesSchema;
    }

    @Override
    public void setAdditionalPropertiesBoolean(Boolean additionalProperties) {
        _additionalPropertiesSchema = null;
        _swSchema.setAdditionalProperties(additionalProperties);
    }

    @Override
    public Boolean getAdditionalPropertiesBoolean() {
        if (_swSchema.getAdditionalProperties() instanceof Boolean) {
            return (Boolean) _swSchema.getAdditionalProperties();
        }
        return null;
    }

    @Override
    public void setAdditionalPropertiesSchema(Schema additionalProperties) {
        if (additionalProperties != null) {
            if (!(additionalProperties instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwSchema)) {
                throw new IllegalArgumentException("Unexpected type: " + additionalProperties);
            }
            _additionalPropertiesSchema = (org.openapitools.empoa.swagger.core.internal.models.media.SwSchema) additionalProperties;
            _swSchema.setAdditionalProperties(_additionalPropertiesSchema.getSw());
        } else {
            _additionalPropertiesSchema = null;
            _swSchema.setAdditionalProperties(null);
        }
    }

    @Override
    public String getDescription() {
        return _swSchema.getDescription();
    }

    @Override
    public void setDescription(String description) {
        _swSchema.setDescription(description);
    }

    @Override
    public String getFormat() {
        return _swSchema.getFormat();
    }

    @Override
    public void setFormat(String format) {
        _swSchema.setFormat(format);
    }

    @Override
    public Boolean getNullable() {
        return _swSchema.getNullable();
    }

    @Override
    public void setNullable(Boolean nullable) {
        _swSchema.setNullable(nullable);
    }

    @Override
    public Boolean getReadOnly() {
        return _swSchema.getReadOnly();
    }

    @Override
    public void setReadOnly(Boolean readOnly) {
        _swSchema.setReadOnly(readOnly);
    }

    @Override
    public Boolean getWriteOnly() {
        return _swSchema.getWriteOnly();
    }

    @Override
    public void setWriteOnly(Boolean writeOnly) {
        _swSchema.setWriteOnly(writeOnly);
    }

    @Override
    public Object getExample() {
        return _swSchema.getExample();
    }

    @Override
    public void setExample(Object example) {
        _swSchema.setExample(example);
    }

    private org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation _externalDocs;

    private void initExternalDocs() {
        if (_swSchema.getExternalDocs() == null) {
            _externalDocs = null;
        } else if (_externalDocs == null) {
            _externalDocs = new org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation(_swSchema.getExternalDocs());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.ExternalDocumentation getExternalDocs() {
        initExternalDocs();
        return _externalDocs;
    }

    @Override
    public void setExternalDocs(org.eclipse.microprofile.openapi.models.ExternalDocumentation externalDocs) {
        if (externalDocs != null) {
            if (!(externalDocs instanceof org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation)) {
                throw new IllegalArgumentException("Unexpected type: " + externalDocs);
            }
            _externalDocs = (org.openapitools.empoa.swagger.core.internal.models.SwExternalDocumentation) externalDocs;
            _swSchema.setExternalDocs(_externalDocs.getSw());
        } else {
            _externalDocs = null;
            _swSchema.setExternalDocs(null);
        }
    }

    @Override
    public Boolean getDeprecated() {
        return _swSchema.getDeprecated();
    }

    @Override
    public void setDeprecated(Boolean deprecated) {
        _swSchema.setDeprecated(deprecated);
    }

    private org.openapitools.empoa.swagger.core.internal.models.media.SwXML _xml;

    private void initXml() {
        if (_swSchema.getXml() == null) {
            _xml = null;
        } else if (_xml == null) {
            _xml = new org.openapitools.empoa.swagger.core.internal.models.media.SwXML(_swSchema.getXml());
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.media.XML getXml() {
        initXml();
        return _xml;
    }

    @Override
    public void setXml(org.eclipse.microprofile.openapi.models.media.XML xml) {
        if (xml != null) {
            if (!(xml instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwXML)) {
                throw new IllegalArgumentException("Unexpected type: " + xml);
            }
            _xml = (org.openapitools.empoa.swagger.core.internal.models.media.SwXML) xml;
            _swSchema.setXml(_xml.getSw());
        } else {
            _xml = null;
            _swSchema.setXml(null);
        }
    }

    private org.openapitools.empoa.swagger.core.internal.models.media.SwSchema _items;

    private void initItems() {
        if (_items == null) {
            if (_swSchema instanceof io.swagger.v3.oas.models.media.ArraySchema && ((io.swagger.v3.oas.models.media.ArraySchema) _swSchema).getItems() != null) {
                _items = new org.openapitools.empoa.swagger.core.internal.models.media.SwSchema(((io.swagger.v3.oas.models.media.ArraySchema) _swSchema).getItems());
            } else {
                _items = null;
            }
        }
    }

    @Override
    public org.eclipse.microprofile.openapi.models.media.Schema getItems() {
        initItems();
        return _items;
    }

    @Override
    public void setItems(org.eclipse.microprofile.openapi.models.media.Schema items) {
        if (items != null) {
            if (!(items instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwSchema)) {
                throw new IllegalArgumentException("Unexpected type: " + items);
            }
            if (!(_swSchema instanceof io.swagger.v3.oas.models.media.ArraySchema)) {
                _swSchema = transformToArraySchema(_swSchema);
            }
            _items = (org.openapitools.empoa.swagger.core.internal.models.media.SwSchema) items;
            ((io.swagger.v3.oas.models.media.ArraySchema) _swSchema).setItems(_items.getSw());
        } else {
            _items = null;
            if (_swSchema instanceof io.swagger.v3.oas.models.media.ArraySchema) {
                ((io.swagger.v3.oas.models.media.ArraySchema) _swSchema).setItems(null);
            }
        }
    }

    private java.util.List<org.openapitools.empoa.swagger.core.internal.models.media.SwSchema> _allOf;

    private void initAllOf() {
        if (_allOf == null) {
            if (!(_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema) || ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).getAllOf() == null) {
                _allOf = null;
            } else if (_allOf == null) {
                _allOf = ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).getAllOf()
                    .stream()
                    .map(org.openapitools.empoa.swagger.core.internal.models.media.SwSchema::new)
                    .collect(java.util.stream.Collectors.toCollection(java.util.ArrayList::new));
            }
        }
    }

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> getAllOf() {
        initAllOf();
        if (_allOf == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_allOf);
    }

    @Override
    public void setAllOf(java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> allOf) {
        if (_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema) {
            ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).setAllOf(null);
        }
        _allOf = null;
        if (allOf != null) {
            if (allOf.isEmpty()) {
                if (!(_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema)) {
                    _swSchema = transformToComposedSchema(_swSchema);
                }
                ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).setAllOf(new java.util.ArrayList<>());
            } else {
                for (org.eclipse.microprofile.openapi.models.media.Schema e : allOf) {
                    this.addAllOf(e);
                }
            }
        }
    }

    @Override
    public Schema addAllOf(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (!(schema instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwSchema)) {
            throw new IllegalArgumentException("Unexpected type: " + schema);
        }
        org.openapitools.empoa.swagger.core.internal.models.media.SwSchema element = (org.openapitools.empoa.swagger.core.internal.models.media.SwSchema) schema;
        if (!(_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema)) {
            _swSchema = transformToComposedSchema(_swSchema);
        }
        initAllOf();
        if (_allOf == null) {
            _allOf = new java.util.ArrayList<>();
            ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).setAllOf(new java.util.ArrayList<>());
        }
        _allOf.add(element);
        ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).getAllOf()
            .add(element.getSw());
        return this;
    }

    @Override
    public void removeAllOf(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (!(schema instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwSchema)) {
            throw new IllegalArgumentException("Unexpected type: " + schema);
        }
        org.openapitools.empoa.swagger.core.internal.models.media.SwSchema element = (org.openapitools.empoa.swagger.core.internal.models.media.SwSchema) schema;
        if (!(_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema)) {
            _swSchema = transformToComposedSchema(_swSchema);
        }
        initAllOf();
        if (_allOf != null) {
            _allOf.remove(schema);
            ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).getAllOf()
                .remove(element.getSw());
        }
    }

    private java.util.List<org.openapitools.empoa.swagger.core.internal.models.media.SwSchema> _anyOf;

    private void initAnyOf() {
        if (_anyOf == null) {
            if (!(_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema) || ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).getAnyOf() == null) {
                _anyOf = null;
            } else {
                _anyOf = ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).getAnyOf()
                    .stream()
                    .map(org.openapitools.empoa.swagger.core.internal.models.media.SwSchema::new)
                    .collect(java.util.stream.Collectors.toCollection(java.util.ArrayList::new));
            }
        }
    }

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> getAnyOf() {
        initAnyOf();
        if (_anyOf == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_anyOf);
    }

    @Override
    public void setAnyOf(java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> anyOf) {
        if (_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema) {
            ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).setAnyOf(null);
        }
        _anyOf = null;
        if (anyOf != null) {
            if (anyOf.isEmpty()) {
                if (!(_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema)) {
                    _swSchema = transformToComposedSchema(_swSchema);
                }
                ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).setAnyOf(new java.util.ArrayList<>());
            } else {
                for (org.eclipse.microprofile.openapi.models.media.Schema e : anyOf) {
                    this.addAnyOf(e);
                }
            }
        }
    }

    @Override
    public Schema addAnyOf(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (!(schema instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwSchema)) {
            throw new IllegalArgumentException("Unexpected type: " + schema);
        }
        org.openapitools.empoa.swagger.core.internal.models.media.SwSchema element = (org.openapitools.empoa.swagger.core.internal.models.media.SwSchema) schema;
        if (!(_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema)) {
            _swSchema = transformToComposedSchema(_swSchema);
        }
        initAnyOf();
        if (_anyOf == null) {
            _anyOf = new java.util.ArrayList<>();
            ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).setAnyOf(new java.util.ArrayList<>());
        }
        _anyOf.add(element);
        ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).getAnyOf()
            .add(element.getSw());
        return this;
    }

    @Override
    public void removeAnyOf(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (!(schema instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwSchema)) {
            throw new IllegalArgumentException("Unexpected type: " + schema);
        }
        org.openapitools.empoa.swagger.core.internal.models.media.SwSchema element = (org.openapitools.empoa.swagger.core.internal.models.media.SwSchema) schema;
        if (!(_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema)) {
            _swSchema = transformToComposedSchema(_swSchema);
        }
        initAnyOf();
        if (_anyOf != null) {
            _anyOf.remove(schema);
            ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).getAnyOf()
                .remove(element.getSw());
        }
    }

    private java.util.List<org.openapitools.empoa.swagger.core.internal.models.media.SwSchema> _oneOf;

    private void initOneOf() {
        if (_oneOf == null) {
            if (!(_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema) || ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).getOneOf() == null) {
                _oneOf = null;
            } else if (_oneOf == null) {
                _oneOf = ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).getOneOf()
                    .stream()
                    .map(org.openapitools.empoa.swagger.core.internal.models.media.SwSchema::new)
                    .collect(java.util.stream.Collectors.toCollection(java.util.ArrayList::new));
            }
        }
    }

    @Override
    public java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> getOneOf() {
        initOneOf();
        if (_oneOf == null) {
            return null;
        }
        return java.util.Collections.unmodifiableList(_oneOf);
    }

    @Override
    public void setOneOf(java.util.List<org.eclipse.microprofile.openapi.models.media.Schema> oneOf) {
        if (_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema) {
            ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).setOneOf(null);
        }
        _oneOf = null;
        if (oneOf != null) {
            if (oneOf.isEmpty()) {
                if (!(_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema)) {
                    _swSchema = transformToComposedSchema(_swSchema);
                }
                ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).setOneOf(new java.util.ArrayList<>());
            } else {
                for (org.eclipse.microprofile.openapi.models.media.Schema e : oneOf) {
                    this.addOneOf(e);
                }
            }
        }
    }

    @Override
    public Schema addOneOf(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (!(schema instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwSchema)) {
            throw new IllegalArgumentException("Unexpected type: " + schema);
        }
        org.openapitools.empoa.swagger.core.internal.models.media.SwSchema element = (org.openapitools.empoa.swagger.core.internal.models.media.SwSchema) schema;
        if (!(_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema)) {
            _swSchema = transformToComposedSchema(_swSchema);
        }
        initOneOf();
        if (_oneOf == null) {
            _oneOf = new java.util.ArrayList<>();
            ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).setOneOf(new java.util.ArrayList<>());
        }
        _oneOf.add(element);
        ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).getOneOf()
            .add(element.getSw());
        return this;
    }

    @Override
    public void removeOneOf(org.eclipse.microprofile.openapi.models.media.Schema schema) {
        if (!(schema instanceof org.openapitools.empoa.swagger.core.internal.models.media.SwSchema)) {
            throw new IllegalArgumentException("Unexpected type: " + schema);
        }
        org.openapitools.empoa.swagger.core.internal.models.media.SwSchema element = (org.openapitools.empoa.swagger.core.internal.models.media.SwSchema) schema;
        if (!(_swSchema instanceof io.swagger.v3.oas.models.media.ComposedSchema)) {
            _swSchema = transformToComposedSchema(_swSchema);
        }
        initOneOf();
        if (_oneOf != null) {
            _oneOf.remove(schema);
            ((io.swagger.v3.oas.models.media.ComposedSchema) _swSchema).getOneOf()
                .remove(element.getSw());
        }
    }

}
