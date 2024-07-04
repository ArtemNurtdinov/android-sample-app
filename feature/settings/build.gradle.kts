plugins {
    id(Libs.plugin.library)
}

android("com.nefrit.settings")

dependencies {
    implementation(projects.coreCommon)
    implementation(projects.coreData)
    implementation(projects.coreUi)

    testImplementation(*Libs.bundle.unitTests)
}