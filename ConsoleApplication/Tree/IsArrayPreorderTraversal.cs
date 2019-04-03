using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class IsArrayPreorderTraversal
    {
        public bool Check(int[] ar)
        {
            int root = int.MinValue;
            Stack<int> stack = new Stack<int>();

            foreach (int e in ar)
            {
                if (root > e)
                {
                    return false;
                }

                if (stack.Count != 0 && stack.Peek() < root)
                {
                    root = stack.Pop();
                }

                stack.Push(e);
            }

            return true;
        }
    }
}
