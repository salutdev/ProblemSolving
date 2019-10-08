package trees

class SerializationOfBinaryTree {

    fun serialize() {
        val root = Tree.getExampleTree1()
        serialize(root)
    }

    private var index = -1

    fun deserialize() {
        val array = arrayOf(20, 13, 4, 2, 1, -1, -1, 3, -1, -1, 8, -1, -1, 17, 15, -1, -1, 19, -1, -1, 44, 25, -1, -1, 58, -1, -1)

        val root = deserialize(array)
        serialize(root)
    }

    private fun deserialize(array: Array<Int>): TreeNode? {
        index++
        if (index >= array.count() || array[index] == -1) {
            return null
        }

        val root = TreeNode(array[index])
        root.left = deserialize(array)
        root.right = deserialize(array)
        return root
    }

    private fun serialize(root: TreeNode?) {
        if (root == null) {
            print("-1, ")
            return
        }

        print("${root.value}, ")

        serialize(root.left)
        serialize(root.right)
    }
}