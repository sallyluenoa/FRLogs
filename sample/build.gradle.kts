/*
 * Copyright (c) 2022 SallyLueNoa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

object ModuleConfigs {
    const val module = "FRLogsSample"
    const val domain = "org.fog-rock"
    const val release = "release"
    const val debug = "debug"
    val javaVersion = JavaVersion.VERSION_11
    val packageName get() = "${domain.replace('-', '_')}.${module.toLowerCase()}"

    fun versionCode(project: Project): Int =
        (project.findProperty("version.code") ?: "1").toString().toInt()

    fun versionName(project: Project): String =
        (project.findProperty("version.name") ?: "0.0.1-SNAPSHOT").toString()
}

plugins {
    alias(libs.plugins.android.app.gradle)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = ModuleConfigs.packageName
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = ModuleConfigs.packageName
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = ModuleConfigs.versionCode(project)
        versionName = ModuleConfigs.versionName(project)
        base {
            archivesName.set("${ModuleConfigs.module}-${ModuleConfigs.versionName(project)}.${ModuleConfigs.versionCode(project)}")
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName(ModuleConfigs.release) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = ModuleConfigs.javaVersion
        targetCompatibility = ModuleConfigs.javaVersion
    }
    kotlinOptions {
        jvmTarget = ModuleConfigs.javaVersion.toString()
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.android.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}