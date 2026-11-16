package besttimetobuyandsellstockwithtransactionfee

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        var cash = 0
        var hold = -prices[0]
        for (i in 1 until prices.size) {
            cash = kotlin.math.max(cash, hold + prices[i] - fee)
            hold = kotlin.math.max(hold, cash - prices[i])
        }
        return cash
    }
}
