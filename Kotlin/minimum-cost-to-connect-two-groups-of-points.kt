package minimumcosttoconnecttwogroupsofpoints
// Time:  O(m * n * 2^n)
// Space: O(2^n)

class Solution {
    fun connectTwoGroups(cost: Array<IntArray>): Int {
        val total = 1 shl cost[0].size
        val dp = Array(2) { IntArray(total) { Int.MAX_VALUE } }
        dp[0][0] = 0
        for (i in cost.indices) {
            dp[(i + 1) % 2].fill(Int.MAX_VALUE)
            for (mask in 0 until total) {
                var base = 1
                for (j in cost[0].indices) {
                    if (dp[i % 2][mask] <= Int.MAX_VALUE - cost[i][j]) {
                        dp[i % 2][mask or base] = minOf(dp[i % 2][mask or base], cost[i][j] + dp[i % 2][mask])
                        dp[(i + 1) % 2][mask or base] = minOf(dp[(i + 1) % 2][mask or base], cost[i][j] + dp[i % 2][mask])
                    }
                    base = base shl 1
                }
            }
        }
        return dp[cost.size % 2].last()
    }
}
