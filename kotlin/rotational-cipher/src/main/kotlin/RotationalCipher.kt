class RotationalCipher(private val shift: Int) {

    fun encode(text: String): String = text
        .map(this::encode)
        .joinToString("")

    private fun encode(char: Char): Char {
        val normalized = if (char.isUpperCase()) char.toLowerCase() else char

        if (!RAW_ALPHABET.contains(normalized)) return char

        val encoded = run {
            val index = RAW_ALPHABET.indexOf(normalized) + shift
            RAW_ALPHABET[index % 26]
        }

        return if (char.isUpperCase()) encoded.toUpperCase() else encoded
    }

    private companion object {
        const val RAW_ALPHABET = "abcdefghijklmnopqrstuvwxyz"
    }
}
