package stringtransformation
// Time:  O(n + logk)
// Space: O(n)

class Solution {
    fun numberOfWays(s: String, t: String, k: Long): Int {
        val n = s.length
        val dp = IntArray(2)
        val nonzero = ((pow((n - 1).toLong(), k, MOD) - pow(-1, k, MOD)) *
            pow(n.toLong(), MOD - 2L, MOD) % MOD + MOD) % MOD
        dp[1] = nonzero.toInt()
        dp[0] = ((dp[1] + pow(-1, k, MOD)) % MOD).toInt()
        var result = 0
        for (i in kmp(s + s.substring(0, s.length - 1), t)) {
            result = ((result + dp[if (i != 0) 1 else 0]) % MOD).toInt()
        }
        return result
    }

    private fun pow(a: Long, b: Long, m: Long): Long {
        var base = a % m
        var exponent = b
        var result = 1L
        while (exponent != 0L) {
            if (exponent and 1L != 0L) {
                result = result * base % m
            }
            base = base * base % m
            exponent = exponent shr 1
        }
        return result
    }

    private fun kmp(text: String, pattern: String): List<Int> {
        val result = mutableListOf<Int>()
        val prefix = getPrefix(pattern)
        var j = -1
        for (i in text.indices) {
            while (j > -1 && pattern[j + 1] != text[i]) {
                j = prefix[j]
            }
            if (pattern[j + 1] == text[i]) {
                ++j
            }
            if (j == pattern.length - 1) {
                result.add(i - j)
                j = prefix[j]
            }
        }
        return result
    }

    private fun getPrefix(pattern: String): IntArray {
        val prefix = IntArray(pattern.length) { -1 }
        var j = -1
        for (i in 1 until pattern.length) {
            while (j > -1 && pattern[j + 1] != pattern[i]) {
                j = prefix[j]
            }
            if (pattern[j + 1] == pattern[i]) {
                ++j
            }
            prefix[i] = j
        }
        return prefix
    }

    private companion object {
        const val MOD = 1_000_000_007L
    }
}
