package linkedLists

class LinkedList(var head: LinkedListNode?) {

    var last: LinkedListNode? = null

    companion object {
        fun getExample(): LinkedList {
           var head = LinkedListNode(5)
           head.next = LinkedListNode(3)
           head.next?.next = LinkedListNode(1)
           head.next?.next?.next = LinkedListNode(19)
           head.next?.next?.next?.next = LinkedListNode(14)
           head.next?.next?.next?.next?.next = LinkedListNode(6)
           head.next?.next?.next?.next?.next?.next = LinkedListNode(17)
           head.next?.next?.next?.next?.next?.next?.next = LinkedListNode(9)

            return LinkedList(head)
        }
    }
}