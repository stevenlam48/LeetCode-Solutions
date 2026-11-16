package buytwochocolates

// Time:  O(n)
// Space: O(1)

class Solution {
    fun buyChoco(prices: IntArray, money: Int): Int {
        fun minIndex(exclude: Int): Int {
            var result = -1
            for (i in prices.indices) {
                if (i != exclude && (result == -1 || prices[result] > prices[i])) {
                    result = i
                }
            }
            return result
        }

        val i = minIndex(-1)
        val j = minIndex(i)
        return if (prices[i] + prices[j] <= money) money - (prices[i] + prices[j]) else money
    }
}
