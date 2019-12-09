package practice.trees

import trees.model.Tree
import trees.model.TreeNode
import java.lang.Integer.max

class LongestUnivaluePath {

    fun find() {

        val root = Tree.getExampleTree7()
        val result = Result(0)
        getLongestPath(root, result)
        println("Max path is: ${result.maxLenth}")
    }

    data class Result(var maxLenth: Int)

    private fun getLongestPath(root: TreeNode?, result: Result): Int {
        if (root == null) return 0

        val left = getLongestPath(root.left, result)
        val right = getLongestPath(root.right, result)

        var leftWithCurrent = 0
        var rightWithCurrent = 0

        if (root.left != null && root.value == root.left!!.value) {
            leftWithCurrent = left + 1
        }

        if (root.right != null && root.value == root.right!!.value) {
            rightWithCurrent = right + 1
        }

        result.maxLenth = max(result.maxLenth, leftWithCurrent + rightWithCurrent)

        return max(leftWithCurrent, rightWithCurrent)
    }
}