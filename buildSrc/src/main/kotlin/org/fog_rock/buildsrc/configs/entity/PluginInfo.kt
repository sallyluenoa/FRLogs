package org.fog_rock.buildsrc.configs.entity

data class PluginInfo(
    val name: String,
    val version: String
) {
    constructor(
        name: String,
        major: Int,
        minor: Int,
        patch: Int
    ) : this(
        name,
        VersionFormat(major, minor, patch).value
    )
}