package maximumalternatingsubarraysumwithonedeletion

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxAlternatingSum(nums: IntArray): Long {
        val negInf = Long.MIN_VALUE
        var result = negInf
        val dp = Array(2) { LongArray(2) { negInf } }
        for (x in nums) {
            dp[1] = longArrayOf(
                maxOf(if (dp[1][1] != negInf) dp[1][1] + x else negInf, dp[0][0]),
                maxOf(if (dp[1][0] != negInf) dp[1][0] - x else negInf, dp[0][1])
            )
            dp[0] = longArrayOf(
                maxOf(dp[0][1], 0L) + x,
                if (dp[0][0] != negInf) dp[0][0] - x else negInf
            )
            result = maxOf(result, dp[0].max(), dp[1].max())
        }
        return result
    }
}
