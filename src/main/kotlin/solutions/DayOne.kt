package solutions

import helpers.Importer

class DayOne(filepath: String) {
    private val data: List<String>
    private val dial = Dial()
    private var zeroCount = 0

    init {
        val data = Importer.extractText(filepath).split("\n")
        this.data = data
    }

    fun first(): Int {
        data.map(::executeInstruction)
        return zeroCount
    }

    fun second(): Int {
        data.map(::executeInstruction)
        return dial.count
    }

    private fun executeInstruction(instruction: String) {
        val direction = instruction.first()
        val clicks = instruction.substring(1).toInt()
        if (direction == 'L') {
            dial.turnLeft(clicks)
        } else if (direction == 'R') {
            dial.turnRight(clicks)
        } else {
            throw IllegalArgumentException("Invalid input")
        }
        if (dial.value == 0) this.zeroCount += 1
    }
}

class Dial {
    var value = 50
    var count = 0

    fun turnLeft(clicks: Int) {
        repeat(clicks) {
            value--
            if (value == 0) count++
            if (value == -1) this.value = 99
        }
    }

    fun turnRight(clicks: Int) {
        repeat(clicks) {
            value++
            if (value == 100) this.value = 0
            if (value == 0) count++
        }
    }
}
