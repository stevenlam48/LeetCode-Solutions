package maximumnonnegativeproductinamatrix

// Time:  O(m * n)
// Space: O(n)

class Solution {
    fun maxProductPath(grid: Array<IntArray>): Int {
        val mod = 1_000_000_007
        val cols = grid[0].size
        val maxDp = Array(2) { LongArray(cols) }
        val minDp = Array(2) { LongArray(cols) }
        for (i in grid.indices) {
            for (j in 0 until cols) {
                if (i == 0 && j == 0) {
                    maxDp[0][0] = grid[0][0].toLong()
                    minDp[0][0] = grid[0][0].toLong()
                    continue
                }
                var currMax = maxOf(
                    if (i > 0) maxDp[(i - 1) % 2][j] else maxDp[i % 2][j - 1],
                    if (j > 0) maxDp[i % 2][j - 1] else maxDp[(i - 1) % 2][j]
                )
                var currMin = minOf(
                    if (i > 0) minDp[(i - 1) % 2][j] else minDp[i % 2][j - 1],
                    if (j > 0) minDp[i % 2][j - 1] else minDp[(i - 1) % 2][j]
                )
                if (grid[i][j] < 0) {
                    val tmp = currMax
                    currMax = currMin
                    currMin = tmp
                }
                maxDp[i % 2][j] = currMax * grid[i][j]
                minDp[i % 2][j] = currMin * grid[i][j]
            }
        }
        val best = maxDp[(grid.size - 1) % 2].last()
        return if (best >= 0) (best % mod).toInt() else -1
    }
}
