package solutions

import helpers.Importer

class DayThree(filepath: String) {
    private val data: List<List<Int>>
    private var result = 0L

    init {
        val data = Importer.extractRows(filepath)
        this.data = data
    }

    fun first(): Long {
        data.forEach { row ->
            result += process(row)
        }
        return result
    }

    fun second(): Long {
        data.forEach { row ->
            result += processSafetyOverride(row)
        }
        return result
    }

    private fun process(row: List<Int>): Long {
        var firstDigit = 0
        var secondDigit = 0
        row.forEachIndexed { index, value ->
            if (value > firstDigit && index != row.lastIndex) {
                firstDigit = value
                secondDigit = 0
            } else if (value > secondDigit) {
                secondDigit = value
            }
        }
        return firstDigit * 10L + secondDigit
    }

    private fun processSafetyOverride(row: List<Int>): Long {
        val digits = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        row.forEachIndexed battery@{ i, new ->
            digits.forEachIndexed { j, existing ->
                if (new > existing && (row.lastIndex - i) >= (11 - j)) {
                    digits[j] = new
                    (j + 1 until 12).forEach { index -> digits[index] = 0 }
                    return@battery
                }
            }
        }
        return digits.joinToString("").toLong()
    }
}