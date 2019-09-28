package LanguageConstructions

import trees.Tree
import trees.TreeNode
import kotlin.math.abs
import kotlin.math.max

class Practice {

    // Complexity n
    fun balancedCheck() {
        val root = Tree.getExampleTree2()

        val result = balancedCheckHelper(root)

        println(if (result != Int.MIN_VALUE) "Balanced" else "Not Balanced")
    }

    private fun balancedCheckHelper(root: TreeNode?): Int {
        if (root == null) return -1

        val leftHeight = balancedCheckHelper(root.left)
        if (leftHeight == Int.MIN_VALUE) return Int.MIN_VALUE

        val rightHeight = balancedCheckHelper(root.right)
        if (rightHeight == Int.MIN_VALUE) return Int.MIN_VALUE

        if (abs(rightHeight - leftHeight) > 1) return Int.MIN_VALUE

        return max(leftHeight, rightHeight) + 1
    }

    fun bstCheck() {
        val root = Tree.getExampleTree1()
        val result = bstCheckHelper(root, Int.MIN_VALUE, Int.MAX_VALUE)
        println(if (result) "BST" else "Not BST")
    }

    private fun bstCheckHelper(root: TreeNode?, min: Int, max: Int): Boolean {

        if (root == null) return true
        if (min >= root.value || root.value >= max) return false

        return bstCheckHelper(root.left, min, root.value) && bstCheckHelper(root.right, root.value, max)
    }
}