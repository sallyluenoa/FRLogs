package org.fog_rock.buildsrc.configs

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import java.util.*

object ProjConfigs {

    const val NAME = "FRLogs"
    const val DOMAIN = "org.fog-rock"

    val PACKAGE_DOMAIN get() = DOMAIN.replace('-', '_')
    val SAMPLE_NAME get() = "${NAME}Sample"
    val LIB_NAME get() = NAME.toLowerCase(Locale.ROOT)
    val SMP_NAME get() = SAMPLE_NAME.toLowerCase(Locale.ROOT)
    val LIB_PACKAGE_NAME get() = "${PACKAGE_DOMAIN}.${LIB_NAME}"
    val SMP_PACKAGE_NAME get() = "${PACKAGE_DOMAIN}.${SMP_NAME}"

    const val COMPILE_SDK = 33
    const val TARGET_SDK = 33
    const val MIN_SDK = 24

    const val RELEASE = "release"
    const val DEBUG = "debug"

    val JAVA_VERSION = JavaVersion.VERSION_11
    const val KOTLIN_JVM_TARGET = "11"

    private object Properties {
        val VERSION get() = "${LIB_PACKAGE_NAME}.version"
        val VERSION_CODE get() = "${VERSION}.code"
        val VERSION_NAME get() = "${VERSION}.name"
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

    fun archiveName(project: Project): String =
        "${NAME}-${versionName(project)}.${versionCode(project)}"

    fun sampleArchiveName(project: Project): String =
        "${SAMPLE_NAME}-${versionName(project)}.${versionCode(project)}"
}