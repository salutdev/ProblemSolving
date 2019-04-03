using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Dynamic
{
    public class EqualSumPartition
    {
        public bool EqualSumPossible(int[] ar)
        {
            int sum = ar.Sum();
            int n = ar.Length;

            if (sum % 2 == 1)
            {
                return false;
            }

            if (sum == 0 && n != 0)
            {
                return true;
            }

            bool[,] dp = new bool[sum / 2 + 1, n + 1];

            for (int j = 0; j <= n; j++)
            {
                dp[0, j] = true;
            }

            for (int i = 1; i <= sum/2; i++)
            {
                dp[i, 0] = false;
            }

            for (int i = 1; i <= sum / 2; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    dp[i, j] = dp[i, j - 1];

                    if (i >= ar[j - 1])
                    {
                        dp[i, j] = dp[i, j] || dp[i - ar[j - 1], j - 1];
                    }
                }
            }

            return dp[sum/2, n];
        }
    }
}
