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
package org.openapitools.empoa.extended.tck.models.media;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.models.media.Schema;
import org.eclipse.microprofile.openapi.models.media.Schema.SchemaType;
import org.junit.jupiter.api.Test;

public class SchemaTest {

    @Test
    public void testCreateSchema() {
        Schema schema = OASFactory.createSchema();
        assertThat(schema).isNotNull();
    }

    @Test
    public void testRequired() {
        Schema schema = OASFactory.createObject(Schema.class);

        schema.setRequired(null);
        assertThat(schema.getRequired()).isNull();

        schema.setRequired(Collections.emptyList());
        assertThat(schema.getRequired()).isEmpty();

        schema.setRequired(Collections.singletonList("element"));
        assertThat(schema.getRequired()).containsExactly("element");

        schema.setRequired(Arrays.asList("lorem", "ipsum"));
        assertThat(schema.getRequired()).containsExactlyInAnyOrder("lorem", "ipsum");
    }

    @Test
    public void testSetItems() {
        Schema schema = OASFactory.createObject(Schema.class);

        schema.setItems(null);
        assertThat(schema.getItems()).isNull();

        Schema item1 = OASFactory.createObject(Schema.class)
            .type(SchemaType.STRING);
        schema.setItems(item1);
        assertThat(schema.getItems()).isNotNull();
        assertThat(
            schema.getItems()
                .getType()
        ).isEqualTo(SchemaType.STRING);

        Schema item2 = OASFactory.createObject(Schema.class)
            .type(SchemaType.NUMBER)
            .format("int32");
        schema.setItems(item2);
        assertThat(schema.getItems()).isNotNull();
        assertThat(
            schema.getItems()
                .getType()
        ).isEqualTo(SchemaType.NUMBER);
        assertThat(
            schema.getItems()
                .getFormat()
        ).isEqualTo("int32");

        schema.setItems(null);
        assertThat(schema.getItems()).isNull();
    }

    @Test
    public void testSetAllOf() {
        Schema schema = OASFactory.createObject(Schema.class);

        schema.setAllOf(null);
        assertThat(schema.getAllOf()).isNull();

        schema.setAllOf(Collections.emptyList());
        assertThat(schema.getAllOf()).isEmpty();

        Schema stringSchema = OASFactory.createObject(Schema.class)
            .type(SchemaType.STRING);
        Schema longSchema = OASFactory.createObject(Schema.class)
            .type(SchemaType.NUMBER)
            .format("int64");
        schema.setAllOf(Arrays.asList(stringSchema, longSchema));
        assertThat(schema.getAllOf()).containsExactly(stringSchema, longSchema);

        schema.setAllOf(null);
        assertThat(schema.getAllOf()).isNull();
    }

    @Test
    public void testAddAllOf() {
        Schema schema = OASFactory.createObject(Schema.class);

        assertThat(schema.getAllOf()).isNull();

        Schema stringSchema = OASFactory.createObject(Schema.class)
            .type(SchemaType.STRING);
        schema.addAllOf(stringSchema);
        assertThat(schema.getAllOf()).containsExactly(stringSchema);

        Schema intSchema = OASFactory.createObject(Schema.class)
            .type(SchemaType.NUMBER)
            .format("int32");
        schema.addAllOf(intSchema);
        assertThat(schema.getAllOf()).containsExactly(stringSchema, intSchema);
    }

    @Test
    public void testSetAnyOf() {
        Schema schema = OASFactory.createObject(Schema.class);

        schema.setAnyOf(null);
        assertThat(schema.getAnyOf()).isNull();

        schema.setAnyOf(Collections.emptyList());
        assertThat(schema.getAnyOf()).isEmpty();

        Schema stringSchema = OASFactory.createObject(Schema.class)
            .type(SchemaType.STRING);
        Schema longSchema = OASFactory.createObject(Schema.class)
            .type(SchemaType.NUMBER)
            .format("int64");
        schema.setAnyOf(Arrays.asList(stringSchema, longSchema));
        assertThat(schema.getAnyOf()).containsExactly(stringSchema, longSchema);

        schema.setAnyOf(null);
        assertThat(schema.getAnyOf()).isNull();
    }

    @Test
    public void testAddAnyOf() {
        Schema schema = OASFactory.createObject(Schema.class);

        assertThat(schema.getAnyOf()).isNull();

        Schema stringSchema = OASFactory.createObject(Schema.class)
            .type(SchemaType.STRING);
        schema.addAnyOf(stringSchema);
        assertThat(schema.getAnyOf()).containsExactly(stringSchema);

        Schema intSchema = OASFactory.createObject(Schema.class)
            .type(SchemaType.NUMBER)
            .format("int32");
        schema.addAnyOf(intSchema);
        assertThat(schema.getAnyOf()).containsExactly(stringSchema, intSchema);
    }

    @Test
    public void testSetOneOf() {
        Schema schema = OASFactory.createObject(Schema.class);

        schema.setOneOf(null);
        assertThat(schema.getOneOf()).isNull();

        schema.setOneOf(Collections.emptyList());
        assertThat(schema.getOneOf()).isEmpty();

        Schema stringSchema = OASFactory.createObject(Schema.class)
            .type(SchemaType.STRING);
        Schema longSchema = OASFactory.createObject(Schema.class)
            .type(SchemaType.NUMBER)
            .format("int64");
        schema.setOneOf(Arrays.asList(stringSchema, longSchema));
        assertThat(schema.getOneOf()).containsExactly(stringSchema, longSchema);

        schema.setOneOf(null);
        assertThat(schema.getOneOf()).isNull();
    }

    @Test
    public void testAddOneOf() {
        Schema schema = OASFactory.createObject(Schema.class);

        assertThat(schema.getOneOf()).isNull();

        Schema stringSchema = OASFactory.createObject(Schema.class)
            .type(SchemaType.STRING);
        schema.addOneOf(stringSchema);
        assertThat(schema.getOneOf()).containsExactly(stringSchema);

        Schema intSchema = OASFactory.createObject(Schema.class)
            .type(SchemaType.NUMBER)
            .format("int32");
        schema.addOneOf(intSchema);
        assertThat(schema.getOneOf()).containsExactly(stringSchema, intSchema);
    }
}
