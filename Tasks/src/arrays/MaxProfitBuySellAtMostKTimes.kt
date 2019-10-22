package arrays

import java.lang.Integer.max

class MaxProfitBuySellAtMostKTimes {
    fun calc() {

//        val price = arrayOf(10, 22, 5, 75, 65, 80)
//        val k = 2
        /*
                K = 2
            Output:  87
            Trader earns 87 as sum of 12 and 75
            Buy at price 10, sell at 22, buy at
            5 and sell at 80
        */

//        val price = arrayOf(12, 14, 17, 10, 14, 13, 12, 15)
//        val k = 3
        /*
                K = 3
            Output:  12
            Trader earns 12 as the sum of 5, 4 and 3
            Buy at price 12, sell at 17, buy at 10
            and sell at 14 and buy at 12 and sell
            at 15
        */

//        val price = arrayOf(100, 30, 15, 10, 8, 25, 80)
//        val k = 3
        /*
                K = 3
            Output:  72
            Only one transaction. Buy at price 8
            and sell at 80.
        */

//        val price = arrayOf(90, 80, 70, 60, 50)
//        val k = 1
        /*
                K = 1
            Output:  0
            Not possible to earn.
        */

        val price = arrayOf(2, 5, 7, 1, 4, 3, 1, 3)
        val k = 3
        /*
            Ouput: 10
        */
        val result = calcOptimized(price, k)
        println(result)
    }

    private fun calcOptimized(price: Array<Int>, k: Int): Int {
        val n = price.size
        val dp = Array(k + 1) {Array(n) {0}}

        for (i in 1..k) {
            var maxDiff = Int.MIN_VALUE
            for (j in 1 until n) {
                maxDiff = max(maxDiff, dp[i-1][j-1] - price[j-1])
                dp[i][j] = max(dp[i][j-1], price[j] + maxDiff)
            }
        }

        return dp[k][n-1]
    }

    private fun calcNotOptimized(price: Array<Int>, k: Int): Int {
        val n = price.size
        val dp = Array(k + 1) {Array(n) {0}}

        for (i in 1..k) {
            for (j in 1 until n) {
                var maxVal = Int.MIN_VALUE
                for (m in 0 until j) {
                    maxVal = max(maxVal, price[j] - price[m] + dp[i-1][m])
                }

                dp[i][j] = max(maxVal, dp[i][j-1])
            }
        }

        return dp[k][n-1]
    }
}