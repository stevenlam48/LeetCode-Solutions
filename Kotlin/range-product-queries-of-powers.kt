package rangeproductqueriesofpowers

// Time:  O(logn + qlogr), r = MOD
// Space: O(logn)

// prefix sum
class Solution {
    fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
        val prefix = mutableListOf(0)
        var i = 0
        while ((1 shl i) <= n) {
            if (((1 shl i) and n) != 0) {
                prefix.add(prefix[prefix.size - 1] + i)
            }
            ++i
        }
        val result = mutableListOf<Int>()
        for (q in queries) {
            result.add(powmod(2L, (prefix[q[1] + 1] - prefix[q[0]]).toLong(), MOD).toInt())
        }
        return result.toIntArray()
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

    companion object {
        private const val MOD = 1000000007L
    }
}
