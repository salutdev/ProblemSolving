using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class BottomView
    {
        public void PrintBottomView(TreeNodeWithHd root)
        {
            Queue<TreeNodeWithHd> q = new Queue<TreeNodeWithHd>();
            root.Hd = 0;
            q.Enqueue(root);

            SortedDictionary<int, int> sd = new SortedDictionary<int, int>();
            sd.Add(root.Hd, root.Data);

            while (q.Count != 0)
            {
                TreeNodeWithHd node = q.Dequeue();

                if (!sd.ContainsKey(node.Hd))
                {
                    sd.Add(node.Hd, node.Data);
                }

                if (node.Left != null)
                {
                    TreeNodeWithHd nodeWithHdL = new TreeNodeWithHd(node.Left);
                    nodeWithHdL.Hd = node.Hd - 1;
                    q.Enqueue(nodeWithHdL);
                }

                if (node.Right != null)
                {
                    TreeNodeWithHd nodeWithHdR = new TreeNodeWithHd(node.Left);
                    nodeWithHdR.Hd = node.Hd + 1;
                    q.Enqueue(nodeWithHdR);
                }
            }

            foreach(int data in sd.Values)
            {
                Console.Write($"{data};");
            }

        }
    }
}
