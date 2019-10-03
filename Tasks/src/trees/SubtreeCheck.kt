package trees

class SubtreeCheck {

    fun check() {
        val t1 = Tree.getExampleTree1()
        val t2 = Tree.getExampleTree4()

        var result = false
        if (t2 == null) {
            result = true
        } else {
            result = subtreeCheck(t1, t2)
        }

        println(result)
    }

    private fun subtreeCheck(t1: TreeNode?, t2: TreeNode?): Boolean {

        if (t1 == null) {
            return false
        } else if (t1?.value == t2?.value && isSubtree(t1, t2)) {
            return true
        }

        return subtreeCheck(t1?.left, t2) || subtreeCheck(t1?.right, t2)
    }

    private fun isSubtree(t1: TreeNode?, t2: TreeNode?): Boolean {
        if (t1 == null && t2 == null) {
            return true
        } else if (t1 == null || t2 == null) {
            return false
        } else if (t1.value == t2.value) {
            return  isSubtree(t1.left, t2.left) && isSubtree(t1.right, t2.right)
        }

        return false
    }
}