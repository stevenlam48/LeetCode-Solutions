package validpalindromeiii

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun isValidPalindrome(s: String, k: Int): Boolean {
        if (s == s.reversed()) {
            return true
        }

        val n = s.length
        val dp = Array(2) { IntArray(n) { 1 } }
        for (i in n - 2 downTo 0) {
            for (j in i + 1 until n) {
                if (s[i] == s[j]) {
                    dp[i % 2][j] = if (i + 1 <= j - 1) 2 + dp[(i + 1) % 2][j - 1] else 2
                } else {
                    dp[i % 2][j] = maxOf(dp[(i + 1) % 2][j], dp[i % 2][j - 1])
                }
            }
        }
        return n <= k + dp[0][n - 1]
    }
}
