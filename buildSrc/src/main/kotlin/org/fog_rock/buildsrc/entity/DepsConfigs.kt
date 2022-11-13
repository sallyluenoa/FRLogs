package org.fog_rock.buildsrc.entity

object DepsConfigs {

    /**
     * Jetpack Library (AndroidX)
     * Official: https://developer.android.com/jetpack/androidx/versions
     */
    object AndroidX {
        val CORE_KTX = DepsInfo("androidx.core", "core-ktx", 1, 9, 0)
        val APP_COMPAT = DepsInfo("androidx.appcompat", "appcompat", 1, 5, 1)

        object Test {
            val JUNIT = DepsInfo("androidx.test.ext", "junit", 1, 1, 3)
            val ESPRESSO_CORE = DepsInfo("androidx.test.espresso", "espresso-core", 3, 4, 0)
        }
    }
    object Google {
        val MATERIAL = DepsInfo("com.google.android.material", "material", 1, 7, 0)
    }
    object Junit {
        val JUNIT = DepsInfo("junit", "junit", 4, 13, 2)
    }
}