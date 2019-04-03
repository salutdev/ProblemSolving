using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Graph
{
    public class DFS
    {
        List<GraphNode> _nodes = null;

        public DFS()
        {
            _nodes = new List<GraphNode>();

        }

        void AddEdge(int s, int e)
        {
            _nodes[s].adj.Add(new GraphNode { Data = e });
        }


        void TraverseRec(GraphNode node, HashSet<GraphNode> set)
        {
            Console.Write($"{node.Data} ");
            set.Add(node);
            foreach (GraphNode adjNode in node.adj)
            {
                if (!set.Contains(adjNode))
                {
                    TraverseRec(adjNode, set);
                }
            }
        }

        public void Traverse()
        {
            GraphNode node1 = new GraphNode() { Data = 1 };
            GraphNode node2 = new GraphNode() { Data = 3 };
            GraphNode node3 = new GraphNode() { Data = 8 };
            GraphNode node4 = new GraphNode() { Data = 19 };
            GraphNode node5 = new GraphNode() { Data = 5 };
            GraphNode node6 = new GraphNode() { Data = 7 };

            _nodes.Add(node1);
            _nodes.Add(node2);
            _nodes.Add(node3);
            _nodes.Add(node4);
            _nodes.Add(node5);
            _nodes.Add(node6);

            for (int i = 0; i < _nodes.Count; i++)
            {
                _nodes[i].adj = new List<GraphNode>();
            }

            node1.adj.Add(node2);
            node1.adj.Add(node3);

            node2.adj.Add(node1);
            node2.adj.Add(node4);
            node2.adj.Add(node5);
            node2.adj.Add(node6);

            node3.adj.Add(node1);
            node3.adj.Add(node4);
            node3.adj.Add(node6);

            node4.adj.Add(node2);
            node4.adj.Add(node3);
            node4.adj.Add(node5);

            node5.adj.Add(node2);
            node5.adj.Add(node4);
            node5.adj.Add(node5);

            node6.adj.Add(node2);
            node6.adj.Add(node3);
            node6.adj.Add(node5);


            HashSet<GraphNode> set = new HashSet<GraphNode>();

            _nodes.ForEach(node =>
            {
                if (!set.Contains(node))
                {
                    TraverseRec(node, set);
                }
            });
        }

    }
}
