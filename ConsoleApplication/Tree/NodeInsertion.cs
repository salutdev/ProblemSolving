using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class NodeInsertion
    {
        public void Insert()
        {
            TreeNode root = Tree.GetExampleTree2();

            TreeNode result = InsertRec(root, 25);

        }

        private TreeNode InsertRec(TreeNode root, int val)
        {
            if (root == null) return new TreeNode(val);

            if (root.Data > val)
            {
                root.Left = InsertRec(root.Left, val);
            }
            else if (root.Data < val)
            {
                root.Right = InsertRec(root.Right, val);
            }

            return root;
        }
    }
}
