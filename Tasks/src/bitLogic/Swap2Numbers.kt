package bitLogic

class Swap2Numbers {
    fun swap() {
        var x = 10
        var y = 20
        println("x = $x, y = $y")

        x = x xor y
        y = x xor y
        x = x xor y

        println("x = $x, y = $y")
    }
}