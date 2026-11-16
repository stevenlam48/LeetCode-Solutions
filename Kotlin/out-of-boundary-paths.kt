package outofboundarypaths
// Time:  O(N * m * n)
// Space: O(m * n)

class Solution {
    fun findPaths(m: Int, n: Int, N: Int, x: Int, y: Int): Int {
        val mod = 1_000_000_007
        val dp = Array(2) { Array(m) { IntArray(n) } }
        for (moves in 0 until N) {
            for (i in 0 until m) {
                for (j in 0 until n) {
                    dp[(moves + 1) % 2][i][j] = (
                        ((if (i == 0) 1 else dp[moves % 2][i - 1][j]) +
                            (if (i == m - 1) 1 else dp[moves % 2][i + 1][j])) % mod +
                            ((if (j == 0) 1 else dp[moves % 2][i][j - 1]) +
                                (if (j == n - 1) 1 else dp[moves % 2][i][j + 1])) % mod
                        ) % mod
                }
            }
        }
        return dp[N % 2][x][y]
    }
}
