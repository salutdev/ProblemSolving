package numberTheory

class GCD_Euclidean {
    fun calc() {
        val a = 35
        val b = 49
        val result = gcd1(a, b)
        println(result)
    }

    private fun gcd1(a: Int, b: Int): Int {
        if (a == 0) return b
        return gcd1(b % a, a)
    }

    private fun gcd2(a: Int, b: Int): Int {
        if (a == b) return a
        return if (a > b) gcd2(a - b, b)  else gcd2(a, b - a)
    }
}