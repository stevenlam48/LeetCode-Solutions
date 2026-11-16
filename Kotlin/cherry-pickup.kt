package cherrypickup

// Time:  O(n^3)
// Space: O(n^2)

class Solution {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val n = grid.size
        val dp = Array(n) { IntArray(n) { -1 } }
        dp[0][0] = grid[0][0]

        val maxLen = 2 * (n - 1)
        for (k in 1..maxLen) {
            val directions = arrayOf(
                intArrayOf(0, 0),
                intArrayOf(-1, 0),
                intArrayOf(0, -1),
                intArrayOf(-1, -1)
            )
            for (i in minOf(k, n - 1) downTo maxOf(0, k - n + 1)) {
                for (j in minOf(k, n - 1) downTo i) {
                    if (grid[i][k - i] == -1 || grid[j][k - j] == -1) {
                        dp[i][j] = -1
                        continue
                    }
                    val cnt = grid[i][k - i] + if (i == j) 0 else grid[j][k - j]
                    var maxCnt = -1
                    for (direction in directions) {
                        val ii = i + direction[0]
                        val jj = j + direction[1]
                        if (ii >= 0 && jj >= 0 && dp[ii][jj] >= 0) {
                            maxCnt = maxOf(maxCnt, dp[ii][jj] + cnt)
                        }
                    }
                    dp[i][j] = maxCnt
                }
            }
        }
        return maxOf(dp[n - 1][n - 1], 0)
    }
}
