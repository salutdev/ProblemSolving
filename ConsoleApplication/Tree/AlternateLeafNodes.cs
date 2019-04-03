using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class AlternateLeafNodes
    {
        public void Alternate()
        {
            TreeNode root = new TreeNode(15);
            root.Left = new TreeNode(6);
            root.Right = new TreeNode(42);

            root.Left.Left = new TreeNode(4);
            root.Left.Right = new TreeNode(9);

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

            //Stack<TreeNode> stack = new Stack<TreeNode>();
            //FillStack(root, stack);
            //AltLeafs(root, stack);
            AlternateEvenLevels(root);
        }

        /*                15
         *            /        \
         *           6         42
         *         /  \        /   \
         *      4     9       33     55
         *     / \   / \     /  \    / \
         *    3   5 7   11  24  38  51  70
         */

        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        Queue<TreeNode> queue1 = new Queue<TreeNode>();
        Queue<TreeNode> queue2 = new Queue<TreeNode>();

        public TreeNode AlternateEvenLevels(TreeNode root)
        {
            queue1.Enqueue(root);

            while (queue1.Count != 0)
            {
                while (queue1.Count != 0)
                {
                    TreeNode node = queue1.Dequeue();
                    if (node.Left != null)
                    {
                        queue2.Enqueue(node);
                        stack2.Push(node.Left);
                        stack2.Push(node.Right);
                    }
                }

                while (queue2.Count != 0)
                {
                    TreeNode node = queue2.Dequeue();

                    TreeNode left = stack2.Pop();
                    TreeNode right = stack2.Pop();

                    node.Left = left;
                    node.Right = right;

                    TreeNode tempL = left.Left;
                    TreeNode tempR = left.Right;

                    left.Left = right.Left;
                    left.Right = right.Right;

                    right.Left = tempL;
                    right.Right = tempR;

                    if (left.Left != null)
                    {
                        queue1.Enqueue(left.Left);
                        queue1.Enqueue(left.Right);
                        queue1.Enqueue(right.Left);
                        queue1.Enqueue(right.Right);
                    }
                }
            }
            return root;
        }


        private bool AltLeafs(TreeNode root, Stack<TreeNode> stack)
        {
            if (root == null) return false;

            if (root.Left == null && root.Right == null)
            {
                return true;
            }

            if (AltLeafs(root.Left, stack))
            {
                root.Left = stack.Pop();
            }

            if (AltLeafs(root.Right, stack))
            {
                root.Right = stack.Pop();
            }

            return false;
        }

        private void FillStack(TreeNode root, Stack<TreeNode> stack)
        {
            if (root == null) return;
            if (root.Left == null && root.Right == null)
            {
                stack.Push(root);
                return;
            }

            FillStack(root.Left, stack);
            FillStack(root.Right, stack);
        }
    }
}
