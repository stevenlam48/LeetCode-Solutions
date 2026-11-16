package maximizepalindromelengthfromsubsequences

// Time:  O((m + n)^2)
// Space: O((m + n)^2)

class Solution {
    fun longestPalindrome(word1: String, word2: String): Int {
        val s = word1 + word2
        val dp = Array(s.length) { IntArray(s.length) }
        var result = 0
        for (j in s.indices) {
            dp[j][j] = 1
            for (i in j - 1 downTo 0) {
                if (s[i] == s[j]) {
                    dp[i][j] = if (i + 1 == j) 2 else dp[i + 1][j - 1] + 2
                    if (i < word1.length && word1.length <= j) {
                        result = maxOf(result, dp[i][j])
                    }
                } else {
                    dp[i][j] = maxOf(dp[i + 1][j], dp[i][j - 1])
                }
            }
        }
        return result
    }
}
