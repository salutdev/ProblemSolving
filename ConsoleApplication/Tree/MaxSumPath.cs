using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class MaxSumPath
    {
        int _maxSum;
        public int CalcMaxSumPath(TreeNode node)
        {
            if (node == null) return 0;

            int leftSum = CalcMaxSumPath(node.Left);
            int rightSum = CalcMaxSumPath(node.Right);

            int maxSumOfSingleBranch = Max(Max(leftSum, rightSum) + node.Data, node.Data);

            int maxOverall = Max(maxSumOfSingleBranch, leftSum + rightSum + node.Data);

            _maxSum = Max(_maxSum, maxOverall);

            return maxSumOfSingleBranch;
        }

        int Max(int a, int b)
        {
            return a > b ? a : b;
        }
    }
}
