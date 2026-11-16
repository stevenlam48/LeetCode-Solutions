package checkifanumberismajorityelementinasortedarray

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun isMajorityElement(nums: IntArray, target: Int): Boolean {
        if (nums.size % 2 != 0) {
            if (nums[nums.size / 2] != target) {
                return false
            }
        } else {
            if (nums[nums.size / 2 - 1] != nums[nums.size / 2] ||
                nums[nums.size / 2] != target
            ) {
                return false
            }
        }
        val left = bound(nums, target, false)
        val right = bound(nums, target, true)
        return (right - left) * 2 > nums.size
    }

    private fun bound(nums: IntArray, target: Int, upper: Boolean): Int {
        var left = 0
        var right = nums.size
        while (left < right) {
            val middle = left + (right - left) / 2
            if (nums[middle] < target || (upper && nums[middle] == target)) {
                left = middle + 1
            } else {
                right = middle
            }
        }
        return left
    }
}
