class Squares(private val maxNumber: Int) {

    fun sumOfSquares(): Int =
        (1..maxNumber)
            .map { it * it }
            .sum()

    fun squareOfSum(): Int =
        (1..maxNumber)
            .sum()
            .let { it * it }

    fun difference(): Int =
        squareOfSum() - sumOfSquares()
}
