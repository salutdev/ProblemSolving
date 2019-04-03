using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class SpecificSumExists
    {
        public void SumExists()
        {
            TreeNode root = Tree.GetExampleTree2();
            Console.WriteLine(SumIsPresent(root, 0, 12));
        }

        private bool SumIsPresent(TreeNode root, int currentSum, int targetSum)
        {
            if (root == null) return false;
            int sumWithRoot = currentSum + root.Data;
            if (root.Data == targetSum || sumWithRoot == targetSum) return true;

            return /*sumWithRoot < targetSum &&*/ SumIsPresent(root.Left, sumWithRoot, targetSum)
                   || /*sumWithRoot < targetSum &&*/ SumIsPresent(root.Right, sumWithRoot, targetSum)
                   || SumIsPresent(root.Left, root.Data, targetSum)
                   || SumIsPresent(root.Right, root.Data, targetSum);
        }

        private int SumIsPresent2(TreeNode root, out bool result, int targetSum)
        {
            result = false;
            if (root == null) return 0;

            int left = SumIsPresent2(root.Left, out result, targetSum);
            int right = SumIsPresent2(root.Right, out result, targetSum);

            if (root.Data == targetSum || left + root.Data == targetSum || right + root.Data == targetSum)
            {
                result = true;
                return targetSum;
            }


            return 0;
        }

        private bool SumIsPresent3(TreeNode root, int currentSum, int targetSum)
        {
            if (root == null) return false;
            int sumWithRoot = currentSum + root.Data;
            if (root.Data == targetSum || sumWithRoot == targetSum) return true;

            return sumWithRoot < targetSum && SumIsPresent(root.Left, sumWithRoot, targetSum)
                   || sumWithRoot < targetSum && SumIsPresent(root.Right, sumWithRoot, targetSum)
                   || SumIsPresent(root.Left, root.Data, targetSum)
                   || SumIsPresent(root.Right, root.Data, targetSum);
        }

    }
}
