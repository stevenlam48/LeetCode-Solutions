package validpermutationsfordisequence

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun numPermsDISequence(S: String): Int {
        val M = 1_000_000_007
        val n = S.length
        val dp = Array(2) { IntArray(n + 1) { 1 } }
        for (i in 0 until n) {
            if (S[i] == 'I') {
                dp[(i + 1) % 2][0] = dp[i % 2][0]
                for (j in 1 until n - i) {
                    dp[(i + 1) % 2][j] = (dp[(i + 1) % 2][j - 1] + dp[i % 2][j]) % M
                }
            } else {
                dp[(i + 1) % 2][n - i - 1] = dp[i % 2][n - i]
                for (j in n - i - 2 downTo 0) {
                    dp[(i + 1) % 2][j] = (dp[(i + 1) % 2][j + 1] + dp[i % 2][j + 1]) % M
                }
            }
        }
        return dp[n % 2][0]
    }
}
