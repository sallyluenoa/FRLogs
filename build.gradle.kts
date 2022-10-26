// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Avoid sync errors due to gradle issues.
    // @see https://github.com/gradle/gradle/issues/9270
    val gradlePlugin = org.fog_rock.buildsrc.PluginConfigs.Gradle
    val kotlinPlugin = org.fog_rock.buildsrc.PluginConfigs.Kotlin
    id(gradlePlugin.APP_NAME) version gradlePlugin.VERSION apply false
    id(gradlePlugin.LIB_NAME) version gradlePlugin.VERSION apply false
    id(kotlinPlugin.NAME) version kotlinPlugin.VERSION apply false
}

tasks.register("clean") {
    delete(rootProject.buildDir)
}