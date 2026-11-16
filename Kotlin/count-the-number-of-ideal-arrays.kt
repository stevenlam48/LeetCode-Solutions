package countthenumberofidealarrays

// Time:  O(sqrt(m) + n + m * (logm + pi(sqrt(m)))) = O(sqrt(m) + n + m * (logm + sqrt(m)/log(sqrt(m)))), pi(n) = number of primes in a range [1, n] = O(n/logn) by prime number theorem, see https://en.wikipedia.org/wiki/Prime_number_theorem
// Space: O(sqrt(m) + n + logm)

// dp, factorization, combinatorics
class Solution {
    private val MOD = 1_000_000_007L
    private val fact = mutableListOf(1L, 1L)
    private val inv = mutableListOf(1L, 1L)
    private val invFact = mutableListOf(1L, 1L)

    fun idealArrays(n: Int, maxValue: Int): Int {
        val primes = linearSieveOfEratosthenes(Math.sqrt(maxValue.toDouble()).toInt())
        val primeFactors = { x0: Int ->
            var x = x0
            val factors = HashMap<Int, Int>()
            for (p in primes) {
                if (p * p > x) {
                    break
                }
                while (x % p == 0) {
                    x /= p
                    factors[p] = factors.getOrDefault(p, 0) + 1
                }
            }
            if (x != 1) {
                factors[x] = factors.getOrDefault(x, 0) + 1
            }
            factors
        }

        var result = 0L
        for (k in 1..maxValue) {
            var total = 1L
            for (c in primeFactors(k).values) {
                total = total * nCr(n + c - 1, c) % MOD
            }
            result = (result + total) % MOD
        }
        return result.toInt()
    }

    private fun nCr(n: Int, k: Int): Long {
        while (inv.size <= n) {  // lazy initialization
            fact.add(fact.last() * inv.size % MOD)
            inv.add(inv[(MOD % inv.size).toInt()] * (MOD - MOD / inv.size) % MOD)
            invFact.add(invFact.last() * inv.last() % MOD)
        }
        return fact[n] * invFact[n - k] % MOD * invFact[k] % MOD
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
