# Memos for Developers

## For All Developers

### Development Tools

Android Studio Electric Eel &#124; 2022.1.1 Patch 2

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
2. Open "_config_project.yml" and update the version of `version`.
3. Move to "release-notes" directory and do the following tasks.
   1. Copy a file from "release-note-template.md". The file name should be "release-note-vX.X.X.md".
   2. Write a release note in the copied one.
   3. Add a mention of that release note in README.md.
4. Add a commit for updated version.
5. Create a pull request from the "develop" to the "main".
6. When merged via the pull request, the release deploy will be run automatically.
