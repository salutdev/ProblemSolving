package dynamic

class EditDistance {

    companion object {
        fun calc() {
            val str1 = "abc"
            val str2 = "abcd"
            val ed = editDistance(str1, str2)
            println(ed)
        }

        private fun editDistance(str1: String, str2: String): Int {
            val m = str1.length
            val n = str2.length
            val dp = Array(m+1) { Array(n+1) {0} }

            for (i in 0..m) {
                dp[i][0] = i
            }

            for (j in 0..n) {
                dp[0][j] = j
            }

            for (i in 1..m) {
                for (j in 1..n) {
                    if (str1[i - 1] == str2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1]
                    } else {
                        dp[i][j] = dp[i - 1][j - 1].coerceAtMost(dp[i][j - 1]).coerceAtMost(dp[i - 1][j]) + 1
                    }
                }
            }

            return dp[m][n]
        }
    }
}