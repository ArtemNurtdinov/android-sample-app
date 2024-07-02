plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(rootProject.extra["compileSdkVersion"] as Int)

    defaultConfig {
        minSdkVersion(rootProject.extra["minSdkVersion"] as Int)
        targetSdkVersion(rootProject.extra["targetSdkVersion"] as Int)
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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

    implementation(rootProject.extra["kotlinDep"] as String)

    implementation(rootProject.extra["androidDep"] as String)
    implementation(rootProject.extra["materialDep"] as String)
    implementation(rootProject.extra["cardViewDep"] as String)
    implementation(rootProject.extra["constraintDep"] as String)

    implementation(rootProject.extra["rxJavaDep"] as String)
    implementation(rootProject.extra["rxAndroidDep"] as String)

    implementation(rootProject.extra["daggerDep"] as String)
    kapt(rootProject.extra["daggerKapt"] as String)

    implementation(rootProject.extra["roomDep"] as String)
    implementation(rootProject.extra["rxRoomDep"] as String)
    kapt(rootProject.extra["roomKapt"] as String)

    implementation(rootProject.extra["lifecycleDep"] as String)
    kapt(rootProject.extra["lifecycleKapt"] as String)

    testImplementation(rootProject.extra["jUnitDep"] as String)
    testImplementation(rootProject.extra["mockitoDep"] as String)
}