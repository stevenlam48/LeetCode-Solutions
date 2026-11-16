package countpartitionswithevensumdifference

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countPartitions(nums: IntArray): Int {
        var result = 0
        var left = 0
        var right = nums.sum()
        for (i in 0 until nums.size - 1) {
            right -= nums[i]
            left += nums[i]
            if (left % 2 == right % 2) {
                ++result
            }
        }
        return result
    }
}
