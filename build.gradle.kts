buildscript {
    extra.apply {
        set("versionName", "1.0.0")
        set("versionCode", 1)

        set("compileSdkVersion", 34)
        set("minSdkVersion", 23)
        set("targetSdkVersion", 34)

        set("kotlinVersion", "1.8.0")

        set("supportVersion", "1.6.0")
        set("cardViewVersion", "1.0.0")
        set("constraintVersion", "1.1.3")
        set("recyclerViewVersion", "1.2.1")

        set("rxJavaVersion", "2.2.7")
        set("rxAndroidVersion", "2.1.0")

        set("daggerVersion", "2.44.2")

        set("architectureComponentVersion", "2.5.0")
        set("lifecycleVersion", "2.2.0")

        set("retrofitVersion", "2.4.0")
        set("okhttpVersion", "3.8.0")
        set("gsonVersion", "2.8.2")

        set("splashScreenVersion", "1.0.0")

        set("zXingVersion", "3.5.0")

        set("navControllerVersion", "2.7.7")

        set("junitVersion", "4.12")
        set("mockitoVersion", "2.23.0")
        set("robolectricVersion", "4.1")

        set("kotlinDep", "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${property("kotlinVersion")}")

        set("androidDep", "androidx.appcompat:appcompat:${property("supportVersion")}")
        set("cardViewDep", "androidx.cardview:cardview:${property("cardViewVersion")}")
        set("recyclerViewDep", "androidx.recyclerview:recyclerview:${property("recyclerViewVersion")}")
        set("constraintDep", "androidx.constraintlayout:constraintlayout:${property("constraintVersion")}")
        set("materialDep", "com.google.android.material:material:${property("supportVersion")}")

        set("rxJavaDep", "io.reactivex.rxjava2:rxjava:${property("rxJavaVersion")}")
        set("rxAndroidDep", "io.reactivex.rxjava2:rxandroid:${property("rxAndroidVersion")}")

        set("daggerDep", "com.google.dagger:dagger:${property("daggerVersion")}")
        set("daggerKapt", "com.google.dagger:dagger-compiler:${property("daggerVersion")}")

        set("lifecycleDep", "androidx.lifecycle:lifecycle-extensions:${property("lifecycleVersion")}")
        set("lifecycleKapt", "androidx.lifecycle:lifecycle-compiler:${property("lifecycleVersion")}")

        set("roomDep", "androidx.room:room-runtime:${property("architectureComponentVersion")}")
        set("rxRoomDep", "androidx.room:room-rxjava2:${property("architectureComponentVersion")}")
        set("roomKapt", "androidx.room:room-compiler:${property("architectureComponentVersion")}")

        set("navigationFragmentDep", "androidx.navigation:navigation-fragment:${property("navControllerVersion")}")
        set("navigationUiDep", "androidx.navigation:navigation-ui:${property("navControllerVersion")}")

        set("retrofitDep", "com.squareup.retrofit2:retrofit:${property("retrofitVersion")}")
        set("rxCallAdapterDep", "com.squareup.retrofit2:adapter-rxjava2:${property("retrofitVersion")}")
        set("gsonConvertedDep", "com.squareup.retrofit2:converter-gson:${property("retrofitVersion")}")
        set("gsonDep", "com.google.code.gson:gson:${property("gsonVersion")}")

        set("splashScreenDep", "androidx.core:core-splashscreen:${property("splashScreenVersion")}")

        set("jUnitDep", "junit:junit:${property("junitVersion")}")
        set("mockitoDep", "org.mockito:mockito-inline:${property("mockitoVersion")}")
        set("robolectricDep", "org.robolectric:robolectric:${property("robolectricVersion")}")
        set("robolectricMultidexDep", "org.robolectric:shadows-multidex:${property("robolectricVersion")}")
        set("archCoreTestDep", "androidx.arch.core:core-testing:${property("architectureComponentVersion")}")
    }

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${property("kotlinVersion")}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}