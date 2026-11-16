package maximumsubarraysumaftermultiplier

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxSubarraySum(nums: IntArray, k: Int): Long {
        val negativeInfinity = Long.MIN_VALUE
        val init = 0
        val mult = 1
        val div = 2
        val done = 3

        var result = negativeInfinity
        var dp = LongArray(4) { negativeInfinity }
        for (num in nums) {
            val x = num.toLong()
            dp = longArrayOf(
                maxOf(dp[init], 0L) + x,
                maxOf(dp[mult], dp[init], 0L) + x * k,
                maxOf(dp[div], dp[init], 0L) + x / k,
                maxOf(dp[done], dp[mult], dp[div], 0L) + x
            )
            result = maxOf(result, dp.maxOrNull()!!)
        }
        return result
    }
}
