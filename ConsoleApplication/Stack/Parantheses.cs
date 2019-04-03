using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Stack
{
    public class Parantheses
    {
        public void DetermineCorectness()
        {
            HashSet<char> opening = new HashSet<char>();
            opening.Add('<');
            opening.Add('(');
            opening.Add('{');

            Dictionary<char, char> closing = new Dictionary<char, char>();
            closing.Add('>', '<');
            closing.Add(')', '(');
            closing.Add('}', '{');

            string str = "({s<sdafsa>}gds)<ad>";

            Stack<char> stack = new Stack<char>();
            bool result = true;

            foreach (char c in str)
            {
                if (opening.Contains(c))
                {
                    stack.Push(c);
                }
                else if (closing.ContainsKey(c))
                {
                    if (stack.Count == 0)
                    {
                        result = false;
                    }
                    else
                    {
                        char stackEl = stack.Pop();
                        if (stackEl != closing[c])
                        {
                            result = false;
                        }
                    }
                }
            }

            if (stack.Count != 0)
            {
                result = false;
            }

            Console.WriteLine(result);
        }
    }
}
