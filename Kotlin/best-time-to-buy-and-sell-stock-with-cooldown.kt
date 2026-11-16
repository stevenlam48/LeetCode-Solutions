package besttimetobuyandsellstockwithcooldown

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }
        val buy = IntArray(2)
        val sell = IntArray(2)
        val coolDown = IntArray(2)
        buy[0] = -prices[0]
        for (i in 1 until prices.size) {
            buy[i % 2] = kotlin.math.max(buy[(i - 1) % 2], coolDown[(i - 1) % 2] - prices[i])
            sell[i % 2] = buy[(i - 1) % 2] + prices[i]
            coolDown[i % 2] = kotlin.math.max(coolDown[(i - 1) % 2], sell[(i - 1) % 2])
        }
        return kotlin.math.max(coolDown[(prices.size - 1) % 2], sell[(prices.size - 1) % 2])
    }
}
