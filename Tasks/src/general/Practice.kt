package general

import trees.Tree
import trees.TreeNode
import kotlin.math.abs
import kotlin.math.max

class Practice {

    fun subset() {
        val array = arrayOf(4, 8, 12)
        val max = 1 shl array.size

        for (i in 0 until max) {

            val combination = getCombination(array, i)
            combination.forEach { print("$it, ")}
            println()
        }
    }

    private fun getCombination(array: Array<Int>, i: Int): List<Int> {
        var k = i
        var index = 0
        val combination = mutableListOf<Int>()
        while(k > 0) {
            if (k and 1 == 1) {
                combination.add(array[index])
            }

            index++
            k = k shr 1
        }

        return combination
    }

    fun commonAncestor() {
        val root = Tree.getExampleTree1()
        val p = getNodeByVal(root,2)
        //val q = getNodeByVal(root,13)

        //val p = TreeNode(4)
        val q = TreeNode(13)

        val result = commonAncestorHelper(root, p, q)
        val resStr = if (result!!.isAncestor) result?.node?.value else "No common ancestor"

        println(resStr)

    }

    private fun commonAncestorHelper(root: TreeNode?, p: TreeNode?, q: TreeNode?): Result? {
        if (root == null) return Result(null, false)
        if (root == p && root == q) return Result(root, true)

        val lRes = commonAncestorHelper(root?.left, p, q)
        if (lRes != null && lRes.isAncestor) return lRes

        val rRes = commonAncestorHelper(root?.right, p, q)
        if (rRes != null && rRes.isAncestor) return rRes

        if (lRes?.node != null && rRes?.node != null) return Result(root, true)

        if (p == root || q == root) {
            return if (lRes?.node != null || rRes?.node != null) Result(root, true) else Result(root, false)
        }

        return if (lRes?.node != null) Result(lRes?.node, false) else Result(rRes?.node, false)
    }

    private fun getNodeByVal(root: TreeNode?, value: Int): TreeNode? {
        if (root == null) return null
        if (root.value == value) return root
        val lNode = getNodeByVal(root.left, value)
        if (lNode != null) return lNode
        return getNodeByVal(root.right, value)
    }

    data class Result(val node: TreeNode?, val isAncestor: Boolean)

    fun commonAncestorInBST() {
        val root = Tree.getExampleTree1()
        val v1 = 20
        val v2 = 13
        var commonAncestor: TreeNode? = null
        var node: TreeNode? = root

        while(node != null) {
            if ((v1 < node.value && v2 > node.value) ||
                (v2 < node.value && v1 > node.value) ||
                node.value == v1 || node.value == v2) {
                commonAncestor = node
                break
            } else if (v1 < node.value && v2 < node.value) {
                node = node.left
            } else if (v1 > node.value && v2 > node.value) {
                node = node.right
            }
        }

        println(commonAncestor?.value)
    }

    fun printAllPermutationsWithDups() {
        var str = "abb"
        val map = buildMap(str)
        println(map)
        val list = mutableListOf<String>()
        getAllPermutationsWithDupsHelper("", str.length, map, list)
        println(list)
    }

    private fun getAllPermutationsWithDupsHelper(prefix: String, remainder: Int, map: HashMap<Char, Int>, list: MutableList<String>) {

        if (remainder == 0) {
            list.add(prefix)
            return
        }

        for (c in map.keys) {
            if (map[c] != 0) {
                map[c] = map[c]!!.plus(-1)
                getAllPermutationsWithDupsHelper(prefix + c, remainder - 1, map, list)
                map[c] = map[c]!!.plus(1)
            }
        }

    }

    private fun buildMap(str: String): HashMap<Char, Int> {
        val map = hashMapOf<Char, Int>() // HashMap<Char, Int>()
        if (str.isEmpty()) return map
        str.forEach { c ->
            if (map.containsKey(c)) {
                map[c] = map[c]!!.plus(1)
            } else {
                map[c] = 1
            }
        }

        return map
    }

    fun printAllPermutations() {
        val str = "aaa"
        val list = getAllPermutations(str)
        for (i in 0 until (list?.count() ?: 0)) {
            print("${list!![i]} ")
        }
    }

    private fun getAllPermutations(str: String?): MutableList<String>? {
        if (str == null) return null
        if (str.isEmpty()) return mutableListOf<String>("")

        val char = str.first()
        val remainder = str.substring(1)
        val list = getAllPermutations(remainder)
        val newList = mutableListOf<String>()
        for (i in 0 until (list?.count() ?: 0)) {
            for (j in 0..remainder.length) {
                val newValue = insertChar(list!![i], char, j)
                newList.add(newValue)
            }
        }
        return newList
    }

    private fun insertChar(str: String, char: Char, pos: Int): String {
        val pref = str.substring(0, pos)
        val suf = str.substring(pos)
        val value = "$pref$char$suf"
        return value
    }

    // Complexity n
    fun balancedCheck() {
        val root = Tree.getExampleTree2()

        val result = balancedCheckHelper(root)

        println(if (result != Int.MIN_VALUE) "Balanced" else "Not Balanced")
    }

    private fun balancedCheckHelper(root: TreeNode?): Int {
        if (root == null) return -1

        val leftHeight = balancedCheckHelper(root.left)
        if (leftHeight == Int.MIN_VALUE) return Int.MIN_VALUE

        val rightHeight = balancedCheckHelper(root.right)
        if (rightHeight == Int.MIN_VALUE) return Int.MIN_VALUE

        if (abs(rightHeight - leftHeight) > 1) return Int.MIN_VALUE

        return max(leftHeight, rightHeight) + 1
    }

    fun bstCheck() {
        val root = Tree.getExampleTree1()
        val result = bstCheckHelper(root, Int.MIN_VALUE, Int.MAX_VALUE)
        println(if (result) "BST" else "Not BST")
    }

    private fun bstCheckHelper(root: TreeNode?, min: Int, max: Int): Boolean {

        if (root == null) return true
        if (min >= root.value || root.value >= max) return false

        return bstCheckHelper(root.left, min, root.value) && bstCheckHelper(root.right, root.value, max)
    }
}