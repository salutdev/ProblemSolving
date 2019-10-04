package dynamic

import kotlin.math.max

class LongestPalindromicSubsequece {

    fun calc() {
        val str = "agbdba"
        val n = str.length
        val dp = Array(n) { i ->  Array(n) { j -> if (i == j) 1 else 0 } }

        for (l in 2..n) {
            for (i in 0..n-l) {
                val j = i + l - 1

                if (str[i] == str[j]) {
                    if (j - i == 1) {
                        dp[i][j] = 2
                    } else {
                        dp[i][j] = 2 + dp[i+1][j-1]
                    }
                } else {
                    dp[i][j] = max(dp[i+1][j], dp[i][j-1])
                }
            }
        }

        println(dp[0][n-1])
    }
}