package dynamic

import kotlin.math.max

class LongestPalindromicSubstring {

    // Complexity O(n^2)
    fun calc() {
        val str = "abcdecba"
        val n = str.length
        val dp = Array(n) { i ->  Array(n) { j -> i == j } }

        var maxLength = 1
        for (l in 2..n) {
            for (i in 0..n-l) {
                val j = i + l - 1

                if (str[i] == str[j]) {
                    if (j - i == 1) { // string of length 2
                        dp[i][j] = true
                        maxLength = 2
                    } else {
                        if (dp[i+1][j-1]) {
                            dp[i][j] = true
                             maxLength = l
                        }
                    }
                }
            }
        }

        println(maxLength)
    }

}