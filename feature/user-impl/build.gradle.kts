plugins {
    id(Libs.plugin.library)
}

android("com.nefrit.users")

dependencies {
    implementation(project(":core-common"))
    implementation(project(":feature-user-api"))

    testImplementation(*Libs.bundle.unitTests)
}