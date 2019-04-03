using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.LinkedList
{
    partial class LinkedList
    {
        public Node Reverse(Node head)
        {
            Node prev = null;
            Node cur = head;
            Node next = null;

            while (cur != null)
            {
                next = cur.Next;
                cur.Next = prev;
                prev = cur;
                cur = next;
            }

            return prev;
        }

    }
}
