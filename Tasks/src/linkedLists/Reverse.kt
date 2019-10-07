package linkedLists

class Reverse {
    fun getRerversedHead() {

        var linkedList = LinkedList.getExample()
        var head = linkedList.head

        val newHead = reverse(head)
        println(newHead?.value)
    }

    private fun reverse(head: LinkedListNode?): LinkedListNode? {

        var prev: LinkedListNode? = null
        var cur: LinkedListNode? = head
        var next: LinkedListNode? = null

        while(cur != null) {
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        }

        return  prev
    }
}