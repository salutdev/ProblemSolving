using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class TreeFromInorderAndPreorder
    {
        int _preIndex = 0;

        public TreeNode ConstructTree()
        {
            int[] inorder = new int[] { 5, 15, 30, 77, 22, 44 };
            int[] preorder = new int[] { 77, 15, 5, 30, 44, 22 };

            return null;
        }

        TreeNode Construct(int[] inorder, int[] preorder, int inStart, int inEnd)
        {
            if (inStart > inEnd) return null;
            TreeNode node = new TreeNode(preorder[_preIndex]);
            _preIndex++;

            if (inStart == inEnd) return node;

            int inIndex = GetInorderIndex(inorder, node.Data, inStart, inEnd);

            node.Left = Construct(inorder, preorder, inStart, inIndex - 1);
            node.Right = Construct(inorder, preorder, inIndex +  1, inEnd);

            return node;
        }

        int GetInorderIndex(int[] inorder, int data, int inStart, int inEnd)
        {
            for (int i = inStart; i <= inEnd; i++)
            {
                if (inorder[i] == data)
                {
                    return i;
                }
            }

            return -1;
        }


    }
}
