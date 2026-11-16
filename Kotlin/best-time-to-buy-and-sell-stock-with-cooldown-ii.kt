package besttimetobuyandsellstockwithcooldownii

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun maxProfit(prices: IntArray, cooldown: Int, costs: IntArray): Int {
        val dp = IntArray(prices.size + 1)
        for (j in prices.indices) {
            var mx = dp[j]
            for (i in 0 until j) {
                mx = kotlin.math.max(
                    mx,
                    dp[kotlin.math.max((i + 1) - (cooldown + 1), 0)] + prices[j] - prices[i] - costs[j - i],
                )
            }
            dp[j + 1] = mx
        }
        return dp[prices.size]
    }
}
