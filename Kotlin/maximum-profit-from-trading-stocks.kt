package maximumprofitfromtradingstocks

// Time:  O(n * b)
// Space: O(b)

// dp, optimized from solution2
class Solution {
    fun maximumProfit(present: IntArray, future: IntArray, budget: Int): Int {
        val dp = IntArray(budget + 1)
        for (i in present.indices) {
            if (future[i] - present[i] < 0) {
                continue
            }
            for (b in budget downTo present[i]) {
                dp[b] = maxOf(dp[b], dp[b - present[i]] + (future[i] - present[i]))
            }
        }
        return dp.last()
    }
}
