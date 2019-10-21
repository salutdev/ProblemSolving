package graphs

class Graph {
    val nodes = ArrayList<GraphNode>()
    val edges = ArrayList<Edge>()

    fun addNode(node: GraphNode) {
        nodes.add(node)
    }

    fun addEdge(edge: Edge) {
        edges.add(edge)
    }

    companion object {
        fun getExampleGraph(): Graph {
            /*
            *                    5                                88
            *                 /  |  \                            /  \
            *               /    |    \                         /    \
            *              10    18    4                       17 -- 41
            *             / \    |    / \
            *            /    \  |   /   \
            *           /      \ |  /     \
            *          6          3        91
            *          \          | \     /
            *           \         |   \  /
            *            \       22    55
            *             \      /  \
            *              \   /      \
            *                7 ------- 80
            * */

            val node5 = GraphNode(5)
            val node10 = GraphNode(10)
            val node18 = GraphNode(18)
            val node4 = GraphNode(4)
            val node6 = GraphNode(6)
            val node3 = GraphNode(3)
            val node91 = GraphNode(91)
            val node22 = GraphNode(22)
            val node55 = GraphNode(55)
            val node7 = GraphNode(7)
            val node80 = GraphNode(80)
            val node88 = GraphNode(88)
            val node17 = GraphNode(17)
            val node41 = GraphNode(41)

            node5.addChild(node10)
            node5.addChild(node18)
            node5.addChild(node4)

            node10.addChild(node5)
            node10.addChild(node3)
            node10.addChild(node6)

            node18.addChild(node5)
            node18.addChild(node3)

            node4.addChild(node5)
            node4.addChild(node3)
            node4.addChild(node91)

            node6.addChild(node10)
            node6.addChild(node7)

            node3.addChild(node10)
            node3.addChild(node18)
            node3.addChild(node4)
            node3.addChild(node22)
            node3.addChild(node55)

            node91.addChild(node4)
            node91.addChild(node55)

            node22.addChild(node3)
            node22.addChild(node7)
            node22.addChild(node80)

            node55.addChild(node3)
            node55.addChild(node91)

            node7.addChild(node6)
            node7.addChild(node22)
            node7.addChild(node80)

            node80.addChild(node7)
            node80.addChild(node22)

            node88.addChild(node17)
            node88.addChild(node41)

            node17.addChild(node88)
            node17.addChild(node41)

            node41.addChild(node17)
            node41.addChild(node88)

            val graph = Graph()
            graph.addNode(node5)
            graph.addNode(node10)
            graph.addNode(node18)
            graph.addNode(node4)
            graph.addNode(node6)
            graph.addNode(node3)
            graph.addNode(node91)
            graph.addNode(node22)
            graph.addNode(node55)
            graph.addNode(node7)
            graph.addNode(node80)
            graph.addNode(node88)
            graph.addNode(node17)
            graph.addNode(node41)

            return graph
        }

        fun getExampleGraph2(): Graph {

            val node1 = GraphNode(1)
            val node2 = GraphNode(2)
            val node3 = GraphNode(3)
            val node4 = GraphNode(4)

            node1.addChild(node2)
            node1.addChild(node4)

            node2.addChild(node1)
            //node2.addChild(node3)

            //node3.addChild(node2)
            node3.addChild(node4)

            node4.addChild(node1)
            node4.addChild(node3)

            val graph = Graph()
            graph.addNode(node1)
            graph.addNode(node2)
            graph.addNode(node3)
            graph.addNode(node4)

            return graph
        }

        // For Kruskal, course from Prinston
        fun getExampleGraph3(): Graph {

            val node0 = GraphNode(0)
            val node1 = GraphNode(1)
            val node2 = GraphNode(2)
            val node3 = GraphNode(3)
            val node4 = GraphNode(4)
            val node5 = GraphNode(5)
            val node6 = GraphNode(6)
            val node7 = GraphNode(7)


            val graph = Graph()

            graph.addNode(node0)
            graph.addNode(node1)
            graph.addNode(node2)
            graph.addNode(node3)
            graph.addNode(node4)
            graph.addNode(node5)
            graph.addNode(node6)
            graph.addNode(node7)

            graph.addEdge(Edge(node0, node2, 26))
            graph.addEdge(Edge(node0, node4, 38))
            graph.addEdge(Edge(node0, node6, 48))
            graph.addEdge(Edge(node0, node7, 16))
            graph.addEdge(Edge(node1, node2, 36))
            graph.addEdge(Edge(node1, node3, 29))
            graph.addEdge(Edge(node1, node5, 32))
            graph.addEdge(Edge(node1, node7, 19))
            graph.addEdge(Edge(node2, node3, 17))
            graph.addEdge(Edge(node2, node6, 40))
            graph.addEdge(Edge(node2, node7, 34))
            graph.addEdge(Edge(node3, node6, 52))
            graph.addEdge(Edge(node4, node5, 35))
            graph.addEdge(Edge(node4, node6, 93))
            graph.addEdge(Edge(node4, node7, 37))
            graph.addEdge(Edge(node5, node7, 28))

            return graph
        }
    }
}