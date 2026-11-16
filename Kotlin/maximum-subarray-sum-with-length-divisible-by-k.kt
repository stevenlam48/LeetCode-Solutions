package maximumsubarraysumwithlengthdivisiblebyk
// Time:  O(n)
// Space: O(k)

class Solution {
    fun maxSubarraySum(nums: IntArray, k: Int): Long {
        val dp = LongArray(k) { Long.MAX_VALUE }
        dp[k - 1] = 0
        var result = Long.MIN_VALUE
        var curr = 0L
        for (i in nums.indices) {
            curr += nums[i]
            val index = i % k
            if (dp[index] != Long.MAX_VALUE) {
                result = maxOf(result, curr - dp[index])
            }
            dp[index] = minOf(dp[index], curr)
        }
        return result
    }
}
