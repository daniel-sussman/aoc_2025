package helpers

import java.io.InputStreamReader

class Importer {
    companion object {
        fun extract(filepath: String): List<List<Int>> {
            val csvFile = ClassLoader.getSystemResourceAsStream(filepath) ?: throw IllegalArgumentException("Cannot find $filepath")
            val rows = csvFile.bufferedReader().readLines()

            val firstRow = rows[0].split(",")
            val numColumns = firstRow.size
            val numRows = rows.size

            val result = List(numColumns) { ArrayList<Int>(numRows) }
            for (row in rows) {
                val values = row.split(",")

                values.forEachIndexed { index, value ->
                    result[index].add(value.toInt())
                }
            }

            return result
        }

        fun extractCsv(filepath: String): List<String> {
            var result = listOf<String>()
            val csvFile = ClassLoader.getSystemResourceAsStream(filepath)
                ?: throw IllegalArgumentException("Cannot find $filepath")
            csvFile.bufferedReader().readLines().forEach { row ->
                result += row.split(",")
            }
            return result
        }

        fun extractRows(filepath: String): List<List<Int>> {
            val file = ClassLoader.getSystemResourceAsStream(filepath) ?: throw IllegalArgumentException("Cannot find $filepath")
            return file.bufferedReader().useLines { lines ->
                lines.map { line ->
                    line.toCharArray().map(Char::digitToInt)
                }.toList()
            }
        }

        fun extractCephalopodColumns(filepath: String): List<CephalopodColumn> {
            val inputStream = ClassLoader.getSystemResourceAsStream(filepath) ?: throw IllegalArgumentException("Cannot find $filepath")
            inputStream.bufferedReader().useLines { lines ->
                val rows = lines.map { line ->
                    val regex = "\\s+".toRegex()
                    regex.split(line.trim())
                }.toList()
                val columns = (0 until rows[0].size).map { columnIndex ->
                    rows.map { row -> row[columnIndex] }
                }
                return columns.map(::incorrectlyMapToCephalopodColumn)
            }
        }

        private fun incorrectlyMapToCephalopodColumn(column: List<String>): CephalopodColumn {
            val values = column.take(column.size - 1).map(String::toLong)
            val sign = if (column.last() == "+") CephalopodColumnType.PLUS else CephalopodColumnType.MULTIPLY
            return CephalopodColumn(values, sign)
        }

        fun actuallyExtractCephalopodColumns(filepath: String): List<CephalopodColumn> {
            val inputStream = ClassLoader.getSystemResourceAsStream(filepath) ?: throw IllegalArgumentException("Cannot find $filepath")
            inputStream.bufferedReader().useLines { lines ->
                val lineList = lines.toList()
                val regex = "\\s+".toRegex()
                val signs = regex.split(lineList.last().trim())
                val rows = lineList
                    .dropLast(1)
                    .map(String::toCharArray)
                var i = 0

                return signs.map { signString ->
                    val sign = if (signString == "+") CephalopodColumnType.PLUS else CephalopodColumnType.MULTIPLY
                    val values = mutableListOf<Long>()
                    while (true) {
                        val number = rows.mapNotNull { row ->
                            if (row.lastIndex >= i) row[i].digitToIntOrNull() else null
                        }
                            .joinToString("")
                            .toLongOrNull()
                        number?.let {
                            values.add(number)
                            i++
                        } ?: break
                    }
                    i++
                    CephalopodColumn(values, sign)
                }
            }
        }

        fun extractMatrix(filepath: String): List<List<Char>> {
            val inputStream = ClassLoader.getSystemResourceAsStream(filepath) ?: throw IllegalArgumentException("File not found: $filepath")

            return inputStream.bufferedReader().use { reader ->
                reader.readLines().map { line -> line.toList() }
            }
        }

        fun extractText(filepath: String): String {
            val inputStream = ClassLoader.getSystemResourceAsStream(filepath) ?: throw IllegalArgumentException("Cannot find $filepath")
            return InputStreamReader(inputStream).use { reader ->
                reader.readText()
            }
        }
    }
}