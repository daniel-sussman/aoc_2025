package solutions

import helpers.CephalopodColumnType.PLUS
import helpers.Importer

class DaySix(filepath: String) {
    private val data = Importer.extractCephalopodColumns(filepath)
    private val realData = Importer.actuallyExtractCephalopodColumns(filepath)
    private var result = 0L

    fun first(): Long {
        data.forEach { problem ->
            result += if (problem.sign == PLUS) problem.values.sum() else problem.values.reduce { a, b -> a * b }
        }
        return result
    }

    fun second(): Long {
        realData.forEach { problem ->
            result += if (problem.sign == PLUS) problem.values.sum() else problem.values.reduce { a, b -> a * b }
        }
        return result
    }
}