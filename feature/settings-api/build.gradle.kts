plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    implementation(rootProject.extra["kotlinDep"] as String)
    implementation(rootProject.extra["rxJavaDep"] as String)
}
