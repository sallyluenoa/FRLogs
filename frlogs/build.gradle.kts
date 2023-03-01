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
    const val module = "FRLogs"
    const val domain = "org.fog-rock"
    const val release = "release"
    const val debug = "debug"
    val packageName get() = "${domain.replace('-', '_')}.${module.toLowerCase()}"

    fun versionCode(project: Project): Int =
        (project.findProperty("version.code") ?: "1").toString().toInt()

    fun versionName(project: Project): String =
        (project.findProperty("version.name") ?: "0.0.1-SNAPSHOT").toString()
}

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.lib.gradle)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = ModuleConfigs.packageName
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        base {
            archivesName.set("${ModuleConfigs.module}-${ModuleConfigs.versionName(project)}.${ModuleConfigs.versionCode(project)}")
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName(ModuleConfigs.release) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
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