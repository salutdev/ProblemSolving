package graphs

import java.util.*

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

    fun traverseIterative() {
        val stack = Stack<GraphNode>()
        val graph = Graph.getExampleGraph()
        for (node in graph.nodes) {
            if (!node.visited) {
                stack.push(node)
                node.visited = true

                while (stack.isNotEmpty()) {
                    val n = stack.pop()
                    print("${n.value}, ")
                    for (child in n.children) {
                        if (!child.visited) {
                            child.visited = true
                            stack.push(child)
                        }
                    }
                }
            }
        }
    }
}