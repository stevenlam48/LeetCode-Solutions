package matrixblocksum

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun matrixBlockSum(mat: Array<IntArray>, K: Int): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        val accu = Array(m + 1) { IntArray(n + 1) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                accu[i + 1][j + 1] = accu[i + 1][j] + accu[i][j + 1] - accu[i][j] + mat[i][j]
            }
        }
        val result = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                val r1 = maxOf(i - K, 0)
                val c1 = maxOf(j - K, 0)
                val r2 = minOf(i + K + 1, m)
                val c2 = minOf(j + K + 1, n)
                result[i][j] = accu[r2][c2] - accu[r1][c2] - accu[r2][c1] + accu[r1][c1]
            }
        }
        return result
    }
}
