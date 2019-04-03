using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.General
{
    public static class Extensions
    {
        public static string Repl(this string s)
        {
            char[] letters = new char[] { 'n', 's', 't', 'r', 'l', 'e' };
            return string.Join(string.Empty, s.Select(c =>
            {
                if (letters.Contains(c))
                {
                    return ((int)c - 96).ToString();
                }
                return c.ToString();
            }).ToArray<string>());
        }
    }
}
