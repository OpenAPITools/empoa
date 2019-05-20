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
package org.openapitools.empoa.specs.swagger;

import org.openapitools.empoa.specs.MemberType;
import org.openapitools.empoa.util.StringUtil;

public class SwMapMember extends SwMember {

    public final String valueFqType;
    public final String addName;
    public final boolean hasAdd;
    public final boolean addReturnsVoid;
    public final String removeName;

    public SwMapMember(MemberType type, String name, String valueFqType) {
        this(type, name, valueFqType, true);
    }

    public SwMapMember(MemberType type, String name, String valueFqType, boolean hasBuilder) {
        this(type, name, valueFqType, hasBuilder, true);
    }

    public SwMapMember(MemberType type, String name, String valueFqType, boolean hasBuilder, boolean hasAdd) {
        this(type, name, valueFqType, hasBuilder, hasAdd, false);
    }

    public SwMapMember(MemberType type, String name, String valueFqType, boolean hasBuilder, boolean hasAdd, boolean addReturnsVoid) {
        this(
            type, name, valueFqType, "set" + StringUtil.capitalize(name), "get" + StringUtil.capitalize(name), StringUtil.decapitalize(name), "add" + StringUtil.capitalize(StringUtil.singular(name)), addReturnsVoid, hasAdd, hasBuilder,
            "remove" + StringUtil.capitalize(StringUtil.singular(name))
        );
    }

    public SwMapMember(MemberType type, String name, String valueFqType, String setterName, String gettterName, String builderName, String addName, boolean addReturnsVoid, boolean hasAdd, boolean hasBuilder, String removeName) {
        super(type, name, "java.util.Map<String, " + valueFqType + ">", setterName, gettterName, builderName, true, true, true, hasBuilder);
        this.valueFqType = valueFqType;
        this.addName = addName;
        this.hasAdd = hasAdd;
        this.addReturnsVoid = addReturnsVoid;
        this.removeName = removeName;
    }

}
