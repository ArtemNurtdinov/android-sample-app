plugins {
    id(Libs.plugin.library)
}

android("com.nefrit.users")

dependencies {
    implementation(projects.coreCommon)
    implementation(projects.featureUserApi)

    testImplementation(*Libs.bundle.unitTests)
}