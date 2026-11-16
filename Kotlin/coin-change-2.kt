package coinchange2

// Time:  O(n * m)
// Space: O(m)


class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1)
        dp[0] = 1
        for (coin in coins) {
            for (i in coin..amount) {
                dp[i] += dp[i - coin]
            }
        }
        return dp[amount]
    }
}
