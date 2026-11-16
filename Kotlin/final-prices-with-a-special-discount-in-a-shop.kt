package finalpriceswithaspecialdiscountinashop

// Time:  O(n)
// Space: O(n)

class Solution {
    fun finalPrices(prices: IntArray): IntArray {
        val stk = ArrayDeque<Int>()
        for (i in prices.indices) {
            while (stk.isNotEmpty() && prices[stk.last()] >= prices[i]) {
                prices[stk.last()] -= prices[i]
                stk.removeLast()
            }
            stk.addLast(i)
        }
        return prices
    }
}
