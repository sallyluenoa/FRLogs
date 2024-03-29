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

package org.fog_rock.frlogs.provider

/**
 * A interface for providing log messages.
 * This would be called via `FRLog`.
 * @see org.fog_rock.frlogs.FRLog
 */
interface FRLogProvider {

    /**
     * Output a "VERBOSE" log message.
     * This would be called via `FRLog.v`.
     * @param tag A tag to identify the source of a log message
     * @param msg A log message
     * @param tr An exception if necessary
     * @see org.fog_rock.frlogs.FRLog.v
     */
    fun v(tag: String, msg: String, tr: Throwable?)

    /**
     * Output a "DEBUG" log message.
     * This would be called via `FRLog.d`.
     * @param tag A tag to identify the source of a log message
     * @param msg A log message
     * @param tr An exception if necessary
     * @see org.fog_rock.frlogs.FRLog.d
     */
    fun d(tag: String, msg: String, tr: Throwable?)

    /**
     * Output a "INFO" log message.
     * This would be called via `FRLog.i`.
     * @param tag A tag to identify the source of a log message
     * @param msg A log message
     * @param tr An exception if necessary
     * @see org.fog_rock.frlogs.FRLog.i
     */
    fun i(tag: String, msg: String, tr: Throwable?)

    /**
     * Output a "WARNING" log message.
     * This would be called via `FRLog.w`.
     * @param tag A tag to identify the source of a log message
     * @param msg A log message
     * @param tr An exception if necessary
     * @see org.fog_rock.frlogs.FRLog.w
     */
    fun w(tag: String, msg: String, tr: Throwable?)

    /**
     * Output a "ERROR" log message.
     * This would be called via `FRLog.e`.
     * @param tag A tag to identify the source of a log message
     * @param msg A log message
     * @param tr An exception if necessary
     * @see org.fog_rock.frlogs.FRLog.e
     */
    fun e(tag: String, msg: String, tr: Throwable?)
}