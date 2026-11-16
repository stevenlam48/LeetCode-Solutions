package findtheindexofpermutation

// Time:  O(nlogn)
// Space: O(n)

private const val MOD = 1_000_000_007L

class Solution {
    fun getPermutationIndex(perm: IntArray): Int {
        val fact = IntArray(perm.size + 1)
        fact[0] = 1
        for (i in 0 until fact.size - 1) {
            fact[i + 1] = ((i + 1).toLong() * fact[i] % MOD).toInt()
        }
        var result = 0L
        val bit = BIT(perm.size)
        for (i in perm.indices) {
            val cnt = (((perm[i] - 1) - bit.query(perm[i] - 2)).toLong() % MOD + MOD) % MOD
            result = (result + cnt * fact[(perm.size - 1) - i] % MOD) % MOD
            bit.add(perm[i] - 1, 1)
        }
        return result.toInt()
    }

    private class BIT(n: Int) {
        private val bit = IntArray(n + 1)

        fun add(i0: Int, v: Int) {
            var i = i0 + 1
            while (i < bit.size) {
                bit[i] = ((bit[i] + v) % MOD).toInt()
                i += i and -i
            }
        }

        fun query(i0: Int): Int {
            var i = i0 + 1
            var total = 0
            while (i > 0) {
                total = ((total + bit[i]) % MOD).toInt()
                i -= i and -i
            }
            return total
        }
    }
}
