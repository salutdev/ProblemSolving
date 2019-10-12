package graphs

import java.util.*

class DijkstraSP {

    val pq = PriorityQueue<DiGraphNode> { a, b -> if (a.distanceFromSource > b.distanceFromSource) 1 else if (a == b) 0 else -1 }

    fun calc() {
        val graph = EdgeWeightedDiGraph.getExampleGraph()
        val source = graph.nodes[0]
        findShortestPath(source)

        graph.nodes.sortedBy { n -> n.value }.forEach { n ->
            println("Node: ${n.value} --- Shortest distance: ${n.distanceFromSource} ---- Last edge: ${n.lastEdgeWithShortestPath?.from?.value} --> ${n.lastEdgeWithShortestPath?.to?.value}")
        }
    }

    private fun findShortestPath(source: DiGraphNode) {
        source.distanceFromSource = 0
        pq.add(source)

        while (pq.isNotEmpty()) {
            val node = pq.remove()

            node.edges?.forEach { e ->
                val childNode = e.to

                if (childNode?.distanceFromSource == Int.MAX_VALUE) {
                    pq.add(childNode)
                }

                if (node.distanceFromSource + e.weight < childNode!!.distanceFromSource) {
                    childNode.distanceFromSource = node.distanceFromSource + e.weight
                    childNode.lastEdgeWithShortestPath = e
                }
            }
        }
    }
}