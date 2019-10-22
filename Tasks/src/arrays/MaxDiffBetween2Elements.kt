package arrays

/*
* Maximum difference between two elements such that larger element appears after the smaller number
*
* Alternative solution:
* If we first find the difference between the adjacent elements of the array and store all differences
* in an auxiliary array diff[] of size n-1. Now this problems turns into finding the
* maximum contiguous sum subarray of this difference array.
*/
class MaxDiffBetween2Elements {
    fun calc() {
        //val ar = arrayOf(200, 177, 88, 75, 50, 44, 35, 28, 10, 3)
        //val ar = arrayOf(2, 4, 9, 3, 8, 15, 1, 6, 10, 15)
        val ar = arrayOf(80, 2, 6, 3, 100)
        var min = Int.MAX_VALUE
        var minInd = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        var maxInd = Int.MIN_VALUE
        var maxDiff = Int.MIN_VALUE

        var curMin = Int.MAX_VALUE
        var curMinInd = Int.MAX_VALUE
        var curMax = Int.MIN_VALUE
        var curMaxInd = Int.MIN_VALUE
        var curMaxDiff = Int.MIN_VALUE

        ar.forEachIndexed { index, value ->
            if (value < curMin) {
                if (curMaxDiff > maxDiff) {
                    min = curMin
                    minInd = curMinInd
                    max = curMax
                    maxInd = curMaxInd
                    maxDiff = curMaxDiff
                }

                curMin = value
                curMinInd = index
                var curMax = Int.MIN_VALUE
                var curMaxInd = Int.MIN_VALUE
            }

            if (value > curMax) {
                curMax = value
                curMaxInd = index
                curMaxDiff = value - curMin
            }
        }

        if (curMaxDiff > maxDiff) {
            min = curMin
            minInd = curMinInd
            max = curMax
            maxInd = curMaxInd
            maxDiff = curMaxDiff
        }

        println("Min: [${minInd}] = ${min};   Max: [${maxInd}] = ${max}; Max diff: ${maxDiff}")
    }
}