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

            val node5 = DiGraphNode(5)
            val node10 = DiGraphNode(10)
            val node18 = DiGraphNode(18)
            val node4 = DiGraphNode(4)
            val node6 = DiGraphNode(6)
            val node3 = DiGraphNode(3)
            val node91 = DiGraphNode(91)
            val node22 = DiGraphNode(22)
            val node55 = DiGraphNode(55)
            val node7 = DiGraphNode(7)
            val node80 = DiGraphNode(80)
            val node88 = DiGraphNode(88)
            val node17 = DiGraphNode(17)
            val node41 = DiGraphNode(41)

            /*node5.addChild(node10)
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
            node41.addChild(node88)*/

            val graph = DiGraph()
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
    }
}