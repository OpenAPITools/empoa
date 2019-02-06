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
package org.openapitools.empoa.generator.swagger;

import java.nio.file.Paths;

import org.openapitools.empoa.generator.Input;
import org.openapitools.empoa.specs.swagger.SwElement;
import org.openapitools.empoa.specs.swagger.SwSpec;

public class SwGeneratorMain {

    public static void main(String[] args) throws Exception {
        Input input = new Input(Paths.get("../empoa-swagger-core/src/main/java"), "org.openapitools.empoa.swagger.core.internal");
        for (SwElement element : SwSpec.elements()) {
            SwGenerator generator = new SwGenerator(element, input);
            generator.writeFile();
        }
    }

}
