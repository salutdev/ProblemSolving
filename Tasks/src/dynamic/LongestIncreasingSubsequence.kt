package dynamic

class LongestIncreasingSubsequence {
    fun calc() {
        val arr = arrayOf(10, 22, 9, 33, 21, 50, 41, 60)
        val n = arr.size
        val lis = Array<Int>(n) {1}

        for (i in 1 until n) {
            for (j in 0 until i) {
                if (arr[j] < arr[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1
                }
            }
        }

        println(lis.max())
    }
}