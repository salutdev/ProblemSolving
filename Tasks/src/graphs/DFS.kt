package graphs

class DFS {
    fun traverse() {
        val graph = Graph.getExampleGraph()

        for (node in graph.nodes) {
            visitRecursive(node)
        }
    }

    private fun visitRecursive(node: GraphNode) {
        if (!node.visited) {
            node.visited = true
            print("${node.value}, ")

            for (child in node.children) {
                visitRecursive(child)
            }
        }
    }
}