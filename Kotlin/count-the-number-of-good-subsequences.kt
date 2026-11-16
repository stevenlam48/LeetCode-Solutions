package countthenumberofgoodsubsequences

// Time:  O(26 * n)
// Space: O(n)

// combinatorics
class Solution {
    private val MOD = 1_000_000_007L
    private val fact = mutableListOf(1L, 1L)
    private val inv = mutableListOf(1L, 1L)
    private val invFact = mutableListOf(1L, 1L)

    fun countGoodSubsequences(s: String): Int {
        val cnt = IntArray(26)
        for (c in s) {
            ++cnt[c - 'a']
        }
        var result = 0L
        for (k in 1..s.length) {
            var curr = 1L
            for (i in cnt.indices) {
                curr = curr * ((1 + nCr(cnt[i], k)) % MOD) % MOD
            }
            result = (result + curr - 1 + MOD) % MOD
        }
        return result.toInt()
    }

    private fun nCr(n: Int, k: Int): Long {
        if (k < 0 || k > n) {
            return 0L
        }
        while (inv.size <= n) {  // lazy initialization
            fact.add(fact.last() * inv.size % MOD)
            inv.add(inv[(MOD % inv.size).toInt()] * (MOD - MOD / inv.size) % MOD)
            invFact.add(invFact.last() * inv.last() % MOD)
        }
        return fact[n] * invFact[n - k] % MOD * invFact[k] % MOD
    }
}
