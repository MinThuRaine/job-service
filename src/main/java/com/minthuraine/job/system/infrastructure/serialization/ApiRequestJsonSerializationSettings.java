/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.minthuraine.job.system.infrastructure.serialization;

import io.micrometer.common.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ApiRequestJsonSerializationSettings {

    private final Set<String> parametersForPartialResponse;

    public ApiRequestJsonSerializationSettings(final String responseJson) {
        String commaSerperatedParameters = responseJson;
        if (StringUtils.isNotBlank(commaSerperatedParameters)) {
            parametersForPartialResponse = new HashSet<>(Arrays.asList(commaSerperatedParameters.split("\\s*,\\s*")));
        } else {
            parametersForPartialResponse = new HashSet<>();
        }
    }

    public Set<String> getParametersForPartialResponse() {
        return this.parametersForPartialResponse;
    }

    public boolean isPartialResponseRequired() {
        return !this.parametersForPartialResponse.isEmpty();
    }
}