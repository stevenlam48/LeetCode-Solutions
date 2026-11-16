package countpathswiththegivenxorvalue

// Time:  O(m * n * r)
// Space: O(n * r)

class Solution {
    fun countPathsWithXorValue(grid: Array<IntArray>, k: Int): Int {
        val mod = 1_000_000_007
        val maxR = 16
        var dp = Array(grid[0].size) { IntArray(maxR) }
        dp[0][0] = 1
        for (row in grid) {
            val newDp = Array(grid[0].size) { IntArray(maxR) }
            for (j in row.indices) {
                for (v in 0 until maxR) {
                    newDp[j][v xor row[j]] =
                        (dp[j][v] + (if (j > 0) newDp[j - 1][v] else 0)) % mod
                }
            }
            dp = newDp
        }
        return dp[dp.lastIndex][k]
    }
}
