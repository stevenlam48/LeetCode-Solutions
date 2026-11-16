package maximumnumberofmovesinagrid
// Time:  O(m * n)
// Space: O(m)

class Solution {
    fun maxMoves(grid: Array<IntArray>): Int {
        var dp = BooleanArray(grid.size) { true }
        var c = 0
        while (c < grid[0].size - 1) {
            val newDp = BooleanArray(grid.size)
            for (r in grid.indices) {
                if (!dp[r]) {
                    continue
                }
                if (grid[r][c] < grid[r][c + 1]) {
                    newDp[r] = true
                }
                if (r - 1 >= 0 && grid[r][c] < grid[r - 1][c + 1]) {
                    newDp[r - 1] = true
                }
                if (r + 1 < grid.size && grid[r][c] < grid[r + 1][c + 1]) {
                    newDp[r + 1] = true
                }
            }
            dp = newDp
            if (dp.none { it }) {
                break
            }
            ++c
        }
        return c
    }
}
