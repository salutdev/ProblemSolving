using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class TreeNode
    {
        public TreeNode() { }
        public TreeNode(int data)
        {
            Data = data;
        }

        public TreeNode Left;
        public TreeNode Right;
        public int Data;
    }
}
