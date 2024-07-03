plugins {
    id(Libs.plugin.library)
}

common("com.nefrit.users")
uiComponents()
rxJavaAndroid()
dagger()
lifecycle()
room()

dependencies {
    implementation(project(":core-common"))
    implementation(project(":feature-user-api"))

    testImplementation(*Libs.bundle.unitTests)
}