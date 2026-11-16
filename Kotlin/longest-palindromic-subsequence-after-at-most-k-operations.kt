package longestpalindromicsubsequenceafteratmostkoperations

// Time:  O(n^2 * k)
// Space: O(n^2 * k)

// dp
class Solution {
    fun longestPalindromicSubsequence(s: String, k: Int): Int {
        val n = s.length
        if (n == 0) {
            return 0
        }
        val dp = Array(n) { Array(n) { IntArray(k + 1) } }
        for (i in 0 until n) {
            for (x in 0..k) {
                dp[i][i][x] = 1
            }
        }
        for (i in n - 2 downTo 0) {
            for (j in i + 1 until n) {
                for (x in 0..k) {
                    if (s[i] == s[j]) {
                        dp[i][j][x] = dp[i + 1][j - 1][x] + 2
                    } else {
                        dp[i][j][x] = maxOf(dp[i + 1][j][x], dp[i][j - 1][x])
                        val diff = kotlin.math.abs(s[i] - s[j])
                        val c = minOf(diff, 26 - diff)
                        if (x >= c) {
                            dp[i][j][x] = maxOf(dp[i][j][x], dp[i + 1][j - 1][x - c] + 2)
                        }
                    }
                }
            }
        }
        return dp[0][n - 1][k]
    }
}
