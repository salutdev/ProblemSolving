using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Dynamic
{
    public class TransformStringByDeletingOrCapitalizing
    {
        public bool CanTransform(string src, string dest)
        {
            int m = src.Length;
            int n = dest.Length;
            bool[,] dp = new bool[m + 1, n + 1];

            for (int i = 0; i <= m; i++)
            {
                for (int j = 0; j <= n; j++)
                {
                    dp[i, j] = false;
                }
            }

            dp[0, 0] = true;

            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (dp[i, j])
                    {
                        if (j < n && char.ToUpper(src[i]) == dest[j])
                        {
                            dp[i + 1, j + 1] = true;
                        }

                        if (char.IsLower(src[i]))
                        {
                            dp[i + 1, j] = true;
                        }
                    }
                }
            }

            return dp[m, n];
        }
    }
}
