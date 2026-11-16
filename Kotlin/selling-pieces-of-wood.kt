package sellingpiecesofwood

// Time:  O(m * n * (m + n))
// Space: O(m * n)

class Solution {
    fun sellingWood(m: Int, n: Int, prices: Array<IntArray>): Long {
        val dp = Array(m + 1) { LongArray(n + 1) }
        for (p in prices) {
            dp[p[0]][p[1]] = p[2].toLong()
        }
        for (i in 1..m) {
            for (j in 1..n) {
                for (k in 1..i / 2) {
                    dp[i][j] = maxOf(dp[i][j], dp[k][j] + dp[i - k][j])
                }
                for (k in 1..j / 2) {
                    dp[i][j] = maxOf(dp[i][j], dp[i][k] + dp[i][j - k])
                }
            }
        }
        return dp[m][n]
    }
}
