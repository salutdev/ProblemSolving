using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.LinkedList
{
    public class MergeAtAlternate
    {
        private Node InitList1()
        {
            // 14 -> 10 -> 18 -> 5 -> 4
            Node head = new Node(14);
            head.Next = new Node(10);
            head.Next.Next = new Node(18);
            head.Next.Next.Next = new Node(5);
            head.Next.Next.Next.Next = new Node(4);
            return head;
        }

        private Node InitList2()
        {
            // 19 -> 33 -> 89 -> 88 -> 54 -> 77 -> 99 -> 178 -> 299
            Node head = new Node(19);
            head.Next = new Node(33);
            head.Next.Next = new Node(89);
            head.Next.Next.Next = new Node(88);
            head.Next.Next.Next.Next = new Node(54);
            head.Next.Next.Next.Next.Next = new Node(77);
            head.Next.Next.Next.Next.Next.Next = new Node(99);
            head.Next.Next.Next.Next.Next.Next.Next = new Node(178);
            head.Next.Next.Next.Next.Next.Next.Next.Next = new Node(299);
            return head;
        }

        public void PrintMerged()
        {
            Node list1 = InitList1();
            Node list2 = InitList2();
            Node cur = Merge(list1, list2);
            while (cur != null)
            {
                Console.Write($"{cur.Value} ");
                cur = cur.Next;
            }
        }
        Node Merge(Node list1, Node list2)
        {
            if (list2 == null) return list1;
            if (list1 == null) return list2;

            Node cur1 = list1;
            Node cur2 = list2;
            Node prev1 = cur1;

            while (cur1 != null && cur2 != null)
            {
                Node next1 = cur1.Next;
                cur1.Next = cur2;
                Node next2 = cur2.Next;
                cur2.Next = next1;
                cur1 = next1;
                cur2 = next2;
            }

            return list1;
        }
    }
}
