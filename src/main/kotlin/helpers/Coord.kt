package helpers

import kotlin.math.sqrt

class Coord(val x: Long, val y: Long, val z: Long) {
    var circuit: Circuit = Circuit(this)

    fun distanceFrom(point: Coord): Double {
        val dx = point.x - this.x
        val dy = point.y - this.y
        val dz = point.z - this.z
        return sqrt((dx * dx + dy * dy + dz * dz).toDouble())
    }
}