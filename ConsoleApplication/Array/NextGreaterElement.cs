using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Array
{
    class NextGreaterElement
    {
        public void PrintNGE(int[] ar)
        {
            Stack<int> stack = new Stack<int>();
            stack.Push(ar[0]);

            foreach(int a in ar)
            {
                while (stack.Count != 0)
                {
                    int stackEl = stack.Pop();
                    if (stackEl < a)
                    {
                        Console.WriteLine($"{stackEl} - {a}");
                    }
                    else
                    {
                        stack.Push(stackEl);
                        break;
                    }
                }
            }

            while (stack.Count != 0)
            {
                int stackEl = stack.Pop();
                Console.WriteLine($"{stackEl} - -1");
            }
        }
    }
}
