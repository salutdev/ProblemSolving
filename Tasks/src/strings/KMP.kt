package strings

class KMP {
    fun findSubstring() {
        val str = "abxabcabcaby"
        val pat = "abcaby"      // patAr = [ 0, 0, 0, 1, 2, 0 ]
        //val pat = "aabaabaaa"      // patAr = [ 0, 1, 0, 1, 2, 3, 4, 5, 2 ]
        val m = str.length
        val n = pat.length

        val patAr = computePatternArray(pat, n)
        val index = findSubstringPosition(str, m, pat, n, patAr)

        println(str)
        println(pat)
        patAr.forEach { print("$it, ") }
        println()
        println("Index: $index")
    }

    // Time complexity O(m+n), space complexity O(m+n)
    private fun findSubstringPosition(str: String, m: Int, pat: String, n: Int, patAr: Array<Int>): Int {

        var i = 0
        var j = 0
        var result = -1

        while (m - i >= n - j && result == -1) {
            if (str[i] == pat[j]) {
                i++
                j++
                if (j == n) result = i - n
            } else {
                if (j == 0) {
                    i++
                }
                else {
                    j = patAr[j - 1]
                }
            }
        }

        return result
    }

    private fun computePatternArray(pat: String, n: Int): Array<Int> {
        val patAr = Array(n) {0}
        var i = 0
        var j = 1

        while (j < n) {

            if (pat[i] == pat[j]) {
                patAr[j] = i + 1
                i++
                j++
            } else {
                if (i == 0) {
                    patAr[j] = 0
                    j++
                } else {
                    i = patAr[i - 1]
                }
            }
        }

        return  patAr
    }
}