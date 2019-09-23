package Trees

class BalancedCheck {
	
	fun isTeeBalanced() {
		val root = Tree.getExampleTree2()
		val result = checkBalanced(root)
		println(if (result != Int.MIN_VALUE) "Balanced" else "Not balanced")
	}
	
	fun checkBalanced(root: TreeNode?): Int {
		
		if (root == null) return -1
		
		val leftHeight = checkBalanced(root.left)
		if (leftHeight == Int.MIN_VALUE) return Int. MIN_VALUE
		
		val rightHeight = checkBalanced(root.right)
		if (rightHeight == Int.MIN_VALUE) return Int. MIN_VALUE
		
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return Int.MIN_VALUE
		} else {
			return Math.max(leftHeight, rightHeight) + 1
		}
	}
	
	fun isTeeBalanced2() {
		val root = Tree.getExampleTree2()
		println(if (isBalanced2(root)) "Balanced" else "Not balanced")
	}
	
	fun isBalanced2(root: TreeNode?): Boolean {
		
		if (root == null) {
			return true
		}
		
		val leftHeight = getHeight2(root.left)
		val rightHeight = getHeight2(root.right)
		
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return false
		}
		
		return isBalanced2(root.left) && isBalanced2(root.right)
	}
	
	private fun getHeight2(root: TreeNode?): Int {
		
		if (root == null) return -1
		
		val leftHeight = getHeight2(root.left)
		val rightHeight = getHeight2(root.right)
		return Math.max(leftHeight, rightHeight) + 1
	}
}