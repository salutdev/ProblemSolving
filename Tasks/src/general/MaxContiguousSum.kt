package general

class MaxContiguousSum {
    fun find() {
        val ar = arrayOf(-2, -3, -8, 5, -3, 2, -3, 7)

        var maxSum = getMaxSumWithAllNegatives(ar)

        println(maxSum)
    }

    private fun getMaxSum(ar: Array<Int>): Int {
        var maxSum = Int.MIN_VALUE
        var curSum = 0

        for (e in ar) {
            curSum += e
            if (curSum < 0) {
                curSum = 0
            } else if (maxSum < curSum) {
                maxSum = curSum
            }
        }
        return maxSum
    }

    private fun getMaxSumWithAllNegatives(ar: Array<Int>): Int {

        var maxSum = Int.MIN_VALUE
        var curSum = 0

        for (e in ar) {
            if (e > maxSum) maxSum = e
            curSum += e
            if (curSum < 0) {
                curSum = 0
            } else if (maxSum < curSum) {
                maxSum = curSum
            }

        }

        return  maxSum
    }
}