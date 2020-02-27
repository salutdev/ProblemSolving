package practice.graphs

import java.util.*

// Updates are happening each day 1 step to each machine neighbour (up, down, left and right)
// Initially only machines designated with 1 have updates. And 0-s are machines that don't have update before the 1st day.
// How many days are needed to spread updates to each machine ?
class Update {

    data class Point(val i: Int, val j: Int)

    // Time complexity  O(m * n * (E + V)
    // V is m * n
    // E is m * (n - 1) + n * (m - 1)
    // Overall time complexity: m * n * (n * m - m + n * m - n + m * n) -> O (m ^ 2 * n ^ 2)
    fun calc() {
        val board = arrayOf(intArrayOf(0, 0, 0, 0),
                            intArrayOf(0, 1, 0, 0),
                            intArrayOf(0, 0, 1, 0),
                            intArrayOf(1, 0, 0, 0)
            )

        val m = 4
        val n = 4

        board.forEachIndexed() { i, ar ->
            ar.forEachIndexed() { j, e ->
                board[i][j] -= 1
            }
        }

        printBoard(board)

        board.forEachIndexed { i, ar ->
            ar.forEachIndexed { j, e ->
                if (board[i][j] == 0) {
                    val visited = Array<BooleanArray>(m) { BooleanArray(n) { false } }
                    val queue = LinkedList<Point>()
                    queue.addLast(Point(i, j))
                    bfs(m, n, board, visited, queue)
                    printBoard(board)
                }
            }
        }
    }

    private fun bfs(m: Int, n: Int, board: Array<IntArray>, visited: Array<BooleanArray>, queue: LinkedList<Point>) {

        while (queue.isNotEmpty()) {
            val point = queue.removeFirst()
            val i = point.i
            val j = point.j
            visited[point.i][point.j] = true
            addPoint(i - 1, j, m, n, board, visited, queue, board[i][j] + 1)
            addPoint(i + 1, j, m, n, board, visited, queue, board[i][j] + 1)
            addPoint(i, j - 1, m, n, board, visited, queue, board[i][j] + 1)
            addPoint(i, j + 1, m, n, board, visited, queue, board[i][j] + 1)
        }
    }

    private fun addPoint(i: Int, j: Int, m: Int, n: Int, board: Array<IntArray>, visited: Array<BooleanArray>, queue: LinkedList<Point>, newValue: Int) {
        if (i in 0 until m && j in 0 until n && !visited[i][j] && board[i][j] != 0 && (board[i][j] == -1 || board[i][j] > newValue)) {
            board[i][j] = newValue
            queue.addLast(Point(i, j))
        }
    }

    private fun printBoard(board: Array<IntArray>) {
        board.forEach() { ar ->
            ar.forEach() { e ->
                print("$e ")
            }
            println()
        }

        println()
    }

}