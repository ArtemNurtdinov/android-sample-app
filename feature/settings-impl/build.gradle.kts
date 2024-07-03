plugins {
    id(Libs.plugin.library)
}

common("com.nefrit.settings")
uiComponents()
dagger()
rxJavaAndroid()
lifecycle()
room()

dependencies {
    implementation(project(":core-common"))
    implementation(project(":feature-settings-api"))

    testImplementation(*Libs.bundle.unitTests)
}