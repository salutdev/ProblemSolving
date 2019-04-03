using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.NumberTheory
{
    public class GCD_Euclidean
    {
        public void CalcGCdc()
        {
            int a = 5, b = 35;
            Console.WriteLine(new GCD_Euclidean().Gdc1(a, b));
            Console.WriteLine(new GCD_Euclidean().Gdc2(a, b));
            Console.WriteLine(new GCD_Euclidean().Gdc3(a, b));
        }
        private int Gdc1(int a, int b)
        {
            if (a == b) return a;

            if (a > b)
            {
                return Gdc1(a - b, b);
            }

            return Gdc1(a, b - a);
        }

        private int Gdc2 (int a, int b)
        {
            if (a == 0)
            {
                return b;
            }

            return Gdc2(b % a, a);
        }

        private int Gdc3(int a, int b)
        {
            if (a == 0) return b;

            if (a > b) return Gdc3(a % b, b);

            return Gdc3(b % a, a);
        }
    }
}
