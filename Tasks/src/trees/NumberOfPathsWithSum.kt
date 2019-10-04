package trees

class NumberOfPathsWithSum {
    fun calc() {
        val root = Tree.getExampleTree1()
        val sum = 20
        val result1 = sumPathCount(root, sum)
        val result2 = sumPathCount2(root, sum)
        println("$result1, $result2")
    }

    // Complexity O ( n log n )
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

    // Complexity O(n)
    private fun sumPathCount2(root: TreeNode?, targetSum: Int): Int {
        return sumPathCountHelper2(root, 0, targetSum, HashMap<Int, Int>())
    }

    private fun sumPathCountHelper2(root: TreeNode?, currentSum: Int, targetSum: Int, hashMap: HashMap<Int, Int>): Int {
        if (root == null) return 0
        val newCurrentSum = currentSum + root.value
        val sum = newCurrentSum - targetSum

        var pathsNum = 0
        if (hashMap.containsKey(sum)) {
            pathsNum = hashMap[sum]!!
        }

        if (newCurrentSum == targetSum) pathsNum++

        addPathSum(hashMap, newCurrentSum, 1)
        val lSum = sumPathCountHelper2(root.left, newCurrentSum, targetSum, hashMap)
        val rSum = sumPathCountHelper2(root.right, newCurrentSum, targetSum, hashMap)
        addPathSum(hashMap, newCurrentSum, -1)
        return lSum + rSum + pathsNum
    }

    private fun addPathSum(hashMap: HashMap<Int, Int>, sum: Int, increment: Int) {
        if (hashMap.containsKey(sum)) {
            val count = hashMap[sum]?.plus(increment)
            hashMap[sum] = hashMap[sum]!! + increment
        } else {
            hashMap[sum] = 1
        }
    }
}