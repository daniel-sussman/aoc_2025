package helpers

class Circuit(coord: Coord) {
    val connections = mutableSetOf<Coord>(coord)

    fun connect(node: Coord) {
        this.connections += node.circuit.connections
        connections.forEach { node -> node.circuit = this }
    }
}