plugins {
    id(Libs.plugin.application)
    id(Libs.plugin.kotlin_android)
    id(Libs.plugin.kotlin_kapt)
}

android {
    compileSdk = App.compileSdk
    defaultConfig {
        applicationId = "com.nefrit.app"
        minSdk = App.minSdk
        targetSdk = App.targetSdk
        versionCode = App.code
        versionName = App.name
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName(BuildTypes.release) {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":core-common"))
    implementation(project(":feature-user-api"))
    implementation(project(":feature-user-impl"))
    implementation(project(":feature-settings-api"))
    implementation(project(":feature-settings-impl"))

    implementation(*Libs.bundle.kotlin)

    implementation(*Libs.bundle.androidx)
    implementation(*Libs.bundle.rxJava)
    implementation(*Libs.bundle.rxJavaAndroid)

    implementation(*Libs.bundle.navigation)

    implementation(*Libs.bundle.room)
    kapt(*Libs.bundle.roomKapt)

    implementation(*Libs.bundle.dagger)
    kapt(*Libs.bundle.daggerKapt)

    implementation(*Libs.bundle.lifecycle)
    kapt(*Libs.bundle.lifecycleKapt)

    implementation(*Libs.bundle.network)
}
