package graphs

import kotlin.math.min

class TravellingSalesman {
    private lateinit var graph: Array<Array<Int>>
    private val n = 4
    private val visited = Array<Boolean>(n) {false}

    fun calc() {

        graph = arrayOf(arrayOf(0, 10, 15, 20),
                        arrayOf(10, 0, 35, 25),
                        arrayOf(15, 35, 0, 30),
                        arrayOf(20, 25, 30, 0))

        visited[0] = true
        var result = tsp(1, 0, 0, Int.MAX_VALUE)
        println(result)
    }

    private fun tsp(count: Int, pos: Int, curCost: Int, ans: Int): Int {

        var curAns = ans
        if (count == n && graph[pos][0] > 0) {
            curAns = min(curAns, curCost + graph[pos][0])
            return curAns
        }

        for (i in 0 until n) {
            if (graph[pos][i] != 0 && !visited[i]) {
                visited[i] = true

                curAns = tsp(count + 1, i, curCost + graph[pos][i], curAns)
                visited[i] = false
            }
        }

        return curAns
    }
}