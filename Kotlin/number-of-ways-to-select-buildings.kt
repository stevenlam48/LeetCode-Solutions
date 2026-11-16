package numberofwaystoselectbuildings

// Time:  O(k * n) = O(n)
// Space: O(k) = O(1)

class Solution {
    fun numberOfWays(s: String): Long {
        val k = 3
        val dp = Array(k) { LongArray(2) }
        for (c in s) {
            val j = c - '0'
            ++dp[0][j]
            for (i in 1 until dp.size) {
                dp[i][j] += dp[i - 1][1 xor j]
            }
        }
        return dp[k - 1][0] + dp[k - 1][1]
    }
}
