package maxProfitIII

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size

        if (n < 2) return 0

        val f = IntArray(n)
        val g = IntArray(n)

        var valley = prices[0]
        for (i in 1 until n) {
            f[i] = maxOf(f[i - 1], prices[i] - valley)
            valley = minOf(valley, prices[i])
        }

        var peak = prices[n - 1]
        for (i in n - 2 downTo 0) {
            g[i] = maxOf(g[i + 1], peak - prices[i])
            peak = maxOf(peak, prices[i])
        }

        var ans = 0
        for (i in 0 until n) {
            ans = maxOf(ans, f[i] + g[i])
        }

        return ans
    }
}
