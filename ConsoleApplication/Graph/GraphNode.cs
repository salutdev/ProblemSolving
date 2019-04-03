using System.Collections.Generic;

namespace Graph
{
    public class GraphNode
    {
        public List<GraphNode> adj = new List<GraphNode>();
        public int Data;
    }
}