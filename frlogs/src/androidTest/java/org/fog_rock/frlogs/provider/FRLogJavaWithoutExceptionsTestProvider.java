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

package org.fog_rock.frlogs.provider;

import com.google.common.truth.Truth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @see org.fog_rock.frlogs.FRLogJavaTest
 */
public class FRLogJavaWithoutExceptionsTestProvider extends FRDefaultLogProvider {

    @Override
    public void v(@NonNull String tag, @NonNull String msg, @Nullable Throwable tr) {
        super.v(tag, msg, tr);
        Truth.assertThat(tag).isEqualTo("FRLogJavaTest");
        Truth.assertThat(msg).isEqualTo("This is the VERBOSE log without exceptions.");
        Truth.assertThat(tr).isNull();
    }

    @Override
    public void d(@NonNull String tag, @NonNull String msg, @Nullable Throwable tr) {
        super.v(tag, msg, tr);
        Truth.assertThat(tag).isEqualTo("FRLogJavaTest");
        Truth.assertThat(msg).isEqualTo("This is the DEBUG log without exceptions.");
        Truth.assertThat(tr).isNull();
    }

    @Override
    public void i(@NonNull String tag, @NonNull String msg, @Nullable Throwable tr) {
        super.v(tag, msg, tr);
        Truth.assertThat(tag).isEqualTo("FRLogJavaTest");
        Truth.assertThat(msg).isEqualTo("This is the INFO log without exceptions.");
        Truth.assertThat(tr).isNull();
    }

    @Override
    public void w(@NonNull String tag, @NonNull String msg, @Nullable Throwable tr) {
        super.v(tag, msg, tr);
        Truth.assertThat(tag).isEqualTo("FRLogJavaTest");
        Truth.assertThat(msg).isEqualTo("This is the WARNING log without exceptions.");
        Truth.assertThat(tr).isNull();
    }

    @Override
    public void e(@NonNull String tag, @NonNull String msg, @Nullable Throwable tr) {
        super.v(tag, msg, tr);
        Truth.assertThat(tag).isEqualTo("FRLogJavaTest");
        Truth.assertThat(msg).isEqualTo("This is the ERROR log without exceptions.");
        Truth.assertThat(tr).isNull();
    }
}