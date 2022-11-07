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

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}