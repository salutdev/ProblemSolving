package trees

class RangeTree {

    var root: RangeTreeNode? = null

    fun calcRanks() {

        val result = Result()
        inorderRankCalc(root, result)
        inorderPrint(root)
    }

    enum class Comparison {
        Less,
        Greater
    }

    fun search(value: Int, comparision: Comparison): RangeTreeNode? {
        return searchRec(value, root, comparision)
    }

    private fun searchRec(value: Int, node: RangeTreeNode?, comparison: Comparison): RangeTreeNode? {
        if (node == null) return null

        var result: RangeTreeNode? = null

        if (node.value < value) {
            result = searchRec(value, node.right, comparison)
        } else if (node.value > value) {
            result = searchRec(value, node.left, comparison)
        } else {
            return node
        }

        if (result == null) {
            if (comparison == Comparison.Greater && node.value > value ||
                comparison == Comparison.Less && node.value < value) {
                result = node
            }
        } else {
            if (comparison == Comparison.Greater && node.value > value && node.value < result.value ||
                comparison == Comparison.Less && node.value < value && node.value > result.value) {
                result = node
            }
        }

        return result
    }

    fun delete(value: Int) {
        deleteRec(root, value)
    }

    private fun deleteRec(root: RangeTreeNode?, value: Int): RangeTreeNode? {
        if (root == null) return null

        if (root.value > value) {
            root.left = deleteRec(root.left, value)
        } else if (root.value < value) {
            root.right = deleteRec(root.right, value)
        } else {

            if (root.left == null) {
                return  root.right
            } else if (root.right == null) {
                return root.left
            }

            val min = findMin(root.right)
            root.value = min
            deleteRec(root.right, min)
        }

        return root
    }

    private fun findMin(root: RangeTreeNode?): Int {
        var min = root!!.value
        var curNode: RangeTreeNode? = root

        while(curNode?.left != null) {
            curNode = curNode.left
            min = curNode!!.value
        }

        return min
    }

    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    private fun insertRec(node: RangeTreeNode?, value: Int): RangeTreeNode {
        if (node == null) return RangeTreeNode(value)
        if (node.value > value) {
            node.left = insertRec(node.left, value)
        } else if (node.value < value) {
            node.right = insertRec(node.right, value)
        }
        return node
    }

    private fun inorderPrint(root: RangeTreeNode?) {
        if (root == null) return
        inorderPrint(root.left)
        print("${root.value}-(${root.rank}), ")
        inorderPrint(root.right)
    }

    private fun inorderRankCalc(root: RangeTreeNode?, result: Result) {
        if (root == null) return
        inorderRankCalc(root.left, result)
        root.rank = result.count
        result.count++
        inorderRankCalc(root.right, result)
    }

    class Result {
        var count: Int = 0
    }

    companion object {

        public fun getExampleTree4(): RangeTreeNode {
            /*                 20
             *              /      \
             *            13        44
             *           /  \      /   \
             *         4      17  25   58
             *        / \    / \
             *       2   8  15 19
             *      / \
 			 *     1   3
             */
            val root = RangeTreeNode(20)
            root.left = RangeTreeNode(13)
            root.right = RangeTreeNode(44)

            root.left?.left = RangeTreeNode(4)
            root.left?.right = RangeTreeNode(17)

            root.left?.left?.left = RangeTreeNode(2)
            root.left?.left?.right = RangeTreeNode(8)

            root.left?.left?.left?.left = RangeTreeNode(1)
            root.left?.left?.left?.right = RangeTreeNode(3)

            root.left?.right?.left = RangeTreeNode(15)
            root.left?.right?.right = RangeTreeNode(19)

            root.right?.left = RangeTreeNode(25)
            root.right?.right = RangeTreeNode(58)

            return root
        }
    }
}