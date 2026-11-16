package besttimetobuyandsellstockusingstrategy

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxProfit(prices: IntArray, strategy: IntArray, k: Int): Long {
        var result = 0L
        var curr = 0L
        for (i in prices.indices) {
            curr += if (i < k) {
                prices[i].toLong() * (if (i < k / 2) 0 else 1)
            } else {
                prices[i].toLong() * strategy[i]
            }
            result += prices[i].toLong() * strategy[i]
        }
        result = kotlin.math.max(result, curr)
        for (i in k until prices.size) {
            curr += (prices[i - k].toLong() * strategy[i - k]) +
                (prices[i] - prices[i - k / 2]) -
                (prices[i].toLong() * strategy[i])
            result = kotlin.math.max(result, curr)
        }
        return result
    }
}
