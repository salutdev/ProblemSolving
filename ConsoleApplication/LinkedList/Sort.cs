using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.LinkedList
{
    partial class LinkedList
    {
        public Node Sort(Node head)
        {
            Node middle = FindMiddle(head);

            Node left = head;
            Node right = middle.Next;
            middle.Next = null;
            if (right != null)
            {
                left = Sort(left);
                right = Sort(right);
            }
            else
            {
                return left;
            }

            Node newHead = null;

            if (left.Value < right.Value)
            {
                newHead = left;
                left = left.Next;
            }
            else
            {
                newHead = right;
                right = right.Next;
            }

            Node cur = newHead;

            while (right != null || left != null)
            {
                if (right == null || (left != null && left.Value < right.Value))
                {
                    cur.Next = left;
                    left = left.Next;
                    cur = cur.Next;
                }
                else if (left == null || (right != null && left.Value > right.Value))
                {
                    cur.Next = right;
                    right = right.Next;
                    cur = cur.Next;
                }
            }

            return newHead;
        }

        public Node SortRecursive(Node head)
        {
            if (head == null || head.Next == null)
            {
                return head;
            }

            Node middle = FindMiddle(head);
            Node nextToMiddle = middle.Next;
            middle.Next = null;

            Node left = SortRecursive(head);
            Node right = SortRecursive(nextToMiddle);

            Node sortedList = Merge(left, right);

            return sortedList;
        }

        private Node Merge(Node left, Node right)
        {
            Node result = null;

            if (left == null)
            {
                return right;
            }

            if  (right == null)
            {
                return left;
            }

            if (left.Value < right.Value)
            {
                result = left;
                result.Next = Merge(left.Next, right);
            }
            else
            {
                result = right;
                result.Next = Merge(left, right.Next);
            }

            return result;
        }

        private Node FindMiddle(Node head)
        {
            if (head == null || head.Next == null)
            {
                return head;
            }

            Node slow = head;
            Node fast = head.Next;
            while (fast.Next != null)
            {
                fast = fast.Next;
                slow = slow.Next;
                if (fast.Next != null)
                {
                    fast = fast.Next;
                }
            }

            return slow;
        }


        Node Sort2(Node head)
        {
            if (head == null || head.Next == null)
            {
                return head;
            }

            Node middle = FindMiddle2(head);

            Node nextToMiddle = middle.Next;
            middle.Next = null;

            Node left = Sort2(head);
            Node right = Sort2(nextToMiddle);

            Node result = Merge2(left, right);
            return result;
        }

        Node Merge2(Node left, Node right)
        {
            if (left == null) return right;
            if (right == null) return left;
            Node result = null;
            if (left.Value < right.Value)
            {
                result = left;
                result.Next = Merge2(left.Next, right);
            }
            else
            {
                result = right;
                result.Next = Merge2(left, right.Next);
            }
            return result;
        }
        private Node FindMiddle2(Node head)
        {
            if (head == null || head.Next == null)
            {
                return head;
            }

            Node slow = head;
            Node fast = head.Next;

            while (fast.Next != null)
            {
                fast = fast.Next;
                slow = slow.Next;
                if (fast != null)
                {
                    fast = fast.Next;
                }
            }
            return slow;
        }

    }
}
