plugins {
    id(Libs.plugin.library)
}

android("com.nefrit.settings")

dependencies {
    implementation(projects.coreCommon)

    testImplementation(*Libs.bundle.unitTests)
}