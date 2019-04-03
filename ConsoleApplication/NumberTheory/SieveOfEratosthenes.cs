using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.NumberTheory
{
    public class SieveOfEratosthenes
    {
        public void Find()
        {
            int n = 10000;
            bool[] nums = new bool[n + 1];

            for (int i = 2; i <= n; i++)
            {
                nums[i] = true;
            }

            for (int i = 2; i*i <= n; i++)
            {
                if (nums[i])
                {
                    for (int j = 2 * i; j <= n; j += i)
                    {
                        nums[j] = false;
                    }
                }

            }

            for (int i = 2; i <= n; i++)
            {
                if (nums[i])
                {
                    Console.Write($"{i} ");
                }
            }

        }
    }
}
