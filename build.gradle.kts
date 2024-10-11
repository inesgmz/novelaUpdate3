

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Removed: alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
    id("com.android.application") version "8.1.0" apply false
    id("com.android.library") version "8.1.0" apply false
 //   id("org.jetbrains.kotlin.android") version "1.8.20" apply false
}
buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.3.15") // Google Services plugin
    }
}