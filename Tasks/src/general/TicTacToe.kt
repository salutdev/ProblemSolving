package general

class TicTacToe {
	
	val arr: Array<Array<Int>>
	val n: Int
	
	constructor() {
		this.n = 3
		this.arr = arrayOf(arrayOf(1, 2, 1),arrayOf(2, 2, 1),arrayOf(2, 0, 2))
		//val board = Array(n, { IntArray(n) })
	}
	
	fun didSomeOneWin() {
		
		if (didSomeOneWin(this.arr, this.n))
			println("Win")
		else
			println("No Win")
	}
	
	// fun twoDimensionalRx(a:Array<IntArray>){ }
	fun didSomeOneWin(board: Array<Array<Int>>, n: Int): Boolean {
		
		//val cols = arrayOf<Int>(n)
		val cols = Array<Int>(n){0}
		var diag1 = 0
		var diag2 = 0
		
		for (i in 0..n-1) {
			var curLineSum = 0
			for (j in 0..n-1) {
				
				val x = when (board[i][j]) {
					1 -> -1
					2 -> 1
					else -> 0
				}
				
				curLineSum += x
				cols[j] += x
				
				if ((j == n-1 && Math.abs(curLineSum) == n) ||
					(i == n-1 && Math.abs(cols[j]) == n)) return true
				
				if (i == j) diag1 += x
				if (i == n-1 && j == n-1 && Math.abs(diag1) == n) return true
	
				if (i == n-1-j) diag2 += x
				if (i == n-1 && j == 0 && Math.abs(diag2) == n) return true
				
				print("${board[i][j]} ")
				//println("i = ${i}, j = ${j}")
				
			}
			println()
		}
	
		return false
	}
}