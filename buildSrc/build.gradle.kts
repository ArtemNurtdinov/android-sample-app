import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.2.2")
    api("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    implementation("com.squareup:javapoet:1.13.0")
}