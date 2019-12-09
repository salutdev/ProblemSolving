package practice.strings

/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple
copies of the substring together. You may assume the given string consists of lowercase English letters only
and its length will not exceed 10000.
*/

class RepeatedSubstringPattern {

    fun calc() {

//        val s = "abacababacab"
//        val s = "aaaa"
//        val s = "aabaaba"
//        val s = "aabaab"
//        val s = "aba"
//        val s = "abcdabcdabcdabcd"
//        val s = "abab"
//        val s = "abac"
        val s = "abcd"

        var result = KMP(s)
        println("KMP result = $result")

        result = shortSolution(s)
        println("ShortSolution result = $result")

    }

    private fun shortSolution(s: String): Boolean {
        val n = s.length
        val newStr = (s + s).substring(1, 2 * n - 1)
        return newStr.indexOf(s) != -1
    }

    // KMP solution
    private fun KMP(s: String): Boolean {

        val n = s.length
        if (n in 0..1) return false
        var i = 0
        var j = 1
        val ar = IntArray(n)
        var matchStartPos = -1

        while (j < n) {

            if (s[i] == s[j]) {
                ar[j] = i + 1
                if (matchStartPos < 1) {
                    matchStartPos = j
                }
                i++
                j++
            } else {
                if (i == 0) {
                    ar[j] = 0
                    matchStartPos = -1
                    j++
                } else {
                    matchStartPos = j - ar[i - 1]
                    i = ar[i - 1]
                }
            }
        }

        return (i % matchStartPos == 0) && (i + matchStartPos == n)
    }
}