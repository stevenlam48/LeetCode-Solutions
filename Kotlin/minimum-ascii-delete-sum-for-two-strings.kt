package minimumasciideletesumfortwostrings

// Time:  O(m * n)
// Space: O(n)

class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val dp = Array(2) { IntArray(s2.length + 1) }
        for (j in s2.indices) {
            dp[0][j + 1] = dp[0][j] + s2[j].code
        }
        for (i in s1.indices) {
            dp[(i + 1) % 2][0] = dp[i % 2][0] + s1[i].code
            for (j in s2.indices) {
                if (s1[i] == s2[j]) {
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j]
                } else {
                    dp[(i + 1) % 2][j + 1] = minOf(
                        dp[i % 2][j + 1] + s1[i].code,
                        dp[(i + 1) % 2][j] + s2[j].code
                    )
                }
            }
        }
        return dp[s1.length % 2][s2.length]
    }
}
