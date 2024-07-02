plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = rootProject.extra["compileSdkVersion"] as Int
    defaultConfig {
        applicationId = "com.nefrit.app"
        minSdk = rootProject.extra["minSdkVersion"] as Int
        targetSdk = rootProject.extra["targetSdkVersion"] as Int
        versionCode = rootProject.extra["versionCode"] as Int
        versionName = rootProject.extra["versionName"] as String
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
    implementation(project(":feature-user-impl"))
    implementation(project(":feature-settings-api"))
    implementation(project(":feature-settings-impl"))

    implementation(rootProject.extra["kotlinDep"] as String)

    implementation(rootProject.extra["androidDep"] as String)
    implementation(rootProject.extra["constraintDep"] as String)

    implementation(rootProject.extra["navigationFragmentDep"] as String)
    implementation(rootProject.extra["navigationUiDep"] as String)

    implementation(rootProject.extra["roomDep"] as String)

    implementation(rootProject.extra["daggerDep"] as String)
    kapt(rootProject.extra["daggerKapt"] as String)

    implementation(rootProject.extra["lifecycleDep"] as String)
    kapt(rootProject.extra["lifecycleKapt"] as String)

    implementation(rootProject.extra["retrofitDep"] as String)
    implementation(rootProject.extra["gsonConvertedDep"] as String)
    implementation(rootProject.extra["rxCallAdapterDep"] as String)
}
