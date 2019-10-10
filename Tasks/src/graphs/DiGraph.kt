package graphs

class DiGraph {
    val nodes = ArrayList<DiGraphNode>()
    val edges = mutableMapOf<DiGraphNode, ArrayList<DirectedEdge>>()

    fun addNode(node: DiGraphNode) {
        nodes.add(node)
    }

    fun addEdge(from: DiGraphNode, to: DiGraphNode, weight: Int) {
        val edge = DirectedEdge(from, to, weight)
        if (!edges.containsKey(from)) {
            edges[from]= ArrayList<DirectedEdge>()
        }
        edges[from]?.add(edge)
    }

    companion object {
        fun getExampleGraph(): DiGraph {
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

            val node0 = DiGraphNode(0)
            val node4 = DiGraphNode(4)
            val node7 = DiGraphNode(7)
            val node1 = DiGraphNode(1)
            val node2 = DiGraphNode(2)
            val node3 = DiGraphNode(3)
            val node5 = DiGraphNode(5)
            val node6 = DiGraphNode(6)

            val graph = DiGraph()
            graph.addNode(node0)
            graph.addNode(node4)
            graph.addNode(node7)
            graph.addNode(node1)
            graph.addNode(node2)
            graph.addNode(node3)
            graph.addNode(node5)
            graph.addNode(node6)

            return graph
        }
    }
}