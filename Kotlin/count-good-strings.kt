package countgoodstrings

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun countGoodStrings(n: Long): Int {
        val t = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 0)
        )
        return matrixMult(arrayOf(intArrayOf(2, 0)), matrixExpo(t, n))[0][1]
    }

    private fun matrixExpo(a: Array<IntArray>, power: Long): Array<IntArray> {
        val result = Array(a.size) { IntArray(a.size) }
        var aExp = a
        for (i in a.indices) {
            result[i][i] = 1
        }
        var pow = power
        while (pow != 0L) {
            if (pow and 1L == 1L) {
                val multiplied = matrixMult(result, aExp)
                for (i in result.indices) {
                    result[i] = multiplied[i]
                }
            }
            aExp = matrixMult(aExp, aExp)
            pow = pow shr 1
        }
        return result
    }

    private fun matrixMult(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
        val mod = 1000000007L
        val result = Array(a.size) { IntArray(b[0].size) }
        for (i in a.indices) {
            for (j in b[0].indices) {
                var entry = 0L
                for (k in b.indices) {
                    entry = (a[i][k].toLong() * b[k][j] % mod + entry) % mod
                }
                result[i][j] = entry.toInt()
            }
        }
        return result
    }
}
