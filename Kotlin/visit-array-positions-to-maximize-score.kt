package visitarraypositionstomaximizescore
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxScore(nums: IntArray, x: Int): Long {
        val min = Long.MIN_VALUE
        val dp = longArrayOf(min, min)
        dp[nums[0] % 2] = nums[0].toLong()
        for (i in 1 until nums.size) {
            val parity = nums[i] % 2
            val other = (nums[i] + 1) % 2
            dp[parity] = maxOf(dp[parity], if (dp[other] != min) dp[other] - x else min) + nums[i]
        }
        return maxOf(dp[0], dp[1])
    }
}
