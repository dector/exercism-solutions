object Pangram {

    private val alphabet = ('a'..'z').toSet()

    fun isPangram(input: String): Boolean {
        val normalizedInput = input
            .toLowerCase()
            .filter(Char::isLetter)

        return alphabet
            .minus(normalizedInput.asIterable())
            .isEmpty()
    }
}
