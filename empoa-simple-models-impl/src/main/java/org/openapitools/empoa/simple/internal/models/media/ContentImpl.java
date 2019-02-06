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

import org.eclipse.microprofile.openapi.models.media.Content;

public class ContentImpl implements Content {

    private java.util.Map<String, org.eclipse.microprofile.openapi.models.media.MediaType> _mediaTypes;

    @Override
    public java.util.Map<String, org.eclipse.microprofile.openapi.models.media.MediaType> getMediaTypes() {
        if (_mediaTypes == null) {
            return null;
        }
        return java.util.Collections.unmodifiableMap(_mediaTypes);
    }

    @Override
    public void setMediaTypes(java.util.Map<String, org.eclipse.microprofile.openapi.models.media.MediaType> mediaTypes) {
        if (mediaTypes == null) {
            _mediaTypes = null;
        } else {
            _mediaTypes = new java.util.LinkedHashMap<>();
            _mediaTypes.putAll(mediaTypes);
        }
    }

    @Override
    public Content addMediaType(String key, org.eclipse.microprofile.openapi.models.media.MediaType mediaType) {
        if (mediaType == null) {
            throw new IllegalArgumentException("Null value for key '" + key + "' is not allowed");
        } else {
            if (_mediaTypes == null) {
                _mediaTypes = new java.util.LinkedHashMap<>();
            }
            _mediaTypes.put(key, mediaType);
        }
        return this;
    }

    @Override
    public void removeMediaType(String key) {
        if (_mediaTypes != null) {
            _mediaTypes.remove(key);
        }
    }

}
