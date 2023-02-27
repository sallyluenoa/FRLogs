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

import org.fog_rock.buildsrc.configs.ProjConfigs

plugins {
    alias(libs.plugins.android.app.gradle)
    alias(libs.plugins.kotlin.android)
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
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.android.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}