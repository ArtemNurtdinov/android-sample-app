import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.kapt(vararg list: String) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(vararg list: Any) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.api(vararg list: String) {
    list.forEach { dependency ->
        add("api", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(vararg list: String) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(vararg list: Any) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.coreLibraryDesugaring(vararg list: String) {
    list.forEach { dependency ->
        add("coreLibraryDesugaring", dependency)
    }
}