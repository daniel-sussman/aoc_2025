package solutions

import helpers.Importer
import helpers.Matrix

class DaySeven(filepath: String) {
    private val data = Importer.extractMatrix(filepath)
    private var result = 0L

    fun first(): Long {
        val matrix = Matrix(data)
        val start = matrix.findOrNull('S') ?: throw IllegalStateException()

        var y = start.first + 1
        var beams = setOf(start.second)

        while (y < matrix.height) {
            val split = mutableSetOf<Int>()
            beams.forEach { x ->
                val grid = matrix.get(y, x)
                if (grid == '^') {
                    if (matrix.isValid(y + 1, x - 1)) split.add(x - 1)
                    if (matrix.isValid(y + 1, x + 1)) split.add(x + 1)
                    result++
                } else {
                    split.add(x)
                }
            }
            beams = split
            y++
        }

        return result
    }

    fun second(): Long {
        val matrix = Matrix(data)
        val start = matrix.findOrNull('S') ?: throw IllegalStateException()

        var y = start.first + 1
        var beams = mapOf(start.second to 1L)

        result = 1
        while (y < matrix.height) {
            val split = mutableMapOf<Int, Long>()
            beams.forEach { x, n ->
                val grid = matrix.get(y, x)
                if (grid == '^') {
                    if (matrix.isValid(y + 1, x - 1)) split[x - 1] = (split[x - 1] ?: 0) + n
                    if (matrix.isValid(y + 1, x + 1)) split[x + 1] = (split[x + 1] ?: 0) + n
                    result += n
                } else {
                    split[x] = (split[x] ?: 0) + n
                }
            }
            beams = split
            y++
        }

        return result
    }
}