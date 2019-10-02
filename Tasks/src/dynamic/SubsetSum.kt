package dynamic

class SubsetSum {
    fun isSumPossible() {
        val ar = arrayOf(2, 3, 7, 8, 10)
        val sum = 11
        val m = ar.size

        val dp = Array(m) { Array(sum+1) { true } }

        for (i in 0 until m) {
            for (j in 1..sum) {
                if (i == 0) {
                    if (ar[i] != j) dp[i][j] = false
                } else {
                    if (dp[i-1][j]) dp[i][j] = true
                    else if (ar[i] <= j) {
                        dp[i][j] = dp[i-1][j-ar[i]]
                    } else dp[i][j] = false
                }
            }
        }

        println(dp[m-1][sum])
    }
}