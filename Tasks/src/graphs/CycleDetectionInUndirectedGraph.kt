package graphs

import graphs.model.Graph
import graphs.model.GraphNode

class CycleDetectionInUndirectedGraph {

    fun calc() {
        val graph = Graph.getExampleGraph2()

        var result = false
        for (node in graph.nodes) {
            if (!node.visited) {
                if (dfs(node, null)) {
                    result = true
                    break
                }
            }
        }

        println(result)
    }

    // Returns true if there is a cycle
    private fun dfs(node: GraphNode, parent: GraphNode?): Boolean {
        if (node.visited) return true
        node.visited = true

        for (child in node.children) {
            if (child != parent && dfs(child, node)) {
                return true
            }
        }

        return false
    }
}