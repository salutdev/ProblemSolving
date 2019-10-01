package bitLogic

class PowerOf2 {
    fun ifPowerOf2() {
        val value = 4096
        val isPowerOf2 = (value != 0) and ((value and (value -1)) == 0)
        println(isPowerOf2)
    }
}