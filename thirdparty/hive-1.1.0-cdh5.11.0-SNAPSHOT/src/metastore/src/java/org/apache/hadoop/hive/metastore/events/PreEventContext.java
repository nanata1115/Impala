/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.metastore.events;

import org.apache.hadoop.hive.metastore.HiveMetaStore.HMSHandler;


/**
 * Base class for all the events which are defined for metastore.
 */

public abstract class PreEventContext {

  public static enum PreEventType {
    CREATE_TABLE,
    DROP_TABLE,
    ALTER_TABLE,
    ADD_PARTITION,
    DROP_PARTITION,
    ALTER_PARTITION,
    CREATE_DATABASE,
    DROP_DATABASE,
    LOAD_PARTITION_DONE,
    AUTHORIZATION_API_CALL,
    READ_TABLE,
    READ_DATABASE,
    ADD_INDEX,
    ALTER_INDEX,
    DROP_INDEX
  }

  private final PreEventType eventType;
  private final HMSHandler handler;

  public PreEventContext(PreEventType eventType, HMSHandler  handler) {
    this.eventType = eventType;
    this.handler = handler;
  }

  /**
   * @return the event type
   */
  public PreEventType getEventType() {
    return eventType;
  }

  /**
   * @return the handler
   */
  public HMSHandler getHandler() {
    return handler;
  }

}
