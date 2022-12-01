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

/**
 * Configurations for library dependencies.
 */
object DepsConfigs {

    /**
     * Jetpack Library (AndroidX)
     * Official: https://developer.android.com/jetpack/androidx/versions
     * MvnRepos: https://mvnrepository.com/artifact/androidx
     */
    object AndroidX {
        /**
         * Core Kotlin Extensions
         * MvnRepos: https://mvnrepository.com/artifact/androidx.core/core-ktx
         */
        val CORE_KTX = DepsInfo("androidx.core", "core-ktx", 1, 9, 0)

        /**
         * Android AppCompat Library
         * MvnRepos: https://mvnrepository.com/artifact/androidx.appcompat/appcompat
         */
        val APP_COMPAT = DepsInfo("androidx.appcompat", "appcompat", 1, 5, 1)

        object Test {
            /**
             * JUnit
             * MvnRepos: https://mvnrepository.com/artifact/androidx.test.ext/junit
             */
            val JUNIT = DepsInfo("androidx.test.ext", "junit", 1, 1, 3)

            /**
             * AndroidX Test Library
             * MvnRepos: https://mvnrepository.com/artifact/androidx.test.espresso/espresso-core
             */
            val ESPRESSO_CORE = DepsInfo("androidx.test.espresso", "espresso-core", 3, 4, 0)
        }
    }

    object Google {
        /**
         * Material Components For Android
         * MvnRepos: https://mvnrepository.com/artifact/com.google.android.material/material
         */
        val MATERIAL = DepsInfo("com.google.android.material", "material", 1, 7, 0)
    }

    object Junit {
        /**
         * JUnit
         * Official: https://junit.org/junit4/
         * MvnRepos: https://mvnrepository.com/artifact/junit/junit
         */
        val JUNIT = DepsInfo("junit", "junit", 4, 13, 2)
    }
}