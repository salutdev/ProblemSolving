package graphs

import java.util.*
import kotlin.collections.ArrayList

class Kruskal {

    private val pq = PriorityQueue<Edge> { a, b -> if (a.weight > b.weight) 1 else if (a == b) 0 else -1 }

    fun calcMST() {
        val resultEdges = ArrayList<Edge>()
        val graph = Graph.getExampleGraph3()
        val v = graph.nodes.size
        graph.edges.forEach { pq.add(it) }
        val disjointSet = DisjointSet()
        graph.nodes.forEach { disjointSet.makeSet(it.value) }

        while (!pq.isEmpty() && resultEdges.size < v-1) {
            val edge: Edge = pq.remove()
            val root1 = disjointSet.findSet(edge.node1!!.value)
            val root2 = disjointSet.findSet(edge.node2!!.value)
            if (root1 != root2) {
                disjointSet.union(edge.node1!!.value, edge.node2!!.value)
                resultEdges.add(edge)
            }
        }

        resultEdges.forEach { println("${it.node1?.value} -> ${it.node2?.value}")}
    }
}