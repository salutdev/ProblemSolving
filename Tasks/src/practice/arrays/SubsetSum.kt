package practice.arrays

class SubsetSum {
    fun calc() {
        val ar = intArrayOf(4, 3, 5, 8, 6)
        val sum = 25
        val n = ar.size

        val dp = populateDp(n, sum, ar)

        if (dp[n-1][sum]) {
            var s = sum
            var i = n - 1
            var j = sum

            while (j != 0) {
                if (i == 0) {
                    print("${ar[i]} ")
                    j -= ar[i]
                } else {
                    if (dp[i-1][j]) {
                        i--
                    } else {
                        print("${ar[i]} ")
                        j -= ar[i]
                        i--
                    }
                }
            }

        } else {
            println("No sum")
        }
    }

    private fun populateDp(
        n: Int,
        sum: Int,
        ar: IntArray
    ): Array<BooleanArray> {
        val dp = Array(n) { BooleanArray(sum + 1) }

        for (i in 0 until n) {
            for (j in 0..sum) {
                if (j == 0) {
                    dp[i][j] = true
                } else if (i == 0) {
                    dp[i][j] = ar[i] == j
                } else {
                    dp[i][j] = dp[i - 1][j] || (j >= ar[i] && dp[i - 1][j - ar[i]])
                }
            }
        }
        return dp
    }
}