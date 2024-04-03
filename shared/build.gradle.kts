import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.cocoapods)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.projectDir.path)
                    }
                }
            }
        }
    }

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }

    jvm()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        val projectName = project.rootProject.name

        iosTarget.binaries.framework {
            baseName = projectName
            isStatic = true
        }
    }

    cocoapods {
        val projectName = project.rootProject.name

        version = "1.0.0"
        summary = projectName
        homepage = "https://example.com"
        name = projectName

        framework {
            isStatic = false
            baseName = projectName
        }

        // If 'Sync Now' command fails on :app:podGenIOS task,
        // run manually ./gradlew :app:podGenIOS in Terminal

        pod("FCUUID")
    }

    sourceSets {
        jvmMain.dependencies {
            implementation(libs.oshi.core)
        }
    }
}

android {
    namespace = "ru.mingli.getdeviceid.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
