package predictthewinner

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun predictTheWinner(nums: IntArray): Boolean {
        if (nums.size % 2 == 0 || nums.size == 1) {
            return true
        }

        val dp = IntArray(nums.size)
        for (i in nums.size - 1 downTo 0) {
            dp[i] = nums[i]
            for (j in i + 1 until nums.size) {
                dp[j] = maxOf(nums[i] - dp[j], nums[j] - dp[j - 1])
            }
        }

        return dp[nums.size - 1] >= 0
    }
}
