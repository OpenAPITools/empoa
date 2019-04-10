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
package org.openapitools.empoa.extended.tck.models.responses;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.models.responses.APIResponses;
import org.junit.jupiter.api.Test;

public class APIResponsesTest {

    @Test
    public void testCreateAPIResponses() {
        APIResponses apiResponses = OASFactory.createAPIResponses();
        assertThat(apiResponses).isNotNull();
    }

    @Test
    public void testSetAPIResponses() {
        APIResponses apiResponses = OASFactory.createAPIResponses();

        apiResponses.setAPIResponses(
            Collections.singletonMap(
                "200", OASFactory.createAPIResponse()
                    .description("OK")
            )
        );
        assertThat(apiResponses.getAPIResponses()).containsOnlyKeys("200");

        apiResponses.setAPIResponses(Collections.emptyMap());
        assertThat(apiResponses.getAPIResponses()).isEmpty();
    }

    @Test
    public void testSetDefaultValue() {
        APIResponses apiResponses = OASFactory.createAPIResponses();

        apiResponses.setDefaultValue(
            OASFactory.createAPIResponse()
                .description("OK")
        );
        assertThat(apiResponses.getAPIResponses()).containsOnlyKeys(APIResponses.DEFAULT);

        apiResponses.setDefaultValue(null);
        assertThat(apiResponses.getAPIResponses()).isEmpty();
    }

}
