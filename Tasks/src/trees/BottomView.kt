package trees

import java.util.*
import kotlin.collections.HashMap

class BottomView {
    fun find() {
        val root: TreeNodeWithHd = Tree.getExampleTree3()
        val queue: Queue<TreeNodeWithHd> = ArrayDeque<TreeNodeWithHd>()
        val map = hashMapOf<Int, TreeNodeWithHd>()
        findBorromView(root, queue, map)

        map.toSortedMap().values.forEach {
            print("${it.value}, ")
        }
    }

    private fun findBorromView(root: TreeNodeWithHd, queue: Queue<TreeNodeWithHd>, map: HashMap<Int, TreeNodeWithHd>) {
        queue.add(root)

        while(queue.isNotEmpty()) {
            val node = queue.remove()
            map[node.hd] = node

            if (node.left != null) {
                node.left?.hd = node.hd - 1
                queue.add(node.left)
            }

            if (node.right != null) {
                node.right?.hd = node.hd + 1
                queue.add(node.right)
            }
        }
    }

}