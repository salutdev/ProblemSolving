package graphs

import graphs.model.DiGraphNode
import graphs.model.DirectedEdge
import graphs.model.EdgeWeightedDiGraph
import java.util.*

class ReverseDiGraph {

    fun reverse() {
        val graph = EdgeWeightedDiGraph.getExampleGraph2()
        val stack = Stack<DiGraphNode>()

        for (node in graph.nodes) {
            sortTopologically(node, stack)
        }

        stack.forEach { n -> n.visited = false }

        while (stack.isNotEmpty()) {
            val node = stack.pop()
            print("${node.value}, ")
            reverseNodeEgdes(node)
        }
        println()

        for (node in graph.nodes) {
            print("${node.value} -> ")
            if (node.edges != null) {
                for (edge in node.edges!!) {
                    print("${edge.to?.value}, ")
                }
            }
            println()
        }

    }

    private fun reverseNodeEgdes(node: DiGraphNode) {
        node.visited = true
        val edgesToReverse = node.edges?.filter { e -> !e.to!!.visited } as Iterable<DirectedEdge>?
        if (edgesToReverse != null) {
            node.edges?.removeAll(edgesToReverse)

            for (edge in edgesToReverse!!) {
                //node.edges!!.remove(edge)

                val to = edge.to
                val from = edge.from

                edge.to = from
                edge.from = to

                to?.edges?.add(edge)
            }
        }
    }

    private fun sortTopologically(node: DiGraphNode?, stack: Stack<DiGraphNode>) {
        if (node == null || node.visited) return
        node.visited = true

        if (node.edges != null) {
            for (edge in node.edges!!) {
                sortTopologically(edge.to, stack)
            }
        }

        stack.add(node)
    }
}