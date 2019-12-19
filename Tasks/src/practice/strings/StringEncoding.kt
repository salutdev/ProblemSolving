package practice.strings

// Translate a string "aaaaaaaaaaaabbbcddd" into string "12a3b1c3d" and back
class StringEncoding {
    fun encode() {
        val str = "aaaaaaaaaaaabbbcddd"
        //val str = "a"
        var count = 1
        var resultStr = ""
        val n = str.length

        for(i in 1 until n) {
            if (str[i-1] != str[i]) {
                resultStr = "$resultStr$count${str[i-1]}"
                count = 1
            } else {
                count++
            }
        }

        resultStr = "$resultStr$count${str[n-1]}"

        println("Encoded string is: $resultStr")
    }

    fun decode() {
        val str = "12a3b1c3d"
        val n = str.length
        var num = ""
        var resultStr = ""

        for (i in 0 until n) {
            if (str[i].isDigit()) {
                num += str[i]
            } else {
                val k = num.toInt()

                resultStr += str[i].toString().repeat(k)
                num = ""
            }
        }

        println("Decoded string is: $resultStr")
    }
}