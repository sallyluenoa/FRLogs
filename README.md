# FRLogs

FRLogs is an Android library that provides easy output of log messages.  
The logs can usually be viewed in the Logcat.  
You can also customize log output destination, such as file output or UI display.

## How to Install

### Create a Personal Access Token

You should create a GitHub personal access token to read the GitHub packages in your Android project.

1. Open your personal GitHub account.
2. Settings -> Developer Settings -> Personal access tokens -> Token (classic) -> Generate new token
3. Generate a new token. Scopes would be selected "read:packages" only.
4. You should keep the created token.

### Install your Android Project with Gradle

In your Android project, open the Gradle file (.gradle or .gradle.kts) of the root and add the following settings.  
`ACCOUNT_NAME` is your GitHub account name and `ACCESS_TOKEN` is the token you created above.

```Gradle
repositories {
    google()
    mavenCentral()

    // Add this settings.
    maven {
        url = uri("https://maven.pkg.github.com/sallyluenoa/FRLogs")
        credentials {
            username = "ACCOUNT_NAME"
            password = "ACCESS_TOKEN"
        }
    }
}
```

Open the Gradle file of the module and add the following dependency, then sync your project with Gradle.  
The library will be installed in your project.

```Gradle
implementation("org.fog-rock.frlogs:frlogs:0.0.1")
```

## How to Use

FRLogs supports both Kotlin and Java.

### For Kotlin

For Kotlin, you can easily use with extension functions.

```kotlin
class KotlinSample {
    
    fun outputLogs(e: Exception) {
        frLogV("This is the VERBOSE log.")
        frLogD("This is the DEBUG log.")
        frLogI("This is the INFO log.")
        frLogW("This is the WARNING log.", e)
        frLogE("This is the ERROR log.", e)
    }
}
```

### For Java

For Java, you can use by calling the static methods of `FRLog` directly.

```java
public class JavaSample {

    private static final String TAG = JavaSample.class.getSimpleName();

    public void outputLogs(final Exception e) {
        FRLog.v(TAG, "This is the VERBOSE log.");
        FRLog.d(TAG, "This is the DEBUG log.");
        FRLog.i(TAG, "This is the INFO log.");
        FRLog.w(TAG, "This is the WARNING log.", e);
        FRLog.e(TAG, "This is the ERROR log.", e);
    }
}
```

## Release Notes

Release notes are available [here](./release-notes/README.md).

## Documents

[A latest version](./docs/index.html) can be read witch written with Kdoc formats.  
Old versions are available from Assets of the past releases.

## License

This license is [Apache License 2.0](./LICENSE.txt).

## For Developers

For more information, read [Memos for Developers](./developers.md).
