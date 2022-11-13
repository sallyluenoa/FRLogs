package org.fog_rock.buildsrc.configs.entity

data class VersionFormat(
    private val major: Int,
    private val minor: Int,
    private val patch: Int
) {
    val value get() = "$major.$minor.$patch"
}