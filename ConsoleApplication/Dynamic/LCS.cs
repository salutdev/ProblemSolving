using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Dynamic
{
    public class LCS
    {
        public int Calculate()
        {
            string str1 = "ABCDGH";
            string str2 = "AEDFHR";
            int length1 = str1.Length;
            int length2 = str2.Length;

            int[,] dp = new int[length1+1, length2+1];
            
            for (int i = 0; i <= length1; i++)
            {
                for (int j = 0; j <= length2; j++)
                {
                    if (i == 0 || j == 0)
                    {
                        dp[i, j] = 0;
                    }
                    else
                    {
                        if (str1[i-1] == str2[j-1])
                        {
                            dp[i, j] = dp[i - 1, j - 1] + 1;
                        }
                        else
                        {
                            dp[i, j] = Max(dp[i - 1, j], dp[i, j - 1]);
                        }
                    }
                    
                }
            }

            return dp[length1, length2];
        }

        int Max(int x, int y)
        {
            return x > y ? x : y;
        }
    }
}
