import org.fog_rock.buildsrc.entity.DepsConfigs
import org.fog_rock.buildsrc.entity.ProjConfigs

plugins {
    val gradlePlugin = org.fog_rock.buildsrc.entity.PluginConfigs.Gradle
    val kotlinPlugin = org.fog_rock.buildsrc.entity.PluginConfigs.Kotlin
    id(gradlePlugin.APP_NAME)
    id(kotlinPlugin.NAME)
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
            archivesName.set(ProjConfigs.archivesName(project))
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

    implementation(DepsConfigs.AndroidX.CORE_KTX.path)
    implementation(DepsConfigs.AndroidX.APP_COMPAT.path)
    implementation(DepsConfigs.Google.MATERIAL.path)
    testImplementation(DepsConfigs.Junit.JUNIT.path)
    androidTestImplementation(DepsConfigs.AndroidX.Test.JUNIT.path)
    androidTestImplementation(DepsConfigs.AndroidX.Test.ESPRESSO_CORE.path)
}