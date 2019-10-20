package combinatorics

class NchooseK {

    // The formula for binomial coefficients  C(n, k) = C(n-1, k-1) + C(n-1, k);
    // it can be derived from Pascal triangle
    // From combinatorics  C(n, k) = n! /(n-k)! k!
    fun calcNumberOfCombinations() {
        println(calcNumberOfCombinationsRec(10, 8))
    }

    private fun calcNumberOfCombinationsRec(n: Int, k: Int): Int {

        // Base cases
        if (k == 0 || n == k) {
            return 1
        }

        return calcNumberOfCombinationsRec(n-1, k-1) + calcNumberOfCombinationsRec(n-1, k)
    }

    fun computePascalTriangle() {
        val n = 10
        val k = 2

        val c = Array<Int>(n+1) {0}
        c[0] = 1

        c.forEach { print("$it, ") }
        println()

        for (i in 1..n) {

            for (j in i downTo 1 step 1) {
                c[j] = c[j] + c[j-1]

            }

            c.forEach { print("$it, ") }
            println()
        }

        println("Result: C($n, $k) = ${c[k]}")

    }

}