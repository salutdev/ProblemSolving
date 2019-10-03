package trees

class NumberOfPathsWithSum {
    fun calc() {
        val root = Tree.getExampleTree1()
        val result = sumPathCount(root, 59)
        println(result)
    }

    private fun sumPathCount(root: TreeNode?, targetSum: Int): Int {
        if (root == null) return 0

        val nodeSum = sumPathCountStartedFromSpecificNode(root, 0, targetSum)
        val lSum = sumPathCount(root.left, targetSum)
        val rSum = sumPathCount(root.right, targetSum)

        return lSum + rSum + nodeSum
    }

    private  fun sumPathCountStartedFromSpecificNode(root: TreeNode?, currentSum: Int, targetSum: Int): Int {
        if (root == null) return 0

        val newCurrentSum = currentSum + root.value
        var pathNum = 0
        if (newCurrentSum == targetSum) pathNum = 1

        val lPathNum = sumPathCountStartedFromSpecificNode(root.left, newCurrentSum, targetSum)
        val rPathNum = sumPathCountStartedFromSpecificNode(root.right, newCurrentSum, targetSum)

        return lPathNum + rPathNum + pathNum
    }
}