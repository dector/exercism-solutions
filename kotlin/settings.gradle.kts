rootProject.name = "exercism-kotlin"

fun loadAllExercises() {
    File(".").listFiles()
        .asSequence()
        .filter { it.isDirectory }
        .filter { it.resolve("build.gradle").exists() }
        .forEach { exerciseDir ->
            include(exerciseDir.name)
        }
}

loadAllExercises()
