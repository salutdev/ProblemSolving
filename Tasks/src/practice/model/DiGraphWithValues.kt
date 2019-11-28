package practice.model

/*

In a directed graph, each node is assigned an uppercase letter. We define a path's value as the number of most frequently-occurring letter along that path. For example, if a path in the graph goes through "ABACA", the value of the path is 3, since there are 3 occurrences of 'A' on the path.

Given a graph with n nodes and m directed edges, return the largest value path of the graph. If the largest value is infinite, then return null.

The graph is represented with a string and an edge list. The i-th character represents the uppercase letter of the i-th node. Each tuple in the edge list (i, j) means there is a directed edge from the i-th node to the j-th node. Self-edges are possible, as well as multi-edges.

For example, the following input graph:

ABACA
[(0, 1),
 (0, 2),
 (2, 3),
 (3, 4)]
Would have maximum value 3 using the path of vertices [0, 2, 3, 4], (A, A, C, A).

The following input graph:

A
[(0, 0)]
Should return null, since we have an infinite loop.

https://blog.asarkar.org/assets/docs/algorithms-curated/Longest Path in a DAG - Khan.pdf

 */



class DiGraphWithValues {

    val nodes = ArrayList<DiGraphNodeWithValues>()

    fun addNode(node: DiGraphNodeWithValues) {
        nodes.add(node)
    }

    companion object {
        // For topological sort
        fun getExampleGraph(): DiGraphWithValues {

            val graph = DiGraphWithValues()

            val node0 = DiGraphNodeWithValues(0, "A")
            val node1 = DiGraphNodeWithValues(1, "B")
            val node2 = DiGraphNodeWithValues(2, "C")
            val node3 = DiGraphNodeWithValues(3, "C")
            val node4 = DiGraphNodeWithValues(4, "A")
            val node5 = DiGraphNodeWithValues(5, "A")
            val node6 = DiGraphNodeWithValues(6, "A")

            graph.addNode(node0)
            graph.addNode(node1)
            graph.addNode(node2)
            graph.addNode(node3)
            graph.addNode(node4)
            graph.addNode(node5)
            graph.addNode(node6)

            node0.addEdge(DirectedEdgeWithValues(node0, node1))
            node0.addEdge(DirectedEdgeWithValues(node0, node2))
            node0.addEdge(DirectedEdgeWithValues(node0, node5))

            node1.addEdge(DirectedEdgeWithValues(node1, node4))

            node3.addEdge(DirectedEdgeWithValues(node3, node2))
            node3.addEdge(DirectedEdgeWithValues(node3, node4))
            node3.addEdge(DirectedEdgeWithValues(node3, node5))
            node3.addEdge(DirectedEdgeWithValues(node3, node6))

            node5.addEdge(DirectedEdgeWithValues(node5, node2))

            node6.addEdge(DirectedEdgeWithValues(node6, node0))
            node6.addEdge(DirectedEdgeWithValues(node6, node4))

            node5.addEdge(DirectedEdgeWithValues(node5, node4))

            return graph
        }
    }
}