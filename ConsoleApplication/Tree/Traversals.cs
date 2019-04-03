using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class Traversals
    {
        private void Preorder(TreeNode root)
        {
            if (root == null)
            {
                return;
            }
            Console.Write($"{root.Data} ");
            Preorder(root.Left);
            Preorder(root.Right);
        }

        private void Inorder(TreeNode root)
        {
            if (root == null)
            {
                return;
            }
            Inorder(root.Left);
            Console.Write($"{root.Data} ");
            Inorder(root.Right);
        }

        public void Traverse()
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

            Preorder(root);
        }
    }
}
