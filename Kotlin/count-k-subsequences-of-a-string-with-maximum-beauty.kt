package countksubsequencesofastringwithmaximumbeauty

// Time:  O(n)
// Space: O(1)

// greedy, quick select, combinatorics
class Solution {
    fun countKSubsequencesWithMaxBeauty(s: String, k: Int): Int {
        val cnt = HashMap<Int, Int>()
        for (c in s) {
            cnt[c.code] = cnt.getOrDefault(c.code, 0) + 1
        }
        if (cnt.size < k) {
            return 0
        }
        val freqs = cnt.values.sortedDescending().toMutableList()
        var result = 1L
        for (i in 0 until k) {
            result = mulmod(result, freqs[i].toLong())
        }
        val n = freqs.count { it == freqs[k - 1] }
        val r = freqs.subList(0, k).count { it == freqs[k - 1] }
        return mulmod(result, nCr(n, r)).toInt()
    }

    private fun nCr(n: Int, k: Int): Long {
        while (inv.size <= n) {
            fact.add(mulmod(fact.last(), inv.size.toLong()))
            inv.add(mulmod(inv[(MOD % inv.size).toInt()], MOD - MOD / inv.size))
            invFact.add(mulmod(invFact.last(), inv.last()))
        }
        return mulmod(mulmod(fact[n], invFact[n - k]), invFact[k])
    }

    private fun mulmod(a0: Long, b0: Long): Long {
        var a = a0 % MOD
        var b = b0 % MOD
        var result = 0L
        if (a < b) {
            val t = a
            a = b
            b = t
        }
        while (b > 0) {
            if (b % 2 == 1L) {
                result = (result + a) % MOD
            }
            a = (a + a) % MOD
            b /= 2
        }
        return result
    }

    companion object {
        private const val MOD = 1_000_000_007L
        private val fact = mutableListOf(1L, 1L)
        private val inv = mutableListOf(1L, 1L)
        private val invFact = mutableListOf(1L, 1L)
    }
}
