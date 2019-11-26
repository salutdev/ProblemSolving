package graphs.model

class DiGraphNode(val value: Int) {

    var distanceFromSource: Double = Double.MAX_VALUE
    var lastEdgeWithShortestPath: DirectedEdge? = null
    var visited = false

    var edges: ArrayList<DirectedEdge>? = ArrayList<DirectedEdge>()

    fun addEdge(edge: DirectedEdge) {
        if (edges == null) edges = arrayListOf<DirectedEdge>()
        edges?.add(edge)
    }
}