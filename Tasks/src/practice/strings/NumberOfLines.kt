package practice.strings

/*
* Given a long string (words & spaces) and a document width (# of characters), return the number of lines the document
* will have. We can't split words, so that means a word goes to the new line if the entire word cannot fit in the current line.
* */
class NumberOfLines {
    fun calc() {
        val d = 3
        val str = "adb daa" // dsfoeds asdfsdf adfsad dslfk"
        var curBoundary = 0
        var curLineNo = 0
        var curWidth = 0
        var i = 0
        val n = str.length

        while (n > 0 && i < str.length) {
            if (str[i] == ' ') {
                if (curWidth != 0) {
                    if (curWidth == d || curWidth == d - 1) {
                        curLineNo++
                        curWidth = 0
                        i++
                    } else if (curWidth < d) {
                        curBoundary = curWidth
                        curWidth++
                        i++
                    } else {
                        curLineNo++
                        curWidth = curWidth - curBoundary - 1
                    }
                } else {
                    i++
                }
            } else {
                curWidth++
                i++
            }
        }

        if (curWidth > d) {
            curLineNo += 2
        } else if (curWidth != 0) {
            curLineNo++
        }

        println("Number of lines: $curLineNo")
    }
}