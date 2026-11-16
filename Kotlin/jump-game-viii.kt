package jumpgameviii
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minCost(nums: IntArray, costs: IntArray): Long {
        val stk1 = mutableListOf<Int>()
        val stk2 = mutableListOf<Int>()
        val dp = LongArray(nums.size) { Long.MAX_VALUE }
        dp[0] = 0
        for (i in nums.indices) {
            while (stk1.isNotEmpty() && nums[stk1.last()] <= nums[i]) {
                dp[i] = minOf(dp[i], dp[stk1.last()] + costs[i])
                stk1.removeAt(stk1.lastIndex)
            }
            stk1.add(i)
            while (stk2.isNotEmpty() && nums[stk2.last()] > nums[i]) {
                dp[i] = minOf(dp[i], dp[stk2.last()] + costs[i])
                stk2.removeAt(stk2.lastIndex)
            }
            stk2.add(i)
        }
        return dp.last()
    }
}
