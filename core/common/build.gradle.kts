plugins {
    id(Libs.plugin.library)
}

common("com.nefrit.common")
dagger()
rxJavaAndroid()
uiComponents()
lifecycle()
room()

dependencies {
    implementation(*Libs.bundle.network)

    implementation(*Libs.bundle.splashScreen)

    testImplementation(*Libs.bundle.unitTests)
}