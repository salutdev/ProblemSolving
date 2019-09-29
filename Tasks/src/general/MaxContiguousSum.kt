package general

class MaxContiguousSum {
    fun find() {
        val ar = arrayOf(-2, -3, -8, -5, -3, -2, -8, -5)

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

        println(maxSum)
    }
}