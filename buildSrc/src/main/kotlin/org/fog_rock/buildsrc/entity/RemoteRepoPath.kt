package org.fog_rock.buildsrc.entity

data class RemoteRepoPath(
    private val group: String,
    private val name: String,
    private val version: String
) {
    val path = "${group}:${name}:${version}"
}