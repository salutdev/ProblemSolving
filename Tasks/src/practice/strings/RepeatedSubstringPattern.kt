package practice.strings

/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple
copies of the substring together. You may assume the given string consists of lowercase English letters only
and its length will not exceed 10000.
*/

class RepeatedSubstringPattern {
    fun calc(): Boolean {

        val s = "abacababacab"
//        val s = "aaaa"
//        val s = "aabaaba"
//        val s = "aabaab"
//        val s = "aba"
//        val s = "abcdabcdabcdabcd"
//        val s = "abab"
//        val s = "abac"
//        val s = "abcd"

        val n = s.length
        if (n in 0..1) return false
        var i = 0
        var j = 1
        val ar = IntArray(n) {0}
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

        val result = (i % matchStartPos == 0) && (i + matchStartPos == n)
        println("result = $result")

        return result
    }
}