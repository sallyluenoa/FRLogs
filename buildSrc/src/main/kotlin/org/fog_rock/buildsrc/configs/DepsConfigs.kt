/*
 * Copyright (c) 2022 SallyLueNoa
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

package org.fog_rock.buildsrc.configs

import org.fog_rock.buildsrc.configs.entity.DepsInfo

object DepsConfigs {

    /**
     * Jetpack Library (AndroidX)
     * Official: https://developer.android.com/jetpack/androidx/versions
     */
    object AndroidX {
        val CORE_KTX = DepsInfo("androidx.core", "core-ktx", 1, 9, 0)
        val APP_COMPAT = DepsInfo("androidx.appcompat", "appcompat", 1, 5, 1)

        object Test {
            val JUNIT = DepsInfo("androidx.test.ext", "junit", 1, 1, 3)
            val ESPRESSO_CORE = DepsInfo("androidx.test.espresso", "espresso-core", 3, 4, 0)
        }
    }
    object Google {
        val MATERIAL = DepsInfo("com.google.android.material", "material", 1, 7, 0)
    }
    object Junit {
        val JUNIT = DepsInfo("junit", "junit", 4, 13, 2)
    }
}