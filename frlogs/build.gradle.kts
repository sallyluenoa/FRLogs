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

import org.fog_rock.buildsrc.configs.DepsConfigs
import org.fog_rock.buildsrc.configs.ProjConfigs

plugins {
    val plugins = org.fog_rock.buildsrc.configs.PluginConfigs
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
            archivesName.set(ProjConfigs.archiveName(project))
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