package minimumsumafterdivisiblesumdeletions

// Time:  O(n + k)
// Space: O(k)

import kotlin.math.min

class Solution {
    fun minArraySum(nums: IntArray, k: Int): Long {
        val dp = LongArray(k) { Long.MAX_VALUE }
        dp[0] = 0
        var result = 0L
        for (x in nums) {
            result += x.toLong()
            val remainder = (result % k).toInt()
            result = min(result, dp[remainder])
            dp[remainder] = result
        }
        return result
    }
}
