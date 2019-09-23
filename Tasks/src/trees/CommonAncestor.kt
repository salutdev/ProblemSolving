package trees

class CommonAncestor {
	
	fun getAncestor() {
		val root = Tree.getExampleTree1()
		
		val node1 = findNode(root, 1)
		val node2 = findNode(root, 58)
		
		val result = getCommonAncestor(root, node1, node2)
		
		println("Common ancestor: " + result.node?.value)
	}

	data class Result(val node: TreeNode?, val isAncestor: Boolean)
	
	private fun getCommonAncestor(root: TreeNode?, a: TreeNode?, b: TreeNode?): Result {
		
		if (root == null) return Result(null, false)
		else if (root == a && root == b) return Result(root, true)
		
		val left = getCommonAncestor(root.left, a, b)
		if (left.isAncestor) return left
		
		val right = getCommonAncestor(root.right, a, b)
		if (right.isAncestor) return right
		
		
		if (left.node != null && right.node != null) return Result(root, true)
		else if (root == a || root == b) {
			val isAncestor = left.node != null || right.node != null
			return Result(root, isAncestor)
		} else {
			return Result(if (left.node != null) left.node else right.node, false)
		}
	}
	
	
	private fun findNode(root: TreeNode?, n: Int): TreeNode? {
		if (root == null || root.value == n) return root
		
		val lResult = findNode(root.left, n)
		if (lResult != null) return lResult
		
		val rResult = findNode(root.right, n)
		return rResult
	}
}