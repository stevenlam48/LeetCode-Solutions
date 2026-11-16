package minimumpathcostinagrid
// Time:  O(m * n^2)
// Space: O(n)

class Solution {
    fun minPathCost(grid: Array<IntArray>, moveCost: Array<IntArray>): Int {
        val dp = Array(2) { IntArray(grid[0].size) }
        for (j in grid[0].indices) {
            dp[0][j] = grid[0][j]
        }
        for (i in 0 until grid.size - 1) {
            dp[(i + 1) % 2] = IntArray(grid[0].size) { Int.MAX_VALUE }
            for (k in grid[0].indices) {
                for (j in grid[0].indices) {
                    dp[(i + 1) % 2][j] = minOf(
                        dp[(i + 1) % 2][j],
                        dp[i % 2][k] + moveCost[grid[i][k]][j] + grid[i + 1][j]
                    )
                }
            }
        }
        return dp[(grid.size - 1) % 2].min()
    }
}
