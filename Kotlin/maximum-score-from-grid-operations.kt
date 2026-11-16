package maximumscorefromgridoperations

// Time:  O(n^3)
// Space: O(n)

class Solution {
    fun maximumScore(grid: Array<IntArray>): Long {
        var prefix = LongArray(grid.size + 1)
        for (i in grid.indices) {
            prefix[i + 1] = prefix[i] + grid[i][0]
        }
        var dp = Array(2) { LongArray(grid.size + 1) }
        for (j in 1 until grid[0].size) {
            val newPrefix = LongArray(grid.size + 1)
            for (i in grid.indices) {
                newPrefix[i + 1] = newPrefix[i] + grid[i][j]
            }
            val newDp = Array(2) { LongArray(grid.size + 1) }
            for (i in 0..grid.size) {
                for (k in 0..i) {
                    newDp[0][i] = maxOf(newDp[0][i], prefix[i] - prefix[k] + dp[0][k])
                }
                newDp[0][i] = maxOf(newDp[0][i], dp[1].max())
                for (k in i + 1..grid.size) {
                    newDp[1][i] = maxOf(newDp[1][i], dp[1][k] + newPrefix[k] - newPrefix[i])
                }
                newDp[1][i] = maxOf(newDp[1][i], newDp[0][i])
            }
            dp = newDp
            prefix = newPrefix
        }
        return dp[1].max()
    }
}
