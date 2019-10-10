package trees

class MaxPathSum {

    companion object {
        fun getMaxPathSum() {
            val root = Tree.getExampleTree1()
            val result = Result(Int.MIN_VALUE)
            getMaxPathSum(root, result);
            println(result.value)
        }

        private fun getMaxPathSum(root: TreeNode?, result: Result): Int {
            if (root == null) return 0

            val leftMax = getMaxPathSum(root.left, result)
            val rightMax = getMaxPathSum(root.right, result)
            val singleMax = (leftMax + root.value).coerceAtLeast(rightMax + root.value).coerceAtLeast(root.value)

            result.value = singleMax.coerceAtLeast(leftMax + rightMax + root.value).coerceAtLeast(result.value)

            return singleMax
        }

        //fun max(a: Int, b: Int): Int = if (a > b) a else b

        data class Result(var value: Int)
    }
}