// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Avoid sync errors due to gradle issues.
    // @see https://github.com/gradle/gradle/issues/9270
    val plugins = org.fog_rock.buildsrc.entity.PluginConfigs
    id(plugins.APP_GRADLE.name) version plugins.APP_GRADLE.version apply false
    id(plugins.LIB_GRADLE.name) version plugins.LIB_GRADLE.version apply false
    id(plugins.KOTLIN.name) version plugins.KOTLIN.version apply false
    // Custom Plugin in buildSrc
    clean_plugins
}