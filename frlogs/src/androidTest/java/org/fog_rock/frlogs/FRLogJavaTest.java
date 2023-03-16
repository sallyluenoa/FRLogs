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

package org.fog_rock.frlogs;

import org.fog_rock.frlogs.provider.FRLogJavaWithExceptionsTestProvider;
import org.fog_rock.frlogs.provider.FRLogJavaWithoutExceptionsTestProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class FRLogJavaTest {

    private static final String TAG = FRLogJavaTest.class.getSimpleName();

    @Test
    public void log_default() {
        FRLog.resetProvider();
        FRLog.v(TAG, "This is the default VERBOSE log.");
        FRLog.d(TAG, "This is the default DEBUG log.");
        FRLog.i(TAG, "This is the default INFO log.");
        FRLog.w(TAG, "This is the default WARNING log.");
        FRLog.e(TAG, "This is the default ERROR log.");
    }

    @Test
    public void log_withoutExceptions() {
        FRLog.setProvider(new FRLogJavaWithoutExceptionsTestProvider());
        FRLog.v(TAG, "This is the VERBOSE log without exceptions.");
        FRLog.d(TAG, "This is the DEBUG log without exceptions.");
        FRLog.i(TAG, "This is the INFO log without exceptions.");
        FRLog.w(TAG, "This is the WARNING log without exceptions.");
        FRLog.e(TAG, "This is the ERROR log without exceptions.");
    }

    @Test
    public void log_withIndexOutOfBoundsException() {
        FRLog.setProvider(new FRLogJavaWithExceptionsTestProvider(IndexOutOfBoundsException.class));
        final List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2));
        int index = list.size();
        try {
            // The index is out of bounds.
            int value = list.get(index);
        } catch (Exception e) {
            // A type of the value `e` would be `IndexOutOfBoundsException`.
            FRLog.v(TAG, "This is the VERBOSE log with an exception.", e);
            FRLog.d(TAG, "This is the DEBUG log with an exception.", e);
            FRLog.i(TAG, "This is the INFO log with an exception.", e);
            FRLog.w(TAG, "This is the WARNING log with an exception.", e);
            FRLog.e(TAG, "This is the ERROR log with an exception.", e);
        }
    }

    @Test
    public void log_withNumberFormatException() {
        FRLog.setProvider(new FRLogJavaWithExceptionsTestProvider(NumberFormatException.class));
        final String str = "string";
        try {
            // This string cannot be replaced by numeric values.
            int num = Integer.parseInt(str);
        } catch (Exception e) {
            // A type of the value `e` would be `NumberFormatException`.
            FRLog.v(TAG, "This is the VERBOSE log with an exception.", e);
            FRLog.d(TAG, "This is the DEBUG log with an exception.", e);
            FRLog.i(TAG, "This is the INFO log with an exception.", e);
            FRLog.w(TAG, "This is the WARNING log with an exception.", e);
            FRLog.e(TAG, "This is the ERROR log with an exception.", e);
        }
    }
}