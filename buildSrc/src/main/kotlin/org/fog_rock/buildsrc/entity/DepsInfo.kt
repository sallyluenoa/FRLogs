package org.fog_rock.buildsrc.entity

data class DepsInfo(
    private val group: String,
    private val name: String,
    private val version: String
) {
    val value = "$group:$name:$version"

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
}