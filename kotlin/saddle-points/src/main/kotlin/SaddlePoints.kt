typealias MatrixData = List<List<Int>>

class Matrix(data: MatrixData) {

    val saddlePoints: Set<MatrixCoordinate> =
        findSaddlePoints(data)
}

private fun findSaddlePoints(data: MatrixData): Set<MatrixCoordinate> {
    if (data.isEmpty()) return emptySet()

    val maxInRows = (0 until data.rows)
        .map { rowIndex -> rowIndex to data.rowAt(rowIndex) }
        .map { (rowIndex, row) ->
            val columnIndex = row.indexOf(row.max())
            MatrixCoordinate(rowIndex, columnIndex)
        }

    val minInColumns = (0 until data.columns)
        .map { columnIndex -> columnIndex to data.columnAt(columnIndex) }
        .map { (columnIndex, column) ->
            val rowIndex = column.indexOf(column.min())
            MatrixCoordinate(rowIndex, columnIndex)
        }

    println("Max in rows: $maxInRows")
    println("Min in columns: $minInColumns")

    return maxInRows
        .filter { minInColumns.contains(it) }
        .toSet()
}

private val MatrixData.rows get() = size
private val MatrixData.columns get() = get(0).size

private fun MatrixData.rowAt(row: Int): List<Int> =
    get(row)

private fun MatrixData.columnAt(column: Int): List<Int> = (0 until rows)
    .map(this::rowAt)
    .map { it[column] }

data class MatrixCoordinate(val row: Int, val col: Int) {

    override fun toString() = "[$row : $col]"
}
