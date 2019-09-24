package dynamic

class LCSubstring {
    companion object {
        fun calc() {
            val str1 = "abbcb"
            val str2 = "babbc"
            val len = lcSubstring(str1, str2)
            println(len)
        }

        private fun lcSubstring(str1: String, str2: String): Int {
            val m = str1.length
            val n = str2.length

            val dp = Array(m + 1) { Array(n + 1) { 0 } }
            var max = 0

            for (i in 1..m) {
                for (j in 1..n) {
                    if (str1[i - 1] == str2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1
                        if (dp[i][j] > max) {
                            max = dp[i][j]
                        }
                    } else {
                        dp[i][j] = 0
                    }
                }
            }

            return max
        }
    }
}