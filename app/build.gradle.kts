plugins {
    id(Libs.plugin.application)
}

android("com.nefrit.app")

dependencies {
    implementation(projects.coreCommon)
    implementation(projects.featureUserApi)
    implementation(projects.featureUserImpl)
    implementation(projects.featureSettingsApi)
    implementation(projects.featureSettingsImpl)

    implementation(*Libs.bundle.navigation)

    implementation(*Libs.bundle.network)
}
