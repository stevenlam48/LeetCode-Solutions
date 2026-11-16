package mincostclimbingstairs

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = IntArray(3)
        for (i in cost.size - 1 downTo 0) {
            dp[i % 3] = cost[i] + minOf(dp[(i + 1) % 3], dp[(i + 2) % 3])
        }
        return minOf(dp[0], dp[1])
    }
}
