using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.Tree
{
    public class SubtreeCheck
    {
        private bool AreTreesSame(TreeNode t, TreeNode s)
        {
            if (t == null && s == null)
            {
                return true;
            }

            if (t == null || s == null)
            {
                return false;
            }

            return t.Data == s.Data && AreTreesSame(t.Left, s.Left) && AreTreesSame(t.Right, s.Right);
        }

        public bool IsSubtree(TreeNode t, TreeNode s)
        {
            if (t == null)
            {
                return false;
            }

            if (s == null)
            {
                return true;
            }

            if (AreTreesSame(t, s))
            {
                return true;
            }

            return IsSubtree(t.Left, s) || IsSubtree(t.Right, s);
        }



        bool AreTreesEqual2(TreeNode t, TreeNode s)
        {
            if (t == null && s == null)
            {
                return true;
            }
            
            if (t == null || s == null)
            {
                return false;
            }

            return t.Data == s.Data && AreTreesEqual2(t.Left, s.Left) && AreTreesEqual2(t.Right, s.Left);
        }

        public bool IsTreeASubtree(TreeNode t, TreeNode s)
        {
            if (t == null) return false;
            if (s == null) return true;

            if (AreTreesEqual2(s, t))
            {
                return true;
            }

            return IsTreeASubtree(t.Left, s) || IsTreeASubtree(t.Right, s);
        }
        
    }
}
