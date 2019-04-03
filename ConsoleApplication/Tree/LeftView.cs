using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class LeftView
    {
        int maxLevel = 0;
        private void PrintLeftView(TreeNode root, int level)
        {
            if (root == null)
            {
                return;
            }

            if (maxLevel < level)
            {
                Console.WriteLine(root.Data);
                maxLevel = level;
            }

            PrintLeftView(root.Left, level + 1);
            PrintLeftView(root.Right, level + 1);
        }

        public void PrintTreeLeftView()
        {
            TreeNode root = new TreeNode(20);
            root.Left = new TreeNode(13);
            root.Right = new TreeNode(44);

            root.Left.Left = new TreeNode(4);
            root.Left.Right = new TreeNode(17);

            root.Left.Left.Left = new TreeNode(2);
            root.Left.Left.Right = new TreeNode(8);

            root.Left.Left.Left.Left = new TreeNode(1);
            root.Left.Left.Left.Right = new TreeNode(3);

            root.Left.Right.Left = new TreeNode(15);
            root.Left.Right.Right = new TreeNode(19);

            root.Right.Left = new TreeNode(25);
            root.Right.Right = new TreeNode(58);

            PrintLeftView(root, 1);
        }
    }
}
