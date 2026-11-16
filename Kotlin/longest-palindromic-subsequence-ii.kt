package longestpalindromicsubsequenceii

// Time:  O(n^2)
// Space: O(n)

class Solution {
    private val dp = Array(2) { Array(250) { IntArray(26) } }

    fun longestPalindromeSubseq(s: String): Int {
        val n = s.length
        if (n == 0) {
            return 0
        }
        for (i in n - 1 downTo 0) {
            for (j in i + 1 until n) {
                if (i == j - 1) {
                    if (s[j] == s[i]) {
                        dp[i % 2][j][s[j] - 'a'] = 2
                    }
                } else {
                    for (k in 0 until 26) {
                        if (s[j] == s[i] && s[j] - 'a' != k) {
                            dp[i % 2][j][s[j] - 'a'] = maxOf(
                                dp[i % 2][j][s[j] - 'a'],
                                dp[(i + 1) % 2][j - 1][k] + 2
                            )
                        }
                        dp[i % 2][j][k] = maxOf(dp[i % 2][j][k], dp[i % 2][j - 1][k])
                        dp[i % 2][j][k] = maxOf(dp[i % 2][j][k], dp[(i + 1) % 2][j][k])
                        dp[i % 2][j][k] = maxOf(dp[i % 2][j][k], dp[(i + 1) % 2][j - 1][k])
                    }
                }
            }
        }
        return dp[0][n - 1].max()
    }
}
