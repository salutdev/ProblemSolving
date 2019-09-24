package searchAndSort

class BinarySearchInRotatedArray {
    companion object {
        fun calc() {
            //val ar = arrayOf<Int>(83, 94, 101, 1, 3, 16, 20, 31, 44, 58, 69, 71)
            val ar = arrayOf<Int>(70, 83, 1, 15)
            val value = 16

            val result = search(ar, value)
            if ( result != -1) {
                println ("ar[$result] = ${ar[result]}")
            } else {
                println("No value")
            }
        }

        private fun search(ar: Array<Int>, value: Int): Int {
            var l = 0
            var r = ar.count() - 1

            while (l <= r) {
                val m = (l + r) / 2
                if (ar[m] == value) return m
                if (ar[m] < ar[r]) {
                    if (ar[m] < value && value <= ar[r]) {
                        l = m + 1
                    }
                    else {
                        r = m - 1
                    }
                } else {
                    if (ar[l] <= value && value < ar[m]) {
                        r = m - 1
                    } else {
                        l = m + 1
                    }
                }
            }

            return -1
        }
    }
}