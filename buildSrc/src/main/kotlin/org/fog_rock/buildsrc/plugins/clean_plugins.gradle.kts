plugins {
    id("com.google.osdetector")
}

val clean by tasks.registering {
    delete(rootProject.buildDir)
    dependsOn(cleanBuildSrc)
}

val cleanBuildSrc by tasks.registering {
    project.exec {
        if (osdetector.os == "windows") {
            commandLine("cmd", "/c", "gradlew", "-p", "buildSrc", "clean")
        } else {
            commandLine("./gradlew", "-p", "buildSrc", "clean")
        }
    }
}