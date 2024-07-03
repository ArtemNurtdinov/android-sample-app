plugins {
    id(Libs.plugin.library)
}

android("com.nefrit.settings")

dependencies {
    implementation(projects.coreCommon)
    implementation(projects.featureSettingsApi)

    testImplementation(*Libs.bundle.unitTests)
}