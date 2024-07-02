def rootProjectPathLength = rootDir.absolutePath.length()
def excludedProjects = [new File(rootDir, "buildSrc")]

findAllPotentialModuleDirs(rootDir).findAll { moduleDir ->
    moduleDir.list().any { child -> child.startsWith("build.gradle") }
}.findAll { moduleDir ->
    !excludedProjects.contains(moduleDir)
}.each { moduleDir ->
    def moduleName = moduleDir.absolutePath
            .substring(rootProjectPathLength)
            .replace(File.separator, "-")
            .replaceFirst('-', ':')

    include(moduleName)
    project(moduleName).projectDir = moduleDir
}

def findAllPotentialModuleDirs(File dir) {
    dir.listFiles().findAll {
        it.directory && !it.hidden && !it.name.startsWith('.') && !['build', 'src'].contains(it.name)
    }.collect {
        [it] + findAllPotentialModuleDirs(it)
    }.flatten()
}