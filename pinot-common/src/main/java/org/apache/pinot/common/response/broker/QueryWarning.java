/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pinot.common.response.broker;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * An informational warning attached to a {@link org.apache.pinot.common.response.BrokerResponse}.
 *
 * <p>Warnings do not represent failures (failures are conveyed via {@link QueryProcessingException}). They surface
 * conditions that may help users interpret a result, such as an empty result set caused by restrictive filters. The
 * {@link #getType()} value is a stable identifier intended for programmatic handling; {@link #getMessage()} is the
 * human-readable description.
 *
 * <p>Instances are immutable and safe to share.
 */
@JsonPropertyOrder({"type", "message"})
public class QueryWarning {

  /** Stable type identifier for the empty-result warning. Treat as a public contract. */
  public static final String TYPE_EMPTY_RESULT = "EMPTY_RESULT";

  private final String _type;
  private final String _message;

  @JsonCreator
  public QueryWarning(@JsonProperty("type") String type, @JsonProperty("message") String message) {
    _type = type;
    _message = message;
  }

  @JsonProperty("type")
  public String getType() {
    return _type;
  }

  @JsonProperty("message")
  public String getMessage() {
    return _message;
  }

  @Override
  public String toString() {
    return "{" + _type + ": " + _message + "}";
  }
}
