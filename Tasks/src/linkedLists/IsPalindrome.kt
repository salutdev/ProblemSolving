package linkedLists

class IsPalindrome {
    fun check() {
        val linkedList = LinkedList.getExample2()
        val reversedHead = cloneAndReverse(linkedList?.head)
        val result = isPalindrome(linkedList?.head, reversedHead)

        println(result)
    }

    private fun isPalindrome(head: LinkedListNode?, revHead: LinkedListNode?): Boolean {
        if (head == null && revHead == null) return true

        var node = head
        var revNode = revHead

        while (node != null && revNode != null ) {
            if (node.value != revNode.value) return false
            node = node.next
            revNode = revNode.next
        }

        return true
    }

    private fun cloneAndReverse(head: LinkedListNode?): LinkedListNode? {

        var node = head
        var newHead: LinkedListNode? = null

        while(node != null) {
            val newNode = LinkedListNode(node.value)
            newNode.next = newHead
            newHead = newNode

            node = node?.next
        }

        return newHead
    }
}