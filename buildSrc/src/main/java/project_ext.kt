import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.fileTree

private val Project.android: BaseExtension
    get() = extensions.findByName("android") as? BaseExtension ?: error("Not an Android module: $name")

fun Project.common(namespace: String) {
    plugins.apply {
        apply(Libs.plugin.kotlin_android)
        apply(Libs.plugin.kotlin_kapt)
        apply(Libs.plugin.lint)
    }

    android.apply {
        this.namespace = namespace
        compileSdkVersion(App.compileSdk)

        defaultConfig {
            minSdk = App.minSdk
            targetSdk = App.targetSdk

            vectorDrawables.useSupportLibrary = true
            testInstrumentationRunner = Libs.bundle.unitTestsRunner
        }

        buildTypes {
            getByName(BuildTypes.debug) {
                isMinifyEnabled = false
            }
            create(BuildTypes.alpha) {
                initWith(getByName(BuildTypes.debug))
                isMinifyEnabled = true
                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            }
            getByName(BuildTypes.release) {
                isMinifyEnabled = true
                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
            }
        }

        buildFeatures.viewBinding = true
    }

    dependencies {
        implementation(project.fileTree("include" to "*.jar", "dir" to "libs"))

        implementation(*Libs.bundle.kotlin)
    }
}

fun Project.dagger() {
    dependencies {
        implementation(*Libs.bundle.dagger)
        kapt(*Libs.bundle.daggerKapt)
    }
}

fun Project.coroutines() {
    dependencies {
        implementation(*Libs.bundle.coroutines)
    }
}

fun Project.uiComponents() {
    dependencies {
        implementation(*Libs.bundle.androidx)
    }
}

fun Project.lifecycle() {
    dependencies {
        implementation(*Libs.bundle.lifecycle)
        kapt(*Libs.bundle.lifecycleKapt)
    }
}

fun Project.room() {
    dependencies {
        implementation(*Libs.bundle.room)
        kapt(*Libs.bundle.roomKapt)
    }
}

fun Project.android(namespace: String) {
    common(namespace)
    uiComponents()
    dagger()
    coroutines()
    lifecycle()
    room()
}