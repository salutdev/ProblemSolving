package linkedLists

class MergeSort {
    fun mergeSort() {
        var head = LinkedListNode(5)
        head.next = LinkedListNode(3)
        head.next?.next = LinkedListNode(1)
        head.next?.next?.next = LinkedListNode(19)
        head.next?.next?.next?.next = LinkedListNode(14)
        head.next?.next?.next?.next?.next = LinkedListNode(6)
        head.next?.next?.next?.next?.next?.next = LinkedListNode(17)
        head.next?.next?.next?.next?.next?.next?.next = LinkedListNode(9)

        val sortedList = sort(head)
        var node = sortedList
        while(node != null) {
            print("${node.value}, ")
            node = node.next
        }
    }

    fun sort(head: LinkedListNode?): LinkedListNode? {
        if (head == null || head.next == null) return head

        val middle = findMiddle(head)
        val nextToMiddle  = middle?.next
        middle?.next = null

        val lList = sort(head)
        val rList = sort(nextToMiddle)
        val resList = merge(lList, rList)
        return resList
    }

    fun merge(lList:LinkedListNode?, rList:LinkedListNode?): LinkedListNode? {

        if (lList == null) return rList
        if (rList == null) return lList
        //val newHead: LinkedListNode?
        var lNode: LinkedListNode? = lList
        var rNode: LinkedListNode? = rList
        var newNode: LinkedListNode?

        if (lNode!!.value < rNode!!.value) {
            newNode = lNode
            lNode.next = merge(lNode.next, rNode)
        } else {
            newNode = rNode
            rNode.next = merge(lNode, rNode.next)
        }

//        if (lNode!!.value < rNode!!.value) {
//            newHead = lNode
//            lNode = lNode.next
//        } else {
//            newHead = rNode
//            rNode = rNode.next
//        }

//        newNode = newHead

//        while (lNode != null || rNode != null) {
//            if (lNode != null && rNode != null) {
//                if (lNode.value < rNode.value) {
//                    newNode?.next = lNode
//                    lNode = lNode.next
//                    newNode = newNode?.next
//                } else {
//                    newNode?.next = rNode
//                    rNode = rNode.next
//                    newNode = newNode?.next
//                }
//            } else if (lNode != null) {
//                newNode?.next = lNode
//                lNode = lNode.next
//                newNode = newNode?.next
//            } else {
//                newNode?.next = rNode
//                rNode = rNode?.next
//                newNode = newNode?.next
//            }
//        }
        return newNode
    }

    private fun findMiddle(head: LinkedListNode?): LinkedListNode? {
        var slow = head
        var fast = head

        while (fast?.next != null) {
            fast = fast.next
            if (fast?.next != null) {
                fast = fast?.next
                slow = slow?.next
            }
        }

        return slow
    }

    private fun getCount(head: LinkedListNode?): Int {
        var node = head
        var n = 0
        while (node != null) {
            node = node?.next
            n++
        }
        return n
    }
}