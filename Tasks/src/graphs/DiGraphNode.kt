package graphs

class DiGraphNode(val value: Int) {

    var distanceFromSource: Int = Int.MAX_VALUE
    var lastEdgeWithShortestPath: DirectedEdge? = null
    var visited = false

    var edges: ArrayList<DirectedEdge>? = null

    fun addEdge(edge: DirectedEdge) {
        if (edges == null) edges = arrayListOf<DirectedEdge>()
        edges?.add(edge)
    }
}