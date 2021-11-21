from linked_list.linked_list_node import LinkedListNode


class Reverse:
    def calc(self):
        head = LinkedListNode(10)
        head.next = LinkedListNode(15)
        head.next.next = LinkedListNode(20)
        head.next.next.next = LinkedListNode(25)
        head.next.next.next.next = LinkedListNode(30)

        self.print_linked_list(head)

        new_head = self.reverse(head)

        self.print_linked_list(new_head)

    def reverse(self, head):
        prev = None
        cur = head
        next = None

        while cur != None:
             next = cur.next
             cur.next = prev
             prev = cur
             cur = next

        return prev

    def print_linked_list(self, head):
        node = head
        while node != None:
            print (node.value)
            node = node.next
