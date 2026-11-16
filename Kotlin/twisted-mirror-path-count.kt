package twistedmirrorpathcount
// Time:  O(m * n)
// Space: O(min(m, n))

class Solution {
    fun uniquePaths(grid: Array<IntArray>): Int {
        val mod = 1_000_000_007
        fun get(r: Int, c: Int): Int {
            return if (grid.size > grid[0].size) grid[r][c] else grid[c][r]
        }
        val dp = Array(minOf(grid.size, grid[0].size) + 1) { 0 to 0 }
        dp[1] = 1 to 1
        for (r in 0 until maxOf(grid.size, grid[0].size)) {
            for (c in 0 until dp.size - 1) {
                if (get(r, c) != 0) {
                    dp[c + 1] = dp[c + 1].second to dp[c].first
                } else {
                    val paths = (dp[c + 1].second + dp[c].first) % mod
                    dp[c + 1] = paths to paths
                }
            }
        }
        return dp.last().first
    }
}
