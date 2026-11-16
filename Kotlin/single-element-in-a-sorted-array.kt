package singleelementinasortedarray

// Time:  O(logn)
// Space: O(1)
class Solution {
    fun singleNonDuplicate(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!(mid % 2 == 0 && mid + 1 < nums.size && nums[mid] == nums[mid + 1]) &&
                !(mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return nums[left]
    }
}
