package trees

import java.util.*

class IterativePreorderTraversal {

    fun traverse() {
        val root = Tree.getExampleTree1()
        val stack = Stack<TreeNode>()

        stack.push(root)

        while (stack.isNotEmpty()) {
            val treeNode = stack.pop()
            print("${treeNode?.value}, ")

            if (treeNode.right != null) {
                stack.push(treeNode.right)
            }

            if (treeNode.left != null) {
                stack.push(treeNode.left)
            }

        }
    }
}