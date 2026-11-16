package primearrangements

// Time:  O(n/2 + n/3 + ... + n/p) = O(nlog(logn)), see https://mathoverflow.net/questions/4596/on-the-series-1-2-1-3-1-5-1-7-1-11
// Space: O(n)

class Solution {
    fun numPrimeArrangements(n: Int): Int {
        val cnt = countPrimes(n)
        return (factorial(cnt) * factorial(n - cnt) % MOD).toInt()
    }

    private fun countPrimes(n: Int): Int {
        if (n <= 1) {
            return 0
        }
        val isPrimes = BooleanArray((n + 1) / 2) { true }
        var cnt = isPrimes.size
        var i = 3
        while (i * i <= n) {
            if (isPrimes[i / 2]) {
                var j = i * i
                while (j <= n) {
                    if (isPrimes[j / 2]) {
                        --cnt
                        isPrimes[j / 2] = false
                    }
                    j += 2 * i
                }
            }
            i += 2
        }
        return cnt
    }

    private fun factorial(n: Int): Long {
        var result = 1L
        for (i in 2..n) {
            result = result * i % MOD
        }
        return result
    }

    companion object {
        private const val MOD = 1_000_000_007L
    }
}
