# FRLogs

FRLogs is an Android library that provides easy output of log messages.  
The logs can usually be viewed in the Logcat.  
You can also customize log output destination, such as file output or UI display.

## How to Install

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

## Releases

## Documents

## License

This license is [Apache License 2.0](./LICENSE.txt).

## For Developers
