package trees

class SerializationOfNaryTree {
    fun serialize() {
        val root = NaryTree.getExampleTee()
        serialize(root)
    }

    private var index = -1

    fun deserialize() {
        val array = arrayOf(15, 6, 18, -1, 7, -1, 45, 40, -1, -1, -1, 14, 64, -1, -1, 22, 95, -1, 13, 35, -1, -1, -1, 42, 19, -1, -1, -1)

        val root = deserialize(array)
        serialize(root)
    }

    private fun deserialize(array: Array<Int>): NaryTreeNode? {
        index++
        if (index >= array.count() || array[index] == -1) {
            return null
        }

        val root = NaryTreeNode(array[index])
        do {
            val child = deserialize(array)
            if (child != null) {
                if (root.children == null) root.children = mutableListOf()
                root.children!!.add(child)
            }

        } while (child != null)

        return root
    }

    private fun serialize(root: NaryTreeNode?) {
        if (root == null) {
            return
        }

        print("${root.value}, ")

        if (root.children != null) {
            for (child in root.children!!) {
                serialize(child)
            }
        }

        print("-1, ")
    }
}