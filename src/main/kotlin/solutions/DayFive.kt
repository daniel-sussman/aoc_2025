package solutions

import helpers.Importer

class DayFive(filepath: String) {
    private val data = Importer.extractText(filepath)
    private var result = 0L

    private val idRanges: List<LongRange>
    private val ids: List<Long>

    init {
        val (idRanges, ids) = data.split("\n\n").map { it.split("\n") }
        this.idRanges = idRanges.map { s ->
            val (first, last) = s.split("-").map(String::toLong)
            first..last
        }
        this.ids = ids.map(String::toLong)
    }

    fun first(): Long {
        ids.forEach ingredient@{ id ->
            idRanges.forEach { range ->
                if (id in range) {
                    result++
                    return@ingredient
                }
            }
        }

        return result
    }

    fun second(): Long {
        val sortedRanges = idRanges.sortedBy(LongRange::first)
        var l0 = 0L
        var r0 = -1L
        sortedRanges.forEach { range ->
            val l1 = range.first
            val r1 = range.last

            if (l1 > r0) {
                result += tallyRange(l0, r0)
                l0 = l1
                r0 = r1
            } else {
                if (r0 < r1) r0 = r1
            }
        }
        result += tallyRange(l0, r0)
        return result
    }

    private fun tallyRange(left: Long, right: Long): Long {
        return right - left + 1L
    }
}