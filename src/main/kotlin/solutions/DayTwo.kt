package solutions

import helpers.Importer

class DayTwo(filepath: String) {
    private val data: List<String>
    private var result = 0L

    init {
        val data = Importer.extractCsv(filepath)
        this.data = data
    }

    fun first(): Long {
        data.forEach { row ->
            processRange(row)
        }
        return result
    }

    fun second(): Long {
        data.forEach { row ->
            trulyProcessRange(row)
        }
        return result
    }

    private fun processRange(range: String) {
        val (first, last) = range.split("-").map(String::toLong)
        (first..last).forEach { number ->
            if (isInvalid(number)) {
                result += number
            }
        }
    }

    private fun trulyProcessRange(range: String) {
        val (first, last) = range.split("-").map(String::toLong)
        (first..last).forEach { number ->
            if (isTrulyInvalid(number)) {
                result += number
            }
        }
    }

    private fun isInvalid(number: Long): Boolean {
        val nString = number.toString()
        if (nString.length % 2 == 0) {
            return nString.substring(0, nString.length / 2) == nString.substring(nString.length / 2)
        }

        return false
    }

    private fun isTrulyInvalid(number: Long): Boolean {
        val numberString = number.toString()
        if (numberString.length < 2) return false

        var unit = numberString.first().toString()
        var lastGuess = false
        var i = 0
        var step = 1

        while (i + step <= numberString.length) {
            val j = i + step
            val sample = numberString.substring(i, j)
            if (unit != sample) {
                lastGuess = false
                unit = numberString.substring(0, i + 1)
                step = unit.length
                i++
            } else {
                lastGuess = true
                i += step
            }
        }

        return lastGuess && numberString.length % step == 0
    }
}
