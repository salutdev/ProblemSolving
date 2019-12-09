package trees

import trees.model.Tree
import trees.model.TreeNode
import java.util.*

class IterativeInorderTraversal {



    fun traverse() {
        val root = Tree.getExampleTree1()
        val stack = Stack<TreeNode>()

        var current: TreeNode? = root

        while(stack.isNotEmpty() || current != null) {

            while (current != null) {
                stack.push(current)
                current = current.left
            }

            current = stack.pop()
            print("${current.value}, ")
            current = current.right
        }
    }

    fun traverseCustom() {
        val root = Tree.getExampleTree5()
        val stack = Stack<TreeNode>()

        var current: TreeNode? = root
        stack.push(current)

        while(stack.isNotEmpty() || current != null) {
            current = current?.left

            if (current != null) {
                stack.push(current)
            } else {
                while (current == null && stack.isNotEmpty()) {
                    val treeNode = stack.pop()
                    print("${treeNode.value}, ")
                    if (treeNode.right != null) {
                        current = treeNode.right
                        stack.push(current)
                    }
                }
            }
        }
    }
}