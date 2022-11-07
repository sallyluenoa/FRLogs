package org.fog_rock.buildsrc.entity

import org.gradle.api.JavaVersion
import org.gradle.api.Project

object ProjConfigs {

    const val NAME = "FRLogs"
    const val DOMAIN = "org.fog_rock"
    const val LIB_NAME = "frlogs"
    const val SMP_NAME = "${LIB_NAME}sample"
    const val LIB_PACKAGE_NAME = "${DOMAIN}.${LIB_NAME}"
    const val SMP_PACKAGE_NAME = "${DOMAIN}.${SMP_NAME}"

    const val COMPILE_SDK = 33
    const val TARGET_SDK = 33
    const val MIN_SDK = 24

    const val RELEASE = "release"
    const val DEBUG = "debug"

    val JAVA_VERSION = JavaVersion.VERSION_11
    const val KOTLIN_JVM_TARGET = "11"

    private object Properties {
        const val VERSION = "$LIB_PACKAGE_NAME.version"
        const val VERSION_CODE = "$VERSION.code"
        const val VERSION_NAME = "$VERSION.name"
        const val DEFAULT_VERSION_CODE = 1
        const val DEFAULT_VERSION_NAME = "0.0.1-SNAPSHOT"
    }

    fun versionCode(project: Project): Int =
        if (project.hasProperty(Properties.VERSION_CODE)) {
            project.property(Properties.VERSION_CODE).toString().toInt()
        } else {
            Properties.DEFAULT_VERSION_CODE
        }

    fun versionName(project: Project): String =
        if (project.hasProperty(Properties.VERSION_NAME)) {
            project.property(Properties.VERSION_NAME).toString()
        } else {
            Properties.DEFAULT_VERSION_NAME
        }

    fun archivesName(project: Project): String =
        "$NAME-${versionName(project)}.${versionCode(project)}"
}