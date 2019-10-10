package numberTheory

class Extended_Euclidean {
    // a * x + b * y = gcd(x, y)
    // method calculates a, b, gcd(x, y)

    // r(i+1) = r(i-1) - q(i) * r(i)
    // x(i+1) = x(i-1) - q(i) * x(i)
    // y(i+1) = y(i-1) - q(i) * y(i)

    fun calc() {
        val x = 45
        val y = 100

        var r0 = x
        var r1 = y
        var x0 = 1
        var x1 = 0
        var y0 = 0
        var y1 = 1
        var r = -1
        var q = 0

        while (r != 0) {
            q = r0 / r1
            r = r0 - q * r1

            if (r != 0) {
                val x = x0 - x1 * q
                val y = y0 - y1 * q
                r0 = r1
                r1 = r
                x0 = x1
                x1 = x
                y0 = y1
                y1 = y
            }
        }

        println("a = $x1; b = $y1; d = $r1" )
    }
}