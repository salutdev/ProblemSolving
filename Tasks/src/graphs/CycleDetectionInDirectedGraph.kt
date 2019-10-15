package graphs

class CycleDetectionInDirectedGraph {
    fun calc() {
        val graph = EdgeWeightedDiGraph.getExampleGraph4()

        val whiteSet = HashSet<DiGraphNode>(graph.nodes)
        val greySet = HashSet<DiGraphNode>()
        val blackSet = HashSet<DiGraphNode>()

        var result = false
        while(whiteSet.isNotEmpty()) {
            val curNode = whiteSet.first()
            if (dfs(curNode, whiteSet, greySet, blackSet)) {
                result = true
                break
            }
        }

        println(result)
    }

    // returns true if there is a cycle
    private fun dfs(curNode: DiGraphNode?, whiteSet: HashSet<DiGraphNode>, greySet: HashSet<DiGraphNode>, blackSet: HashSet<DiGraphNode>): Boolean {

        moveNode(curNode, whiteSet, greySet)

        curNode?.edges?.forEach { e ->

            val childNode = e.to
            if (whiteSet.contains(childNode)) {
                moveNode(childNode, whiteSet, greySet)
                if (dfs(childNode, whiteSet, greySet, blackSet)) {
                    return true
                }
            }

            if (greySet.contains(childNode)) {
                return true
            }
        }

        moveNode(curNode, greySet, blackSet)

        return false
    }

    private fun moveNode(curNode: DiGraphNode?, sourceSet: HashSet<DiGraphNode>, targetSet: HashSet<DiGraphNode>) {
        if (sourceSet.contains(curNode)) {
            sourceSet.remove(curNode)
            targetSet.add(curNode!!)
        }
    }
}