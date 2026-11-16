package minimumsubarraysinavalidsplit

// Time:  O(n^2 * logr), r = max(nums)
// Space: O(n)

import kotlin.math.min

class Solution {
    fun validSubarraySplit(nums: IntArray): Int {
        val dp = IntArray(nums.size + 1) { Int.MAX_VALUE }
        dp[0] = 0
        for (i in 1..nums.size) {
            for (j in 0 until i) {
                if (gcd(nums[j], nums[i - 1]) != 1 && dp[j] != Int.MAX_VALUE) {
                    dp[i] = min(dp[i], dp[j] + 1)
                }
            }
        }
        return if (dp[nums.size] != Int.MAX_VALUE) dp[nums.size] else -1
    }

    private tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
