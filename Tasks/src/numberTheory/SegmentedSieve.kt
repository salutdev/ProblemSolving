package numberTheory

import kotlin.math.sqrt

class SegmentedSieve {

    fun calc() {
        val n = 200
        val range = sqrt(n.toDouble()).toInt() + 1
        val primes = simpleSieve(range)
        primes.forEach {e -> print("$e, ")}

        segmentedSieve(primes, range, n)

    }

    private fun segmentedSieve(primes: ArrayList<Int>, range: Int, n: Int) {

        var lo = range + 1
        var hi = lo + range - 1

        while(lo < n) {

            val segPrimes = Array<Boolean>(range) {true}

            for (i in 0 until primes.count()) {

                var first = (lo / primes[i]) * primes[i]
                if (first < lo) first += primes[i]

                for (j in first until hi step primes[i]) {
                    segPrimes[j - lo] = false
                }
            }

            for (i in lo until hi) {
                if (segPrimes[i - lo]) {
                    print("$i, ")
                }
            }

            lo = hi + 1
            hi += range
        }

    }

    private fun simpleSieve(range: Int): ArrayList<Int> {

        val ar = Array<Boolean>(range+1) {true}
        val primes = ArrayList<Int>()

        for (i in 2..sqrt(range.toDouble()).toInt() + 1) {
            if (ar[i]) {
                for (j in 2*i..range step i) {
                    ar[j] = false
                }
            }
        }

        ar.forEachIndexed {i, e -> if (i > 1 && e) primes.add(i) }

        return primes
    }
}