using System;
using System.Collections.Generic;

namespace Graph
{
    public class BFS
    {
        
        public void Traverse(GraphNode node)
        {
            Queue<GraphNode> queue = new Queue<GraphNode>();
            queue.Enqueue(node);
            HashSet<GraphNode> set = new HashSet<GraphNode>();

            while (queue.Count != 0)
            {
                GraphNode cur = queue.Dequeue();
                Console.WriteLine(cur.Data);

                cur.adj.ForEach(e =>
                {
                    if (!set.Contains(cur))
                    {
                        queue.Enqueue(e);
                        set.Add(cur);
                    }
                });
            }

        }
    }
}