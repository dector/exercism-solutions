object Hamming {

    fun compute(a: String, b: String): Int {
        require(a.length == b.length) { "left and right strands must be of equal length." }

        if (a == b) return 0

        return a.zip(b)
            .count { it.first != it.second }
    }
}
