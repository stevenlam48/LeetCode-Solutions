package knightdialer

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun knightDialer(N: Int): Int {
        val T = arrayOf(
            intArrayOf(0, 0, 0, 0, 1, 0, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 1, 0, 1, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 0, 1),
            intArrayOf(0, 0, 0, 0, 1, 0, 0, 0, 1, 0),
            intArrayOf(1, 0, 0, 1, 0, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 0, 0, 0, 1, 0, 0),
            intArrayOf(0, 0, 1, 0, 0, 0, 1, 0, 0, 0),
            intArrayOf(0, 1, 0, 1, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 0, 1, 0, 0, 0, 0, 0)
        )

        val result = matrixExpo(T, N - 1)
        var total = 0
        for (row in result) {
            for (value in row) {
                total = (total + value) % M
            }
        }
        return total
    }

    private fun matrixExpo(A: Array<IntArray>, pow: Int): Array<IntArray> {
        var p = pow
        var result = Array(A.size) { IntArray(A.size) }
        var aExp = Array(A.size) { A[it].copyOf() }
        for (i in A.indices) {
            result[i][i] = 1
        }
        while (p > 0) {
            if (p % 2 == 1) {
                result = matrixMult(result, aExp)
            }
            aExp = matrixMult(aExp, aExp)
            p /= 2
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

    private companion object {
        const val M = 1_000_000_007
    }
}
