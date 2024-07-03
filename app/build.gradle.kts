plugins {
    id(Libs.plugin.application)
}

android("com.nefrit.app")

dependencies {
    implementation(projects.coreCommon)
    implementation(projects.featureUser)
    implementation(projects.featureSettings)

    implementation(*Libs.bundle.navigation)

    implementation(*Libs.bundle.network)
}
