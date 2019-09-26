package searchAndSort

class MergeSort {

    fun mergeSort() {
        val ar = arrayOf(20, 31, 3, 69, 16, 101, 1, 58, 71, 3, 94, 8, 44, 54 )
        var l = 0
        var r = ar.count() - 1

        ar.forEach { print("$it, ") }
        println()
        sort(ar, l, r)

        ar.forEach { print("$it, ") }

    }

    private fun sort(ar: Array<Int>, l: Int, r: Int): Array<Int> {

        if (l < r) {
            val m = (l + r) / 2

            sort(ar, l, m)
            sort(ar, m+1, r)

            merge(ar, l, m, r)
        }


        return ar
    }

    private fun merge(ar: Array<Int>, l: Int, m: Int, r: Int) {
        val n1 = m-l+1
        val n2 = r-m

        val lArray = ar.sliceArray(l..m)
        val rArray = ar.sliceArray(m+1..r)

        var indexL = 0
        var indexR = 0

        for (i in l until l+n1+n2) {
            if (indexR == n2  || indexL != n1 && lArray[indexL] < rArray[indexR]) {
                ar[i] = lArray[indexL]
                indexL++
            } else {
                ar[i] = rArray[indexR]
                indexR++
            }
        }
    }
}