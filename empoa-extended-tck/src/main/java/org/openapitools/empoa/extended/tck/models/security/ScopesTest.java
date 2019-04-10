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
package org.openapitools.empoa.extended.tck.models.security;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.models.security.Scopes;
import org.junit.jupiter.api.Test;

public class ScopesTest {

    @Test
    public void testCreateScopes() {
        Scopes scopes = OASFactory.createScopes();
        assertThat(scopes).isNotNull();
    }

    @Test
    public void testSetScopes() {
        Scopes scopes = OASFactory.createScopes();

        scopes.setScopes(
            Collections.singletonMap(
                "write:elements", "modify elements in your item"
            )
        );
        assertThat(scopes.getScopes()).containsOnlyKeys("write:elements");

        scopes.setScopes(Collections.emptyMap());
        assertThat(scopes.getScopes()).isEmpty();
    }

}
