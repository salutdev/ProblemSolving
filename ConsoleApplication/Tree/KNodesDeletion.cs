using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class KNodesDeletion
    {

        public void DeleteNodes()
        {
            TreeNode root = new TreeNode();

            DeleteKNodes(root, 5, 0);
        }

        private bool DeleteKNodes(TreeNode root, int k, int depth)
        {
            if (root == null)
            {
                return true;
            }


            bool leftResult = DeleteKNodes(root.Left, k, depth + 1);

            if (leftResult)
            {
                root.Left = null;
                if (root.Right == null && depth < k)
                {
                    return true;
                }
            }

            bool rightResult = DeleteKNodes(root.Right, k, depth + 1);

            if (rightResult)
            {
                root.Right = null;
                if (root.Left == null && depth < k)
                {
                    return true;
                }
            }

            return false;
        }


        private TreeNode DeleteKNodes2(TreeNode root, int k, int depth)
        {
            if (root == null)
            {
                return null;
            }

            root.Left = DeleteKNodes2(root.Left, k, depth + 1);
            root.Right = DeleteKNodes2(root.Right, k, depth + 1);

            if (root.Left == null && root.Right == null && depth < k)
            {
                return null;
            }

            return root;
        }

    }
}
