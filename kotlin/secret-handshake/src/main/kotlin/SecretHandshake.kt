object HandshakeCalculator {

    fun calculateHandshake(number: Int): List<Signal> {
        val code = number.toString(2)
        val shouldReverse = code.getOrElse(4) { '0' } == '1'

        return parse(code)
            .reverseIfNeeded(shouldReverse)
    }

    private fun parse(code: String): List<Signal> =
        code.reversed()
            .mapIndexed { index, value ->
                if (value == '1') index else null
            }
            .filterNotNull()
            .mapNotNull { Signal.byIndex(it) }
}

private fun List<Signal>.reverseIfNeeded(shouldReverse: Boolean): List<Signal> =
    if (shouldReverse)
        reversed()
    else this

enum class Signal {
    WINK, DOUBLE_BLINK, CLOSE_YOUR_EYES, JUMP;

    companion object
}

private fun Signal.Companion.byIndex(index: Int): Signal? =
    Signal.values().getOrNull(index)
