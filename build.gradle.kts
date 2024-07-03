plugins {
    id(Libs.plugin.gradleVersionsPlugin) version (Libs.gradleVersionsPluginVersion)
}

buildscript {
    extra.apply {
        set("kotlinDep", "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Libs.kotlinVersion}")

        set("androidDep", "androidx.appcompat:appcompat:${Libs.supportVersion}")
        set("recyclerViewDep", "androidx.recyclerview:recyclerview:${Libs.recyclerViewVersion}")
        set("constraintDep", "androidx.constraintlayout:constraintlayout:${Libs.constraintVersion}")
        set("materialDep", "com.google.android.material:material:${Libs.supportVersion}")

        set("rxJavaDep", "io.reactivex.rxjava2:rxjava:${Libs.rxJavaVersion}")
        set("rxAndroidDep", "io.reactivex.rxjava2:rxandroid:${Libs.rxAndroidVersion}")

        set("daggerDep", "com.google.dagger:dagger:${Libs.daggerVersion}")
        set("daggerKapt", "com.google.dagger:dagger-compiler:${Libs.daggerVersion}")

        set("lifecycleDep", "androidx.lifecycle:lifecycle-extensions:${Libs.lifecycleVersion}")
        set("lifecycleKapt", "androidx.lifecycle:lifecycle-compiler:${Libs.lifecycleVersion}")

        set("roomDep", "androidx.room:room-runtime:${Libs.architectureComponentVersion}")
        set("rxRoomDep", "androidx.room:room-rxjava2:${Libs.architectureComponentVersion}")
        set("roomKapt", "androidx.room:room-compiler:${Libs.architectureComponentVersion}")

        set("navigationFragmentDep", "androidx.navigation:navigation-fragment:${Libs.navControllerVersion}")
        set("navigationUiDep", "androidx.navigation:navigation-ui:${Libs.navControllerVersion}")

        set("retrofitDep", "com.squareup.retrofit2:retrofit:${Libs.retrofitVersion}")
        set("rxCallAdapterDep", "com.squareup.retrofit2:adapter-rxjava2:${Libs.retrofitVersion}")
        set("gsonConvertedDep", "com.squareup.retrofit2:converter-gson:${Libs.retrofitVersion}")
        set("gsonDep", "com.google.code.gson:gson:${Libs.gsonVersion}")

        set("splashScreenDep", "androidx.core:core-splashscreen:${Libs.splashScreenVersion}")

        set("jUnitDep", "junit:junit:${Libs.junitVersion}")
        set("mockitoDep", "org.mockito:mockito-inline:${Libs.mockitoVersion}")
        set("robolectricDep", "org.robolectric:robolectric:${Libs.robolectricVersion}")
        set("robolectricMultidexDep", "org.robolectric:shadows-multidex:${Libs.robolectricVersion}")
        set("archCoreTestDep", "androidx.arch.core:core-testing:${Libs.architectureComponentVersion}")
    }

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Libs.gradleVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Libs.kotlinVersion}")
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