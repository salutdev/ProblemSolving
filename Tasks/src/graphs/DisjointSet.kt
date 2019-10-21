package graphs

class DisjointSet {

    class Node {
        var data: Int = 0
        var parent: Node? = null
        var rank: Int = 0
    }

    var map = HashMap<Int, Node>()

    fun makeSet(data: Int) {
        val node = Node()
        node.data = data
        node.parent = node
        map.put(data, node)
    }

    fun union(data1: Int, data2: Int) {

        val node1 = map[data1]
        val node2 = map[data2]

        val parent1 = findSet(node1)
        val parent2 = findSet(node2)

        if (parent1 == parent2) return

        if (parent1.rank >= parent2.rank) {
            parent2.parent = parent1
            if (parent1.rank == parent2.rank) {
                parent1.rank++
            }
        } else {
            parent1.parent = parent2
        }

    }

    fun findSet(data: Int): Int {
        if (map.containsKey(data)) {
            val node = map.get(data)
            val parentNode = findSet(node)
            return  parentNode.data
        }

        return Int.MIN_VALUE
    }

    private fun findSet(node: Node?): Node {
        val parent = node?.parent
        if (node == parent) {
            return parent!!
        }

        // Path compression
        node?.parent = findSet(node?.parent)
        return node?.parent!!
    }
}