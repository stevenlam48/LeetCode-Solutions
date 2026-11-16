package directionassignmentswithexactlykvisiblepeople

// Time:  O(n)
// Space: O(n)

// combinatorics
class Solution {
    fun countVisiblePeople(n: Int, pos: Int, k: Int): Int {
        return ((nCr(n - 1, k) * 2) % MOD).toInt()
    }

    private fun nCr(n: Int, k: Int): Long {
        while (INV.size <= n) {  // lazy initialization
            val i = INV.size
            FACT.add(FACT.last() * i % MOD)
            INV.add(INV[(MOD % i).toInt()] * (MOD - MOD / i) % MOD)
            INV_FACT.add(INV_FACT.last() * INV.last() % MOD)
        }
        return (((FACT[n] * INV_FACT[n - k]) % MOD) * INV_FACT[k]) % MOD
    }

    companion object {
        private const val MOD = 1_000_000_007L
        private val FACT = mutableListOf(1L, 1L)
        private val INV = mutableListOf(1L, 1L)
        private val INV_FACT = mutableListOf(1L, 1L)
    }
}
