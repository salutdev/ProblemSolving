using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Dynamic
{
    public class PalindromePartitioning
    {
        // complexity n^3
        public void Calc()
        {
            string s = "abcbm"; // result = 2
            //string s = "ababbbabbababa"; // 3
            int n = s.Length;
            int[,] dp = new int[n, n];

            for (int i = 2; i <= n; i++)
            {
                for (int j = 0; j <= n - i; j++)
                {
                    int e = i + j - 1;
                    if (i == 2)
                    {
                        dp[j, e] = (s[j] == s[e]) ? 0 : 1;
                    }
                    else
                    {
                        // case i == 2 is needed to handle 2nd condition, but can be omitted
                        if (s[j] == s[e] && dp[j + 1, e - 1] == 0)
                        {
                            dp[j, e] = 0;
                        }
                        else
                        {
                            int min = int.MaxValue;
                            for (int k = 0; k < i - 1; k++)
                            {
                                int val = 1 + dp[j, j + k] + dp[j + k + 1, e];
                                min = (min < val) ? min : val;
                            }
                            dp[j, e] = min;
                        }
                    }
                }
            }

            Console.WriteLine(dp[0, n - 1]);
        }

        // complexity n^2
        public void Calc2()
        {
            //string s = "abcbm"; // result = 2
            string s = "ababbbabbababa"; // 3
            int n = s.Length;
            bool[,] dp = new bool[n, n];
            int[] c = new int[n];

            for (int i = 0; i < n; i++)
            {
                dp[i, i] = true;
            }

            for (int i = 2; i <= n; i++)
            {
                for (int j = 0; j <= n - i; j++)
                {
                    int e = i + j - 1;
                    if (i == 2)
                    {
                        dp[j, e] = s[j] == s[e];
                    }
                    else
                    {
                        // case i == 2 is needed to handle 2nd condition, but can be omitted
                        dp[j, e] = s[j] == s[e] && dp[j + 1, e - 1];
                    }
                }
            }

            for (int i = 0; i < n; i++)
            {
                if (dp[0, i])
                {
                    c[i] = 0;
                }
                else
                {
                    c[i] = int.MaxValue;
                    for (int j = 0; j < i; j++)
                    {
                        if (dp[j + 1, i] && c[j] + 1 < c[i])
                        {
                            c[i] = c[j] + 1;
                        }

                    }
                }
            }

            Console.WriteLine(c[n - 1]);
        }

    }
}
