using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Dynamic
{
    public class MatrixChainMultiplication
    {
        public void Calc()
        {
            //int[] m = new int[] { 10, 20, 30, 40, 30 };  // 30000
            int[] m = new int[] { 40, 20, 30, 10, 30 };  // 26000
            //int[] m = new int[] { 10, 20, 30 };  // 6000

            int n = m.Length - 1;
            int[,] dp = new int[n, n];

            for (int i = 0; i < n; i++)
            {
                dp[i, i] = 0;
            }

            for (int i = 2; i <= n; i++)
            {
                for (int j = 0; j <= n - i; j++)
                {
                    int min = int.MaxValue;
                    for (int k = 0; k < i - 1; k++)
                    {
                        int mult = dp[j, j + k] + dp[j + k + 1, j + i - 1] + m[j] * m[j + k + 1] * m[j + i];
                        min = min > mult ? mult : min;
                    }
                    dp[j, j + i - 1] = min;
                }
            }
            Console.WriteLine(dp[0, n - 1]);
        }
    }
}
