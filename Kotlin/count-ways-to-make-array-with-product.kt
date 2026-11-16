package countwaystomakearraywithproduct

// Time:  O(sqrt(m) + n + q * (logm + pi(sqrt(m)))) = O(sqrt(m) + n + q * (logm + sqrt(m)/log(sqrt(m)))), m is max(k for _, k in queries), pi(n) = number of primes in a range [1, n] = O(n/logn) by prime number theorem, see https://en.wikipedia.org/wiki/Prime_number_theorem
// Space: O(sqrt(m) + n + logm)

import kotlin.math.sqrt

private const val MOD = 1_000_000_007L

private val FACT = mutableListOf(1L, 1L)
private val INV = mutableListOf(1L, 1L)
private val INV_FACT = mutableListOf(1L, 1L)

private fun nCr(n: Int, k: Int): Long {
    while (INV.size <= n) {
        val i = INV.size
        FACT.add(FACT.last() * i % MOD)
        INV.add(INV[(MOD % i).toInt()] * (MOD - MOD / i) % MOD)
        INV_FACT.add(INV_FACT.last() * INV.last() % MOD)
    }
    return FACT[n] * INV_FACT[n - k] % MOD * INV_FACT[k] % MOD
}

class Solution {
    fun waysToFillArray(queries: Array<IntArray>): IntArray {
        var m = 0
        for (q in queries) {
            m = maxOf(m, q[1])
        }
        val primes = linearSieveOfEratosthenes(sqrt(m.toDouble()).toInt())

        fun primeFactors(x0: Int): HashMap<Int, Int> {
            var x = x0
            val factors = HashMap<Int, Int>()
            for (p in primes) {
                if (p * p > x) {
                    break
                }
                while (x % p == 0) {
                    factors[p] = (factors[p] ?: 0) + 1
                    x /= p
                }
            }
            if (x != 1) {
                factors[x] = (factors[x] ?: 0) + 1
            }
            return factors
        }

        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val n = queries[i][0]
            val k = queries[i][1]
            var total = 1L
            for (c in primeFactors(k).values) {
                total = total * nCr(n + c - 1, c) % MOD
            }
            result[i] = total.toInt()
        }
        return result
    }

    private fun linearSieveOfEratosthenes(n: Int): List<Int> {
        val spf = IntArray(n + 1) { -1 }
        val primes = mutableListOf<Int>()
        for (i in 2..n) {
            if (spf[i] == -1) {
                spf[i] = i
                primes.add(i)
            }
            for (p in primes) {
                if (i * p > n || p > spf[i]) {
                    break
                }
                spf[i * p] = p
            }
        }
        return primes
    }
}
