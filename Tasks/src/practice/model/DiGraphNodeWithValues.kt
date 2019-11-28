package practice.model

import practice.Status

class DiGraphNodeWithValues(val value: Int, val strValue: String) {

    var lastEdgeWithShortestPath: DirectedEdgeWithValues? = null
    var status = Status.NotVisited
    var hashMap = HashMap<String, Int>()

    init {
        hashMap[strValue] = 1
    }

    var edges: ArrayList<DirectedEdgeWithValues>? = ArrayList<DirectedEdgeWithValues>()

    fun addEdge(edge: DirectedEdgeWithValues) {
        if (edges == null) edges = arrayListOf<DirectedEdgeWithValues>()
        edges?.add(edge)
    }
}