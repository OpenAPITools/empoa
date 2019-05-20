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
package org.openapitools.empoa.util;

public class StringUtil {

    public static String capitalize(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        return string.substring(0, 1)
            .toUpperCase() + string.substring(1);
    }

    public static String decapitalize(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        return string.substring(0, 1)
            .toLowerCase() + string.substring(1);
    }

    public static String computeSimpleName(final String fqName) {
        if (fqName == null) {
            return null;
        }
        int ltPosition = fqName.lastIndexOf("<");
        if (ltPosition > -1) {
            return computeSimpleName(fqName.substring(0, ltPosition));
        }
        int dotPosition = fqName.lastIndexOf(".");
        if (dotPosition > -1) {
            return fqName.substring(dotPosition + 1);
        }
        return fqName;
    }

    public static String computePackage(final String fqName) {
        if (fqName == null) {
            return null;
        }
        int position = fqName.lastIndexOf(".");
        if (position > -1) {
            return fqName.substring(0, position);
        }
        return fqName;
    }

    public static String singular(String name) {
        if (name.endsWith("ies")) {
            return name.substring(0, name.length() - 3) + "y";
        }
        if (name.endsWith("s")) {
            return name.substring(0, name.length() - 1);
        }
        return name;
    }

    public static String plural(String name) {
        if (name.endsWith("y")) {
            return name.substring(0, name.length() - 1) + "ies";
        }
        return name + "s";
    }

}
