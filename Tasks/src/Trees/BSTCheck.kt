package Trees

class BSTCheck {
	
	fun check() {
		
		val root: TreeNode = Tree().getExampleTree1()
		val n = getNumberOfNodesPostorder(root)
		var ar = Array<Int>(n, { i -> 0 })  // arrayOf<Int>(12, 12 ,12)
		ar[0] = 10
		
		println(n)
		
		if (isBstWithLimits(root, null, null)) {
			println("BST")
		} else {
			println("Not BST")
		}

//		for (i in 1..n-1) {
//			if (ar[i-1] > ar[i]) {
//				println("Not BST")
//				return
//			}
//			print(ar[i].toString() + " ")
//		}
		
	}
	
	data class Values(var prev: Int)
	
	private fun isBstWithLimits(root: TreeNode?, min: Int?, max: Int?): Boolean {
		if (root == null) return true
		if ((min != null && min > root.value) || (max != null && max < root.value)) return false
		
		if (!isBstWithLimits(root.left, min, root.value)) return false
		if (!isBstWithLimits(root.right, root.value, max)) return false
	
		return true
	}
	
	var prev: Int? = null
	private fun inorderWithPrevValueIsBst(root: TreeNode?): Boolean {
		if (root == null) return true
		if (!inorderWithPrevValueIsBst(root.left)) return false
		if (prev != null && prev!! > root.value) {
			return false
		} else {
			prev = root.value
		}
		if (!inorderWithPrevValueIsBst(root.right)) return false
		return true
	}
	
	var index: Int = 0
	private fun inorderWithArray(root: TreeNode?, ar: Array<Int>) {
		if (root == null) return
		inorderWithArray(root.left, ar)
		ar[index] = root.value
		index++
		inorderWithArray(root.right, ar)
	}
	
	// Quantity of elements
	private fun getNumberOfNodesPostorder(root: TreeNode?): Int {
		if (root == null) return 0
		var l = getNumberOfNodesPostorder(root.left)
		var r = getNumberOfNodesPostorder(root.right)
		return l + r + 1
	}
}