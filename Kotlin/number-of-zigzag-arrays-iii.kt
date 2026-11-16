package numberofzigzagarraysiii

// Time:  O(n^3)
// Space: O(n)

class Solution {
    fun zigZagArrays(n: Int, l: Int, r: Int): Int {
        val mod = 1_000_000_007
        val inv = mutableListOf(1L, 1L)
        val invFact = mutableListOf(1L, 1L)
        fun invFactorial(value: Int): Long {
            while (inv.size <= value) {
                inv.add(inv[mod % inv.size] * (mod - mod / inv.size) % mod)
                invFact.add(invFact.last() * inv.last() % mod)
            }
            return invFact[value]
        }

        fun f(x: Int): Long {
            var dp = LongArray(x) { it.toLong() }
            for (iteration in 0 until n - 2) {
                val newDp = LongArray(x)
                for (i in 0 until x - 1) {
                    newDp[i + 1] = (newDp[i] + dp[x - 1 - i]) % mod
                }
                dp = newDp
            }
            var total = 0L
            for (i in 0 until x) {
                total = (total + dp[i]) % mod
            }
            return total * 2 % mod
        }

        val m = r - l + 1
        if (m <= n + 1) {
            return f(m).toInt()
        }
        val prefix = LongArray(n + 2)
        prefix[0] = 1L
        for (i in 0 until prefix.lastIndex) {
            val factor = ((m - 1 - i) % mod + mod) % mod
            prefix[i + 1] = prefix[i] * factor % mod
        }
        val suffix = LongArray(n + 2)
        suffix[suffix.lastIndex] = 1L
        for (i in suffix.lastIndex - 1 downTo 0) {
            val factor = ((m - 1 - i) % mod + mod) % mod
            suffix[i] = suffix[i + 1] * factor % mod
        }
        var result = 0L
        for (i in 0 until n + 1) {
            var term = prefix[i] * suffix[i + 1] % mod
            term = f(i + 1) * term % mod
            term = term * (invFactorial(i) * invFactorial(n - i) % mod) % mod
            term = term * if ((n - i) % 2 != 0) mod - 1L else 1L
            term %= mod
            result = (result + term) % mod
        }
        return result.toInt()
    }
}
