package graphs

import java.util.*

class Prims {

    private val pq = PriorityQueue<DiGraphNode> { a, b -> if (a.distanceFromSource > b.distanceFromSource) 1 else if (a == b) 0 else -1 }
    fun calc() {
        val graph = EdgeWeightedDiGraph.getExampleGraph3()
        val source = graph

        findMST(source.nodes[0])

        graph.nodes.sortedBy { n -> n.value }.forEach { n ->
            println("Node: ${n.value} --- Shortest distance: ${n.distanceFromSource} ---- Last edge: ${n.lastEdgeWithShortestPath?.from?.value} --> ${n.lastEdgeWithShortestPath?.to?.value}")
        }

    }

    private fun findMST(source: DiGraphNode) {

        source.distanceFromSource = 0.0
        pq.add(source)

        while (pq.isNotEmpty()) {
            val node = pq.remove()
            node.visited = true

            node.edges?.forEach { e ->
                val childNode = e.to

                if (!childNode!!.visited && e.weight < childNode!!.distanceFromSource) {
                    childNode.distanceFromSource = e.weight
                    childNode.lastEdgeWithShortestPath = e

                    if (pq.contains(childNode)) {
                        // Reorder pq as key changes (doesn't automatically reorder qp when key changed)
                        // This is decreaseKey operation (to be implemented with priority queue)
                        pq.remove(childNode)
                    }
                    pq.add(childNode)
                }
            }
        }

    }
}