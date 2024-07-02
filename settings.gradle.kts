val rootProjectPathLength = rootDir.absolutePath.length
val excludedProjects = listOf(File(rootDir, "buildSrc"))

rootDir.findAllPotentialModuleDirs()
    .filter { it.list()!!.any { child -> child.startsWith("build.gradle") } }
    .filterNot { it in excludedProjects }
    .forEach { moduleDir ->

        val moduleName = moduleDir.absolutePath
            .substring(rootProjectPathLength)
            .replace(File.separator, "-")
            .replaceFirst('-', ':')

        include(moduleName)
        project(moduleName).projectDir = moduleDir
    }

fun File.findAllPotentialModuleDirs(): Sequence<File> = listFiles()!!.asSequence()
    .filter { it.isDirectory }
    .filterNot { it.isHidden }
    .filterNot { it.name.startsWith('.') }
    .filterNot { it.name == "build" }
    .filterNot { it.name == "src" }
    .flatMap { sequenceOf(it) + it.findAllPotentialModuleDirs() }