package thenumberofgoodsubsets

// Time:  O(n * 2^p), p is the number of primes in [1, n]
// Space: O(2^p)

class Solution {
    fun numberOfGoodSubsets(nums: IntArray): Int {
        val mod = 1_000_000_007L
        val primes = sieveOfEratosthenes(nums.maxOrNull()!!)
        val dp = IntArray(1 shl primes.size)
        dp[0] = 1
        val cnts = HashMap<Int, Int>()
        for (x in nums) {
            cnts[x] = (cnts[x] ?: 0) + 1
        }
        for ((x, cnt) in cnts) {
            if (x == 1 || primes.any { p -> p * p <= x && x % (p * p) == 0 }) {
                continue
            }
            val mask = toMask(primes, x)
            for (i in 0 until dp.size - 1) {
                if (i and mask != 0) {
                    continue
                }
                dp[i or mask] = ((dp[i or mask] + cnt.toLong() * dp[i]) % mod).toInt()
            }
        }
        var total = 0L
        for (v in dp) {
            total = (total + v) % mod
        }
        val p = powmod(2L, (cnts[1] ?: 0).toLong(), mod)
        return (p * ((total - 1 + mod) % mod) % mod).toInt()
    }

    private fun sieveOfEratosthenes(n: Int): List<Int> {
        if (n < 2) {
            return emptyList()
        }
        val primes = ArrayList<Int>()
        primes.add(2)
        val isPrime = BooleanArray((n + 1) / 2) { true }
        for (i in 1 until isPrime.size) {
            if (!isPrime[i]) {
                continue
            }
            primes.add(2 * i + 1)
            var j = 2 * i * (i + 1)
            while (j < isPrime.size) {
                isPrime[j] = false
                j += 2 * i + 1
            }
        }
        return primes
    }

    private fun toMask(primes: List<Int>, x: Int): Int {
        var mask = 0
        var basis = 1
        for (p in primes) {
            if (x % p == 0) {
                mask = mask or basis
            }
            basis = basis shl 1
        }
        return mask
    }

    private fun powmod(a0: Long, b0: Long, mod: Long): Long {
        var a = a0 % mod
        var b = b0
        var result = 1L
        while (b > 0) {
            if (b and 1L == 1L) {
                result = result * a % mod
            }
            a = a * a % mod
            b = b shr 1
        }
        return result
    }
}
