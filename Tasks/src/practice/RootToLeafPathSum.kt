package practice

import trees.Tree
import trees.TreeNode

class RootToLeafPathSum {
/*
Given a binary tree, where every node value is a number. Find the sum of all the numbers which are formed from root to leaf paths.

For example consider the following Binary Tree.


           6
         /   \
        3     5
      /   \     \
     2     5     4
         /  \
        7    4


There are 4 leaves, hence 4 root to leaf paths:
  Path                      Number
  6->3->2                   600+30+2=632
  6->3->5->7                6000+300+50+7=6357
  6->3->5->4                6000+300+50+4=6354
  6->5>4                    600+50+4=654
Answer = 632 + 6357 + 6354 + 654 = 13997

*/

    fun calc() {
        val root = Tree.getExampleTree5()
        val result = traverse(root, 0)
        println(result)
    }

    private fun traverse(root: TreeNode?, parentVal: Int): Int {
        if (root == null) return 0
        val curVal = parentVal * 10 + root.value

        if (root.left == null && root.right == null) return curVal

        if (root.left == null) {
            return traverse(root.right, curVal)
        } else if (root.right == null) {
            return traverse(root.left, curVal)
        }

        return traverse(root.left, curVal) + traverse(root.right, curVal)
    }
}