using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class MinHeight
    {
        TreeNode _head;
        public int FindMinHeight()
        {
            return FindeMinHeightRec(_head);
        }

        private int FindeMinHeightRec(TreeNode root)
        {
            if (root == null)
            {
                return 0;
            }

            if (root.Left == null && root.Right == null)
            {
                return 1;
            }

            if (root.Right == null)
            {
                return FindeMinHeightRec(root.Left) + 1;
            }

            if (root.Left == null)
            {
                return FindeMinHeightRec(root.Right) + 1;
            }

            return Min(FindeMinHeightRec(root.Left), FindeMinHeightRec(root.Right)) + 1;
        }

        private int Min(int left, int right)
        {
            return left < right ? left : right;
        }

    }
}
