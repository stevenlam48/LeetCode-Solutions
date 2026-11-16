package totalcharactersinstringaftertransformationsii

// Time:  O(n + 26^3 * logt)
// Space: O(26^2)

class Solution {
    fun lengthAfterTransformations(s: String, t: Int, nums: IntArray): Int {
        val cnt = IntArray(26)
        for (x in s) {
            ++cnt[x - 'a']
        }
        val matrix = Array(26) { IntArray(26) }
        for (i in nums.indices) {
            for (j in 1..nums[i]) {
                matrix[i][(i + j) % 26] = 1
            }
        }
        val matrixPowT = matrixExpo(matrix, t.toLong())
        val result = matrixMult(arrayOf(cnt), matrixPowT)
        var sum = 0L
        for (x in result[0]) {
            sum = (sum + x) % MOD
        }
        return sum.toInt()
    }

    private fun matrixExpo(a: Array<IntArray>, pow: Long): Array<IntArray> {
        var p = pow
        val result = Array(a.size) { IntArray(a.size) }
        var aExp = Array(a.size) { i -> a[i].copyOf() }
        for (i in a.indices) {
            result[i][i] = 1
        }
        while (p > 0) {
            if (p % 2L == 1L) {
                val next = matrixMult(result, aExp)
                for (i in next.indices) {
                    next[i].copyInto(result[i])
                }
            }
            aExp = matrixMult(aExp, aExp)
            p /= 2
        }
        return result
    }

    private fun matrixMult(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
        val result = Array(a.size) { IntArray(b[0].size) }
        for (i in a.indices) {
            for (j in b[0].indices) {
                var entry = 0L
                for (k in b.indices) {
                    entry = (a[i][k].toLong() * b[k][j] % MOD + entry) % MOD
                }
                result[i][j] = entry.toInt()
            }
        }
        return result
    }

    companion object {
        private const val MOD = 1_000_000_007L
    }
}
