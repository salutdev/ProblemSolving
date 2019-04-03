using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.LinkedList
{
    public partial class LinkedList
    {
        public Node InitLinkedList()
        {
            // 14 -> 10 -> 18 -> 5 -> 4
            Node head = new Node(14);
            head.Next = new Node(10);
            head.Next.Next = new Node(18);
            head.Next.Next.Next = new Node(5);
            head.Next.Next.Next.Next = new Node(4);
            return head;
        }

        public void PrintLinkedList(Node head)
        {
            Node cur = head;
            while (cur != null)
            {
                Console.Write(cur.Value + " -> ");
                cur = cur.Next;
            }
        }
    }
}
