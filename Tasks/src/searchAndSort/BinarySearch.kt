package searchAndSort

class BinarySearch {

    fun find() {
        val ar = arrayOf(1, 3, 16, 20, 31, 44, 58, 69, 71, 83, 94, 101)
        val value = 31
        val index = binarySearch(ar, value)

        if ( index != -1) {
            println ("ar[$index] = ${ar[index]}")
        } else {
            println("No value")
        }
    }

    private fun binarySearch(ar: Array<Int>, value: Int): Int {
        var l = 0
        var r = ar.count() - 1

        while (l <= r) {
            val m = (l + r) / 2
            if (ar[m] == value) return m

            if (ar[m] > value) {
                r = m -1
            } else {
                l = m + 1
            }
        }

        return -1
    }
}