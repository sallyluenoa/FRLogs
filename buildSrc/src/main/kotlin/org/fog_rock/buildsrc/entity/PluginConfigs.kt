package org.fog_rock.buildsrc.entity

object PluginConfigs {

    /**
     * Android Application Gradle Plugin
     * Official: https://developer.android.com/studio/releases/gradle-plugin
     * MvnRepos: https://mvnrepository.com/artifact/com.android.application/com.android.application.gradle.plugin
     */
    val APP_GRADLE = PluginInfo("com.android.application", 7, 3, 1)

    /**
     * Android Library Gradle Plugin
     * Official: https://developer.android.com/studio/releases/gradle-plugin
     * MvnRepos: https://mvnrepository.com/artifact/com.android.library/com.android.library.gradle.plugin
     */
    val LIB_GRADLE = PluginInfo("com.android.library", 7, 3, 1)

    /**
     * Android Kotlin Plugin
     * Official: https://kotlinlang.org/
     * MvnRepos: https://mvnrepository.com/artifact/org.jetbrains.kotlin.android/org.jetbrains.kotlin.android.gradle.plugin
     */
    val KOTLIN = PluginInfo("org.jetbrains.kotlin.android", 1, 7, 20)
}