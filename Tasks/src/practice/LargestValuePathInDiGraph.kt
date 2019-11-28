package practice

import practice.model.DiGraphNodeWithValues
import practice.model.DiGraphWithValues
import practice.model.DirectedEdgeWithValues
import java.lang.Integer.max
import java.util.*

enum class Status { NotVisited, Visiting, Visited }

class LargestValuePathInDiGraph {

    fun calc() {

        val graph = DiGraphWithValues.getExampleGraph()
        if (!isCyclePresent(graph)) {

            setNotVisited(graph)

            val stack = Stack<DiGraphNodeWithValues>()

            topologicalSort(graph, stack)
            //printTopologicalOrder(stack)
            setNotVisited(graph)
            printGraph(graph)

            reverseGraph(stack)
            setNotVisited(graph)

            stack.empty()
            topologicalSort(graph, stack)

            setNotVisited(graph)

            val count = calcMaxCounts(stack)
            println("Max count = $count")
            //printTopologicalOrder(stack)
            printGraph(graph)
        }
    }

    private fun calcMaxCounts(stack: Stack<DiGraphNodeWithValues>): Int {

        var maxCount = 0
        var node: DiGraphNodeWithValues? = null
            while(stack.isNotEmpty()) {
            node = stack.pop()
            node.edges?.forEach { e ->
                node.hashMap.forEach { nodeHashPair ->
                    if (e.to!!.hashMap.containsKey(nodeHashPair.key)) {
                        val additionValue = if (nodeHashPair.key == e.to!!.strValue) 1 else 0
                        if (e.to!!.hashMap[nodeHashPair.key]!! < nodeHashPair.value + additionValue) {
                            e.to!!.hashMap[nodeHashPair.key] = nodeHashPair.value + additionValue
                        }
                    } else {
                        e.to!!.hashMap[nodeHashPair.key] = nodeHashPair.value
                    }
                    maxCount = max(maxCount, e.to!!.hashMap[nodeHashPair.key]!!)
                }
            }
        }

        node?.hashMap?.values?.forEach { v ->
            maxCount = max(maxCount, v)
        }

        return maxCount
    }

    private fun reverseGraph(stack: Stack<DiGraphNodeWithValues>) {

        while (stack.isNotEmpty()) {
            val node = stack.pop()
            node.status = Status.Visited
            val edges = node.edges?.filter { e -> e.to?.status != Status.Visited } as Iterable<DirectedEdgeWithValues>
            node.edges?.removeAll(edges)
            edges.forEach {
                val to = it.to
                it.to = it.from
                it.from = to
                to?.addEdge(it)
            }
        }
    }

    private fun topologicalSort(graph: DiGraphWithValues, stack: Stack<DiGraphNodeWithValues>) {

        for (node in graph.nodes) {
            topologicalSortDfs(node, stack)
        }
    }

    private fun topologicalSortDfs(node: DiGraphNodeWithValues?, stack: Stack<DiGraphNodeWithValues>) {
        if (node == null || node.status == Status.Visited) return
        node.status = Status.Visited

        for (edge in node.edges!!) {
            topologicalSortDfs(edge.to, stack)
        }

        stack.push(node)
    }

    private fun isCyclePresent(graph: DiGraphWithValues): Boolean {

        for (node in graph.nodes) {
            if (isCycleDfs(node)) return true
        }

        return false
    }

    private fun isCycleDfs(node: DiGraphNodeWithValues?): Boolean {

        if (node == null || node.status == Status.Visited) return false
        if (node.status == Status.Visiting) return true
        node.status = Status.Visiting

        for (edge in node.edges!!) {
            if (isCycleDfs(edge.to)) return true
        }

        node.status = Status.Visited
        return false
    }

    private fun printGraph(graph: DiGraphWithValues) {
        println()
        graph.nodes.forEach { node ->
            print("${node.value} -> ")
            node.edges?.forEach { edge ->
                print("${edge.to?.value}, ")
            }
            println()
        }
        println()
    }

    private fun printTopologicalOrder(stack: Stack<DiGraphNodeWithValues>) {
        println()
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            print("${node.value}, ")
        }
        println()
    }

    private fun setNotVisited(graph: DiGraphWithValues) {
        graph.nodes.forEach { n -> n.status = Status.NotVisited}
    }
}