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

import com.google.common.truth.Truth

/**
 * A custom log provider without exceptions.
 * @see org.fog_rock.frlogs.FRLogKtxTest.log_withoutExceptions
 */
class FRLogKtxWithoutExceptionsTestProvider : FRDefaultLogProvider() {

    override fun v(tag: String, msg: String, tr: Throwable?) {
        super.v(tag, msg, tr)
        Truth.assertThat(tag).isEqualTo("FRLogKtxTest")
        Truth.assertThat(msg).isEqualTo("This is the VERBOSE log without exceptions.")
        Truth.assertThat(tr).isNull()
    }

    override fun d(tag: String, msg: String, tr: Throwable?) {
        super.d(tag, msg, tr)
        Truth.assertThat(tag).isEqualTo("FRLogKtxTest")
        Truth.assertThat(msg).isEqualTo("This is the DEBUG log without exceptions.")
        Truth.assertThat(tr).isNull()
    }

    override fun i(tag: String, msg: String, tr: Throwable?) {
        super.i(tag, msg, tr)
        Truth.assertThat(tag).isEqualTo("FRLogKtxTest")
        Truth.assertThat(msg).isEqualTo("This is the INFO log without exceptions.")
        Truth.assertThat(tr).isNull()
    }

    override fun w(tag: String, msg: String, tr: Throwable?) {
        super.w(tag, msg, tr)
        Truth.assertThat(tag).isEqualTo("FRLogKtxTest")
        Truth.assertThat(msg).isEqualTo("This is the WARNING log without exceptions.")
        Truth.assertThat(tr).isNull()
    }

    override fun e(tag: String, msg: String, tr: Throwable?) {
        super.e(tag, msg, tr)
        Truth.assertThat(tag).isEqualTo("FRLogKtxTest")
        Truth.assertThat(msg).isEqualTo("This is the ERROR log without exceptions.")
        Truth.assertThat(tr).isNull()
    }
}