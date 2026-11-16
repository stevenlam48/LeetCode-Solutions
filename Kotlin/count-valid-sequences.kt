package countvalidsequences

// Time:  O(n)
// Space: O(n)

private const val MOD = 1_000_000_007L
private const val MAX_N = 500_000

private object Tables {
    val fact = mutableListOf(1L, 1L)
    val inv = mutableListOf(1L, 1L)
    val invFact = mutableListOf(1L, 1L)

    init {
        ensure(MAX_N)
    }

    fun ensure(n: Int) {
        while (inv.size <= n) {
            val i = inv.size
            fact.add(fact.last() * i % MOD)
            inv.add(inv[(MOD % i).toInt()] * (MOD - MOD / i) % MOD)
            invFact.add(invFact.last() * inv.last() % MOD)
        }
    }
}

private fun nCr(n: Int, k: Int): Long {
    return Tables.fact[n] * Tables.invFact[n - k] % MOD * Tables.invFact[k] % MOD
}

private fun nHr(n: Int, k: Int): Long {
    return nCr(n + k - 1, k)
}

class Solution {
    fun countValidSequences(n: Int, k: Int): Int {
        val total = nHr(k, n - k)
        val subtract = if ((n - k) % 2 == 0) nHr(k, (n - k) / 2) else 0L
        return (((total - subtract) % MOD + MOD) % MOD).toInt()
    }
}
