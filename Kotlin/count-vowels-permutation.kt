package countvowelspermutation

// Time:  O(logn)
// Space: O(1)

class Solution {
    private val MOD = 1_000_000_007

    fun countVowelPermutation(n: Int): Int {
        val t = arrayOf(
            intArrayOf(0, 1, 1, 0, 1),
            intArrayOf(1, 0, 1, 0, 0),
            intArrayOf(0, 1, 0, 1, 0),
            intArrayOf(0, 0, 1, 0, 0),
            intArrayOf(0, 0, 1, 1, 0)
        )

        val result = matrixExpo(t, n - 1)
        var total = 0
        for (row in result) {
            for (v in row) {
                total = (total + v) % MOD
            }
        }
        return total
    }

    private fun matrixExpo(a: Array<IntArray>, pow: Int): Array<IntArray> {
        val result = Array(a.size) { IntArray(a.size) }
        var aExp = Array(a.size) { a[it].copyOf() }
        for (i in a.indices) {
            result[i][i] = 1
        }
        var p = pow
        while (p != 0) {
            if (p % 2 == 1) {
                val r = matrixMult(result, aExp)
                for (i in result.indices) {
                    result[i] = r[i]
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
}
