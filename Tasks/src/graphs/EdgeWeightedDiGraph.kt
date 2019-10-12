package graphs

class EdgeWeightedDiGraph {

    val nodes = ArrayList<DiGraphNode>()
    var v: Int = 0
            get() = this.nodes.count() // Number of vertices

    //val edges = mutableMapOf<DiGraphNode, ArrayList<DirectedEdge>>()

    fun addNode(node: DiGraphNode) {
        nodes.add(node)
    }

//    fun addEdge(from: DiGraphNode, to: DiGraphNode, weight: Int) {
//        val edge = DirectedEdge(from, to, weight)
//        if (!edges.containsKey(from)) {
//            edges[from]= ArrayList<DirectedEdge>()
//        }
//        edges[from]?.add(edge)
//    }

    companion object {
        fun getExampleGraph(): EdgeWeightedDiGraph {
            /*
            *           1 -------*  3
            *         * |  \      * |
            *        /  *     *  /  |
            *      0 -* 7 ----- 2   |
            *      |  * |     *  \  |
            *      | /  *   /     * *
            *      | /   5 -------* 6
            *      | /  *          *
            *      *  /           /
            *      4 ------------
            */

            val graph = EdgeWeightedDiGraph()

            val node0 = DiGraphNode(0)
            val node4 = DiGraphNode(4)
            val node7 = DiGraphNode(7)
            val node1 = DiGraphNode(1)
            val node2 = DiGraphNode(2)
            val node3 = DiGraphNode(3)
            val node5 = DiGraphNode(5)
            val node6 = DiGraphNode(6)

            graph.addNode(node0)
            graph.addNode(node4)
            graph.addNode(node7)
            graph.addNode(node1)
            graph.addNode(node2)
            graph.addNode(node3)
            graph.addNode(node5)
            graph.addNode(node6)

            node0.addEdge(DirectedEdge(node0, node1, 5))
            node0.addEdge(DirectedEdge(node0, node7, 8))
            node0.addEdge(DirectedEdge(node0, node4, 9))

            node1.addEdge(DirectedEdge(node1, node3, 15))
            node1.addEdge(DirectedEdge(node1, node2, 12))
            node1.addEdge(DirectedEdge(node1, node7, 4))

            node7.addEdge(DirectedEdge(node7, node2, 7))
            node7.addEdge(DirectedEdge(node7, node5, 6))

            node4.addEdge(DirectedEdge(node4, node7, 5))
            node4.addEdge(DirectedEdge(node4, node5, 4))
            node4.addEdge(DirectedEdge(node4, node6, 20))

            node3.addEdge(DirectedEdge(node3, node6, 9))

            node2.addEdge(DirectedEdge(node2, node3, 3))
            node2.addEdge(DirectedEdge(node2, node6, 11))

            node5.addEdge(DirectedEdge(node5, node2, 1))
            node5.addEdge(DirectedEdge(node5, node6, 13))

            return graph
        }
    }
}