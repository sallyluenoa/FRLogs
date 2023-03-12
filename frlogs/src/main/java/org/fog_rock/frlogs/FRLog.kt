/*
 * Copyright (c) 2023 SallyLueNoa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fog_rock.frlogs

import org.fog_rock.frlogs.provider.FRDefaultLogProvider
import org.fog_rock.frlogs.provider.FRLogProvider

/**
 * A singleton object for outputting log messages by calling the log provider internally.
 */
object FRLog {

    private var provider: FRLogProvider = FRDefaultLogProvider()

    /**
     * Set a customized log provider.
     * The default provider is `FRDefaultLogProvider`.
     * @param provider A log provider that you customized
     */
    fun setProvider(provider: FRLogProvider) {
        this.provider = provider
    }

    /**
     * Output a "VERBOSE" log message.
     * @param tag A tag to identify the source of a log message
     * @param msg A log message
     * @param tr An exception if necessary
     */
    @JvmOverloads
    fun v(tag: String, msg: String, tr: Throwable? = null) {
        provider.v(tag, msg, tr)
    }

    /**
     * Output a "DEBUG" log message.
     * @param tag A tag to identify the source of a log message
     * @param msg A log message
     * @param tr An exception if necessary
     */
    @JvmOverloads
    fun d(tag: String, msg: String, tr: Throwable? = null) {
        provider.d(tag, msg, tr)
    }

    /**
     * Output a "INFO" log message.
     * @param tag A tag to identify the source of a log message
     * @param msg A log message
     * @param tr An exception if necessary
     */
    @JvmOverloads
    fun i(tag: String, msg: String, tr: Throwable? = null) {
        provider.i(tag, msg, tr)
    }

    /**
     * Output a "WARNING" log message.
     * @param tag A tag to identify the source of a log message
     * @param msg A log message
     * @param tr An exception if necessary
     */
    @JvmOverloads
    fun w(tag: String, msg: String, tr: Throwable? = null) {
        provider.w(tag, msg, tr)
    }

    /**
     * Output a "ERROR" log message.
     * @param tag A tag to identify the source of a log message
     * @param msg A log message
     * @param tr An exception if necessary
     */
    @JvmOverloads
    fun e(tag: String, msg: String, tr: Throwable? = null) {
        provider.e(tag, msg, tr)
    }
}