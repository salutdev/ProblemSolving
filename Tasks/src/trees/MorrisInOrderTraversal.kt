package trees

// Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is
// changed to the original key plus sum of all keys greater than the original key in BST.
class MorrisInOrderTraversal {
    fun calc() {
        var root = Tree.getExampleTree1()
        inOrder(root)
        println()
        inOrderCalcBiggerTree(root, Result(0))
        inOrder(root)
        println()

        root = Tree.getExampleTree1()
        morrisInOrder(root)
        println()
        morrisInOrderCalcBiggerTree(root)
        morrisInOrder(root)
    }

    private fun morrisInOrder(root: TreeNode?) {

        if (root == null) return
        var current = root
        var predecessor = current

        while (current != null) {

            if (current.left == null) {
                print("${current.value}, ")
                current = current.right
            } else {
                predecessor = current.left
                while (predecessor?.right != null && predecessor.right != current) {
                    predecessor = predecessor.right
                }

                if (predecessor!!.right == null) {
                    predecessor.right = current
                    current = current.left
                } else {
                    predecessor.right = null
                    print("${current.value}, ")
                    current = current.right
                }
            }
        }
    }

    private fun inOrder(root: TreeNode?) {
        if (root == null) return

        inOrder(root.left)
        print("${root.value}, ")
        inOrder(root.right)
    }

    private fun inOrderCalcBiggerTree(root: TreeNode?, result: Result) {
        if (root == null) return

        inOrderCalcBiggerTree(root.right, result)

        root.value += result.sum
        result.sum = root.value

        inOrderCalcBiggerTree(root.left, result)
    }

    private fun morrisInOrderCalcBiggerTree(root: TreeNode?) {

        if (root == null) return
        var current = root
        var predecessor = current
        var sum = 0

        while (current != null) {

            if (current.right == null) {
                current.value += sum
                sum = current.value
                current = current.left
            } else {
                predecessor = current.right
                while (predecessor?.left != null && predecessor.left != current) {
                    predecessor = predecessor.left
                }

                if (predecessor!!.left == null) {
                    predecessor.left = current
                    current = current.right
                } else {
                    predecessor.left = null
                    current.value += sum
                    sum = current.value
                    current = current.left
                }
            }
        }
    }

    data class Result(var sum: Int)
}