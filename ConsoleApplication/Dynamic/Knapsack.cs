using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Dynamic
{
    public class Knapsack
    {
        public void GetMaxValue()
        {
            int maxWt = 7;
            int[] wt = new int[] { 1, 3, 4, 5 };
            int[] val = new int[] { 1, 4, 5, 7 };

            int maxVal = Calc(wt, val, maxWt);
            Console.WriteLine(maxVal);
        }

        private int Calc(int[] wt, int[] val, int maxWt)
        {
            int n = wt.Count();
            int[,] dp = new int[n, maxWt + 1];

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j <= maxWt; j++)
                {
                    if (j == 0)
                    {
                        dp[i, j] = 0;
                    } 
                    else if (i == 0)
                    {
                        dp[i, j] = j < wt[0] ? 0 : val[0];
                    }
                    else
                    {
                        dp[i, j] = j >= wt[i] ? Max(val[i] + dp[i - 1, j - wt[i]], dp[i - 1, j]) : dp[i - 1, j];
                    }
                }
            }

            return dp[n - 1, maxWt];
        }

        int Max(int x, int y)
        {
            return x > y ? x : y;
        }
    }
}
