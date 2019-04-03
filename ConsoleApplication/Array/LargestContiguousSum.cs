using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Array
{
    public class LargestContiguousSum
    {
        public int GetLargestContiguousSum(int[] a)
        {
            int sum = 0;
            int maxSum = int.MinValue;

            for (int i = 0; i < a.Length; i++)
            {
                sum += a[i];

                if (sum < 0)
                {
                    sum = 0;
                }

                if (sum > maxSum)
                {
                    maxSum = sum;
                }
            }


            return maxSum;
        }

        public int GetLargestContiguousSumWithAllNegative(int[] a)
        {
            int sum = a[0];
            int maxSum = a[0];

            for (int i = 1; i < a.Length; i++)
            {
                sum = Max(a[i], sum + a[i]);

                if (sum > maxSum)
                {
                    maxSum = sum;
                }
            }


            return maxSum;
        }

        int Max(int x, int y)
        {
            return x > y ? x : y;
        }
    }
}
