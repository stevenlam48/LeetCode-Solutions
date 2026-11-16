package removealloneswithrowandcolumnflipsii
// Time:  O(m * n * 2^(m * n))
// Space: O(2^(m * n))

class Solution {
    fun removeOnes(grid: Array<IntArray>): Int {
        val inf = Int.MAX_VALUE
        val rows = IntArray(grid.size)
        var mask = 0
        var bit = 1
        for (j in grid[0].indices) {
            mask += bit
            bit = bit shl 1
        }
        for (i in grid.indices) {
            rows[i] = mask
            mask = mask shl grid[0].size
        }

        val cols = IntArray(grid[0].size)
        mask = 0
        bit = 1
        for (i in grid.indices) {
            mask += bit
            bit = bit shl grid[0].size
        }
        for (j in grid[0].indices) {
            cols[j] = mask
            mask = mask shl 1
        }

        val fullMask = (1 shl (grid.size * grid[0].size)) - 1
        val masks = Array(grid.size) { IntArray(grid[0].size) { fullMask } }
        var target = 0
        bit = 1
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                target += bit * grid[i][j]
                masks[i][j] -= rows[i] + cols[j] - bit
                bit = bit shl 1
            }
        }

        val dp = IntArray(target + 1) { inf }
        dp[0] = 0
        for (current in 1..target) {
            for (i in grid.indices) {
                for (j in grid[0].indices) {
                    if (grid[i][j] != 0 && dp[current and masks[i][j]] != inf) {
                        dp[current] = minOf(dp[current], dp[current and masks[i][j]] + 1)
                    }
                }
            }
        }
        return dp[target]
    }
}
