package trees

import java.util.*

class IterativePostorderTraversalWithOneStack {

    fun traverse() {
        val root = Tree.getExampleTree2()
        val stack = Stack<TreeNode>()

        stack.push(root)
        var current: TreeNode? = root

        while (current != null || stack.isNotEmpty()) {

            current = current?.left

            if (current == null) {

                var treeNode = stack.peek()
                if (treeNode.right == null) {
                    while (current == null && stack.isNotEmpty()) {
                        treeNode = stack.pop()
                        print("${treeNode.value}, ")
                        if (stack.isNotEmpty()) {
                            val parent = stack.peek()
                            if (parent.left == treeNode) {
                                current = parent.right
                                stack.push(current)
                            }
                        }
                    }

                } else {
                    current = treeNode?.right
                    stack.push(current)
                }
            } else {
                stack.push(current)
            }
        }


    }
}