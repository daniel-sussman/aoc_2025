package solutions

import helpers.Circuit
import helpers.Coord
import helpers.Importer

class DayEight(filepath: String) {
    private val data = Importer.extractCoords(filepath)

    fun first(n: Int = 10): Long {
        val distances = mutableMapOf<Pair<Coord, Coord>, Double>()
        val circuits = mutableSetOf<Circuit>()

        (0 until data.size).forEach { i ->
            val thisCoord = data[i]
            ((i + 1) until data.size).forEach { j ->
                val thatCoord = data[j]
                distances[thisCoord to thatCoord] = thisCoord.distanceFrom(thatCoord)
            }
        }

        val sorted = distances.toSortedMap(compareBy { distances[it] } )
        sorted.keys
            .take(n)
            .forEach { (first, second) ->
                first.circuit.connect(second)
            }
        sorted.keys.forEach { (first, second) ->
            circuits.add(first.circuit)
            circuits.add(second.circuit)
        }

        return circuits.map { it.connections.count().toLong() }.sortedDescending().take(3).reduce { a, b -> a * b }
    }

    fun second(): Long {
        val distances = mutableMapOf<Pair<Coord, Coord>, Double>()

        (0 until data.size).forEach { i ->
            val thisCoord = data[i]
            ((i + 1) until data.size).forEach { j ->
                val thatCoord = data[j]
                distances[thisCoord to thatCoord] = thisCoord.distanceFrom(thatCoord)
            }
        }

        val sorted = distances.toSortedMap(compareBy { distances[it] } )
        val bigCircuit = sorted.firstKey().first.circuit
        sorted.keys
            .forEach { (first, second) ->
                if (second.circuit == bigCircuit) {
                    second.circuit.connect(first)
                } else {
                    first.circuit.connect(second)
                }
                if (bigCircuit.connections.size == data.size) {
                    return first.x * second.x
                }
            }

        return -1
    }
}