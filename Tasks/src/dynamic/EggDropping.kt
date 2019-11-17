package dynamic

import java.lang.Integer.max

class EggDropping {
    fun calc() {
        val n = 2 // n eggs
        val k = 6 // k floors

        val dp = Array(n+1) { Array(k+1) {0} }

        // If there is only 1 floor
        for (i in 1..n) {
            dp[i][1] = 1
        }

        // If there is only 1 egg
        for (j in 1..k) {
            dp[1][j] = j
        }

        for (i in 2..n) {
            for (j in 2..k) {

                dp[i][j] = Int.MAX_VALUE
                for (x in 1..j) {
                    val currentMin = 1 + max(dp[i-1][x-1], dp[i][j-x])
                    if (currentMin < dp[i][j]) {
                        dp[i][j] = currentMin
                    }
                }
            }
        }


        for (i in 0..n) {
            for (j in 0..k) {
                print("${dp[i][j]}   ")
            }
            println()
        }

        println("Number of attempts: ${dp[n][k]}")

    }
}