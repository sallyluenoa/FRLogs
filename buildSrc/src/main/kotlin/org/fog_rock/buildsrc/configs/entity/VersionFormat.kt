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

package org.fog_rock.buildsrc.configs.entity

/**
 * Data for a version format.
 * @param major A numeric value for the major version
 * @param minor A numeric value for the minor version
 * @param patch A numeric value for the patch version
 */
data class VersionFormat(
    private val major: Int,
    private val minor: Int,
    private val patch: Int
) {
    /**
     * Get a string value that conforms to the version format.
     */
    val value get() = "$major.$minor.$patch"
}