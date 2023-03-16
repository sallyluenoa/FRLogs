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

import android.util.Log

/**
 * A class of the default log provider.
 * Methods of this class call methods of Android standard logging class `android.util.Log`,
 * then the logs can be viewed in the Logcat.
 */
open class FRDefaultLogProvider : FRLogProvider {

    override fun v(tag: String, msg: String, tr: Throwable?) {
        tr?.let {
            Log.v(tag, msg, it)
        } ?: run {
            Log.v(tag, msg)
        }
    }

    override fun d(tag: String, msg: String, tr: Throwable?) {
        tr?.let {
            Log.d(tag, msg, it)
        } ?: run {
            Log.d(tag, msg)
        }
    }

    override fun i(tag: String, msg: String, tr: Throwable?) {
        tr?.let {
            Log.i(tag, msg, it)
        } ?: run {
            Log.i(tag, msg)
        }
    }

    override fun w(tag: String, msg: String, tr: Throwable?) {
        tr?.let {
            Log.w(tag, msg, it)
        } ?: run {
            Log.w(tag, msg)
        }
    }

    override fun e(tag: String, msg: String, tr: Throwable?) {
        tr?.let {
            Log.e(tag, msg, it)
        } ?: run {
            Log.e(tag, msg)
        }
    }
}