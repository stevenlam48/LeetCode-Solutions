package longestsubsequencewithdecreasingadjacentdifference
// Time:  O(r^2 + n * r), r = max(nums)
// Space: O(r^2)

import kotlin.math.abs

class Solution {
    fun longestSubsequence(nums: IntArray): Int {
        var result = 2
        val maximum = nums.max()
        val dp = Array(maximum) { IntArray(maximum) }
        for (value in nums) {
            val x = value - 1
            for (next in dp[x].indices) {
                val difference = abs(next - x)
                dp[x][difference] = maxOf(dp[x][difference], dp[next][difference] + 1)
            }
            for (difference in dp[x].size - 2 downTo 0) {
                dp[x][difference] = maxOf(dp[x][difference], dp[x][difference + 1])
            }
            result = maxOf(result, dp[x][0])
        }
        return result
    }
}
