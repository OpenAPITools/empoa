/*******************************************************************************
 * Copyright 2020 Jeremie Bresson
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
package org.openapitools.empoa.generator.util.merge;

import java.nio.file.Paths;

import org.openapitools.empoa.generator.Input;
import org.openapitools.empoa.specs.OpenAPISpec;

public class MergeGeneratorMain {

    public static void main(String[] args) throws Exception {
        Input input1 = new Input(Paths.get("../empoa-util/src/main/java"), "org.openapitools.empoa.util.merge");
        MergeGenerator generator1 = new MergeGenerator(OpenAPISpec.elements(), input1);
        generator1.writeFile();
        Input input2 = new Input(Paths.get("../empoa-util/src/test/java"), "org.openapitools.empoa.util.merge");
        MergeTestGenerator generator2 = new MergeTestGenerator(OpenAPISpec.elements(), input2);
        generator2.writeFile();
    }
}
