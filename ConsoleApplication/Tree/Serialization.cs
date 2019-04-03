using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class Serialization
    {
        public void Serialize()
        {
            TreeNode root = Tree.GetExampleTree2();
            SerializeRec(root);
        }

        void SerializeRec(TreeNode root)
        {
            if (root == null)
            {
                Console.Write("-1,");
                return;
            }

            Console.Write($" {root.Data},");
            SerializeRec(root.Left);
            SerializeRec(root.Right);
        }

        int index = -1;

        public TreeNode Deserialize()
        {
            int[] arr = new int[] { 15, 6, 4, 3, -1, -1, 5, -1, -1, 9, 7, -1, -1, 11, -1, -1, 42, 33, 24, -1, -1, 38, -1, -1, 55, 51, -1, -1, 70, -1, -1 };

            TreeNode root = DeserializeRec(arr);
            return root;
        }
        public TreeNode DeserializeRec(int[] arr)
        {
            index++;
            if (index >= arr.Length || arr[index] == -1)
            {
                return null;
            }

            TreeNode node = new TreeNode(arr[index]);
            node.Left = DeserializeRec(arr);
            node.Right = DeserializeRec(arr);

            return node;
        }
    }
}
