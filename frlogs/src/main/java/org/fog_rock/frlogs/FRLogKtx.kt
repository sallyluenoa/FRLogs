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

/**
 * Get a simple class name as a "TAG".
 */
val Any.TAG: String get() = this::class.java.simpleName

/**
 * Output a "VERBOSE" log message.
 * This can be called from Kotlin code.
 * @param msg A log message
 * @param tr An exception if necessary
 * @see org.fog_rock.frlogs.FRLog.v
 */
fun Any.logV(msg: String, tr: Throwable? = null) = FRLog.v(TAG, msg, tr)

/**
 * Output a "DEBUG" log message.
 * This can be called from Kotlin code.
 * @param msg A log message
 * @param tr An exception if necessary
 * @see org.fog_rock.frlogs.FRLog.d
 */
fun Any.logD(msg: String, tr: Throwable? = null) = FRLog.d(TAG, msg, tr)

/**
 * Output a "INFO" log message.
 * This can be called from Kotlin code.
 * @param msg A log message
 * @param tr An exception if necessary
 * @see org.fog_rock.frlogs.FRLog.i
 */
fun Any.logI(msg: String, tr: Throwable? = null) = FRLog.i(TAG, msg, tr)

/**
 * Output a "WARNING" log message.
 * This can be called from Kotlin code.
 * @param msg A log message
 * @param tr An exception if necessary
 * @see org.fog_rock.frlogs.FRLog.w
 */
fun Any.logW(msg: String, tr: Throwable? = null) = FRLog.w(TAG, msg, tr)

/**
 * Output a "ERROR" log message.
 * This can be called from Kotlin code.
 * @param msg A message
 * @param tr An exception
 * @see org.fog_rock.frlogs.FRLog.e
 */
fun Any.logE(msg: String, tr: Throwable? = null) = FRLog.e(TAG, msg, tr)
