package dynamic

import kotlin.math.pow

// https://www.hackerrank.com/challenges/grid-walking/problem
class GridWalking {
    fun calc() {
        val mod: Int = (10.0.pow(9) + 7.0).toInt()
        val maxMoves = 300
        val maxX = 100
        val n = 5 // 1 <= n <= 10   - number of dimensions
        val m = 200  // 1 <= m <= 300  - number of moves
        var x = arrayOf(31, 64, 13, 10, 65)    // 1 <= x[i] <= D[i]
        x = arrayOf(0, *x)
        var D = arrayOf(33, 77, 40, 27, 95)    // 1 <= D[i] <= 100    - upper limit of the i-th dimension
        D = arrayOf(0, *D)
        //val result = calcMovesInEachDimention(xi, m, 1, di)

        val ways = calcNumberOfMoveNumbers(maxMoves, maxX, mod)
        val nck = calcNCK(maxMoves, mod)
        val dp = calcDP(m, n, ways, x, D, nck, mod)
        val result = dp[n][m]
        println(result)
    }

    private fun calcDP(m: Int, n: Int, ways: Array<Array<Array<Int>>>, x: Array<Int>, D: Array<Int>, nck: Array<Array<Int>>, mod: Int): Array<Array<Int>> {

        val dp = Array(n + 1) {
            Array(m + 1) {0}
        }

        for (j in 1..n) {
            for (k in 0..m) {
                if (k == 0) {
                    dp[j][k] = 1
                } else if (j == 1) {
                    // way[limit][pos][move]
                    dp[j][k] = ways[D[j]][x[j]][k]
                } else {
                    for (i in 0..k) {
                        var temp: Long = (nck[k][i].toLong() * ways[D[j]][x[j]][i]) % mod
                        temp = (temp * dp[j - 1][k - i]) % mod
                        dp[j][k] = (dp[j][k] + temp.toInt()) % mod

                    }
                }
            }
        }

        return dp
    }

    // Calculate binomial coefficients C(n, k)
    private fun calcNCK(maxMoves: Int, mod: Int): Array<Array<Int>> {

        val nck = Array(maxMoves + 1) {
            Array(maxMoves + 1) {0}
        }

        for (i in 0..maxMoves) {
            for (j in 0..i) {
                if (j == 0 || j == i) {
                    nck[i][j] = 1
                } else {
                    nck[i][j] = (nck[i - 1][j] + nck[i - 1][j - 1]) % mod
                }
            }
        }

//        for (i in 0..maxMoves) {
//            for (j in 0..i) {
//                print("${nck[i][j]}  ")
//            }
//            println()
//        }

        return nck
    }

    private fun calcNumberOfMoveNumbers(maxMoves: Int, maxX: Int, mod: Int): Array<Array<Array<Int>>> {

        // way[limit][pos][move]
        val ways = Array<Array<Array<Int>>>(maxX + 1) {limit ->
            Array<Array<Int>>(maxX + 2) { pos ->
                Array<Int>((maxMoves + 1)) { moves -> 0 /*if (moves == 0 && pos != 0 && pos != maxX) 1 else 0*/ }
            }
        }

        for (moves in 0..maxMoves) {
            for (limit in 1..maxX) {
                for (pos in 1..limit) {
                    if (moves == 0) {
                        ways[limit][pos][moves] = 1
                    } else {
                        ways[limit][pos][moves] = (ways[limit][pos - 1][moves - 1] + ways[limit][pos + 1][moves - 1]) % mod
                    }
                }
            }
        }

//        for (limit in 1..maxX) {
//            println("limit = $limit")
//            for (pos in 0..limit+1) {
//                for (moves in 0..maxMoves) {
//                    print("${ways[limit][pos][moves]}, ")
//                }
//                println()
//            }
//            println()
//            println()
//        }

        return ways
    }

    // Not working for larger number of moves
    private fun calcMovesInEachDimention(x: Int, movesRemained: Int, lowBound: Int, upperBound: Int): Int {
        if (movesRemained == 0) return 1

        var lCount = 0
        if (x > lowBound) {
            lCount = calcMovesInEachDimention(x - 1, movesRemained - 1, lowBound, upperBound)
        }

        var rCount = 0
        if (x < upperBound) {
            rCount = calcMovesInEachDimention(x + 1, movesRemained - 1, lowBound, upperBound)
        }

        return lCount + rCount
    }
}