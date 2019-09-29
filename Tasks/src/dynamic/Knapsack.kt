package dynamic

import kotlin.math.max

class Knapsack {
    fun calcMaxValue() {

        // answer 9
        val weights = arrayOf<Int>(1, 3, 4, 5)
        val values = arrayOf<Int>(1, 4, 5, 7)
        val maxWeight = 7

        // answer 220
//        val weights = arrayOf<Int>(10, 20, 30)
//        val values = arrayOf<Int>(60, 100, 120)
//        val maxWeight = 50

        val m = weights.size

        val dp = Array(m) { Array(maxWeight+1) { 0 } }

        for (i in 0 until m) {
            for (j in 0..maxWeight) {
                when {
                    j == 0 -> dp[i][j] = 0
                    i == 0 -> dp[i][j] = if (j < weights[i]) 0 else values[i]
                    else -> dp[i][j] = if (j < weights[i]) dp[i-1][j] else max(dp[i-1][j], values[i] + dp[i-1][j-weights[i]])
                }
            }
        }

        println(dp[m-1][maxWeight])
    }
}