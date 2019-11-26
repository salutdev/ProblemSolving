package graphs.model

class GraphNode(val value: Int) {

    val children = ArrayList<GraphNode>()
    var visited = false

    fun addChild(child: GraphNode) {
        children.add(child)
    }
}