/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.opentable.logging;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class CommonLogHolder
{
    private static final Logger LOG = LoggerFactory.getLogger(CommonLogHolder.class);

    static final DateTimeFormatter FORMAT = DateTimeFormatter.ISO_INSTANT;
    static final String HOST_NAME;
    static final String OT_ENV;

    static {
        try {
            HOST_NAME = InetAddress.getLocalHost().getHostName();
            LOG.info("Detected hostname as '{}'", HOST_NAME);
        } catch (UnknownHostException e) {
            LOG.error("Failed to detect hostname", e);
            throw new ExceptionInInitializerError(e);
        }

        OT_ENV = System.getenv("OT_ENV");
        LOG.info("Running in environment {}", OT_ENV);
    }
}
