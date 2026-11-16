package minimumtotalpriceafterapplyingdiscounts

// Time:  O(nlogn + mlogm)
// Space: O(1)

// sort, greedy
class Solution {
    fun minPrice(prices: IntArray, discounts: IntArray): Double {
        prices.sortDescending()
        discounts.sortDescending()
        var total = prices.sumOf { it.toLong() } * 100
        for (i in 0 until minOf(prices.size, discounts.size)) {
            total -= prices[i].toLong() * discounts[i]
        }
        return total / 100.0
    }
}
