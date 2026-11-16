package numberofsmoothdescentperiodsofastock

// Time:  O(n)
// Space: O(1)

class Solution {
    fun getDescentPeriods(prices: IntArray): Long {
        var result: Long = 0
        var i: Long = 0
        var l: Long = 0
        val n = prices.size.toLong()
        while (i < n) {
            ++l
            if (i + 1 == n || prices[i.toInt()] - 1 != prices[(i + 1).toInt()]) {
                result += l * (l + 1) / 2
                l = 0
            }
            ++i
        }
        return result
    }
}
