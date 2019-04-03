using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class Tree
    {
        public static TreeNode GetExampleTree1()
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

            return root;
        }

        public static TreeNode GetExampleTree2()
        {
            /*                15
             *            /        \
             *           6         42
             *         /  \        /   \
             *      4     9       33     55
             *     / \   / \     /  \    / \
             *    3   5 7   11  24  38  51  70
             */
            TreeNode root = new TreeNode(15);
            root.Left = new TreeNode(6);
            root.Right = new TreeNode(42);

            root.Left.Left = new TreeNode(4);
            root.Left.Right = new TreeNode(-9);

            root.Right.Left = new TreeNode(33);
            root.Right.Right = new TreeNode(55);

            root.Left.Left.Left = new TreeNode(3);
            root.Left.Left.Right = new TreeNode(5);
            root.Left.Right.Left = new TreeNode(7);
            root.Left.Right.Right = new TreeNode(11);

            root.Right.Left.Left = new TreeNode(24);
            root.Right.Left.Right = new TreeNode(38);
            root.Right.Right.Left = new TreeNode(51);
            root.Right.Right.Right = new TreeNode(70);

            return root;
        }
    }
}
