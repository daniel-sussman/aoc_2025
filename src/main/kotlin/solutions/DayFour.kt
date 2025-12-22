package solutions

import helpers.Importer
import helpers.Matrix

class DayFour(filepath: String) {
    private val data: List<List<Char>>
    private var result = 0

    init {
        val data = Importer.extractMatrix(filepath)
        this.data = data
    }

    fun first(): Int {
        val matrix = Matrix(data)

        iterate(matrix)
        return result
    }

    fun second(): Int {
        val matrix = Matrix(data)
        var keepIterating = true

        while (keepIterating) {
            val oldResult = result
            mutate(matrix)
            if (result == oldResult) keepIterating = false
        }

        return result
    }

    private fun iterate(matrix: Matrix) {
        matrix.iterate().forEach { (y, x) ->
            if (matrix.get(y, x) != '@') return@forEach

            val adjacentCount = matrix.listAdjacent(y, x).count { it == '@' }
            if (adjacentCount < 4) result++
        }
    }

    private fun mutate(matrix: Matrix) {
        matrix.iterate().forEach { (y, x) ->
            if (matrix.get(y, x) != '@') return@forEach

            val adjacentCount = matrix.listAdjacent(y, x).count { it == '@' }
            if (adjacentCount < 4) {
                result++
                matrix.mutate(y, x, 'x')
            }
        }
    }
}