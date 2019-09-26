package LanguageConstructions

import trees.Tree
import trees.TreeNode

class Practice {
    fun bstCheck() {
        val root = Tree.getExampleTree1()

        val lMin = Int.MIN_VALUE
        val lMax = root.value
        val rMin = root.value
        val rMax = Int.MAX_VALUE

        val result = check(root, Int.MIN_VALUE, Int.MAX_VALUE)

        println(if (result) "BST" else "Not BST")
    }

    private fun check(root: TreeNode?, min: Int, max: Int): Boolean {

        if (root == null) return true
        if (min >= root.value || root.value >= max) return false

        return check(root.left, min, root.value) && check(root.right, root.value, max)
    }
}