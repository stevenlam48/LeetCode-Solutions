package findminimuminrotatedsortedarrayii

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right && nums[left] >= nums[right]) {
            val mid = left + (right - left) / 2
            if (nums[mid] == nums[left]) {
                ++left
            } else if (nums[mid] < nums[left]) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return nums[left]
    }
}
