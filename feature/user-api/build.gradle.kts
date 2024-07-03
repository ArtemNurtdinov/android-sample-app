plugins {
    id(Libs.plugin.java_library)
    id(Libs.plugin.kotlin)
}

dependencies {
    implementation(rootProject.extra["kotlinDep"] as String)
    implementation(rootProject.extra["rxJavaDep"] as String)
}