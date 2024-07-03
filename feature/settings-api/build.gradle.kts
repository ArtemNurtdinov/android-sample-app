plugins {
    id(Libs.plugin.java_library)
    id(Libs.plugin.kotlin)
}

dependencies {
    implementation(*Libs.bundle.kotlin)
    implementation(*Libs.bundle.rxJava)
}
