package numberTheory

class ModuloExponentiation {

    // Find x^y % p
    fun calc() {
        var result = 1
        var x = 50
        var y = 101
        val p = 13

        // Update x if it is more or equal to p
        x %= p

        while (y > 0) {

            if (y and 1 == 1) {
                result = (result * x) % p
            }

            // y is even now
            // y = y/2
            y = y shr 1
            x = (x * x) % p
        }

        println(result)
    }

    // Find x^y % p
    fun calc2() {
        var result = 1
        val x = 50
        val y = 101
        val p = 13

        for (i in 0 until y) {
            result = (result * (x % p)) % p
        }

        println(result)
    }

}