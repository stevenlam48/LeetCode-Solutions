package findthenthvalueafterkseconds

// Time:  O(n + k)
// Space: O(n + k)

// combinatorics
class Solution {
    private val MOD = 1_000_000_007L
    private val fact = mutableListOf(1L, 1L)
    private val inv = mutableListOf(1L, 1L)
    private val invFact = mutableListOf(1L, 1L)

    fun valueAfterKSeconds(n: Int, k: Int): Int {
        return nCr((n - 1) + k, n - 1).toInt()
    }

    private fun nCr(n: Int, k: Int): Long {
        if (k < 0 || k > n) {
            return 0
        }
        while (inv.size <= n) {
            val i = inv.size.toLong()
            fact.add(fact.last() * i % MOD)
            inv.add(inv[(MOD % i).toInt()] * (MOD - MOD / i) % MOD)
            invFact.add(invFact.last() * inv.last() % MOD)
        }
        return fact[n] * invFact[n - k] % MOD * invFact[k] % MOD
    }
}
