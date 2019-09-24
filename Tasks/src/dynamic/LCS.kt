package dynamic

class LCS {
    companion object {
        fun calc() {
            val str1 = "ab"
            val str2 = "babbc"
            val len = lcs(str1, str2)
            println(len)
        }

        private fun lcs(str1: String, str2: String): Int {
            val m = str1.length
            val n = str2.length

            val dp = Array(m + 1) { Array(n + 1) { 0 } }

            for (i in 1..m) {
                for (j in 1..n) {
                    if (str1[i - 1] == str2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1
                    } else {
                        dp[i][j] = dp[i][j - 1].coerceAtLeast(dp[i - 1][j])
                    }
                }
            }

            return dp[m][n]
        }
    }
}