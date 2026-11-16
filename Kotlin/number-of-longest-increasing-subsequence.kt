package numberoflongestincreasingsubsequence
// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun findNumberOfLIS(nums: IntArray): Int {
        var result = 0
        var maxLen = 0
        val dp = Array(nums.size) { intArrayOf(1, 1) }
        for (i in nums.indices) {
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    if (dp[i][0] == dp[j][0] + 1) {
                        dp[i][1] += dp[j][1]
                    } else if (dp[i][0] < dp[j][0] + 1) {
                        dp[i] = intArrayOf(dp[j][0] + 1, dp[j][1])
                    }
                }
            }
            if (maxLen == dp[i][0]) {
                result += dp[i][1]
            } else if (maxLen < dp[i][0]) {
                maxLen = dp[i][0]
                result = dp[i][1]
            }
        }
        return result
    }
}
