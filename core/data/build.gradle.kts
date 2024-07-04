plugins {
    id(Libs.plugin.library)
}

android("com.nefrit.data")

dependencies {
    implementation(projects.coreCommon)
    implementation(*Libs.bundle.network)

    testImplementation(*Libs.bundle.unitTests)
}