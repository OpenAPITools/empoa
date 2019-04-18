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
package org.openapitools.empoa.specs;

import org.openapitools.empoa.util.StringUtil;

public class MapMember extends Member {

    public final String valueFqType;
    public final String addName;
    public final String removeName;
    public MapNullValueStrategy nullValueStrategy;

    public MapMember(MemberType type, String name, String valueFqType) {
        this(type, name, valueFqType, MapNullValueStrategy.THROW_EXCEPTION);
    }

    public MapMember(MemberType type, String name, String valueFqType, MapNullValueStrategy nullValueStrategy) {
        this(
            type, name, valueFqType, "set" + StringUtil.capitalize(name), "get" + StringUtil.capitalize(name), StringUtil.decapitalize(name), "add" + StringUtil.capitalize(StringUtil.singular(name)),
            "remove" + StringUtil.capitalize(StringUtil.singular(name)), nullValueStrategy
        );
    }

    public MapMember(MemberType type, String name, String valueFqType, String setterName, String gettterName, String builderName, String addName, String removeName, MapNullValueStrategy nullValueStrategy) {
        super(type, name, "java.util.Map<String, " + valueFqType + ">", setterName, gettterName, builderName, true, true, true, true);
        this.valueFqType = valueFqType;
        this.addName = addName;
        this.removeName = removeName;
        this.nullValueStrategy = nullValueStrategy;
    }

}
