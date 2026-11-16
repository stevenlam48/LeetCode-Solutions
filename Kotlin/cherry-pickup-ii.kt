package cherrypickupii

// Time:  O(m * n^2)
// Space: O(n^2)

class Solution {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(2) { Array(n + 2) { IntArray(n + 2) { Int.MIN_VALUE } } }

        dp[0][1][n] = grid[0][0] + grid[0][n - 1]
        var result = 0
        for (i in 1 until m) {
            for (j in 1..n) {
                for (k in 1..n) {
                    var maxPrevDp = Int.MIN_VALUE
                    for (d1 in -1..1) {
                        for (d2 in -1..1) {
                            maxPrevDp = maxOf(maxPrevDp, dp[(i - 1) % 2][j + d1][k + d2])
                        }
                    }
                    dp[i % 2][j][k] = if (maxPrevDp == Int.MIN_VALUE) {
                        Int.MIN_VALUE
                    } else {
                        maxPrevDp + if (j != k) grid[i][j - 1] + grid[i][k - 1] else grid[i][j - 1]
                    }
                    result = maxOf(result, dp[i % 2][j][k])
                }
            }
        }
        return result
    }
}
