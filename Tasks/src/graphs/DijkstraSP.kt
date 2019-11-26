package graphs

import graphs.model.DiGraphNode
import graphs.model.EdgeWeightedDiGraph
import java.util.*

class DijkstraSP {

    private val pq = PriorityQueue<DiGraphNode> { a, b -> if (a.distanceFromSource > b.distanceFromSource) 1 else if (a == b) 0 else -1 }

    fun calc() {
        val graph = EdgeWeightedDiGraph.getExampleGraph()
        val source = graph.nodes[0]
        findShortestPath(source)

        graph.nodes.sortedBy { n -> n.value }.forEach { n ->
            println("Node: ${n.value} --- Shortest distance: ${n.distanceFromSource} ---- Last edge: ${n.lastEdgeWithShortestPath?.from?.value} --> ${n.lastEdgeWithShortestPath?.to?.value}")
        }
    }

    private fun findShortestPath(source: DiGraphNode) {
        source.distanceFromSource = 0.0
        pq.add(source)

        while (pq.isNotEmpty()) {
            val node = pq.remove()

            node.edges?.forEach { e ->
                val childNode = e.to

                if (node.distanceFromSource + e.weight < childNode!!.distanceFromSource) {
                    childNode.distanceFromSource = node.distanceFromSource + e.weight
                    childNode.lastEdgeWithShortestPath = e

                    if (pq.contains(childNode)) {
                        pq.remove(childNode)  // Reorder pq as key changes (doesn't automatically reoder qp when key changed)
                    }
                    pq.add(childNode)
                }
            }
        }
    }
}