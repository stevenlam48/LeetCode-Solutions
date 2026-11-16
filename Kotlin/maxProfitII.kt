package maxProfitII

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        var ans = 0

        for (i in 1 until n) {
            val diff = prices[i] - prices[i - 1]
            if (diff > 0) ans += diff
        }

        return ans
    }
}
