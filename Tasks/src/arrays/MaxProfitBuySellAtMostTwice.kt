package arrays

import java.lang.Integer.max

// Maximum profit by buying and selling a share at most twice
class MaxProfitBuySellAtMostTwice {
    fun calc() {

        //val price = arrayOf(10, 22, 5, 75, 65, 80)
        /*
            Output:  87
            Trader earns 87 as sum of 12 and 75
            Buy at price 10, sell at 22, buy at 5 and sell at 80
        */

        val price = arrayOf(2, 30, 15, 10, 8, 25, 80)
        /*
            Output:  100
            Trader earns 100 as sum of 28 and 72
            Buy at price 2, sell at 30, buy at 8 and sell at 80
        */

        //val price = arrayOf(100, 30, 15, 10, 8, 25, 80)
        /*
            Output:  72
            Buy at price 8 and sell at 80.
        */

        //val price = arrayOf(90, 80, 70, 60, 50)
        /*
            Output:  0
            Not possible to earn.
        */

        val n = price.size
        val profit = Array<Int>(n) {0}
        var maxPrice = price[n-1]

        for (i in n-2 downTo 0) {
            if (price[i] > maxPrice) maxPrice = price[i]

            profit[i] = max(profit[i+1], maxPrice - price[i])
        }

        var minPrice = price[0]

        for (i in 1 until n) {
            if (price[i] < minPrice) minPrice = price[i]

            profit[i] = max(profit[i-1], profit[i] + (price[i] - minPrice))
        }

        profit.forEach { print("$it, ") }
        println()
        println("Max profit: ${profit[n-1]}")
    }
}