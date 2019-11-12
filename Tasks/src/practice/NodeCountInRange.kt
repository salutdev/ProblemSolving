package practice

import trees.Tree
import trees.TreeNode

class NodeCountInRange {

    fun calc() {
        val root = Tree.getExampleTree1()
        val min = 1
        val max = 19

        val result = preorder(root, min, max)
        println(result)
    }

    private fun preorder(root: TreeNode?, min: Int, max: Int): Int {
        if (root == null) return 0

        if (root.value in min..max) {
            return 1 + preorder(root.left, min, max) + preorder(root.right, min, max)
        } else if (root.value < min) {
            return preorder(root.right, min, max)
        } else {
            return preorder(root.left, min, max)
        }
    }

}