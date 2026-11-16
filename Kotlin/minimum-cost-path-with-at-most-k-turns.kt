package minimumcostpathwithatmostkturns

// Time:  O(m * n * k)
// Space: O(m * n)

class Solution {
    fun minCost(grid: Array<IntArray>, k: Int): Int {
        val INF = Int.MAX_VALUE
        val m = grid.size
        val n = grid[0].size

        var dp = Array(m) { IntArray(n) { INF } }
        dp[0][0] = grid[0][0]
        for (step in 0..k) {
            val newDp = Array(m) { dp[it].clone() }
            for (i in 0 until m) {
                var mn = INF
                for (j in 0 until n) {
                    if (mn != INF) {
                        mn += grid[i][j]
                    }
                    mn = minOf(mn, dp[i][j])
                    newDp[i][j] = minOf(newDp[i][j], mn)
                }
                mn = INF
                for (j in n - 1 downTo 0) {
                    if (mn != INF) {
                        mn += grid[i][j]
                    }
                    mn = minOf(mn, dp[i][j])
                    newDp[i][j] = minOf(newDp[i][j], mn)
                }
            }
            for (j in 0 until n) {
                var mn = INF
                for (i in 0 until m) {
                    if (mn != INF) {
                        mn += grid[i][j]
                    }
                    mn = minOf(mn, dp[i][j])
                    newDp[i][j] = minOf(newDp[i][j], mn)
                }
                mn = INF
                for (i in m - 1 downTo 0) {
                    if (mn != INF) {
                        mn += grid[i][j]
                    }
                    mn = minOf(mn, dp[i][j])
                    newDp[i][j] = minOf(newDp[i][j], mn)
                }
            }
            dp = newDp
        }
        return if (dp[m - 1][n - 1] != INF) dp[m - 1][n - 1] else -1
    }
}
