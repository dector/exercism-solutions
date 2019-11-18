object ScrabbleScore {

    private val score = mapOf(
        "aeioulnrst" to 1,
        "dg" to 2,
        "bcmp" to 3,
        "fhvwy" to 4,
        "k" to 5,
        "jx" to 8,
        "qz" to 10
    ).flatMap { (letters, score) ->
        letters.map { it to score }
    }.toMap()

    fun scoreLetter(c: Char): Int =
        score.getValue(c.toLowerCase())

    fun scoreWord(word: String): Int =
        word.map(this::scoreLetter)
            .sum()
}
