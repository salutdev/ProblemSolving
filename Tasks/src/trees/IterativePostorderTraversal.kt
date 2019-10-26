package trees

import java.util.*

class IterativePostorderTraversal {
    fun traverse() {
        val root = Tree.getExampleTree1()
        val stack1 = Stack<TreeNode>()
        val stack2 = Stack<TreeNode>()

        stack1.push(root)

        while (stack1.isNotEmpty()) {
            val treeNode = stack1.pop()
            stack2.push(treeNode)

            if (treeNode.left != null) {
                stack1.push(treeNode.left)
            }

            if (treeNode.right != null) {
                stack1.push(treeNode.right)
            }
        }

        while (stack2.isNotEmpty()) {
            val treeNode = stack2.pop()
            print("${treeNode.value}, ")
        }
    }
}