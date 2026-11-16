package houserobberv
// Time:  O(n)
// Space: O(1)

class Solution {
    fun rob(nums: IntArray, colors: IntArray): Long {
        val dp = LongArray(2)
        for (i in nums.indices) {
            dp[i % 2] = if (i - 1 >= 0 && colors[i - 1] == colors[i]) {
                maxOf(
                    dp[((i - 2) % 2 + 2) % 2] + nums[i],
                    dp[((i - 1) % 2 + 2) % 2]
                )
            } else {
                dp[((i - 1) % 2 + 2) % 2] + nums[i]
            }
        }
        return dp[(nums.size - 1) % 2]
    }
}
