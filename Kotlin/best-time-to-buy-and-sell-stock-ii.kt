package besttimetobuyandsellstockii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        for (i in 1 until prices.size) {
            result += kotlin.math.max(0, prices[i] - prices[i - 1])
        }
        return result
    }
}
