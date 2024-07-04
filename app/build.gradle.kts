plugins {
    id(Libs.plugin.application)
}

android("com.nefrit.app")

dependencies {
    implementation(projects.coreCommon)
    implementation(projects.coreData)
    implementation(projects.coreUi)
    implementation(projects.featureUser)
    implementation(projects.featureSettings)

    implementation(*Libs.bundle.navigation)

    implementation(*Libs.bundle.network)
    implementation(*Libs.bundle.firebase)
}
