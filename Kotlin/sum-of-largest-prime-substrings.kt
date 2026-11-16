package sumoflargestprimesubstrings

// Time:  O(n^2 * sqrt(r))
// Space: O(n^2)

class Solution {
    fun sumOfLargestPrimes(s: String): Long {
        val primesSet = mutableSetOf<Long>()
        for (i in s.indices) {
            var curr = 0L
            for (j in i until s.length) {
                curr = curr * 10 + (s[j] - '0')
                if (isPrime(curr)) {
                    primesSet.add(curr)
                }
            }
        }
        val primes = primesSet.sortedDescending()
        return primes.take(minOf(primes.size, 3)).sum()
    }

    private fun isPrime(n: Long): Boolean {
        if (n == 1L) {
            return false
        }
        if (n == 2L || n == 3L) {
            return true
        }
        if (n % 2L == 0L || n % 3L == 0L) {
            return false
        }
        var i = 5L
        while (i < n) {
            if (i * i > n) {
                break
            }
            if (n % i == 0L || n % (i + 2) == 0L) {
                return false
            }
            i += 6
        }
        return true
    }
}
