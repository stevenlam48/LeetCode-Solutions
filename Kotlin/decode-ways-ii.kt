package decodewaysii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun numDecodings(s: String): Int {
        val M = 1000000007L
        val W = 3
        val dp = LongArray(W)
        dp[0] = 1
        dp[1] = if (s[0] == '*') 9 else (if (s[0] != '0') dp[0] else 0)
        for (i in 1 until s.length) {
            if (s[i] == '*') {
                dp[(i + 1) % W] = 9 * dp[i % W]
                if (s[i - 1] == '1') {
                    dp[(i + 1) % W] = (dp[(i + 1) % W] + 9 * dp[(i - 1) % W]) % M
                } else if (s[i - 1] == '2') {
                    dp[(i + 1) % W] = (dp[(i + 1) % W] + 6 * dp[(i - 1) % W]) % M
                } else if (s[i - 1] == '*') {
                    dp[(i + 1) % W] = (dp[(i + 1) % W] + 15 * dp[(i - 1) % W]) % M
                }
            } else {
                dp[(i + 1) % W] = if (s[i] != '0') dp[i % W] else 0
                if (s[i - 1] == '1') {
                    dp[(i + 1) % W] = (dp[(i + 1) % W] + dp[(i - 1) % W]) % M
                } else if (s[i - 1] == '2' && s[i] <= '6') {
                    dp[(i + 1) % W] = (dp[(i + 1) % W] + dp[(i - 1) % W]) % M
                } else if (s[i - 1] == '*') {
                    dp[(i + 1) % W] = (dp[(i + 1) % W] + (if (s[i] <= '6') 2 else 1) * dp[(i - 1) % W]) % M
                }
            }
        }
        return dp[s.length % W].toInt()
    }
}
