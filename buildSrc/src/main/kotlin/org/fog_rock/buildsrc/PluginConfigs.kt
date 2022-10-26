package org.fog_rock.buildsrc

object PluginConfigs {

    /**
     * Android Gradle Plugin
     * Official: https://developer.android.com/studio/releases/gradle-plugin
     * MvnRepos: https://mvnrepository.com/artifact/com.android.application/com.android.application.gradle.plugin
     * MvnRepos: https://mvnrepository.com/artifact/com.android.library/com.android.library.gradle.plugin
     */
    object Gradle {
        const val APP_NAME = "com.android.application"
        const val LIB_NAME = "com.android.library"
        const val VERSION = "7.3.1"
    }

    /**
     * Android Kotlin Plugin
     * Official: https://kotlinlang.org/
     * MvnRepos: https://mvnrepository.com/artifact/org.jetbrains.kotlin.android/org.jetbrains.kotlin.android.gradle.plugin
     */
    object Kotlin {
        const val NAME = "org.jetbrains.kotlin.android"
        const val VERSION = "1.7.20"
    }
}