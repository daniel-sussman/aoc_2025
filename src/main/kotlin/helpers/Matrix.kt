package helpers

class Matrix(data: List<List<Char>>) {
    val width = data[0].size
    val height = data.size
    private val state: MutableList<MutableList<Char>> = data.map { it.toMutableList() }.toMutableList()

    fun isValid(y: Int, x: Int) = y in 0 until height && x in 0 until width

    fun get(y: Int, x: Int) = if (isValid(y, x)) state[y][x] else null

    fun findOrNull(value: Char): Pair<Int, Int>? {
        state.forEachIndexed { y, row ->
            row.forEachIndexed { x, char ->
                if (value == char) return y to x
            }
        }
        return null
    }

    fun mutate(y: Int, x: Int, value: Char) {
        state[y][x] = value
    }

    fun iterate(): List<Pair<Int, Int>> {
        val result = mutableListOf<Pair<Int, Int>>()
        (0 until height).forEach { y ->
            (0 until width).forEach { x ->
                result.add(y to x)
            }
        }
        return result
    }

    fun listAdjacent(y: Int, x: Int): List<Char> {
        val result = mutableListOf<Char>()
        (-1 until 2).forEach { dy ->
            (-1 until 2).forEach { dx ->
                if (dx != 0 || dy != 0) get(y + dy, x + dx)?.let { result.add(it) }
            }
        }
        return result
    }
}