plugins {
    id(Libs.plugin.library)
    id(Libs.plugin.kotlin_android)
    id(Libs.plugin.kotlin_kapt)
}

android {
    compileSdk = App.compileSdk

    defaultConfig {
        minSdk = App.minSdk
        targetSdk = App.targetSdk
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

    implementation(rootProject.extra["kotlinDep"] as String)

    implementation(rootProject.extra["androidDep"] as String)
    implementation(rootProject.extra["materialDep"] as String)
    implementation(rootProject.extra["recyclerViewDep"] as String)
    implementation(rootProject.extra["constraintDep"] as String)

    implementation(rootProject.extra["rxJavaDep"] as String)

    implementation(rootProject.extra["daggerDep"] as String)
    kapt(rootProject.extra["daggerKapt"] as String)

    implementation(rootProject.extra["lifecycleDep"] as String)
    kapt(rootProject.extra["lifecycleKapt"] as String)

    implementation(rootProject.extra["retrofitDep"] as String)
    implementation(rootProject.extra["gsonConvertedDep"] as String)
    implementation(rootProject.extra["rxCallAdapterDep"] as String)

    implementation(rootProject.extra["roomDep"] as String)
    implementation(rootProject.extra["rxRoomDep"] as String)
    kapt(rootProject.extra["roomKapt"] as String)

    testImplementation(rootProject.extra["jUnitDep"] as String)
    testImplementation(rootProject.extra["mockitoDep"] as String)

    implementation(rootProject.extra["splashScreenDep"] as String)
}