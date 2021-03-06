package trees

import trees.model.Tree
import trees.model.TreeNode
import kotlin.math.min

class MinHeight {
    fun find() {
        val root = Tree.getExampleTree1()
        val height = minHeight(root)
        println(height)
    }

    private fun minHeight(root: TreeNode?): Int {
        if (root == null) return -1
        if (root.left == null && root.right == null) return 0

        if (root.left == null) return minHeight(root.right) + 1
        if (root.right == null) return  minHeight(root.left) + 1

        return min(minHeight(root.left), minHeight(root.left)) + 1
    }
}