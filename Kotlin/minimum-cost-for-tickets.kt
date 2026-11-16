package minimumcostfortickets

// Time:  O(n)
// Space: O(1)

class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val durations = intArrayOf(1, 7, 30)
        val W = durations.last()
        val INF = Int.MAX_VALUE
        val dp = IntArray(W) { INF }
        dp[0] = 0
        val lastBuyDays = intArrayOf(0, 0, 0)
        for (i in 1..days.size) {
            dp[i % W] = INF
            for (j in durations.indices) {
                while (i - 1 < days.size &&
                    days[i - 1] > days[lastBuyDays[j]] + durations[j] - 1
                ) {
                    ++lastBuyDays[j]
                }
                dp[i % W] = minOf(dp[i % W], dp[lastBuyDays[j] % W] + costs[j])
            }
        }
        return dp[days.size % W]
    }
}
