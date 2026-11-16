package deleteoperationfortwostrings

// Time:  O(m * n)
// Space: O(n)

class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length

        val dp = Array(2) { IntArray(n + 1) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                dp[(i + 1) % 2][j + 1] = maxOf(
                    maxOf(dp[i % 2][j + 1], dp[(i + 1) % 2][j]),
                    dp[i % 2][j] + (if (word1[i] == word2[j]) 1 else 0)
                )
            }
        }
        return m + n - 2 * dp[m % 2][n]
    }
}
