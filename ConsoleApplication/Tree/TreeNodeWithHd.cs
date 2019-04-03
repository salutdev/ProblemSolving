using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class TreeNodeWithHd : TreeNode
    {
        //public TreeNode root;
        public TreeNodeWithHd() { }
        public TreeNodeWithHd(TreeNode root)
        {
            Left = root.Left;
            Right = root.Right;
            Data = root.Data;
        }
        public int Hd;
    }
}
