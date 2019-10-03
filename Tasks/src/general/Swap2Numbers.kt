package general

class Swap2Numbers {
    fun swap() {
        var x = 10
        var y = 5
        println("x = $x, y = $y")

        x = x + y
        y = x - y
        x = x - y
        println("x = $x, y = $y")
    }

    fun swap2() {
        var x = 10
        var y = 5
        println("x = $x, y = $y")

        x = x * y
        y = x / y
        x = x / y
        println("x = $x, y = $y")
    }
}