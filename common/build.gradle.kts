import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("org.jetbrains.compose")
    id("com.android.library")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    jvmToolchain(17)

    androidTarget()

    ios()

    iosSimulatorArm64()

    sourceSets {
        val commonMain = getByName("commonMain") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
                implementation("io.ktor:ktor-client-core:2.3.4")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.4")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")
                api(compose.ui)
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material3)
            }
        }

        getByName("androidMain") {
            dependencies {
                implementation("io.ktor:ktor-client-android:2.3.4")
            }
        }

        // todo: not sure why this has to be created
        create("androidDebug") {
            dependencies {
                implementation(compose.preview)
                runtimeOnly(compose.uiTooling)
            }
        }

        getByName("androidUnitTest") {
            dependencies {
                implementation("junit:junit:4.13.2")
                runtimeOnly("org.slf4j:slf4j-simple:2.0.9")
            }
        }

        val iosMain = getByName("iosMain") {
            dependsOn(commonMain)
            dependencies {
                implementation("io.ktor:ktor-client-ios:2.3.4")
            }
        }

        getByName("iosSimulatorArm64Main") {
            dependsOn(iosMain)
        }
    }
}

tasks.withType<Test> {
    testLogging {
        showStandardStreams = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        events(STARTED, PASSED, SKIPPED, FAILED)
    }
}

android {
    namespace = "org.webjars.common"
    buildToolsVersion = "34.0.0"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}
