package pathsinmatrixwhosesumisdivisiblebyk

// Time:  O(m * n * k)
// Space: O(n * k)

class Solution {
    fun numberOfPaths(grid: Array<IntArray>, k: Int): Int {
        val MOD = 1_000_000_007
        val dp = Array(grid[0].size) { IntArray(k) }
        dp[0][0] = 1
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                val cnt = IntArray(k)
                for (l in 0 until k) {
                    cnt[(l + grid[i][j]) % k] = ((if (j - 1 >= 0) dp[j - 1][l] else 0) + dp[j][l]) % MOD
                }
                dp[j] = cnt
            }
        }
        return dp[dp.size - 1][0]
    }
}
