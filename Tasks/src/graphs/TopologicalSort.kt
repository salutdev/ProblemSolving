package graphs

import graphs.model.DiGraphNode
import graphs.model.EdgeWeightedDiGraph
import java.util.*

class TopologicalSort {
    fun calc() {
        val graph = EdgeWeightedDiGraph.getExampleGraph2()
        val stack = Stack<DiGraphNode>()

        for (node in graph.nodes) {
            if (!node.visited) {
                dfs(node, stack)
            }
        }

        while (stack.isNotEmpty()) {
            print("${stack.pop().value}, ")
        }
    }

    // Reverse post order
    private fun dfs(node: DiGraphNode?, stack: Stack<DiGraphNode>) {

        node?.visited = true

        if (node?.edges != null) {
            for (edge in node.edges!!) {
                if (!edge.to!!.visited) {
                    dfs(edge.to, stack)
                }
            }
        }

        stack.push(node)
    }
}