plugins {
    id(Libs.plugin.library)
}

android("com.nefrit.common")

dependencies {
    implementation(*Libs.bundle.network)
    implementation(*Libs.bundle.firebase)

    implementation(*Libs.bundle.splashScreen)

    testImplementation(*Libs.bundle.unitTests)
}