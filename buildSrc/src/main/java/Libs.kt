object Libs {
    private const val gradleVersion = "7.2.2"
    private const val kotlinVersion = "1.8.0"

    private const val supportVersion = "1.6.0"
    private const val constraintVersion = "1.1.3"
    private const val recyclerViewVersion = "1.2.1"
    const val architectureComponentVersion = "2.5.0"

    private const val lifecycleVersion = "2.2.0"
    private const val navigationVersion = "2.7.7"
    const val retrofitVersion = "2.4.0"

    private const val kotlinterVersion = "4.2.0"
    private const val rulerVersion = "1.4.0"

    private const val rxJavaVersion = "2.2.7"
    private const val rxAndroidVersion = "2.1.0"

    private const val daggerVersion = "2.44.2"

    private const val hiltVersion = "2.51"
    private const val hiltJetpackVersion = "1.2.0"

    private const val crashlyticsGradleVersion = "2.9.9"
    private const val crashlyticsVersion = "18.6.2"
    private const val analyticsVersion = "21.5.1"
    private const val messagingVersion = "23.4.1"
    private const val configVersion = "21.6.2"

    private const val splashScreenVersion = "1.0.0"
    const val navControllerVersion = "2.7.7"

    const val junitVersion = "4.12"
    const val mockitoVersion = "2.23.0"
    const val robolectricVersion = "4.1"

    const val gradleVersionsPluginVersion = "0.51.0"

    object plugin {
        const val application = "com.android.application"
        const val library = "com.android.library"
        const val java_library = "java-library"
        const val kotlin = "kotlin"
        const val kotlin_kapt = "kotlin-kapt"
        const val kotlin_parcelize = "kotlin-parcelize"
        const val kotlin_serialization = "kotlinx-serialization"
        const val kotlin_android = "kotlin-android"
        const val hilt = "dagger.hilt.android.plugin"
        const val lint = "org.jmailen.kotlinter"
        const val gradleVersionsPlugin = "com.github.ben-manes.versions"
    }

    object classpath {
        const val android_gradle = "com.android.tools.build:gradle:$gradleVersion"
        const val kotlin_gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val kotlin_serialization = "org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion"
        const val crashlytics_gradle = "com.google.firebase:firebase-crashlytics-gradle:$crashlyticsGradleVersion"
        const val hilt_gradle = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
        const val navigation_safeArgs_gradle = "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"
        const val kotlinter = "org.jmailen.gradle:kotlinter-gradle:$kotlinterVersion"
        const val ruler = "com.spotify.ruler:ruler-gradle-plugin:$rulerVersion"
        const val gradleVersionsPlugin = "com.github.ben-manes:gradle-versions-plugin:$gradleVersionsPluginVersion"
    }

    object bundle {
        val kotlin = arrayOf("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
        val androidx = arrayOf(
            "androidx.appcompat:appcompat:$supportVersion",
            "androidx.recyclerview:recyclerview:$recyclerViewVersion",
            "androidx.constraintlayout:constraintlayout:$constraintVersion",
            "com.google.android.material:material:$supportVersion"
        )
        val rxJava = arrayOf("io.reactivex.rxjava2:rxjava:$rxJavaVersion")
        val rxJavaAndroid = arrayOf("io.reactivex.rxjava2:rxandroid:$rxAndroidVersion")

        val dagger = arrayOf("com.google.dagger:dagger:$daggerVersion")
        val daggerKapt = arrayOf("com.google.dagger:dagger-compiler:$daggerVersion")

        val lifecycle = arrayOf("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")
        val lifecycleKapt = arrayOf("androidx.lifecycle:lifecycle-compiler:$lifecycleVersion")

        val room = arrayOf(
            "androidx.room:room-runtime:$architectureComponentVersion",
            "androidx.room:room-rxjava2:$architectureComponentVersion"
        )
        val roomKapt = arrayOf("androidx.room:room-compiler:$architectureComponentVersion")

        val navigation = arrayOf(
            "androidx.navigation:navigation-fragment:$navControllerVersion",
            "androidx.navigation:navigation-ui:$navControllerVersion"
        )

        val network = arrayOf(
            "com.squareup.retrofit2:retrofit:$retrofitVersion",
            "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion",
            "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        )

        val splashScreen = arrayOf("androidx.core:core-splashscreen:$splashScreenVersion")

        val unitTests = arrayOf(
            "junit:junit:$junitVersion",
            "org.mockito:mockito-inline:$mockitoVersion"
        )
    }
}