package practice

class Boggle {


    fun calc() {
        val dictionary = hashSetOf("GEEKS", "FOR", "QUIZ", "GO")

        val chars = arrayOf(arrayOf('G','I','Z'),
                         arrayOf('U','E','K'),
                         arrayOf('Q','S','E'))

        val m = chars.size
        val n = chars[0].size

        val visited = Array<Array<Boolean>>(m) { Array<Boolean>(n) { false } }

        for (i in 0 until m) {
            for (j in 0 until n) {
                traverse("", i, j, dictionary, chars, visited, m, n)
            }
        }
    }

    private fun traverse(curWord: String, i: Int, j: Int, dictionary: HashSet<String>, chars: Array<Array<Char>>, visited: Array<Array<Boolean>>, m: Int, n: Int) {

        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return

        var curStr = curWord + chars[i][j]
        if (dictionary.contains(curStr)) {
            println(curStr)
        }

        visited[i][j] = true
        traverse(curStr, i - 1, j, dictionary, chars, visited, m, n)
        traverse(curStr, i - 1, j + 1, dictionary, chars, visited, m, n)
        traverse(curStr, i, j + 1, dictionary, chars, visited, m, n)
        traverse(curStr, i + 1, j + 1, dictionary, chars, visited, m, n)
        traverse(curStr, i + 1, j, dictionary, chars, visited, m, n)
        traverse(curStr, i + 1, j - 1, dictionary, chars, visited, m, n)
        traverse(curStr, i, j - 1, dictionary, chars, visited, m, n)
        traverse(curStr, i - 1, j - 1, dictionary, chars, visited, m, n)
        visited[i][j] = false
    }
}
