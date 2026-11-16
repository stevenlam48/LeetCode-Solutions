package minimuminsertionstepstomakeastringpalindrome
// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun minInsertions(s: String): Int {
        val reversedS = s.reversed()
        return s.length - longestCommonSubsequence(s, reversedS)
    }

    private fun longestCommonSubsequence(text1: String, text2: String): Int {
        if (text1.length < text2.length) {
            return longestCommonSubsequence(text2, text1)
        }
        val dp = Array(2) { IntArray(text2.length + 1) }
        for (i in 1..text1.length) {
            for (j in 1..text2.length) {
                dp[i % 2][j] = if (text1[i - 1] == text2[j - 1]) {
                    dp[(i - 1) % 2][j - 1] + 1
                } else {
                    maxOf(dp[(i - 1) % 2][j], dp[i % 2][j - 1])
                }
            }
        }
        return dp[text1.length % 2][text2.length]
    }
}
