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

public class SwListMember extends SwMember {

    public final String itemFqType;
    public final String addName;

    public SwListMember(MemberType type, String name, String itemFqType) {
        this(type, name, itemFqType, "add" + StringUtil.capitalize(name) + "Item");
    }

    public SwListMember(MemberType type, String name, String itemFqType, String addName) {
        this(type, name, itemFqType, "set" + StringUtil.capitalize(name), "get" + StringUtil.capitalize(name), StringUtil.decapitalize(name), addName, true);
    }

    public SwListMember(MemberType type, String name, String itemFqType, String setterName, String gettterName, String builderName, String addName, boolean hasBuilder) {
        super(type, name, "java.util.List<" + itemFqType + ">", setterName, gettterName, builderName, true, true, true, hasBuilder);
        this.itemFqType = itemFqType;
        this.addName = addName;
    }

}
