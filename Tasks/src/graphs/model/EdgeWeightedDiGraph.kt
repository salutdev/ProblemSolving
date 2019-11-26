package graphs.model

class EdgeWeightedDiGraph {

    val nodes = ArrayList<DiGraphNode>()
//    var v: Int = 0
//            get() = this.nodes.count() // Number of vertices

    fun addNode(node: DiGraphNode) {
        nodes.add(node)
    }

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

            node0.addEdge(DirectedEdge(node0, node1, 5.0))
            node0.addEdge(DirectedEdge(node0, node7, 8.0))
            node0.addEdge(DirectedEdge(node0, node4, 9.0))

            node1.addEdge(DirectedEdge(node1, node3, 15.0))
            node1.addEdge(DirectedEdge(node1, node2, 12.0))
            node1.addEdge(DirectedEdge(node1, node7, 4.0))

            node7.addEdge(DirectedEdge(node7, node2, 7.0))
            node7.addEdge(DirectedEdge(node7, node5, 6.0))

            node4.addEdge(DirectedEdge(node4, node7, 5.0))
            node4.addEdge(DirectedEdge(node4, node5, 4.0))
            node4.addEdge(DirectedEdge(node4, node6, 20.0))

            node3.addEdge(DirectedEdge(node3, node6, 9.0))

            node2.addEdge(DirectedEdge(node2, node3, 3.0))
            node2.addEdge(DirectedEdge(node2, node6, 11.0))

            node5.addEdge(DirectedEdge(node5, node2, 1.0))
            node5.addEdge(DirectedEdge(node5, node6, 13.0))

            return graph
        }

        // For topological sort
        fun getExampleGraph2(): EdgeWeightedDiGraph {

            val graph = EdgeWeightedDiGraph()

            val node0 = DiGraphNode(0)
            val node1 = DiGraphNode(1)
            val node2 = DiGraphNode(2)
            val node3 = DiGraphNode(3)
            val node4 = DiGraphNode(4)
            val node5 = DiGraphNode(5)
            val node6 = DiGraphNode(6)

            graph.addNode(node0)
            graph.addNode(node1)
            graph.addNode(node2)
            graph.addNode(node3)
            graph.addNode(node4)
            graph.addNode(node5)
            graph.addNode(node6)

            node0.addEdge(DirectedEdge(node0, node1, 1.0))
            node0.addEdge(DirectedEdge(node0, node2, 1.0))
            node0.addEdge(DirectedEdge(node0, node5, 1.0))

            node1.addEdge(DirectedEdge(node1, node4, 1.0))

            node3.addEdge(DirectedEdge(node3, node2, 1.0))
            node3.addEdge(DirectedEdge(node3, node4, 1.0))
            node3.addEdge(DirectedEdge(node3, node5, 1.0))
            node3.addEdge(DirectedEdge(node3, node6, 1.0))

            node5.addEdge(DirectedEdge(node5, node2, 1.0))

            node6.addEdge(DirectedEdge(node6, node0, 1.0))
            node6.addEdge(DirectedEdge(node6, node4, 1.0))

            return graph
        }

        // For Prim's algorithm
        fun getExampleGraph3(): EdgeWeightedDiGraph {

            val graph = EdgeWeightedDiGraph()

            val node0 = DiGraphNode(0)
            val node1 = DiGraphNode(1)
            val node2 = DiGraphNode(2)
            val node3 = DiGraphNode(3)
            val node4 = DiGraphNode(4)
            val node5 = DiGraphNode(5)
            val node6 = DiGraphNode(6)
            val node7 = DiGraphNode(7)

            graph.addNode(node0)
            graph.addNode(node1)
            graph.addNode(node2)
            graph.addNode(node3)
            graph.addNode(node4)
            graph.addNode(node5)
            graph.addNode(node6)
            graph.addNode(node7)

            node0.addEdge(DirectedEdge(node0, node2, 0.26))
            node0.addEdge(DirectedEdge(node0, node4, 0.38))
            node0.addEdge(DirectedEdge(node0, node6, 0.58))
            node0.addEdge(DirectedEdge(node0, node7, 0.16))

            node1.addEdge(DirectedEdge(node1, node2, 0.36))
            node1.addEdge(DirectedEdge(node1, node3, 0.29))
            node1.addEdge(DirectedEdge(node1, node5, 0.32))
            node1.addEdge(DirectedEdge(node1, node7, 0.19))

            node2.addEdge(DirectedEdge(node2, node0, 0.26))
            node2.addEdge(DirectedEdge(node2, node1, 0.36))
            node2.addEdge(DirectedEdge(node2, node3, 0.17))
            node2.addEdge(DirectedEdge(node2, node6, 0.40))
            node2.addEdge(DirectedEdge(node2, node7, 0.34))

            node3.addEdge(DirectedEdge(node3, node1, 0.29))
            node3.addEdge(DirectedEdge(node3, node2, 0.17))
            node3.addEdge(DirectedEdge(node3, node6, 0.52))

            node4.addEdge(DirectedEdge(node4, node0, 0.38))
            node4.addEdge(DirectedEdge(node4, node5, 0.35))
            node4.addEdge(DirectedEdge(node4, node6, 0.93))
            node4.addEdge(DirectedEdge(node4, node7, 0.37))

            node5.addEdge(DirectedEdge(node5, node1, 0.32))
            node5.addEdge(DirectedEdge(node5, node4, 0.35))
            node5.addEdge(DirectedEdge(node5, node7, 0.28))

            node6.addEdge(DirectedEdge(node6, node0, 0.58))
            node6.addEdge(DirectedEdge(node6, node2, 0.40))
            node6.addEdge(DirectedEdge(node6, node3, 0.52))
            node6.addEdge(DirectedEdge(node6, node4, 0.93))

            node7.addEdge(DirectedEdge(node7, node0, 0.16))
            node7.addEdge(DirectedEdge(node7, node1, 0.19))
            node7.addEdge(DirectedEdge(node7, node2, 0.34))
            node7.addEdge(DirectedEdge(node7, node4, 0.37))
            node7.addEdge(DirectedEdge(node7, node5, 0.28))

            return graph
        }

        // For directed graph cycle detection
        fun getExampleGraph4(): EdgeWeightedDiGraph {

            val graph = EdgeWeightedDiGraph()

            val node1 = DiGraphNode(1)
            val node2 = DiGraphNode(2)
            val node4 = DiGraphNode(4)
            val node5 = DiGraphNode(5)
            val node6 = DiGraphNode(6)

            graph.addNode(node1)
            graph.addNode(node2)
            graph.addNode(node4)
            graph.addNode(node5)
            graph.addNode(node6)

            node1.addEdge(DirectedEdge(node1, node2, 1.0))

            node4.addEdge(DirectedEdge(node4, node1, 1.0))
            node4.addEdge(DirectedEdge(node4, node5, 1.0))

            node5.addEdge(DirectedEdge(node5, node6, 1.0))

            node6.addEdge(DirectedEdge(node6, node4, 1.0))

            return graph
        }
    }
}