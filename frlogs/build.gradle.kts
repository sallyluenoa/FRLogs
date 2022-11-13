import org.fog_rock.buildsrc.entity.DepsConfigs
import org.fog_rock.buildsrc.entity.ProjConfigs

plugins {
    val plugins = org.fog_rock.buildsrc.entity.PluginConfigs
    id(plugins.LIB_GRADLE.name)
    id(plugins.KOTLIN.name)
}

android {
    namespace = ProjConfigs.LIB_PACKAGE_NAME
    compileSdk = ProjConfigs.COMPILE_SDK

    defaultConfig {
        minSdk = ProjConfigs.MIN_SDK
        targetSdk = ProjConfigs.TARGET_SDK
        base {
            archivesName.set(ProjConfigs.archivesName(project))
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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