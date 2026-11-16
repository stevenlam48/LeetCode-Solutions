package findallpossiblestablebinaryarraysi

// Time:  O(n * m)
// Space: O(n * m)

class Solution {
    fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
        val mod = 1_000_000_007
        val dp = Array(zero + 1) { Array(one + 1) { IntArray(2) } }
        for (i in 0..zero) {
            dp[i][0][0] = if (i <= limit) 1 else 0
        }
        for (j in 0..one) {
            dp[0][j][1] = if (j <= limit) 1 else 0
        }
        for (i in 1..zero) {
            for (j in 1..one) {
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % mod
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % mod
                if (i - limit - 1 >= 0) {
                    dp[i][j][0] = ((dp[i][j][0] - dp[i - limit - 1][j][1]) % mod + mod) % mod
                }
                if (j - limit - 1 >= 0) {
                    dp[i][j][1] = ((dp[i][j][1] - dp[i][j - limit - 1][0]) % mod + mod) % mod
                }
            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % mod
    }
}
