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

val domain = "org.fog-rock"
val release = "release"
val javaVersion = JavaVersion.VERSION_17
val Project.versionName: String get() = (this.findProperty("version.name") ?: "0.0.1-SNAPSHOT").toString()
val Project.versionCode: Int get() = (this.findProperty("version.code") ?: "1").toString().toInt()

plugins {
    alias(libs.plugins.android.lib.gradle)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.dokka)
    `maven-publish`
}

android {
    namespace = "${domain}.${project.name}".replace('-', '_')
    compileSdk = libs.versions.sdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        base {
            archivesName.set("${project.name}-${project.versionName}.${project.versionCode}")
        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        getByName(release) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
    kotlinOptions {
        jvmTarget = javaVersion.toString()
    }
    publishing {
        singleVariant(release) {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    androidTestImplementation(libs.bundles.androidx.test)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/sallyluenoa/${rootProject.name}")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = "${domain}.${project.name}"
            artifactId = project.name
            version = project.versionName
            artifact("${buildDir}/outputs/aar/${project.name}-${project.versionName}.${project.versionCode}-release.aar")
        }
    }
}