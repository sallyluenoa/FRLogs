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
import org.fog_rock.frlogs.gadget.FRAnonymousTestInterface
import org.fog_rock.frlogs.provider.FRLogKtxWithAnonymousTestProvider
import org.fog_rock.frlogs.provider.FRLogKtxWithExceptionsTestProvider
import org.fog_rock.frlogs.provider.FRLogKtxWithoutExceptionsTestProvider
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Tests for Kotlin codes.
 */
@RunWith(AndroidJUnit4::class)
class FRLogKtxTest {

    /**
     * Use the default log provider.
     */
    @Test
    fun log_default() {
        FRLog.resetProvider()
        frLogV("This is the default VERBOSE log.")
        frLogD("This is the default DEBUG log.")
        frLogI("This is the default INFO log.")
        frLogW("This is the default WARNING log.")
        frLogE("This is the default ERROR log.")
    }

    /**
     * Use a custom log provider without exceptions.
     * @see org.fog_rock.frlogs.provider.FRLogKtxWithoutExceptionsTestProvider
     */
    @Test
    fun log_withoutExceptions() {
        FRLog.setProvider(FRLogKtxWithoutExceptionsTestProvider())
        frLogV("This is the VERBOSE log without exceptions.")
        frLogD("This is the DEBUG log without exceptions.")
        frLogI("This is the INFO log without exceptions.")
        frLogW("This is the WARNING log without exceptions.")
        frLogE("This is the ERROR log without exceptions.")
    }

    /**
     * Use a custom log provider with an exception `IndexOutOfBoundsException`.
     * @see org.fog_rock.frlogs.provider.FRLogKtxWithExceptionsTestProvider
     */
    @Test
    fun log_withIndexOutOfBoundsException() {
        FRLog.setProvider(FRLogKtxWithExceptionsTestProvider(IndexOutOfBoundsException::class.java))
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

    /**
     * Use a custom log provider with an exception `NumberFormatException`.
     * @see org.fog_rock.frlogs.provider.FRLogKtxWithExceptionsTestProvider
     */
    @Test
    fun log_withNumberFormatException() {
        FRLog.setProvider(FRLogKtxWithExceptionsTestProvider(NumberFormatException::class.java))
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

    /**
     * Use a custom log provider with anonymous class.
     * @see org.fog_rock.frlogs.provider.FRLogKtxWithAnonymousTestProvider
     * @see org.fog_rock.frlogs.gadget.FRAnonymousTestInterface
     */
    @Test
    fun log_withAnonymousClass() {
        FRLog.setProvider(FRLogKtxWithAnonymousTestProvider())
        val anonymous = object : FRAnonymousTestInterface {
            override fun call() {
                frLogV("This is the VERBOSE log in the anonymous class.")
                frLogD("This is the DEBUG log in the anonymous class.")
                frLogI("This is the INFO log in the anonymous class.")
                frLogW("This is the WARNING log in the anonymous class.")
                frLogE("This is the ERROR log in the anonymous class.")
            }
        }
        anonymous.call()
    }
}