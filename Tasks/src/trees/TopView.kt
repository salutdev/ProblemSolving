package trees

import java.util.*
import kotlin.collections.HashMap

class TopView {
    fun find() {
        val root = Tree.getExampleTree3()
        //val queue = LinkedList<Int>()
        val queue: Queue<TreeNodeWithHd> = ArrayDeque<TreeNodeWithHd>()
        val map = hashMapOf<Int, TreeNodeWithHd>()

        traverse(root, map, queue)

        map.values.forEach {
            print("${it.value}, ")
        }
    }

    private fun traverse(root: TreeNodeWithHd, map: HashMap<Int, TreeNodeWithHd>, queue: Queue<TreeNodeWithHd>) {

        queue.add(root)

        while(queue.isNotEmpty()) {
            val node: TreeNodeWithHd = queue.remove()
            val hd = node.hd
            if (!map.containsKey(hd)) {
                map[hd] = node
            }

            if (node?.left != null) {
                node?.left?.hd = hd - 1
                queue.add(node?.left)
            }

            if (node?.right != null) {
                node?.right?.hd = hd + 1
                queue.add(node?.right)
            }
        }
    }

}