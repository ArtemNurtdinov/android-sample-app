plugins {
    id(Libs.plugin.library)
}

android("com.nefrit.users")

dependencies {
    implementation(projects.coreCommon)

    testImplementation(*Libs.bundle.unitTests)
}