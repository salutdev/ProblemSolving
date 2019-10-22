package arrays

class StockMultipleBuySell {
    //val ar = arrayOf(200, 177, 88, 75, 50, 44, 35, 28, 10, 3)
    val ar = arrayOf(2, 4, 9, 3, 8, 15, 1, 6, 10, 15, 4, 3)
    //val ar = arrayOf(80, 2, 6, 3, 100)
    //val ar = arrayOf(2, 2, 2, 2, 2, 2)
    val n = ar.size

    fun calc() {

        var i = 0
        var min = Int.MAX_VALUE
        var max = Int.MAX_VALUE
        if (n > 1) {
            while (i < n - 1) {

                while (i < n - 1 && ar[i] >= ar[i + 1]) i++
                min = ar[i]

                if (i < n - 1) {
                    while (i < n - 1 && ar[i] <= ar[i + 1]) i++
                    max = ar[i]
                }

                if (min == Int.MAX_VALUE || max == Int.MAX_VALUE) {
                    println("No transactions")
                } else if (!(min == Int.MIN_VALUE || max == Int.MIN_VALUE)) {
                    println("Min: ${min};   Max: ${max}")
                }
                min = Int.MIN_VALUE
                max = Int.MIN_VALUE
            }
        } else {
            println("No transactions")
        }
    }
}