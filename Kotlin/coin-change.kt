package coinchange

// Time:  O(n * k), n is the number of coins, k is the amount of money
// Space: O(k)


class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { Int.MAX_VALUE }
        dp[0] = 0
        for (i in 0..amount) {
            if (dp[i] != Int.MAX_VALUE) {
                for (coin in coins) {
                    if (coin <= amount - i) {
                        dp[i + coin] = minOf(dp[i + coin], dp[i] + 1)
                    }
                }
            }
        }
        return if (dp[amount] == Int.MAX_VALUE) -1 else dp[amount]
    }
}
