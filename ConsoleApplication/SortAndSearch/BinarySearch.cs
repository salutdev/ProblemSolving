using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.SortAndSearch
{
    public class BinarySearch
    {
        private int BinarySearchRecursive(int[] ar, int x, int l, int r)
        {
            if (l <= r)
            {
                int m = l + (r - l) / 2;

                if (ar[m] == x)
                {
                    return m;
                } 
                else if (ar[m] > x)
                {
                    return BinarySearchRecursive(ar, x, l, r - 1);
                }
                else
                {
                    return BinarySearchRecursive(ar, x, l+1, r);
                }
            }
            return -1;
        }

        private int BinarySearchIterative(int[] ar, int x)
        {
            int l = 0;
            int r = ar.Length - 1;
            int m = -1;
            while (l <= r)
            {
                m = l + (r-l)/2;
                if (ar[m] == x)
                {
                    return m;
                }
                else if (ar[m] < x)
                {
                    l = m + 1;
                }
                else
                {
                    r = m - 1;
                }
            }

            return -1;
        }

        public void Seacrh()
        {
            int[] ar = new int[] { 1, 3, 6, 9, 20, 34, 45, 67, 345, 346, 777 };
            int x = 35;
            //Console.WriteLine(BinarySearchRecursive(ar, x, 0, ar.Length - 1));
            Console.WriteLine(BinarySearchIterative(ar, x));
        }
    }
}
