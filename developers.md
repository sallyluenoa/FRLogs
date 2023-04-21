# Memos for Developers

## For All Developers

### Development Tools

* Android Studio Flamingo &#124; 2022.2.1
  * Gradle: 8.1
  * Android Gradle Plugin: 8.0.0
  * Kotlin: 1.8.20
  * Android SDK: 33
  * Android Min SDK: 24
  * JDK: 17

### How to Build

Just open this project in Android Studio.  

### Branch Management

The "main" branch is the latest one that has been public released.  
The "develop" branch is the latest development one that has not been released yet.

## For Administrators

### How to Release

We deploy releases via GitHub Actions.  
It would be triggered when pushed on the "main" branch.

1. Check out the "develop" branch.
2. If you have updated the versions of Android Studio, open "developers.md" and update version information in "Development Tools".
3. Open "_config_project.yml" and update the version of `version`.
4. Move to "release-notes" directory and do the following tasks.
   1. Copy a file from "release-note-template.md". The file name should be "release-note-vX.X.X.md".
   2. Write a release note in the copied one.
   3. Add a mention of that release note in README.md.
5. Add a commit for updated version.
6. Create a pull request from the "develop" to the "main".
7. When merged via the pull request, the release deploy will be run automatically.
    1. If you have any conflicts, merge it manually.
