using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class VerticalOrder
    {
        private Dictionary<int, List<int>> _hdDic = new Dictionary<int, List<int>>();
        private int _min = int.MaxValue;
        private int _max = int.MinValue;

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


            Preorder(root, 0);
            for (int i = _min; i <= _max; i++)
            {
                _hdDic[i].ForEach(d => Console.Write($"{d} "));
                Console.WriteLine();
            }
        }

        private void Preorder(TreeNode root, int hd)
        {
            if (root == null)
            {
                return;
            }

            if (hd < _min)
            {
                _min = hd;
            }
            else if (hd > _max)
            {
                _max = hd;
            }

            if (_hdDic.ContainsKey(hd))
            {
                _hdDic[hd].Add(root.Data);
            }
            else
            {
                _hdDic.Add(hd, new List<int> { root.Data });
            }

            Preorder(root.Left, hd - 1);
            Preorder(root.Right, hd + 1);
        }
    }
}
