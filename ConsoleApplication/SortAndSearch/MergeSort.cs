using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.SortAndSearch
{
    public class MergeSort
    {
        public void Calc()
        {
            int[] ar = new int[] {9, 5, 4, 7 };
            int r = ar.Length-1;
            Sort(ar, 0, r);
        }

        private void Sort(int[] ar, int l, int r)
        {
            if (l < r)
            {
                int m = (l + r) / 2;

                Sort(ar, l, m);
                Sort(ar, m + 1, r);

                Merge(ar, l, m, r);

            }

        }

        private void Merge(int[] ar, int l, int m, int r)
        {
            int n1 = m - l + 1;
            int n2 = r - m;
            int[] lAr = new int[n1];
            int[] rAr = new int[n2];

            for (int i = 0; i < n1; i++)
            {
                lAr[i] = ar[l + i];
            }

            for (int i = 0; i < n2; i++)
            {
                rAr[i] = ar[m + i + 1];
            }


            int lIndex = l;
            int rIndex = m + 1;
            int index = l;

            for (int i = 0; i < n1 + n2; i++)
            {
                if (lIndex <= m && (rIndex > r || (rIndex <= r && lAr[lIndex-l] < rAr[rIndex-m-1])))
                {
                    ar[index] = lAr[lIndex-l];
                    index++;
                    lIndex++;
                }
                else
                {
                    ar[index] = rAr[rIndex - m - 1];
                    index++;
                    rIndex++;
                }

            }


        }
    }
}
