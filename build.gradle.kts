plugins {
    id("com.android.application")  version "8.3.0-alpha03" apply false
    id("com.android.library")      version "8.3.0-alpha01" apply false
    id("org.jetbrains.compose")    version "1.5.1" apply false
    kotlin("android")              version "1.9.10" apply false
    kotlin("multiplatform")        version "1.9.10" apply false
    kotlin("plugin.serialization") version "1.9.10" apply false
}

allprojects {
    repositories {
        mavenCentral()
        google()
        //maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
