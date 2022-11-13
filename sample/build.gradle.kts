import org.fog_rock.buildsrc.configs.DepsConfigs
import org.fog_rock.buildsrc.configs.ProjConfigs

plugins {
    val plugins = org.fog_rock.buildsrc.configs.PluginConfigs
    id(plugins.APP_GRADLE.name)
    id(plugins.KOTLIN.name)
}

android {
    namespace = ProjConfigs.SMP_PACKAGE_NAME
    compileSdk = ProjConfigs.COMPILE_SDK

    defaultConfig {
        applicationId = ProjConfigs.SMP_PACKAGE_NAME
        minSdk = ProjConfigs.MIN_SDK
        targetSdk = ProjConfigs.TARGET_SDK
        versionCode = ProjConfigs.versionCode(project)
        versionName = ProjConfigs.versionName(project)
        base {
            archivesName.set(ProjConfigs.sampleArchiveName(project))
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName(ProjConfigs.RELEASE) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = ProjConfigs.JAVA_VERSION
        targetCompatibility = ProjConfigs.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = ProjConfigs.KOTLIN_JVM_TARGET
    }
}

dependencies {

    implementation(DepsConfigs.AndroidX.CORE_KTX.value)
    implementation(DepsConfigs.AndroidX.APP_COMPAT.value)
    implementation(DepsConfigs.Google.MATERIAL.value)
    testImplementation(DepsConfigs.Junit.JUNIT.value)
    androidTestImplementation(DepsConfigs.AndroidX.Test.JUNIT.value)
    androidTestImplementation(DepsConfigs.AndroidX.Test.ESPRESSO_CORE.value)
}