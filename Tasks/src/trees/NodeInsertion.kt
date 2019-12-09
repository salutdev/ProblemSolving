package trees

import trees.model.Tree
import trees.model.TreeNode

class NodeInsertion {
    fun insert() {
        val root = Tree.getExampleTree1()
        insertNode(root, 43)
    }

    private fun insertNode(root: TreeNode?, value: Int): TreeNode {
        if (root == null) return TreeNode(value)

        if (root.value > value) {
            root.left = insertNode(root.left, value)
        } else if (root.value < value) {
            root.right = insertNode(root.right, value)
        }

        return root
    }
}