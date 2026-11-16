package maximumpathscoreinagrid
// Time:  O(m * n * k)
// Space: O(m * n * k)

class Solution {
    fun maxPathScore(grid: Array<IntArray>, k: Int): Int {
        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
        val dp = Array(grid.size) { Array(grid[0].size) { IntArray(k + 1) { -1 } } }
        dp[0][0][0] = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                for (c in 0..k) {
                    if (dp[i][j][c] == -1) {
                        continue
                    }
                    for ((di, dj) in directions) {
                        val ni = i + di
                        val nj = j + dj
                        if (ni !in grid.indices || nj !in grid[0].indices || c + (if (grid[ni][nj] != 0) 1 else 0) > k) {
                            continue
                        }
                        val nc = c + (if (grid[ni][nj] != 0) 1 else 0)
                        dp[ni][nj][nc] = maxOf(dp[ni][nj][nc], dp[i][j][c] + grid[ni][nj])
                    }
                }
            }
        }
        return dp.last().last().maxOrNull()!!
    }
}
