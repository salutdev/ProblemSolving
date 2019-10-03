package trees

class SpecificSumExists {
    fun find() {
        val root = Tree.getExampleTree1()
        val result = sumExists(root, 0, 17)
        println(result)
    }

    private fun sumExists(root: TreeNode?, currentSum: Int, targetSum: Int): Boolean {
        if (root == null) return false

        val newCurrentSum = currentSum + root?.value
        if (newCurrentSum == targetSum || root?.value == targetSum) return true

        return  newCurrentSum < targetSum && sumExists(root.left, newCurrentSum, targetSum) ||
                newCurrentSum < targetSum && sumExists(root.right, newCurrentSum, targetSum) ||
                sumExists(root.left, root?.value, targetSum) ||
                sumExists(root.right, root?.value, targetSum)
    }
}