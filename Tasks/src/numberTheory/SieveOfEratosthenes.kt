package numberTheory

import kotlin.math.sqrt

class SieveOfEratosthenes {
    fun printPrimeNumbers() {
        val n = 100
        val ar = Array<Boolean>(n+1) {true}

        for (i in 2..sqrt(n.toDouble()).toInt()) {
            if (ar[i]) {
                for (j in 2*i..n step i) {
                    ar[j] = false
                }
            }
        }

        ar.forEachIndexed {i, e -> if (i > 1 && e) print("$i, ")}
    }
}