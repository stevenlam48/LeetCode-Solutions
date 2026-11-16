package minimumincreasetomaximizespecialindices
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minIncrease(nums: IntArray): Long {
        var dp = 0L
        if (nums.size % 2 != 0) {
            for (i in 1 until (nums.size - 1) step 2) {
                dp += maxOf(maxOf(nums[i - 1], nums[i + 1]) + 1 - nums[i], 0)
            }
            return dp
        }
        var dp2 = 0L
        for (i in 1 until (nums.size - 1) step 2) {
            dp += maxOf(maxOf(nums[i - 1], nums[i + 1]) + 1 - nums[i], 0)
            dp2 += maxOf(maxOf(nums[i], nums[i + 2]) + 1 - nums[i + 1], 0)
            dp2 = minOf(dp2, dp)
        }
        return dp2
    }
}
