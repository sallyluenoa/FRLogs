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

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.fog_rock.frlogs.provider.FRLogKtxWithExceptionTestProvider
import org.fog_rock.frlogs.provider.FRLogKtxWithoutExceptionsTestProvider
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FRLogKtxTest {

    @Test fun default() {
        FRLog.resetProvider()
        frLogV("This is the default VERBOSE log.")
        frLogD("This is the default DEBUG log.")
        frLogI("This is the default INFO log.")
        frLogW("This is the default WARNING log.")
        frLogE("This is the default ERROR log.")
    }

    @Test fun withoutExceptions() {
        FRLog.setProvider(FRLogKtxWithoutExceptionsTestProvider())
        frLogV("This is the VERBOSE log without exceptions.")
        frLogD("This is the DEBUG log without exceptions.")
        frLogI("This is the INFO log without exceptions.")
        frLogW("This is the WARNING log without exceptions.")
        frLogE("This is the ERROR log without exceptions.")
    }

    @Test fun withIndexOutOfBoundsException() {
        FRLog.setProvider(FRLogKtxWithExceptionTestProvider(IndexOutOfBoundsException::class.java))
        val list = listOf(0, 1, 2)
        val index = list.size
        try {
            // The index is out of bounds.
            val value = list[index]
        } catch (e: Exception) {
            // A type of the value `e` would be `IndexOutOfBoundsException`.
            frLogV("This is the VERBOSE log with an exception.", e)
            frLogD("This is the DEBUG log with an exception.", e)
            frLogI("This is the INFO log with an exception.", e)
            frLogW("This is the WARNING log with an exception.", e)
            frLogE("This is the ERROR log with an exception.", e)
        }
    }

    @Test fun withNumberFormatException() {
        FRLog.setProvider(FRLogKtxWithExceptionTestProvider(NumberFormatException::class.java))
        val str = "string"
        try {
            // This string cannot be replaced by numeric values.
            val num = str.toInt()
        } catch (e: Exception) {
            // A type of the value `e` would be `NumberFormatException`.
            frLogV("This is the VERBOSE log with an exception.", e)
            frLogD("This is the DEBUG log with an exception.", e)
            frLogI("This is the INFO log with an exception.", e)
            frLogW("This is the WARNING log with an exception.", e)
            frLogE("This is the ERROR log with an exception.", e)
        }
    }
}