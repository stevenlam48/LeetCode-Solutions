package besttimetobuyandsellstockiv

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxProfit(k: Int, prices: IntArray): Int {
        val profits = ArrayList<Int>()
        val vPStk = ArrayList<Pair<Int, Int>>()
        var v = -1
        var p = -1
        while (p + 1 < prices.size) {
            v = p + 1
            while (v + 1 < prices.size) {
                if (prices[v] < prices[v + 1]) {
                    break
                }
                ++v
            }
            p = v
            while (p + 1 < prices.size) {
                if (prices[p] > prices[p + 1]) {
                    break
                }
                ++p
            }
            while (vPStk.isNotEmpty() && prices[vPStk.last().first] > prices[v]) {
                val (lastV, lastP) = vPStk.removeAt(vPStk.size - 1)
                profits.add(prices[lastP] - prices[lastV])
            }
            while (vPStk.isNotEmpty() && prices[vPStk.last().second] <= prices[p]) {
                val (lastV, lastP) = vPStk.removeAt(vPStk.size - 1)
                profits.add(prices[lastP] - prices[v])
                v = lastV
            }
            vPStk.add(Pair(v, p))
        }
        while (vPStk.isNotEmpty()) {
            val (lastV, lastP) = vPStk.removeAt(vPStk.size - 1)
            profits.add(prices[lastP] - prices[lastV])
        }
        var kk = k
        if (kk > profits.size) {
            kk = profits.size
        } else {
            profits.sortDescending()
        }
        var result = 0
        for (i in 0 until kk) {
            result += profits[i]
        }
        return result
    }
}
