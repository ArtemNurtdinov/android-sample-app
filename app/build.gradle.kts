plugins {
    id(Libs.plugin.application)
}

common("com.nefrit.app")
uiComponents()
rxJavaAndroid()
dagger()
lifecycle()
room()

dependencies {
    implementation(project(":core-common"))
    implementation(project(":feature-user-api"))
    implementation(project(":feature-user-impl"))
    implementation(project(":feature-settings-api"))
    implementation(project(":feature-settings-impl"))

    implementation(*Libs.bundle.navigation)

    implementation(*Libs.bundle.network)
}
