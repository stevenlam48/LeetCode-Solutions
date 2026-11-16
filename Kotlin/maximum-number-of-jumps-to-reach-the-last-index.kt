package maximumnumberofjumpstoreachthelastindex
// Time:  O(n^2)
// Space: O(n)

import kotlin.math.abs

class Solution {
    fun maximumJumps(nums: IntArray, target: Int): Int {
        val dp = IntArray(nums.size) { -1 }
        dp[0] = 0
        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                if (abs(nums[i] - nums[j]) <= target) {
                    if (dp[j] != -1) {
                        dp[i] = maxOf(dp[i], dp[j] + 1)
                    }
                }
            }
        }
        return dp.last()
    }
}
