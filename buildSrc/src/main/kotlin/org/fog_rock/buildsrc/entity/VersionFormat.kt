package org.fog_rock.buildsrc.entity

data class VersionFormat(
    private val major: Int,
    private val minor: Int,
    private val patch: Int
) {
    val value = "$major.$minor.$patch"
}