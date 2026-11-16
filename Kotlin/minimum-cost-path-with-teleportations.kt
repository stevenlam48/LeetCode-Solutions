package minimumcostpathwithteleportations

// Time:  O(k * (m * n + r))
// Space: O(m * n + r)

class Solution {
    fun minCost(grid: Array<IntArray>, k: Int): Int {
        val INF = Int.MAX_VALUE
        val m = grid.size
        val n = grid[0].size
        var mx = 0
        for (row in grid) {
            val v = row.max()
            if (v > mx) {
                mx = v
            }
        }
        val dp = Array(m) { IntArray(n) { INF } }
        dp[m - 1][n - 1] = 0
        val prefix = IntArray(mx + 1) { INF }
        repeat(k + 1) {
            for (r in m - 1 downTo 0) {
                for (c in n - 1 downTo 0) {
                    if (r + 1 < m && dp[r + 1][c] != INF) {
                        val cand = dp[r + 1][c] + grid[r + 1][c]
                        if (cand < dp[r][c]) {
                            dp[r][c] = cand
                        }
                    }
                    if (c + 1 < n && dp[r][c + 1] != INF) {
                        val cand = dp[r][c + 1] + grid[r][c + 1]
                        if (cand < dp[r][c]) {
                            dp[r][c] = cand
                        }
                    }
                    if (prefix[grid[r][c]] < dp[r][c]) {
                        dp[r][c] = prefix[grid[r][c]]
                    }
                }
            }
            for (r in 0 until m) {
                for (c in 0 until n) {
                    if (dp[r][c] < prefix[grid[r][c]]) {
                        prefix[grid[r][c]] = dp[r][c]
                    }
                }
            }
            for (i in 0 until mx) {
                if (prefix[i] < prefix[i + 1]) {
                    prefix[i + 1] = prefix[i]
                }
            }
        }
        return dp[0][0]
    }
}
