/*
 * Copyright (c) 2012-2025 Savoir Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.savoir.bundle.demo.command;

import com.savoir.bundle.demo.api.OurService;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Service
@Command(scope = "os", name = "makeXML", description = "OurService command")
public class OurCommand implements Action {

    @Reference
    private OurService ourService;

    @Argument(index = 0, name = "input", description = "User input", required = true, multiValued = false)
    String input;

    @Override
    public Object execute() throws Exception {
        String response = ourService.makeXml(input);
        System.out.println(response);
        return null;
    }
}
