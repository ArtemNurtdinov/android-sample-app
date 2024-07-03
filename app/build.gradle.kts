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
