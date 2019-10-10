package trees

import kotlin.math.max

class MaxHeight {
    fun find() {
        val root = Tree.getExampleTree1()
        println(height((root)))
    }

    private fun height(root: TreeNode?): Int {
        if (root == null) return -1
        return max(height(root.left), height(root.right)) + 1
    }
}