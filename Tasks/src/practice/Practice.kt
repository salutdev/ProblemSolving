package practice

import trees.model.NaryTree
import trees.model.NaryTreeNode
import trees.model.Tree
import trees.model.TreeNode
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Practice {

    fun getDistanceInNaryTree() {

        val aa = intArrayOf(1, 2)

        val root = NaryTree.getExampleTee()
        val result = getDistance(root, 45, 11)

        if (result != null && result.isResult) {
            println("Distance: ${result.value}")
        } else {
            println("No result")
        }
    }

    private fun getDistance(root: NaryTreeNode?, value1: Int, value2: Int): NaryResult? {
        if (root == null) return NaryResult(0, false)
        if (root.value == value1 && root.value == value2) return NaryResult(0, true)

        var childResult: NaryResult? = null
        var childResult1: NaryResult? = null
        var childResult2: NaryResult? = null
        if (root.children != null) {
            for (child in root.children!!) {
                childResult = getDistance(child, value1, value2)
                if (childResult!!.isResult) return childResult
                if (childResult != null && !childResult.isResult && childResult.value > 0) {
                    if (childResult1 == null) {
                        childResult1 = childResult
                    } else {
                        childResult2 = childResult
                    }
                }
            }
        }

        if (childResult1 != null && childResult2 != null) {
            return NaryResult(childResult1.value + childResult2.value, true)
        }

        if (root.value == value1 || root.value == value2) {
            if (childResult1 != null) {
                return NaryResult(childResult1.value, true)
            } else {
                return NaryResult(1, false)
            }
        }

        if (childResult1 != null) {
            childResult1.value++
            return childResult1
        }

        return NaryResult(0, false)
    }

    class NaryResult (var value: Int, var isResult: Boolean)


    fun topologicalSort()
    {
        val adj = HashMap<Int, ArrayList<Int>>()
        val stack = Stack<Int>()
        val visited = Array<Boolean>(adj.keys.size) { false }
        for (node in adj.keys) {
            topologicalSortReversePostOrder(node, stack, adj, visited)
        }
    }

    private fun topologicalSortReversePostOrder(node: Int,  stack: Stack<Int>, adj: HashMap<Int, ArrayList<Int>>, visited: Array<Boolean>) {

        if (visited[node]) return
        visited[node] = true

        val children = adj[node]!!
        for (child in children) {
            topologicalSortReversePostOrder(child,  stack, adj, visited)
        }

        stack.add(node)
    }

    fun getMaxPathValue(): Int {
        //val g = GetGraph()
        //if (IsCyclePresent(g)) return Int.MAX_VALUE

        val adj = HashMap<Int, ArrayList<Int>>()
        val pathValues = HashMap<Char, Int>()
        val pathValueResult = PathValueResult()

        for (node in adj.keys) {
            pathValueDfs(node, pathValues, adj, pathValueResult)
        }

        return 0
    }

    private fun pathValueDfs(node: Int, pathValues: HashMap<Char, Int>, adj: HashMap<Int, ArrayList<Int>>, pathValueResult: PathValueResult): Boolean {

        // if ( node.status = Status.visited) return true
        // if ( node.status = Status.visiting) return false // cycle
        val char = getChar(node)
        addChar(char, pathValues)
        // node.status = Status.visiting
        val children = adj[node]
        if (children != null && children.count() != 0) {
            for (child in children) {
                pathValueDfs(child, pathValues, adj, pathValueResult)
            }
        } else {
            pathValueResult.value = max(pathValueResult.value, pathValues.values.max()!!)
            removeChar(char, pathValues)
        }

        // node.status = Status.visited
        return true
    }

    private fun addChar(char: Char, pathValues: HashMap<Char, Int>) {
        if (pathValues.containsKey(char)) {
            pathValues[char] = pathValues[char]!! + 1
        } else {
            pathValues[char] = 1
        }
    }

    class PathValueResult {
        var value: Int = Int.MIN_VALUE
    }

    private fun removeChar(char: Char, pathValues: HashMap<Char, Int>) {
        if (pathValues.containsKey(char)) {
            pathValues[char] = pathValues[char]!! - 1
        }
    }

    fun getChar(value: Int): Char {
        return 'a'
    }

    fun commonAncestor2() {
        var root = Tree.getExampleTree1()
        val node1 = getNodeByVal(root, 4)
        val node2 = getNodeByVal(root, 17)

        val result = commonAncestorRec(root, node1, node2)

    }

    private fun commonAncestorRec(root: TreeNode?, p: TreeNode?, q: TreeNode?): Result {

        if (root == null) return Result(null, false)
        if (root == p && root == q) return Result(root, true)

        val lResult = commonAncestorRec(root.left, p, q)
        if (lResult != null && lResult.isAncestor) return lResult

        val rResult = commonAncestorRec(root.right, p, q)
        if (rResult != null && rResult.isAncestor) return rResult

        if (lResult.node != null && rResult.node != null) return Result(root, true)

        if (p == root || q == root) {
            return if (lResult.node != null || rResult.node != null) Result(root, true)
                   else Result(root, false)
        }

        return if (lResult.node != null)  Result(lResult.node, false)
               else Result(rResult.node, false)
    }

    fun balancedCheck2() {
        val root = Tree.getExampleTree6()
        val result = balancedCheckRec2(root)
        println(if (result != Int.MAX_VALUE) "Balanced" else "Not balanced")
    }

    private fun balancedCheckRec2(root: TreeNode?): Int {
        if (root == null) return 0

        val lHeight = balancedCheckRec2(root.left)
        if (lHeight == Int.MAX_VALUE) return Int.MAX_VALUE

        val rHeight = balancedCheckRec2(root.right)
        if (rHeight == Int.MAX_VALUE) return Int.MAX_VALUE

        if (abs(rHeight - lHeight) > 1) return Int.MAX_VALUE

        return max(lHeight, rHeight) + 1
    }

    fun minHeightOfBinaryTree() {
        val root = Tree.getExampleTree5()
        println(minHeight(root))
    }

    private fun minHeight(root: TreeNode?): Int {

        if (root == null) return -1
        if (root.left == null && root.right == null) return 0

        var lHeight = 0
        var rHeight = 0
        if (root.left == null) rHeight = minHeight(root.right)
        else if (root.left == null) lHeight = minHeight(root.left)
        else {
            rHeight = minHeight(root.right)
            lHeight = minHeight(root.left)
        }

        return min(lHeight, rHeight) + 1
    }

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
            return if (lRes?.node != null || rRes?.node != null) Result(
                root,
                true
            ) else Result(root, false)
        }

        return if (lRes?.node != null) Result(
            lRes?.node,
            false
        ) else Result(rRes?.node, false)
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