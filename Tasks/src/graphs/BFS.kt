package graphs

import java.util.*

class BFS {

    fun traverse() {
        val graph = Graph.getExampleGraph()

        val queue = LinkedList<GraphNode>() // ArrayDeque<GraphNode>()

        for (node in graph.nodes) {
            queue.addLast(node)
            node.visited = true
        }

        while(queue.isNotEmpty()) {
            val node = queue.removeFirst()
            print("${node.value}, ")

            for (child in node.children) {
                if (!child.visited) {
                    queue.addLast(child)
                }
            }
        }
    }
}