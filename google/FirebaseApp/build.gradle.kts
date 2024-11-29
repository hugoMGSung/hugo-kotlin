// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
}

buildscript {
    dependencies {
        // Google Services 플러그인 추가  (프로젝트 수준):
        classpath("com.google.gms:google-services:4.3.15")
    }
}