package general

import trees.Tree
import trees.TreeNode
import kotlin.math.abs
import kotlin.math.max

class Practice {

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