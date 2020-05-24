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
package org.openapitools.empoa.generator.util;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openapitools.empoa.generator.Input;
import org.openapitools.empoa.specs.Element;
import org.openapitools.empoa.specs.IMember;
import org.openapitools.empoa.specs.MapMember;
import org.openapitools.empoa.specs.OpenAPISpec;

public class SortMapsGeneratorMain {

    public static void main(String[] args) throws Exception {
        Map<Element, List<MapMember>> map = new HashMap<>();
        for (Element e : OpenAPISpec.elements()) {
            for (IMember m : e.members) {
                if (m instanceof MapMember) {
                    MapMember member = (MapMember) m;
                    List<MapMember> l = map.computeIfAbsent(e, k -> new ArrayList<>());
                    l.add(member);
                }
            }
            if (e.extensible) {
                List<MapMember> l = map.computeIfAbsent(e, k -> new ArrayList<>());
                MapMember member = new MapMember(null, "Extensions", "java.util.Object");
                l.add(member);
            }
        }
        Input input1 = new Input(Paths.get("../empoa-util/src/main/java"), "org.openapitools.empoa.util");
        SortMapsGenerator generator1 = new SortMapsGenerator(map, input1);
        generator1.writeFile();
        Input input2 = new Input(Paths.get("../empoa-util/src/main/java"), "org.openapitools.empoa.util");
        SortMapsConfigGenerator generator2 = new SortMapsConfigGenerator(map, input2);
        generator2.writeFile();
    }
}
