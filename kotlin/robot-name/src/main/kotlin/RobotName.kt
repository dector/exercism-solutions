class Robot {

    private var _name: String? = null
    val name: String
        get() = _name ?: RobotNameRegistry
            .generateName()
            .also { _name = it }

    fun reset() {
        RobotNameRegistry.dispose(name)
        _name = null
    }
}

private object RobotNameRegistry {

    private val PREFIX_ALPHABET = ('A'..'Z').toSet()
    private val SUFFIX_ALPHABET = (0..9).toSet()

    private val names = mutableListOf<String>()

    fun generateName(): String {
        val newName = generateUntil(this::isNameFree) {
            val prefix = (1..2).map { PREFIX_ALPHABET.random() }.joinToString("")
            val suffix = (1..3).map { SUFFIX_ALPHABET.random() }.joinToString("")

            prefix + suffix
        }

        names += newName

        return newName
    }

    fun dispose(name: String) {
        names -= name
    }

    private fun isNameFree(name: String) = !names.contains(name)
}

private inline fun <reified T> generateUntil(predicate: (T) -> Boolean, generator: () -> T): T {
    var value = generator()

    while (!predicate(value)) {
        value = generator()
    }

    return value
}
