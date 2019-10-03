package searchAndSort

class QuickSort {
    fun sort() {
        val ar = arrayOf(101, 1, 31, 3, 69, 16, 1, 58, 71, 3, 94, 8, 44, 54 )
        quickSort(ar, 0, ar.size - 1)
        ar.forEach { print("$it, ") }
    }

    private fun quickSort(ar: Array<Int>, l: Int, r: Int) {
        if (l >= r) return
        val j = partition(ar, l, r)
        quickSort(ar, l, j - 1)
        quickSort(ar, j + 1, r)
    }

    private fun partition(ar: Array<Int>, l: Int, r: Int): Int {
        val pivot = ar[l]

        var i = l + 1
        var j = r
        while (true) {
            while (ar[i] < pivot) {
                i++
                if (i >= r) break
            }
            while (ar[j] > pivot) {
                j--
                if (j <= l) break
            }

            if (i >= j) break
            swap (ar, i, j)
        }

        swap(ar, j, l)
        return j
    }

    private fun swap(ar: Array<Int>, il: Int, ir: Int) {

        val temp = ar[il]
        ar[il] = ar[ir]
        ar[ir] = temp
   }
}