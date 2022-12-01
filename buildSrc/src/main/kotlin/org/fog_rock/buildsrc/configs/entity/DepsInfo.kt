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
 * Data for a library dependency.
 * @param group A namespace group
 * @param name A library name
 * @param version A library version
 */
data class DepsInfo(
    private val group: String,
    private val name: String,
    private val version: String
) {
    /**
     * The secondary constructor.
     * @param group A namespace group
     * @param name A library name
     * @param major A numeric value for the major version
     * @param minor A numeric value for the minor version
     * @param patch A numeric value for the patch version
     */
    constructor(
        group: String,
        name: String,
        major: Int,
        minor: Int,
        patch: Int
    ) : this(
        group,
        name,
        VersionFormat(major, minor, patch).value
    )

    /**
     * Get a string value that conforms to the format of dependencies.
     */
    val value get() = "$group:$name:$version"
}