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

import org.fog_rock.buildsrc.configs.entity.PluginInfo

object PluginConfigs {

    /**
     * Android Application Gradle Plugin
     * Official: https://developer.android.com/studio/releases/gradle-plugin
     * MvnRepos: https://mvnrepository.com/artifact/com.android.application/com.android.application.gradle.plugin
     */
    val APP_GRADLE = PluginInfo("com.android.application", 7, 3, 1)

    /**
     * Android Library Gradle Plugin
     * Official: https://developer.android.com/studio/releases/gradle-plugin
     * MvnRepos: https://mvnrepository.com/artifact/com.android.library/com.android.library.gradle.plugin
     */
    val LIB_GRADLE = PluginInfo("com.android.library", 7, 3, 1)

    /**
     * Android Kotlin Plugin
     * Official: https://kotlinlang.org/
     * MvnRepos: https://mvnrepository.com/artifact/org.jetbrains.kotlin.android/org.jetbrains.kotlin.android.gradle.plugin
     */
    val KOTLIN = PluginInfo("org.jetbrains.kotlin.android", 1, 7, 20)
}