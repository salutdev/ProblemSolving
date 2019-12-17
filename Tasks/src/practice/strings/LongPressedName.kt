package practice.strings

class LongPressedName {

    /*
        Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long
        pressed, and the character will be typed 1 or more times.
        You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name,
        with some characters (possibly none) being long pressed.

        Example 1:

        Input: name = "alex", typed = "aaleex"
        Output: true
        Explanation: 'a' and 'e' in 'alex' were long pressed.
     */
    fun calc() {
        val result = isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz")
        println(result)
    }

    private fun isLongPressedName(name: String, typed: String): Boolean {

        val m = name.length
        val n = typed.length
        var i = 0
        var j = 0

        while(i < m || j < n) {

            if (i < m && j < n && name[i] == typed[j]) {
                i++
                j++
            } else if (i != 0) {
                while (j < n && name[i-1] == typed[j]) {
                    j++
                }

                if (j == n) {
                    return i == m
                } else if (i >= m || name[i] != typed[j]) {
                    return false
                }
            } else {
                return false
            }
        }

        return i == m && j == n
    }
}