package primesubsetselectionii

// Time:  O(n + (n / logn) * s)
// Space: O(n + (n / logn) * s)

class Solution {
    fun maxPrimeSubset(n: Int, s: Int): IntArray {
        val INF = Int.MAX_VALUE

        val primes = linearSieveOfEratosthenes(n)
        val dp = Array(primes.size + 1) { IntArray(s + 1) { INF } }
        dp[primes.size][0] = 0
        for (i in primes.size - 1 downTo 0) {
            for (j in 0..s) {
                dp[i][j] = minOf(
                    dp[i + 1][j],
                    if (j - primes[i] >= 0 && dp[i + 1][j - primes[i]] != INF) dp[i + 1][j - primes[i]] + 1 else INF
                )
            }
        }
        var target = -1
        for (j in s downTo 0) {
            if (dp[0][j] != INF) {
                target = j
                break
            }
        }
        val result = ArrayList<Int>()
        for (i in primes.indices) {
            if (target - primes[i] < 0) {
                break
            }
            if (dp[i + 1][target - primes[i]] != dp[i][target] - 1) {
                continue
            }
            result.add(primes[i])
            target -= primes[i]
        }
        return result.toIntArray()
    }

    private fun linearSieveOfEratosthenes(n: Int): IntArray {
        val spf = IntArray(n + 1) { -1 }
        val primes = IntArray(n + 1)
        var count = 0
        for (i in 2..n) {
            if (spf[i] == -1) {
                spf[i] = i
                primes[count++] = i
            }
            for (k in 0 until count) {
                val p = primes[k]
                if (i * p > n || p > spf[i]) {
                    break
                }
                spf[i * p] = p
            }
        }
        return primes.copyOf(count)
    }
}
