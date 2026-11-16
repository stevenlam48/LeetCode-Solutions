package besttimetobuyandsellstockv

// Time:  O(n * k)
// Space: O(k)

class Solution {
    fun maximumProfit(prices: IntArray, k: Int): Long {
        val NEG_INF = Long.MIN_VALUE

        var dp = LongArray(prices.size + 1)
        var result = 0L
        for (i in 0 until k) {
            val newDp = LongArray(prices.size + 1) { NEG_INF }
            var x = NEG_INF
            var y = NEG_INF
            for (j in i until prices.size) {
                x = kotlin.math.max(x, dp[j] - prices[j])
                y = kotlin.math.max(y, dp[j] + prices[j])
                newDp[j + 1] = maxOf(newDp[j], x + prices[j], y - prices[j])
            }
            dp = newDp
            result = kotlin.math.max(result, dp[prices.size])
        }
        return result
    }
}
