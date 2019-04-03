using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.NumberTheory
{
    public class ExtendedEuclidean
    {
        public void Calc()
        {
            // r(0) = a
            // r(1) = b
            // r(i+1) = r(i-1) - r(i) * q(i)
            // q(i) = r(0) / r(1);
            //
            // x(0) = 1,  x(1) = 0
            // y(0) = 0,  y(1) = 1
            // x(i+1) = x(i-1) - x(i) * q(i)
            // y(i+1) = y(i-1) - y(i) * q(i)

            int a = 240, b = 46;
            int r0 = a, r1 = b;
            int x0 = 1, x1 = 0;
            int y0 = 0, y1 = 1;
            int q = 0;
            int r = -1;

            while(r != 0)
            {
                q = r0 / r1;
                r = r0 - r1 * q;
                if (r != 0)
                {
                    int x = x0 - x1 * q;
                    int y = y0 - y1 * q;
                    x0 = x1;
                    x1 = x;
                    y0 = y1;
                    y1 = y;
                    r0 = r1;
                    r1 = r;
                }
            }

            Console.WriteLine($"a = {a};  x = {x1}; b = {b}; y = {y1}; r = {r1}");
        }
    }
}
