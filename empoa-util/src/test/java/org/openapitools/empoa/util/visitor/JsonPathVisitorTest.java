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
package org.openapitools.empoa.util.visitor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.openapitools.empoa.extended.tck.AbstractSpecTest;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathVisitorTest extends AbstractSpecTest {

    @Override
    protected void runTest(Specs spec) throws Exception {
        JsonPathVisitor visitor = new JsonPathVisitor();
        OASAccept.accept(visitor, getOpenAPISpec(spec));
        assertThat(visitor.getJsonPaths()).containsExactlyInAnyOrderElementsOf(getExpectedJsonPaths(spec));

        String json = readJsonSpec(spec);
        DocumentContext context = JsonPath.parse(json);

        for (String jsonPath : visitor.getJsonPaths()) {
            Object result = context.read(jsonPath);
            assertThat(result)
                .as("jsonPath '" + jsonPath + "' result")
                .isNotNull();
        }
    }

    private List<String> getExpectedJsonPaths(Specs spec) {
        switch (spec) {
        case HELLO:
            return Arrays.asList(
                "$",
                "$.components",
                "$.components.schemas.['Error']",
                "$.components.schemas.['Error'].properties.['code']",
                "$.components.schemas.['Error'].properties.['message']",
                "$.components.schemas.['Hello']",
                "$.components.schemas.['Hello'].properties.['message']",
                "$.components.schemas.['Hello'].properties.['timestamp']",
                "$.info",
                "$.info.contact",
                "$.info.license",
                "$.paths",
                "$.paths.['/hello/{name}']",
                "$.paths.['/hello/{name}'].get",
                "$.paths.['/hello/{name}'].get.parameters[0]",
                "$.paths.['/hello/{name}'].get.parameters[0].schema",
                "$.paths.['/hello/{name}'].get.parameters[1]",
                "$.paths.['/hello/{name}'].get.parameters[1].schema",
                "$.paths.['/hello/{name}'].get.responses",
                "$.paths.['/hello/{name}'].get.responses.['200']",
                "$.paths.['/hello/{name}'].get.responses.['200'].content",
                "$.paths.['/hello/{name}'].get.responses.['200'].content.['application/json']",
                "$.paths.['/hello/{name}'].get.responses.['200'].content.['application/json'].schema",
                "$.paths.['/hello/{name}'].get.responses.['200'].content.['application/text']",
                "$.paths.['/hello/{name}'].get.responses.['200'].content.['application/text'].schema",
                "$.paths.['/hello/{name}'].get.responses.['200'].content.['application/xml']",
                "$.paths.['/hello/{name}'].get.responses.['200'].content.['application/xml'].schema",
                "$.paths.['/hello/{name}'].get.responses.['4XX']",
                "$.paths.['/hello/{name}'].get.responses.['4XX'].content",
                "$.paths.['/hello/{name}'].get.responses.['4XX'].content.['*/*']",
                "$.paths.['/hello/{name}'].get.responses.['4XX'].content.['*/*'].schema",
                "$.servers[0]",
                "$.servers[1]"
            );
        case MULTIPLE_RESPONSES:
            return Arrays.asList(
                "$",
                "$.components",
                "$.components.responses.['BusinessErrorResponse']",
                "$.components.responses.['BusinessErrorResponse'].content",
                "$.components.schemas.['Error']",
                "$.components.schemas.['Error'].properties.['code']",
                "$.components.schemas.['Error'].properties.['message']",
                "$.components.schemas.['PingObject']",
                "$.components.schemas.['PingObject'].properties.['id']",
                "$.components.schemas.['PingObject'].properties.['name']",
                "$.components.responses.['BusinessErrorResponse'].content.['*/*']",
                "$.components.responses.['BusinessErrorResponse'].content.['*/*'].schema",
                "$.info",
                "$.paths",
                "$.paths.['/ping']",
                "$.paths.['/ping'].get",
                "$.paths.['/ping'].get.responses",
                "$.paths.['/ping'].get.responses.['200']",
                "$.paths.['/ping'].get.responses.['200'].content",
                "$.paths.['/ping'].get.responses.['200'].content.['application/json']",
                "$.paths.['/ping'].get.responses.['200'].content.['application/json'].schema",
                "$.paths.['/ping'].get.responses.['4XX']",
                "$.paths.['/ping'].get.responses.['default']",
                "$.paths.['/ping'].get.responses.['default'].content",
                "$.paths.['/ping'].get.responses.['default'].content.['*/*']",
                "$.paths.['/ping'].get.responses.['default'].content.['*/*'].schema",
                "$.paths.['/ping'].post",
                "$.paths.['/ping'].post.responses",
                "$.paths.['/ping'].post.responses.['405']",
                "$.servers[0]"
            );
        case PING:
            return Arrays.asList(
                "$",
                "$.info",
                "$.servers[0]",
                "$.paths.['/ping']",
                "$.paths.['/ping'].get.responses",
                "$.paths",
                "$.paths.['/ping'].get",
                "$.paths.['/ping'].get.responses.['200']"
            );
        case TODOAPP:
            return Arrays.asList(
                "$",
                "$.components",
                "$.components.schemas.['Error']",
                "$.components.schemas.['Error'].properties.['code']",
                "$.components.schemas.['Error'].properties.['message']",
                "$.components.schemas.['Task']",
                "$.components.schemas.['Task'].properties.['completed']",
                "$.components.schemas.['Task'].properties.['description']",
                "$.components.schemas.['Task'].properties.['id']",
                "$.info",
                "$.info.license",
                "$.paths",
                "$.paths.['/task']",
                "$.paths.['/task'].get",
                "$.paths.['/task'].get.responses",
                "$.paths.['/task'].get.responses.['200']",
                "$.paths.['/task'].get.responses.['200'].content",
                "$.paths.['/task'].get.responses.['200'].content.['application/json']",
                "$.paths.['/task'].get.responses.['200'].content.['application/json'].schema.items",
                "$.paths.['/task'].get.responses.['200'].content.['application/json'].schema",
                "$.paths.['/task'].get.responses.['default']",
                "$.paths.['/task'].get.responses.['default'].content",
                "$.paths.['/task'].get.responses.['default'].content.['application/json']",
                "$.paths.['/task'].get.responses.['default'].content.['application/json'].schema",
                "$.paths.['/task'].post",
                "$.paths.['/task'].post.requestBody.content",
                "$.paths.['/task'].post.requestBody.content.['application/json']",
                "$.paths.['/task'].post.requestBody.content.['application/json'].schema",
                "$.paths.['/task'].post.requestBody",
                "$.paths.['/task'].post.responses",
                "$.paths.['/task'].post.responses.['200']",
                "$.paths.['/task'].post.responses.['200'].content",
                "$.paths.['/task'].post.responses.['200'].content.['application/json']",
                "$.paths.['/task'].post.responses.['200'].content.['application/json'].schema",
                "$.paths.['/task'].post.responses.['default']",
                "$.paths.['/task'].post.responses.['default'].content",
                "$.paths.['/task'].post.responses.['default'].content.['application/json']",
                "$.paths.['/task'].post.responses.['default'].content.['application/json'].schema",
                "$.paths.['/task/{taskId}']",
                "$.paths.['/task/{taskId}'].delete",
                "$.paths.['/task/{taskId}'].delete.responses",
                "$.paths.['/task/{taskId}'].delete.responses.['204']",
                "$.paths.['/task/{taskId}'].delete.responses.['default']",
                "$.paths.['/task/{taskId}'].delete.responses.['default'].content",
                "$.paths.['/task/{taskId}'].delete.responses.['default'].content.['application/json']",
                "$.paths.['/task/{taskId}'].delete.responses.['default'].content.['application/json'].schema",
                "$.paths.['/task/{taskId}'].get",
                "$.paths.['/task/{taskId}'].get.responses",
                "$.paths.['/task/{taskId}'].get.responses.['200']",
                "$.paths.['/task/{taskId}'].get.responses.['200'].content",
                "$.paths.['/task/{taskId}'].get.responses.['200'].content.['application/json']",
                "$.paths.['/task/{taskId}'].get.responses.['200'].content.['application/json'].schema",
                "$.paths.['/task/{taskId}'].get.responses.['default']",
                "$.paths.['/task/{taskId}'].get.responses.['default'].content",
                "$.paths.['/task/{taskId}'].get.responses.['default'].content.['application/json']",
                "$.paths.['/task/{taskId}'].get.responses.['default'].content.['application/json'].schema",
                "$.paths.['/task/{taskId}'].parameters[0].schema",
                "$.paths.['/task/{taskId}'].parameters[0]",
                "$.paths.['/task/{taskId}'].put",
                "$.paths.['/task/{taskId}'].put.requestBody.content",
                "$.paths.['/task/{taskId}'].put.requestBody.content.['application/json']",
                "$.paths.['/task/{taskId}'].put.requestBody.content.['application/json'].schema",
                "$.paths.['/task/{taskId}'].put.requestBody",
                "$.paths.['/task/{taskId}'].put.responses",
                "$.paths.['/task/{taskId}'].put.responses.['200']",
                "$.paths.['/task/{taskId}'].put.responses.['200'].content",
                "$.paths.['/task/{taskId}'].put.responses.['200'].content.['application/json']",
                "$.paths.['/task/{taskId}'].put.responses.['200'].content.['application/json'].schema",
                "$.paths.['/task/{taskId}'].put.responses.['default']",
                "$.paths.['/task/{taskId}'].put.responses.['default'].content",
                "$.paths.['/task/{taskId}'].put.responses.['default'].content.['application/json']",
                "$.paths.['/task/{taskId}'].put.responses.['default'].content.['application/json'].schema",
                "$.servers[0]",
                "$.tags[0]"
            );
        case BIG:
            return Arrays.asList(
                "$.components.callbacks.['PingCallback'].['{$request.body#/callbackUrl}'].get.parameters[0].schema",
                "$.components.callbacks.['PingCallback'].['{$request.body#/callbackUrl}'].get.parameters[0]",
                "$.components.callbacks.['PingCallback'].['{$request.body#/callbackUrl}'].get.responses.['200']",
                "$.components.callbacks.['PingCallback'].['{$request.body#/callbackUrl}'].get.responses",
                "$.components.callbacks.['PingCallback'].['{$request.body#/callbackUrl}'].get",
                "$.components.callbacks.['PingCallback'].['{$request.body#/callbackUrl}']",
                "$.components.callbacks.['PingCallback']",
                "$.components.parameters.['LanguageParam'].schema",
                "$.components.parameters.['LanguageParam']",
                "$.components.requestBodies.['UpdateBody'].content.['application/json'].schema.properties.['description']",
                "$.components.requestBodies.['UpdateBody'].content.['application/json'].schema.properties.['message']",
                "$.components.requestBodies.['UpdateBody'].content.['application/json'].schema",
                "$.components.requestBodies.['UpdateBody'].content.['application/json']",
                "$.components.requestBodies.['UpdateBody'].content",
                "$.components.requestBodies.['UpdateBody']",
                "$.components.responses.['MessageResponse'].content.['*/*'].schema",
                "$.components.responses.['MessageResponse'].content.['*/*']",
                "$.components.responses.['MessageResponse'].content",
                "$.components.responses.['MessageResponse']",
                "$.components.schemas.['Body'].properties.['callbackUrl']",
                "$.components.schemas.['Body'].properties.['items'].items",
                "$.components.schemas.['Body'].properties.['items']",
                "$.components.schemas.['Body']",
                "$.components.schemas.['ChildObject'].allOf[0]",
                "$.components.schemas.['ChildObject'].allOf[1].properties.['prop3']",
                "$.components.schemas.['ChildObject'].allOf[1].properties.['prop4']",
                "$.components.schemas.['ChildObject'].allOf[1]",
                "$.components.schemas.['ChildObject']",
                "$.components.schemas.['Error'].properties.['code']",
                "$.components.schemas.['Error'].properties.['message']",
                "$.components.schemas.['Error']",
                "$.components.schemas.['ExtendedInfo'].properties.['code']",
                "$.components.schemas.['ExtendedInfo'].properties.['data'].not",
                "$.components.schemas.['ExtendedInfo'].properties.['data']",
                "$.components.schemas.['ExtendedInfo'].properties.['info']",
                "$.components.schemas.['ExtendedInfo'].properties.['infoType']",
                "$.components.schemas.['ExtendedInfo']",
                "$.components.schemas.['Info'].discriminator",
                "$.components.schemas.['Info'].oneOf[0]",
                "$.components.schemas.['Info'].oneOf[1]",
                "$.components.schemas.['Info']",
                "$.components.schemas.['Message'].properties.['description']",
                "$.components.schemas.['Message'].properties.['value']",
                "$.components.schemas.['Message']",
                "$.components.schemas.['Node'].properties.['children'].items",
                "$.components.schemas.['Node'].properties.['children']",
                "$.components.schemas.['Node'].properties.['name']",
                "$.components.schemas.['Node']",
                "$.components.schemas.['ParentObject'].allOf[0]",
                "$.components.schemas.['ParentObject'].allOf[1].properties.['prop1']",
                "$.components.schemas.['ParentObject'].allOf[1].properties.['prop2']",
                "$.components.schemas.['ParentObject'].allOf[1]",
                "$.components.schemas.['ParentObject']",
                "$.components.schemas.['RootClass'].discriminator",
                "$.components.schemas.['RootClass'].properties.['prop0']",
                "$.components.schemas.['RootClass'].properties.['type']",
                "$.components.schemas.['RootClass']",
                "$.components.schemas.['SimpleInfo'].properties.['description']",
                "$.components.schemas.['SimpleInfo'].properties.['infoType']",
                "$.components.schemas.['SimpleInfo']",
                "$.components.securitySchemes.['api-key-auth']",
                "$.components.securitySchemes.['basic-auth']",
                "$.components",
                "$.info.contact",
                "$.info.license",
                "$.info",
                "$.paths.['/messages'].post.requestBody.content.['application/json'].schema.properties.['description']",
                "$.paths.['/messages'].post.requestBody.content.['application/json'].schema.properties.['id']",
                "$.paths.['/messages'].post.requestBody.content.['application/json'].schema.properties.['language']",
                "$.paths.['/messages'].post.requestBody.content.['application/json'].schema",
                "$.paths.['/messages'].post.requestBody.content.['application/json']",
                "$.paths.['/messages'].post.requestBody.content",
                "$.paths.['/messages'].post.requestBody",
                "$.paths.['/messages'].post.responses.['200']",
                "$.paths.['/messages'].post.responses",
                "$.paths.['/messages'].post",
                "$.paths.['/messages']",
                "$.paths.['/messages/{id}'].get.parameters[0]",
                "$.paths.['/messages/{id}'].get.responses.['200']",
                "$.paths.['/messages/{id}'].get.responses",
                "$.paths.['/messages/{id}'].get",
                "$.paths.['/messages/{id}'].parameters[0].schema",
                "$.paths.['/messages/{id}'].parameters[0]",
                "$.paths.['/messages/{id}'].put.parameters[0].schema",
                "$.paths.['/messages/{id}'].put.parameters[0]",
                "$.paths.['/messages/{id}'].put.requestBody",
                "$.paths.['/messages/{id}'].put.responses.['200']",
                "$.paths.['/messages/{id}'].put.responses",
                "$.paths.['/messages/{id}'].put",
                "$.paths.['/messages/{id}']",
                "$.paths.['/subscribe'].post.callbacks.['myEvent'].['{$request.body#/callbackUrl}'].post.requestBody.content.['application/json'].schema.properties.['message']",
                "$.paths.['/subscribe'].post.callbacks.['myEvent'].['{$request.body#/callbackUrl}'].post.requestBody.content.['application/json'].schema",
                "$.paths.['/subscribe'].post.callbacks.['myEvent'].['{$request.body#/callbackUrl}'].post.requestBody.content.['application/json']",
                "$.paths.['/subscribe'].post.callbacks.['myEvent'].['{$request.body#/callbackUrl}'].post.requestBody.content",
                "$.paths.['/subscribe'].post.callbacks.['myEvent'].['{$request.body#/callbackUrl}'].post.requestBody",
                "$.paths.['/subscribe'].post.callbacks.['myEvent'].['{$request.body#/callbackUrl}'].post.responses.['200']",
                "$.paths.['/subscribe'].post.callbacks.['myEvent'].['{$request.body#/callbackUrl}'].post.responses",
                "$.paths.['/subscribe'].post.callbacks.['myEvent'].['{$request.body#/callbackUrl}'].post",
                "$.paths.['/subscribe'].post.callbacks.['myEvent'].['{$request.body#/callbackUrl}']",
                "$.paths.['/subscribe'].post.callbacks.['myEvent']",
                "$.paths.['/subscribe'].post.callbacks.['pingEvent']",
                "$.paths.['/subscribe'].post.requestBody.content.['application/json'].schema",
                "$.paths.['/subscribe'].post.requestBody.content.['application/json']",
                "$.paths.['/subscribe'].post.requestBody.content",
                "$.paths.['/subscribe'].post.requestBody",
                "$.paths.['/subscribe'].post.responses.['201']",
                "$.paths.['/subscribe'].post.responses",
                "$.paths.['/subscribe'].post",
                "$.paths.['/subscribe']",
                "$.paths.['/tree/{name}'].get.parameters[0].schema",
                "$.paths.['/tree/{name}'].get.parameters[0]",
                "$.paths.['/tree/{name}'].get.responses.['200'].content.['application/json'].schema",
                "$.paths.['/tree/{name}'].get.responses.['200'].content.['application/json']",
                "$.paths.['/tree/{name}'].get.responses.['200'].content.['application/text'].schema",
                "$.paths.['/tree/{name}'].get.responses.['200'].content.['application/text']",
                "$.paths.['/tree/{name}'].get.responses.['200'].content",
                "$.paths.['/tree/{name}'].get.responses.['200']",
                "$.paths.['/tree/{name}'].get.responses.['4XX'].content.['*/*'].schema",
                "$.paths.['/tree/{name}'].get.responses.['4XX'].content.['*/*']",
                "$.paths.['/tree/{name}'].get.responses.['4XX'].content",
                "$.paths.['/tree/{name}'].get.responses.['4XX']",
                "$.paths.['/tree/{name}'].get.responses",
                "$.paths.['/tree/{name}'].get.security[0]",
                "$.paths.['/tree/{name}'].get.security[1]",
                "$.paths.['/tree/{name}'].get",
                "$.paths.['/tree/{name}']",
                "$.paths",
                "$.servers[0]",
                "$.servers[1].variables.['username']",
                "$.servers[1].variables.['version']",
                "$.servers[1].variables",
                "$.servers[1]",
                "$.tags[0]",
                "$"
            );
        default:
            throw new IllegalArgumentException("Unexpected spec: " + spec);
        }
    }
}
