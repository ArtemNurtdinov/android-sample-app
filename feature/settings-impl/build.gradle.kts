plugins {
    id(Libs.plugin.library)
}

android("com.nefrit.settings")

dependencies {
    implementation(project(":core-common"))
    implementation(project(":feature-settings-api"))

    testImplementation(*Libs.bundle.unitTests)
}