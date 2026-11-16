package imagesmoother

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun imageSmoother(M: Array<IntArray>): Array<IntArray> {
        val m = M.size
        val n = M[0].size
        val result = Array(m) { M[it].copyOf() }
        for (i in 0 until m) {
            for (j in 0 until n) {
                result[i][j] = getGray(M, i, j)
            }
        }
        return result
    }

    private fun getGray(M: Array<IntArray>, i: Int, j: Int): Int {
        val m = M.size
        val n = M[0].size
        var total = 0.0
        var count = 0
        for (r in -1..1) {
            for (c in -1..1) {
                val ii = i + r
                val jj = j + c
                if (0 <= ii && ii < m && 0 <= jj && jj < n) {
                    total += M[ii][jj]
                    ++count
                }
            }
        }
        return (total / count).toInt()
    }
}
