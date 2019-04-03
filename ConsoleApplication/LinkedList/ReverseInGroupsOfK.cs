using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.LinkedList
{
    public class ReverseInGroupsOfK
    {
        private Node Push(Node head, int value)
        {
            Node node = new Node(value);
            node.Next = head;
            head = node;
            return head;
        }

        public void Reverse()
        {
            int k = 3;
            Node head = Push(null, 9);
            head = Push(head, 8);
            head = Push(head, 7);
            head = Push(head, 6);
            head = Push(head, 5);
            head = Push(head, 4);
            head = Push(head, 3);
            head = Push(head, 2);
            head = Push(head, 1);
            head = ReverseInGroups(head, k);

            Node cur = head;
            while (cur != null)
            {
                Console.Write($"{cur.Value} ");
                cur = cur.Next;
            }
        }

        Node ReverseInGroups(Node head, int k)
        {
            Node cur = head;
            Node prev = null;
            Node next = null;
            Node prevGroupHead = null;
            Node curGroupHead = head;
            Node curGroupEnd = null;
            int i = 0;

            while (cur != null)
            {
                curGroupHead = cur;

                while (cur != null && i < k)
                {
                    next = cur.Next;
                    cur.Next = prev;
                    prev = cur;
                    cur = next;
                    i++;
                }

                i = 0;
                if (curGroupEnd == null)
                {
                    head = prev;
                }

                if (prevGroupHead != null)
                {
                    prevGroupHead.Next = prev;
                }
                prevGroupHead = curGroupHead;
                curGroupEnd = prev;
                prev = null;
            }
            return head;
        }
    }
}
