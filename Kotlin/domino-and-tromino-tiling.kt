package dominoandtrominotiling

// Time:  O(logn)
// Space: O(logn)

class Solution {
    fun numTilings(N: Int): Int {
        val T = arrayOf(
            intArrayOf(1, 0, 0, 1),
            intArrayOf(1, 0, 1, 0),
            intArrayOf(1, 1, 0, 0),
            intArrayOf(1, 1, 1, 0)
        )
        return matrixMult(arrayOf(intArrayOf(1, 0, 0, 0)), matrixExpo(T, N))[0][0]
    }

    private fun matrixExpo(A: Array<IntArray>, pow0: Int): Array<IntArray> {
        var pow = pow0
        val result = Array(A.size) { IntArray(A.size) }
        var aExp = A.map { it.copyOf() }.toTypedArray()
        for (i in A.indices) {
            result[i][i] = 1
        }
        while (pow != 0) {
            if (pow % 2 == 1) {
                val r = matrixMult(result, aExp)
                for (i in r.indices) {
                    result[i] = r[i]
                }
            }
            aExp = matrixMult(aExp, aExp)
            pow /= 2
        }
        return result
    }

    private fun matrixMult(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        val result = Array(A.size) { IntArray(B[0].size) }
        for (i in A.indices) {
            for (j in B[0].indices) {
                var entry = 0L
                for (k in B.indices) {
                    entry = (A[i][k].toLong() * B[k][j] % M + entry) % M
                }
                result[i][j] = entry.toInt()
            }
        }
        return result
    }

    private val M = 1_000_000_007
}
