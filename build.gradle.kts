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

plugins {
    // Avoid sync errors due to gradle issues.
    // @see https://github.com/gradle/gradle/issues/9270
    val plugins = org.fog_rock.buildsrc.configs.PluginConfigs
    id(plugins.APP_GRADLE.name) version plugins.APP_GRADLE.version apply false
    id(plugins.LIB_GRADLE.name) version plugins.LIB_GRADLE.version apply false
    id(plugins.KOTLIN.name) version plugins.KOTLIN.version apply false
    // Custom Plugin in buildSrc
    clean_plugins
}