package besttimetobuyandsellstock

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }

        var hold1 = Int.MIN_VALUE
        var release1 = Int.MIN_VALUE

        for (p in prices) {
            hold1 = maxOf(hold1, -p)
            release1 = maxOf(release1, hold1 + p)
        }

        return release1
    }
}
