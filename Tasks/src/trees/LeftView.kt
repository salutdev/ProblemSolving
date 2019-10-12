package trees

import kotlin.math.max

class LeftView {
    fun find() {
        val root = Tree.getExampleTree3()
        val map = hashMapOf<Int, TreeNodeWithHd>()
        leftView(root, 0, 0, map)
        map.toSortedMap().values.forEach { node ->
            println("${node.value}")
        }

        val root2 = Tree.getExampleTree1()
        println()
        leftView2(root2, 0)
    }

    private fun leftView(root: TreeNodeWithHd?, level: Int, hDistance: Int, map: HashMap<Int, TreeNodeWithHd>) {
        if (root == null) return
        root.hd = hDistance

        if (!map.containsKey(level)) {
            map[level] = root
        } else if (map[level]!!.hd > hDistance) {
            map[level] = root
        }

        leftView(root.left, level + 1, hDistance - 1, map)
        leftView(root.right, level + 1, hDistance + 1, map)
    }

    var maxLevel = -1
    private fun leftView2(root: TreeNode?, level: Int) {
        if (root == null) return
        if (maxLevel < level) {
            println(root.value)
            maxLevel = level
        }

        leftView2(root.left, level + 1)
        leftView2(root.right, level + 1)
    }
}