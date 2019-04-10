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
package org.openapitools.empoa.extended.tck.models.media;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.models.media.Content;
import org.junit.jupiter.api.Test;

public class ContentTest {

    @Test
    public void testCreateContent() {
        Content content = OASFactory.createContent();
        assertThat(content).isNotNull();
    }

    @Test
    public void testSetMediaTypes() {
        Content content = OASFactory.createContent();

        content.setMediaTypes(
            Collections.singletonMap(
                "application/json", OASFactory.createMediaType()
            )
        );
        assertThat(content.getMediaTypes()).containsOnlyKeys("application/json");

        content.setMediaTypes(Collections.emptyMap());
        assertThat(content.getMediaTypes()).isEmpty();
    }

}
