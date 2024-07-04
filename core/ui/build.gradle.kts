plugins {
    id(Libs.plugin.library)
}

android("com.nefrit.ui")

dependencies {
    implementation(projects.coreCommon)

    implementation(*Libs.bundle.splashScreen)

    testImplementation(*Libs.bundle.unitTests)
}