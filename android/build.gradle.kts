import java.util.Properties

plugins {
    id("com.android.application")
    kotlin("android")
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(project(":common"))

    implementation("androidx.activity:activity-compose:1.7.2")
}

android {
    namespace = "org.webjars.android"
    buildToolsVersion = "34.0.0"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        val barsUrl: String? by project

        val props = Properties()
        rootProject.file("local.properties").let {
            if (it.exists()) it.inputStream().use(props::load)
        }

        val barsUrlWithFallback = barsUrl ?: props["webjarsUrl"] as String?

        val barsUrlWithDefault = barsUrlWithFallback ?: "https://www.webjars.org"
        resValue("string", "webjars_url", barsUrlWithDefault)
    }
}
