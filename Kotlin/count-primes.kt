package countprimes

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countPrimes(n: Int): Int {
        return linearSieveOfEratosthenes(n.toLong() - 1).size
    }

    private fun linearSieveOfEratosthenes(n: Long): List<Long> {
        val spf = LongArray(n.toInt() + 1) { -1L }
        val primes = mutableListOf<Long>()
        for (i in 2L..n) {
            if (spf[i.toInt()] == -1L) {
                spf[i.toInt()] = i
                primes.add(i)
            }
            for (p in primes) {
                if (i * p > n || p > spf[i.toInt()]) {
                    break
                }
                spf[(i * p).toInt()] = p
            }
        }
        return primes
    }
}
