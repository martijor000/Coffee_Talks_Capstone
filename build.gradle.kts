// Top-level build file where you can add configuration options common to all subprojects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.google.gms:google-services:4.4.2")
    }
    task ("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
    allprojects {
        repositories {
            google()
        }
    }
}

plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
    id("com.android.library") version "8.2.0" apply false
}