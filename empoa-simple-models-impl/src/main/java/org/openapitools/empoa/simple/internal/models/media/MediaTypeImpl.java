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

import org.eclipse.microprofile.openapi.models.media.MediaType;

public class MediaTypeImpl implements MediaType {

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
    public MediaType addExtension(String key, Object object) {
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
    public MediaType addExample(String key, org.eclipse.microprofile.openapi.models.examples.Example example) {
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

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.media.Encoding> _encoding;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.media.Encoding> getEncoding() {
        if (_encoding == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_encoding);
    }

    @Override
    public void setEncoding(java.util.Map<String, org.eclipse.microprofile.openapi.models.media.Encoding> encoding) {
        if (encoding == null) {
            _encoding = null;
        } else {
            _encoding = new java.util.LinkedHashMap<>();
            _encoding.putAll(encoding);
        }
    }

    @Override
    public MediaType addEncoding(String key, org.eclipse.microprofile.openapi.models.media.Encoding encoding) {
        if (encoding == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_encoding == null) {
                _encoding = new java.util.LinkedHashMap<>();
            }
            _encoding.put(key, encoding);
        }
        return this;
    }

    @Override
    public void removeEncoding(String key) {
        if (_encoding != null) {
            _encoding.remove(key);
        }
    }

}
