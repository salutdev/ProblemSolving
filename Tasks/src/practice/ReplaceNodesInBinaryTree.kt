package practice

import trees.model.Tree
import trees.model.TreeNode

class ReplaceNodesInBinaryTree {

    /*

Replace each node in binary tree with the sum of its inorder predecessor and successor
Given a binary tree containing n nodes. The problem is to replace each node in the binary
tree with the sum of its inorder predecessor and inorder successor.

https://www.geeksforgeeks.org/replace-node-binary-tree-sum-inorder-predecessor-successor/

Input :          1
               /   \
              2     3
            /  \  /  \
           4   5  6   7

Output :        11
              /    \
             9      13
            / \    /  \
           2   3   4   3

For 1:
Inorder predecessor = 5
Inorder successor  = 6
Sum = 11

For 4:
Inorder predecessor = 0
(as inorder predecessor is not present)
Inorder successor  = 2
Sum = 2

For 7:
Inorder predecessor = 3
Inorder successor  = 0
(as inorder successor is not present)
Sum = 3

    * */

    var index = 1
    fun calc() {
        val root = Tree.getExampleTree6()
        val n = 7
        val ar = Array<Int>(n+2) {0}
        val ar2 = Array<Int>(n) {0}

        inorder(root, ar)
        ar.forEach { print("$it, ") }
        for (i in 1..n) {
            ar2[i-1] = ar[i-1] + ar[i+1]
        }

        println()
        ar2.forEach { print("$it, ") }

        index = 0
        inorderWithReplacement(root, ar2)
    }

    private fun inorderWithReplacement(root: TreeNode?, ar: Array<Int>) {
        if (root == null) return
        inorderWithReplacement(root.left, ar)

         root.value = ar[index]
         index++

        inorderWithReplacement(root.right, ar)
    }

    private fun inorder(root: TreeNode?, ar: Array<Int>) {
        if (root == null) return
        inorder(root.left, ar)

        ar[index] = root.value
        index++

        inorder(root.right, ar)
    }

}