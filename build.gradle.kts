plugins {
    id("com.android.application")  version "8.3.0-alpha05" apply false
    id("com.android.library")      version "8.3.0-alpha05" apply false
    id("org.jetbrains.compose")    version "1.5.10" apply false
    kotlin("android")              version "1.9.10" apply false
    kotlin("multiplatform")        version "1.9.10" apply false
    kotlin("plugin.serialization") version "1.9.10" apply false
}

allprojects {
    repositories {
        mavenCentral()
        google()
    }
}
