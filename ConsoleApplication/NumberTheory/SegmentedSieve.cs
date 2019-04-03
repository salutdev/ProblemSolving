using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.NumberTheory
{
    public class SegmentedSieve
    {



        // This methid finds all primes smaller than 'limit'
        // using simple sieve of eratosthenes. It also stores
        // found primes in vector prime[]
        private void simpleSieve(int limit, List<int> prime)
        {
            // Create a boolean array "mark[0..n-1]" and initialize
            // all entries of it as true. A value in mark[p] will
            // finally be false if 'p' is Not a prime, else true.
            bool[] mark = new bool[limit + 1];

            for (int i = 0; i < mark.Length; i++)
                mark[i] = true;

            for (int p = 2; p * p < limit; p++)
            {
                // If p is not changed, then it is a prime
                if (mark[p] == true)
                {
                    // Update all multiples of p
                    for (int i = p * 2; i < limit; i += p)
                        mark[i] = false;
                }
            }

            // Print all prime numbers and store them in prime
            for (int p = 2; p < limit; p++)
            {
                if (mark[p] == true)
                {
                    prime.Add(p);
                    Console.Write(p + "  ");
                }
            }
        }

        // Prints all prime numbers smaller than 'n'
        public void segmentedSieve(int n)
        {
            // Compute all primes smaller than or equal
            // to square root of n using simple sieve
            int limit = (int)(Math.Floor(Math.Sqrt(n)) + 1);
            List<int> prime = new List<int>();
            simpleSieve(limit, prime);

            // Divide the range [0..n-1] in different segments
            // We have chosen segment size as sqrt(n).
            int low = limit;
            int high = 2 * limit;

            // While all segments of range [0..n-1] are not processed,
            // process one segment at a time
            while (low < n)
            {
                if (high >= n)
                    high = n;

                // To mark primes in current range. A value in mark[i]
                // will finally be false if 'i-low' is Not a prime,
                // else true.
                bool[] mark = new bool[limit + 1];

                for (int i = 0; i < mark.Length; i++)
                    mark[i] = true;

                // Use the found primes by simpleSieve() to find
                // primes in current range
                for (int i = 0; i < prime.Count; i++)
                {
                    // Find the minimum number in [low..high] that is
                    // a multiple of prime.get(i) (divisible by prime.get(i))
                    // For example, if low is 31 and prime.get(i) is 3,
                    // we start with 33.
                    int loLim = (int)(Math.Floor((decimal)low / prime[i]) * prime[i]);
                    if (loLim < low)
                        loLim += prime[i];

                    /*  Mark multiples of prime.get(i) in [low..high]:
                        We are marking j - low for j, i.e. each number
                        in range [low, high] is mapped to [0, high-low]
                        so if range is [50, 100]  marking 50 corresponds
                        to marking 0, marking 51 corresponds to 1 and
                        so on. In this way we need to allocate space only
                        for range  */
                    for (int j = loLim; j < high; j += prime[i])
                        mark[j - low] = false;
                }

                // Numbers which are not marked as false are prime
                for (int i = low; i < high; i++)
                    if (mark[i - low] == true)
                        Console.Write(i + "  ");

                // Update low and high for next segment
                low = low + limit;
                high = high + limit;
            }
        }












        public void Calc()
        {
            int n = 100;
            int segment = (int)Math.Sqrt(n) + 1;

            List<int> primes = SimpleSieve(segment);
            primes.ForEach(e => Console.Write($"{e} "));

            int low = segment;
            int high = 2 * segment;


            while (low < n)
            {
                bool[] nums = new bool[segment];
                for (int i = 0; i < nums.Count(); i++)
                {
                    nums[i] = true;
                }


                for (int i = 0; i < primes.Count; i++)
                {
                    int k = (int)Math.Floor((decimal)low / primes[i]) * primes[i];
                    if (k < low)
                    {
                        k += primes[i];
                    }

                    for (int j = k; j <= high; j += primes[i])
                    {

                        nums[j - low] = false;
                    }
                }

                for (int i = 0; i < nums.Count(); i++)
                {
                    if (nums[i])
                    {
                        Console.Write($"{i + low} ");
                    }
                }

                low = high + 1;
                high += segment;
            }
        }

        private List<int> SimpleSieve(int n)
        {
            bool[] primes = new bool[n + 1];
            for (int i = 2; i <= n; i++)
            {
                primes[i] = true;
            }

            for (int i = 2; i * i <= n; i++)
            {
                if (primes[i])
                {
                    for (int j = 2*i; j <= n; j += i)
                    {
                        primes[j] = false;
                    }
                }
            }

            List<int> primeList = new List<int>();
            for (int i = 2; i <= n; i++)
            {
                if (primes[i])
                {
                    primeList.Add(i);
                }
            }
            return primeList;
        }
    }
}
