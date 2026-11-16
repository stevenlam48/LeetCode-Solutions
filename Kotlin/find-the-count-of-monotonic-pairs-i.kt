package findthecountofmonotonicpairsi

// Time:  O(n + r), r = max(nums)
// Space: O(n + r)
class Solution {
    fun countOfPairs(nums: IntArray): Int {
        var cnt = nums.last()
        for (i in 1 until nums.size) {
            cnt -= maxOf(nums[i] - nums[i - 1], 0)
        }
        return if (cnt >= 0) nHr(nums.size + 1, cnt) else 0
    }

    private fun nHr(n: Int, r: Int): Int {
        return nCr(n + r - 1, r)
    }

    private fun nCr(n: Int, k: Int): Int {
        while (inv.size <= n) {
            val size = inv.size
            fact.add(mulMod(fact.last(), size))
            inv.add(mulMod(inv[MOD % size], MOD - MOD / size))
            invFact.add(mulMod(invFact.last(), inv.last()))
        }
        return mulMod(mulMod(fact[n], invFact[n - k]), invFact[k])
    }

    private fun addMod(a0: Int, b0: Int): Int {
        val a = a0 % MOD
        var b = b0 % MOD
        if (MOD - a <= b) {
            b -= MOD
        }
        return a + b
    }

    private fun mulMod(a0: Int, b0: Int): Int {
        var a = a0 % MOD
        var b = b0 % MOD
        var result = 0
        if (a < b) {
            val temp = a
            a = b
            b = temp
        }
        while (b > 0) {
            if ((b and 1) != 0) {
                result = addMod(result, a)
            }
            a = addMod(a, a)
            b = b ushr 1
        }
        return result
    }

    private val fact = mutableListOf(1, 1)
    private val inv = mutableListOf(1, 1)
    private val invFact = mutableListOf(1, 1)

    companion object {
        private const val MOD = 1_000_000_007
    }
}
