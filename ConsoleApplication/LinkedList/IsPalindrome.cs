using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.LinkedList
{
    public partial class LinkedList
    {
        private Node head;
        private Node left;

        private bool IsPalindromeHelper(Node right)
        {
            if (left == null)
            {
                return true;
            }

            bool result = IsPalindrome(right.Next);
            if (!result)
            {
                return false;
            }

            if (left.Value == right.Value)
            {
                left = left.Next;
                return true;
            }
            else
            {
                return false;
            }
        }

        public bool IsPalindrome(Node head)
        {
            this.head = head;
            left = head;

            bool result = IsPalindromeHelper(head);

            return result;
        }

    }
}
