using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.NumberTheory
{
    public class ModuloExponentiation
    {
        // ((a mod p) (b mod p)) mod p = (ab) mod p
        
        // Calculate x^y mod p

        public void CalcReminder()
        {
            int x = 20, y = 30, p = 7;
            Console.WriteLine($"1. { Calculate1(x, y, p) }");
            Console.WriteLine($"2. { Calculate2(x, y, p) }");
            Console.WriteLine($"3. { Calculate3(x, y, p) }");
            Console.WriteLine($"4. { Calculate4(x, y, p) }");
        }

        private int Calculate1(int x, int y, int p)
        {
            int res = 1;
            for (int i = 0; i < y; i++)
            {
                res *= x;
            }

            return res % p;
        }

        private int Calculate2(int x, int y, int p)
        {
            int result = 1;

            for (int i = 0; i < y; i++)
            {
                result = (result * x) % p;
            }

            return result;
        }

        private int Calculate3(int x, int y, int p)
        {
            int result = 1;

            for (int i = 0; i < y; i++)
            {
                result = (result * (x % p)) % p;
            }

            return result;
        }

        private int Calculate4 (int x, int y, int p)
        {
            int result = 1;

            while (y > 0)
            {
                if ((y & 1) == 1)
                {
                    result = (result * (x % p)) % p;
                }

                y >>= 1;
                x = ((int)Math.Pow((x % p), 2)) % p;
            }

            return result;
        }

    }
}
