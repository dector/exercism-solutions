class Triangle(a: Double, b: Double, c: Double) {

    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    private val sides = listOf(a, b, c)

    init {
        require(sides.all { it > 0 })
        require(sides.areTriangle())
    }

    val isEquilateral: Boolean =
        sides.distinct().size == 1

    val isIsosceles: Boolean =
        sides.distinct().size <= 2

    val isScalene: Boolean =
        sides.distinct().size == 3
}

private fun List<Double>.areTriangle(): Boolean {
    val max = max() ?: return false

    return (this - max).sum() >= max
}
