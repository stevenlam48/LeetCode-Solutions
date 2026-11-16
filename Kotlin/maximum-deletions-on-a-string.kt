package maximumdeletionsonastring

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun deleteString(s: String): Int {
        if (s.all { it == s[0] }) {
            return s.length
        }
        val dp2 = Array(2) { IntArray(s.length + 1) }
        val dp = IntArray(s.length) { 1 }
        for (i in s.length - 2 downTo 0) {
            for (j in i + 1 until s.length) {
                dp2[i % 2][j] = if (s[j] == s[i]) dp2[(i + 1) % 2][j + 1] + 1 else 0
                if (dp2[i % 2][j] >= j - i) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }
        return dp[0]
    }
}
