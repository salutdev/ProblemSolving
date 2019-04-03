using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.SortAndSearch
{
    public class BinarySearchInRotatedArray
    {
        public void Search()
        {
            int[] ar = new int[] { 19, 1, 3, 5, 7, 9, 11 };
            int x = 19;
            Console.WriteLine(SearchIterative(ar, x));
        }

        int SearchIterative(int[] ar, int x)
        {
            int l = 0;
            int r = ar.Length - 1;

            while(l <= r)
            {
                int m = (l + r) / 2;

                if (ar[m] == x)
                {
                    return m;
                }
                else if (ar[m] >= ar[l])
                {
                    if (x <= ar[m] && x >= ar[l])
                    {
                        r = m - 1;
                    }
                    else
                    {
                        l = m + 1;
                    }
                }
                else
                {
                    if (x >= ar[m] && x <= ar[r])
                    {
                        l = m + 1;
                    }
                    else
                    {
                        r = m - 1;
                    }
                }

            }


            return -1;
        }
    }
}
