// Safe Args
buildscript {
    repositories {
        google()
    }
    dependencies {
        val navVersion = "2.8.5"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    // KSP Plugin
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
}