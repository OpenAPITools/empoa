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
package org.openapitools.empoa.extended.tck.models.servers;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.models.servers.ServerVariables;
import org.junit.jupiter.api.Test;

public class ServerVariablesTest {

    @Test
    public void testCreateServerVariables() {
        ServerVariables serverVariables = OASFactory.createServerVariables();
        assertThat(serverVariables).isNotNull();
    }

    @Test
    public void testSetServerVariables() {
        ServerVariables serverVariables = OASFactory.createServerVariables();

        serverVariables.setServerVariables(
            Collections.singletonMap(
                "name", OASFactory.createServerVariable()
            )
        );
        assertThat(serverVariables.getServerVariables()).containsOnlyKeys("name");

        serverVariables.setServerVariables(Collections.emptyMap());
        assertThat(serverVariables.getServerVariables()).isEmpty();
    }

}
