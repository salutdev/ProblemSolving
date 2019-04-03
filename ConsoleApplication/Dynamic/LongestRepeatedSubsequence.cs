using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Dynamic
{
    public class LongestRepeatedSubsequence
    {
        int[,] dp;
        int n;
        string initStr;

        public int FindLongestRepeatedSubsequenceLength(string str)
        {
            initStr = str;
            n = str.Count();
            dp = new int[n + 1, n + 1];

            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    if (str[i-1] == str[j-1] && i != j)
                    {
                        dp[i, j] = dp[i - 1, j - 1] + 1;
                    }
                    else
                    {
                        dp[i, j] = Max(dp[i - 1, j], dp[j, j - 1]);
                    }
                }
            }

            return dp[n, n];
        }

        int Max(int x, int y)
        {
            return x > y ? x : y;
        }

        public void PrintLongestRepeatedSubsequance()
        {
            int i = n;
            int j = n;
            int index = dp[n, n] - 1;
            char[] lrs = new char[dp[n, n]];

            while (i > 0 && j > 0)
            {
                if (dp[i, j] == dp[i-1, j-1] + 1)
                {
                    lrs[index] = initStr[i-1];
                    index--;
                    i--;
                    j--;
                }
                else if (dp[i, j] == dp[i-1, j])
                {
                    i--;
                }
                else
                {
                    j--;
                }
            }

            for (i = 0; i < dp[n, n]; i++)
            {
                Console.Write($"{lrs[i]}");
            }
        }

        public void PrintDp()
        {
            for (int i = 0; i <= n; i++)
            {
                for (int j = 0; j <= n; j++)
                {
                    Console.Write($"{dp[i, j]} ");
                }
                Console.Write("\r\n");
            }

            Console.Write("\r\n\r\n");
        }

        public void PrintLength()
        {
            Console.WriteLine($"Longest repeated subsequance: {dp[n, n]} \r\n");
        }
    }
}
